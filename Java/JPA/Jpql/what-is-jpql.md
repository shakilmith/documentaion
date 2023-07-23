What is JPQL?
JPQL is an object oriented java persistence query language that can perfom database operations from java code or application than sql database. The JPQL syntaxes are almost like sql syntaxes but the only difference between sql and JPQL is that, sql statement operates in database but JPQL statemnet operates in the application.

The key features of JPQL: 
  - JPQL is portable and platform independant and can be used in different datastores.
  - It can operates bulk update, deletet operations without tuching datastore.
  - JPQL can also perform join and agreegate operations like sql.
  - JPQL queries can be declared statically in metadata (inside the entity itself) or can be declared dynamically in code or business logic. (Below we will describe about it)
  - JPQL is used to define searches against persistent entities and store those entities in database independantly.


JPQL provides 2 methods that can be used to access database records.
   1. createQuery()
     It is called dynamic query, created on the business logic 
     How to define createQuery method in the business logic?
     Query query = em.createQuery("Select p.first_name from Person p);
  2. @NamedQuery()
     It is called static query and it is defined inside the entity itself. 
     How to define @NamedQuery() method inside the entity?
     @NamedQuery(name="find name", query="Select p.first_name from Person p")
     Then inside the business logic we have to mention the name,
     Query query = em.createQuery("find name")
     Note: Here, em is the isntance of entity-manager interface.

The following are the possible JPQL statemnets on the queries: 
  - SELECT (Select p from Peron p where p.id <109)
  - Update (Update Person p SET p.salary=2500 where p.id > 135) 
  - DELETE (Delete p from Person p were p.id = 109) or (Delete from Person wehre p.id = 109)
  Note: Here, Person is the entity name, and p is alise.

In JPQL Select, Update, Delete statements may contains the following clauses (parameters): 
  - Select clasue (It determines the type of the objects or values to be selected)
  - From clause (It mentions the entity name or designate the domain type whcih expressions specified)
  - Entity referecne ()
  - An optional Where clause (like sql where statement, and it applies conditions whcih be used to restrict the results that are returned by the query)
  - An optional Order By clause (Order by not OrderBy)
  - An optional Group By clause
  - An optional Having clause
  - Identifies like Distinct, Like, Join, As, True or False.
