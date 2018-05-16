package io.pivotal.bds.gemfire.security;

import org.apache.geode.security.AuthenticationFailedException;
import org.apache.geode.security.ResourcePermission;
import org.apache.geode.security.SecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

import java.net.URI;
import java.util.Properties;

public class VaultSecurityManager implements SecurityManager {

    private VaultTemplate vaultTemplate;
    private String readPath = "secret/";

    private static final Logger LOG = LoggerFactory.getLogger(VaultSecurityManager.class);

    public VaultSecurityManager() {
    }

    public VaultSecurityManager(VaultTemplate vaultTemplate, String readPath) {
        this.vaultTemplate = vaultTemplate;
        this.readPath = readPath;
    }

    @Override
    public Object authenticate(Properties properties) throws AuthenticationFailedException {
        String username = properties.getProperty("security-username");
        Assert.hasText(username, "Missing username");
        LOG.info("authenticate: username={}", username);

        String password = properties.getProperty("security-password");
        Assert.hasText(password, "Missing password");
        LOG.trace("authenticate: username={}, password={}", username, password);

        VaultResponse vaultResponse = vaultTemplate.read(readPath + username);

        if (vaultResponse == null) {
            throw new AuthenticationFailedException(username);
        }

        String actualPassword = (String) vaultResponse.getData().get("password");
        LOG.trace("authenticate: username={}, password={}, actualPassword={}", username, password, actualPassword);

        if (!password.equals(actualPassword)) {
            throw new AuthenticationFailedException(username);
        }

        return new UsernamePrincipal(username);
    }

    @Override
    public void init(Properties securityProps) {
        String token = securityProps.getProperty("security-token");
        Assert.hasText(token, "Missing security token");

        String uri = securityProps.getProperty("security-uri", "http://localhost:8200");
        readPath = securityProps.getProperty("read-path", readPath);
        LOG.info("init: token={}, readPath={}, uri={}", token, readPath, uri);

        VaultEndpoint ve = VaultEndpoint.from(URI.create(uri));
        TokenAuthentication auth = new TokenAuthentication(token);

        vaultTemplate = new VaultTemplate(ve, auth);
    }

    @Override
    public boolean authorize(Object principal, ResourcePermission permission) {
        return true;
    }

    @Override
    public void close() {
    }
}
