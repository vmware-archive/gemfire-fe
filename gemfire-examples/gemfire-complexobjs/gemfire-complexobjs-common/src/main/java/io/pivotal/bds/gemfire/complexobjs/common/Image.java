package io.pivotal.bds.gemfire.complexobjs.common;

public class Image extends BaseObject {

	public Image() {
	}

	public Image(String id, byte[] data, String mimeType) {
		super(id, data, mimeType);
	}

}
