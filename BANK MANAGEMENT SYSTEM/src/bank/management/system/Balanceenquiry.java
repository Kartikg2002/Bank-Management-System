
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Balanceenquiry1 extends JFrame{
    JLabel image,text;
    JButton back;
    String pinnumber;
    Balanceenquiry1(String pinnumber){
        this.pinnumber=pinnumber;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(850,740);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(850, 810, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,850,810);
        add(image);
        
        
        back=new JButton("Back");
        back.addActionListener(new ActionListener(){
           public void actionPerformed (ActionEvent e){
               setVisible(false);
               new transaction1(pinnumber).setVisible(true);
           } 
        });
        back.setBounds(380,450,100,35);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Raleway",Font.BOLD,12));
        image.add(back);
        
        int balance=0;
        try{
          Conn c=new Conn();
               ResultSet resultset =c.statement.executeQuery("SELECT * FROM BANK WHERE pin ='"+pinnumber+"'");
               while(resultset.next()){
                   if(resultset.getString("type").equals("Deposit")){
                       balance+=Integer.parseInt(resultset.getString("amount"));
                   }
                   else{
                       balance-=Integer.parseInt(resultset.getString("amount"));
                   }
               }
        }catch(Exception ae){
            System.out.println(ae);
        } 
        
        text=new JLabel("YOUR CURRENT ACCOUNT BALANCE IS Rs "+balance);
        text.setBounds(150,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,14));
        image.add(text);
    }
}

public class Balanceenquiry {
    public static void main(String args[]){
        Balanceenquiry1 b1= new Balanceenquiry1("");
        b1.setVisible(true);
    }
    
}
