# Write your MySQL query statement below

-- select e2.name from Employee e1 right join Employee e2 on e1.managerId=e2.id group by e2.id having count(e2.id)>=5;


select name from Employee where id in (
    select managerId from Employee where managerId is not null group by managerId having count(*)>=5 
);
