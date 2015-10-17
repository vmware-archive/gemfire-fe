package io.pivotal.bds.spring.integration.collectd;

import org.jcollectd.agent.api.Notification;
import org.jcollectd.agent.api.Values;
import org.jcollectd.agent.protocol.Dispatcher;
import org.jcollectd.server.protocol.UdpReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

public class CollectdMessageProducer extends MessageProducerSupport {

    private String listenAddress = "0.0.0.0";
    private int port = 25286;

    private UdpReceiver receiver;
    private final Dispatcher dispatcher = new DispatcherImpl();

    private static final Logger LOG = LoggerFactory.getLogger(CollectdMessageProducer.class);

    public CollectdMessageProducer() {
    }

    public CollectdMessageProducer(String listenAddress, int port) {
        this.listenAddress = listenAddress;
        this.port = port;
    }

    public String getListenAddress() {
        return listenAddress;
    }

    public void setListenAddress(String listenAddress) {
        this.listenAddress = listenAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    protected void doStart() {
        super.doStart();

        LOG.info("doStart: listenAddress={}, port={}", listenAddress, port);

        try {
            receiver = new UdpReceiver();
            receiver.setListenAddress(listenAddress);
            receiver.setPort(port);
            receiver.setDispatcher(dispatcher);

            Runnable r = new Runnable() {

                @Override
                public void run() {
                    try {
                        receiver.listen();
                    } catch (Exception x) {
                        LOG.error(x.toString(), x);
                    }
                }
            };

            new Thread(r).start();
        } catch (Exception x) {
            throw new IllegalArgumentException(x.toString(), x);
        }
    }

    @Override
    protected void doStop() {
        super.doStop();

        LOG.info("doStop: listenAddress={}, port={}", listenAddress, port);

        receiver.shutdown();
        receiver = null;
    }

    private class DispatcherImpl implements Dispatcher {

        @Override
        public void dispatch(Values values) {
            LOG.debug("dispatch: values={}", values);
            Message<Values> msg = MessageBuilder.withPayload(values).build();
            sendMessage(msg);
        }

        @Override
        public void dispatch(Notification notification) {
            LOG.debug("dispatch: notification={}", notification);
            Message<Notification> msg = MessageBuilder.withPayload(notification).build();
            sendMessage(msg);
        }
    }
}
