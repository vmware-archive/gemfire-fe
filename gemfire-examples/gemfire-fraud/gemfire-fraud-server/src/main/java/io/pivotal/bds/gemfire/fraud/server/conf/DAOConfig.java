package io.pivotal.bds.gemfire.fraud.server.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import io.pivotal.bds.gemfire.fraud.common.Constants;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountAggregateDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountBalanceDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountClassifierDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountClassifierDataDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountRegressionDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountTransactionXrefDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.AlertDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardAggregateDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardBalanceDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardClassifierDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardClassifierDataDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardLockDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardNumberAccountKeyXrefDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardNumberCardKeyXrefDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardTransactionXrefDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionAggregateDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionHistoryDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionHistoryXrefDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionStatusDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.VendorDAO;

@Configuration("DAOConfig")
@DependsOn("RegionHolder")
public class DAOConfig implements Constants {

    @Autowired
    private RegionHolder regions;

    private static final Logger LOG = LoggerFactory.getLogger(DAOConfig.class);

    @Bean
    public AccountDAO accountDAO() {
        LOG.info("accountDAO");
        return new AccountDAO(regions.accountRegion);
    }

    @Bean
    public AccountClassifierDAO accountClassifierDAO() {
        LOG.info("accountClassifierDAO");
        return new AccountClassifierDAO(regions.accountClassifierRegion);
    }

    @Bean
    public AccountClassifierDataDAO accountClassifierDataDAO() {
        LOG.info("accountClassifierDataDAO");
        return new AccountClassifierDataDAO(regions.accountClassifierDataRegion);
    }

    @Bean
    public AccountRegressionDAO accountRegressionDAO() {
        LOG.info("accountRegressionDAO");
        return new AccountRegressionDAO(regions.accountRegressionRegion);
    }

    @Bean
    public AccountBalanceDAO accountBalanceDAO() {
        LOG.info("accountBalanceDAO");
        return new AccountBalanceDAO(regions.accountBalanceRegion);
    }

    @Bean
    public AccountAggregateDAO accountAggregateDAO() {
        LOG.info("accountAggregateDAO");
        return new AccountAggregateDAO(regions.accountAggregateRegion);
    }

    @Bean
    public AccountTransactionXrefDAO accountTransactionXrefDAO() {
        LOG.info("accountTransactionXrefDAO");
        return new AccountTransactionXrefDAO(regions.accountTransactionXrefRegion);
    }

    @Bean
    public TransactionDAO transactionDAO() {
        LOG.info("transactionDAO");
        return new TransactionDAO(regions.transactionRegion);
    }

    @Bean
    public TransactionAggregateDAO transactionAggregateDAO() {
        LOG.info("transactionAggregateDAO");
        return new TransactionAggregateDAO(regions.transactionAggregateRegion);
    }

    @Bean
    public TransactionHistoryDAO transactionHistoryDAO() {
        LOG.info("transactionHistoryDAO");
        return new TransactionHistoryDAO(regions.transactionHistoryRegion);
    }

    @Bean
    public TransactionStatusDAO transactionStatusDAO() {
        LOG.info("transactionStatusDAO");
        return new TransactionStatusDAO(regions.transactionStatusRegion);
    }

    @Bean
    public TransactionHistoryXrefDAO transactionHistoryXrefDAO() {
        LOG.info("transactionHistoryXrefDAO");
        return new TransactionHistoryXrefDAO(regions.transactionHistoryXrefRegion);
    }

    @Bean
    public VendorDAO vendorDAO() {
        LOG.info("vendorDAO");
        return new VendorDAO(regions.vendorRegion);
    }

    @Bean
    public CardNumberAccountKeyXrefDAO cardNumberAccountKeyXrefDAO() {
        LOG.info("cardNumberAccountKeyXrefDAO");
        return new CardNumberAccountKeyXrefDAO(regions.cardNumberAccountKeyXrefRegion);
    }

    @Bean
    public CardNumberCardKeyXrefDAO cardNumberCardKeyXrefDAO() {
        LOG.info("cardNumberCardKeyXrefDAO");
        return new CardNumberCardKeyXrefDAO(regions.cardNumberCardKeyXrefRegion);
    }

    @Bean
    public CardDAO cardDAO() {
        LOG.info("cardDAO");
        return new CardDAO(regions.cardRegion);
    }

    @Bean
    public CardBalanceDAO cardBalanceDAO() {
        LOG.info("cardBalanceDAO");
        return new CardBalanceDAO(regions.cardBalanceRegion);
    }

    @Bean
    public CardLockDAO cardLockDAO() {
        LOG.info("cardLockDAO");
        return new CardLockDAO(regions.cardLockRegion);
    }

    @Bean
    public CardAggregateDAO cardAggregateDAO() {
        LOG.info("cardAggregateDAO");
        return new CardAggregateDAO(regions.cardAggregateRegion);
    }

    @Bean
    public CardTransactionXrefDAO cardTransactionXrefDAO() {
        LOG.info("cardTransactionXrefDAO");
        return new CardTransactionXrefDAO(regions.cardTransactionXrefRegion);
    }

    @Bean
    public CardClassifierDAO cardClassifierDAO() {
        LOG.info("cardClassifierDAO");
        return new CardClassifierDAO(regions.cardClassifierRegion);
    }

    @Bean
    public CardClassifierDataDAO cardClassifierDataDAO() {
        LOG.info("cardClassifierDataDAO");
        return new CardClassifierDataDAO(regions.cardClassifierDataRegion);
    }

    @Bean
    public AlertDAO alertDAO() {
        LOG.info("alertDAO");
        return new AlertDAO(regions.alertRegion);
    }

}
