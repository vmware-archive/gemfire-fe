create table account 
    ( account_id varchar primary key
    , account_status int
    , account_limit double);
   
create table account_balance    
    ( account_id varchar primary key
    , account_balance double);

create table card
    ( card_id varchar primary key
    , card_number varchar
    , expiration_date timestamp
    , ccv varchar
    , name_on_card varchar
    , account_id varchar
    , card_limit double);
    
create index card_number on card (card_number);
create index card_account_id on card (account_id);
    
create table transaction
    ( transaction_id varchar primary key
    , account_id varchar
    , card_id varchar
    , vendor_id varchar
    , created_on timestamp
    , transaction_amount double);
    
create index transaction_account_id on transaction (account_id);
create index transaction_card_id on transaction (card_id);
create index transaction_vendor_id on transaction (vendor_id);

create table transaction_history
    ( transaction_history_id varchar primary key
    , updated_on timestamp
    , transaction_status int
    , transaction_result int
    , transaction_id varchar
    , account_id varchar
    , card_id varchar
    , vendor_id varchar
    , created_on timestamp
    , transaction_amount double);
    
create index transaction_history_transaction_id on transaction_history (transaction_id);
create index transaction_history_account_id on transaction_history (account_id);
create index transaction_history_card_id on transaction_history (card_id);
create index transaction_history_vendor_id on transaction_history (vendor_id);

create table transaction_status
    ( transaction_id varchar primary key
    , account_id varchar
    , transaction_status int
    , transaction_result int);
    
create index transaction_status_account_id on transaction_status (account_id);

create table vendor
    ( vendor_id varchar primary key
    , vendor_type int
    , vendor_status int
    , vendor_x double
    , vendor_y double);

create table alert
    ( alert_id varchar primary key
    , transaction_id varchar
    , account_id varchar
    , created_on timestamp
    , message varchar);

create index alert_transaction_id on alert (transaction_id);
create index alert_account_id on alert (account_id);

create table card_balance
    ( card_id varchar primary key
    , account_id varchar
    , card_balance double);
    
create index card_balance_account_id on card_balance (account_id);

create table account_classifier
    ( account_id varchar primary key
    , x blob
    , y blob);
    
create table card_classifier
    ( card_id varchar primary key
    , account_id varchar
    , x blob
    , y blob);
    
    