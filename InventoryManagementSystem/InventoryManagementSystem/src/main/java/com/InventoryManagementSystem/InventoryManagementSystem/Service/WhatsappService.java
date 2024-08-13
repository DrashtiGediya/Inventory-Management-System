package com.InventoryManagementSystem.InventoryManagementSystem.Service;

import com.InventoryManagementSystem.InventoryManagementSystem.Model.TwilioMessage;
import com.InventoryManagementSystem.InventoryManagementSystem.Model.WhatsappMessage;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WhatsappService {

    @Autowired
    private WhatsappMessage whatsappMessage;
    @Autowired
    private TwilioMessage twilioMessage;

    public void sendMessageToWhatsapp(){
        Message.creator(new PhoneNumber("whatsapp:+919875055843"),new PhoneNumber(whatsappMessage.getWhatsappNumber()),"order is done").create();
    }
}
