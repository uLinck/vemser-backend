CREATE TABLE VEM_SER.ESTUDANTE(
                                  id NUMBER PRIMARY KEY,
                                  nome VARCHAR2(200) NOT NULL,
                                  data_nascimento DATE NOT NULL,
                                  nr_matricula NUMBER(10) UNIQUE NOT NULL,
                                  ativo CHAR
);

CREATE SEQUENCE VEM_SER.SEQ_ESTUDANTE
    START WITH 1
    INCREMENT BY 1
    NOCACHE NOCYCLE;

INSERT INTO VEM_SER.ESTUDANTE
(id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.NEXTVAL, 'Gustavo', TO_DATE('11-08-2003','dd-mm-yyyy'), 1, 'N');

INSERT INTO VEM_SER.ESTUDANTE
(id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.NEXTVAL, 'Rafael', TO_DATE('06-09-2003','dd-mm-yyyy'), 2, 'S');

INSERT INTO VEM_SER.ESTUDANTE
(id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.NEXTVAL, 'Bruno', TO_DATE('20-03-2003','dd-mm-yyyy'), 3, 'N');

INSERT INTO VEM_SER.ESTUDANTE
(id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.NEXTVAL, 'Guilherme', TO_DATE('13-05-2003','dd-mm-yyyy'), 4, 'S');

INSERT INTO VEM_SER.ESTUDANTE
(id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.NEXTVAL, 'Enzo', TO_DATE('22-04-2003','dd-mm-yyyy'), 5, 'N');

INSERT INTO VEM_SER.ESTUDANTE
(id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.NEXTVAL, 'Lucas', TO_DATE('23-08-2003','dd-mm-yyyy'), 6, 'S');

INSERT INTO VEM_SER.ESTUDANTE
(id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.NEXTVAL, 'Ana', TO_DATE('11-02-2003','dd-mm-yyyy'), 7, 'N');

INSERT INTO VEM_SER.ESTUDANTE
(id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.NEXTVAL, 'Amanda', TO_DATE('26-09-2003','dd-mm-yyyy'), 8, 'S');

INSERT INTO VEM_SER.ESTUDANTE
(id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.NEXTVAL, 'Jacinto P.', TO_DATE('05-12-2003','dd-mm-yyyy'), 9, 'N');

INSERT INTO VEM_SER.ESTUDANTE
(id, nome, data_nascimento, nr_matricula, ativo)
VALUES(SEQ_ESTUDANTE.NEXTVAL, 'Maicon', TO_DATE('08-09-2003','dd-mm-yyyy'), 10, 'S');

SELECT * FROM ESTUDANTE;
