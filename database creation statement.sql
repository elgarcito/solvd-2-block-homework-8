/* creating database statements */
CREATE DATABASE IF NOT EXISTS solvd_essay;

SET SQL_SAFE_UPDATES = 0;

/*Wrong database creation*/
CREATE DATABASE IF NOT EXISTS solvd_essay2;
USE solvd_essay;

/* creating table statements */
create table if not exists essay_module (
id serial,
module_description varchar(45) not null,
primary key (id)
);

/* creating table statements */
create table if not exists equipment_for_test_model (
id serial,
model_name varchar(10) not null unique,
model_description varchar(50),
primary key (id)
);

/*Duplicate table by error drop it later*/
create table if not exists equipment_for_test_model2 ( 
id serial,
model_name varchar(10) not null unique,
model_description varchar(50),
primary key (id)
);

/* creating table statements */
create table if not exists batch_info(
id serial,
batch_number varchar(10) not null,
primary key (id)
);
/* creating table statements */
create table if not exists laboratory_tool (
id serial,
tool_name varchar(30) not null unique,
tool_description varchar(50),
primary key (id)
);
/* creating table statements */
create table if not exists employee_work_area(
id serial,
area_name varchar(45) not null unique,
primary key (id)
);
/* creating table statements */
create table if not exists temperature_essay(
id serial,
front_measurement double not null,
right_side_measurement double,
essay_result boolean not null,
lab_test_report_id bigint unsigned not null unique,
primary key (id)
);


create table if not exists energy_efficiency_essay(
id serial,
energy_efficiency double not null,
category varchar(10) not null,
essay_result boolean not null,
lab_test_report_id bigint unsigned not null unique,
primary key (id)
);

create table if not exists gas_consumption_essay(
id serial,
max_consume double not null,
standard_mean double not null,
measurement_error double not null,
essay_result boolean not null,
lab_test_report_id bigint unsigned not null unique,
primary key (id)
);


/* creating table statements */
create table if not exists employee(
id serial,
first_name varchar(20) not null,
last_name varchar(20) not null,
personal_id varchar(20) not null unique,
birth_date date not null,
salary double not null,
primary key (id)
);


/* creating table statements */
create table if not exists lab_test_report(
id serial,
essay_code varchar(30) not null unique,
date_of_essay date not null,
essay_description varchar(100) not null,
equipment_for_test_model_id bigint unsigned not null,
batch_info_id bigint unsigned not null,
employee_id bigint unsigned ,
essay_module_id bigint unsigned not null,
primary key (id)
);


/*Adding constrains to essay tables*/
alter table temperature_essay
add constraint fk_temperature_essay_lab_test_report 
foreign key (lab_test_report_id) references lab_test_report (id) on update  no action on delete cascade;

alter table energy_efficiency_essay
add constraint fk_energy_efficiency_essay_lab_test_report 
foreign key (lab_test_report_id) references lab_test_report (id) on update  no action on delete cascade;

alter table gas_consumption_essay
add constraint fk_gas_consumption_essay_lab_test_report 
foreign key (lab_test_report_id) references lab_test_report (id) on update  no action on delete cascade;


/*Creating intermediate tables*/
create table if not exists employee_employee_work_areas(
id serial,
employee_id bigint unsigned not null,
employee_work_area_id bigint unsigned not null
);


create table if not exists employee_laboratory_tools(
id serial,
employee_id bigint unsigned not null,
laboratory_tool_id bigint unsigned not null
);



/*Adding constrains to intermediate tables*/
alter table employee_employee_work_areas
add constraint fk_employee_employee_work_areas_employee
foreign key (employee_id) references employee (id) on update no action on delete cascade,
add constraint fk_employee_employee_work_areas_employee_work_area
foreign key (employee_work_area_id) references employee_work_area (id) on update no action on delete cascade;

alter table employee_employee_work_areas
add primary key(employee_work_area_id,employee_id);


alter table employee_laboratory_tools
add constraint fk_employee_laboratory_tools_employee
foreign key (employee_id) references employee (id) on update no action on delete cascade,
add constraint fk_employee_laboratory_tools_laboratory_tool
foreign key (laboratory_tool_id) references laboratory_tool (id) on update no action on delete cascade;

alter table employee_laboratory_tools
add primary key(laboratory_tool_id,employee_id);


/*adding constrains to lab_test_report */
alter table lab_test_report
add constraint fk_lab_test_report_batch_info
foreign key (batch_info_id) references batch_info(id) on update no action on delete no action,
add constraint fk_lab_test_report_employee
foreign key (employee_id) references employee(id) on update no action on delete set null,
add constraint fk_lab_test_report_essay_module
foreign key (essay_module_id) references essay_module(id) on update no action on delete cascade,
add constraint fk_lab_test_report_equipment_for_test_model
foreign key (equipment_for_test_model_id) references equipment_for_test_model(id) on update no action on delete no action;

