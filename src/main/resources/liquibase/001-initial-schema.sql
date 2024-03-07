CREATE TABLE campaign
(
  id         UUID PRIMARY KEY,
  account_id UUID,
  name       VARCHAR(64),
  date_start TIMESTAMP NOT NULL,
  date_end   TIMESTAMP NOT NULL,
  version    BIGINT NOT NULL
);