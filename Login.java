package electricity.billing.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    JTextField usertext, userpassword;
    Choice loginChoice;
    JButton loginButton, cancelButton, signupButton;

    Login() {
        super("Login");
        getContentPane().setBackground(Color.cyan);

        JLabel username = new JLabel("UserName");
        username.setBounds(300, 60, 100, 20);
        add(username);

        usertext = new JTextField();
        usertext.setBounds(400, 60, 100, 20);
        add(usertext);

        JLabel password = new JLabel("Password");
        password.setBounds(300, 100, 100, 20);
        add(password);

        userpassword = new JTextField();
        userpassword.setBounds(400, 100, 100, 20);
        add(userpassword);

        JLabel Loggin = new JLabel("Loggin In  As");
        Loggin.setBounds(300, 140, 100, 20);
        add(Loggin);

        loginChoice = new Choice();
        loginChoice.add("Admin");
        loginChoice.add("Customer");
        loginChoice.setBounds(400, 140, 100, 20);
        add(loginChoice);

        loginButton = new JButton("Log in");
        loginButton.setBounds(300, 180, 100, 20);
        loginButton.addActionListener(this);
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(420, 180, 100, 20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        signupButton = new JButton("Sign up");
        signupButton.setBounds(360, 220, 100, 20);
        signupButton.addActionListener(this);
        add(signupButton);

        ImageIcon profileOne = new ImageIcon(ClassLoader.getSystemResource("icon/profile.png"));
        Image profiletwo = profileOne.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon fprofileOne = new ImageIcon(profiletwo);
        JLabel profileLabel = new JLabel(fprofileOne);
        profileLabel.setBounds(5, 5, 250, 250);
        add(profileLabel);

        setSize(640, 400);
        setLocation(400, 200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String susername = usertext.getText();
            String spassword = userpassword.getText();
            String suser     = loginChoice.getSelectedItem();

            try {
                Database  c = new Database();
                String query = "select * from Signup where username = '"+susername+"' and password ='"+spassword+"' and usertype ='"+suser+"'";
                ResultSet resultSet = c.statement.executeQuery(query);

                if(resultSet.next()){
                    String meter = resultSet.getString("meterNumber");
                    setVisible(false);
                    new Main_Class(suser,meter);
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                }
            } catch (Exception E){
                E.printStackTrace();
            }


        } else if (e.getSource() == cancelButton) {
            setVisible(false);

        } else if (e.getSource() == signupButton) {
            setVisible(false);
            new Signup();
        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
