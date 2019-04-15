package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
 
@Component
public class Consumer {
 
 @RabbitListener(queues="${jsa.rabbitmq.queue}")
    public void recievedMessage(String msg) throws IOException {
	 String url = msg;
	 URL obj = new URL(url);
	 HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
     connection.setRequestMethod("GET");
     BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	 String inputLine;
	 StringBuffer responseFtomHttp = new StringBuffer();
     while ((inputLine = in.readLine()) != null) {
  	   responseFtomHttp.append(inputLine);
	 }
	   in.close();
	   System.out.println(responseFtomHttp);
   }
}