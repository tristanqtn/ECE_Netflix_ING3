CREATE DATABASE NETFLIX;
use NETFLIX;

CREATE TABLE NETFLIX.films(
   ID int NOT NULL AUTO_INCREMENT,
   realisateur VARCHAR(255) NOT NULL,
   acteur VARCHAR(255) NOT NULL,
   genres VARCHAR(255) NOT NULL,
   duree int NOT NULL,
   note double NOT NULL,
   parution date NOT NULL,
   titre VARCHAR(255) NOT NULL,
   synopsis VARCHAR(255) NOT NULL,
   video VARCHAR(255) NOT NULL,
   trailer VARCHAR(255) NOT NULL,
   PRIMARY KEY (ID)
);

CREATE TABLE NETFLIX.documentaires(
   ID int NOT NULL AUTO_INCREMENT,
   realisateur VARCHAR(255) NOT NULL,
   acteur VARCHAR(255) NOT NULL,
   genres VARCHAR(255) NOT NULL,
   duree int NOT NULL,
   note double NOT NULL,
   parution date NOT NULL,
   titre VARCHAR(255) NOT NULL,
   synopsis VARCHAR(255) NOT NULL,
   video VARCHAR(255) NOT NULL,
   trailer VARCHAR(255) NOT NULL,
   PRIMARY KEY (ID)
);

CREATE TABLE NETFLIX.series(
   ID int NOT NULL,
   realisateur VARCHAR(255) NOT NULL,
   acteur VARCHAR(255) NOT NULL,
   genres VARCHAR(255) NOT NULL,
   duree int NOT NULL,
   note double NOT NULL,
   parution date NOT NULL,
   titre VARCHAR(255) NOT NULL,
   synopsis VARCHAR(255) NOT NULL,
   video VARCHAR(255) NOT NULL,
   trailer VARCHAR(255) NOT NULL,
   nombre_saison int NOT NULL, 
   episode_en_cours int,
   PRIMARY KEY (ID)
);

CREATE TABLE NETFLIX.saisons(
   ID int NOT NULL AUTO_INCREMENT,
   serie int NOT NULL,
   num_saison int NOT NULL,
   nombre_episode int NOT NULL,
   PRIMARY KEY (ID),
   FOREIGN KEY (serie) REFERENCES series (ID)
);

CREATE TABLE NETFLIX.episodes(
   ID int NOT NULL AUTO_INCREMENT,
   saison int NOT NULL,
   realisateur VARCHAR(255) NOT NULL,
   acteur VARCHAR(255) NOT NULL,
   genres VARCHAR(255) NOT NULL,
   duree int NOT NULL,
   note double NOT NULL,
   parution date NOT NULL,
   titre VARCHAR(255) NOT NULL,
   synopsis VARCHAR(255) NOT NULL,
   video VARCHAR(255) NOT NULL,
   trailer VARCHAR(255),
   numero_episode int NOT NULL,
   PRIMARY KEY (ID), 
   FOREIGN KEY (saison) REFERENCES saisons (ID)
);

CREATE TABLE NETFLIX.membres(
   ID int NOT NULL AUTO_INCREMENT,
   nom VARCHAR(255) NOT NULL,
   prenom VARCHAR(255) NOT NULL,
   adresse_mail VARCHAR(255) NOT NULL,
   telephone BIGINT NOT NULL,
   num_carte BIGINT NOT NULL,  
   preferences VARCHAR(255) NOT NULL,
   mdp VARCHAR(255) NOT NULL,
   PRIMARY KEY (ID)
);

