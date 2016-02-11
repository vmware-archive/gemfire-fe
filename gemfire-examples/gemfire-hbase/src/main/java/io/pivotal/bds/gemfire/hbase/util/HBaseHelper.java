package io.pivotal.bds.gemfire.hbase.util;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableExistsException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.pdx.PdxInstance;
import com.gemstone.gemfire.pdx.internal.PdxInputStream;
import com.gemstone.gemfire.pdx.internal.PdxOutputStream;

public class HBaseHelper {

    private static byte[] family;
    private static byte[] qualifier;

    private static Connection connection;
    private static final Map<String, Table> tables = new HashMap<>();
    private static final Logger LOG = LoggerFactory.getLogger(HBaseHelper.class);

    static {
        try {
            String sfam = System.getProperty("hbase.family", "gemfire");
            family = sfam.getBytes("UTF-8");

            String squal = System.getProperty("hbase.qualifier", sfam);
            qualifier = squal.getBytes("UTF-8");
        } catch (Exception x) {
            x.printStackTrace(); // very unlikely
        }
    }

    @SuppressWarnings("unchecked")
    public static <V> List<V> scan(byte[] start, byte[] end, String tableName) throws Exception {
        Table table = getTable(tableName);
        Scan scan = new Scan(start, end);
        ResultScanner scanner = table.getScanner(scan);
        Result result = null;

        List<V> list = new ArrayList<>();

        while ((result = scanner.next()) != null) {
            if (!result.isEmpty()) {
                Cell cell = result.getColumnLatestCell(family, qualifier);
                if (cell != null) {
                    byte[] b = CellUtil.cloneValue(cell);

                    PdxInputStream is = new PdxInputStream(b);

                    try {
                        V v = (V) is.readObject();
                        list.add(v);
                    } finally {
                        is.close();
                    }
                }
            }
        }

        return list;
    }

    @SuppressWarnings("unchecked")
    public static <V> V retrieve(Object key, String tableName) throws Exception {
        LOG.debug("retrieve: key={}, tableName={}", key, tableName);

        byte[] bk = serialize(key);
        byte[] bv = retrieve(bk, tableName);

        if (bv == null) {
            return null;
        }

        PdxInputStream is = new PdxInputStream(bv);

        try {
            return (V) is.readObject();
        } finally {
            is.close();
        }
    }

    public static byte[] retrieve(byte[] key, String tableName) throws Exception {
        Table table = getTable(tableName);

        Get get = new Get(key);
        Result result = table.get(get);

        if (result.isEmpty()) {
            return null;
        }

        Cell cell = result.getColumnLatestCell(family, qualifier);

        if (cell == null) {
            return null;
        }

        return CellUtil.cloneValue(cell);
    }

    public static Put createPut(Object key, Object value) {
        byte[] bk = serialize(key);
        byte[] bv = serialize(value);
        return createPut(bk, bv);
    }

    public static Put createPut(byte[] key, byte[] value) {
        Put put = new Put(key);
        put.addColumn(family, qualifier, value);
        return put;
    }

    public static Delete createDelete(Object key) {
        byte[] bk = serialize(key);
        return createDelete(bk);
    }

    public static Delete createDelete(byte[] key) {
        Delete del = new Delete(key);
        return del;
    }

    public static void store(List<Put> puts, String tableName) throws Exception {
        Table table = getTable(tableName);
        table.put(puts);
    }

    public static void delete(List<Delete> dels, String tableName) throws Exception {
        Table table = getTable(tableName);
        table.delete(dels);
    }

    public static void store(Object key, Object value, String tableName) throws Exception {
        byte[] bv = serialize(value);
        store(key, bv, tableName);
    }

    public static void store(Object key, byte[] value, String tableName) throws Exception {
        byte[] bk = serialize(key);
        store(bk, value, tableName);
    }

    public static void store(byte[] key, byte[] value, String tableName) throws Exception {
        Table table = getTable(tableName);
        Put put = createPut(key, value);
        table.put(put);
    }

    public static void delete(Object key, String tableName) throws Exception {
        byte[] bk = serialize(key);
        delete(bk, tableName);
    }

    public static void delete(byte[] key, String tableName) throws Exception {
        Table table = getTable(tableName);
        Delete del = createDelete(key);
        table.delete(del);
    }

    private static Object getIdentityFieldValue(PdxInstance pi) {
        for (String f : pi.getFieldNames()) {
            if (pi.isIdentityField(f)) {
                return pi.getField(f);
            }
        }

        return null;
    }

    public static byte[] serialize(Object o) {
        if (o instanceof byte[]) {
            return (byte[]) o;
        } else if (o instanceof PdxInstance) {
            PdxInstance pi = (PdxInstance) o;
            Object id = getIdentityFieldValue(pi);

            if (id == null) {
                PdxOutputStream pos = new PdxOutputStream();
                pos.writeObject(o, false);
                return pos.toByteArray();
            } else {
                return serialize(id);
            }
        } else {
            Class<?> c = o.getClass();

            if (c == String.class) {
                String s = (String) o;
                try {
                    return s.getBytes("UTF-8");
                } catch (Exception x) {
                    throw new IllegalArgumentException(x.toString(), x);
                }
            } else if (c == Integer.class || c == int.class) {
                Integer i = (Integer) o;
                ByteBuffer buf = ByteBuffer.allocate(4);
                buf.putInt(i);
                return buf.array();
            } else if (c == Long.class || c == long.class) {
                Long l = (Long) o;
                ByteBuffer buf = ByteBuffer.allocate(8);
                buf.putLong(l);
                return buf.array();
            } else if (c == Double.class || c == double.class) {
                Double d = (Double) o;
                ByteBuffer buf = ByteBuffer.allocate(8);
                buf.putDouble(d);
                return buf.array();
            } else {
                throw new IllegalArgumentException("Cannot serialize type: " + c.getName());
            }
        }
    }

    public static synchronized Table getTable(String name) throws Exception {
        Table t = tables.get(name);

        if (t == null) {
            TableName tn = TableName.valueOf(name);

            try {
                HTableDescriptor desc = new HTableDescriptor(tn);
                HColumnDescriptor col = new HColumnDescriptor("gemfire");
                desc.addFamily(col);
                getConnection().getAdmin().createTable(desc);
                LOG.debug("getTable: created table {}", name);
            } catch (TableExistsException x) {
                LOG.debug("getTable: table {} already exists", name);
            }

            t = getConnection().getTable(tn);
            tables.put(name, t);
        }

        return t;
    }

    private static synchronized Connection getConnection() throws Exception {
        if (connection == null) {
            connection = ConnectionFactory.createConnection();
        }

        return connection;
    }
}
