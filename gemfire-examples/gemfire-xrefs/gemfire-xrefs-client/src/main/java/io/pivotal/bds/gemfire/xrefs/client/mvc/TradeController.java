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

import org.apache.geode.cache.Region;

import io.pivotal.bds.gemfire.data.securities.Account;
import io.pivotal.bds.gemfire.data.securities.AccountKey;
import io.pivotal.bds.gemfire.data.securities.Security;
import io.pivotal.bds.gemfire.data.securities.SecurityKey;
import io.pivotal.bds.gemfire.data.securities.Trade;
import io.pivotal.bds.gemfire.data.securities.TradeKey;
import io.pivotal.bds.gemfire.keyfw.generator.ColocationKeyGenerator;
import io.pivotal.bds.gemfire.xrefs.common.Constants;

@RestController
@RequestMapping("/trade")
public class TradeController implements Constants {

    @Resource(name = SECURITY_REGION_BEAN_NAME)
    private Region<SecurityKey, Security> securityRegion;

    @Resource(name = ACCOUNT_REGION_BEAN_NAME)
    private Region<AccountKey, Account> accountRegion;

    @Resource(name = TRADE_REGION_BEAN_NAME)
    private Region<TradeKey, Trade> tradeRegion;

    @Autowired
    private ColocationKeyGenerator<Long, String> colocationKeyGenerator;

    private static final Logger LOG = LoggerFactory.getLogger(TradeController.class);

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createTrade(@RequestParam("securityId") String secId, @RequestParam("accountId") String acctId,
            @RequestParam("quantity") int quan, @RequestParam("price") double price) {

        LOG.info("createTrade: secId={}, acctId={}, quan={}, price={}", secId, acctId, quan, price);

        SecurityKey sk = new SecurityKey(secId);
        Security sec = securityRegion.get(sk);
        Assert.notNull(sec, "Security " + secId + " not found");

        AccountKey ak = new AccountKey(acctId);
        Account acct = accountRegion.get(ak);
        Assert.notNull(acct, "Account " + acctId + " not found");

        TradeKey tk = colocationKeyGenerator.generate(TradeKey.class, acctId);
        Trade tr = new Trade(tk, sk, ak, new Date(), quan, price);

        LOG.info("createTrade: tk={}, secId={}, acctId={}, quan={}, price={}", tk, secId, acctId, quan, price);

        tradeRegion.put(tk, tr);
    }
}
