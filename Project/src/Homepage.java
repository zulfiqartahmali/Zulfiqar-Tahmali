import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.awt.Color;

/*
 * To change all image, just download new image and rename it exactly as declared in this program
 */
public class Homepage extends JFrame implements MouseListener{

	private JFrame frame;
	JLabel lblPic;
	Timer timer;
	int x = 0;
	
	//image banner name is movie1.jpg, etc..
	String[] picList = {"movie1.jpg", "movie2.jpg", "movie3.jpg", "movie4.png"};
	
	private JLabel picMovie1;
	private JLabel picMovie2;
	private JLabel picMovie3;
	private JLabel lblMovie1Name;
	private JLabel lblMovie2Name;
	private JLabel lblMovie3Name;
	String username;

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

	/**
	 * Create the application.
	 * this is the constructor
	 */
	public Homepage(String username) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 659, 573);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		setUsername(username);
		initialize();
	}

	//to set username for buying purpose
	public void setUsername(String username) {
		System.out.println("user name is: " + username);
		this.username = username;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame.setVisible(true);
		//title
		JLabel lblTitle = new JLabel("Golden Screen Cinema");
		lblTitle.setForeground(Color.CYAN);
		lblTitle.setFont(new Font("Prestige Elite Std", Font.PLAIN, 22));
		lblTitle.setBounds(190, 11, 281, 33);
		frame.getContentPane().add(lblTitle);
		
		//for moving image. Image change every 2 second
		lblPic = new JLabel("New label");
		lblPic.setBounds(53, 52, 547, 152);
		frame.getContentPane().add(lblPic);
		SetImageSize(3);
		timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SetImageSize(x);
				x += 1;
				if (x >= picList.length)
					x = 0;
			}
		});
		frame.getContentPane().add(lblPic);
		
		// all "picMovie1,2,3,4 is for the image poster
		picMovie1 = new JLabel("New label");
		picMovie1.setBounds(53, 262, 101, 138);
		frame.getContentPane().add(picMovie1);
		//image file name is small_movie_1.jpg
		SetImage("small_movie_1.jpg", picMovie1);
		//use mouseListener because we are click a label instead of button
		picMovie1.addMouseListener(this);
		
		picMovie2 = new JLabel("New label");
		picMovie2.setBounds(202, 262, 101, 138);
		frame.getContentPane().add(picMovie2);
		SetImage("small_movie_2.jpg", picMovie2);
		picMovie2.addMouseListener(this);
		
		picMovie3 = new JLabel("New label");
		picMovie3.setBounds(351, 262, 101, 138);
		frame.getContentPane().add(picMovie3);
		SetImage("small_movie_3.jpg", picMovie3);
		picMovie3.addMouseListener(this);
		
		//lblMovie1Name, etc... is for the movie title. Change as you wish
		lblMovie1Name = new JLabel("Train To Busan");
		lblMovie1Name.setForeground(Color.WHITE);
		lblMovie1Name.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMovie1Name.setBounds(53, 411, 101, 14);
		frame.getContentPane().add(lblMovie1Name);
		
		lblMovie2Name = new JLabel("Fukushima 50");
		lblMovie2Name.setForeground(Color.WHITE);
		lblMovie2Name.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMovie2Name.setBounds(202, 411, 101, 14);
		frame.getContentPane().add(lblMovie2Name);
		
		lblMovie3Name = new JLabel("Solar Impact");
		lblMovie3Name.setForeground(Color.WHITE);
		lblMovie3Name.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMovie3Name.setBounds(351, 411, 101, 14);
		frame.getContentPane().add(lblMovie3Name);
		timer.start();

	}

	//to set imageSize for movie BANNER (the moving image)
	private void SetImageSize(int i) {
		ImageIcon icon = new ImageIcon(picList[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(lblPic.getWidth(), lblPic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        lblPic.setIcon(newImc);
	}
	
	//to set image size of movie POSTER
	private void SetImage(String image_path, JLabel picLabel) {
		ImageIcon icon = new ImageIcon(image_path);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(picLabel.getWidth(), picLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        picLabel.setIcon(newImc);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == picMovie1) {
			Movie1 m1 = new Movie1(username);
			m1.setVisible(true);
			frame.dispose();
		}
		
		if (e.getSource() == picMovie2) {
			Movie2 m2 = new Movie2(username);
			m2.setVisible(true);
			frame.dispose();
		}
		
		if (e.getSource() == picMovie3) {
			Movie3 m3 = new Movie3(username);
			m3.setVisible(true);
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
