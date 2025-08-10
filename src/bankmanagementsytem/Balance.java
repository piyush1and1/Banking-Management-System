package bankmanagementsytem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Balance extends JFrame implements ActionListener {
    
    String pinnumber;
    JButton back;
    
    Balance(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        back = new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(150,340,200,40);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        back.addActionListener(this);
        add(back);
        
        int balance = 0;
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        JLabel text = new JLabel("YOUR CURRENT BALANCE");
        text.setBounds(80,40,400,50);
        text.setFont(new Font("System", Font.BOLD,25));
        add(text);
        
        JLabel rs = new JLabel("Rs ");
        rs.setBounds(40,140,60,50);
        rs.setFont(new Font("Raleway", Font.BOLD,25));
        add(rs);
        
        JLabel btext = new JLabel(""+balance);
        btext.setBounds(100,140,400,50);
        btext.setFont(new Font("Raleway", Font.BOLD,25));
        add(btext);
        
        setSize(500,500);
        setLocation(300,10);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            try{
                Conn c = new Conn();
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[] args){
        new Balance("").setVisible(true);
    }
}
