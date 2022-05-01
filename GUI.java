/* Gary Henry
4/30/2022
CIS221
Tuesdays and Thursdays (2:10pm to 4:00pm)
Professor: Mr.Swinarski 
CIS221 Final Project*/


//import swing library for creating a GUI, import ActionListenr and Event for click actions
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;//for buttons
import javax.swing.JFrame;//for window frames
import javax.swing.JLabel;//for labels
import javax.swing.JPanel;//for the panel that goes on top of the frame
import javax.swing.JPasswordField;//for password field entry...cant see chars
import javax.swing.JTextField;//for basic text field
import java.io.File;//to import files
import java.util.Scanner;//scanner to scan files, etc...
import java.io.FileNotFoundException;//handles exceptions


public class GUI  implements ActionListener   { //GUI class implements ActionListener Interface
		
		//Create private variables with class wide scope for GUI creation
		private static JLabel userLabel;
		private static JTextField userText;
		private static JLabel passwordLabel;
		private static JPasswordField passwordText;
		private static JButton button;
		private static JLabel success;
		
		    public static void main(String[] args) { //main method
		    	
		    	JFrame frame = new JFrame(); //create object of JFrame called "frame"
		        JPanel panel = new JPanel(); //create object of JPanel called "panel"
		        frame.setSize(350, 200); //set frame size
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set close operation
		        frame.add(panel); //add frame to panel object

		        panel.setLayout(null);
		        
		        //Create user label object and add to panel object
		        userLabel = new JLabel("User:");
		        userLabel.setBounds(10, 20, 80, 25);//set size and place of userLabel label
		        panel.add(userLabel);
		        
		        //Create user text field object and add to panel
		        userText = new JTextField(20);
		        userText.setBounds(100, 20, 165, 25);//sets size of userText object
		        panel.add(userText);
		        
		        //create password label object and add to panel
		        passwordLabel = new JLabel("Password:");
		        passwordLabel.setBounds(10, 50, 80, 25); //set size and position of the Password label
		        panel.add(passwordLabel);
		        
		        //create password field object and add to panel
		        passwordText = new JPasswordField();
		        passwordText.setBounds(100, 50, 165, 25);// set size and position of password field object
		        panel.add(passwordText);
		        
		        //create button object and add to panel
		        button = new JButton("Login");
		        button.setBounds(10, 80, 80, 25);
		        panel.add(button);
		        button.addActionListener(new GUI()); //adds action to button
		        
		        //create success label and add to panel
		        success = new JLabel("");//sets text to null
		        success.setBounds(10, 110, 300, 25);
		        panel.add(success);
		        

		        frame.setVisible(true); //makes the frame visible

		    }

		    //action event when button clicked, checks userName and password field
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String user = userText.getText().toLowerCase(); //variable holds user entry
				
				String password = passwordText.getText().toLowerCase();//variable hold password entry
				
				
				try { //try block
				File text = new File("users.txt"); //make object of file and import file "users"
				Scanner scan = new Scanner(text);//scan object holds the text var
				while(scan.hasNextLine()) { //do this while there is a next line to be scanned in the text file
					
					String data = scan.nextLine(); //assign the lines read to data String
					if(user.equals(data)) { //if user entry matches line in the text file
						checkPassword(password); //method to check the password
					}
					
						
					
					System.out.println(data);
					System.out.println("The password is bloodkeep");
					
				}
				scan.close();//close the scanner
				if (user.equals(" ")){
					System.out.println("Enter your username");
			
			}
					
				} catch (FileNotFoundException s) { //catch error
				System.out.println("error has occured");
				s.printStackTrace();
				} finally { //placeholder for last resort
					
				}
			}
			
			//method that checks the password and notifies user accordingly
			public static String checkPassword(String password) {
				switch (password) {
				case "bloodkeep":
					success.setText("successful");
					break;
				default:
					success.setText("unsuccessful");
					break;
				}
				return password;
			}
}
