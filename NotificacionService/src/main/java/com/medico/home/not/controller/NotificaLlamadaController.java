/**
 * 
 */
package com.medico.home.not.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.WebpushConfig;
import com.google.firebase.messaging.WebpushNotification;



/**
 * @author macpro
 *
 */
@RestController
@RequestMapping("/medico")
public class NotificaLlamadaController {

    
    @GetMapping("/push")
    public String sendPush() throws FirebaseMessagingException {
    	
    	    // [START send_to_token]
    	    // This registration token comes from the client FCM SDKs.
    	    String registrationToken = "eGkwNm4Kmv_hsCdxIGVqmq:APA91bHqdJAacIJaXan24jZXKBz_iP69EnW3ljYakkdeJMrkmG1fsjRd_2Hj5seUwRBcCZw4T82Ao8KNAwgTrk7DxxwnweQbUaO2B54W5Fqiwe_D5Zjg8scZfexTvIvNnpuYo6JoGogv";

    	    Message message = Message.builder()
    	            .setWebpushConfig(WebpushConfig.builder()
    	                .setNotification(new WebpushNotification(
    	                    "Doctores en su casa",
    	                    "Bienvenido a doctores en su casa",
    	                    "https://my-server/icon.png"))
    	                .build())
    	            .setToken(registrationToken)
    	            .build();

    	    // Send a message to the device corresponding to the provided
    	    // registration token.
    	    String response = FirebaseMessaging.getInstance().send(message);
    	    
    	   
    	    // Response is a message ID string.
    	    System.out.println("Successfully sent message: " + response);
    	    // [END send_to_token]
			return response;
    	  

    }
}



