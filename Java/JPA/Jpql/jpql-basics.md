# JPQL overview

JPQL stands for java persistence query language. It provides many built in features which are used to perform relational database operations smoothly from persistence entities or from applications rather than database tables.

JPQL contains 2 special built in methods  to access or modified database records. 
- createQuery() method
It is basically used inside business logic (outside from the doamin or entity model)
- createNamedQuery() method 
It is used from the entity itself and provide a uniqe name as reference of the query. 

For creating JPQL Query method we have to implemetn entity-manager inerface firstly. 

createQuery() method creation: 

