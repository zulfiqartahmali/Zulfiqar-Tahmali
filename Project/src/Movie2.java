import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSpinner;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

public class Movie2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	JButton btnBuy;
	JLabel Price, Title, Duration;
	JSpinner spinnerQuantity;
	String username;
	JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void setUsername(String username) {
		System.out.println("user name is: " + username);
		this.username = username;
	}
	/**
	 * Create the frame.
	 */
	public Movie2(String username) {
		setUsername(username);
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 549, 556);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		initialize();
	}
	private void initialize() {
		frame.setVisible(true);
		
		JLabel picMovie = new JLabel("New label");
		picMovie.setBounds(10, 11, 220, 435);
		frame.getContentPane().add(picMovie);
		ImageIcon icon = new ImageIcon("small_movie_2.jpg");
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(picMovie.getWidth(), picMovie.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        picMovie.setIcon(newImc);
		
		JLabel lblTitle = new JLabel("Movie Title");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitle.setBounds(240, 11, 72, 14);
		frame.getContentPane().add(lblTitle);
		
		Title = new JLabel("Train To Busan - Peninsula");
		Title.setForeground(Color.WHITE);
		Title.setFont(new Font("Times New Roman", Font.BOLD, 13));
		Title.setBounds(250, 27, 167, 14);
		frame.getContentPane().add(Title);
		
		JLabel lblReleaseDate = new JLabel("Release Date");
		lblReleaseDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblReleaseDate.setForeground(Color.WHITE);
		lblReleaseDate.setBounds(240, 65, 79, 14);
		frame.getContentPane().add(lblReleaseDate);
		
		JLabel ReleaseDate = new JLabel("07 Jul 2020");
		ReleaseDate.setFont(new Font("Times New Roman", Font.BOLD, 13));
		ReleaseDate.setForeground(Color.WHITE);
		ReleaseDate.setBounds(250, 90, 131, 14);
		frame.getContentPane().add(ReleaseDate);
		
		JLabel lblSynopsis = new JLabel("Synopsis");
		lblSynopsis.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSynopsis.setForeground(Color.WHITE);
		lblSynopsis.setBounds(240, 130, 61, 14);
		frame.getContentPane().add(lblSynopsis);
		
		JLabel SynopsisLine1 = new JLabel("A soldier and his team battle hordes of");
		SynopsisLine1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		SynopsisLine1.setForeground(Color.WHITE);
		SynopsisLine1.setBounds(250, 155, 241, 14);
		frame.getContentPane().add(SynopsisLine1);
		
		JLabel SynopsisLine2 = new JLabel("post-apocalyptic zombies in the wastelands");
		SynopsisLine2.setForeground(Color.WHITE);
		SynopsisLine2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		SynopsisLine2.setBounds(250, 180, 262, 14);
		frame.getContentPane().add(SynopsisLine2);
		
		JLabel SynopsisLine3 = new JLabel("of the Korean Peninsula.");
		SynopsisLine3.setForeground(Color.WHITE);
		SynopsisLine3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		SynopsisLine3.setBounds(250, 205, 262, 14);
		frame.getContentPane().add(SynopsisLine3);
		
		JLabel lblDuration = new JLabel("Movie Duration");
		lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDuration.setForeground(Color.WHITE);
		lblDuration.setBounds(240, 248, 101, 14);
		frame.getContentPane().add(lblDuration);
		
		Duration = new JLabel("1.5 Hours");
		Duration.setForeground(Color.WHITE);
		Duration.setFont(new Font("Times New Roman", Font.BOLD, 13));
		Duration.setBounds(250, 273, 91, 14);
		frame.getContentPane().add(Duration);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setBounds(240, 313, 79, 14);
		frame.getContentPane().add(lblPrice);
		
		Price = new JLabel("RM 16");
		Price.setFont(new Font("Times New Roman", Font.BOLD, 13));
		Price.setForeground(Color.WHITE);
		Price.setBounds(253, 338, 88, 16);
		frame.getContentPane().add(Price);
		
		btnBuy = new JButton("Buy");
		btnBuy.setBounds(240, 423, 251, 23);
		frame.getContentPane().add(btnBuy);
		
		spinnerQuantity = new JSpinner();
		spinnerQuantity.setBounds(297, 379, 72, 20);
		frame.getContentPane().add(spinnerQuantity);
		
		JLabel lblQty = new JLabel("Quantity");
		lblQty.setForeground(Color.WHITE);
		lblQty.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQty.setBounds(240, 381, 48, 14);
		frame.getContentPane().add(lblQty);
		btnBuy.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuy) {
			PrintWriter out = null;
			try {
				//get time and date
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
				LocalDateTime now = LocalDateTime.now();  
				Double totalPrice = Double.parseDouble(spinnerQuantity.getValue().toString()) * 16;
				out = new PrintWriter (new BufferedWriter (new FileWriter("invoice.txt", false)));
				out.println("Movie Title : " + Title.getText() + "\nDuration : " + Duration.getText() + "\nBuyer Username : " + username + "\nPrice Per Unit : RM16" + "\nTotal : RM" + totalPrice + "\nDate/Time : " + dtf.format(now));
				JOptionPane.showMessageDialog(contentPane, "Movie has been bought. Invoice successfully generated!");
				Homepage log = new Homepage(username);
				log.setVisible(true);
				frame.dispose();
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}finally {
				if (out != null) {
					out.close();
				}
			}
		}
		
	}
}
