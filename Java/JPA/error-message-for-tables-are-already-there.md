## Error message for tables are already present or duplicate tables

```console
WARN: GenerationTarget encountered exception accepting command : Error executing DDL "drop table if exists employee_details" via JDBC Statement
org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "drop table if exists employee_details" via JDBC Statement
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:67)
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.applySqlString(SchemaDropperImpl.java:419)
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.applySqlStrings(SchemaDropperImpl.java:403)
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropFromMetadata(SchemaDropperImpl.java:272)
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.performDrop(SchemaDropperImpl.java:178)
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:149)
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:117)
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:242)
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.lambda$process$5(SchemaManagementToolCoordinator.java:143)
	at java.base/java.util.HashMap.forEach(HashMap.java:1429)
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:140)
	at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:336)
	at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:415)
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1425)
	at org.hibernate.jpa.HibernatePersistenceProvider.createEntityManagerFactory(HibernatePersistenceProvider.java:55)
	at jakarta.persistence.Persistence.createEntityManagerFactory(Persistence.java:80)
	at jakarta.persistence.Persistence.createEntityManagerFactory(Persistence.java:55)
	at com.company.dbpersistent.DemoPersistent.main(DemoPersistent.java:13)
Caused by: java.sql.SQLException: Cannot drop table 'employee_details' referenced by a foreign key constraint 'FK3i5y58envfx5od0vo1mu8pio' on table 'retired_employee'.
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:129)
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122)
	at com.mysql.cj.jdbc.StatementImpl.executeInternal(StatementImpl.java:763)
	at com.mysql.cj.jdbc.StatementImpl.execute(StatementImpl.java:648)
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:54)
	... 17 more

Jul 16, 2023 1:09:55 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@4c0e426a] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Jul 16, 2023 1:09:55 PM org.hibernate.tool.schema.internal.ExceptionHandlerLoggedImpl handleException
WARN: GenerationTarget encountered exception accepting command : Error executing DDL "create table employee_details (e_id integer not null, e_name varchar(255), primary key (e_id)) engine=InnoDB" via JDBC Statement
org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "create table employee_details (e_id integer not null, e_name varchar(255), primary key (e_id)) engine=InnoDB" via JDBC Statement
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:67)
	at org.hibernate.tool.schema.internal.SchemaCreatorImpl.applySqlString(SchemaCreatorImpl.java:502)
	at org.hibernate.tool.schema.internal.SchemaCreatorImpl.applySqlStrings(SchemaCreatorImpl.java:486)
	at org.hibernate.tool.schema.internal.SchemaCreatorImpl.createFromMetadata(SchemaCreatorImpl.java:363)
	at org.hibernate.tool.schema.internal.SchemaCreatorImpl.performCreation(SchemaCreatorImpl.java:176)
	at org.hibernate.tool.schema.internal.SchemaCreatorImpl.doCreation(SchemaCreatorImpl.java:144)
	at org.hibernate.tool.schema.internal.SchemaCreatorImpl.doCreation(SchemaCreatorImpl.java:128)
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:254)
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.lambda$process$5(SchemaManagementToolCoordinator.java:143)
	at java.base/java.util.HashMap.forEach(HashMap.java:1429)
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:140)
	at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:336)
	at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:415)
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1425)
	at org.hibernate.jpa.HibernatePersistenceProvider.createEntityManagerFactory(HibernatePersistenceProvider.java:55)
	at jakarta.persistence.Persistence.createEntityManagerFactory(Persistence.java:80)
	at jakarta.persistence.Persistence.createEntityManagerFactory(Persistence.java:55)
	at com.company.dbpersistent.DemoPersistent.main(DemoPersistent.java:13)
Caused by: java.sql.SQLSyntaxErrorException: Table 'employee_details' already exists
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:120)
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122)
	at com.mysql.cj.jdbc.StatementImpl.executeInternal(StatementImpl.java:763)
	at com.mysql.cj.jdbc.StatementImpl.execute(StatementImpl.java:648)
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:54)
	... 17 more

Jul 16, 2023 1:09:55 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
Jul 16, 2023 1:09:55 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PoolState stop
INFO: HHH10001008: Cleaning up connection pool [jdbc:mysql://localhost:3306/testdb]

Process finished with exit code 0

```


## Duplicate error:
```console
Exception in thread "main" jakarta.persistence.RollbackException: Error while committing the transaction
	at org.hibernate.internal.ExceptionConverterImpl.convertCommitException(ExceptionConverterImpl.java:83)
	at org.hibernate.engine.transaction.internal.TransactionImpl.commit(TransactionImpl.java:104)
	at com.company.dbpersistent.DemoPersistent.main(DemoPersistent.java:45)
Caused by: jakarta.persistence.PersistenceException: Converting `org.hibernate.exception.ConstraintViolationException` to JPA `PersistenceException` : could not execute statement
	at org.hibernate.internal.ExceptionConverterImpl.convert(ExceptionConverterImpl.java:165)
	at org.hibernate.internal.ExceptionConverterImpl.convert(ExceptionConverterImpl.java:175)
	at org.hibernate.internal.ExceptionConverterImpl.convertCommitException(ExceptionConverterImpl.java:67)
	... 2 more
Caused by: org.hibernate.exception.ConstraintViolationException: could not execute statement
	at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:60)
	at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:56)
	at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:109)
	at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:95)
	at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:200)
	at org.hibernate.engine.jdbc.batch.internal.NonBatchingBatch.addToBatch(NonBatchingBatch.java:39)
	at org.hibernate.persister.collection.AbstractCollectionPersister.recreate(AbstractCollectionPersister.java:1478)
	at org.hibernate.action.internal.CollectionRecreateAction.execute(CollectionRecreateAction.java:47)
	at org.hibernate.engine.spi.ActionQueue.executeActions(ActionQueue.java:612)
	at org.hibernate.engine.spi.ActionQueue.lambda$executeActions$1(ActionQueue.java:483)
	at java.base/java.util.LinkedHashMap.forEach(LinkedHashMap.java:729)
	at org.hibernate.engine.spi.ActionQueue.executeActions(ActionQueue.java:480)
	at org.hibernate.event.internal.AbstractFlushingEventListener.performExecutions(AbstractFlushingEventListener.java:329)
	at org.hibernate.event.internal.DefaultFlushEventListener.onFlush(DefaultFlushEventListener.java:39)
	at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:107)
	at org.hibernate.internal.SessionImpl.doFlush(SessionImpl.java:1425)
	at org.hibernate.internal.SessionImpl.managedFlush(SessionImpl.java:477)
	at org.hibernate.internal.SessionImpl.flushBeforeTransactionCompletion(SessionImpl.java:2234)
	at org.hibernate.internal.SessionImpl.beforeTransactionCompletion(SessionImpl.java:1930)
	at org.hibernate.engine.jdbc.internal.JdbcCoordinatorImpl.beforeTransactionCompletion(JdbcCoordinatorImpl.java:439)
	at org.hibernate.resource.transaction.backend.jdbc.internal.JdbcResourceLocalTransactionCoordinatorImpl.beforeCompletionCallback(JdbcResourceLocalTransactionCoordinatorImpl.java:183)
	at org.hibernate.resource.transaction.backend.jdbc.internal.JdbcResourceLocalTransactionCoordinatorImpl$TransactionDriverControlImpl.commit(JdbcResourceLocalTransactionCoordinatorImpl.java:281)
	at org.hibernate.engine.transaction.internal.TransactionImpl.commit(TransactionImpl.java:101)
	... 1 more
Caused by: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '1' for key 'student_library.UK_rciskkxm637ukkdf8ie9wc3hr'
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:117)
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeInternal(ClientPreparedStatement.java:916)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeUpdateInternal(ClientPreparedStatement.java:1061)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeUpdateInternal(ClientPreparedStatement.java:1009)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeLargeUpdate(ClientPreparedStatement.java:1320)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeUpdate(ClientPreparedStatement.java:994)
	at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
	... 19 more

Process finished with exit code 1

```

1. Exception in thread "main" jakarta.persistence.EntityExistsException: A different object with the same identifier value was already associated with the session : [com.company.model.Student#101]