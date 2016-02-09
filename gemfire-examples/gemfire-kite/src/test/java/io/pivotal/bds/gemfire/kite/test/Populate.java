package io.pivotal.bds.gemfire.kite.test;

import java.io.File;
import java.util.Calendar;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.kitesdk.data.CompressionType;
import org.kitesdk.data.Dataset;
import org.kitesdk.data.DatasetDescriptor;
import org.kitesdk.data.DatasetNotFoundException;
import org.kitesdk.data.DatasetWriter;
import org.kitesdk.data.Datasets;
import org.kitesdk.data.Formats;

public class Populate {

	private static final String URI = "dataset:hdfs://localhost:8020/datasets/default/test";

	public static void main(String[] args) throws Exception {
		Schema schema = new Schema.Parser().parse(new File("src/test/resources/schema.avsc"));
		Dataset<GenericRecord> ds = null;

		try {
			ds = Datasets.load(URI);
		} catch (DatasetNotFoundException x) {
			DatasetDescriptor desc = new DatasetDescriptor.Builder().format(Formats.PARQUET).schema(schema)
					.location("hdfs://localhost:8020/datasets/default/test")
					.compressionType(CompressionType.Uncompressed).build();
			ds = Datasets.create(URI, desc);
		}
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		DatasetWriter<GenericRecord> writer = ds.newWriter();

		try {

			for (int i = 0; i < 1000; ++i) {
				long t = cal.getTimeInMillis();
				cal.add(Calendar.MINUTE, 1);
				
				GenericRecord rec = new GenericData.Record(schema);

				rec.put("id", "id-" + i);
				rec.put("ts", t);
				rec.put("desc", "description-" + i);

				writer.write(rec);
			}
		} finally {
			writer.close();
		}
	}
}
