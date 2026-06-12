# Write your MySQL query statement below


-- select e.employee_id
-- from Employees e where e.manager_id not in
-- (select e1.employee_id from Employees e1) and e.salary<30000 order by e.employee_id;

with Managers as (
    select employee_id from Employees
)

select e.employee_id from Employees e
left join Managers m on e.manager_id=m.employee_id
where e.salary<30000 and e.manager_id is not null 
and m.employee_id is null order by e.employee_id;



