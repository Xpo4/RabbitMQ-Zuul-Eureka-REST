package com.example.demo.filters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class PostFilter extends ZuulFilter {
	private static Logger log = LoggerFactory.getLogger(PostFilter.class);

	  @Override
	  public String filterType() {
	    return "post";
	  }

	  @Override
	  public int filterOrder() {
	    return 1;
	  }

	  @Override
	  public boolean shouldFilter() {
	    return true;
	  }
	  
	  public static String asJsonString(final Object obj) {
		    try {
		        final ObjectMapper mapper = new ObjectMapper();
		        final String jsonContent = mapper.writeValueAsString(obj);
		        return jsonContent;
		    } catch (Exception e) {
		        throw new RuntimeException(e);
		    }
		}
      
	  @Override
	  public Object run() {
	  
		RequestContext contex = RequestContext.getCurrentContext();
		try (InputStream responseDataStream = contex.getResponseDataStream()) {
			   String responseData = CharStreams.toString(new InputStreamReader(responseDataStream, "UTF-8"));
			   
			   String url = "http://localhost:8090/School/SchoolNumber1";
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
			  
			   ArrayList<Object> list = new ArrayList<Object>();
			   list.add(asJsonString("PostFilter"));
			   list.add(responseFtomHttp);
			   list.add(responseData);
			   contex.setResponseBody(list.toString());
			  
		} catch (IOException e) {
			   log.warn("Ошибка в теле запроса");
			}
   
	    return null;
	    
	  }
	  	  
}
