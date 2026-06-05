# Write your MySQL query statement below

select c.class from Courses c group by c.class having
case when count(c.class)>=5 then 1 else 0 end=1;
