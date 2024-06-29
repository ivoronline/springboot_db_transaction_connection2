package com.ivoronline.springboot_db_transaction_connection2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class MyRepository {

  //PROPERTIES
  @Autowired private JdbcTemplate jdbcTemplate;

  //=========================================================================================================
  // INSERT
  //=========================================================================================================
  public void insert(Connection connection, String name, int age) throws SQLException {
    String    sql       = "INSERT INTO PERSON(NAME, AGE) VALUES('"+name+"',"+age+")";
    Statement statement = connection.createStatement();
              statement.executeUpdate(sql);
  }

}

