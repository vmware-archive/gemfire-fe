package io.pivotal.bds.gemfire.groovy

import org.json.JSONObject
import org.springframework.context.ApplicationContext
import org.springframework.util.Assert

import com.gemstone.gemfire.cache.Region

import io.pivotal.bds.gemfire.data.securities.Account;
import io.pivotal.bds.gemfire.data.securities.AccountKey
import io.pivotal.bds.gemfire.data.securities.Security
import io.pivotal.bds.gemfire.data.securities.SecurityKey;
import io.pivotal.bds.gemfire.data.securities.Trade
import io.pivotal.bds.gemfire.data.securities.TradeKey
import io.pivotal.bds.gemfire.keyfw.generator.ColocationKeyGenerator;
import io.pivotal.bds.gemfire.keyfw.generator.KeyGenerator;

class TradeProcessor {

    static void process(String jsonTrade) {
        JSONObject json = new JSONObject(jsonTrade);

        String tradeId = json.getString("tradeId")
        String accountId = json.getString("accountId")
        String securityId = json.getString("securityId")
        int quantity = json.getInt("quantity")
        double price = json.getDouble("price")

        Region<AccountKey, Account> accountRegion = ApplicationContextSupport.getContext().getBean("accountRegion",Region.class)
        AccountKey acctKey = new AccountKey(accountId)
        Account acct = accountRegion.get(acctKey)
        Assert.notNull(acct,"Account "+accountId+" not found")
        
        Region<SecurityKey, Security> securityRegion = ApplicationContextSupport.getContext().getBean("securityRegion",Region.class)
        SecurityKey secKey = new SecurityKey(securityId)
        Security security = securityRegion.get(secKey)
        Assert.notNull(acct,"Security "+securityId+" not found")
        
        ColocationKeyGenerator<Long, String> keyGen = ApplicationContextSupport.getContext().getBean(ColocationKeyGenerator.class)
        TradeKey tradeKey = keyGen.generate(TradeKey.class,accountId)
        Trade trade = new Trade(tradeKey,secKey,acctKey,new Date(),quantity,price)
        Region<TradeKey, Trade> tradeRegion = ApplicationContextSupport.getContext().getBean("tradeRegion",Region.class)
        tradeRegion.put(tradeKey,trade)
    }
}
