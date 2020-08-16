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
import java.io.FileReader;
import java.io.IOException;

		

public class Login extends JFrame implements ActionListener, MouseListener{

	private JFrame frame;
	private JTextField username;
	private JTextField password;
	private JButton btnLogin;
	private JLabel lblSignUpHere;
	private JPanel contentPane;
	int position;																							
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		frame = new JFrame();
		frame.setTitle("Sign Up Page");
		frame.setBounds(100, 100, 496, 319);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
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
	    btnLogin = new JButton("Login");
		btnLogin.setBounds(176, 167, 156, 23);
		frame.getContentPane().add(btnLogin);
		btnLogin.addActionListener(this);
		
		JLabel lblNotAMember = new JLabel("Not a member?");
		lblNotAMember.setBounds(176, 214, 96, 14);
		frame.getContentPane().add(lblNotAMember);
		
		lblSignUpHere = new JLabel("Sign up here");
		lblSignUpHere.setForeground(Color.RED);
		lblSignUpHere.setBounds(270, 214, 76, 14);
		frame.getContentPane().add(lblSignUpHere);
		lblSignUpHere.addMouseListener(this);
		frame.addMouseListener(this);
	}

	//All button action is defined here
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			login();	
		}
	}

	public void login() {
		String record = null;
		FileReader in = null;
		
		
		try {
			in = new FileReader ("login.txt");
			BufferedReader br = new BufferedReader(in);
			String username = this.username.getText();
			String password = this.password.getText();
			/* userStatus = 0 (User doesn't exist)
			 * userStatus = 1 (User exist)
			 * userStatus = 2 (Wrong password)
			 * when username is wrong, userStatus is = 0
			 */
			int userStatus = 0;
			//iterate through login.txt to find matching username and password
			while ((record = br.readLine()) != null) {
				String[] split = record.split("\\s");
				
				if (username.equals(split[0])) {
					if (password.equals(split[1])) {
						Homepage hp = new Homepage(username);
						userStatus = 1;
						hp.setVisible(true);
						frame.dispose();
					}
					else {
						System.out.println("wrong password");
						userStatus = 2;
						JOptionPane.showMessageDialog(contentPane, "Wrong Password. Please Reenter");
					}
					break;
				}
			}
			if (userStatus == 0)
				JOptionPane.showMessageDialog(contentPane, "Account doesn't exist");
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}

	//The mouse method below is for mouse pressed function. Mainly only for the Sign Up Here
	public void mousePressed(MouseEvent e) {
	       
   }

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblSignUpHere) {
			Register reg = new Register();
			reg.setVisible(true);
			//frame.setVisible(false);
			frame.dispose();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
