Rest-Approach-to-Data-Persistence-R.A.D.A-
==========================================
This is bassically a rest api for data access. 
With the only difference that by using an hexagonal architecture design, we can easily swich the type of database
we want to persist to. 

By having the persistance layer completely decoupled from a system, we have a separation of concerns that allows us to 
easier maintain our solution. Service layer should only care about bussiness logic, it will be modules like this one that should take care of persistance. 

Currently this sample app, defines one port for inserting data, and there are 2 addapters implemented, one for a sql database and the other for a no-sql database. 

Developing something like this could be cheaper than a vendor solution, and it also can be customized to just what your business needs.


Issues and futures enhancement
-------------------------------

-Hibernate many-to-one mapping does not update the foreign key
-It would be nice to have a property that used in the endpoint we can choose to persist in
 either sql,nosql or both(At the moment it persists in 2 data bases at the same time).

As you can see the develop and maintenance of the persistence layer is a tedious task by its own, why having all this stuff together with
the rest of the system?    


