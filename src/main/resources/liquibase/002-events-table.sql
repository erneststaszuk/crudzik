CREATE TABLE event
(
  id    UUID PRIMARY KEY,
  type  VARCHAR(255),
  topic VARCHAR(255),
  event VARCHAR(4096)
);