# Write your MySQL query statement below



select (
    select distinct salary 
    from (
        select salary, DENSE_RANK() over(order by salary desc) as rnk
        from Employee
    ) as Ranked 
    where rnk=2
) as SecondHighestSalary 