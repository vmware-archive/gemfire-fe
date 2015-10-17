package io.pivotal.bds.gemfire.complexobjs.common;

public class Video extends BaseObject {

	public Video() {
	}

	public Video(String id, byte[] data, String mimeType) {
		super(id, data, mimeType);
	}

}
