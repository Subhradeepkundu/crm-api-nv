CREATE TABLE banks (
    id          uuid DEFAULT uuid_generate_v4(),
    logo        varchar(255),
    name        varchar(255),
    PRIMARY KEY(id)
);

CREATE TABLE bank_accounts (
    id              uuid DEFAULT uuid_generate_v4(),
    account_number  varchar(255),
    category        varchar(255),
    iban_number     varchar(255),
    provider_id     uuid,
    resort_id       uuid,
    swift_number    varchar(100),
    bank_id         uuid,
    PRIMARY KEY(id),
    CONSTRAINT fk_bank_account
      FOREIGN KEY(bank_id)
      REFERENCES banks(id)
      ON DELETE CASCADE
);