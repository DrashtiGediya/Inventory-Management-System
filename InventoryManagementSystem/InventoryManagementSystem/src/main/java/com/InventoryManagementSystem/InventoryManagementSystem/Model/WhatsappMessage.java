package com.InventoryManagementSystem.InventoryManagementSystem.Model;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "twilio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WhatsappMessage {
    private String whatsappNumber;
}
