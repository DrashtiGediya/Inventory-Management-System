package com.InventoryManagementSystem.InventoryManagementSystem.Service;

import com.InventoryManagementSystem.InventoryManagementSystem.Model.Product;
import com.InventoryManagementSystem.InventoryManagementSystem.Repository.ProductRepository;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

@Service
public class SendCsvInEmail {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendCsvEmail(){
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setTo("abc123@gmail.com");  // write email address for receive csv file
            mimeMessageHelper.setSubject("Threshold Project");
            mimeMessageHelper.setText("Product Stock Less");

            FileSystemResource fileSystemResource = new FileSystemResource("C:\\Users\\ADMIN\\Downloads\\Practice\\stockReport.csv");
            mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);

            javaMailSender.send(mimeMessage);
            System.out.println("mail send successfully");
        }catch (Exception e){
            System.out.println("mail not send");
        }
    }

    public void createCsvFile(){
        try (Writer writer = new FileWriter("C:\\Users\\ADMIN\\Downloads\\Practice\\stockReport.csv")){

            ICsvBeanWriter iCsvBeanWrite = new CsvBeanWriter(writer, CsvPreference.STANDARD_PREFERENCE);
            String[] headers ={"productId","productName","productPrice","gst","inventoryCount"};

            iCsvBeanWrite.writeHeader(headers);
            List<Product> products = productRepository.getProducts();
            for(Product product : products){
                iCsvBeanWrite.write(product,headers);
            }

            iCsvBeanWrite.close();
            writer.close();

            sendCsvEmail();
        }catch (Exception e){
            System.out.println("file not written");
        }
    }
}
