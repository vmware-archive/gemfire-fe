package io.pivotal.bds.gemfire.fraud.common.util;

import com.datastax.driver.extras.codecs.enums.EnumOrdinalCodec;

import io.pivotal.bds.gemfire.fraud.common.data.AccountStatus;

public class AccountStatusCodec extends EnumOrdinalCodec<AccountStatus> {

    public AccountStatusCodec() {
        super(AccountStatus.class);
    }

}
