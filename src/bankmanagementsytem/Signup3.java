package bankmanagementsytem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener {
    
    JRadioButton r1, r2;
    JButton  submit, cancel;
    JCheckBox c1, c2, c3, c4, c5, c7;
    String formno;
    
    Signup3(String formno){
        this.formno = formno;
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3 : Account detail");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(260,40,400,40);
        add(l1);
        
        JLabel type = new JLabel("Account Type : ");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.white);
        r1.setBounds(330, 140, 150, 30);
        add(r1);
        
        r2 = new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setBounds(550, 140, 150, 30);
        add(r2);
        
        ButtonGroup acgroup = new ButtonGroup();
        acgroup.add(r1);
        acgroup.add(r2);
        
        JLabel card = new JLabel("Card Number : ");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100,210,200,30);
        add(card);
        
        JLabel Number = new JLabel("XXXX-6789");
        Number.setFont(new Font("Raleway", Font.BOLD, 22));
        Number.setBounds(330,210,300,30);
        add(Number);
        
        JLabel carddet = new JLabel("Your 8 digit card Number");
        carddet.setFont(new Font("Raleway", Font.BOLD, 12));
        carddet.setBounds(100,230,300,30);
        add(carddet);
        
        JLabel Pin = new JLabel("PIN : ");
        Pin.setFont(new Font("Raleway", Font.BOLD, 22));
        Pin.setBounds(100,280,200,30);
        add(Pin);
        
        JLabel pndet = new JLabel("Your 4 digit pin");
        pndet.setFont(new Font("Raleway", Font.BOLD, 12));
        pndet.setBounds(100,300,300,30);
        add(pndet);
        
        JLabel pincode = new JLabel("XXXX");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(330,280,300,30);
        add(pincode);
        
        JLabel services = new JLabel("Services requried : ");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100,340,300,30);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(130, 400, 200, 30);
        add(c1);
        
        c2 = new JCheckBox("INTERNET BANKING");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(430, 400, 200, 30);
        add(c2);
        
        c3 = new JCheckBox("MOBILE BANKING");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(130, 450, 200, 30);
        add(c3);
        
        c4 = new JCheckBox("SMS ALERT");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(430, 450, 200, 30);
        add(c4);
        
        c5 = new JCheckBox("CHEQUE BOOK");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(280, 500, 200, 30);
        add(c5);
        
        c7 = new JCheckBox("declearing all inmortion are correct!");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway", Font.BOLD, 14));
        c7.setBounds(130, 650, 500, 30);
        add(c7);
        
        submit = new JButton("submit");
        submit.setBackground(Color.BLACK);
        submit .setForeground(Color.white);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(290,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("cancel");
        cancel.setBackground(Color.BLACK);
        cancel .setForeground(Color.white);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.white);
        
        setSize(850,820);
        setVisible(true);
        setLocation(350,90);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accounttype = null;
            if(r1.isSelected()){
                accounttype = "Saving Account";
            }else if(r2.isSelected()){
                accounttype = "Current Account";
            }
            Random random = new Random();
            String cardnumber =""+ Math.abs((random.nextLong() % 9000L) + 3040000L);
            String pin ="" + Math.abs((random.nextLong() % 9000L) + 0000L);
            String facility = "";
            if(c1.isSelected()){
                facility = facility + "ATM CARD";
            }else if(c2.isSelected()){
                facility = facility + "INTERNET BANKING";
            }else if(c3.isSelected()){
                facility = facility + "MOBILE BANKING";
            }else if(c4.isSelected()){
                facility = facility + "SMS ALERT";
            }else if(c5.isSelected()){
                facility = facility + "CHEQUE BOOK";
            }
            
            try{
                if(accounttype.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }else{
                    Conn c = new Conn();
                    String query = "insert into signup3 values('" + formno + "', '" + accounttype + "', '" + cardnumber + "', '" + pin + "', '" + facility + "')";
                    String query2 = "insert into login values('" + formno + "', '" + cardnumber + "', '" + pin + "')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number : "+ cardnumber + "\n Pin : " + pin);
                    
                    setVisible(false);
                    new Login().setVisible(true);
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String[] args){
        new Signup3("");
    }
}
    