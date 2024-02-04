package electricity.billing.system;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.ImageGraphicAttribute;

public class Main_Class extends JFrame implements ActionListener {

     String acctype;
     String meter_pass;
    Main_Class(String acctype,String meter_pass) {

        this.acctype = acctype;
        this.meter_pass= meter_pass;
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/EBS.png"));
        Image image = imageIcon.getImage().getScaledInstance(1290, 640, DO_NOTHING_ON_CLOSE);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel imagLabel = new JLabel(imageIcon2);
        add(imagLabel);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Menu");
        menu.setFont(new Font("serif", Font.PLAIN, 15));


        JMenuItem newCustomer = new JMenuItem("New Customer");
        newCustomer.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon customerimg = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
        Image customerImage = customerimg.getImage().getScaledInstance(20, 20, image.SCALE_DEFAULT);
        newCustomer.setIcon(new ImageIcon(customerImage));
        newCustomer.addActionListener(this);
        menu.add(newCustomer);

        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon CustomerDetails = new ImageIcon(ClassLoader.getSystemResource("icon/customerDetails.png"));
        Image Customerdetails = customerimg.getImage().getScaledInstance(20, 20, image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(customerImage));
        customerdetails.addActionListener(this);
        menu.add(customerdetails);

        JMenuItem depositdetails = new JMenuItem("Deposit Details");
        depositdetails.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon depositdetailsImg = new ImageIcon(ClassLoader.getSystemResource("icon/depositdetails.png"));
        Image depositdetailsImage = depositdetailsImg.getImage().getScaledInstance(20, 20, image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(depositdetailsImage));
        depositdetails.addActionListener(this);
        menu.add(depositdetails);

        JMenuItem calculateBill = new JMenuItem("Calculate Bill");
        calculateBill.setFont(new Font("monospaced", Font.PLAIN,14));
        ImageIcon calculateBillImg =new ImageIcon(ClassLoader.getSystemResource("icon/calculatorbills.png"));
        Image calculateBillImage = calculateBillImg.getImage().getScaledInstance(20,20,image.SCALE_DEFAULT);
        calculateBill.setIcon(new ImageIcon(calculateBillImage));
        calculateBill.addActionListener(this);
         menu.add(calculateBill);

         JMenu info = new JMenu("Information");
         info.setFont(new Font("serif",Font.PLAIN,15));


         JMenuItem upinfo = new JMenuItem("Update Information"); 
         upinfo.setFont(new Font("monospaced",Font.PLAIN,14));
         ImageIcon upinfoImg = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
         Image upinfoImage = upinfoImg.getImage().getScaledInstance(20,20,image.SCALE_DEFAULT);
         upinfo.setIcon(new ImageIcon(upinfoImage));
        upinfo.addActionListener(this);
         info.add(upinfo);

         JMenuItem viewinfo= new JMenuItem("View Information");
         viewinfo.setFont(new Font("monospaced",Font.PLAIN,14));
         ImageIcon viewinfoImg = new ImageIcon(ClassLoader.getSystemResource("icon/information.png"));
         Image viewinfoImge = viewinfoImg.getImage().getScaledInstance(20,20,image.SCALE_DEFAULT);
         viewinfo.setIcon(new ImageIcon(viewinfoImge));
          viewinfo.addActionListener(this);
         info.add(viewinfo);

         JMenu user= new JMenu("User");
         user.setFont(new Font("serif",Font.PLAIN,14));


         JMenuItem paybill = new JMenuItem("PayBill");
         paybill.setFont(new Font("monospaced",Font.PLAIN,14));
         ImageIcon paybillImg = new ImageIcon(ClassLoader.getSystemResource("icon/pay.png"));
         Image paybillImage = paybillImg.getImage().getScaledInstance(20,20,image.SCALE_DEFAULT);
         paybill.setIcon(new ImageIcon(paybillImage));
         paybill.addActionListener(this);
         user.add(paybill);

         JMenuItem  billdetails = new JMenuItem("Bill Details");
         billdetails.setFont(new Font("monospaced",Font.PLAIN,14));
         ImageIcon billdetailsImg = new ImageIcon(ClassLoader.getSystemResource("icon/details.png"));
         Image billdetailsImage= billdetailsImg.getImage().getScaledInstance(20,20,image.SCALE_DEFAULT);
         billdetails.setIcon(new ImageIcon(billdetailsImage));
         billdetails.addActionListener(this);
         user.add(billdetails);

         JMenu bill = new JMenu("Bill");
         bill.setFont(new Font("serif",Font.PLAIN,14));


         JMenuItem generatebill = new JMenuItem("Generate Bill");
         generatebill.setFont(new Font("monospaced",Font.PLAIN,14));
         ImageIcon generatebillImg = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
         Image generatebillImage = generatebillImg.getImage().getScaledInstance(20,20,image.SCALE_DEFAULT);
         generatebill.setIcon(new ImageIcon(generatebillImage));
          generatebill.addActionListener(this);
         bill.add(generatebill);

         JMenu utility = new JMenu("Utility");
         utility.setFont(new Font("serif",Font.PLAIN,14));



        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon notepadImg = new ImageIcon(ClassLoader.getSystemResource("icon/notepad.png"));
        Image notepadImage = notepadImg.getImage().getScaledInstance(20,20,image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(notepadImage));
        notepad.addActionListener(this);
        utility.add(notepad);


         JMenuItem calculator = new JMenuItem("Calculator");
         calculator.setFont(new Font("monospaced",Font.PLAIN,14));
         ImageIcon calculatorImg = new ImageIcon(ClassLoader.getSystemResource("icon/calculator.png"));
         Image calculatorImage = calculatorImg.getImage().getScaledInstance(20,20,image.SCALE_DEFAULT);
         calculator.setIcon(new ImageIcon(calculatorImage));
         calculator.addActionListener(this);
         utility.add(calculator);


        JMenu exit = new JMenu("Exit");
        exit.setFont(new Font("serif",Font.PLAIN,14));



        JMenuItem ext = new JMenuItem("Exit");
        ext.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon extImg = new ImageIcon(ClassLoader.getSystemResource("icon/exit.png"));
        Image extImage = calculatorImg.getImage().getScaledInstance(20,20,image.SCALE_DEFAULT);
        ext.setIcon(new ImageIcon(extImage));
        ext.addActionListener(this);
        exit.add(ext);




        setLayout(new FlowLayout());
        setVisible(true);

        if(acctype.equals("Admin")){
            menuBar.add(menu);
        }else {
            menuBar.add(bill);
            menuBar.add(user);
            menuBar.add(info);
        }
        menuBar.add(utility);
        menuBar.add(exit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String msg= e.getActionCommand();
        if(msg.equals("New Customer")){
            new New_Customer();

        } else if (msg.equals("Customer Details")) {
            new Customer_details();
        } else if (msg.equals("Deposit Details")) {
            new Deposit_Details();
        } else if (msg.equals("Calculate Bill")) {
            new Calculate_Bill();

        } else if (msg.equals("Update Information")) {
            new Update_Information(meter_pass);
        } else if (msg.equals("View Information")) {
            new View_Information(meter_pass);
        } else if (msg.equals("Bill Details")) {
            new Bill_Details(meter_pass);
        } else if (msg.equals("Calculator")) {
             try {
                 Runtime.getRuntime().exec("calc.exe");


             }catch (Exception E){
                 E.printStackTrace();
             }
        } else if (msg.equals("Notepad")) {
            try {
                 Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (msg.equals("Exit")) {
            setVisible(false);
            new Login();
        } else if (msg.equals("PayBill")) {
            new Pay_Bill(meter_pass);

        } else if (msg.equals("Generate Bill")) {
            new Generate_Bill(meter_pass);
        }
    }

    public static void main(String[] args) {

        new Main_Class("","");

    }
}
