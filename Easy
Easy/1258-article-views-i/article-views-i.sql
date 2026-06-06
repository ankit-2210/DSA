# Write your MySQL query statement below

select distinct(v.viewer_id) as id from Views as v where v.author_id=v.viewer_id order by v.viewer_id asc;
