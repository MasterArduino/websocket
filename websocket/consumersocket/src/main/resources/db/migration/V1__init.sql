CREATE TABLE user_audit (
                            id SERIAL PRIMARY KEY,
                            user_id VARCHAR(255) NOT NULL,
                            is_active BOOLEAN,
                            color VARCHAR(255),
                            number INTEGER,
                            message VARCHAR(255)
);
