
-- RIGHT OUTER JOIN ENTRE TABELA PESSOA E ENDERECO

SELECT * FROM PESSOA P
RIGHT OUTER JOIN CONTATO C 
ON (C.ID_PESSOA = C.ID_PESSOA)

-- RIGHT OUTER JOIN ENTRE PESSOA, PESSOA_X E ENDERECO_PESSOA

SELECT * FROM PESSOA P
RIGHT OUTER JOIN PESSOA_X_PESSOA_ENDERECO PX 
ON (PX.ID_PESSOA = P.ID_PESSOA)
RIGHT OUTER JOIN ENDERECO_PESSOA EP 
ON (EP.ID_ENDERECO = PX.ID_ENDERECO)

-- RIGHT OUTER JOIN ENTRE TODAS TABELAS

SELECT * FROM PESSOA P
RIGHT OUTER JOIN CONTATO C 
ON (C.ID_PESSOA = P.ID_PESSOA)
RIGHT OUTER JOIN PESSOA_X_PESSOA_ENDERECO PX 
ON (PX.ID_PESSOA = C.ID_PESSOA)
RIGHT OUTER JOIN ENDERECO_PESSOA EP 
ON (EP.ID_ENDERECO = PX.ID_ENDERECO)

-- OUTER FULL JOIN ENTRE TABELA PESSOA E CONTATO

SELECT * FROM PESSOA P
FULL OUTER JOIN CONTATO C 
ON (C.ID_PESSOA = P.ID_PESSOA)

-- OUTER FULL JOIN ENTRE TABELA PESSOA, PESSOA_X_PESSOA_ENDERECO E ENDERECO_PESSOA

SELECT * FROM PESSOA P
FULL OUTER JOIN PESSOA_X_PESSOA_ENDERECO PX 
ON (P.ID_PESSOA = PX.ID_PESSOA)
FULL OUTER JOIN ENDERECO_PESSOA EP
ON (EP.ID_ENDERECO = PX.ID_ENDERECO)

-- OUTER FULL JOIN ENTRE TODAS AS TABELAS

SELECT * FROM PESSOA P
FULL OUTER JOIN CONTATO C
ON (C.ID_PESSOA = P.ID_PESSOA)
FULL OUTER JOIN PESSOA_X_PESSOA_ENDERECO PX
ON (PX.ID_PESSOA = P.ID_PESSOA)
FULL OUTER JOIN ENDERECO_PESSOA EP 
ON (EP.ID_ENDERECO = PXPE.ID_ENDERECO)

-- SELECIONANDO AS PESSOAS QUE TEM ENDERECO COM 0 EXISTS

SELECT PESSOA.NOME FROM PESSOA P
WHERE EXISTS (SELECT 1 FROM PESSOA_X_PESSOA_ENDERECO PX WHERE P.ID_PESSOA = PX.ID_PESSOA AND PX.ID_ENDERECO IS NOT NULL);

-- SELECIONANDO ID E NOME DA TABELA PESSOA / ID E LOGRADOURO DA TABELA ENDERECO

SELECT ID_PESSOA, NOME
FROM PESSOA 
UNION SELECT id_endereco, logradouro
FROM ENDERECO_PESSOA;
