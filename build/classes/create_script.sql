create table Admin(
nome varchar2(30) not null,
cognome varchar2(30) not null,
codAdmin int,
passAdmin varchar2(2000) not null,
constraint p_codAdmin primary key(codAdmin));

create table Corsista(
nome varchar2(30) not null,
cognome varchar2(30) not null,
codCorsista int,
precedentiFormativi CHAR(1),
constraint p_codCorsista primary key(codCorsista),
check(precedentiFormativi = 'T' or precedentiFormativi = 'F'));

create table Docente(
nome varchar2(30) not null,
cognome varchar2(30) not null,
cv varchar2(500) not null,
codDocente int,
constraint p_codDocente primary key(codDocente));

create table Corso(
nomeCorso varchar2(30) not null,
inizio Date not null,
fine Date not null,
costo number(7,2) not null,
commenti varchar2(500),
aula varchar2(30),
codDocente int,
codCorso int,
constraint p_codCorso primary key(codCorso),
constraint f_codDocente foreign key(codDocente) references docente(codDocente) on delete cascade);

create table Iscrizione(
codCorso int,
codCorsista int,
constraint p_iscrizione primary key (codCorso, codCorsista),
constraint f_codCorso foreign key(codCorso) references corso(codCorso) on delete cascade,
constraint f_codCorsista foreign key(codCorsista) references corsista(codCorsista) on delete cascade);


create sequence corsista_seq;
create sequence corso_seq;
















