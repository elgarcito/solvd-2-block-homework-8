/*7 statements with aggregate functions and group by and with having.*/
/*Show how many energy efficiency essay are less than 70%*/
select category,
avg(value_of_essay)
from energy_efficiency_essay
group by category
having avg(value_of_essay)<70;


/*In an essay show us the minimun value per equipment filtering with values lesser than 1.8*/
select 
model_description, min(max_consume)
from gas_consumption_essay as tg inner join lab_test_report as t1
on t1.id=tg.lab_test_report_id
inner join equipment_for_test_model as tm
on t1.equipment_for_test_model_id=tm.id
group by equipment_for_test_model_id
having min(max_consume)<1.8;


/*In an essay show us the maximum value per equipment > 71 */
select 
model_description,  max(value_of_essay)
from energy_efficiency_essay as te inner join lab_test_report as t1
on t1.id=te.lab_test_report_id
inner join equipment_for_test_model as tm
on t1.equipment_for_test_model_id=tm.id
group by equipment_for_test_model_id
having max(value_of_essay)>71;

/*Count how many employees made more than 7 essays*/
select 
first_name,
last_name,
count(*) as "amount of essay per employee"
from lab_test_report as ltr inner join employee as et
on ltr.employee_id=et.id
group by first_name, last_name
having count(*)>7;

/*give the average of essays per employee*/
select 
first_name,
last_name,
avg(employee_id) as "average of essay per employee bigger than 1"
from lab_test_report as ltr inner join employee as et
on ltr.employee_id=et.id
group by first_name, last_name
having avg(employee_id)>1;



/*Group the employees by the amount of tools that they use*/
select 
first_name,
last_name,
count(*) as "amount of tools used per employee"
from employee as em inner join employee_laboratory_tools as elts
on em.id=elts.employee_id
group by first_name, last_name
having count(*)>0;

/*Count how many employees work in different areas*/
select 
first_name,
last_name,
count(*) as "Areas of work used per employee"
from employee as em inner join employee_employee_work_areas as emws
on em.id=emws.employee_id
group by first_name, last_name
having count(*)>1;






