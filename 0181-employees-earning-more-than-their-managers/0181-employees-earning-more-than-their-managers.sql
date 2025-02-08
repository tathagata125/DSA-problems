# Write your MySQL query statement below
select e.name as Employee from Employee e Left join Employee m on e.managerId = m.id where e.salary > m.salary;