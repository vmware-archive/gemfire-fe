package io.pivotal.bds.gemfire.complexobjs.common;

public abstract class BaseObject {

	private String id;
	private byte[] data;
	private String mimeType;

	public BaseObject() {
	}

	public BaseObject(String id, byte[] data, String mimeType) {
		this.id = id;
		this.data = data;
		this.mimeType = mimeType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [id=" + id + ", data.length=" + data.length + ", mimeType=" + mimeType
				+ "]";
	}

}
