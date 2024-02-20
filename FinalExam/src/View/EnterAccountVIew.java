package View;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.MyConnection;
import Controller.MyQuery;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class EnterAccountVIew extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JTextField usernameTextField_1;
	private JPasswordField passwordTextField_1;
	private JPasswordField repeatPasswordTextField;

	public EnterAccountVIew() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600); //1920, 1080
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(0, 0, 474, 563);
		contentPane.add(imagePanel);
		imagePanel.setLayout(null);
		
		JLabel imageLoginLabel = new JLabel("");
		imageLoginLabel.setBounds(0, 0, 474, 563);
		imageLoginLabel.setIcon(new ImageIcon("C:\\Users\\PHILONG\\Downloads\\Photo\\imageEnter.png"));
		imagePanel.add(imageLoginLabel);
		
		JPanel enterPanel = new JPanel();
		enterPanel.setBounds(473, 0, 513, 563);
		contentPane.add(enterPanel);
		enterPanel.setLayout(new CardLayout(0, 0));
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(new Color(32, 65, 97));
		enterPanel.add(loginPanel, "name_580467231037000");
		loginPanel.setLayout(null);
		
		JPanel createPanel = new JPanel();
		createPanel.setBackground(new Color(32, 65, 97));
		enterPanel.add(createPanel, "name_577602304833400");
		createPanel.setLayout(null);
		
		JLabel createAccLabel = new JLabel("CREATE NEW ACCOUNT");
		createAccLabel.setOpaque(true);
		createAccLabel.setHorizontalAlignment(SwingConstants.CENTER);
		createAccLabel.setForeground(new Color(27, 55, 82));
		createAccLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 42));
		createAccLabel.setBackground(new Color(52, 104, 156));
		createAccLabel.setBounds(0, 0, 513, 77);
		createPanel.add(createAccLabel);
		
		usernameTextField_1 = new JTextField();
		usernameTextField_1.setFont(new Font("SVN-Agency FB", Font.PLAIN, 26));
		usernameTextField_1.setColumns(10);
		usernameTextField_1.setBounds(139, 123, 324, 51);
		createPanel.add(usernameTextField_1);
		
		JLabel usernameLabel_1 = new JLabel("USERNAME:");
		usernameLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		usernameLabel_1.setForeground(new Color(57, 114, 171));
		usernameLabel_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 26));
		usernameLabel_1.setBounds(12, 123, 117, 51);
		createPanel.add(usernameLabel_1);
		
		JLabel passwordLabel_1 = new JLabel("PASS:");
		passwordLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		passwordLabel_1.setForeground(new Color(57, 114, 171));
		passwordLabel_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 26));
		passwordLabel_1.setBounds(12, 184, 117, 51);
		createPanel.add(passwordLabel_1);
		
		passwordTextField_1 = new JPasswordField();
		char temp = passwordTextField_1.getEchoChar();
		passwordTextField_1.setFont(new Font("Arial", Font.BOLD, 18));
		passwordTextField_1.setBounds(139, 184, 324, 51);
		createPanel.add(passwordTextField_1);
		
		JLabel repeatPasswordLabel = new JLabel("RE-PASS:");
		repeatPasswordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		repeatPasswordLabel.setForeground(new Color(57, 114, 171));
		repeatPasswordLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 26));
		repeatPasswordLabel.setBounds(12, 245, 117, 51);
		createPanel.add(repeatPasswordLabel);
		
		repeatPasswordTextField = new JPasswordField();
		repeatPasswordTextField.setFont(new Font("Arial", Font.BOLD, 18));
		repeatPasswordTextField.setBounds(139, 245, 324, 51);
		createPanel.add(repeatPasswordTextField);
		
		JCheckBox passCheckBox = new JCheckBox("Show password");
		passCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (passCheckBox.isSelected()) {
					passwordTextField_1.setEchoChar((char) 0);
					repeatPasswordTextField.setEchoChar((char) 0);
				}
				else {
					passwordTextField_1.setEchoChar(temp);
					repeatPasswordTextField.setEchoChar(temp);
				}
			}
		});
		passCheckBox.setForeground(new Color(57, 114, 171));
		passCheckBox.setFont(new Font("SVN-Agency FB", Font.PLAIN, 18));
		passCheckBox.setFocusable(false);
		passCheckBox.setBackground(new Color(32, 65, 97));
		passCheckBox.setBounds(386, 302, 117, 33);
		createPanel.add(passCheckBox);
		
		Button cancelButton_1 = new Button("CANCEL");
		cancelButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cancelButton_1.setForeground(new Color(57, 114, 171));
		cancelButton_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		cancelButton_1.setFocusable(false);
		cancelButton_1.setBackground(new Color(3, 6, 9));
		cancelButton_1.setBounds(10, 354, 237, 62);
		createPanel.add(cancelButton_1);
		
		Button createButton = new Button("CREATE");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String username = usernameTextField_1.getText().replaceAll("\\s+$", "");
					String password = String.valueOf(passwordTextField_1.getPassword());
					String repeatPassword = String.valueOf(repeatPasswordTextField.getPassword());
					
					if (username.matches("") || password.matches("") || repeatPassword.matches(""))
						JOptionPane.showConfirmDialog(null, "ERROR: Enter again");
					else if (!username.matches("[a-zA-Z0-9]+"))
						JOptionPane.showConfirmDialog(null, "ERROR: The username cannot contain special characters");
					else if (username.length() > 8 || username.length() < 4)
						JOptionPane.showConfirmDialog(null, "ERROR: The username only contains a minimum of 4 characters and a maximum of 8 characters");
					else if (password.length() > 16 || password.length() < 8)
						JOptionPane.showConfirmDialog(null, "ERROR: The password only contains a minimum of 8 characters and a maximum of 16 characters");
					else if (!password.matches(repeatPassword)) {
						JOptionPane.showConfirmDialog(null, "ERROR: The re-pass isn't the same as the pass");
						repeatPasswordTextField.setText("");
					}
					else if (isUsernameExist(username))
						JOptionPane.showConfirmDialog(null, "The username has been used");
					else {
						Connection con = MyConnection.getConnection();
						PreparedStatement ps;
						ps = con.prepareStatement("INSERT INTO Information (Username, Password, Email, Country, Money, Gender) VALUES (?, ?, '', '', 0, '');");
						ps.setString(1, username);
						ps.setString(2, password);
						if (ps.executeUpdate() != 0)
							JOptionPane.showConfirmDialog(null, "Account created");
						else
							JOptionPane.showConfirmDialog(null, "Something wrong");
					}
				} catch (SQLException ex) {
					Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
		createButton.setForeground(new Color(57, 114, 171));
		createButton.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		createButton.setFocusable(false);
		createButton.setBackground(new Color(18, 35, 53));
		createButton.setBounds(266, 353, 237, 62);
		createPanel.add(createButton);
		
		JLabel loginViewLabel = new JLabel("Already have an account? Click here to Login");
		loginViewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usernameTextField_1.setText("");
				passwordTextField_1.setText("");
				repeatPasswordTextField.setText("");
				enterPanel.removeAll();
				enterPanel.add(loginPanel);
				enterPanel.repaint();
				enterPanel.revalidate();
			}
		});
		loginViewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginViewLabel.setForeground(new Color(57, 114, 171));
		loginViewLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 18));
		loginViewLabel.setBounds(12, 422, 493, 45);
		createPanel.add(loginViewLabel);
		
		JLabel loginLabel = new JLabel("LOGIN");
		loginLabel.setOpaque(true);
		loginLabel.setBackground(new Color(52, 104, 156));
		loginLabel.setForeground(new Color(27, 55, 82));
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 42));
		loginLabel.setBounds(0, 0, 513, 77);
		loginPanel.add(loginLabel);
		
		JLabel usernameLabel = new JLabel("USERNAME:");
		usernameLabel.setForeground(new Color(57, 114, 171));
		usernameLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 26));
		usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		usernameLabel.setBounds(12, 184, 117, 51);
		loginPanel.add(usernameLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("SVN-Agency FB", Font.PLAIN, 26));
		usernameTextField.setBounds(139, 184, 324, 51);
		loginPanel.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("PASSWORD:");
		passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		passwordLabel.setForeground(new Color(57, 114, 171));
		passwordLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 26));
		passwordLabel.setBounds(12, 245, 117, 51);
		loginPanel.add(passwordLabel);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("Arial", Font.BOLD, 18));
		passwordTextField.setBounds(139, 245, 324, 51);
		loginPanel.add(passwordTextField);
		
		JCheckBox passwordCheckBox = new JCheckBox("Show password");
		passwordCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (passwordCheckBox.isSelected())
					passwordTextField.setEchoChar((char) 0);
				else
					passwordTextField.setEchoChar(temp);
			}
		});
		passwordCheckBox.setFocusable(false);
		passwordCheckBox.setForeground(new Color(57, 114, 171));
		passwordCheckBox.setBackground(new Color(32, 65, 97));
		passwordCheckBox.setFont(new Font("SVN-Agency FB", Font.PLAIN, 18));
		passwordCheckBox.setBounds(386, 302, 117, 33);
		loginPanel.add(passwordCheckBox);
		
		Button cancelButton = new Button("CANCEL");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cancelButton.setFocusable(false);
		cancelButton.setForeground(new Color(57, 114, 171));
		cancelButton.setBackground(new Color(3, 6, 9));
		cancelButton.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		cancelButton.setBounds(10, 354, 237, 62);
		loginPanel.add(cancelButton);
		
		Button loginButton = new Button("LOGIN");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String username = usernameTextField.getText();
					String password = String.valueOf(passwordTextField.getPassword());
					
					if (username.matches("") || password.matches(""))
						JOptionPane.showConfirmDialog(null, "Enter again");
					else {
						Connection con = MyConnection.getConnection();
						PreparedStatement ps;
						ResultSet rs;
						ps = con.prepareStatement("SELECT * FROM Information WHERE Username = ? AND Password = ?;");
						ps.setString(1, username);
						ps.setString(2, password);
						rs = ps.executeQuery();
								
						if (rs.next()) {
							if (username.matches("neuoavs") && password.matches("171410Tn")) {
								JOptionPane.showConfirmDialog(null, "Loged");
								dispose();
								new ManagementGameView();
								
							} else {
								JOptionPane.showConfirmDialog(null, "Loged");
								dispose();
								HomeView homeView = new HomeView();
								homeView.getPerLabel().setText(username + " - " + rs.getFloat(6));
								MyQuery.showYourGameTable(homeView.getTable_1(), homeView.getPerLabel());
							}
						}
						else
							JOptionPane.showConfirmDialog(null, "Login Error");
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
				}
				
			}
		});
		loginButton.setForeground(new Color(57, 114, 171));
		loginButton.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		loginButton.setFocusable(false);
		loginButton.setBackground(new Color(18, 35, 53));
		loginButton.setBounds(266, 353, 237, 62);
		loginPanel.add(loginButton);
		
		JLabel createClickLabel = new JLabel("New user? Click here to create an account");
		createClickLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usernameTextField.setText("");
				passwordTextField.setText("");
				enterPanel.removeAll();
				enterPanel.add(createPanel);
				enterPanel.repaint();
				enterPanel.revalidate();
			}
		});
		createClickLabel.setForeground(new Color(57, 114, 171));
		createClickLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 18));
		createClickLabel.setHorizontalAlignment(SwingConstants.CENTER);
		createClickLabel.setBounds(12, 422, 493, 45);
		loginPanel.add(createClickLabel);

		JLabel formatLabel = new JLabel();
		formatLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showConfirmDialog(null, "The username only contains a minimum of 4 characters and a maximum of 8 characters. The username also cannot contain special characters");
			}
		});
		formatLabel.setBounds(473, 196, 30, 30);
		ImageIcon IC = new ImageIcon("C:\\Users\\PHILONG\\Downloads\\Photo\\format.png");
		Image formatI = IC.getImage().getScaledInstance(formatLabel.getWidth(), formatLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon formatIC = new ImageIcon(formatI);
		formatLabel.setIcon(formatIC);
		loginPanel.add(formatLabel);
		
		JLabel formatLabel_1 = new JLabel();
		formatLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showConfirmDialog(null, "The password only contains a minimum of 8 characters and a maximum of 16 characters");
			}
		});
		formatLabel_1.setIcon(formatIC);
		formatLabel_1.setBounds(473, 255, 30, 30);
		loginPanel.add(formatLabel_1);

		JLabel formatLabel_2 = new JLabel();
		formatLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showConfirmDialog(null, "The username only contains a minimum of 4 characters and a maximum of 8 characters. The username also cannot contain special characters");
			}
		});
		formatLabel_2.setIcon(formatIC);
		formatLabel_2.setBounds(473, 132, 30, 30);
		createPanel.add(formatLabel_2);
		
		JLabel formatLabel_2_1 = new JLabel();
		formatLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showConfirmDialog(null, "The password only contains a minimum of 8 characters and a maximum of 16 characters");
			}
		});
		formatLabel_2_1.setIcon(formatIC);
		formatLabel_2_1.setBounds(473, 196, 30, 30);
		createPanel.add(formatLabel_2_1);
		
		JLabel formatLabel_2_1_1 = new JLabel();
		formatLabel_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showConfirmDialog(null, "The re-pass must be the same as the pass");
			}
		});
		formatLabel_2_1_1.setIcon(formatIC);
		formatLabel_2_1_1.setBounds(473, 255, 30, 30);
		createPanel.add(formatLabel_2_1_1);
		
		
		
		setVisible(true);
	}
	public boolean isUsernameExist(String un) {
		try {
			Connection con = MyConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Information WHERE Username = ?;");;
			ps.setString(1, un);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return true;
		} catch (SQLException ex) {
			Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
	
}
