package com.ivoronline.springboot_db_transaction_connection2.controller;

import com.ivoronline.springboot_db_transaction_connection2.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired private MyService myService;

  //=========================================================================================================
  // INSERT
  //=========================================================================================================
  @ResponseBody
  @GetMapping("/insert")
  public String insert() throws SQLException {
    myService.insert();
    return "Records Inserted";
  }

}
