package io.pivotal.bds.gemfire.key;

public class BaseColocationKey<T, C> extends BaseKey<T> implements ColocationID<C> {

	private C colocationId;

	public BaseColocationKey() {
	}

	public BaseColocationKey(T id, C colocationId) {
		super(id);
		this.colocationId = colocationId;
	}

	public C getColocationId() {
		return colocationId;
	}

	public void setColocationId(C colocationId) {
		this.colocationId = colocationId;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [id=" + getId() + ", colocationId=" + colocationId + "]";
	}
}
