/*Join statements*/
/*5 statements with left, right, inner, outer joins.*/
/*inner join*/
select 
essay_code as "Essay unique code",
date_of_essay as "Date of essay",
essay_description as "Essay description",
front_measurement as "Front measurement (°C)",
left_side_measurement as "left side measurement (°C)",
essay_result as "result of essay"
from lab_test_report inner join temperature_essay
on (lab_test_report.id=temperature_essay.lab_test_report_id);

select 
first_name as "Employee first name",
last_name as "Employee last name",
area_name as "Area of work",
area_code as "Code of the area"
from
employee as t1 left join employee_employee_work_areas as t2
on t1.id=t2.employee_id 
left join employee_work_area as t4 on t2.employee_work_area_id=t4.id;

select 
batch_number as "Batch code",
essay_code as "Essays code per batch",
date_of_essay as "date of essay per batch",
first_name as "Essay responsible first name",
last_name as "Essay responsible last name"
 from
batch_info as t1 right join lab_test_report as t2
on t1.id=t2.batch_info_id
inner join employee as t3 on t2.employee_id=t3.id;

/*full outer join*/
select * from
lab_test_report as t1 left join energy_efficiency_essay as t2
on t1.id=t2.lab_test_report_id
union
select * from 
lab_test_report as t1 right join energy_efficiency_essay as t2
on t1.id=t2.lab_test_report_id;

/*two unrelated tables result null as expected*/
select * from
lab_test_report as t1 inner join gas_consumption_essay as t2
on  t1.id=t2.lab_test_report_id
left join temperature_essay as t3 on t1.id=t3.lab_test_report_id
where t3.id is not null
;