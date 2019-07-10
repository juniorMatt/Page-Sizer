package pl.edu.utp;

import javax.swing.JOptionPane;

public class Error {

	public static void errorMessage() { // metoda odpowiadaj¹ca za zwrócenie wiadomoœci o braku mo¿liwoœci zmierzenia rozmiaru strony
		int badSize =Measurement.conn.getContentLength();
		if(badSize <=0 ) {
			JOptionPane.showMessageDialog(null, "Nie uda³o siê zmierzyæ rozmiaru strony !");
		}
	}
}
