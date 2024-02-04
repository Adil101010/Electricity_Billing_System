package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Pay_Bill extends JFrame implements ActionListener {

    String meter;
    JButton pay,back;
    Choice searchMonthCho;
    Pay_Bill(String meter){
        this.meter=meter;


        setSize(700,600);
        setLocation(400,150);
        setLayout(null);


          JLabel heading = new JLabel("Pay Bill");
          heading.setFont(new Font("tahoma",Font.BOLD,24));
          heading.setBounds(120,5,400,30);
          add(heading);


          JLabel meterNumber = new JLabel("Meter Number");
          meterNumber.setBounds(35,80,200,20);
          add(meterNumber);

          JLabel meterNumberText = new JLabel("");
          meterNumberText.setBounds(300,80,200,20);
          add(meterNumberText);

          JLabel name = new JLabel("Name");
          name.setBounds(35,140,200,20);
          add(name);

          JLabel nametext = new JLabel("");
          nametext.setBounds(300,140,200,20);
          add(nametext);

          JLabel month = new JLabel("Month");
          month.setBounds(35,200,200,20);
          add(month);


        searchMonthCho = new Choice();
        searchMonthCho = new Choice();
        searchMonthCho.add("January");
        searchMonthCho.add("February");
        searchMonthCho.add("March");
        searchMonthCho.add("April");
        searchMonthCho.add("May");
        searchMonthCho.add("June");
        searchMonthCho.add("July");
        searchMonthCho.add("August");
        searchMonthCho.add("September");
        searchMonthCho.add("October");
        searchMonthCho.add("November");
        searchMonthCho.add("December");
        searchMonthCho.setBounds(300,200,150,20);
        add(searchMonthCho);


        JLabel unit = new JLabel("Unit");
        unit.setBounds(35,260,200,20);
        add(unit);

        JLabel unitText = new JLabel("");
        unitText.setBounds(300,260,200,20);
        add(unitText);

        JLabel totalbill = new JLabel("Total Bill");
        totalbill.setBounds(35,320,200,20);
        add(totalbill);

        JLabel totalbillText = new JLabel("");
        totalbillText.setBounds(300,320,200,20);
        add(totalbillText);

        JLabel status = new JLabel("Status");
        status.setBounds(35,380,200,20);
        add(status);

        JLabel statusText = new JLabel("");
        statusText.setBounds(300,380,200,20);
        statusText.setForeground(Color.RED);
        add(statusText);

        try {
            Database c= new Database();
            ResultSet resultSet = c.statement.executeQuery("select * from New_Customer where meterNumber ='"+meter+"'");
            while(resultSet.next()){
                meterNumberText.setText(meter);
                nametext.setText(resultSet.getString("name"));
            }

        }catch (Exception E){
            E.printStackTrace();
        }

           searchMonthCho.addItemListener(new ItemListener() {
               @Override
               public void itemStateChanged(ItemEvent e) {
                   Database c= new Database();
                   try {

                       ResultSet resultSet = c.statement.executeQuery("select * from bill where meterNumber ='"+meter+"' and month = '"+searchMonthCho.getSelectedItem()+"' ");
                    while (resultSet.next()){

                        unitText.setText(resultSet.getString("unit"));
                        totalbillText.setText(resultSet.getString("total_bill"));
                        statusText.setText(resultSet.getString("status"));
                    }

                   }catch (Exception E){
                       E.printStackTrace();
                   }

               }
           });


        pay = new JButton("Pay");
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.white);
        pay.setBounds(100,460,100,25);
        pay.addActionListener(this);
        add(pay);

        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(230,460,100,25);
        back.addActionListener(this);
        add(back);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==pay){
            try {
                Database c= new Database();
                c.statement.executeUpdate("update bill set status = ' Paid' where meterNumber = '"+meter+"' and  month = '"+searchMonthCho.getSelectedItem()+"'");
            }catch (Exception E){
                E.printStackTrace();
            }
             setVisible(false);
            new Payment_Bill(meter);
        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Pay_Bill("");
    }
}
