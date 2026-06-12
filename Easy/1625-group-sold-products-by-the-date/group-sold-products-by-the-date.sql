# Write your MySQL query statement below


select 
av.sell_date, count(distinct av.product) as num_sold, group_concat(distinct av.product) as products
from Activities av group by av.sell_date 
order by av.sell_date, av.product asc;


