# Write your MySQL query statement below

select u.user_id, u.name, u.mail
from Users u 
where u.mail REGEXP '^[A-Za-z][A-Za-z0-9_.-]*@leetcode.com$'
and u.mail like Binary '%leetcode.com';



