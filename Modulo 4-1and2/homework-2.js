--------------------------------------
-- Passar para a db do geekers
use Geekers

--------------------------------------

-- Insert Usuarios

db.usuario.insert(
  [
    {
        "login": "teste",
        "senha": "$2a$10$7F9XDalCdCCW594j2k6INuySaL9iDgwmAEbYjyBRy.0YAJputZdmK",
        "nome": "Felipe Noguez",
        "email": "felipenoguez@mail.com",
        "telefone": "+555198778545",
        "dataNascimento": "2002-02-02",
        "sexo": "M"
      },
      {
        "login": "kaio",
        "senha": "$2a$10$CO0JT4SDek5ILSmqsN3VaeE8/Y9aAIsYyi9lqZQ89HZXzejc2CGci",
        "nome": "kaio adm",
        "email": "kaioaar@gmail.com",
        "telefone": "+555198778545",
        "dataNascimento": "2002-02-02",
        "sexo": "M"
      },
      {
        "login": "diabetico",
        "senha": "$2a$10$YsklO7EHK3eRoTgZ4PG8K.cG8tIwahh/53UKJxKQPPBTm9yZ.6tKS",
        "nome": "Ricardo Langbecker",
        "email": "rlangbecker.dev@gmail.com",
        "telefone": "+555198778545",
        "dataNascimento": "2002-02-02",
        "sexo": "M"
      },
      {
        "login": "Linck",
        "senha": "$2a$10$Yv6RQV8.gNEeMu8LlgY83OiGYHmIuyn3P9.M3hRabDrPtUxKOE2yi",
        "nome": "Gustavo Linck",
        "email": "linck.privado@gmail.com",
        "telefone": "+555198778545",
        "dataNascimento": "2002-02-02",
        "sexo": "M"
      },
      {
        "login": "AlissonDelas",
        "senha": "$2a$10$ZbetHox/TQbVN.VFPPdGK.voSFog8saVpgindXJ0QdawW.47S5kXu",
        "nome": "Alisson Silva",
        "email": "AlissonSilva@mail.com",
        "telefone": "+555198778545",
        "dataNascimento": "2002-02-02",
        "sexo": "M"
      },
      {
        "login": "omeu",
        "senha": "$2a$10$pr3GGBQ/L2j.FbBM.FGQAO.iuSb036CJcfblXGA/Aghl8JjINsY7m",
        "nome": "Luiz Martins",
        "email": "Luiz_o_meu@mail.com",
        "telefone": "+555198778545",
        "dataNascimento": "2002-02-02",
        "sexo": "M"
      },
      {
        "login": "juliao",
        "senha": "$2a$10$FqywZGXXDOoHQaon2rTX9.Sz7elqANhZa2xRz.GH.lXkbkCFZXhpi",
        "nome": "Julio Rocha",
        "email": "julio_rocha@mail.com",
        "telefone": "+555198778545",
        "dataNascimento": "2002-02-02",
        "sexo": "M"
      },
      {
        "login": "Noah",
        "senha": "$2a$10$BrGAPAieKWAPvenKfh0RSOP6D6tywpSi3CC3vhfAxwXDUHVYauCAW",
        "nome": "Noah Bispo",
        "email": "noah.bispo@gmail.com",
        "telefone": "+555198772233",
        "dataNascimento": "2002-02-02",
        "sexo": "M"
      },
      {
        "login": "noah",
        "senha": "$2a$10$Gvx0A1P2vvkAiYPkJBmbcOLedm3iafWyxlHrZSL7qjy1nuUOzFcFC",
        "nome": "Felipe Noguez",
        "email": "noguez.felipe@gmail.com",
        "telefone": "+555198778545",
        "dataNascimento": "2002-02-02",
        "sexo": "M"
      }
]
)

--------------------------------------

-- Find 1:

db.usuarios.find(
  {
    "nome" : "Gustavo Linck"
  }
)

-- Resultado:

{ 
  _id: ObjectId("6372d4a6bedd9586eeaf5f8d"),
  login: 'Linck',
  senha: '$2a$10$Yv6RQV8.gNEeMu8LlgY83OiGYHmIuyn3P9.M3hRabDrPtUxKOE2yi',
  nome: 'Gustavo Linck',
  email: 'linck.privado@gmail.com',
  telefone: '+555198778545',
  dataNascimento: '2002-02-02',
  sexo: 'M'
 }

 --------------------------------------

-- Find 2:

 db.usuarios.find(
  {
    "nome" : "Ricardo Langbecker"
  }
)

-- Resultado:

{ 
  _id: ObjectId("6372d4a6bedd9586eeaf5f8c"),
  login: 'diabetico',
  senha: '$2a$10$YsklO7EHK3eRoTgZ4PG8K.cG8tIwahh/53UKJxKQPPBTm9yZ.6tKS',
  nome: 'Ricardo Langbecker',
  email: 'rlangbecker.dev@gmail.com',
  telefone: '+555198778545',
  dataNascimento: '2002-02-02',
  sexo: 'M' 
}

--------------------------------------