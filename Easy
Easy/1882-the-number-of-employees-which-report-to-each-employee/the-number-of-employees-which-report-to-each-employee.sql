# Write your MySQL query statement below

select 
e2.employee_id, e2.name, 
count(e1.reports_to) as reports_count,
ROUND(avg(e1.age)) as average_age
from Employees e1 join Employees e2 on e1.reports_to=e2.employee_id
group by e2.employee_id, e2.name
order by e2.employee_id;

