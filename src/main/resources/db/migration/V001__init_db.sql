create schema if not exists my_person;

create sequence if not exists my_person.my_person_id_seq;

create table if not exists my_person.person(
                                              id integer not null default nextval('my_person.my_person_id_seq') primary key,
                                              name text not null,
                                              surname text not null
);
