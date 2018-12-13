/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Dieval
 * Created: 22/10/2018
 */
create table genero (
   id serial not null primary key,
  nome varchar(60) not null );

create table musica (
  id serial not null primary key,
  titulo varchar(255) not null,
  letra clob not null default '',
  datacomposicao date not null,
  genero int not null references genero (id) on delete restrict on update cascade,
  tag varchar(255) not null,
  rank int(2) not null
);

create table tipomidia (
   id serial not null primary key,
   midia varchar(30) not null );

create table album (
   id serial not null primary key,
  titulo varchar(255) not null,
  genero int not null references genero (id) on delete restrict on update cascade,
  datalancamento date not null,
  tipomidia int not null references tipomidia (id) on delete restrict on update cascade,
   tempototal int not null default 0
);

create table faixa (
   albumid int not null references album (id) on delete cascade on update cascade,
   faixaordem int not null,
   musicaid int not null references musica (id) on delete cascade on update cascade,
  genero int not null references genero (id) on delete restrict on update cascade,
  duracao int not null,
  primary key (albumid,faixaordem)
);
