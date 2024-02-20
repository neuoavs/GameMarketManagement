package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import javax.swing.table.JTableHeader;

import Controller.MyCheck;
import Controller.MyConnection;

import Controller.MyHeaderColor;

import Controller.MyQuery;
import Model.MyRan;



import javax.swing.JTextField;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;



public class HomeView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField emailTextField;
	private JTable table;
	private JTable table_1;
	private JLabel perLabel;
	private JComboBox genderComboBox;
	private JComboBox countryComboBox;
	private JTable table_2;
	private JLabel studioGameLabel;
	private JLabel nameGameLabel;
	private JTextField resultTextField_1;
	private JTextField resultTextField_1_1;
	private JTextField resultTextField_1_1_1;
	private JTextField largerTextField;
	private JComboBox fromComboBox;
	private JComboBox toComboBox;
	private JTextField smallerTextField;
	private JComboBox genreComboBox;
	
	public HomeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 56, 1540, 784);
		contentPane.add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));
	
		JPanel homeViewPanel = new JPanel();
		homeViewPanel.setBackground(new Color(32, 65, 97));
		mainPanel.add(homeViewPanel, "homeView");
		homeViewPanel.setLayout(null);
		
		JPanel gamePanel = new JPanel();
		gamePanel.setBackground(new Color(32, 65, 97));
		mainPanel.add(gamePanel, "mainView");
		gamePanel.setLayout(null);
		
		JPanel informationViewPanel = new JPanel();
		informationViewPanel.setBackground(new Color(32, 65, 97));
		mainPanel.add(informationViewPanel, "inforView");
		informationViewPanel.setLayout(null);
		
		JPanel ruleViewPanel = new JPanel();
		ruleViewPanel.setBackground(new Color(32, 65, 97));
		mainPanel.add(ruleViewPanel, "ruleView");
		ruleViewPanel.setLayout(null);
		
		// UpPanel HomeView
				JPanel upPanel = new JPanel();
				upPanel.setBackground(new Color(3, 6, 9));
				upPanel.setBounds(0, 0, 1540, 56);
				contentPane.add(upPanel);
				
				JLabel ruleLabel = new JLabel("RULE");
				ruleLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						mainPanel.removeAll();
						mainPanel.add(ruleViewPanel);
						mainPanel.repaint();
						mainPanel.revalidate();
					}
				});
				ruleLabel.setOpaque(true);
				ruleLabel.setHorizontalAlignment(SwingConstants.CENTER);
				ruleLabel.setForeground(new Color(62, 124, 185));
				ruleLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 28));
				ruleLabel.setBackground(new Color(13, 26, 38));
				ruleLabel.setBounds(936, 11, 81, 38);
				upPanel.add(ruleLabel);
				
				JPanel addFundsViewPanel = new JPanel();
				addFundsViewPanel.setBackground(new Color(32, 65, 97));
				mainPanel.add(addFundsViewPanel, "fundsView");
				addFundsViewPanel.setLayout(null);
				
				JPanel panel_3_1 = new JPanel();
				panel_3_1.setLayout(null);
				panel_3_1.setBackground(new Color(13, 26, 38));
				panel_3_1.setBounds(310, 10, 827, 254);
				addFundsViewPanel.add(panel_3_1);
				
				JLabel num1Label = new JLabel("");
				num1Label.setHorizontalAlignment(SwingConstants.LEFT);
				num1Label.setForeground(new Color(57, 114, 171));
				num1Label.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
				num1Label.setBounds(10, 10, 37, 37);
				panel_3_1.add(num1Label);
				
				JLabel plusLabel = new JLabel("+");
				plusLabel.setHorizontalAlignment(SwingConstants.CENTER);
				plusLabel.setForeground(new Color(57, 114, 171));
				plusLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
				plusLabel.setBounds(57, 10, 37, 37);
				panel_3_1.add(plusLabel);
				
				JLabel num2Label = new JLabel("");
				num2Label.setHorizontalAlignment(SwingConstants.LEFT);
				num2Label.setForeground(new Color(57, 114, 171));
				num2Label.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
				num2Label.setBounds(104, 10, 37, 37);
				panel_3_1.add(num2Label);
				
				JLabel equalLabel = new JLabel("=");
				equalLabel.setHorizontalAlignment(SwingConstants.CENTER);
				equalLabel.setForeground(new Color(57, 114, 171));
				equalLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
				equalLabel.setBounds(151, 10, 37, 37);
				panel_3_1.add(equalLabel);
				
				JTextField resultTextField = new JTextField();
				resultTextField.setBackground(new Color(200, 218, 236));
				resultTextField.setHorizontalAlignment(SwingConstants.LEFT);
				resultTextField.setForeground(new Color(57, 114, 171));
				resultTextField.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
				resultTextField.setBounds(198, 10, 80, 37);
				panel_3_1.add(resultTextField);
				
				JLabel num1Label_1 = new JLabel("");
				num1Label_1.setHorizontalAlignment(SwingConstants.LEFT);
				num1Label_1.setForeground(new Color(57, 114, 171));
				num1Label_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
				num1Label_1.setBounds(10, 57, 37, 37);
				panel_3_1.add(num1Label_1);
				
				resultTextField_1 = new JTextField();
				resultTextField_1.setBackground(new Color(200, 218, 236));
				resultTextField_1.setHorizontalAlignment(SwingConstants.LEFT);
				resultTextField_1.setForeground(new Color(57, 114, 171));
				resultTextField_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
				resultTextField_1.setBounds(198, 57, 80, 37);
				panel_3_1.add(resultTextField_1);
				
				JLabel plusLabel_1 = new JLabel("x");
				plusLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				plusLabel_1.setForeground(new Color(57, 114, 171));
				plusLabel_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
				plusLabel_1.setBounds(57, 57, 37, 37);
				panel_3_1.add(plusLabel_1);
				
				JLabel num2Label_1 = new JLabel("");
				num2Label_1.setHorizontalAlignment(SwingConstants.LEFT);
				num2Label_1.setForeground(new Color(57, 114, 171));
				num2Label_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
				num2Label_1.setBounds(104, 57, 37, 37);
				panel_3_1.add(num2Label_1);
				
				JLabel equalLabel_1 = new JLabel("=");
				equalLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				equalLabel_1.setForeground(new Color(57, 114, 171));
				equalLabel_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
				equalLabel_1.setBounds(151, 57, 37, 37);
				panel_3_1.add(equalLabel_1);
				
				JLabel num1Label_1_1 = new JLabel("");
				num1Label_1_1.setHorizontalAlignment(SwingConstants.LEFT);
				num1Label_1_1.setForeground(new Color(57, 114, 171));
				num1Label_1_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
				num1Label_1_1.setBounds(350, 10, 37, 37);
				panel_3_1.add(num1Label_1_1);
				
				JLabel truLabel = new JLabel("-");
				truLabel.setHorizontalAlignment(SwingConstants.CENTER);
				truLabel.setForeground(new Color(57, 114, 171));
				truLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
				truLabel.setBounds(397, 10, 37, 37);
				panel_3_1.add(truLabel);
				
				JLabel num2Label_1_1 = new JLabel("");
				num2Label_1_1.setHorizontalAlignment(SwingConstants.LEFT);
				num2Label_1_1.setForeground(new Color(57, 114, 171));
				num2Label_1_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
				num2Label_1_1.setBounds(444, 10, 37, 37);
				panel_3_1.add(num2Label_1_1);
				
				JLabel equalLabel_1_1 = new JLabel("=");
				equalLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
				equalLabel_1_1.setForeground(new Color(57, 114, 171));
				equalLabel_1_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
				equalLabel_1_1.setBounds(491, 10, 37, 37);
				panel_3_1.add(equalLabel_1_1);
				
				resultTextField_1_1 = new JTextField();
				resultTextField_1_1.setBackground(new Color(200, 218, 236));
				resultTextField_1_1.setHorizontalAlignment(SwingConstants.LEFT);
				resultTextField_1_1.setForeground(new Color(57, 114, 171));
				resultTextField_1_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
				resultTextField_1_1.setBounds(538, 10, 80, 37);
				panel_3_1.add(resultTextField_1_1);
				
				JLabel num1Label_1_1_1 = new JLabel("");
				num1Label_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
				num1Label_1_1_1.setForeground(new Color(57, 114, 171));
				num1Label_1_1_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
				num1Label_1_1_1.setBounds(350, 57, 37, 37);
				panel_3_1.add(num1Label_1_1_1);
				
				JLabel plusLabel_1_1_1 = new JLabel(":");
				plusLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
				plusLabel_1_1_1.setForeground(new Color(57, 114, 171));
				plusLabel_1_1_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
				plusLabel_1_1_1.setBounds(397, 57, 37, 37);
				panel_3_1.add(plusLabel_1_1_1);
				
				JLabel num2Label_1_1_1 = new JLabel("");
				num2Label_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
				num2Label_1_1_1.setForeground(new Color(57, 114, 171));
				num2Label_1_1_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
				num2Label_1_1_1.setBounds(444, 57, 37, 37);
				panel_3_1.add(num2Label_1_1_1);
				
				JLabel equalLabel_1_1_1 = new JLabel("=");
				equalLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
				equalLabel_1_1_1.setForeground(new Color(57, 114, 171));
				equalLabel_1_1_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
				equalLabel_1_1_1.setBounds(491, 57, 37, 37);
				panel_3_1.add(equalLabel_1_1_1);
				
				resultTextField_1_1_1 = new JTextField();
				resultTextField_1_1_1.setBackground(new Color(200, 218, 236));
				resultTextField_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
				resultTextField_1_1_1.setForeground(new Color(57, 114, 171));
				resultTextField_1_1_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
				resultTextField_1_1_1.setBounds(538, 57, 80, 37);
				panel_3_1.add(resultTextField_1_1_1);
				
				Button checkButton = new Button("CHECK");
				checkButton.setBackground(new Color(8, 16, 24));
				checkButton.setForeground(new Color(62, 124, 185));
				checkButton.setFocusable(false);
				checkButton.setFont(new Font("SVN-Agency FB", Font.BOLD, 28));
				checkButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						int e1 = Integer.parseInt(resultTextField.getText());
						int e2 = Integer.parseInt(resultTextField_1.getText());
						int e3 = Integer.parseInt(resultTextField_1_1.getText());
						int e4 = Integer.parseInt(resultTextField_1_1_1.getText());
						int num1 = Integer.parseInt(num1Label.getText());
						int num2 = Integer.parseInt(num2Label.getText());
						int num1_1 = Integer.parseInt(num1Label_1.getText());
						int num2_1 = Integer.parseInt(num2Label_1.getText());
						int num1_1_1 = Integer.parseInt(num1Label_1_1.getText());
						int num2_1_1 = Integer.parseInt(num2Label_1_1.getText());
						int num1_1_1_1 = Integer.parseInt(num1Label_1_1_1.getText());
						int num2_1_1_1 = Integer.parseInt(num2Label_1_1_1.getText());
						
						if ((num1 + num2 == e1) && (num1_1 * num2_1 == e2) && (num1_1_1 - num2_1_1 == e3) && (num1_1_1_1 / num2_1_1_1 == e4)) {
							try {
								float money = MyQuery.getMoney(MyQuery.getIDUser(perLabel));
								money += 100f;
								Connection con = MyConnection.getConnection();
								PreparedStatement ps = con.prepareStatement("UPDATE Information SET Money = ? WHERE UserID = ?");
								ps.setFloat(1, money);
								ps.setInt(2, MyQuery.getIDUser(perLabel));
								if (ps.executeUpdate() != 0) {
									JOptionPane.showConfirmDialog(null, "Correct. You just received $100 into your account");
									
									String per = perLabel.getText();
									
									int index = per.lastIndexOf(" ");
									
									per = per.substring(0, index);
									
									perLabel.setText(per + " " + money);
									
									num1Label.setText("" + MyRan.getRan());
									num2Label.setText("" + MyRan.getRan());
									num1Label_1.setText("" + MyRan.getRan());
									num2Label_1.setText("" + MyRan.getRan());
									num1Label_1_1.setText("" + MyRan.getRan());
									num2Label_1_1.setText("" + MyRan.getRan());
									num1Label_1_1_1.setText("" + MyRan.getRan());
									num2Label_1_1_1.setText("" + MyRan.getRan());		
								}
							} catch (SQLException e5) {
								// TODO Auto-generated catch block
								e5.printStackTrace();
							}
						}
						else 
							JOptionPane.showConfirmDialog(null, "Incorrect. Please try again");
					}
				});
				checkButton.setBounds(691, 10, 123, 84);
				panel_3_1.add(checkButton);
				
				JTextArea txtrNoteResultsOnly = new JTextArea();
				txtrNoteResultsOnly.setEditable(false);
				txtrNoteResultsOnly.setBackground(new Color(200, 218, 236));
				txtrNoteResultsOnly.setFont(new Font("SVN-Agency FB", Font.BOLD, 38));
				txtrNoteResultsOnly.setText("Note: Results only receive integer values.\r\nFor example: 8 / 3 = 2,667 --> Result = 2");
				txtrNoteResultsOnly.setBounds(10, 122, 807, 120);
				panel_3_1.add(txtrNoteResultsOnly);
				
				
				JLabel addFundsLabel_1 = new JLabel("ADD FUNDS");
				addFundsLabel_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						mainPanel.removeAll();
						mainPanel.add(addFundsViewPanel);
						mainPanel.repaint();
						mainPanel.revalidate();
						
						num1Label.setText("" + MyRan.getRan());
						num2Label.setText("" + MyRan.getRan());
						num1Label_1.setText("" + MyRan.getRan());
						num2Label_1.setText("" + MyRan.getRan());
						num1Label_1_1.setText("" + MyRan.getRan());
						num2Label_1_1.setText("" + MyRan.getRan());
						num1Label_1_1_1.setText("" + MyRan.getRan());
						num2Label_1_1_1.setText("" + MyRan.getRan());					
					}
				});
				addFundsLabel_1.setOpaque(true);
				addFundsLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				addFundsLabel_1.setForeground(new Color(62, 124, 185));
				addFundsLabel_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 28));
				addFundsLabel_1.setBackground(new Color(13, 26, 38));
				addFundsLabel_1.setBounds(1027, 11, 107, 38);
				upPanel.add(addFundsLabel_1);
				
				
				JLabel neuoLabel = new JLabel("NEUO");
				neuoLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						mainPanel.removeAll();
						mainPanel.add(homeViewPanel);
						mainPanel.repaint();
						mainPanel.revalidate();
						MyQuery.showYourGameTable(table_1, perLabel);
						fromComboBox.setSelectedItem("");
						toComboBox.setSelectedItem("");
						largerTextField.setText("");
						smallerTextField.setText("");
						genreComboBox.setSelectedItem("");
					}
				});
				upPanel.setLayout(null);
				neuoLabel.setForeground(new Color(62, 124, 185));
				neuoLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 38));
				neuoLabel.setHorizontalAlignment(SwingConstants.CENTER);
				neuoLabel.setBounds(0, 0, 310, 50);
				upPanel.add(neuoLabel);
				
				perLabel = new JLabel();
				perLabel.setOpaque(true);
				perLabel.setBackground(new Color(13, 26, 38));
				perLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						mainPanel.removeAll();
						mainPanel.add(informationViewPanel);
						mainPanel.repaint();
						mainPanel.revalidate();
						MyQuery.setPer(nameTextField, emailTextField, genderComboBox, countryComboBox, perLabel);
					}
				});
				perLabel.setHorizontalAlignment(SwingConstants.CENTER);
				perLabel.setForeground(new Color(62, 124, 185));
				perLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 28));
				perLabel.setBounds(1144, 11, 221, 39);
				upPanel.add(perLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(13, 26, 38));
		panel_1.setBounds(310, 10, 827, 764);
		gamePanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel gameImageLabel = new JLabel("New label");
		gameImageLabel.setBounds(10, 10, 807, 386);
		panel_1.add(gameImageLabel);
		
		Button addCartButton = new Button("ADD CART");
		addCartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String gameName = nameGameLabel.getText();
				String studioName = studioGameLabel.getText();
				
				if (MyCheck.checkGameUserHad(MyQuery.getIDGame(gameName, studioName), MyQuery.getIDUser(perLabel)))
					JOptionPane.showConfirmDialog(null, "The game is available");
				else if (MyCheck.checkCartItemUserHad(MyQuery.getIDGame(gameName, studioName), MyQuery.getIDUser(perLabel)))
					JOptionPane.showConfirmDialog(null, "The game is already in the cart");
				else {
					try {
						Connection con = MyConnection.getConnection();
						PreparedStatement ps = con.prepareStatement("INSERT INTO CartItem (UserID, GameID) VALUES (?, ?);");
						ps.setInt(1, MyQuery.getIDUser(perLabel));
						ps.setInt(2, MyQuery.getIDGame(gameName, studioName));
						int check = ps.executeUpdate();
						
						if (check > 0) {
							JOptionPane.showConfirmDialog(null, "Added cart");
							MyQuery.showYourGameTable(table_1, perLabel);
						}

						else 
							JOptionPane.showConfirmDialog(null, "Something error");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
			}
		});
		addCartButton.setForeground(new Color(62, 124, 185));
		addCartButton.setFont(new Font("SVN-Agency FB", Font.BOLD, 38));
		addCartButton.setFocusable(false);
		addCartButton.setBackground(new Color(8, 16, 24));
		addCartButton.setBounds(10, 700, 807, 54);
		panel_1.add(addCartButton);
		
		JLabel genreGameLabel = new JLabel("");
		genreGameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		genreGameLabel.setForeground(new Color(57, 114, 171));
		genreGameLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		genreGameLabel.setBounds(107, 516, 300, 37);
		panel_1.add(genreGameLabel);
		
		JLabel relYearGameLabel = new JLabel();
		relYearGameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		relYearGameLabel.setForeground(new Color(57, 114, 171));
		relYearGameLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		relYearGameLabel.setBounds(107, 563, 300, 37);
		panel_1.add(relYearGameLabel);
		
		JLabel capacityGameLabel = new JLabel();
		capacityGameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		capacityGameLabel.setForeground(new Color(57, 114, 171));
		capacityGameLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		capacityGameLabel.setBounds(107, 610, 300, 37);
		panel_1.add(capacityGameLabel);
		
		JLabel priceGameLabel = new JLabel();
		priceGameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		priceGameLabel.setForeground(new Color(57, 114, 171));
		priceGameLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		priceGameLabel.setBounds(107, 657, 300, 37);
		panel_1.add(priceGameLabel);
		
		nameGameLabel = new JLabel();
		nameGameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameGameLabel.setForeground(new Color(57, 114, 171));
		nameGameLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 32));
		nameGameLabel.setBounds(10, 406, 390, 53);
		panel_1.add(nameGameLabel);
		
		JTextArea descipGameTextArea = new JTextArea();
		descipGameTextArea.setBackground(new Color(200, 218, 236));
		descipGameTextArea.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		descipGameTextArea.setEditable(false);
		
		JScrollPane scrollPane_1 = new JScrollPane(descipGameTextArea);
		scrollPane_1.setBounds(417, 469, 400, 225);
		panel_1.add(scrollPane_1);
		
		JLabel studioLabel = new JLabel("STUDIO:");
		studioLabel.setHorizontalAlignment(SwingConstants.LEFT);
		studioLabel.setForeground(new Color(57, 114, 171));
		studioLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		studioLabel.setBounds(10, 469, 87, 37);
		panel_1.add(studioLabel);
		
		JLabel genreLabel = new JLabel("GENRE:");
		genreLabel.setHorizontalAlignment(SwingConstants.LEFT);
		genreLabel.setForeground(new Color(57, 114, 171));
		genreLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		genreLabel.setBounds(10, 516, 87, 37);
		panel_1.add(genreLabel);
		
		JLabel relYearLabel = new JLabel("RELEASE:");
		relYearLabel.setHorizontalAlignment(SwingConstants.LEFT);
		relYearLabel.setForeground(new Color(57, 114, 171));
		relYearLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		relYearLabel.setBounds(10, 563, 87, 37);
		panel_1.add(relYearLabel);
		
		JLabel CapacityLabel = new JLabel("CAPACITY:");
		CapacityLabel.setHorizontalAlignment(SwingConstants.LEFT);
		CapacityLabel.setForeground(new Color(57, 114, 171));
		CapacityLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		CapacityLabel.setBounds(10, 610, 87, 37);
		panel_1.add(CapacityLabel);
		
		JLabel priceLabel = new JLabel("PRICE:");
		priceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		priceLabel.setForeground(new Color(57, 114, 171));
		priceLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		priceLabel.setBounds(10, 657, 87, 37);
		panel_1.add(priceLabel);
		
		studioGameLabel = new JLabel();
		studioGameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		studioGameLabel.setForeground(new Color(57, 114, 171));
		studioGameLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		studioGameLabel.setBounds(107, 469, 300, 37);
		panel_1.add(studioGameLabel);
		
		JPanel cartViewPanel = new JPanel();
		cartViewPanel.setBackground(new Color(32, 65, 97));
		mainPanel.add(cartViewPanel, "cartView");
		cartViewPanel.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(13, 26, 38));
		panel_1_1.setBounds(320, 10, 815, 556);
		cartViewPanel.add(panel_1_1);
		
		JLabel totalMoneyLabel = new JLabel();
		totalMoneyLabel.setHorizontalAlignment(SwingConstants.LEFT);
		totalMoneyLabel.setForeground(new Color(57, 114, 171));
		totalMoneyLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		totalMoneyLabel.setBounds(107, 445, 297, 37);
		panel_1_1.add(totalMoneyLabel);
		
		
		table_2 = new JTable();
		table_2.setFocusable(false);
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int[] rowIndex = table_2.getSelectedRows();
				
				float total = 0f;
				for (int row : rowIndex) {
					total += Float.parseFloat(table_2.getValueAt(row, 3).toString());
				}
				totalMoneyLabel.setText("" + total);
			}
		});
		table_2.setFont(new Font("Agency FB", Font.BOLD, 21));
		table_2.setRowHeight(40);
		
		JScrollPane scrollPane_3 = new JScrollPane(table_2);
		scrollPane_3.setBounds(10, 10, 795, 425);
		panel_1_1.add(scrollPane_3);
		

		
		JLabel totalLabel = new JLabel("TOTAL:");
		totalLabel.setHorizontalAlignment(SwingConstants.LEFT);
		totalLabel.setForeground(new Color(57, 114, 171));
		totalLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		totalLabel.setBounds(10, 445, 87, 37);
		panel_1_1.add(totalLabel);
		
		JLabel yourMoneyLabel = new JLabel();
		yourMoneyLabel.setHorizontalAlignment(SwingConstants.LEFT);
		yourMoneyLabel.setForeground(new Color(57, 114, 171));
		yourMoneyLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		yourMoneyLabel.setBounds(539, 445, 266, 37);
		panel_1_1.add(yourMoneyLabel);
		
		JLabel moneyLabel = new JLabel("YOUR MONEY:");
		moneyLabel.setHorizontalAlignment(SwingConstants.LEFT);
		moneyLabel.setForeground(new Color(57, 114, 171));
		moneyLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		moneyLabel.setBounds(412, 445, 117, 37);
		panel_1_1.add(moneyLabel);
		
		Button removeButton = new Button("REMOVE");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyQuery.removeTableCart(table_2, perLabel);
				MyQuery.showTableCart(table_2, MyQuery.getIDUser(perLabel));
			}
		});
		removeButton.setForeground(new Color(62, 124, 185));
		removeButton.setFont(new Font("SVN-Agency FB", Font.BOLD, 38));
		removeButton.setFocusable(false);
		removeButton.setBackground(new Color(8, 16, 24));
		removeButton.setBounds(10, 488, 395, 54);
		panel_1_1.add(removeButton);
		
		Button payButton = new Button("PAY");
		payButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float total = Float.parseFloat(totalMoneyLabel.getText());
				float yourMoney = Float.parseFloat(yourMoneyLabel.getText());
				if (total > yourMoney)
					JOptionPane.showConfirmDialog(null, "Not enough money");
				else {
					try {
						int[] indexRow = table_2.getSelectedRows();
						
						Connection con = null;
						
						for (int row : indexRow) {
							String gameName = table_2.getValueAt(row, 0).toString();
							String studioName = table_2.getValueAt(row, 1).toString();
							con = MyConnection.getConnection();
							PreparedStatement ps = con.prepareStatement("INSERT INTO UsersGame (UserID, GameID) VALUES (?, ?);");
							ps.setInt(1, MyQuery.getIDUser(perLabel));
							ps.setInt(2, MyQuery.getIDGame(gameName, studioName));
							ps.executeUpdate();	
						}
						
						String per = perLabel.getText();
				
						int index = per.lastIndexOf(" ");
						
						per = per.substring(0, index);
						
						perLabel.setText(per + " " + (yourMoney - total));
						PreparedStatement ps1 = con.prepareStatement("UPDATE Information SET Money = ? WHERE UserID = ?");
						ps1.setFloat(1, yourMoney - total);
						ps1.setInt(2, MyQuery.getIDUser(perLabel));
						ps1.executeUpdate();
						MyQuery.removeTableCart(table_2, perLabel);
						yourMoneyLabel.setText("" + (yourMoney - total));
						totalMoneyLabel.setText("" + 0);
						JOptionPane.showConfirmDialog(null, "Payment success");
						MyQuery.showTableCart(table_2, MyQuery.getIDUser(perLabel));
					}
					catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		payButton.setForeground(new Color(62, 124, 185));
		payButton.setFont(new Font("SVN-Agency FB", Font.BOLD, 38));
		payButton.setFocusable(false);
		payButton.setBackground(new Color(8, 16, 24));
		payButton.setBounds(412, 488, 395, 54);
		panel_1_1.add(payButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(13, 26, 38));
		panel_3.setBounds(320, 10, 815, 298);
		ruleViewPanel.add(panel_3);
		panel_3.setLayout(null);
		
		JTextArea ruleTextArea = new JTextArea("All games posted on NEUO are full versions, with no play time limit.\r\n"
				+ "All games have been successfully tested before being uploaded for you to download.\r\n"
				+ "All game download links have been tested and guaranteed to work before being posted to the app.\r\n"
				+ "If you can't play a certain game, it's because your computer can't play it, not because of an error in the posted game.");
		ruleTextArea.setFont(new Font("SVN-Agency FB", Font.BOLD, 28));
		ruleTextArea.setLineWrap(true);
		ruleTextArea.setWrapStyleWord(true);
		ruleTextArea.setBackground(new Color(200, 218, 236));
		ruleTextArea.setEditable(false);
		
		JScrollPane scrollPane_4 = new JScrollPane(ruleTextArea);
		scrollPane_4.setBounds(10, 10, 795, 275);
		panel_3.add(scrollPane_4);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(52, 104, 156)));
		panel.setBackground(new Color(23, 45, 68));
		panel.setBounds(0, 10, 310, 764);
		homeViewPanel.add(panel);
		panel.setLayout(null);
		
		JLabel yourGameLabel = new JLabel("YOUR NAME");
		yourGameLabel.setForeground(new Color(52, 104, 156));
		yourGameLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 18));
		yourGameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		yourGameLabel.setBounds(10, 10, 290, 36);
		panel.add(yourGameLabel);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_1.getSelectedRow();
				String gameName = table_1.getValueAt(index, 0).toString();
				String studioGame = table_1.getValueAt(index, 1).toString();
				
				mainPanel.removeAll();
				mainPanel.add(gamePanel);
				mainPanel.repaint();
				mainPanel.revalidate();
				
				try {
					Connection con = MyConnection.getConnection();
					PreparedStatement ps = con.prepareStatement("SELECT Genre, ReleaseYear, GameCapacity, GameDescription, Image, Price FROM Game WHERE GameName = ? AND StudioName = ?; ");
					ps.setString(1, gameName);
					ps.setString(2, studioGame);
					
					ResultSet rs = ps.executeQuery();
					
					if (rs.next()) {
						nameGameLabel.setText(gameName);
						studioGameLabel.setText(studioGame);
						genreGameLabel.setText(rs.getString("Genre"));
						float capGame = Float.parseFloat(rs.getString("GameCapacity")) / 1024;
						capacityGameLabel.setText(capGame + " GB");
						relYearGameLabel.setText(rs.getString("ReleaseYear"));
						descipGameTextArea.setText(rs.getString("GameDescription"));
						descipGameTextArea.setLineWrap(true);
						descipGameTextArea.setWrapStyleWord(true);
						ImageIcon img = new ImageIcon((new ImageIcon(rs.getBytes("Image"))).getImage().getScaledInstance(gameImageLabel.getWidth(), gameImageLabel.getHeight(), Image.SCALE_SMOOTH));
						gameImageLabel.setIcon(img);
						priceGameLabel.setText(rs.getString("Price"));
					}
				} catch (SQLException ex) {
					Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
		table_1.setFocusable(false);
		MyQuery.showYourGameTable(table_1, perLabel);
		JTableHeader tableHeader_1 = table_1.getTableHeader();
        tableHeader_1.setDefaultRenderer(new MyHeaderColor(new Font("Agency FB", Font.BOLD, 26)));
        table_1.setBackground(new Color(200, 218, 236));
        table_1.setForeground(new Color(27, 55, 82));
        table_1.setFont(new Font("Agency FB", Font.BOLD, 21));
        table_1.setRowHeight(30);
        
		
		JScrollPane scrollPane_2 = new JScrollPane(table_1);
		scrollPane_2.setBounds(10, 56, 290, 697);
		panel.add(scrollPane_2);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(52, 104, 156)));
		panel_2.setBackground(new Color(23, 45, 68));
		panel_2.setBounds(1145, 10, 395, 764);
		homeViewPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel gameLilterLabel = new JLabel("GAME LILTER");
		gameLilterLabel.setOpaque(true);
		gameLilterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameLilterLabel.setForeground(new Color(27, 55, 82));
		gameLilterLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 42));
		gameLilterLabel.setBackground(new Color(52, 104, 156));
		gameLilterLabel.setBounds(0, 0, 395, 65);
		panel_2.add(gameLilterLabel);
		
		JLabel label = new JLabel("New label");
		label.setBounds(58, 60, 45, 13);
		panel_2.add(label);
		
		JLabel fromLabel = new JLabel("From:");
		fromLabel.setForeground(new Color(57, 114, 171));
		fromLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		fromLabel.setBounds(10, 129, 77, 46);
		panel_2.add(fromLabel);
		
		fromComboBox = new JComboBox();
		fromComboBox.setModel(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", ""}));
		fromComboBox.setSelectedItem("");
		fromComboBox.setFocusable(false);
		fromComboBox.setFont(new Font("SVN-Agency FB", Font.PLAIN, 21));
		fromComboBox.setBackground(new Color(200, 218, 236));
		fromComboBox.setBounds(89, 129, 298, 46);
		panel_2.add(fromComboBox);
		
		JLabel toLabel = new JLabel("To:");
		toLabel.setForeground(new Color(57, 114, 171));
		toLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		toLabel.setBounds(10, 185, 77, 46);
		panel_2.add(toLabel);
		
		toComboBox = new JComboBox();
		toComboBox.setModel(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", ""}));
		toComboBox.setSelectedItem("");
		toComboBox.setFocusable(false);
		toComboBox.setFont(new Font("SVN-Agency FB", Font.PLAIN, 21));
		toComboBox.setBackground(new Color(200, 218, 236));
		toComboBox.setBounds(89, 185, 298, 46);
		panel_2.add(toComboBox);
		
		JLabel yearLabel = new JLabel("--Year Of Realese--");
		yearLabel.setHorizontalAlignment(SwingConstants.CENTER);
		yearLabel.setForeground(new Color(57, 114, 171));
		yearLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 26));
		yearLabel.setBounds(109, 75, 181, 46);
		panel_2.add(yearLabel);
		
		JLabel gameDescriptionLabel_1 = new JLabel("--Capacity (GB)--");
		gameDescriptionLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		gameDescriptionLabel_1.setForeground(new Color(57, 114, 171));
		gameDescriptionLabel_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 26));
		gameDescriptionLabel_1.setBounds(109, 241, 181, 46);
		panel_2.add(gameDescriptionLabel_1);
		
		JLabel largerLabel = new JLabel("Larger:");
		largerLabel.setForeground(new Color(57, 114, 171));
		largerLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		largerLabel.setBounds(10, 295, 77, 46);
		panel_2.add(largerLabel);
		
		JLabel smallerLabel = new JLabel("Smaller:");
		smallerLabel.setForeground(new Color(57, 114, 171));
		smallerLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		smallerLabel.setBounds(10, 351, 77, 46);
		panel_2.add(smallerLabel);
		
		smallerTextField = new JTextField();
		smallerTextField.setFont(new Font("SVN-Agency FB", Font.PLAIN, 21));
		smallerTextField.setBackground(new Color(200, 218, 236));
		smallerTextField.setBounds(89, 351, 298, 46);
		panel_2.add(smallerTextField);
		
		largerTextField = new JTextField();
		largerTextField.setFont(new Font("SVN-Agency FB", Font.PLAIN, 21));
		largerTextField.setBackground(new Color(200, 218, 236));
		largerTextField.setBounds(89, 295, 298, 46);
		panel_2.add(largerTextField);
		
		JLabel underLabel = new JLabel("Genre:");
		underLabel.setForeground(new Color(57, 114, 171));
		underLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		underLabel.setBounds(10, 461, 77, 46);
		panel_2.add(underLabel);
		
		JLabel gameGenreLabel = new JLabel("--Game Genre--");
		gameGenreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameGenreLabel.setForeground(new Color(57, 114, 171));
		gameGenreLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 26));
		gameGenreLabel.setBounds(109, 407, 181, 46);
		panel_2.add(gameGenreLabel);
		
		genreComboBox = new JComboBox();
		genreComboBox.setModel(new DefaultComboBoxModel(new String[] {"Adventure", "Action", "Sports", "Simulation", "Platformer", "RPG", "First-person shooter", "Action-adventure", "Fighting", "Real-time strategy", "Racing", "Shooter", "Puzzle", "Casual", "Strategy game", "Massively multiplayer online role-playing", "Stealth", "Party", "Action RPG", "Tactical role-playing", "Survival", "Battle Royale", ""}));
		genreComboBox.setSelectedItem("");
		genreComboBox.setFocusable(false);
		genreComboBox.setFont(new Font("SVN-Agency FB", Font.PLAIN, 21));
		genreComboBox.setBackground(new Color(200, 218, 236));
		genreComboBox.setBounds(89, 461, 298, 46);
		panel_2.add(genreComboBox);
		
		Button filterButton = new Button("FIND");
		filterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fromYear = fromComboBox.getSelectedItem().toString(); 
				String toYear = toComboBox.getSelectedItem().toString(); 
				String largerCap = largerTextField.getText();
				String smallerCap = smallerTextField.getText();
				String genreGame = genreComboBox.getSelectedItem().toString();
				MyQuery.filterGame(fromYear, toYear, largerCap, smallerCap, genreGame, table);
			}
		});
		filterButton.setForeground(new Color(62, 124, 185));
		filterButton.setFont(new Font("SVN-Agency FB", Font.BOLD, 38));
		filterButton.setFocusable(false);
		filterButton.setBackground(new Color(8, 16, 24));
		filterButton.setBounds(10, 533, 375, 74);
		panel_2.add(filterButton);
		
		table = new JTable();
		MyQuery.showHomeTable(table);
		table.setFocusable(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				String gameName = table.getValueAt(index, 0).toString();
				String studioGame = table.getValueAt(index, 1).toString();
				
				mainPanel.removeAll();
				mainPanel.add(gamePanel);
				mainPanel.repaint();
				mainPanel.revalidate();
				
				try {
					Connection con = MyConnection.getConnection();
					PreparedStatement ps = con.prepareStatement("SELECT Genre, ReleaseYear, GameCapacity, GameDescription, Image, Price FROM Game WHERE GameName = ? AND StudioName = ?; ");
					ps.setString(1, gameName);
					ps.setString(2, studioGame);
					
					ResultSet rs = ps.executeQuery();
					
					if (rs.next()) {
						nameGameLabel.setText(gameName);
						studioGameLabel.setText(studioGame);
						genreGameLabel.setText(rs.getString("Genre"));
						float capGame = Float.parseFloat(rs.getString("GameCapacity")) / 1024;
						capacityGameLabel.setText(capGame + " GB");
						relYearGameLabel.setText(rs.getString("ReleaseYear"));
						descipGameTextArea.setText(rs.getString("GameDescription"));
						descipGameTextArea.setLineWrap(true);
						descipGameTextArea.setWrapStyleWord(true);
						ImageIcon img = new ImageIcon((new ImageIcon(rs.getBytes("Image"))).getImage().getScaledInstance(gameImageLabel.getWidth(), gameImageLabel.getHeight(), Image.SCALE_SMOOTH));
						gameImageLabel.setIcon(img);
						priceGameLabel.setText(rs.getString("Price"));
					}
				} catch (SQLException ex) {
					Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(320, 10, 815, 764);
		scrollPane.getViewport().getView().setBackground(new Color(200, 218, 236));
		homeViewPanel.add(scrollPane);
		
		
		
		//InformationView
		JLabel nameLabel = new JLabel("NAME:");
		nameLabel.setForeground(new Color(57, 114, 171));
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		nameLabel.setBounds(320, 49, 75, 37);
		informationViewPanel.add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("SVN-Agency FB", Font.PLAIN, 24));
		nameTextField.setBounds(405, 49, 719, 37);
		informationViewPanel.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel genderLabel = new JLabel("GENDER:");
		genderLabel.setForeground(new Color(57, 114, 171));
		genderLabel.setHorizontalAlignment(SwingConstants.LEFT);
		genderLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		genderLabel.setBounds(320, 96, 75, 37);
		informationViewPanel.add(genderLabel);
		
		genderComboBox = new JComboBox();
		genderComboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		genderComboBox.setFocusable(false);
		genderComboBox.setFont(new Font("SVN-Agency FB", Font.PLAIN, 24));
		genderComboBox.setBounds(405, 96, 186, 37);
		informationViewPanel.add(genderComboBox);
		
		JLabel emailLabel = new JLabel("EMAIL:");
		emailLabel.setForeground(new Color(57, 114, 171));
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		emailLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		emailLabel.setBounds(320, 147, 75, 37);
		informationViewPanel.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("SVN-Agency FB", Font.PLAIN, 24));
		emailTextField.setColumns(10);
		emailTextField.setBounds(405, 147, 719, 37);
		informationViewPanel.add(emailTextField);
		
		JLabel countryLabel = new JLabel("COUNTRY:");
		countryLabel.setForeground(new Color(57, 114, 171));
		countryLabel.setHorizontalAlignment(SwingConstants.LEFT);
		countryLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 24));
		countryLabel.setBounds(601, 96, 87, 37);
		informationViewPanel.add(countryLabel);
		
		countryComboBox = new JComboBox();
		countryComboBox.setFont(new Font("SVN-Agency FB", Font.PLAIN, 24));
		countryComboBox.setModel(new DefaultComboBoxModel(new String[] {"Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Côte d'Ivoire", "Cabo Verde", "Cambodia", "Cameroon", "Canada", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo (Congo-Brazzaville)", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czechia (Czech Republic)", "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini (fmr. \"Swaziland\")", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Holy See", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar (formerly Burma)", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Korea", "North Macedonia", "Norway", "Oman", "Pakistan", "Palau", "Palestine State", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Korea", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Tajikistan", "Tanzania", "Thailand", "Timor-Leste", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States of America", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"}));
		countryComboBox.setFocusable(false);
		countryComboBox.setBounds(698, 96, 426, 37);
		informationViewPanel.add(countryComboBox);
		

		// set Infor
		
		Button updateButton = new Button("UPDATE");
		updateButton.setFocusable(false);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyQuery.updateData(nameTextField, emailTextField, genderComboBox, countryComboBox, perLabel);
			}
		});
		updateButton.setFont(new Font("SVN-Agency FB", Font.BOLD, 38));
		updateButton.setForeground(new Color(62, 124, 185));
		updateButton.setBackground(new Color(8, 16, 24));
		updateButton.setBounds(320, 204, 804, 54);
		informationViewPanel.add(updateButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(13, 26, 38));
		lblNewLabel.setBounds(310, 10, 827, 262);
		informationViewPanel.add(lblNewLabel);;
		
		
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new EnterAccountVIew();
			}
		});
		lblNewLabel_1.setBounds(1488, 11, 42, 35);
		ImageIcon im = new ImageIcon("C:\\Users\\PHILONG\\Downloads\\Photo\\logout.png");
		Image ig = im.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon igC= new ImageIcon(ig);
		lblNewLabel_1.setIcon(igC);
		upPanel.add(lblNewLabel_1);
		
		JLabel cartLabel = new JLabel(" CART");
		cartLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainPanel.removeAll();
				mainPanel.add(cartViewPanel);
				mainPanel.repaint();
				mainPanel.revalidate();
				MyQuery.showTableCart(table_2, MyQuery.getIDUser(perLabel));
				
				String username = perLabel.getText();
				
				int index = username.indexOf(' ');
				
				if (index != -1)
					username = username.substring(0, index);
			
				try {
					Connection con = MyConnection.getConnection();
					PreparedStatement ps = con.prepareStatement("SELECT Money FROM Information WHERE Username = ?");
					ps.setString(1, username);
					ResultSet rs = ps.executeQuery();
					if (rs.next())
						yourMoneyLabel.setText("" + rs.getFloat("Money"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		cartLabel.setIcon(new ImageIcon("C:\\Users\\PHILONG\\Downloads\\Photo\\cart.png"));
		cartLabel.setOpaque(true);
		cartLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cartLabel.setForeground(new Color(62, 124, 185));
		cartLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 28));
		cartLabel.setBackground(new Color(13, 26, 38));
		cartLabel.setBounds(1375, 8, 103, 42);
		upPanel.add(cartLabel);
		
		setVisible(true);
	}
	
	
	public JLabel getPerLabel() {
		return perLabel;
	}

	public JTable getTable_1() {
		return table_1;
	}
	// Select Data into Home Table
//	public void selectHomeTable() {
//		
//		try {
//			Connection con = MyConnection.getConnection();
//			PreparedStatement ps = con.prepareStatement("SELECT * FROM Game;");
//			ResultSet rs = ps.executeQuery();
//			table.setModel(new MyTableHome(rs));
//			JTableHeader tableHeader = table.getTableHeader();
//	        tableHeader.setDefaultRenderer(new MyHeaderColor(new Font("Agency FB", Font.BOLD, 26)));
//	        table.setBackground(new Color(200, 218, 236));
//	        table.setForeground(new Color(27, 55, 82));
//	        table.setFont(new Font("Agency FB", Font.BOLD, 21));
//	        table.setRowHeight(40);
//		} catch (SQLException ex) {
//			Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
//		}
//	}




	// Select Data into Cart Table
//	public void selectCartTable() {
//		
//		int userID = getIDUser();
//		
//		try {
//			Connection con = MyConnection.getConnection();
//			PreparedStatement ps = con.prepareStatement("SELECT GameName, StudioName, Genre, Price FROM (CartItem INNER JOIN Game ON CartItem.GameID = Game.GameID) WHERE UserID = ?;");
//			ps.setInt(1, userID);
//			ResultSet rs = ps.executeQuery();
//			table_2.setModel(new MyTableCart(rs));
//			JTableHeader tableHeader = table_2.getTableHeader();
//	        tableHeader.setDefaultRenderer(new MyHeaderColor(new Font("Agency FB", Font.BOLD, 26)));
//			table_2.setBackground(new Color(200, 218, 236));
//			table_2.setForeground(new Color(27, 55, 82));
//			table_2.setFont(new Font("Agency FB", Font.BOLD, 21));
//			table_2.setRowHeight(40);
//		} catch (SQLException ex) {
//			Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
//		}
//	}
	// Select Dara into Your Game Table
	
//	public void selectYourGameTable() {
//		int userID = getIDUser();
//		
//		try {
//			Connection con = MyConnection.getConnection();
//			PreparedStatement ps = con.prepareStatement("SELECT GameName, StudioName FROM UsersGame INNER JOIN Game ON UsersGame.GameID = Game.GameID WHERE UserID = ?;");
//			ps.setInt(1, userID);
//			ResultSet rs = ps.executeQuery();
//			table_1.setModel(new MyTableYourGame(rs));
//			JTableHeader tableHeader = table_1.getTableHeader();
//	        tableHeader.setDefaultRenderer(new MyHeaderColor(new Font("Agency FB", Font.BOLD, 26)));
//			table_1.setBackground(new Color(200, 218, 236));
//			table_1.setForeground(new Color(27, 55, 82));
//			table_1.setFont(new Font("Agency FB", Font.BOLD, 21));
//			table_1.setRowHeight(40);
//		} catch (SQLException ex) {
//			Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
//		}
//	}
	
	// Set Personal
//	public void setPer() {
//		
//		String username = perLabel.getText();
//		
//		int index = username.indexOf(' ');
//		
//		if (index != -1)
//			username = username.substring(0, index);
//		
//		
//		try {
//			Connection con = MyConnection.getConnection();
//			PreparedStatement ps = con.prepareStatement("SELECT Email, Country, Gender FROM Information WHERE Username = ?;");
//			ps.setString(1, username);
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				nameTextField.setText(username);
//				emailTextField.setText(rs.getString("Email"));
//				genderComboBox.setSelectedItem(rs.getString("Gender"));
//				countryComboBox.setSelectedItem(rs.getString("Country"));
//			}
//		} catch (SQLException ex) {
//			Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
//		}
//	}

	// Update data Personal
//	public void updateData() {
//		String name = nameTextField.getText();
//		String email = emailTextField.getText();
//		String gender = genderComboBox.getSelectedItem().toString();
//		String country = countryComboBox.getSelectedItem().toString();
//		int ID = getIDUser();
//		
//		if (name.matches("") || email.matches("") || gender.matches("") || country.matches(""))
//			JOptionPane.showConfirmDialog(null, "Check Your Enter Again");
//		else {
//			try {
//				Connection con = MyConnection.getConnection();
//				PreparedStatement ps = con.prepareStatement("UPDATE Information SET Username = ?, Email = ?, Country = ?, Gender = ? WHERE UserID = ?;");
//				ps.setString(1, name);
//				ps.setString(2, email);
//				ps.setString(3, country);
//				ps.setString(4, gender);
//				ps.setInt(5, ID);
//				if (ps.executeUpdate() != 0)
//					JOptionPane.showConfirmDialog(null, "Updated");
//				else
//					JOptionPane.showConfirmDialog(null, "Something Error");
//			} catch (SQLException ex) {
//				Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
//			}
//		}
//	}
	// REMOVE DATA CART TABLE;
	
//	public void removeTableCart() {
//		
//		int[] rowIndex = table_2.getSelectedRows();
//		
//		try {
//			for (int row : rowIndex) {
//				String gameName = table_2.getValueAt(row, 0).toString();
//				String studioname = table_2.getValueAt(row, 1).toString();
//				int gameID = getIDGame(gameName, studioname);
//				int userID = getIDUser();
//				Connection con = MyConnection.getConnection();
//				PreparedStatement ps = con.prepareStatement("DELETE FROM CartItem WHERE UserID = ? AND GameID = ?;");
//				ps.setInt(1, userID);
//				ps.setInt(2, gameID);
//				ps.executeUpdate();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	
	// Get ID User 
//	public int getIDUser() {
//		
//		String username = perLabel.getText();
//		
//		int id = 0;
//		
//		int index = username.indexOf(' ');
//		
//		if (index != -1)
//			username = username.substring(0, index);
//		try {
//			Connection con = MyConnection.getConnection();
//			PreparedStatement ps = con.prepareStatement("SELECT UserID FROM Information WHERE Username = ?;");
//			ps.setString(1, username);
//			ResultSet rs = ps.executeQuery();
//			if (rs.next())
//				id = rs.getInt("UserID");
//		} catch (SQLException ex) {
//			// TODO Auto-generated catch block
//			Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		return id;
//	}
	
	// Ger ID Game
//	public int getIDGame(String gameName, String studioName) {
//		int id = 0;
//		
//		Connection con = MyConnection.getConnection();
//		try {
//			PreparedStatement ps = con.prepareStatement("SELECT GameID FROM Game WHERE GameName = ? AND StudioName = ?;");
//			ps.setString(1, gameName);
//			ps.setString(2, studioName);
//			ResultSet rs = ps.executeQuery();
//			if (rs.next())
//				id = rs.getInt("GameID");
//		} catch (SQLException ex) {
//			Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		return id;
//	}
	// Chech CartItem
//	public boolean isCartItemHad(int gameID, int userID) {
//		
//		try {
//			Connection con = MyConnection.getConnection();
//			PreparedStatement ps = con.prepareStatement("SELECT * FROM CartItem WHERE UserID = ? AND GameID = ?");
//			ps.setInt(1, userID);
//			ps.setInt(2, gameID);
//			ResultSet rs = ps.executeQuery();
//			
//			if (rs.next())
//				return true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return false;
//	}
//	public boolean isGameHad(int gameID, int userID) {
//		
//		try {
//			Connection con = MyConnection.getConnection();
//			PreparedStatement ps = con.prepareStatement("SELECT * FROM UsersGame WHERE UserID = ? AND GameID = ?");
//			ps.setInt(1, userID);
//			ps.setInt(2, gameID);
//			ResultSet rs = ps.executeQuery();
//			if (rs.next())
//				return true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}
	
//	public float getMoney(int userID) {
//		float money = 0f;
//		try {
//			Connection con = MyConnection.getConnection();
//			PreparedStatement ps = con.prepareStatement("SELECT Money FROM Information WHERE UserID = ?;");
//			ps.setInt(1, userID);
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				money = rs.getFloat("Money");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return money;
//	}
}
