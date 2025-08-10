package bankmanagementsytem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener {
    
    JTextField pintext,repintext;
    JButton change,back;
    String pinnumber;
    
    Pinchange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        JLabel text = new JLabel("PIN CHANGE");
        text.setBounds(170,40,300,50);
        text.setFont(new Font("System", Font.BOLD,30));
        add(text);
        
        JLabel pin = new JLabel("Enter pin : ");
        pin.setBounds(100,140,150,30);
        pin.setFont(new Font("Raleway", Font.BOLD,18));
        add(pin);
        
        pintext = new JTextField();
        pintext.setBounds(270,140,200,30);
        pintext.setFont(new Font("Raleway",Font.BOLD,18));
        pintext.setBackground(Color.white);
        add(pintext);
        
        pintext.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume(); // Ignore the input
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
        
        JLabel repin = new JLabel("Re-Enter pin : ");
        repin.setBounds(100,190,150,30);
        repin.setFont(new Font("Raleway", Font.BOLD,18));
        add(repin);
        
        repintext = new JTextField();
        repintext.setBounds(270,190,200,30);
        repintext.setFont(new Font("Raleway",Font.BOLD,18));
        repintext.setBackground(Color.white);
        add(repintext);
        
        repintext.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume(); // Ignore the input
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
        
        change = new JButton("CHANGE");
        change.setBackground(Color.black);
        change.setForeground(Color.white);
        change.setBounds(200,290,200,40);
        change.setFont(new Font("Raleway",Font.BOLD,15));
        change.addActionListener(this);
        add(change);
        
        back = new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(200,340,200,40);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        back.addActionListener(this);
        add(back);
        
        getContentPane().setBackground(Color.white);
        
        setSize(600,600);
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
                String npin = pintext.getText();
                String rpin = repintext.getText();
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Pins does not match");
                    return ;
                }
                if(npin.equals("")||rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter pins");
                    return ;
                }
                
                Conn c = new Conn();
                String query1 = "update bank set pin = '" + rpin + "' where pin = '"+ pinnumber +"'" ;
                String query2 = "update login set pin = '" + rpin + "' where pin = '"+ pinnumber +"'" ;
                String query3 = "update signup3 set pin = '" + rpin + "' where pin = '"+ pinnumber +"'" ;
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN is changed sucessfully" );
                
                setVisible(false);
                
                new Transactions(rpin).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[] args){
        new Pinchange("").setVisible(true);
    }
}
