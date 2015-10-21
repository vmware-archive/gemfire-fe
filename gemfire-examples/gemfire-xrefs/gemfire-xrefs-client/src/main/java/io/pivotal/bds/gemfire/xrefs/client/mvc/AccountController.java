package io.pivotal.bds.gemfire.xrefs.client.mvc;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gemstone.gemfire.cache.Region;

import io.pivotal.bds.gemfire.data.securities.Account;
import io.pivotal.bds.gemfire.data.securities.AccountHistory;
import io.pivotal.bds.gemfire.data.securities.AccountHistoryKey;
import io.pivotal.bds.gemfire.data.securities.AccountKey;
import io.pivotal.bds.gemfire.data.securities.AccountStatus;
import io.pivotal.bds.gemfire.data.securities.ChangeAttributeType;
import io.pivotal.bds.gemfire.data.securities.ChangeRule;
import io.pivotal.bds.gemfire.data.securities.ChangeRuleKey;
import io.pivotal.bds.gemfire.data.securities.ChangeValueType;
import io.pivotal.bds.gemfire.data.securities.Security;
import io.pivotal.bds.gemfire.data.securities.SecurityKey;
import io.pivotal.bds.gemfire.keyfw.generator.ColocationKeyGenerator;
import io.pivotal.bds.gemfire.xrefs.common.Constants;

@RestController
public class AccountController implements Constants {

    @Resource(name = ACCOUNT_REGION_BEAN_NAME)
    private Region<AccountKey, Account> accountRegion;

    @Resource(name = ACCOUNT_HISTORY_REGION_BEAN_NAME)
    private Region<AccountHistoryKey, AccountHistory> accountHistoryRegion;

    @Resource(name = ACCOUNT_STATUS_REGION_BEAN_NAME)
    private Region<AccountKey, AccountStatus> accountStatusRegion;

    @Resource(name = CHANGE_RULE_REGION_BEAN_NAME)
    private Region<ChangeRuleKey, ChangeRule> changeRuleRegion;

    @Resource(name = SECURITY_REGION_BEAN_NAME)
    private Region<SecurityKey, Security> securityRegion;

    @Autowired
    private ColocationKeyGenerator<Long, String> keyGenerator;

    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createAccount(@RequestParam("id") String id, @RequestParam("name") String name,
            @RequestParam("balance") double balance) {
        LOG.info("createAccount: id={}, name={}, balance={}", id, name, balance);

        Date now = new Date();

        AccountKey key = new AccountKey(id);
        Account acct = new Account(key, name);
        accountRegion.putIfAbsent(key, acct);

        AccountHistoryKey ahk = keyGenerator.generate(AccountHistoryKey.class, id);
        AccountHistory ah = new AccountHistory(ahk, key, now, balance);
        accountHistoryRegion.putIfAbsent(ahk, ah);

        AccountStatus as = new AccountStatus(key, now, balance);
        accountStatusRegion.put(key, as);
    }

    @RequestMapping(value = "/rule", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createChangeRule(@RequestParam("id") String id, @RequestParam("acctid") String acctId,
            @RequestParam("secid") String secId, @RequestParam("attrtype") ChangeAttributeType attrType,
            @RequestParam("valtype") ChangeValueType valueType, @RequestParam("maximum") double max) {
        LOG.info("createChangeRule: id={}, acctId={}, attrType={}, valueType={}, max={}", id, acctId, attrType, valueType, max);

        AccountKey ak = new AccountKey(acctId);
        Account acct = accountRegion.get(ak);
        Assert.notNull(acct, "Account " + acctId + " not found");

        SecurityKey sk = new SecurityKey(secId);
        Security sec = securityRegion.get(sk);
        Assert.notNull(sec, "Security " + secId + " not found");

        ChangeRuleKey key = new ChangeRuleKey(id, acctId);
        ChangeRule rule = new ChangeRule(key, ak, sk, attrType, valueType, max);
        changeRuleRegion.putIfAbsent(key, rule);
    }
}
