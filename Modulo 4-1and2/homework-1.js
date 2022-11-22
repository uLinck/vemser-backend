db.createCollection("alunos")

----------------------------------------------------

-- Insert 1;

db.alunos.insert (
    {
    "nome" : "Linck Schast",
    "data nascimento" : new Date(2003, 08, 11)
})

----------------------------------------------------

-- Insert 2;

db.alunos.insert (
    {
    "nome" : "Paulo Sergio",
    "data nascimento" : new Date(1999, 01, 23)
})

----------------------------------------------------

-- Insert 3;

db.alunos.insert (
    {
    "nome" : "Luiz Martins",
    "data nascimento" : new Date(1997, 04, 24)
})

----------------------------------------------------

-- Find 1;

db.alunos.find({
    "nome" : "Luiz Martins"
})

{ _id: ObjectId("6372cef22364aba07928f445"),
  nome: 'Luiz Martins',
  'data nascimento': 1997-05-24T03:00:00.000Z }

  ----------------------------------------------------

-- find 2;
  db.alunos.find({
    "nome" : "Linck Schast"
})

  { _id: ObjectId("6372cdd82364aba07928f443"),
  nome: 'Linck Schast',
  data_nascimento: 2003-09-11T03:00:00.000Z }

  ----------------------------------------------------

-- find 3;

  db.alunos.find({
    "nome" : "Paulo Sergio"
})

  { _id: ObjectId("6372ce052364aba07928f444"),
  nome: 'Paulo Sergio',
  data_nascimento: 1999-03-23T03:00:00.000Z }