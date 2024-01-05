/*Insert statement*/
/*batch_info table insertion*/
insert into batch_info (batch_number)
value ("PR1001");

insert into batch_info (batch_number)
value ("PR1002");

/*Bad batch delete all essays*/
insert into batch_info (batch_number)
value ("PR1003");


/*employee table insertion*/
insert into employee(first_name, last_name,personal_id,birth_date,salary)
values ("john", "smith","Abc123","2000-12-15",1000);

insert into employee(first_name, last_name,personal_id,birth_date,salary)
values ("mary", "jane","def236","2000-05-15",1200);

/*all the essays of this employee must be erased*/
insert into employee(first_name, last_name,personal_id,birth_date,salary)
values ("julian", "jhonson","Abc236","2000-8-15",1800);


/*employee_work_area table insertion*/
insert into employee_work_area (area_name)
value("administration");

insert into employee_work_area (area_name)
value("production");

insert into employee_work_area (area_name)
value("laboratory");

/*laboratory_tool table insertion*/
insert into solvd_essay.laboratory_tool (tool_name,tool_description)
values("gas reader","0.1 m^3 precition gas reader");

insert into solvd_essay.laboratory_tool (tool_name,tool_description)
values("termometer1","100°C termometer");

insert into laboratory_tool (tool_name,tool_description)
values("termometer2","100°C termometer broken-not used anymore");

insert into laboratory_tool (tool_name,tool_description)
values("gas reader2","temperature");/*delete description is wrong and we have no data of it*/

/*employee_laboratory_tools table insertion*/
insert into employee_laboratory_tools (employee_id, laboratory_tool_id)
values(1,1);

insert into employee_laboratory_tools (employee_id, laboratory_tool_id)
values(1,2);

insert into employee_laboratory_tools (employee_id, laboratory_tool_id)
values(2,2);


/*employee_employee_work_areas table insertion*/

insert into employee_employee_work_areas (employee_id, employee_work_area_id)
values(1,2);

insert into employee_employee_work_areas (employee_id, employee_work_area_id)
values(2,2);

insert into employee_employee_work_areas (employee_id, employee_work_area_id)
values(2,3);

/*equipment_for_test_model table insertion*/
insert into equipment_for_test_model (model_name,model_description)
values ("model 1","Big equipment");

insert into equipment_for_test_model (model_name,model_description)
values ("model 2","Small equipment");

insert into equipment_for_test_model (model_name,model_description)
values ("model 3","intermediate equipment");

insert into equipment_for_test_model (model_name,model_description)
values ("model 4","deprecated equipment");


/*essay_module table insertion*/
insert into essay_module (module_description)
value("Big equipment module");

insert into essay_module (module_description)
value("Small equipment module");

insert into essay_module (module_description)
value("Intermediate equipment module");

insert into essay_module (module_description)
value("Deprecated module");

/*lab reports and essay insert*/
/*Gas consume essay*/
insert into lab_test_report(essay_code,date_of_essay,essay_description,equipment_for_test_model_id,batch_info_id,employee_id,essay_module_id)
values ("EA1",curdate(),"Big equipment essay", 1,1,1,1);

insert into gas_consumption_essay(max_consume,standard_mean,measurement_error,essay_result,lab_test_report_id)
values (2.1,0.1,0.1,false,1);

insert into lab_test_report(essay_code,date_of_essay,essay_description,equipment_for_test_model_id,batch_info_id,employee_id,essay_module_id)
values ("EA2",curdate(),"small equipment gas consumption essay", 2,2,2,1);/*corregir el modulo usado*/

insert into gas_consumption_essay(max_consume,standard_mean,measurement_error,essay_result,lab_test_report_id)
values (1.5,0.1,0.1,true,2);


/*energy efficiency essay*/

insert into lab_test_report(essay_code,date_of_essay,essay_description,equipment_for_test_model_id,batch_info_id,employee_id,essay_module_id)
values ("EA3",curdate(),"Big equipment energy efficiency essay", 1,1,1,1);

insert into energy_efficiency_essay(energy_efficiency,category,essay_result,lab_test_report_id)
values (74,"A",true,3);

insert into lab_test_report(essay_code,date_of_essay,essay_description,equipment_for_test_model_id,batch_info_id,employee_id,essay_module_id)
values ("EA4",curdate(),"small equipment energy efficiency essay", 2,1,2,2);

insert into energy_efficiency_essay(energy_efficiency,category,essay_result,lab_test_report_id)
values (61,"C",false,4);

insert into lab_test_report(essay_code,date_of_essay,essay_description,equipment_for_test_model_id,batch_info_id,employee_id,essay_module_id)
values ("EA5",curdate(),"small equipment energy efficiency essay", 2,1,3,2);

insert into energy_efficiency_essay(energy_efficiency,category,essay_result,lab_test_report_id)
values (60.3,"C",false,5);


/*Temperature essay*/

insert into lab_test_report(essay_code,date_of_essay,essay_description,equipment_for_test_model_id,batch_info_id,employee_id,essay_module_id)
values ("EA6",curdate(),"Small equipment temperature essay", 1,1,2,2);

insert into temperature_essay (front_measurement,right_side_measurement,essay_result,lab_test_report_id)
values(30.5,25.2,true,6);

insert into lab_test_report(essay_code,date_of_essay,essay_description,equipment_for_test_model_id,batch_info_id,employee_id,essay_module_id)
values ("EA8",curdate(),"Big equipment temperature essay", 2,2,1,2);/*correct code EA7*/

insert into temperature_essay (front_measurement,right_side_measurement,essay_result,lab_test_report_id)
values(38,25.2,false,7);

insert into lab_test_report(essay_code,date_of_essay,essay_description,equipment_for_test_model_id,batch_info_id,employee_id,essay_module_id)
values ("EA9",curdate(),"Big equipment temperature essay", 2,2,1,2);

insert into temperature_essay (front_measurement,right_side_measurement,essay_result,lab_test_report_id)
values(38,25.2,false,8); /*Duplicated value -delete*/



/*more inserts*/
/*Gas consume essay*/
insert into lab_test_report(essay_code,date_of_essay,essay_description,equipment_for_test_model_id,batch_info_id,employee_id,essay_module_id)
values ("EA10",curdate(),"Big equipment essay", 1,2,2,1);

insert into gas_consumption_essay(max_consume,standard_mean,measurement_error,essay_result,lab_test_report_id)
values (1.8,0.1,0.1,true,9);

insert into lab_test_report(essay_code,date_of_essay,essay_description,equipment_for_test_model_id,batch_info_id,employee_id,essay_module_id)
values ("EA11",curdate(),"small equipment gas consumption essay", 2,2,1,2);

insert into gas_consumption_essay(max_consume,standard_mean,measurement_error,essay_result,lab_test_report_id)
values (2,0.05,0.2,false,10);

insert into lab_test_report(essay_code,date_of_essay,essay_description,equipment_for_test_model_id,batch_info_id,employee_id,essay_module_id)
values ("EA12",curdate(),"intermediate equipment gas consumption essay", 3,1,1,3);

insert into gas_consumption_essay(max_consume,standard_mean,measurement_error,essay_result,lab_test_report_id)
values (1.7,0.2,0.1,true,11);


/*energy efficiency essay*/

insert into lab_test_report(essay_code,date_of_essay,essay_description,equipment_for_test_model_id,batch_info_id,employee_id,essay_module_id)
values ("EA12.1",curdate(),"Big equipment energy efficiency essay", 2,2,2,1);

insert into energy_efficiency_essay(energy_efficiency,category,essay_result,lab_test_report_id)
values (65,"B",false,12);

insert into lab_test_report(essay_code,date_of_essay,essay_description,equipment_for_test_model_id,batch_info_id,employee_id,essay_module_id)
values ("EA13",curdate(),"intermediate equipment energy efficiency essay", 3,1,2,3);

insert into energy_efficiency_essay(energy_efficiency,category,essay_result,lab_test_report_id)
values (71.0,"A",TRUE,13);

insert into lab_test_report(essay_code,date_of_essay,essay_description,equipment_for_test_model_id,batch_info_id,employee_id,essay_module_id)
values ("EA14",curdate(),"small equipment energy efficiency essay", 2,2,1,2);

insert into energy_efficiency_essay(energy_efficiency,category,essay_result,lab_test_report_id)
values (71.1,"A",true,14);


/*Temperature essay*/

insert into lab_test_report(essay_code,date_of_essay,essay_description,equipment_for_test_model_id,batch_info_id,employee_id,essay_module_id)
values ("EA15",curdate(),"Intermediate equipment temperature essay", 3,2,1,3);

insert into temperature_essay (front_measurement,right_side_measurement,essay_result,lab_test_report_id)
values(60.1,25.2,false,15);

insert into lab_test_report(essay_code,date_of_essay,essay_description,equipment_for_test_model_id,batch_info_id,employee_id,essay_module_id)
values ("EA16",curdate(),"Big equipment temperature essay", 1,1,2,1);

insert into temperature_essay (front_measurement,right_side_measurement,essay_result,lab_test_report_id)
values(30,25.6,true,16);

insert into lab_test_report(essay_code,date_of_essay,essay_description,equipment_for_test_model_id,batch_info_id,employee_id,essay_module_id)
values ("EA17",curdate(),"Small equipment temperature essay", 2,1,2,2);

insert into temperature_essay (front_measurement,right_side_measurement,essay_result,lab_test_report_id)
values(28,25.2,true,17); 
