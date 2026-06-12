# Write your MySQL query statement below


with top_user as
(select u.name as results
from Users u join MovieRating mr on u.user_id=mr.user_id
group by mr.user_id
order by count(*) desc, u.name asc limit 1),

top_movie as
(select m.title as results
from Movies m join MovieRating mr on m.movie_id=mr.movie_id 
where mr.created_at between '2020-02-01' and '2020-02-29'
group by mr.movie_id
order by avg(mr.rating) desc, m.title asc limit 1)


select * from top_user 
union all 
select * from top_movie;


