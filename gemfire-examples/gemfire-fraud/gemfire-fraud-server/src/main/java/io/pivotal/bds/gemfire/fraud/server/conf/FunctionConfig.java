package io.pivotal.bds.gemfire.fraud.server.conf;

import javax.annotation.Resource;

import org.opengis.referencing.operation.MathTransform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.execute.FunctionService;

import io.pivotal.bds.gemfire.fraud.common.data.Account;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountAggregateDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountClassifierDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardBalanceDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardClassifierDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardLockDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardNumberAccountKeyXrefDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardNumberCardKeyXrefDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionHistoryDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionStatusDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.VendorDAO;
import io.pivotal.bds.gemfire.fraud.server.function.ProcessTransactionFunction;
import io.pivotal.bds.gemfire.fraud.server.function.ProcessTransactionPartitionedFunction;

@Configuration
public class FunctionConfig {

    @Resource
    private Region<AccountKey, Account> accountRegion;

    private static final Logger LOG = LoggerFactory.getLogger(FunctionConfig.class);

    @Bean
    public ProcessTransactionFunction processTransactionFunction(CardNumberAccountKeyXrefDAO cardNumberAccountKeyXrefDAO) {
        LOG.info("processTransactionFunction");
        Assert.notNull(accountRegion, "accountRegion is null");
        ProcessTransactionFunction f = new ProcessTransactionFunction(cardNumberAccountKeyXrefDAO, accountRegion);
        FunctionService.registerFunction(f);
        return f;
    }

    @Bean
    public ProcessTransactionPartitionedFunction processTransactionPartitionedFunction(CardNumberCardKeyXrefDAO cardKeyXrefDAO,
            CardDAO cardDAO, VendorDAO vendorDAO, AccountDAO accountDAO, AccountAggregateDAO accountAggregateDAO,
            TransactionDAO transactionDAO, TransactionHistoryDAO transactionHistoryDAO, TransactionStatusDAO transactionStatusDAO,
            AccountClassifierDAO accountClassifierDAO, CardClassifierDAO cardClassifierDAO, CardLockDAO cardLockDAO,
            CardBalanceDAO cardBalanceDAO, MathTransform latLonToCart) {
        LOG.info("processTransactionPartitionedFunction");
        ProcessTransactionPartitionedFunction f = new ProcessTransactionPartitionedFunction(cardKeyXrefDAO, cardDAO, vendorDAO,
                accountDAO, accountAggregateDAO, transactionDAO, transactionHistoryDAO, transactionStatusDAO, accountClassifierDAO,
                cardClassifierDAO, cardLockDAO, cardBalanceDAO, latLonToCart);
        FunctionService.registerFunction(f);
        return f;
    }
}
