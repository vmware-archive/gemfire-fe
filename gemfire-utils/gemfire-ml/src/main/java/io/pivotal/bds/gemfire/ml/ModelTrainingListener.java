package io.pivotal.bds.gemfire.ml;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

public class ModelTrainingListener extends CacheListenerAdapter<String, TrainingParameters> {

	private ModelManager models;
	private ModelFactoryManager factories;

	private static final Logger LOG = LoggerFactory.getLogger(ModelTrainingListener.class);

	public ModelTrainingListener(ModelManager models, ModelFactoryManager factories) {
		this.models = models;
		this.factories = factories;
	}

	@Override
	public void afterCreate(EntryEvent<String, TrainingParameters> event) {
		TrainingParameters params = event.getNewValue();
		LOG.debug("afterCreate: params={}", params);
		Model m = create(params);
		models.createModel(m);
	}

	@Override
	public void afterDestroy(EntryEvent<String, TrainingParameters> event) {
		String modelName = event.getNewValue().getModelName();
		LOG.debug("afterDestroy: modelName={}", modelName);
		models.deleteModel(modelName);
	}

	@Override
	public void afterUpdate(EntryEvent<String, TrainingParameters> event) {
		TrainingParameters params = event.getNewValue();
		LOG.debug("afterUpdate: params={}", params);
		Model m = create(params);
		models.updateModel(m);
	}

	private Model create(TrainingParameters params) {
		ModelFactory factory = factories.getFactory(params.getType());
		String name = params.getModelName();
		String attr = params.getAttributeName();
		Properties props = params.getProperties();
		Model model = factory.create(name, attr, props);
		model.train(params.getX(), params.getY());
		return model;
	}
}
