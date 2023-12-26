/*7 Statements with agregate function*/
/*Average group by category in energy efficiency*/
select category,
avg(value_of_essay)
from energy_efficiency_essay
group by category;

/*standar deviation of approved and dissaproved essays*/
select essay_result ,
std(front_measurement)
from temperature_essay
group by essay_result;

/*Count the number of essays of by equipment type */
select 
equipment_for_test_model_id as "Equipment id", 
model_description as "Equipment description",
count(*) as "Amount of essay by equipment "
from lab_test_report,  equipment_for_test_model
where lab_test_report.equipment_for_test_model_id=equipment_for_test_model.id
group by equipment_for_test_model_id;

/*In an essay show us the minimun value per equipment*/
select 
model_description, min(max_consume)
from gas_consumption_essay as tg inner join lab_test_report as t1
on t1.id=tg.lab_test_report_id
inner join equipment_for_test_model as tm
on t1.equipment_for_test_model_id=tm.id
group by equipment_for_test_model_id;

/*In an essay show us the maximum value per equipment*/
select 
model_description,  max(value_of_essay)
from energy_efficiency_essay as te inner join lab_test_report as t1
on t1.id=te.lab_test_report_id
inner join equipment_for_test_model as tm
on t1.equipment_for_test_model_id=tm.id
group by equipment_for_test_model_id;

/*Sum all employee salaries*/
select
sum(salary) as "All employee salaries"
from employee;

