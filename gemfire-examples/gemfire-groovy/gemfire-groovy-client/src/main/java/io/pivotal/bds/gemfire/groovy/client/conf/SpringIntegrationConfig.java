package io.pivotal.bds.gemfire.groovy.client.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.amqp.Amqp;
import org.springframework.integration.dsl.support.Transformers;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.util.Assert;

import io.pivotal.bds.gemfire.groovy.client.handler.TradeHandler;

@Configuration
@EnableIntegration
public class SpringIntegrationConfig {

    private static final Logger LOG = LoggerFactory.getLogger(SpringIntegrationConfig.class);

    @Bean
    public DirectChannel inputChannel() {
        LOG.info("creating inputChannel");
        return new DirectChannel();
    }

    @Bean
    public DirectChannel errorChannel() {
        LOG.info("creating errorChannel");
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow inputFlow(DirectChannel inputChannel, DirectChannel errorChannel, ConnectionFactory cf,
            TradeHandler handler) {
        LOG.info("creating inputFlow");

        Assert.notNull(inputChannel, "inputChannel is null");
        Assert.notNull(cf, "cf is null");
        Assert.notNull(handler, "handler is null");

        return IntegrationFlows
                .from(Amqp.inboundAdapter(cf, "trade").concurrentConsumers(10).prefetchCount(100).errorChannel(errorChannel))
                .transform(Transformers.objectToString("UTF-8")).channel(inputChannel).handle(handler).get();
    }

    @Bean
    public IntegrationFlow errorFlow(DirectChannel errorChannel) {
        LOG.info("creating errorFlow");
        return IntegrationFlows.from(errorChannel).handle(new LoggingHandler("warn")).get();
    }
}
