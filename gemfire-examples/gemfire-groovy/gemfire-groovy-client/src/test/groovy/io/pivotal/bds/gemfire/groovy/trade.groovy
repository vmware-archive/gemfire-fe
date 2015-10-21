package io.pivotal.bds.gemfire.groovy

import io.pivotal.bds.gemfire.groovy.TradeProcessor
import org.springframework.context.ApplicationContext

String trade = (String)this.arguments
ApplicationContext context = this.context

ApplicationContextSupport.setContext(context)

TradeProcessor.process(trade)