CREATE TABLE IF NOT EXISTS tb_associate (
    id SERIAL PRIMARY KEY,
    nr_cpf VARCHAR(11) NOT NULL
)

CREATE TABLE IF NOT EXISTS tb_discussion (
    id SERIAL PRIMARY KEY,
    ds_subject VARCHAR(200) NOT NULL,
    ds_description VARCHAR(300) NOT NULL,
    dt_creation_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    nr_total_votes_yes INTEGER,
    nr_total_votes_no INTEGER
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