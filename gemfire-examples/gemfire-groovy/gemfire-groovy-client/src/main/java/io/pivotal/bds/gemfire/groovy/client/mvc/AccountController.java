package io.pivotal.bds.gemfire.groovy.client.mvc;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gemstone.gemfire.cache.Region;

import io.pivotal.bds.gemfire.data.securities.Account;
import io.pivotal.bds.gemfire.data.securities.AccountKey;
import io.pivotal.bds.gemfire.groovy.common.Constants;

@RestController
public class AccountController implements Constants {

    @Resource(name = ACCOUNT_REGION_BEAN_NAME)
    private Region<AccountKey, Account> accountRegion;

    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createAccount(@RequestParam("id") String id, @RequestParam("name") String name,
            @RequestParam("balance") double balance) {
        LOG.info("createAccount: id={}, name={}, balance={}", id, name, balance);

        AccountKey key = new AccountKey(id);
        Account acct = new Account(key, name);
        accountRegion.putIfAbsent(key, acct);
    }
}
