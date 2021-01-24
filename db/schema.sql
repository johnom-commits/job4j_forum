CREATE TABLE topics (
  id serial PRIMARY KEY,
  name varchar(500) NOT NULL,
  description text,
  created timestamp without time zone NOT NULL default now(),
  user_id integer NOT NULL REFERENCES users (id)
);

CREATE TABLE answers (
    id serial PRIMARY KEY,
    content text,
    created timestamp without time zone NOT NULL default now(),
    user_id integer NOT NULL REFERENCES users (id)
);

CREATE TABLE topics_answers (
    topic_id integer REFERENCES topics (id),
    answers_id integer REFERENCES answers (id),
    PRIMARY KEY (topic_id, answers_id)
);

CREATE TABLE users (
    id serial PRIMARY KEY,
    username varchar(50) NOT NULL UNIQUE,
    password varchar(500) NOT NULL,
    enabled boolean,
    email varchar(100) NOT NULL UNIQUE
);

