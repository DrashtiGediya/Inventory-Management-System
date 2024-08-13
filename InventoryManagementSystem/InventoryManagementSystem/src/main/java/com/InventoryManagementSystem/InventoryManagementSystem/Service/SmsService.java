package com.InventoryManagementSystem.InventoryManagementSystem.Service;

import com.InventoryManagementSystem.InventoryManagementSystem.Model.TwilioMessage;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    @Autowired
    private TwilioMessage message;
    public void sendSms(){
      Message.creator(new PhoneNumber("+919875109748"),new PhoneNumber(message.getTwilioNumber()),"Your Order is Confirmed!!").create();
    }
}
