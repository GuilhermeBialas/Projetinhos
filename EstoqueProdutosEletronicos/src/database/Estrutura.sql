/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guilherme Bialas
 * Created: 12/10/2018
 */

DROP DATABASE IF EXISTS produtos;
CREATE DATABASE produtos;
USE produtos;

CREATE TABLE produtos(
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(200),
quantidade INT,
peso DOUBLE,
categoria VARCHAR(200)
);

INSERT INTO produtos(id, nome, quantidade, peso, categoria)VALUES
(1,"ps4",1,2.5,"video_games");