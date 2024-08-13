package com.InventoryManagementSystem.InventoryManagementSystem.Controller;

import com.InventoryManagementSystem.InventoryManagementSystem.Service.SendCsvInEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email")
public class EmailController {

    @Autowired
    private SendCsvInEmail sendCsvInEmail;

    @PostMapping("sendMail")
    public void senCsv(){
//        sendCsvInEmail.sendCsvEmail(to,subject,text);
        sendCsvInEmail.createCsvFile();
    }
}
