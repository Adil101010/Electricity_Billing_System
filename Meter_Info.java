package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Meter_Info extends JFrame implements  ActionListener{

          Choice meterLocCho,meterTypCho,phaseCodeCho,billTypcho;
           JButton submit;
           String meternumber;
           Meter_Info(String meternumber){
               super("Meter Information");
               this.meternumber=meternumber;

               setSize(700,500);
               setLocation(400,200);

               JPanel panel = new JPanel();
               panel.setLayout(null);
               panel.setBackground(new Color(252,186,3));
               add(panel);

               JLabel heading = new JLabel("Meter Information");
               heading.setBounds(180,10,200,20);
               heading.setFont(new Font("Tahoma",Font.BOLD,20));
               panel.add(heading);


               JLabel meterNumber = new JLabel("Meter Number");
               meterNumber.setBounds(50,80,100,20);
               panel.add(meterNumber);

               JLabel meterNumberText = new JLabel(meternumber);
               meterNumberText.setBounds(200,80,150,20);
               panel.add(meterNumberText);

               JLabel meterLoc = new JLabel("Meter Number");
               meterLoc.setBounds(50,120,100,20);
               panel.add(meterLoc);

               meterLocCho = new Choice();
               meterLocCho.add("Outside");
               meterLocCho.add("Inside");
               meterLocCho.setBounds(200,120,150,20);
               panel.add(meterLocCho);

               JLabel metertyp = new JLabel("Meter Type");
               metertyp.setBounds(50,160,150,20);
               panel.add(metertyp);

               meterTypCho = new Choice();
               meterTypCho.add("Electeric Meter");
               meterTypCho.add("Solar Meter");
               meterTypCho.add("Smart Meter");
               meterTypCho.setBounds(200,160,150,20);
               panel.add(meterTypCho);

               JLabel phaseCode = new JLabel("Phase Code");
               phaseCode.setBounds(50,200,100,20);
               panel.add(phaseCode);


               phaseCodeCho = new Choice();
               phaseCodeCho.add("011");
               phaseCodeCho.add("022");
               phaseCodeCho.add("033");
               phaseCodeCho.add("044");
               phaseCodeCho.add("055");
               phaseCodeCho.add("066");
               phaseCodeCho.add("077");
               phaseCodeCho.add("088");
               phaseCodeCho.add("099");
               phaseCodeCho.setBounds(200,200,150,20);
               panel.add(phaseCodeCho);

               JLabel billType = new JLabel("Bill Type");
               billType.setBounds(50,240,100,20);
               panel.add(billType);

               billTypcho = new Choice();
               billTypcho.add("Normal");
               billTypcho.add("Industrial");
               billTypcho.setBounds(200,240,150,20);
               panel.add(billTypcho);

                JLabel day = new JLabel("30 Days Billing time...");
                day.setBounds(50,280,150,20);
                panel.add(day);

                JLabel note = new JLabel("Note:-");
                note.setBounds(50,320,100,20);
                panel.add(note);

                JLabel note1 = new JLabel("By default bill calculated 30 days only");
                note1.setBounds(50,340,200,20);
                panel.add(note1);

                submit = new JButton("Submit");
                submit.setBounds(180,380,100,25);
                submit.setBackground(Color.BLACK);
                submit.setForeground(Color.white);
                submit.addActionListener(this);
                panel.add(submit);

                setLayout(new BorderLayout());
                add(panel,"Center");

                ImageIcon  i1= new ImageIcon(ClassLoader.getSystemResource("icon/details.png"));
                Image i2 = i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                JLabel imgLable = new JLabel(i3);
                add(imgLable,"East");

               setVisible(true);

           }

    @Override
    public void actionPerformed(ActionEvent e) {

               if(e.getSource()==submit){
                   String smeterNum = meternumber;
                   String smeterLoc = meterLocCho.getSelectedItem();
                   String smetertyp = meterTypCho.getSelectedItem();
                   String sphaseCode = phaseCodeCho.getSelectedItem();
                   String sbillTyp =   billTypcho.getSelectedItem();
                   String sdays  = "30";

                   String query_meterInfo = "insert into Meter_Info values('"+smeterNum+"','"+smeterLoc+"','"+smetertyp+"','"+sphaseCode+"','"+sbillTyp+"','"+sdays+"')";
                   try {

                       Database c = new Database();
                       c.statement.executeUpdate(query_meterInfo);

                       JOptionPane.showMessageDialog(null,"Meter Information submited successfully");
                       setVisible(false);

                   } catch (Exception E){
                       E.printStackTrace();
                   }
               }
                   else{
                       setVisible(false);
               }
    }

    public static  void main(String[] args){
         new Meter_Info("");
     }

}
