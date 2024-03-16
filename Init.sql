CREATE TABLE IF NOT EXISTS tb_associate (
    id SERIAL PRIMARY KEY,
    nr_cpf VARCHAR(11) NOT NULL
)

CREATE TABLE IF NOT EXISTS tb_discussion (
    id SERIAL PRIMARY KEY,
    ds_subject VARCHAR(200) NOT NULL,
    ds_description VARCHAR(300) NOT NULL,
    dt_creation_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    nr_total_votes INTEGER
)

CREATE TABLE IF NOT EXISTS tb_session (
    id SERIAL PRIMARY KEY,
    dt_session_start TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    tm_session_duration INTEGER,
    dt_session_end TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    nr_session_state VARCHAR(6) NOT NULL,
    discussion_id LONG,
    CONSTRAINT fk_discussion FOREIGN KEY (discussion_id) REFERENCES tb_discussion(id)
)

CREATE TABLE IF NOT EXISTS tb_vote (
    id SERIAL PRIMARY KEY,
    vl_vote_answer BOOLEAN,
    associate_id LONG,
    session_id LONG,
    CONSTRAINT fk_associate FOREIGN KEY (associate_id) REFERENCES tb_associate(id),
    CONSTRAINT fk_session FOREIGN KEY (session_id) REFERENCES tb_session(id)
)

CREATE OR REPLACE FUNCTION update_discussion_status() RETURNS VOID AS $$
DECLARE
    total_votes_positive INTEGER;
    total_votes_negative INTEGER;
BEGIN
    UPDATE tb_session
    SET nr_session_state = 'CLOSED'
    WHERE nr_session_state = 'OPEN' AND dt_session_end <= NOW();

    FOR s IN SELECT id FROM tb_session WHERE nr_session_state = 'CLOSED' LOOP
        SELECT COUNT(*)
        INTO total_votes_positive
        FROM tb_vote
        WHERE session_id = s.id
        AND vl_vote_answer = true;

        SELECT COUNT(*)
        INTO total_votes_negative
        FROM tb_vote
        WHERE session_id = s.id
        AND vl_vote_answer = false;

        IF total_votes_positive > total_votes_negative THEN
            UPDATE tb_discussion
                    SET nr_total_votes = total_votes_positive
                    WHERE id = s.discussion_id;
        ELSE
            UPDATE tb_discussion
                    SET nr_total_votes = total_votes_negative
                    WHERE id = s.discussion_id;
        END IF;
    END LOOP;
END;
$$ LANGUAGE plpgsql;