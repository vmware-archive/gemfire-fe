package io.pivotal.bds.gemfire.cassandra.util;

import com.datastax.driver.extras.codecs.enums.EnumOrdinalCodec;

import io.pivotal.bds.gemfire.cassandra.data.AccountStatus;

public class AccountStatusCodec extends EnumOrdinalCodec<AccountStatus> {

    public AccountStatusCodec() {
        super(AccountStatus.class);
    }

  
}
