ALTER TABLE POST ADD COLUMN commentary_id INTEGER,
ADD CONSTRAINT commentary_id FOREIGN KEY (commentary_id) REFERENCES COMMENTARIES(id);