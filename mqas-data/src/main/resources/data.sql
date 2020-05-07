insert into privilege (name) values ('READ_PRIVILEGE');
insert into privilege (name) values ('WRITE_PRIVILEGE');
insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_USER');
insert into role_privilege (role_id, privilege_id) select r.Id, p.Id from role r, privilege p where r.name = 'ROLE_USER' and p.name = 'WRITE_PRIVILEGE';
insert into role_privilege (role_id, privilege_id) select r.Id, p.Id from role r, privilege p where r.name = 'ROLE_ADMIN' and p.name = 'READ_PRIVILEGE';
insert into role_privilege (role_id, privilege_id) select r.Id, p.Id from role r, privilege p where r.name = 'ROLE_USER' and p.name = 'READ_PRIVILEGE';

