package io.pivotal.bds.gemfire.security;

import java.io.Serializable;
import java.security.Principal;

public class UsernamePrincipal implements Principal, Serializable {

	private final String userName;

	private static final long serialVersionUID = 1L;

	public UsernamePrincipal(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return this.userName;
	}

	@Override
	public String toString() {
		return this.userName;
	}

}
