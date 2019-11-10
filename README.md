# Application Walkthrough

Current application allows users to find out necessary flights, purchase chosen tickets and return ones.

## Application structure

All data stores in .csv file used as database. There are aircraft.csv, flight.csv, routs.csv, tickets.csv files in resources package.

An application can write data to file in case when user buy a ticket, read data from file for searching necessary records, update specific records during execution an operation.
For this actions all data in correspondent file transforms to objects. Transformation logic is presented in repository package. All POJO classes (Aircraft, Flight, Rout, Ticket) correspondent stored type of objects in .csv files is presented in model package. Each java-object (POJO class) supports CRUD operations - create, get all, delete, update. Service package contains business logic of the application, controller package - the logic of actions with objects, view package - presentation data logic to users.

## User functionality

### Ticket purchase
To look up a particular ticket an application allows the user specify searching parameters such as arrival and destination airports, date of departure, class of a seat (business or economy). If tickets are found by input criteria the user can buy one ticket. After that application creates a ticket, calculates a cost and writes ticket details to tickets.csv file. If tickets.csv file is successfully updated with a new purchased ticket then sold tickets information for correspondent flight will be updated in flight.csv file.

### Ticket return
To return purchased ticket user should input ticket number and second name only. After that application changes ticket status from 'PURCHASED' to 'RETURNED' and informs the user.

## Data Model
