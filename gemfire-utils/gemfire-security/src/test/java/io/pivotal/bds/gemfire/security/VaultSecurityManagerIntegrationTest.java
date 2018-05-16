package io.pivotal.bds.gemfire.security;

import org.apache.geode.security.AuthenticationFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;

import java.net.URI;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

/**
 * This test uses the dev vault server on localhost.  Replace the token below with the token created when the server is started.  A KV engine must be
 * created at kv/ using vault secrets enable -path=kv kv and create a secret using vault write kv/some-user password=some-password.
 */
class VaultSecurityManagerIntegrationTest {

    private VaultSecurityManager vaultSecurityManager;
    private VaultTemplate vaultTemplate;

    @BeforeEach
    void setUp() {
        String token = "4ad19d66-4406-632f-5b77-88e7e050b711";
        String uri = "http://127.0.0.1:8200";

        VaultEndpoint ve = VaultEndpoint.from(URI.create(uri));
        TokenAuthentication auth = new TokenAuthentication(token);

        vaultTemplate = new VaultTemplate(ve, auth);
        vaultSecurityManager = new VaultSecurityManager(vaultTemplate, "kv/");
    }

    @Test
    void authenticate_success() {
        Properties props = new Properties();
        props.setProperty("security-username","some-user");
        props.setProperty("security-password","some-password");
        vaultSecurityManager.authenticate(props);
    }

    @Test
    void authenticate_invalidPassword() {
        Properties props = new Properties();
        props.setProperty("security-username","some-user");
        props.setProperty("security-password","some-invalid-password");
        Throwable throwable = catchThrowable(() -> vaultSecurityManager.authenticate(props));
        assertThat(throwable).isInstanceOf(AuthenticationFailedException.class);
    }

    @Test
    void authenticate_invalidUsername() {
        Properties props = new Properties();
        props.setProperty("security-username","some-invalid-user");
        props.setProperty("security-password","some-password");
        Throwable throwable = catchThrowable(() -> vaultSecurityManager.authenticate(props));
        assertThat(throwable).isInstanceOf(AuthenticationFailedException.class);
    }
}