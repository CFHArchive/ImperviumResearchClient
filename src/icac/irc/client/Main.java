package icac.irc.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String host = "";
        int port = 21025;
        
        System.out.print("Enter Host: ");
        try {
			host = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        System.out.print("Enter Port (default 21025): ");
        try{
            port = Integer.parseInt(br.readLine());
        } catch(NumberFormatException e){
//			e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
        
        Client c = new Client(host, port);
        c.start();
	}

}