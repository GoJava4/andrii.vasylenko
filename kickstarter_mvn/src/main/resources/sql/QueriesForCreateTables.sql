drop table IF EXISTS Quotes;
CREATE TABLE Quotes
(
  id serial NOT NULL,
  quote character varying(255),
  CONSTRAINT quotes_pkey PRIMARY KEY (id)
);


drop table IF EXISTS Categories CASCADE;
CREATE TABLE Categories
(
  id serial NOT NULL,
  name character varying(255),
  CONSTRAINT categories_pkey PRIMARY KEY (id)
);


drop table IF EXISTS Projects CASCADE; 
CREATE TABLE Projects
(
  id serial NOT NULL,
  id_category integer,
  name character varying(255),
  description character varying(255),
  total_amount integer,
  days_left integer,
  history character varying(255),
  link character varying(255),
  CONSTRAINT projects_pkey PRIMARY KEY (id),
  CONSTRAINT projects_id_category_fkey FOREIGN KEY (id_category)
      REFERENCES categories (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


drop table IF EXISTS Payments;
CREATE TABLE Payments
(
  id serial NOT NULL,
  id_project integer,
  amount integer,
  CONSTRAINT payments_pkey PRIMARY KEY (id),
  CONSTRAINT payments_id_project_fkey FOREIGN KEY (id_project)
      REFERENCES projects (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


drop table IF EXISTS Questions; 
CREATE TABLE Questions
(
  id serial NOT NULL,
  id_project integer,
  question character varying(255),
  CONSTRAINT questions_pkey PRIMARY KEY (id),
  CONSTRAINT questions_id_project_fkey FOREIGN KEY (id_project)
      REFERENCES projects (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


drop table IF EXISTS PaymentVariants;
CREATE TABLE PaymentVariants
(
  id serial NOT NULL,
  id_project integer,
  amount integer,
  description character varying(255),
  CONSTRAINT PaymentVariants_pkey PRIMARY KEY (id),
  CONSTRAINT PaymentVariants_id_project_fkey FOREIGN KEY (id_project)
      REFERENCES projects (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
