package io.pivotal.bds.gemfire.util;

import org.apache.geode.DataSerializer;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Date;

public class ReflectionBasedDataSerializer extends DataSerializer {

    private int id;
    private Class<?> clazz;

    public ReflectionBasedDataSerializer(int id, Class<?> clazz) {
        this.id = id;
        this.clazz = clazz;
    }

    @Override
    public Class<?>[] getSupportedClasses() {
        return new Class<?>[]{clazz};
    }

    @Override
    public boolean toData(Object o, DataOutput dataOutput) throws IOException {
        Class<?> c = o.getClass();
        toData(c, o, dataOutput);
        return true;
    }

    @Override
    public Object fromData(DataInput dataInput) throws IOException, ClassNotFoundException {
        try {
            Object o = clazz.newInstance();
            fromData(clazz, o, dataInput);
            return o;
        } catch (IOException x) {
            throw x;
        } catch (ClassNotFoundException x) {
            throw x;
        } catch (Exception x) {
            throw new IOException(x.toString(), x);
        }
    }

    @Override
    public int getId() {
        return id;
    }

    private void fromData(Class<?> c, Object o, DataInput dataInput) throws IOException, ClassNotFoundException {
        try {
            Field[] fields = c.getDeclaredFields();

            for (Field field : fields) {
                int modifiers = field.getModifiers();

                if (!(Modifier.isStatic(modifiers) && Modifier.isTransient(modifiers))) {
                    Class<?> t = field.getType();
                    field.setAccessible(true);

                    if (t == String.class) {
                        field.set(o, readString(dataInput));
                    } else if (t == Integer.class) {
                        field.set(o, readInteger(dataInput));
                    } else if (t == int.class) {
                        field.set(o, readPrimitiveInt(dataInput));
                    } else if (t == Long.class) {
                        field.set(o, readLong(dataInput));
                    } else if (t == long.class) {
                        field.set(o, readPrimitiveLong(dataInput));
                    } else if (t == Double.class) {
                        field.set(o, readDouble(dataInput));
                    } else if (t == double.class) {
                        field.set(o, readPrimitiveDouble(dataInput));
                    } else if (t == Date.class) {
                        field.set(o, readDate(dataInput));
                    } else if (t == Boolean.class) {
                        field.set(o, readBoolean(dataInput));
                    } else if (t == boolean.class) {
                        field.set(o, readPrimitiveBoolean(dataInput));
                    } else if (t == Short.class) {
                        field.set(o, readShort(dataInput));
                    } else if (t == short.class) {
                        field.set(o, readPrimitiveShort(dataInput));
                    } else {
                        field.set(o, readObject(dataInput));
                    }
                }
            }
        } catch (IOException x) {
            throw x;
        } catch (Exception x) {
            throw new IOException(x.toString(), x);
        }

        c = c.getSuperclass();

        if (c != null && c != Object.class) {
            fromData(c, o, dataInput);
        }
    }

    private void toData(Class<?> c, Object o, DataOutput dataOutput) throws IOException {
        try {
            Field[] fields = c.getDeclaredFields();

            for (Field field : fields) {
                int modifiers = field.getModifiers();

                if (!(Modifier.isStatic(modifiers) && Modifier.isTransient(modifiers))) {
                    Class<?> t = field.getType();
                    field.setAccessible(true);

                    if (t == String.class) {
                        writeString((String) field.get(o), dataOutput);
                    } else if (t == Integer.class) {
                        writeInteger((Integer) field.get(o), dataOutput);
                    } else if (t == int.class) {
                        writePrimitiveInt((Integer) field.get(o), dataOutput);
                    } else if (t == Long.class) {
                        writeLong((Long) field.get(o), dataOutput);
                    } else if (t == long.class) {
                        writePrimitiveLong((Long) field.get(o), dataOutput);
                    } else if (t == Double.class) {
                        writeDouble((Double) field.get(o), dataOutput);
                    } else if (t == double.class) {
                        writePrimitiveDouble((Double) field.get(o), dataOutput);
                    } else if (t == Date.class) {
                        writeDate((Date) field.get(o), dataOutput);
                    } else if (t == Boolean.class) {
                        writeBoolean((Boolean) field.get(o), dataOutput);
                    } else if (t == boolean.class) {
                        writePrimitiveBoolean((Boolean) field.get(o), dataOutput);
                    } else if (t == Short.class) {
                        writeShort((Short) field.get(o), dataOutput);
                    } else if (t == short.class) {
                        writePrimitiveShort((Short) field.get(o), dataOutput);
                    } else {
                        writeObject(field.get(o), dataOutput);
                    }
                }
            }
        } catch (IOException x) {
            throw x;
        } catch (Exception x) {
            throw new IOException(x.toString(), x);
        }

        c = c.getSuperclass();

        if (c != null && c != Object.class) {
            toData(c, o, dataOutput);
        }
    }
}
