package com.InventoryManagementSystem.InventoryManagementSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "twilio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TwilioMessage {
    private String twilioNumber;
    private String accountSid;
    private String authToken;
}
