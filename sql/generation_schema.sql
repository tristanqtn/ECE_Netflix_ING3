CREATE DATABASE NETFLIX;
use NETFLIX;

CREATE TABLE NETFLIX.films(
   ID int NOT NULL AUTO_INCREMENT,
   realisateur VARCHAR(255),
   acteur VARCHAR(255),
   genres VARCHAR(255),
   duree int,
   note double,
   time_code int,
   parution date,
   titre VARCHAR(255),
   synopsis VARCHAR(255),
   video VARCHAR(255),
   trailer VARCHAR(255),
   PRIMARY KEY (ID)
);

CREATE TABLE NETFLIX.documentaires(
   ID int NOT NULL AUTO_INCREMENT,
   realisateur VARCHAR(255),
   acteur VARCHAR(255),
   genres VARCHAR(255),
   duree int,
   note double,
   time_code int,
   parution date,
   titre VARCHAR(255),
   synopsis VARCHAR(255),
   video VARCHAR(255),
   trailer VARCHAR(255),
   PRIMARY KEY (ID)
);

CREATE TABLE NETFLIX.series(
   ID int NOT NULL,
   realisateur VARCHAR(255),
   acteur VARCHAR(255),
   genres VARCHAR(255),
   duree int,
   note double,
   time_code int,
   parution date,
   titre VARCHAR(255),
   synopsis VARCHAR(255),
   video VARCHAR(255),
   trailer VARCHAR(255),
   nombre_saison int, 
   episode_en_cours int,
   PRIMARY KEY (ID)
);

CREATE TABLE NETFLIX.saisons(
   ID int NOT NULL AUTO_INCREMENT,
   serie int,
   
   num_saison int,
   nombre_episode int,
   
   PRIMARY KEY (ID),
   FOREIGN KEY (serie) REFERENCES series (ID)
);

CREATE TABLE NETFLIX.episodes(
   ID int NOT NULL AUTO_INCREMENT,
   saison int NOT NULL,
   
   realisateur VARCHAR(255),
   acteur VARCHAR(255),
   genres VARCHAR(255),
   duree int,
   note double,
   time_code int,
   parution date,
   titre VARCHAR(255),
   synopsis VARCHAR(255),
   video VARCHAR(255),
   trailer VARCHAR(255),
   numero_episode int,
   
   PRIMARY KEY (ID), 
   FOREIGN KEY (saison) REFERENCES saisons (ID)
);

CREATE TABLE NETFLIX.membres(
   ID int NOT NULL AUTO_INCREMENT,
   nom VARCHAR(255),
   prenom VARCHAR(255),
   adresse_mail VARCHAR(255),
   telephone int,
   num_carte double, 
   preferences VARCHAR(255),
   mdp VARCHAR(255),
   PRIMARY KEY (ID)
);

