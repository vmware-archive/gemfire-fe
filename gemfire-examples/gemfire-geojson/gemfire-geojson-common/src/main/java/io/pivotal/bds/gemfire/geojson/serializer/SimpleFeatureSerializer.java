package io.pivotal.bds.gemfire.geojson.serializer;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.geode.DataSerializer;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vividsolutions.jts.geom.Geometry;

public class SimpleFeatureSerializer extends DataSerializer {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleFeatureSerializer.class);

    public SimpleFeatureSerializer() {
    }

    @Override
    public Class<?>[] getSupportedClasses() {
        return new Class[] { SimpleFeature.class };
    }

    @Override
    public boolean toData(Object o, DataOutput out) throws IOException {
        Class<?> c = o.getClass();

        if (c.isInstance(o)) {
            LOG.debug("toData: supported: o={}", o);
            SimpleFeature sf = (SimpleFeature) o;

            String id = sf.getID();
            String ft = sf.getFeatureType().getTypeName();
            Geometry geom = (Geometry) sf.getDefaultGeometry();

            writeString(id, out);
            writeString(ft, out);
            writeObject(geom, out);

            return true;
        }

        LOG.debug("toData: not supported: class={}", c.getName());
        return false;
    }

    @Override
    public Object fromData(DataInput in) throws IOException, ClassNotFoundException {
        String id = readString(in);
        String ft = readString(in);
        Geometry geom = (Geometry) readObject(in);
        LOG.debug("fromData: id={}, ft={}, geom={}", id, ft, geom);

        SimpleFeatureTypeBuilder sftb = new SimpleFeatureTypeBuilder();
        sftb.add("geometry", Geometry.class);
        sftb.setName(ft);

        SimpleFeatureType sft = sftb.buildFeatureType();

        SimpleFeatureBuilder sfb = new SimpleFeatureBuilder(sft);
        sfb.add(geom);

        SimpleFeature sf = sfb.buildFeature(id);
        return sf;
    }

    @Override
    public int getId() {
        return 1001;
    }

}
