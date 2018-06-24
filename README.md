# Rick's Guitar App

## Environment

- JavaSE-1.8 
  - jdk1.8.0_144  
- MySQL 8.0.11
- mysql-connector-java-8.0.11
- MySQL Workbench 6.3
- Eclipse IDE for Java Developers
  - Version: Oxygen.3a Release (4.7.3a)

### MySQL JDBC Connector

[Download](https://dev.mysql.com/downloads/connector/j/)

#### MacOS

![jdbc_connector_macOS](.img/jdbc_connector_macOS.png)

#### Add External JAR

After download Connector Archive, you can find the `mysql-connector-java-8.0.11.jar` file below.

![jdbc_connector_jar](.img/jdbc_connector_jar.png)

Add this JAR file to the JRE system libraries via the `Add External JARs...` button. 

![jdbc_add](./img/jdbc_add.png)

### .properties

You need to create the `config.properties` file like below to connect your MySQL server.

```properties
user=root
password=0000
dburl=jdbc:mysql://localhost:3306/ricksGuitar?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=true&serverTimezone=Asia/Seoul
```

## Screen Shots

### Search

![sc_search](./img/sc_search.png)

### Detail Search

![sc_detail_search](./img/sc_detail_search.png)

### Add

![sc_add](./img/sc_add.png)

![sc_added](./img/sc_added.png)

### Edit

![sc_edit](./img/sc_edit.png)

![sc_edited](./img/sc_edited.png)

### Delete

![sc_delete](./img/sc_delete.png)

![sc_deleted](./img/sc_deleted.png)



