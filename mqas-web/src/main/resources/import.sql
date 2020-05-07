SET search_path TO mqas_test;

insert into privilege (id, name) values (nextval('hibernate_sequence'),'READ_PRIVILEGE');
insert into privilege (id, name) values (nextval('hibernate_sequence'),'WRITE_PRIVILEGE');
insert into role (id, name) values (nextval('hibernate_sequence'),'ROLE_ADMIN');
insert into role (id, name) values (nextval('hibernate_sequence'),'ROLE_USER');
insert into role_privilege (role_id, privilege_id) select r.Id, p.Id from role r, privilege p where r.name = 'ROLE_USER' and p.name = 'WRITE_PRIVILEGE';
insert into role_privilege (role_id, privilege_id) select r.Id, p.Id from role r, privilege p where r.name = 'ROLE_ADMIN' and p.name = 'READ_PRIVILEGE';
insert into role_privilege (role_id, privilege_id) select r.Id, p.Id from role r, privilege p where r.name = 'ROLE_USER' and p.name = 'READ_PRIVILEGE';

INSERT INTO access_level(id, description, name, req_per_minute, total_req, price) VALUES (nextval('hibernate_sequence'), 'For Large Businesses', 'Large', 500, 5000000, 249.56);
INSERT INTO access_level(id, description, name, req_per_minute, total_req, price) VALUES (nextval('hibernate_sequence'), 'For Medium Businesses', 'Big', 50, 50000, 185.25);
INSERT INTO access_level(id, description, name, req_per_minute, total_req, price) VALUES (nextval('hibernate_sequence'), 'For Small Businesses', 'Small', 5, 5000, 119.89);