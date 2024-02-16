
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

class Fastcash1 extends JFrame implements ActionListener{
    JLabel image,text;
    JButton hundred,fivehundred,thousand,twothousand,fivethousand,tenthousand,back;
    String pinnumber;
    Fastcash1(String pinnumber){
        this.pinnumber=pinnumber;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(850,740);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //setUndecorated(true);
           
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(850, 810,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        image= new JLabel(i3);
        image.setBounds(0,0,850,700);
        add(image);
        
        text=new JLabel("SELECT WITHDRAWAL AMOUNT ");
        text.setBounds(165,210,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);
        
        hundred=new JButton("Rs 100");
        hundred.addActionListener(this);
        hundred.setBounds(160,265,145,35);
        hundred.setForeground(Color.BLACK);
        hundred.setFont(new Font("Raleway",Font.BOLD,12));
        image.add(hundred);
        
        fivehundred=new JButton("Rs 500");
        fivehundred.addActionListener(this);
        fivehundred.setBounds(160,310,145,35);
        fivehundred.setForeground(Color.BLACK);
        fivehundred.setFont(new Font("Raleway",Font.BOLD,12));
        image.add( fivehundred);
        
        thousand=new JButton("Rs 1000");
        thousand.addActionListener(this);
        thousand.setBounds(330,265,145,35);
        thousand.setForeground(Color.BLACK);
        thousand.setFont(new Font("Raleway",Font.BOLD,12));
        image.add(thousand);
        
        twothousand=new JButton("Rs 2000");
        twothousand.addActionListener(this);
        twothousand.setBounds(330,310,145,35);
        twothousand.setForeground(Color.BLACK);
        twothousand.setFont(new Font("Raleway",Font.BOLD,12));
        image.add(twothousand);
        
        fivethousand=new JButton("Rs 5000");
        fivethousand.addActionListener(this);
        fivethousand.setBounds(330,355,145,35);
        fivethousand.setForeground(Color.BLACK);
        fivethousand.setFont(new Font("Raleway",Font.BOLD,12));
        image.add(fivethousand);
        
        tenthousand=new JButton("Rs 10,000");
        tenthousand.addActionListener(this);
        tenthousand.setBounds(160,355,145,35);
        tenthousand.setForeground(Color.BLACK);
        tenthousand.setFont(new Font("Raleway",Font.BOLD,12));
        image.add(tenthousand);
        
        back=new JButton("Back");
        back.addActionListener(this);
        back.setBounds(245,400,145,35);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Raleway",Font.BOLD,12));
        image.add(back);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            setVisible(false);
            new transaction1(pinnumber).setVisible(true);
        }
        else{
        String amount=((JButton)e.getSource()).getText().substring(3);
               try{
               Conn c=new Conn();
               ResultSet resultset =c.statement.executeQuery("SELECT * FROM BANK WHERE pin ='"+pinnumber+"'");
               int balance=0;
               while(resultset.next()){
                   if(resultset.getString("type").equals("Deposit")){
                       balance+=Integer.parseInt(resultset.getString("amount"));
                   }
                   else{
                       balance-=Integer.parseInt(resultset.getString("amount"));
                   }
               } 
               if(e.getSource()!=back && balance<Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null,"INSUFFICIENT BALANCE!!!!");
                   return;
               }
               Date date =new Date();
               String query=String.format("INSERT INTO bank VALUES('%s','%s','%s','%s')",pinnumber,date,"Withdrawl",amount);
               c.statement.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Rs"+amount+" Debited Successfully");
               setVisible(false);
               new transaction1(pinnumber).setVisible(true);
               }catch(Exception ae){
                   System.out.println(ae);
               }
        }
    }
}

public class Fastcash {
public static void main(String args[]){
    Fastcash1 f1 = new Fastcash1("");
    f1.setVisible(true);
}    
}
