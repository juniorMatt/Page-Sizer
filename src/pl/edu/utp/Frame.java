package pl.edu.utp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;


import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
//Frame(U¿ytkownik)
public class Frame  {

	public static final JTextField textFieldURL = new JTextField();
	private JFrame frame;
	//public static JTextField textFieldURL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Web Page Sizer");
		frame.setAlwaysOnTop(false);
		frame.setBounds(100, 100, 640, 305);
		frame.setLocationRelativeTo(null); //ustawienie œrodkowej pozycji okna
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon("C:\\Users\\mdlen\\eclipse-workspace\\PageSizer\\resources\\logo.jpg"); 
				JOptionPane.showMessageDialog(null,"Projekt wykona³ : Mateusz Didyk"," O Projekcie :", JOptionPane.INFORMATION_MESSAGE, icon);
				
			}
		});
		btnAbout.setFont(new Font("Tahoma", Font.ITALIC, 13));

		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		panel.add(btnAbout);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(30);
		panel_1.setBorder(new EmptyBorder(0, 0, 25, 0));
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Measurement measur = new Measurement();
					try {
						measur.startTiming();
						measur.pageSize();
						measur.endTiming();
						measur.differenceTime();
						Error.errorMessage();
					} catch (IOException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
					//Error.errorMessage();
				
			}
		});
		panel_1.add(btnStart);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldURL.setText(""); //czyszczenie pola tekstowego
			}
		});
		panel_1.add(btnReset);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(55, 15, 45, 15));
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(5, 35));
		
		JLabel lblInfoText = new JLabel("Aby dokona\u0107 pomiaru wpisz/wklej adres strony i naci\u015Bnij przycisk Start");
		lblInfoText.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblInfoText, BorderLayout.NORTH);
		
		JLabel lblURL = new JLabel("URL :");
		panel_2.add(lblURL, BorderLayout.WEST);
		
		
		textFieldURL.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldURL.setColumns(10);
		panel_2.add(textFieldURL, BorderLayout.CENTER);
	}

}
