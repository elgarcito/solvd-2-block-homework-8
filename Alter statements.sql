/*Alter statements*/
/*On energy_efficiency table alter column description*/
alter table energy_efficiency_essay
change energy_efficiency value_of_essay double;

alter table employee_work_area
add column area_code varchar(10);

alter table temperature_essay
drop column right_side_measurement;

alter table temperature_essay
add column left_side_measurement double;

alter table equipment_for_test_model
add column release_date date;