GRANT ALL PRIVILEGES ON DATABASE demo_db TO demo_user;

CREATE TABLE IF NOT EXISTS demo_table (
    demo_id INT GENERATED ALWAYS AS IDENTITY,
    demo_key character varying(200) NOT NULL,
	demo_value character varying(300) NOT NULL
);