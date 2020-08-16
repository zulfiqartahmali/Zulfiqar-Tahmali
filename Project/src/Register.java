import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Register extends JFrame implements ActionListener{

	private JFrame frame;
	private JTextField username;
	private JTextField password;
	private JButton btnSignUp;
	private JLabel lblSignUpHere;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}
				

	/**
	 * Create the application.
	 */
	public Register() {
		frame = new JFrame();
		frame.setTitle("Register Page");
		frame.setBounds(100, 100, 496, 319);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setVisible(true);
		//Set title here
		JLabel lblTitle = new JLabel("Golden Screen Cinema");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Prestige Elite Std", Font.PLAIN, 19));
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setBounds(144, 32, 230, 30);
		frame.getContentPane().add(lblTitle);
		
		//label for username
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(54, 90, 76, 14);
		frame.getContentPane().add(lblUsername);
		
		//label for password
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(54, 126, 76, 14);
		frame.getContentPane().add(lblPassword);
		
		//textfield for username
		username = new JTextField();
		username.setBounds(140, 87, 262, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		//textfield for password
		password = new JTextField();
		password.setBounds(140, 123, 262, 20);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		
		//login button
	    btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(176, 167, 156, 23);
		frame.getContentPane().add(btnSignUp);
		btnSignUp.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSignUp) {
			boolean isExist = false;
			isExist = checkUsername(username.getText());
			if (!isExist)
				register(username.getText(), password.getText());
			else
				JOptionPane.showMessageDialog(contentPane, "Username exist!");
		}
		
	}

	private boolean checkUsername(String username) {
		String record = null;
		FileReader in = null;
		boolean userStatus = false;
		
		try {
			in = new FileReader ("login.txt");
			BufferedReader br = new BufferedReader(in);
			/* userStatus = 0 (User doesn't exist)
			 * userStatus = 1 (User exist)
			 * userStatus = 2 (Wrong password)
			 * when username is wrong, userStatus is = 0
			 */
			
			//iterate through login.txt to find matching username and password
			while ((record = br.readLine()) != null) {
				String[] split = record.split("\\s");
				
				if (username.equals(split[0])) {
					System.out.println("user exist");
					userStatus = true;
					break;	
					}
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		
		return userStatus;
		
	}

	//to register the user
	private void register(String username, String password) {
		PrintWriter out = null;
		try {
			
			//open the file "login.txt"
			out = new PrintWriter (new BufferedWriter (new FileWriter("login.txt", true)));
			
			//write the username and password in form of:
			//username password
			out.print("\n" + username + " " + password);
			JOptionPane.showMessageDialog(contentPane, "Account created successfully!");
			Login log = new Login();
			log.setVisible(true);
			frame.dispose();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			if (out != null) {
				//always close the file after open
				out.close();
			}
		}
	}

}
