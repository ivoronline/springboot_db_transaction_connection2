package com.ivoronline.springboot_db_transaction_connection2.service;

import com.ivoronline.springboot_db_transaction_connection2.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class MyService {

  //PROPERTIES
  @Autowired private Connection   connection;
  @Autowired private MyRepository myRepository;

  //=========================================================================================================
  // INSERT
  //=========================================================================================================
  public void insert() throws SQLException {

    //TRANSACTION
    try {

      //START TRANSACTION
      connection.setAutoCommit(true);

      //EXECUTE SQL STATEMENTS (Inserts both Records or none)
      for (int i = 1; i <= 2; i++) {
        if(i==2) { throw new Exception("Exception"); }
        myRepository.insert("Person " + i, 10 * i);
      }

      //COMMIT TRANSACTION
      connection.commit();

    }
    catch (Exception e) {
      //ROLLBACK TRANSACTION
      connection.rollback();
    }
    finally {
      connection.close();
    }

  }

}
