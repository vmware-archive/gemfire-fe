package io.pivotal.bds.gemfire.mongodb.util;

import java.util.Map;

import org.bson.Document;
import org.dozer.CustomConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.CacheFactory;
import org.apache.geode.pdx.PdxInstance;
import org.apache.geode.pdx.PdxInstanceFactory;

public class DozerPdxInstanceConverter implements CustomConverter {

    private static final Logger LOG = LoggerFactory.getLogger(DozerPdxInstanceConverter.class);

    @Override
    public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass,
            Class<?> sourceClass) {

        LOG.debug("convert: existingDestinationFieldValue={}, sourceFieldValue={}, destinationClass={}, sourceClass={}",
                existingDestinationFieldValue, sourceFieldValue, destinationClass, sourceClass);

        if (PdxInstance.class.isAssignableFrom(sourceClass) && Document.class.isAssignableFrom(destinationClass)) {
            PdxInstance inst = (PdxInstance) sourceFieldValue;
            String className = inst.getClassName();

            Document doc = new Document();
            doc.put("_className", className);

            for (String fn : inst.getFieldNames()) {
                Object sfv = inst.getField(fn);

                if (sfv != null) {
                    Object dfv = null;

                    if (PdxInstance.class.isInstance(sfv)) {
                        dfv = convert(null, sfv, Document.class, PdxInstance.class);
                    } else {
                        dfv = sfv;
                    }

                    doc.put(fn, dfv);
                }
            }

            LOG.debug("convert: inst={}, doc={}", inst, doc);
            return doc;
        } else if (Document.class.isAssignableFrom(sourceClass) && PdxInstance.class.isAssignableFrom(destinationClass)) {
            Document doc = (Document) sourceFieldValue;
            String className = doc.getString("_className");

            if (className == null || className.trim().length() == 0) {
                throw new IllegalArgumentException("Missing field 'className'");
            }

            PdxInstanceFactory pif = CacheFactory.getAnyInstance().createPdxInstanceFactory(className);

            for (Map.Entry<String, Object> entry : doc.entrySet()) {
                String fn = entry.getKey();
                Object sfv = entry.getValue();

                if (sfv != null) {
                    Object dfv = null;

                    if (Document.class.isInstance(sfv)) {
                        dfv = convert(null, sfv, PdxInstance.class, Document.class);
                    } else {
                        dfv = sfv;
                    }

                    pif.writeObject(fn, dfv);
                }
            }

            PdxInstance inst = pif.create();
            LOG.debug("convert: doc={}, inst={}", doc, inst);
            return inst;
        }

        throw new IllegalArgumentException("Cannot map from " + sourceClass.getName() + " to " + destinationClass.getName());
    }

}
