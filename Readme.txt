This project runs on port 8080 and in order to run this project  right click on the project and click on Maven Build and then Run as Spring Boot app

I have used NoSQL database as MongoDB for storing the data for which I have downloaded Mongodb and created a database named as mydb after that using command mongod, I have started my Mongodb server

I have created various routes:
i) /addemployees route which basically adds the information of user to our db.I have tested it in postmann while putting the route as (localhost:8080/employees/addemployees) and its json format as 
{
    "id": "1",
    "employeeName": "Manya Mishra",
    "phoneNumber": "9305138135",
    "email": "manyamishra292@gmail.com",
    "reportsTo": "Kaushikey Mishra"
}

ii)/getemployees route which basically gets all the details of the employees entered.I have tested it in postmann while putting the route as (localhost:8080/employees/getemployees).

iii)/getemployee{id} route which basically gets the details of the desired employee by providing it id.I have tested it in postmann while putting the route as (localhost:8080/employees/e11ffe7b-d8dd-46eb-aa0e-e49d855fd44d).

iv)updateemployee/{id} route which simply updates the details of the employee.I have tested it in postmann while putting the route as (localhost:8080/employees/updateemployee/474f8116-8a32-4d0c-84e1-aae9db8176c) and its json format as
{
    "id": "5",
    "employeeName": "Atharva  Mishra",
    "phoneNumber": "9305138135",
    "email": "atharva292@gmail.com",
    "reportsTo": "Kashika Gupta"
}

v)deleteemployee/{id} route which simply deletes the details of employee.I have tested it in postmann while putting the route as (localhost:8080/employees/deleteemployee/474f8116-8a32-4d0c-84e1-aae9db8176c).