/* -----------------------------------------------
	esporte
----------------------------------------------- */

create table esporte(
  nomeEsporte varchar2(100),
  unidade varchar2(10),
  
  constraint esporte_pk primary key (nomeEsporte)
);

/* -----------------------------------------------
	modalidade
----------------------------------------------- */

create table modalidade(
  nomeModalidade varchar2(100),
  numeroMaximoAtletas number(3),  /* 1 to 100 */
  categoria varchar2(10) not null,
  nomeEsporte varchar2(100),
  
  constraint modalidade_pk
    primary key (nomeModalidade, nomeEsporte),
  
  constraint categoria_check
    check(categoria = 'masculino' or
    categoria = 'feminino' or
    categoria = 'misto'),
    
  constraint nomeEsporte_fk
    foreign key (nomeEsporte)
    references esporte (nomeEsporte)
);