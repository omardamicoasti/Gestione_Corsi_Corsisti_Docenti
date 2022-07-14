insert into Admin values('Zaia', 'Ghianda', '00001','b0Rd%k0aZ$!f?s39vA#a£@d72Rd%k0aZ$!f?s39vA#a£@d743Rd%k0aZ$!f?s39vA#a£@d7bRd%k0aZ$!f?s39vA#a£@d7abRd%k0aZ$!f?s39vA#a£@d7fRd%k0aZ$!f?s39vA#a£@d7b3Rd%k0aZ$!f?s39vA#a£@d796Rd%k0aZ$!f?s39vA#a£@d76dRd%k0aZ$!f?s39vA#a£@d7e2Rd%k0aZ$!f?s39vA#a£@d799Rd%k0aZ$!f?s39vA#a£@d789Rd%k0aZ$!f?s39vA#a£@d73Rd%k0aZ$!f?s39vA#a£@d776Rd%k0aZ$!f?s39vA#a£@d72Rd%k0aZ$!f?s39vA#a£@d79Rd%k0aZ$!f?s39vA#a£@d7');

insert into Corsista values('Mario', 'Rossi', corsista_seq.nextval, 'T');
insert into Corsista values('Luca', 'Verdi', corsista_seq.nextval, 'T');
insert into Corsista values('Matteo', 'Bianchi', corsista_seq.nextval, 'F');
insert into Corsista values('Marco', 'Rosa', corsista_seq.nextval, 'T');
insert into Corsista values('Giovanni', 'Blu', corsista_seq.nextval, 'F');
insert into Corsista values('Matteo', 'Gialli', corsista_seq.nextval, 'T');
insert into Corsista values('Nicola', 'Secchio', corsista_seq.nextval, 'F');
insert into Corsista values('Francesco', 'Castello', corsista_seq.nextval, 'F');
insert into Corsista values('Barbara', 'Cecchetto', corsista_seq.nextval, 'T');


insert into Docente values('Marina', 'Marietti', 'CV Buono', '00001');
insert into Docente values('Piera', 'Pierini', 'CV Ottimo', '00002');
insert into Docente values('Antonietta', 'Antonelli', 'CV Eccellente', '00003');
insert into Docente values('Giuseppe', 'Beppi', 'CV Distinto', '00004');
insert into Docente values('Sandro', 'Sandroni', 'CV Decente', '00005');


insert into Corso values('Matematica', '18-MAG-2022', '30-DIC-2022', 99.80, 'Commento interessante','Aula B', 1, corso_seq.nextval);
insert into Corso values('Geografia', '18-MAG-2022', '30-DIC-2022', 99.80, 'Commento interessante','Aula C', 2, corso_seq.nextval);
insert into Corso values('Storia', '18-MAG-2022', '30-DIC-2022', 99.80, 'Commento interessante','Aula Zaia', 2, corso_seq.nextval);
insert into Corso values('Informatica', '9-SET-2022', '31-DIC-2022', 99.80, 'Commento interessante','Aula Zaia', 2, corso_seq.nextval);
insert into Corso values('Sistemi', '9-SET-2022', '01-DIC-2022', 99.80, 'Commento interessante','Aula Zaia', 2, corso_seq.nextval);
insert into Corso values('Chimica', '11-SET-2022', '02-DIC-2022', 99.80, 'Commento interessante','Aula Zaia', 2, corso_seq.nextval);
insert into Corso values('Fisica', '30-SET-2022', '05-DIC-2022', 99.80, 'Commento interessante','Aula Zaia', 2, corso_seq.nextval);

insert into Iscrizione values(2,2);
insert into Iscrizione values(2,3);
insert into Iscrizione values(2,4);

insert into Iscrizione values(1,3);
insert into Iscrizione values(3,3);
insert into Iscrizione values(4,3);
insert into Iscrizione values(5,3);
insert into Iscrizione values(6,3);

commit