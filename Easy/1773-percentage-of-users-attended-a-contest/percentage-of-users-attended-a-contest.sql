# Write your MySQL query statement below


select r.contest_id, 
ROUND(count(distinct user_id)*100/(select count(distinct user_id) from Users), 2) as percentage
from Register r 
group by r.contest_id order by percentage desc, r.contest_id;

