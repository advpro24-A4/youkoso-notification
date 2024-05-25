CREATE TABLE notification
(
    id         UUID                        NOT NULL,
    message    VARCHAR(255)                NOT NULL,
    type       VARCHAR(255)                NOT NULL,
    status     VARCHAR(255)                NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_notification PRIMARY KEY (id)
);