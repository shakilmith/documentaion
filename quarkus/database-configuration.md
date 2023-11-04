## if mysql

```js
# datasource configuration
quarkus.datasource.db-kind = mysql
quarkus.datasource.username = root #usernmae
quarkus.datasource.password = root #password
quarkus.datasource.jdbc.url = jdbc:mysql://localhost:3306/qtestdb #5432 if postgresql

# drop and create the database at startup (use `update` to only update the schema)
quarkus.hibernate-orm.database.generation= drop-and-create
```

## if postgresql

```js
# datasource configuration
quarkus.datasource.db-kind = postgresql
# explicitely add db version
quarkus.datasource.db-version = 14.0
quarkus.datasource.username = hibernate
quarkus.datasource.password = hibernate
quarkus.datasource.jdbc.url = jdbc:postgresql://localhost:5432/hibernate_db

# drop and create the database at startup (use `update` to only update the schema)
quarkus.hibernate-orm.database.generation=drop-and-create
# hibernate dialect 
quarkus.hibernate-orm.dialect=org.hibernate.dialect.CockroachDialect
```