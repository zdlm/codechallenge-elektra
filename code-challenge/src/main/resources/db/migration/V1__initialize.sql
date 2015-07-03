-- Table: contents

CREATE TABLE contents
(
  id         BIGSERIAL NOT NULL PRIMARY KEY,
  content    CHARACTER VARYING(255),
  dateAdded TIMESTAMP DEFAULT now()
);
ALTER TABLE contents
OWNER TO postgres;


