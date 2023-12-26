/*Update statements*/
/*On lab_test_report*/
update lab_test_report
set essay_description="Big equipment gas compsumption essay"
where id=1;

update lab_test_report
set essay_code="EA7"
where id=7;

update equipment_for_test_model
set release_date= "2023-01-01"
where release_date is null;


update temperature_essay
set left_side_measurement=0
where null;

update employee_work_area
set area_code="01-area A"
where id=1;

update employee_work_area
set area_code="02-area B"
where id=2;

update lab_test_report
set essay_module_id=2
where id=2;

update equipment_for_test_model
set model_description="Medium size equipment"
where id=3;

update employee_work_area
set area_name="Line production"
where id=2;

update employee_work_area
set area_name="Essay Laboratory"
where id=3;

update temperature_essay
set left_side_measurement=0.0
where left_side_measurement is null;


/*Deletion staments*/
/*Administration has no relevance here*/
delete from employee_work_area
where id=1;

delete from equipment_for_test_model
where model_name="model 4";

delete from laboratory_tool
where tool_name="termometer2";

delete from lab_test_report
where id=8;

delete from laboratory_tool
where id>3 and id<5;

drop table equipment_for_test_model2;

drop schema solvd_essay2;

delete from lab_test_report
where employee_id=3;

delete from employee
where id=3;

delete from essay_module
where id=4;