CREATE TABLE tb_answers
(
	id                 UUID                        NOT NULL,
	answer_message     VARCHAR(150)                NOT NULL,
	answer_topic       UUID                        NOT NULL,
	answer_create_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	answer_author      UUID                        NOT NULL,
	CONSTRAINT pk_tb_answers PRIMARY KEY (id)
);

CREATE TABLE tb_course
(
	id              UUID         NOT NULL,
	course_name     VARCHAR(20)  NOT NULL,
	course_category VARCHAR(255) NOT NULL,
	CONSTRAINT pk_tb_course PRIMARY KEY (id)
);

CREATE TABLE tb_profile
(
	id           UUID        NOT NULL,
	profile_name VARCHAR(20) NOT NULL,
	CONSTRAINT pk_tb_profile PRIMARY KEY (id)
);

CREATE TABLE tb_topic
(
	id                UUID                        NOT NULL,
	topic_title       VARCHAR(50)                 NOT NULL,
	topic_message     VARCHAR(150)                NOT NULL,
	topic_create_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	topic_status      VARCHAR(255)                NOT NULL,
	topic_author      UUID                        NOT NULL,
	topic_course      UUID                        NOT NULL,
	CONSTRAINT pk_tb_topic PRIMARY KEY (id)
);

CREATE TABLE tb_user
(
	id            UUID         NOT NULL,
	user_name     VARCHAR(20)  NOT NULL,
	user_email    VARCHAR(255) NOT NULL,
	user_password VARCHAR(255) NOT NULL,
	CONSTRAINT pk_tb_user PRIMARY KEY (id)
);

CREATE TABLE tb_user_profiles
(
	profiles_id   UUID NOT NULL,
	user_profiles UUID NOT NULL
);

ALTER TABLE tb_course
	ADD CONSTRAINT uc_tb_course_course_name UNIQUE (course_name);

ALTER TABLE tb_profile
	ADD CONSTRAINT uc_tb_profile_profile_name UNIQUE (profile_name);

ALTER TABLE tb_topic
	ADD CONSTRAINT uc_tb_topic_topic_title UNIQUE (topic_title);

ALTER TABLE tb_user
	ADD CONSTRAINT uc_tb_user_user_email UNIQUE (user_email);

ALTER TABLE tb_user
	ADD CONSTRAINT uc_tb_user_user_name UNIQUE (user_name);

ALTER TABLE tb_answers
	ADD CONSTRAINT fk_tb_answers_on_answer_author FOREIGN KEY (answer_author) REFERENCES tb_user (id);

ALTER TABLE tb_answers
	ADD CONSTRAINT fk_tb_answers_on_answer_topic FOREIGN KEY (answer_topic) REFERENCES tb_topic (id);

ALTER TABLE tb_topic
	ADD CONSTRAINT fk_tb_topic_on_topic_author FOREIGN KEY (topic_author) REFERENCES tb_user (id);

ALTER TABLE tb_topic
	ADD CONSTRAINT fk_tb_topic_on_topic_course FOREIGN KEY (topic_course) REFERENCES tb_course (id);

ALTER TABLE tb_user_profiles
	ADD CONSTRAINT fk_tbusepro_on_profile FOREIGN KEY (profiles_id) REFERENCES tb_profile (id);

ALTER TABLE tb_user_profiles
	ADD CONSTRAINT fk_tbusepro_on_user FOREIGN KEY (user_profiles) REFERENCES tb_user (id);
