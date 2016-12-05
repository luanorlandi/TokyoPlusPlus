/* -----------------------------------------------
	esporte
----------------------------------------------- */
insert into esporte
  (nomeEsporte, unidade)
  values
  ('futebol', 'inteiro');

insert into esporte
  (nomeEsporte, unidade)
  values
  ('corrida', 'tempo');

insert into esporte
  (nomeEsporte, unidade)
  values
  ('natação', 'tempo');

/* -----------------------------------------------
	modalidade
----------------------------------------------- */

insert into modalidade
  (nomeModalidade, numeroMaximoAtletas, categoria, nomeEsporte)
  values
  ('100m', 8, 'masculino', 'corrida');

insert into modalidade
  (nomeModalidade, numeroMaximoAtletas, categoria, nomeEsporte)
  values
  ('200m', 10, 'masculino', 'corrida');

insert into modalidade
  (nomeModalidade, numeroMaximoAtletas, categoria, nomeEsporte)
  values
  ('100m', 8, 'feminino', 'natação');

insert into modalidade
  (nomeModalidade, numeroMaximoAtletas, categoria, nomeEsporte)
  values
  ('200m', 10, 'misto', 'natação');