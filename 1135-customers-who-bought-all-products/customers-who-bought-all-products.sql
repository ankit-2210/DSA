# Write your MySQL query statement below

-- select c.customer_id from Customer c 
-- group by c.customer_id
-- having count(distinct c.product_key)=(select count(*) from Product);


with total_products as (
    select count(*) as total from Product
),

product_customer as (
    select c.customer_id, count(distinct c.product_key) as pk from Customer c group by c.customer_id
)

select customer_id from product_customer, total_products 
where pk=total;

