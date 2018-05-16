package io.pivotal.bds.gemfire.security;

import org.apache.geode.security.AuthenticationFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class VaultSecurityManagerTest {

    private VaultSecurityManager vaultSecurityManager;

    @Mock
    private VaultTemplate vaultTemplate;

    @BeforeEach
    void setUp() {
        initMocks(this);
        vaultSecurityManager = new VaultSecurityManager(vaultTemplate, "kv/");
    }

    @Test
    void authenticate_success() {
        String username = "some-user";
        String password = "some-password";

        VaultResponse vaultResponse = mock(VaultResponse.class);
        Map<String, Object> data = new HashMap<>();
        data.put("password", password);
        when(vaultResponse.getData()).thenReturn(data);
        when(vaultTemplate.read(anyString())).thenReturn(vaultResponse);

        Properties props = new Properties();
        props.setProperty("security-username",username);
        props.setProperty("security-password",password);
        vaultSecurityManager.authenticate(props);
    }

    @Test
    void authenticate_invalidPassword() {
        String username = "some-user";
        String password = "some-password";

        VaultResponse vaultResponse = mock(VaultResponse.class);
        Map<String, Object> data = new HashMap<>();
        data.put("password", password);
        when(vaultResponse.getData()).thenReturn(data);
        when(vaultTemplate.read(anyString())).thenReturn(vaultResponse);

        Properties props = new Properties();
        props.setProperty("security-username",username);
        props.setProperty("security-password","some-other-password");
        Throwable throwable = catchThrowable(() -> vaultSecurityManager.authenticate(props));
        assertThat(throwable).isInstanceOf(AuthenticationFailedException.class);
    }

    @Test
    void authenticate_missingPassword() {
        String username = "some-user";
        String password = "some-password";

        VaultResponse vaultResponse = mock(VaultResponse.class);
        Map<String, Object> data = new HashMap<>();
        data.put("password", password);
        when(vaultResponse.getData()).thenReturn(data);
        when(vaultTemplate.read(anyString())).thenReturn(vaultResponse);

        Properties props = new Properties();
        props.setProperty("security-username", username);
        Throwable throwable = catchThrowable(() -> vaultSecurityManager.authenticate(props));
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void authenticate_missingUsername() {
        String password = "some-password";

        VaultResponse vaultResponse = mock(VaultResponse.class);
        Map<String, Object> data = new HashMap<>();
        data.put("password", password);
        when(vaultResponse.getData()).thenReturn(data);
        when(vaultTemplate.read(anyString())).thenReturn(vaultResponse);

        Properties props = new Properties();
        props.setProperty("security-password",password);
        Throwable throwable = catchThrowable(() -> vaultSecurityManager.authenticate(props));
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }
}