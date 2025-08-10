package bankmanagementsytem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*; 

public class Login extends JFrame implements ActionListener{
    
    JButton login,signup,clear;
    JTextField cardTextField,pinTextField;
    
    Login() {
        setTitle("Automated Teller Machine");
        setLayout(null); 
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);
        
        JLabel cardno = new JLabel("Card No: ");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        cardTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(cardTextField);
        
        cardTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume(); // Ignore the input
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
        
        JLabel pin = new JLabel("Pin: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 150, 40);
        add(pin);
        
        pinTextField = new JPasswordField(); 
        pinTextField.setBounds(300, 220, 250, 30);
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(pinTextField);
        
        pinTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume(); // Ignore the input
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
        
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGNUP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if (ae.getSource()== signup){
            setVisible(false);
            new Signup1().setVisible(true);
        } else if (ae.getSource()== login){
            Conn c = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardNumber = '" + cardnumber + "' and pin = '" + pinnumber +"'";
            try{
                ResultSet rn = c.s.executeQuery(query);
                if(rn.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect information");
                }
            }catch(Exception e){
                System.out.print(e);
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
