package electricity.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Deposit_Details extends JFrame implements ActionListener {
    Choice searchmeterCho,searchMonthCho;
    JTable table;

    JButton search,print,close;

    Deposit_Details(){

               super("Deposit  Details");
               getContentPane().setBackground(new Color(192,186,254));
               setSize(700,500);
               setLocation(400,200);
               setLayout(null);

               JLabel searchmeter = new JLabel("Search By Meter Number");
               searchmeter.setBounds(20,20,150,20);
               add(searchmeter);


               searchmeterCho = new Choice();
               searchmeterCho.setBounds(180,20,100,20);
               add(searchmeterCho);
               try {

                   Database c= new Database();
                   ResultSet resultSet= c.statement.executeQuery("select * from bill");
                   while(resultSet.next()){
                       searchmeterCho.add(resultSet.getString("meterNumber"));
                   }
               }catch (Exception E){
                   E.printStackTrace();
               }


               JLabel searchMonth = new JLabel("Search By Month");
                searchMonth.setBounds(340,20,150,20);
               add(searchMonth);

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
              searchMonthCho.setBounds(520,20,150,20);
              add(searchMonthCho);



        table = new JTable();
               try {
                   Database c= new Database();
                   ResultSet resultSet= c.statement.executeQuery("select * from bill");
                   table.setModel(DbUtils.resultSetToTableModel(resultSet));


               }catch (Exception e){
                   e.printStackTrace();
               }


               JScrollPane scrollPane= new JScrollPane(table );
               scrollPane.setBounds(0,100,700,500);
               scrollPane.setBackground(Color.white);
               add(scrollPane);

               search = new JButton("Search");
               search.setBackground(Color.white);
               search.setBounds(20,70,80,20);
               search.addActionListener(this);
               add(search);

               print = new JButton("Print");
               print.setBackground(Color.white);
               print.setBounds(140,70,80,20);
               print.addActionListener(this);
               add(print);

               close = new JButton("Close");
               close.setBackground(Color.white);
               close.setBounds(550,70,80,20);
               close.addActionListener(this);
               add(close);


               setVisible(true);
           }

           @Override
           public void actionPerformed(ActionEvent e) {
               if(e.getSource()==search){
                   String query_search = "select * from bill  where meterNumber = '"+searchmeterCho.getSelectedItem()+"' and month = '"+searchMonthCho.getSelectedItem()+"'";
                   try {
                       Database c= new Database();
                        ResultSet resultSet = c.statement.executeQuery(query_search);
                       table.setModel(DbUtils.resultSetToTableModel(resultSet));


                   }catch (Exception E){
                       E.printStackTrace();
                   }

               } else if (e.getSource()==print) {
                   try {
                       table.print();
                   } catch (Exception E) {
                       E.printStackTrace();
                   }
               }
               else {
                   setVisible(false);
               }
           }

           public static  void main(String[] args){
        new Deposit_Details();
    }


}
