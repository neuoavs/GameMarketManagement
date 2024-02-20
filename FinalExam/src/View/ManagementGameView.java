package View;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Button;
import javax.swing.JTable;
import javax.swing.JLabel;


import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import Controller.MyChooseImage;

import Controller.MyQuery;


import java.awt.event.ActionListener;


import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.CardLayout;


public class ManagementGameView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField gameNameTextField;
	private JTextField studioNameTextField;
	private JTextField gameCapacityTextField;
	private JTextField priceTextField;
	private JLabel imageLabel;
	private JComboBox gameGenreComboBox;
	private JComboBox releaseYearComboBox;

	private JTextArea gameDescriptionTextArea;
	private JTable table;
	private JTextField gameNameTextField_1;
	private JTextField studioNameTextField_1;
	
	private JTable table_1;
	private JTextField usernameTextField;
	private JTextField passTextField;
	private JTextField emailTextField;
	private JComboBox genderComboBox;
	private JComboBox countryComboBox;
	
	private JTextField usernameTextField_1;
	private JTextField emailTextField_1;
	private JComboBox genderComboBox_1;
	private JComboBox countryComboBox_1;
	private JTextField moneyTextField;;

	String usernameEmpty = "";
	String gameNameEmpty = "";
	String studioNameEmpty = "";
	
	
	
	public ManagementGameView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(8, 16, 24));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1540, 790);
		contentPane.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JPanel game = new JPanel();
		game.setBackground(new Color(3, 6, 9));
		panel_1.add(game, "name_391959430771900");
		game.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(1179, 5, 360, 378);
		panel.setBackground(new Color(3, 6, 9));
		panel.setLayout(null);
		game.add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 383, 1530, 412);
		panel_2.setBackground(new Color(32, 65, 97));
		panel_2.setLayout(null);
		game.add(panel_2);
		
		JLabel studioNameLabel = new JLabel("STUDIO NAME:");
		studioNameLabel.setForeground(new Color(57, 114, 171));
		studioNameLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		studioNameLabel.setBounds(10, 66, 117, 46);
		panel_2.add(studioNameLabel);
		
		JLabel gameNameLabel = new JLabel("GAME NAME:");
		gameNameLabel.setForeground(new Color(57, 114, 171));
		gameNameLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		gameNameLabel.setBounds(10, 10, 117, 46);
		panel_2.add(gameNameLabel);
		
		gameNameTextField = new JTextField();
		gameNameTextField.setBackground(new Color(200, 218, 236));
		gameNameTextField.setFont(new Font("SVN-Agency FB", Font.PLAIN, 21));
		gameNameTextField.setBounds(129, 10, 258, 46);
		panel_2.add(gameNameTextField);
		gameNameTextField.setColumns(10);
		
		studioNameTextField = new JTextField();
		studioNameTextField.setBackground(new Color(200, 218, 236));
		studioNameTextField.setFont(new Font("SVN-Agency FB", Font.PLAIN, 21));
		studioNameTextField.setColumns(10);
		studioNameTextField.setBounds(129, 66, 258, 46);
		panel_2.add(studioNameTextField);
		
		JLabel gameGenreLabel = new JLabel("GAME GENRE:");
		gameGenreLabel.setForeground(new Color(57, 114, 171));
		gameGenreLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		gameGenreLabel.setBounds(10, 122, 117, 46);
		panel_2.add(gameGenreLabel);
		
		gameGenreComboBox = new JComboBox();
		gameGenreComboBox.setModel(new DefaultComboBoxModel(new String[] {"Adventure", "Action", "Sports", "Simulation", "Platformer", "RPG", "First-person shooter", "Action-adventure", "Fighting", "Real-time strategy", "Racing", "Shooter", "Puzzle", "Casual", "Strategy game", "Massively multiplayer online role-playing", "Stealth", "Party", "Action RPG", "Tactical role-playing", "Survival", "Battle Royale", ""}));
		gameGenreComboBox.setSelectedItem("");
		gameGenreComboBox.setFont(new Font("Agency FB", Font.PLAIN, 21));
		gameGenreComboBox.setFocusable(false);
		gameGenreComboBox.setBackground(new Color(200, 218, 236));
		gameGenreComboBox.setBounds(129, 122, 258, 46);
		panel_2.add(gameGenreComboBox);
		
		JLabel releaseYearLabel = new JLabel("RELEASE YEAR:");
		releaseYearLabel.setForeground(new Color(57, 114, 171));
		releaseYearLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		releaseYearLabel.setBounds(10, 178, 117, 46);
		panel_2.add(releaseYearLabel);
		
		releaseYearComboBox = new JComboBox(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", ""}));
		releaseYearComboBox.setSelectedItem("");;
		releaseYearComboBox.setFont(new Font("Agency FB", Font.PLAIN, 21));
		releaseYearComboBox.setFocusable(false);
		releaseYearComboBox.setBackground(new Color(200, 218, 236));
		releaseYearComboBox.setBounds(129, 178, 258, 46);
		panel_2.add(releaseYearComboBox);
		
		releaseYearComboBox.setSelectedItem("");
		gameGenreComboBox.setSelectedItem("");
		JLabel studioNameLabel_1_1 = new JLabel("GAME CAPACITY:");
		studioNameLabel_1_1.setForeground(new Color(57, 114, 171));
		studioNameLabel_1_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		studioNameLabel_1_1.setBounds(10, 234, 117, 46);
		panel_2.add(studioNameLabel_1_1);
		
		gameCapacityTextField = new JTextField();
		gameCapacityTextField.setBackground(new Color(200, 218, 236));
		gameCapacityTextField.setFont(new Font("SVN-Agency FB", Font.PLAIN, 21));
		gameCapacityTextField.setColumns(10);
		gameCapacityTextField.setBounds(129, 234, 258, 46);
		panel_2.add(gameCapacityTextField);
		
		JLabel priceLabel = new JLabel("PRICE:");
		priceLabel.setForeground(new Color(57, 114, 171));
		priceLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		priceLabel.setBounds(10, 290, 117, 46);
		panel_2.add(priceLabel);
		
		priceTextField = new JTextField();
		priceTextField.setBackground(new Color(200, 218, 236));
		priceTextField.setFont(new Font("SVN-Agency FB", Font.PLAIN, 21));
		priceTextField.setColumns(10);
		priceTextField.setBounds(129, 290, 258, 46);
		panel_2.add(priceTextField);
		
		imageLabel = new JLabel("");
		imageLabel.setOpaque(true);
		imageLabel.setBackground(new Color(200, 218, 236));
		imageLabel.setBounds(707, 66, 270, 270);
		panel_2.add(imageLabel);
		
		JLabel gameDescriptionLabel = new JLabel("GAME DESCRIPTION:");
		gameDescriptionLabel.setForeground(new Color(57, 114, 171));
		gameDescriptionLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		gameDescriptionLabel.setBounds(397, 10, 151, 46);
		panel_2.add(gameDescriptionLabel);
		
		JLabel gameImageLabel = new JLabel("GAME IMAGE:");
		gameImageLabel.setForeground(new Color(57, 114, 171));
		gameImageLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		gameImageLabel.setBounds(708, 10, 100, 46);
		panel_2.add(gameImageLabel);
		
		Button chooseButton = new Button("Choose Image");
		chooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyQuery.imagePath = MyChooseImage.chooseImage(imageLabel);
			}
		});
		chooseButton.setForeground(new Color(42, 84, 127));
		chooseButton.setFont(new Font("SVN-Agency FB", Font.BOLD, 16));
		chooseButton.setFocusable(false);
		chooseButton.setBackground(new Color(134, 174, 215));
		chooseButton.setBounds(856, 10, 121, 46);
		panel_2.add(chooseButton);
		
		gameDescriptionTextArea = new JTextArea();
		gameDescriptionTextArea.setLineWrap(true);
		gameDescriptionTextArea.setWrapStyleWord(true);
		gameDescriptionTextArea.setFont(new Font("SVN-Agency FB", Font.PLAIN, 21));
		gameDescriptionTextArea.setBackground(new Color(200, 218, 236));
		
		Button addButton = new Button("ADD");
		addButton.setBackground(new Color(52, 104, 156));
		addButton.setForeground(new Color(27, 55, 82));
		addButton.setFocusable(false);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gameName = gameNameTextField.getText();
				String studioName = studioNameTextField.getText();
				String gameGenre = gameGenreComboBox.getSelectedItem().toString();
				int releaseYear = Integer.parseInt(releaseYearComboBox.getSelectedItem().toString());
				int gameCapacity = Integer.parseInt(gameCapacityTextField.getText());
				String gameDescription = gameDescriptionTextArea.getText();
				float price = Float.parseFloat(priceTextField.getText());
				
				
				MyQuery.addGame(gameName, studioName, gameGenre, releaseYear, gameCapacity, gameDescription, price, imageLabel, (ImageIcon) imageLabel.getIcon());
				MyQuery.showGame(table);
				gameNameTextField.setText("");
				studioNameTextField.setText("");
				gameGenreComboBox.setSelectedItem("");
				releaseYearComboBox.setSelectedItem("");
				gameCapacityTextField.setText("");
				gameDescriptionTextArea.setText("");
				imageLabel.setIcon(null);
				priceTextField.setText("");
			}
		});
		addButton.setFont(new Font("SVN-Agency FB", Font.BOLD, 32));
		addButton.setBounds(0, 10, 356, 67);
		panel.add(addButton);
		
		Button removeButton = new Button("REMOVE");
		removeButton.setBackground(new Color(52, 104, 156));
		removeButton.setForeground(new Color(27, 55, 82));
		removeButton.setFocusable(false);
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyQuery.delGame(table);
				MyQuery.showGame(table);
				gameNameTextField.setText("");
				studioNameTextField.setText("");
				gameGenreComboBox.setSelectedItem("");
				releaseYearComboBox.setSelectedItem("");
				gameCapacityTextField.setText("");
				gameDescriptionTextArea.setText("");
				imageLabel.setIcon(null);
				priceTextField.setText("");
			}
		});
		removeButton.setFont(new Font("SVN-Agency FB", Font.BOLD, 32));
		removeButton.setBounds(0, 83, 356, 67);
		panel.add(removeButton);
		
		Button updateButton = new Button("UPDATE");
		updateButton.setBackground(new Color(52, 104, 156));
		updateButton.setForeground(new Color(27, 55, 82));
		updateButton.setFocusable(false);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gameName = gameNameTextField.getText();
				String studioName = studioNameTextField.getText();
				String gameGenre = gameGenreComboBox.getSelectedItem().toString();
				int releaseYear = Integer.parseInt(releaseYearComboBox.getSelectedItem().toString());
				int gameCapacity = Integer.parseInt(gameCapacityTextField.getText());
				String gameDescription = gameDescriptionTextArea.getText();
				float price = Float.parseFloat(priceTextField.getText());
				MyQuery.updateGame(gameName, studioName, gameNameEmpty, studioNameEmpty, gameGenre, releaseYear, gameCapacity, gameDescription, price, imageLabel, (ImageIcon) imageLabel.getIcon(), table);
				MyQuery.showGame(table);
				gameNameTextField.setText("");
				studioNameTextField.setText("");
				gameGenreComboBox.setSelectedItem("");
				releaseYearComboBox.setSelectedItem("");
				gameCapacityTextField.setText("");
				gameDescriptionTextArea.setText("");
				imageLabel.setIcon(null);
				priceTextField.setText("");
			}
		});
		updateButton.setFont(new Font("SVN-Agency FB", Font.BOLD, 32));
		updateButton.setBounds(0, 156, 356, 67);
		panel.add(updateButton);;
		
		Button findButton = new Button("FIND");
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gameName = gameNameTextField_1.getText();
				String studioName = studioNameTextField_1.getText();
				MyQuery.findGame(table, gameName, studioName);
				gameNameTextField.setText("");
				studioNameTextField.setText("");
				gameGenreComboBox.setSelectedItem("");
				releaseYearComboBox.setSelectedItem("");
				gameCapacityTextField.setText("");
				gameDescriptionTextArea.setText("");
				imageLabel.setIcon(null);
				priceTextField.setText("");
			}
		});
		findButton.setForeground(new Color(27, 55, 82));
		findButton.setFont(new Font("SVN-Agency FB", Font.BOLD, 32));
		findButton.setFocusable(false);
		findButton.setBackground(new Color(52, 104, 156));
		findButton.setBounds(0, 229, 356, 67);
		panel.add(findButton);
		
		Button showButton = new Button("SHOW");
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyQuery.showGame(table);
				gameNameTextField.setText("");
				studioNameTextField.setText("");
				gameGenreComboBox.setSelectedItem("");
				releaseYearComboBox.setSelectedItem("");
				gameCapacityTextField.setText("");
				gameDescriptionTextArea.setText("");
				imageLabel.setIcon(null);
				priceTextField.setText("");
			}
		});
		showButton.setForeground(new Color(27, 55, 82));
		showButton.setFont(new Font("SVN-Agency FB", Font.BOLD, 32));
		showButton.setFocusable(false);
		showButton.setBackground(new Color(52, 104, 156));
		showButton.setBounds(0, 302, 356, 67);
		panel.add(showButton);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int rowIndex = table.getSelectedRow();
				gameNameTextField.setText(table.getValueAt(rowIndex, 1).toString());
				gameNameEmpty = gameNameTextField.getText();
				studioNameTextField.setText(table.getValueAt(rowIndex, 2).toString());
				studioNameEmpty = studioNameTextField.getText();
				gameGenreComboBox.setSelectedItem(table.getValueAt(rowIndex, 3));
				releaseYearComboBox.setSelectedItem(table.getValueAt(rowIndex, 4).toString());
				gameCapacityTextField.setText(table.getValueAt(rowIndex, 5).toString());
				gameDescriptionTextArea.setText(table.getValueAt(rowIndex, 6).toString());
				ImageIcon img = (ImageIcon) table.getValueAt(rowIndex, 7);
				imageLabel.setIcon(new ImageIcon(img.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH)));
				priceTextField.setText(table.getValueAt(rowIndex, 8).toString());
			}
		});
		table.setFocusable(false);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(5, 15, 1165, 359);
		scrollPane.setOpaque(true);
		scrollPane.setBackground(new Color(3, 6, 8));
		game.add(scrollPane);
		
		JPanel user = new JPanel();
		user.setBackground(new Color(3, 6, 9));
		panel_1.add(user, "name_392789679746300");
		user.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(3, 6, 9));
		panel_3.setBounds(1179, 5, 360, 378);
		user.add(panel_3);
		
		JScrollPane scrollPane_1 = new JScrollPane(gameDescriptionTextArea);
		scrollPane_1.setBounds(397, 66, 300, 270);
		panel_2.add(scrollPane_1);
		
		gameNameTextField_1 = new JTextField();
		gameNameTextField_1.setFont(new Font("SVN-Agency FB", Font.PLAIN, 21));
		gameNameTextField_1.setColumns(10);
		gameNameTextField_1.setBackground(new Color(200, 218, 236));
		gameNameTextField_1.setBounds(1093, 66, 427, 46);
		panel_2.add(gameNameTextField_1);
		
		JLabel studioNameLabel_1 = new JLabel("STUDIO NAME:");
		studioNameLabel_1.setForeground(new Color(57, 114, 171));
		studioNameLabel_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		studioNameLabel_1.setBounds(987, 122, 100, 46);
		panel_2.add(studioNameLabel_1);
		
		JLabel gameNameLabel_1 = new JLabel("GAME NAME:");
		gameNameLabel_1.setForeground(new Color(57, 114, 171));
		gameNameLabel_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		gameNameLabel_1.setBounds(987, 66, 100, 46);
		panel_2.add(gameNameLabel_1);
		
		JLabel searchLabel = new JLabel("SEARCH:");
		searchLabel.setForeground(new Color(57, 114, 171));
		searchLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		searchLabel.setBounds(987, 10, 100, 46);
		panel_2.add(searchLabel);
		
		studioNameTextField_1 = new JTextField();
		studioNameTextField_1.setFont(new Font("SVN-Agency FB", Font.PLAIN, 21));
		studioNameTextField_1.setColumns(10);
		studioNameTextField_1.setBackground(new Color(200, 218, 236));
		studioNameTextField_1.setBounds(1093, 122, 427, 46);
		panel_2.add(studioNameTextField_1);
		
		
		Button addButton_1 = new Button("ADD");
		addButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameTextField.getText();
				String password = passTextField.getText();
				String email = emailTextField.getText();
				String country = countryComboBox.getSelectedItem().toString();
				String gender = genderComboBox.getSelectedItem().toString();
				String money = moneyTextField.getText();
				
				MyQuery.addUser(username, password, email, country, gender, money);
				MyQuery.showUser(table_1);;
				
				usernameTextField.setText("");
				passTextField.setText("");
				emailTextField.setText("");
				countryComboBox.setSelectedItem("");
				genderComboBox.setSelectedItem("");
				moneyTextField.setText("");
			}
		});
		addButton_1.setForeground(new Color(27, 55, 82));
		addButton_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 32));
		addButton_1.setFocusable(false);
		addButton_1.setBackground(new Color(52, 104, 156));
		addButton_1.setBounds(0, 10, 356, 67);
		panel_3.add(addButton_1);
		
		Button removeButton_1 = new Button("REMOVE");
		removeButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyQuery.delUser(table_1);
				MyQuery.showUser(table_1);
				
				usernameTextField.setText("");
				passTextField.setText("");
				emailTextField.setText("");
				countryComboBox.setSelectedItem("");
				genderComboBox.setSelectedItem("");
				moneyTextField.setText("");
			}
		});
		removeButton_1.setForeground(new Color(27, 55, 82));
		removeButton_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 32));
		removeButton_1.setFocusable(false);
		removeButton_1.setBackground(new Color(52, 104, 156));
		removeButton_1.setBounds(0, 83, 356, 67);
		panel_3.add(removeButton_1);
		
		Button updateButton_1 = new Button("UPDATE");
		updateButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameTextField.getText();
				String password = passTextField.getText();
				String email = emailTextField.getText();
				String country = countryComboBox.getSelectedItem().toString();
				String gender = genderComboBox.getSelectedItem().toString();
				String money = moneyTextField.getText();
				
				MyQuery.updateUser(username, usernameEmpty, password, email, country, gender, money, table_1);
				MyQuery.showUser(table_1);
				
				usernameTextField.setText("");
				passTextField.setText("");
				emailTextField.setText("");
				countryComboBox.setSelectedItem("");
				genderComboBox.setSelectedItem("");
				moneyTextField.setText("");
			}
		});
		updateButton_1.setForeground(new Color(27, 55, 82));
		updateButton_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 32));
		updateButton_1.setFocusable(false);
		updateButton_1.setBackground(new Color(52, 104, 156));
		updateButton_1.setBounds(0, 156, 356, 67);
		panel_3.add(updateButton_1);
		
		Button findButton_1 = new Button("FIND");
		findButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameTextField_1.getText();
				String email = emailTextField_1.getText();
				String gender = genderComboBox_1.getSelectedItem().toString();
				String country = countryComboBox_1.getSelectedItem().toString();
				
				MyQuery.findUser(username, email, gender, country, table_1);
				
				usernameTextField.setText("");
				passTextField.setText("");
				emailTextField.setText("");
				countryComboBox.setSelectedItem("");
				genderComboBox.setSelectedItem("");
				moneyTextField.setText("");
			}
		});
		findButton_1.setForeground(new Color(27, 55, 82));
		findButton_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 32));
		findButton_1.setFocusable(false);
		findButton_1.setBackground(new Color(52, 104, 156));
		findButton_1.setBounds(0, 229, 356, 67);
		panel_3.add(findButton_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex = table_1.getSelectedRow();
				usernameTextField.setText(table_1.getValueAt(rowIndex, 1).toString());
				usernameEmpty = usernameTextField.getText();
				passTextField.setText(table_1.getValueAt(rowIndex, 2).toString());
				emailTextField.setText(table_1.getValueAt(rowIndex, 3).toString());
				countryComboBox.setSelectedItem(table_1.getValueAt(rowIndex, 4));
				genderComboBox.setSelectedItem(table_1.getValueAt(rowIndex, 6));
				moneyTextField.setText(table_1.getValueAt(rowIndex, 5).toString());
				
			}
		});
		
		JScrollPane scrollPane_2 = new JScrollPane(table_1);
		scrollPane_2.setBounds(5, 15, 1165, 359);
		scrollPane_2.setOpaque(true);
		scrollPane_2.setBackground(new Color(3, 6, 8));
		user.add(scrollPane_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(32, 65, 97));
		panel_2_1.setBounds(5, 384, 1530, 412);
		user.add(panel_2_1);
		
		JLabel usernameLabel = new JLabel("USERNAME:");
		usernameLabel.setForeground(new Color(57, 114, 171));
		usernameLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		usernameLabel.setBounds(10, 10, 117, 46);
		panel_2_1.add(usernameLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("SVN-Agency FB", Font.PLAIN, 21));
		usernameTextField.setColumns(10);
		usernameTextField.setBackground(new Color(200, 218, 236));
		usernameTextField.setBounds(129, 10, 431, 46);
		panel_2_1.add(usernameTextField);
		
		genderComboBox = new JComboBox();
		genderComboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", ""}));
		genderComboBox.setSelectedItem("");
		genderComboBox.setFont(new Font("Agency FB", Font.PLAIN, 21));
		genderComboBox.setFocusable(false);
		genderComboBox.setBackground(new Color(200, 218, 236));
		genderComboBox.setBounds(689, 10, 288, 46);
		panel_2_1.add(genderComboBox);
		
		countryComboBox = new JComboBox();
		countryComboBox.setModel(new DefaultComboBoxModel(new String[] {"Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Côte d'Ivoire", "Cabo Verde", "Cambodia", "Cameroon", "Canada", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo (Congo-Brazzaville)", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czechia (Czech Republic)", "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini (fmr. \"Swaziland\")", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Holy See", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar (formerly Burma)", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Korea", "North Macedonia", "Norway", "Oman", "Pakistan", "Palau", "Palestine State", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Korea", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Tajikistan", "Tanzania", "Thailand", "Timor-Leste", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States of America", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe", ""}));
		countryComboBox.setSelectedItem("");
		countryComboBox.setFont(new Font("Agency FB", Font.PLAIN, 21));
		countryComboBox.setFocusable(false);
		countryComboBox.setBackground(new Color(200, 218, 236));
		countryComboBox.setBounds(689, 66, 288, 46);
		panel_2_1.add(countryComboBox);
		
		JLabel countryLabel = new JLabel("COUNTRY");
		countryLabel.setForeground(new Color(57, 114, 171));
		countryLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		countryLabel.setBounds(570, 66, 117, 46);
		panel_2_1.add(countryLabel);
		
		JLabel genderLabel = new JLabel("GENDER:");
		genderLabel.setForeground(new Color(57, 114, 171));
		genderLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		genderLabel.setBounds(570, 10, 117, 46);
		panel_2_1.add(genderLabel);
		
		JLabel passLabel = new JLabel("PASSWORD:");
		passLabel.setForeground(new Color(57, 114, 171));
		passLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		passLabel.setBounds(10, 66, 117, 46);
		panel_2_1.add(passLabel);
		
		passTextField = new JTextField();
		passTextField.setFont(new Font("SVN-Agency FB", Font.PLAIN, 21));
		passTextField.setColumns(10);
		passTextField.setBackground(new Color(200, 218, 236));
		passTextField.setBounds(129, 66, 431, 46);
		panel_2_1.add(passTextField);
		
		JLabel emailLabel = new JLabel("EMAIL:");
		emailLabel.setForeground(new Color(57, 114, 171));
		emailLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		emailLabel.setBounds(10, 122, 117, 46);
		panel_2_1.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("SVN-Agency FB", Font.PLAIN, 21));
		emailTextField.setColumns(10);
		emailTextField.setBackground(new Color(200, 218, 236));
		emailTextField.setBounds(129, 122, 431, 46);
		panel_2_1.add(emailTextField);
		
		JLabel searchLabel_1 = new JLabel("SEARCH:");
		searchLabel_1.setForeground(new Color(57, 114, 171));
		searchLabel_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		searchLabel_1.setBounds(10, 178, 100, 46);
		panel_2_1.add(searchLabel_1);
		
		JLabel usernameLabel_1 = new JLabel("USERNAME");
		usernameLabel_1.setForeground(new Color(57, 114, 171));
		usernameLabel_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		usernameLabel_1.setBounds(10, 234, 117, 46);
		panel_2_1.add(usernameLabel_1);
		
		JLabel studioNameLabel_2_1 = new JLabel("EMAIL:");
		studioNameLabel_2_1.setForeground(new Color(57, 114, 171));
		studioNameLabel_2_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		studioNameLabel_2_1.setBounds(10, 290, 117, 46);
		panel_2_1.add(studioNameLabel_2_1);
		
		emailTextField_1 = new JTextField();
		emailTextField_1.setFont(new Font("SVN-Agency FB", Font.PLAIN, 21));
		emailTextField_1.setColumns(10);
		emailTextField_1.setBackground(new Color(200, 218, 236));
		emailTextField_1.setBounds(129, 290, 431, 46);
		panel_2_1.add(emailTextField_1);
		
		usernameTextField_1 = new JTextField();
		usernameTextField_1.setFont(new Font("SVN-Agency FB", Font.PLAIN, 21));
		usernameTextField_1.setColumns(10);
		usernameTextField_1.setBackground(new Color(200, 218, 236));
		usernameTextField_1.setBounds(129, 234, 431, 46);
		panel_2_1.add(usernameTextField_1);
		
		JLabel genderLabel_1 = new JLabel("GENDER:");
		genderLabel_1.setForeground(new Color(57, 114, 171));
		genderLabel_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		genderLabel_1.setBounds(570, 234, 117, 46);
		panel_2_1.add(genderLabel_1);
		
		JLabel countryLabel_1 = new JLabel("COUNTRY");
		countryLabel_1.setForeground(new Color(57, 114, 171));
		countryLabel_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		countryLabel_1.setBounds(570, 290, 117, 46);
		panel_2_1.add(countryLabel_1);
		
		countryComboBox_1 = new JComboBox();
		countryComboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Côte d'Ivoire", "Cabo Verde", "Cambodia", "Cameroon", "Canada", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo (Congo-Brazzaville)", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czechia (Czech Republic)", "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini (fmr. \"Swaziland\")", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Holy See", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar (formerly Burma)", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Korea", "North Macedonia", "Norway", "Oman", "Pakistan", "Palau", "Palestine State", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Korea", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Tajikistan", "Tanzania", "Thailand", "Timor-Leste", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States of America", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe", ""}));
		countryComboBox_1.setSelectedItem("");
		countryComboBox_1.setFont(new Font("Agency FB", Font.PLAIN, 21));
		countryComboBox_1.setFocusable(false);
		countryComboBox_1.setBackground(new Color(200, 218, 236));
		countryComboBox_1.setBounds(689, 290, 288, 46);
		panel_2_1.add(countryComboBox_1);
		
		genderComboBox_1 = new JComboBox();
		genderComboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", ""}));
		genderComboBox_1.setSelectedItem("");
		genderComboBox_1.setFont(new Font("Agency FB", Font.PLAIN, 21));
		genderComboBox_1.setFocusable(false);
		genderComboBox_1.setBackground(new Color(200, 218, 236));
		genderComboBox_1.setBounds(689, 234, 288, 46);
		panel_2_1.add(genderComboBox_1);
		
		JLabel moneyLabel = new JLabel("MONEY:");
		moneyLabel.setForeground(new Color(57, 114, 171));
		moneyLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		moneyLabel.setBounds(570, 122, 117, 46);
		panel_2_1.add(moneyLabel);
		
		moneyTextField = new JTextField();
		moneyTextField.setFont(new Font("SVN-Agency FB", Font.PLAIN, 21));
		moneyTextField.setColumns(10);
		moneyTextField.setBackground(new Color(200, 218, 236));
		moneyTextField.setBounds(689, 122, 288, 46);
		panel_2_1.add(moneyTextField);
		
		
		Button showButton_1 = new Button("SHOW");
		showButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyQuery.showUser(table_1);
				
				usernameTextField.setText("");
				passTextField.setText("");
				emailTextField.setText("");
				countryComboBox.setSelectedItem("");
				genderComboBox.setSelectedItem("");
				moneyTextField.setText("");
			}
		});
		showButton_1.setForeground(new Color(27, 55, 82));
		showButton_1.setFont(new Font("SVN-Agency FB", Font.BOLD, 32));
		showButton_1.setFocusable(false);
		showButton_1.setBackground(new Color(52, 104, 156));
		showButton_1.setBounds(0, 302, 356, 67);
		panel_3.add(showButton_1);
		
		JLabel adminLabel = new JLabel("neuoavs - ADMIN");
		adminLabel.setBounds(1210, 795, 270, 56);
		adminLabel.setHorizontalAlignment(SwingConstants.CENTER);
		adminLabel.setForeground(new Color(62, 124, 185));
		adminLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 38));
		
		JLabel logOutLabel = new JLabel("");
		logOutLabel.setBounds(1480, 795, 55, 55);
		logOutLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EnterAccountVIew();
				dispose();
			}
		});
		logOutLabel.setIcon(new ImageIcon("C:\\Users\\PHILONG\\Downloads\\Photo\\logout.png"));
		logOutLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logOutLabel.setForeground(new Color(62, 124, 185));
		contentPane.setLayout(null);
		
		JLabel userViewLabel = new JLabel("USER");
		userViewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.removeAll();
				panel_1.add(user);
				panel_1.repaint();
				panel_1.revalidate();
			}
		});
		userViewLabel.setOpaque(true);
		userViewLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		userViewLabel.setBackground(new Color(62, 124, 185));
		userViewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userViewLabel.setForeground(new Color(27, 55, 82));
		userViewLabel.setBounds(5, 800, 127, 35);
		contentPane.add(userViewLabel);
		
		JLabel gameViewLabel = new JLabel("GAME");
		gameViewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.removeAll();
				panel_1.add(game);
				panel_1.repaint();
				panel_1.revalidate();
			}
		});
		gameViewLabel.setOpaque(true);
		gameViewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameViewLabel.setForeground(new Color(27, 55, 82));
		gameViewLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 21));
		gameViewLabel.setBackground(new Color(62, 124, 185));
		gameViewLabel.setBounds(142, 800, 127, 35);
		contentPane.add(gameViewLabel);
		
		JLabel adminNameLabel = new JLabel("neuoavs - ADMIN");
		adminNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		adminNameLabel.setForeground(new Color(57, 114, 171));
		adminNameLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 32));
		adminNameLabel.setBounds(1267, 789, 207, 55);
		contentPane.add(adminNameLabel);
		
		ImageIcon igC = new ImageIcon("C:\\Users\\PHILONG\\Downloads\\Photo\\logout.png");
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(1488, 800, 42, 35);
		Image ig = igC.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
		lblNewLabel_1.setIcon(new ImageIcon(ig));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EnterAccountVIew();
				dispose();
			}
		});
		contentPane.add(lblNewLabel_1);
	
		setVisible(true);
	}
}