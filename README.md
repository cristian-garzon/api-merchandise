# api-merchandise

por favor, en el motor de base de datos de postbres, correr la siguiente linea
```sql
create database merchandise
```

ahora vamos a ir al application.propertiews y vamos a colocar nuestro usuario y nuestra contraseña, acto seguido corremos el programa.

ahora vamos a ejecutar los siguientes inserts para tener los cargos posibles, y los empleados

```sql
-- insert job positions
insert into job_position (name) values ('Asesor de Ventas');
insert into job_position (name) values ('administrador');
insert into job_position (name) values ('soporte');


-- insert employees
insert into employee (age, enter_date_company, name, id_job_position) values (19, now(), 'cristian', 2);
insert into employee (age, enter_date_company, name, id_job_position) values (19, now(), 'camilo', 1);
```

para usar la api sin necesitad de usar la aplicación, podemos ir a la documentación del swagger que estará en 
http://localhost:8080/swagger-ui.html

![image text](https://github.com/cristian-garzon/evidencias/blob/main/WhatsApp%20Image%202022-05-07%20at%203.08.52%20AM.jpeg)
