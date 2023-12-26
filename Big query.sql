/*All the info of one essay*/
select 
essay_code as "Code of the essay",
date_of_essay as "Date of essay",
essay_description as "Essay description",
first_name as "Employee first name",
last_name as "Employee last name",
area_name as "Area of work of the employee",
model_description as "Model used for essay",
module_description as "Module for essay used",
batch_number as "Batch info of equipment",
max_consume as "Max consume of gas consumption essay",
tool_name as "Tool used"
 from
lab_test_report as ltr inner join gas_consumption_essay as ge
on ltr.id=ge.lab_test_report_id
inner join employee as em 
on ltr.employee_id=em.id
inner join essay_module as esm
on ltr.essay_module_id=esm.id
inner join equipment_for_test_model as eq
on ltr.equipment_for_test_model_id=eq.id
inner join batch_info as bi
on ltr.batch_info_id=bi.id
inner join employee_employee_work_areas as emws
on em.id=emws.employee_id
inner join employee_work_area as emw
on emws.employee_work_area_id=emw.id
inner join employee_laboratory_tools as elts
on ltr.employee_id= elts.employee_id
inner join laboratory_tool as lbt
on elts.laboratory_tool_id=lbt.id;