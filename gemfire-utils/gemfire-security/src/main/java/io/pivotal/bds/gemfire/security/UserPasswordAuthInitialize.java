package io.pivotal.bds.gemfire.security;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.geode.LogWriter;
import org.apache.geode.distributed.DistributedMember;
import org.apache.geode.security.AuthInitialize;
import org.apache.geode.security.AuthenticationFailedException;

public class UserPasswordAuthInitialize implements AuthInitialize {

	public static final String USER_NAME = "security-username";
	public static final String PASSWORD = "security-password";

	private static final Logger LOG = LogManager.getLogger(UserPasswordAuthInitialize.class);

	public static AuthInitialize create() {
		LOG.info("UserPasswordAuthInitialize.create");
		return new UserPasswordAuthInitialize();
	}

	public UserPasswordAuthInitialize() {
		LOG.info("UserPasswordAuthInitialize.constructor");
	}

	@Override
	public Properties getCredentials(Properties securityProps, DistributedMember server, boolean isPeer)
			throws AuthenticationFailedException {

		LOG.info("UserPasswordAuthInitialize.getCredentials: securityProps={}", securityProps);

		Properties newProps = new Properties();

		String userName = securityProps.getProperty(USER_NAME);

		if (userName == null) {
			throw new AuthenticationFailedException(
					"UserPasswordAuthInit: user name property [" + USER_NAME + "] not set.");
		}

		String passwd = securityProps.getProperty(PASSWORD);

		if (passwd == null) {
			passwd = "";
		}

		newProps.setProperty(USER_NAME, userName);
		newProps.setProperty(PASSWORD, passwd);

		LOG.info("UserPasswordAuthInitialize.getCredentials: newProps={}", newProps);
		return newProps;
	}

	@Override
	public void init(LogWriter systemLogger, LogWriter securityLogger) throws AuthenticationFailedException {
		LOG.info("UserPasswordAuthInitialize.init");
	}

	@Override
	public void close() {
	}
}
