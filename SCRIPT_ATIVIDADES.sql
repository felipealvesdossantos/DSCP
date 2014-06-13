CREATE TABLE areas(
idArea INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
codArea VARCHAR(5) UNIQUE,
descricao VARCHAR(100),
fk_idArea INT
);

CREATE TABLE atividades(
idAtividade INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
codAtividade VARCHAR(5) UNIQUE,
descricao VARCHAR(100),
pontos INT,
fk_idAtividade INT,
fk_idFormula INT
);

CREATE TABLE formulas(
idFormula INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
descricao VARCHAR(200)
);

CREATE TABLE areasAtividades(
idAreasAtividades INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
fk_idArea INT,
fk_idAtividade INT,
FOREIGN KEY(fk_idArea) REFERENCES areas(idArea) ON DELETE CASCADE,
FOREIGN KEY(fk_idAtividade) REFERENCES atividades(idAtividade) ON DELETE CASCADE
);


