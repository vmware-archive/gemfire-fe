package io.pivotal.bds.gemfire.kite.test;

import java.io.File;

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

public class Populate2 {

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
		
		DatasetWriter<GenericRecord> writer = ds.newWriter();

		try {

			for (int i = 0; i < 1000; ++i) {
				GenericRecord rec = new GenericData.Record(schema);

				rec.put("id", "id-" + i);
				rec.put("ts", i);
				rec.put("desc", "description-" + i);

				writer.write(rec);
			}
		} finally {
			writer.close();
		}
	}
}
