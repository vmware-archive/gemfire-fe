package io.pivotal.bds.gemfire.key;

public abstract class BaseKey<T> {

	private T id;

	public BaseKey() {
	}

	public BaseKey(T id) {
		this.id = id;
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		BaseKey<T> other = (BaseKey<T>) obj;
		return id.equals(other.id);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [id=" + id + "]";
	}

}
