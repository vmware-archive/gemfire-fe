package io.pivotal.bds.gemfire.spring.boot.conf;

import java.util.Properties;

import com.gemstone.gemfire.LogWriter;
import com.gemstone.gemfire.distributed.DistributedMember;
import com.gemstone.gemfire.security.AuthInitialize;
import com.gemstone.gemfire.security.AuthenticationFailedException;

public class AuthInitializeImpl implements AuthInitialize {

    public static String username;
    public static String password;

    public static AuthInitialize create() {
        return new AuthInitializeImpl();
    }

    @Override
    public void close() {
    }

    @Override
    public Properties getCredentials(Properties props, DistributedMember member, boolean isPeer)
            throws AuthenticationFailedException {
        Properties p = new Properties();
        p.setProperty("security-username", username);
        p.setProperty("security-password", password);
        return p;
    }

    @Override
    public void init(LogWriter systemLogger, LogWriter securityLogger) throws AuthenticationFailedException {
    }

}
