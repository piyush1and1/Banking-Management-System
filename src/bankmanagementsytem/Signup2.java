package bankmanagementsytem;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;


public class Signup2 extends JFrame implements ActionListener {

    JTextField panTextfield, adharTextfield;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox income, education, occupation;
    String formno;

    Signup2(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("ACCOUNT APPLICATION FORM - PAGE 2 ");

        JLabel additionaldetails = new JLabel("PAGE 2: ADDITIONAL DETAILS");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionaldetails.setBounds(240, 80, 400, 30);
        add(additionaldetails);

        JLabel dob = new JLabel("Income : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 140, 200, 30);
        add(dob);

        String incomecategory[] = {"null", "< 50,000", "< 1,50,000", "< 2,50,000", "More than 2,50,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 140, 400, 30);
        income.setBackground(Color.white);
        add(income);

        JLabel gender = new JLabel("Educational ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 190, 200, 30);
        add(gender);

        JLabel email = new JLabel("Qualification : ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 215, 200, 30);
        add(email);

        String educategory[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "other"};
        education = new JComboBox(educategory);
        education.setBounds(300, 215, 400, 30);
        education.setBackground(Color.white);
        add(education);

        JLabel marital = new JLabel("Occupation : ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 265, 200, 30);
        add(marital);

        String occucategory[] = {"Salaried", "Self-employed", "Bussiness", "student", "Retired", "Defence", "None"};
        occupation = new JComboBox(occucategory);
        occupation.setBounds(300, 265, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);

        JLabel PAN = new JLabel("PAN number : ");
        PAN.setFont(new Font("Raleway", Font.BOLD, 20));
        PAN.setBounds(100, 315, 200, 30);
        add(PAN);

        panTextfield = new JTextField();
        panTextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextfield.setBounds(300, 315, 400, 30);
        add(panTextfield);

        JLabel Aadhar = new JLabel("Aadhar number : ");
        Aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        Aadhar.setBounds(100, 365, 200, 30);
        add(Aadhar);

        adharTextfield = new JTextField();
        adharTextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        adharTextfield.setBounds(300, 365, 400, 30);
        add(adharTextfield);

        adharTextfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume(); // Ignore the input
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });

        JLabel state = new JLabel("Senior citizen : ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 415, 200, 30);
        add(state);

        syes = new JRadioButton("YES");
        syes.setBounds(300, 415, 100, 30);
        syes.setBackground(Color.white);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBounds(450, 415, 100, 30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup marriedgroup = new ButtonGroup();
        marriedgroup.add(syes);
        marriedgroup.add(sno);

        JLabel pincode = new JLabel("Exisiting Account : ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 465, 200, 30);
        add(pincode);

        eyes = new JRadioButton("YES");
        eyes.setBounds(300, 465, 60, 30);
        eyes.setBackground(Color.white);
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setBounds(450, 465, 120, 30);
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(eyes);
        gendergroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 564, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);

        setSize(750, 700);
        setVisible(true);
        setLocation(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String span = panTextfield.getText();
        String saadhar = adharTextfield.getText();
        String seniorcitizen = syes.isSelected() ? "yes" : "no";
        String existaccount = eyes.isSelected() ? "yes" : "no";

        try {
            if(saadhar.length() != 12){
                JOptionPane.showMessageDialog(null, "addhar should be 12 digit !");
                return ;
            }else if(span.length() != 10){
                JOptionPane.showMessageDialog(null, "PAN should be 10 digit !");
                return ;
            }
            Conn c = new Conn();
            String query = "insert into signup2 values('" + formno + "', '" + sincome + "', '" + seducation + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '" + seniorcitizen + "', '" + existaccount + "')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new Signup3(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] arg) {
        new Signup2("");
    }

}
