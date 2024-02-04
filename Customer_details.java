package electricity.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;

public class Customer_details extends JFrame implements ActionListener {

    Choice searchmeterCho,searchNameCho;
    JTable table;

    JButton search,print,close;
    Customer_details(){
        super("Customer Details");
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
            ResultSet resultSet= c.statement.executeQuery("select * from New_Customer");
            while(resultSet.next()){
                searchmeterCho.add(resultSet.getString("meterNumber"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }


         JLabel searchName = new JLabel("Search By Name");
        searchName.setBounds(340,20,150,20);
        add(searchName);

        searchNameCho = new Choice();
        searchNameCho.setBounds(500,20,100,20);
        add(searchNameCho);
        try {

            Database c= new Database();
            ResultSet resultSet= c.statement.executeQuery("select * from New_Customer");
            while(resultSet.next()){
                searchNameCho.add(resultSet.getString("name"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }


        table = new JTable();
        try {
            Database c= new Database();
            ResultSet resultSet= c.statement.executeQuery("select * from New_Customer");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        }catch (Exception e){
            e.printStackTrace();
        }


        JScrollPane scrollPane= new JScrollPane(table);
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
       if(e.getSource() == search){
           String query_search = "select * from New_Customer where meterNumber = '"+searchmeterCho.getSelectedItem()+"' and name = '"+searchNameCho.getSelectedItem()+"'";
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

    public static void main(String[] args){

        new Customer_details();
    }

}
