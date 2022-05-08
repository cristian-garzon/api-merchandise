-- insert job positions
insert into job_position (name) values ('Asesor de Ventas');
insert into job_position (name) values ('administrador');
insert into job_position (name) values ('soporte');


-- insert employees
insert into employee (age, enter_date_company, name, id_job_position) values (19, now(), 'cristian', 2);
insert into employee (age, enter_date_company, name, id_job_position) values (19, now(), 'camilo', 1);


-- insert merchandise
insert into merchandise (enter_date, product_name, quantity, id_employee)  values (now(), 'motor 0.9 Turbo TwinAir', 3, 1);
insert into merchandise (enter_date, product_name, quantity, id_employee)  values (now(), 'motor 2.5 TFSI', 1, 2);
insert into merchandise (enter_date, product_name, quantity, id_employee)  values (now(), 'motor 1.5 EcoBoost', 1, 2);
insert into merchandise (enter_date, product_name, quantity, id_employee)  values (now(), '8 cilindros: motor 3.9 V8', 5, 2);
insert into merchandise (enter_date, product_name, quantity, id_employee)  values (now(), '8 cilindros: motor 4.0 V8', 2, 1);

