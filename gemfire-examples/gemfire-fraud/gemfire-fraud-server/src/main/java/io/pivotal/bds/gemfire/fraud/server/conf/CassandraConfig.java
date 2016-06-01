package io.pivotal.bds.gemfire.fraud.server.conf;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;

import io.pivotal.bds.gemfire.fraud.common.data.Account;
import io.pivotal.bds.gemfire.fraud.common.data.AccountBalance;
import io.pivotal.bds.gemfire.fraud.common.data.Alert;
import io.pivotal.bds.gemfire.fraud.common.data.Card;
import io.pivotal.bds.gemfire.fraud.common.data.CardBalance;
import io.pivotal.bds.gemfire.fraud.common.data.CardClassifierData;
import io.pivotal.bds.gemfire.fraud.common.data.AccountClassifierData;
import io.pivotal.bds.gemfire.fraud.common.data.Transaction;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionHistory;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionStatus;
import io.pivotal.bds.gemfire.fraud.common.data.Vendor;

@Configuration
public class CassandraConfig {

    @Autowired
    private PropertyConfig properties;

    private static final Logger LOG = LoggerFactory.getLogger(CassandraConfig.class);

    @Bean
    public Cluster cassandraCluster() {
        LOG.info("cassandraCluster: cassandraContactPoints={}", properties.cassandraContactPoints);

        Cluster.Builder builder = Cluster.builder();

        String[] sa = properties.cassandraContactPoints.split(",");

        for (String s : sa) {
            int p = s.indexOf(':');

            if (p < 0) {
                builder.addContactPoint(s);
            } else {
                String host = s.substring(0, p);
                int port = Integer.parseInt(s.substring(p + 1));
                InetSocketAddress addr = new InetSocketAddress(host, port);
                builder.addContactPointsWithPorts(addr);
            }
        }

        Cluster c = builder.build();
        return c;
    }

    @Bean
    public Session cassandraSession(Cluster cassandraCluster) {
        LOG.info("cassandraSession: cassandraKeyspace={}", properties.cassandraKeyspace);
        Session s = cassandraCluster.connect(properties.cassandraKeyspace);
        return s;
    }

    @Bean
    public MappingManager cassandraMappingManager(Session cassandraSession) {
        LOG.info("cassandraMappingManager");
        return new MappingManager(cassandraSession);
    }

    @Bean
    public Mapper<Account> accountMapper(MappingManager cassandraMappingManager) {
        LOG.info("accountMapper");
        return cassandraMappingManager.mapper(Account.class);
    }

    @Bean
    public Mapper<AccountBalance> accountBalanceMapper(MappingManager cassandraMappingManager) {
        LOG.info("accountBalanceMapper");
        return cassandraMappingManager.mapper(AccountBalance.class);
    }

    @Bean
    public Mapper<Transaction> transactionMapper(MappingManager cassandraMappingManager) {
        LOG.info("transactionMapper");
        return cassandraMappingManager.mapper(Transaction.class);
    }

    @Bean
    public Mapper<TransactionHistory> transactionHistoryMapper(MappingManager cassandraMappingManager) {
        LOG.info("transactionHistoryMapper");
        return cassandraMappingManager.mapper(TransactionHistory.class);
    }

    @Bean
    public Mapper<TransactionStatus> transactionStatusMapper(MappingManager cassandraMappingManager) {
        LOG.info("transactionStatusMapper");
        return cassandraMappingManager.mapper(TransactionStatus.class);
    }
    
    @Bean
    public Mapper<Vendor> vendorMapper(MappingManager cassandraMappingManager) {
        LOG.info("vendorMapper");
        return cassandraMappingManager.mapper(Vendor.class);
    }
    
    @Bean
    public Mapper<Card> cardMapper(MappingManager cassandraMappingManager) {
        LOG.info("cardMapper");
        return cassandraMappingManager.mapper(Card.class);
    }
    
    @Bean
    public Mapper<CardBalance> cardBalanceMapper(MappingManager cassandraMappingManager) {
        LOG.info("cardBalanceMapper");
        return cassandraMappingManager.mapper(CardBalance.class);
    }
    
    @Bean
    public Mapper<Alert> alertMapper(MappingManager cassandraMappingManager) {
        LOG.info("alertMapper");
        return cassandraMappingManager.mapper(Alert.class);
    }

    @Bean
    public Mapper<AccountClassifierData> accountClassifierDataMapper(MappingManager cassandraMappingManager) {
        LOG.info("accountClassifierDataMapper");
        return cassandraMappingManager.mapper(AccountClassifierData.class);
    }

    @Bean
    public Mapper<CardClassifierData> cardClassifierDataMapper(MappingManager cassandraMappingManager) {
        LOG.info("cardClassifierDataMapper");
        return cassandraMappingManager.mapper(CardClassifierData.class);
    }

}
