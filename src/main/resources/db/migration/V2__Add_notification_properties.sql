ALTER TABLE notification
    ADD order_id VARCHAR(255);

ALTER TABLE notification
    ADD payment_id VARCHAR(255);

ALTER TABLE notification
    ADD product_id VARCHAR(255);

ALTER TABLE notification
    ADD shipment_id VARCHAR(255);

ALTER TABLE notification
    ADD user_id VARCHAR(255);

ALTER TABLE notification
    ALTER COLUMN user_id SET NOT NULL;