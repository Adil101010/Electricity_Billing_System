package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Information extends JFrame implements ActionListener {

    String view;
    JButton cancel;
    View_Information(String view){

        this.view = view;
        setBounds(350,150,800,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("View Customer Information");
        heading.setBounds(250,0,500,60);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);

        JLabel namelabel = new JLabel("Name");
        namelabel.setBounds(70,80,100,20);
        add(namelabel);

        JLabel namelabelText = new JLabel();
        namelabelText.setBounds(200,80,150,20);
        add(namelabelText);

        JLabel meterNumber = new JLabel("Meter Number");
        meterNumber.setBounds(70,140,100,20);
        add(meterNumber);

        JLabel meterText = new JLabel();
        meterText.setBounds(200,140,150,20);
        add(meterText);


        JLabel address = new JLabel("Address");
        address.setBounds(70,200,100,20);
        add(address);

        JLabel addressText = new JLabel();
        addressText.setBounds(200,200,150,20);
        add(addressText);

        JLabel  city = new JLabel("City");
        city.setBounds(70,260,100,20);
        add(city);

        JLabel cityText = new JLabel();
        cityText.setBounds(200,260,150,20);
        add(cityText);


        JLabel state = new JLabel("State");
        state.setBounds(450,80,100,20);
        add(state);

        JLabel stateText = new JLabel();
        stateText.setBounds(600,80,150,20);
        add(stateText);


        JLabel email = new JLabel("Email");
        email.setBounds(450,140,100,20);
        add(email);

        JLabel emailText = new JLabel();
        emailText.setBounds(600,140,150,20);
        add(emailText);

        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(450,200,100,20);
        add(phone);

        JLabel phoneText = new JLabel();
        phoneText.setBounds(600,200,150,20);
        add(phoneText);

         try {
             Database c= new Database();
             ResultSet resultSet = c.statement.executeQuery("select * from New_Customer where meterNumber = '"+view+"'");
             if (resultSet.next()){
                 namelabelText.setText(resultSet.getString("name"));
                 meterText.setText(resultSet.getString("meterNumber"));
                 addressText.setText(resultSet.getString("address"));
                 cityText.setText(resultSet.getString("city"));
                 stateText.setText(resultSet.getString("state"));
                 emailText.setText(resultSet.getString("email"));
                 phoneText.setText(resultSet.getString("phone"));

             }
         }catch (Exception e){
             e.printStackTrace();
         }

         cancel = new JButton("Cancel");
         cancel.setBounds(150,330,120,25);
         cancel.setBackground(Color.BLUE);
         cancel.setForeground(Color.white);
         cancel.addActionListener(this);
         add(cancel);


         ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/viewInfo.png"));
         Image image= i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(image);
         JLabel img = new JLabel(i3);
         img.setBounds(100,260,600,300);
         add(img);



        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

         if(e.getSource()==cancel){
             setVisible(false);
         }
    }

    public static  void main(String[] args){

        new View_Information("");
    }

}
