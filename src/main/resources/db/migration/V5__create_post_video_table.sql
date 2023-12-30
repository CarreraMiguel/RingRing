CREATE TABLE IF NOT EXISTS POST_VIDEOS
(
    id INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 1) PRIMARY KEY,
    title VARCHAR(50),
    body VARCHAR(2500),
    quality INTEGER,
    duration VARCHAR(10),
    created_date TIMESTAMP,
    user_id INTEGER,
    FOREIGN KEY (user_id) REFERENCES USERS(id)
);