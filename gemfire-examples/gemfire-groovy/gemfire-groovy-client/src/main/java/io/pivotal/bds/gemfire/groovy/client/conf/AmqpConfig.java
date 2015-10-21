package io.pivotal.bds.gemfire.groovy.client.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfig {

    @Autowired
    private PropertyConfig config;

    private static final Logger LOG = LoggerFactory.getLogger(AmqpConfig.class);

    @Bean
    public ConnectionFactory createConnectionFactory() {
        LOG.info("creating RabbitMQ ConnectionFactory: host={}, port={}, username={}, password={}", config.rabbitHost,
                config.rabbitPort, config.rabbitUsername, config.rabbitPassword);

        CachingConnectionFactory cf = new CachingConnectionFactory();

        cf.setHost(config.rabbitHost);
        cf.setPort(config.rabbitPort);
        cf.setUsername(config.rabbitUsername);
        cf.setPassword(config.rabbitPassword);

        return cf;
    }
}
