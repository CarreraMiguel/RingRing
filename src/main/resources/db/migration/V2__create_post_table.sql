CREATE TABLE IF NOT EXISTS POSTS
(
    id INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 1) PRIMARY KEY,
    title VARCHAR(50),
    body VARCHAR(2500),
    created_date TIMESTAMP,
    user_id INTEGER,
    FOREIGN KEY (user_id) REFERENCES USERS(id)
);