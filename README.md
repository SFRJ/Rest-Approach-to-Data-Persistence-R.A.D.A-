Rest-Approach-to-Data-Persistence-R.A.D.A-
==========================================
This is bassically a rest api for data access. 
With the only difference that by using an hexagonal architecture design, we can easily swich the type of database
we want to persist to. 

By having the persistance layer completely decoupled from a system, we have a separation of concerns that allows us to 
easier maintain our solution. Service layer should only care about bussiness logic, it will be modules like this one that
should take care of persistance. 

Currently this sample app, defines one port for inserting data, and there are 2 addapters implemented, one for a sql database
and the other for a no-sql database. 


Issues and futures enhancements
-------------------------------

- The hibernate addapter I was writing is not working well, the reason for this is that within the inner modules of the application that take care for either sql or no-sql persistance, an specific domain object/entities need to be created and a mapping mechanism for the object that arrives to that specific entity(either sql or no sql) to be implemented. I expect to fix that very soon, just haven't got much time lately.

- I would like to enhance this example for the persistance to be configurable with a property, to be either sql,no-sql or both at the same 
time.  

- It would be nice to add support for the other database operations.


As you can see the develop and maintenance of the persistence layer is a tedious task by its own, why having all this stuff together with
the rest of the system?    


