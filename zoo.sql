
create database if not exists zoo;
use zoo;
drop table if exists pets;
drop table if exists commands_sets;
drop table if exists animals;
drop table if exists animal_types;



create table if not exists animal_types( 
id int auto_increment primary key, 
animal_type char(20)
);


create table if not exists animals  (
id int auto_increment primary key,
animal_name char(20),
 animal_type_id int,
 animal_kind char(20),
 foreign key (animal_type_id) references animal_types(id)
);

create table if not exists commands_sets(
animal_id int,
`bark` bit,
`gallop` bit,
`load` bit,
`meow` bit,
`say` bit,
`trot` bit,
foreign key (animal_id) references animals(id) on delete cascade
);
insert into animal_types(animal_type) values("pets"), ("pack's");
select * from animal_types;






