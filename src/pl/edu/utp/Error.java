package pl.edu.utp;

import javax.swing.JOptionPane;

public class Error {

	public static void errorMessage() { // metoda odpowiadaj�ca za zwr�cenie wiadomo�ci o braku mo�liwo�ci zmierzenia rozmiaru strony
		int badSize =Measurement.conn.getContentLength();
		if(badSize <=0 ) {
			JOptionPane.showMessageDialog(null, "Nie uda�o si� zmierzy� rozmiaru strony !");
		}
	}
}
