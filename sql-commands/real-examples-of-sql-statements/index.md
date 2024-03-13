## SQL statements in action

All the SQL commands: How to use them with your RDMS database.

//All in a nutshell:

## SQL SELECT Command:

1. Retrieve particular columns from a database table.

Syntax:
```js
SELECT C1, C2, C3 FROM table_name;
//like (we have an employee table and we want to retrieve three columns.)
SELECT employee_id, firstName, lastName from Employee;
//Using Where
SELECT firstName, lastName from Employee where employeeID < 20;

```

2. Retrieving or extracting Employee data using Where clasue.

```js
//Retrieve all the employee inforamtion who lives in Australia.
SELECT * from Employee where Country = 'Australia';
//Retrieving all employee firstName, lastName that id is equal to 30.
SELECT firstName, lastName from Employee where employeeID = 30;
//Retrieve all the Employee whose id is below 20;
Select * from Employee where employeeID < 20;
```
Note: The following operations can also be used together the where clause.

Such as:

<table style="width: 100%;">
        <tr style="text-align: left;">
            <th>Operator</th>
            <th>Description</th>
        </tr>
        <tr>
            <td>=</td>
            <td>Equal</td>
        </tr>
        <tr>
            <td>></td>
            <td>Greater than</td>
        </tr>
        <tr>
            <td><</td>
            <td>Less than</td>
        </tr>
        <tr>
            <td>>=</td>
            <td>Greater than or equal</td>
        </tr>
        <tr>
            <td><=</td>
            <td>Less than or equal</td>
        </tr>
        <tr>
            <td> <> or !=</td>
            <td>Not equal</td>
        </tr>
        <tr>
            <td><b>BETWEEN</b></td>
            <td>Between a certain range</td>
        </tr>
        <tr>
            <td><b>IN</b></td>
            <td>To specify multiple possible values for a column.</td>
        </tr>
        <tr>
            <td><b>LIKE</b></td>
            <td>Search for a pattern</td>
        </tr>
    </table>


## SQL ORDER BY clause.

The SQL ORDER BY clasue helps us to sort the returning result by ascending or descanding.

Like:

```js
//sort the result by asecending
SELECT * FROM Employee ORDER BY employee_age; // ascending by default
//sort the result by decending order
SELECT * FROM Employee ORDER BY employee_age DESC;
```

## SQL AND and OR clasue

And or OR clause can be combined or used with Where clause. Such as, implementing more rescrictions filtering database records.

Like:

```js
SELECT * FROM Employee Where Country = 'Australin' AND City = 'Melborn';
//One more
SELECT * FROM Employee Where Country = 'Australia' AND Salary > 1500;

```