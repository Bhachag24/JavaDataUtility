package com.learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) {
	// write your code here

        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/albums");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader br;
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            StringBuilder sb = new StringBuilder();
            String line = "";
            if(status<=299) {
                 br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            }else {
                br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            while((line=br.readLine())!=null) {
                sb.append(line);
            }
            System.out.println(sb.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
