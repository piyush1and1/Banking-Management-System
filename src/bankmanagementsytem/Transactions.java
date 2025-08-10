package bankmanagementsytem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    
    JButton deposit,Withdrawl,Pin,Balance,Exit;
    String pinnumber;
    
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        JLabel text = new JLabel("Please select your transaction");
        text.setFont(new Font("Raleway", Font.BOLD,22));
        text.setBounds(260,40,400,40);
        add(text);
        
        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Raleway", Font.BOLD,22));
        deposit.setBounds(70,150,250,60);
        deposit.addActionListener(this);
        add(deposit);
        
        Withdrawl = new JButton("Cash Withdrawal");
        Withdrawl.setFont(new Font("Raleway", Font.BOLD,22));
        Withdrawl.setBounds(520,150,250,60);
        Withdrawl.addActionListener(this);
        add(Withdrawl);
        
        Pin = new JButton("Pin Change");
        Pin.setFont(new Font("Raleway", Font.BOLD,22));
        Pin.setBounds(70,260,250,60);
        Pin.addActionListener(this);
        add(Pin);
        
        Balance = new JButton("Check Balance");
        Balance.setFont(new Font("Raleway", Font.BOLD,22));
        Balance.setBounds(520,260,250,60);
        Balance.addActionListener(this);
        add(Balance);
        
        Exit = new JButton("Exit");
        Exit.setFont(new Font("Raleway", Font.BOLD,22));
        Exit.setBounds(290,470,250,60);
        Exit.addActionListener(this);
        add(Exit);
        
        getContentPane().setBackground(Color.white);
        
        setSize(865,700);
        setLocation(300,60);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource() == Withdrawl){
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }else if(ae.getSource() == Pin){
            setVisible(false);
            new Pinchange(pinnumber).setVisible(true);
        }else if(ae.getSource() == Balance){
            setVisible(false);
            new Balance(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Transactions("");
    }
}
