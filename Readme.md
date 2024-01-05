In this progressive project, we are going to model a lab essay
management database.
The structure of the databases

Exercises


### 19/12/2023
Build hierarchy for Schema from the below course.
Create DAO classes with necessary interfaces, abstract classes, and Generics.
DAO should be scalable and flexible to support another framework and another database as well.
All CRUD operations should be supported using JDBC. Use connection pool from the below block.
Implement Service layer with necessary abstraction to be able to switch between databases and frameworks.

* All Crud operations with these requirements were done in the master branch

### 14/12/2024
Exercises

* 10 statements for insertion.
* 10 statements for updating.
* 10 statements for deletions.
* 5 alter table.
* 1 big statement to join all tables in the database.
* 5 statements with left, right, inner, outer joins.
* 7 statements with aggregate functions and group by and without having.
* 7 statements with aggregate functions and group by and with having.

There were added all the queries in the essay project folder. Each file
has the name of the asked queries.


### 12/12/2024

Create a database schema using Mysql Workbench for the
new hierarchy with at least 12 tables and all relations.
The schema should satisfy the 3 Normal Forms.

The schema was created and satisfy the 3 normal forms.
The tables created were:
* batch_info: it contains the information of the batch
* employee: it has the information of every employee
* equipment_for_test_model: the model of the equipment tested and it info
* essay_module: the module in wich the equipment is tested
* laboratory_tool: the tools used
* employee_work_area: the areas of works of the employees
* lab_test_report: the unique information of each essay
* temperature_essay: the temperature essay results
* gas_consumption_essay: the gas consumption essay results
* energy_efficiency_essay: the energy efficiency essay results
* employee_employee_work_areas: an intermediate table that joins
  the employees with their different working areas
* employee_laboratory_tools: an intermediate table that joins
  the employees with the different tools that use.
