package io.pivotal.bds.gemfire.bitcoinj.function;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.wallet.Wallet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.execute.Function;
import com.gemstone.gemfire.cache.execute.FunctionContext;
import com.gemstone.gemfire.cache.execute.FunctionException;
import com.gemstone.gemfire.cache.execute.ResultSender;

@SuppressWarnings("serial")
public class AddWalletFunction implements Function {

    private NetworkParameters params;
    private Region<String, byte[]> serializedWalletRegion;

    private static final Logger LOG = LoggerFactory.getLogger(AddWalletFunction.class);

    public AddWalletFunction(NetworkParameters params, Region<String, byte[]> serializedWalletRegion) {
        this.params = params;
        this.serializedWalletRegion = serializedWalletRegion;
    }

    @Override
    public void execute(FunctionContext context) {
        try {
            String id = UUID.randomUUID().toString();
            LOG.info("execute: id={}", id);
            Wallet wallet = new Wallet(params);

            String receiveAddr = wallet.currentReceiveAddress().toString();

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            wallet.saveToFileStream(bos);
            byte[] data = bos.toByteArray();

            serializedWalletRegion.put(id, data);

            String resp = "id=" + id + ", receive address=" + receiveAddr;
            LOG.info("execute: id={}, resp={}", id, resp);

            ResultSender<String> sender = context.getResultSender();
            sender.lastResult(resp);
        } catch (Exception x) {
            LOG.error("execute: x={}", x.toString(), x);
            throw new FunctionException(x.toString(), x);
        }
    }

    @Override
    public String getId() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean hasResult() {
        return true;
    }

    @Override
    public boolean isHA() {
        return false;
    }

    @Override
    public boolean optimizeForWrite() {
        return false;
    }

}
