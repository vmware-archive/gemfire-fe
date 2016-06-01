package io.pivotal.bds.gemfire.fraud.common.data;

public enum TransactionResultCode {

    in_process, success, success_flagged, limit_exceeded, unknown_account, invalid_card, invalid_account, invalid_vendor, suspect_vendor, suspect_txn, error
}
