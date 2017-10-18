package io.pivotal.bds.gemfire.security;

import java.security.Principal;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.geode.LogWriter;
import org.apache.geode.distributed.DistributedMember;
import org.apache.geode.security.AuthenticationFailedException;
import org.apache.geode.security.Authenticator;

public class LdapAuthenticator implements Authenticator {

	public static final String LDAP_SERVER_NAME = "security-ldap-server";
	public static final String LDAP_BASEDN_NAME = "security-ldap-basedn";

	private String ldapServer = null;
	private String basedn = null;

	private static final Logger LOG = LogManager.getLogger(LdapAuthenticator.class);

	public static Authenticator create() {
		LOG.info("LdapAuthenticator.create");
		return new LdapAuthenticator();
	}

	public LdapAuthenticator() {
		LOG.info("LdapAuthenticator.constructor");
	}

	@Override
	public Principal authenticate(Properties props, DistributedMember member) throws AuthenticationFailedException {
		LOG.info("LdapAuthenticator.authenticate: props={}", props);

		String userName = props.getProperty(UserPasswordAuthInitialize.USER_NAME);

		if (userName == null) {
			throw new AuthenticationFailedException("LdapAuthenticator: user name property ["
					+ UserPasswordAuthInitialize.USER_NAME + "] not provided");
		}

		String passwd = props.getProperty(UserPasswordAuthInitialize.PASSWORD);

		if (passwd == null) {
			passwd = "";
		}

		String bindDn = "uid=" + userName + "," + this.basedn;
		LOG.info("LdapAuthenticator.authenticate: bindDn={}", bindDn);

		Properties env = new Properties();

		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://" + this.ldapServer + '/' + this.basedn);
		env.put(Context.SECURITY_PRINCIPAL, bindDn);
		env.put(Context.SECURITY_CREDENTIALS, passwd);

		LOG.info("LdapAuthenticator.authenticate: env={}", env);

		try {
			LOG.info("LdapAuthenticator.authenticate: creating context");
			DirContext ctx = new InitialDirContext(env);

			LOG.info("LdapAuthenticator.authenticate: closing context");
			ctx.close();
		} catch (Exception e) {
			LOG.error(e.toString(), e);
			throw new AuthenticationFailedException("LdapAuthenticator: Failure with provided username, password "
					+ "combination for user name: " + userName);
		}

		Principal p = new UsernamePrincipal(userName);

		LOG.info("LdapAuthenticator.authenticate: returning principal: {}", p);
		return p;
	}

	@Override
	public void init(Properties securityProps, LogWriter systemLogger, LogWriter securityLogger)
			throws AuthenticationFailedException {
		LOG.info("LdapAuthenticator.init: securityProps={}", securityProps);

		this.ldapServer = securityProps.getProperty(LDAP_SERVER_NAME);

		if (this.ldapServer == null || this.ldapServer.length() == 0) {
			throw new AuthenticationFailedException(
					"LdapUserAuthenticator: LDAP server property [" + LDAP_SERVER_NAME + "] not specified");
		}

		this.basedn = securityProps.getProperty(LDAP_BASEDN_NAME);

		if (this.basedn == null || this.basedn.length() == 0) {
			throw new AuthenticationFailedException(
					"LdapUserAuthenticator: LDAP base DN property [" + LDAP_BASEDN_NAME + "] not specified");
		}
	}

	@Override
	public void close() {
	}
}
