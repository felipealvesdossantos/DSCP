CREATE TABLE niveis(
idNivel INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
descricao VARCHAR(50) UNIQUE
);

CREATE TABLE classes(
idClasse INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
tipo VARCHAR(10),
descricao VARCHAR(100)
);

CREATE TABLE docentes(
idDocente INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
nome VARCHAR(50)
);

CREATE TABLE docentesclasses(
idDocenteClasse INT AUTO_INCREMENT PRIMARY KEY, 
fk_idDocente INT, 
fk_idClasse INT,
FOREIGN KEY(fk_idDocente) REFERENCES docentes(idDocente) ON DELETE CASCADE,
FOREIGN KEY(fk_idClasse) REFERENCES classes(idClasse) ON DELETE CASCADE
);

CREATE TABLE classesniveis(
idClassesNiveis INT AUTO_INCREMENT PRIMARY KEY, 
fk_idClasse INT,
fk_idNivel INT,
FOREIGN KEY(fk_idClasse) REFERENCES classes(idClasse) ON DELETE CASCADE,
FOREIGN KEY(fk_idNivel) REFERENCES niveis(idNivel) ON DELETE CASCADE
);

INSERT INTO niveis(descricao) VALUES('Nivel1');
INSERT INTO niveis(descricao) VALUES('Nivel2');
INSERT INTO niveis(descricao) VALUES('Nivel3');
INSERT INTO niveis(descricao) VALUES('Nivel4');

INSERT INTO classes(tipo, descricao) VALUES('A', 'Docente Adjunto');
INSERT INTO classes(tipo, descricao) VALUES('A', 'Docente Assistente');
INSERT INTO classes(tipo, descricao) VALUES('A', 'Docente Auxiliar');
INSERT INTO classes(tipo, descricao) VALUES('B', 'Docente Assistente');
INSERT INTO classes(tipo, descricao) VALUES('C', 'Docente Adjunto');
INSERT INTO classes(tipo, descricao) VALUES('D', 'Docente Associado');
INSERT INTO classes(tipo, descricao) VALUES('E', 'Docente Titular');

INSERT INTO docentes(nome) VALUES('Fabio Nogueira');
INSERT INTO docentes(nome) VALUES('Ricardo Rocha');
INSERT INTO docentes(nome) VALUES('Marcelo Quinta');
INSERT INTO docentes(nome) VALUES('Marcelo Aquira');
INSERT INTO docentes(nome) VALUES('Renado Bulcão');

INSERT INTO docentesclasses(fk_idDocente, fk_idClasse) VALUES((SELECT idDocente FROM docentes where upper(nome) =upper('Fabio Nogueira')),(SELECT idClasse FROM classes WHERE upper(tipo)=upper('B')));
INSERT INTO docentesclasses(fk_idDocente, fk_idClasse) VALUES((SELECT idDocente FROM docentes where upper(nome) =upper('Fabio Nogueira')),(SELECT idClasse FROM classes WHERE upper(tipo)=upper('C')));
INSERT INTO docentesclasses(fk_idDocente, fk_idClasse) VALUES((SELECT idDocente FROM docentes where upper(nome) =upper('Ricardo Rocha')),(SELECT idClasse FROM classes WHERE upper(tipo)=upper('D')));
INSERT INTO docentesclasses(fk_idDocente, fk_idClasse) VALUES((SELECT idDocente FROM docentes where upper(nome) =upper('Ricardo Rocha')),(SELECT idClasse FROM classes WHERE upper(tipo)=upper('E')));
INSERT INTO docentesclasses(fk_idDocente, fk_idClasse) VALUES((SELECT idDocente FROM docentes where upper(nome) =upper('Marcelo Quinta')),(SELECT idClasse FROM classes WHERE upper(tipo)=upper('A') AND upper(descricao)=upper('Docente Assistente')));
INSERT INTO docentesclasses(fk_idDocente, fk_idClasse) VALUES((SELECT idDocente FROM docentes where upper(nome) =upper('Marcelo Quinta')),(SELECT idClasse FROM classes WHERE upper(tipo)=upper('E')));
INSERT INTO docentesclasses(fk_idDocente, fk_idClasse) VALUES((SELECT idDocente FROM docentes where upper(nome) =upper('Marcelo Aquira')),(SELECT idClasse FROM classes WHERE upper(tipo)=upper('B')));
INSERT INTO docentesclasses(fk_idDocente, fk_idClasse) VALUES((SELECT idDocente FROM docentes where upper(nome) =upper('Marcelo Aquira')),(SELECT idClasse FROM classes WHERE upper(tipo)=upper('C')));
INSERT INTO docentesclasses(fk_idDocente, fk_idClasse) VALUES((SELECT idDocente FROM docentes where upper(nome) =upper('Renado Bulcão')),(SELECT idClasse FROM classes WHERE upper(tipo)=upper('D')));
INSERT INTO docentesclasses(fk_idDocente, fk_idClasse) VALUES((SELECT idDocente FROM docentes where upper(nome) =upper('Renado Bulcão')),(SELECT idClasse FROM classes WHERE upper(tipo)=upper('A') AND upper(descricao)=upper('Docente Auxiliar')));

INSERT INTO classesniveis(fk_idClasse,fk_idNivel) VALUES((SELECT idClasse FROM classes WHERE upper(tipo)=upper('B')), (SELECT idNivel FROM niveis WHERE upper(descricao) = upper('Nivel1')));
INSERT INTO classesniveis(fk_idClasse,fk_idNivel) VALUES((SELECT idClasse FROM classes WHERE upper(tipo)=upper('C')), (SELECT idNivel FROM niveis WHERE upper(descricao) = upper('Nivel4')));
INSERT INTO classesniveis(fk_idClasse,fk_idNivel) VALUES((SELECT idClasse FROM classes WHERE upper(tipo)=upper('D')), (SELECT idNivel FROM niveis WHERE upper(descricao) = upper('Nivel3')));
INSERT INTO classesniveis(fk_idClasse,fk_idNivel) VALUES((SELECT idClasse FROM classes WHERE upper(tipo)=upper('E')), (SELECT idNivel FROM niveis WHERE upper(descricao) = upper('Nivel1')));
INSERT INTO classesniveis(fk_idClasse,fk_idNivel) VALUES((SELECT idClasse FROM classes WHERE upper(tipo)=upper('A') AND upper(descricao)=upper('Docente Assistente')), (SELECT idNivel FROM niveis WHERE upper(descricao) = upper('Nivel2')));
INSERT INTO classesniveis(fk_idClasse,fk_idNivel) VALUES((SELECT idClasse FROM classes WHERE upper(tipo)=upper('E')), (SELECT idNivel FROM niveis WHERE upper(descricao) = upper('Nivel1')));
INSERT INTO classesniveis(fk_idClasse,fk_idNivel) VALUES((SELECT idClasse FROM classes WHERE upper(tipo)=upper('B')), (SELECT idNivel FROM niveis WHERE upper(descricao) = upper('Nivel2')));
INSERT INTO classesniveis(fk_idClasse,fk_idNivel) VALUES((SELECT idClasse FROM classes WHERE upper(tipo)=upper('C')), (SELECT idNivel FROM niveis WHERE upper(descricao) = upper('Nivel4')));
INSERT INTO classesniveis(fk_idClasse,fk_idNivel) VALUES((SELECT idClasse FROM classes WHERE upper(tipo)=upper('D')), (SELECT idNivel FROM niveis WHERE upper(descricao) = upper('Nivel2')));
INSERT INTO classesniveis(fk_idClasse,fk_idNivel) VALUES((SELECT idClasse FROM classes WHERE upper(tipo)=upper('A') AND upper(descricao)=upper('Docente Auxiliar')), (SELECT idNivel FROM niveis WHERE upper(descricao) = upper('Nivel1')));

