
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Ministatement1 extends JFrame{
    JLabel card,bank,mini,balance;
    JButton back;
    String pinnumber;
    Ministatement1(String pinnumber){
        this.pinnumber=pinnumber;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
         
        bank=new JLabel("INDIAN BANK");
        bank.setBounds(130,20,150,20);
        bank.setForeground(Color.BLACK);
        bank.setFont(new Font("Raleway",Font.BOLD,20));
        add(bank);
         
        card=new JLabel();
        card.setBounds(20,90,300,20);
        card.setForeground(Color.BLACK);
        card.setFont(new Font("Raleway",Font.BOLD,15));
        add(card);
        
        mini=new JLabel();
        mini.setBounds(20,160,400,200);
        mini.setForeground(Color.BLACK);
        mini.setFont(new Font("Raleway",Font.BOLD,13));
        add(mini);
        
        balance=new JLabel();
        balance.setBounds(20,280,300,200);
        balance.setForeground(Color.BLACK);
        balance.setFont(new Font("Raleway",Font.BOLD,13));
        add(balance);

       
         try{
          Conn c=new Conn();
               ResultSet resultset =c.statement.executeQuery("SELECT * FROM login WHERE pinno='"+pinnumber+"'");
               while(resultset.next()){
                   card.setText("CARD NO. "+resultset.getString("cardno").substring(0,4)+"XXXXXXXX"+resultset.getString("cardno").substring(12));
               }
        }catch(Exception ae){
            System.out.println(ae);
        }
         
          try{
          Conn c=new Conn();
               ResultSet resultset =c.statement.executeQuery("SELECT * FROM bank WHERE pin='"+pinnumber+"'");
               while(resultset.next()){
                   mini.setText(mini.getText()+"<html>"+resultset.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultset.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultset.getString("amount")+"<br><br>");
               }
        }catch(Exception ae){
            System.out.println(ae);
        }
          
          int bal=0;
          try{
            Conn c=new Conn();
               ResultSet resultset =c.statement.executeQuery("SELECT * FROM BANK WHERE pin ='"+pinnumber+"'");
               while(resultset.next()){
                   if(resultset.getString("type").equals("Deposit")){
                       bal+=Integer.parseInt(resultset.getString("amount"));
                   }
                   else{
                       bal-=Integer.parseInt(resultset.getString("amount"));
                   }
               }
               balance.setText("YOUR CURRENT BALANCE IS Rs "+bal);
          }catch(Exception ae){
              System.out.println(ae);
          }
              
    }
}

public class Ministatement {
    public static void main(String args[]){
        Ministatement1 m1=new Ministatement1("");
        m1.setVisible(true);
    }
    
}
