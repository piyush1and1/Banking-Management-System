package bankmanagementsytem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        JLabel text = new JLabel("Enter the amount ");
        text.setBounds(170,40,300,50);
        text.setFont(new Font("Raleway", Font.BOLD,30));
        add(text);
        
        JLabel rs = new JLabel("Rs ");
        rs.setBounds(110,140,60,50);
        rs.setFont(new Font("Raleway", Font.BOLD,30));
        add(rs);
        
        amount = new JTextField();
        amount.setBounds(170,140,300,50);
        amount.setFont(new Font("Raleway",Font.BOLD,30));
        amount.setBackground(Color.white);
        add(amount);
        
        amount.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume(); // Ignore the input
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
        
        deposit = new JButton("DEPOSIT");
        deposit.setBackground(Color.black);
        deposit.setForeground(Color.white);
        deposit.setBounds(200,290,200,40);
        deposit.setFont(new Font("Raleway",Font.BOLD,25));
        deposit.addActionListener(this);
        add(deposit);
        
        back = new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(200,340,200,40);
        back.setFont(new Font("Raleway",Font.BOLD,25));
        back.addActionListener(this);
        add(back);
        
        getContentPane().setBackground(Color.white);
        
        setSize(600,600);
        setLocation(300,10);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount");
            }else{
                try{
                    Conn c = new Conn();
                String query = "insert into bank values('"+ pinnumber +"', '"+ date +"','deposit','"+ number +"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+" deposited sucessfully" );
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Deposit("");
    }
}
