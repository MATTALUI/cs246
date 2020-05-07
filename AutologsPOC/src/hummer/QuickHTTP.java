package hummer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class QuickHTTP {

  private static HttpURLConnection getBaseConnection(String url) throws MalformedURLException, IOException {
    System.out.println(url);
    HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();
    connection.setRequestProperty("Authorization", "Basic: " + Config.APPID);
    connection.setRequestProperty("X-Identity", Config.USERTOKEN);
    connection.setRequestProperty("Content-Type", "application/json; utf-8");

    return connection;
  }

  private static String readResponse(HttpURLConnection connection) throws IOException {
    InputStream response = connection.getInputStream();
    Scanner scanner = new Scanner(response);

    return scanner.useDelimiter("\\A").next();
  }

  private static void writeData(HttpURLConnection connection, String data) throws IOException {
    OutputStream output = connection.getOutputStream();
    byte[] body = data.getBytes("utf-8");
    output.write(body, 0, body.length);
  }

  public static String get(String url){
    try {
      HttpURLConnection connection = getBaseConnection(url);
      return readResponse(connection);
    }catch(Exception e) {
      System.out.println(e);
      return "ERROR";
    }
  }

  public static String post(String url, String data){
    try {
      HttpURLConnection connection = getBaseConnection(url);
      connection.setRequestMethod("POST");
      connection.setDoOutput(true);

      writeData(connection, data);

      return readResponse(connection);
    }catch(Exception e) {
      System.out.println(e);
      return "";
    }
  }

  public static String put(String url, String data){
    try {
      HttpURLConnection connection = getBaseConnection(url);
      connection.setRequestMethod("PUT");
      connection.setDoOutput(true);

      writeData(connection, data);

      return readResponse(connection);
    }catch(Exception e) {
      System.out.println(e);
      return "";
    }
  }

  public static String delete(String url){
    try {
      HttpURLConnection connection = getBaseConnection(url);
      connection.setRequestMethod("DELETE");

      return readResponse(connection);
    }catch(Exception e) {
      return "";
    }
  }
}
