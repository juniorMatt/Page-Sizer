package pl.edu.utp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;


public class Measurement {
	
	static long startTime;
	static long endTime;
	static long timeElapsed;
	public static HttpURLConnection conn;
	static String field;
	
	
	
	
	public static String getField() {
		return field;
	}

	public void pageSize() throws MalformedURLException, IOException {  // metoda pobieraj¹ca rozmiar strony
		 field = Frame.textFieldURL.getText();
		 if(field.isEmpty()) {
			 JOptionPane.showMessageDialog(null,"Wprowadz adres strony !"); 
		 }
		 conn = (HttpURLConnection) new URL(field).openConnection();	 
		 int pom = conn.getContentLength();
		 System.out.println(pom);
		 if(pom >= 0) {
			 JOptionPane.showMessageDialog(null,"Waga strony : "+ pom/1024+" KB"); 
		 }
		 else {
			 
		 	}
		 

	}
    /* 
     * Metody odpowiedzalne za pomiar czasu
     */
	public void startTiming() {
		 startTime = System.nanoTime();
		
	}

	public void endTiming() {
		 endTime = System.nanoTime();
	}

	public void differenceTime() {
		 timeElapsed = endTime - startTime;
		 System.err.println("Execution time in nanoseconds : " + timeElapsed);
		 JOptionPane.showMessageDialog(null,"Czas pomiaru : "+ timeElapsed/1000000 +" ms"); 
		
	}

}