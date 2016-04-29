package hello;

import org.joda.time.LocalTime;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HelloWorld {

  public static void main(String[] args) {

    try {

	  // Basic ES request diagnostic test.
      DefaultHttpClient httpClient = new DefaultHttpClient();
      HttpGet getRequest = new HttpGet("http://192.168.1.9:9200/");
      HttpResponse response = httpClient.execute(getRequest);
      System.out.println(response.getStatusLine().getStatusCode());
      httpClient.getConnectionManager().shutdown();

    } catch (ClientProtocolException e) {

      e.printStackTrace();

    } catch (IOException e) {

      e.printStackTrace();

    }

    LocalTime currentTime = new LocalTime();
    System.out.println("The current local time is: " + currentTime);

    Greeter greeter = new Greeter();
    System.out.println(greeter.sayHello());

  }

}
