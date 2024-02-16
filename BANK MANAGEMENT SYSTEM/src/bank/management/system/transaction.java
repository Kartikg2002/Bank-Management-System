
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class transaction1 extends JFrame{
    JLabel image,text;
    JButton deposit,cashwithdrawl,fastcash,ministatement,pinchange,balance,exit;
    String pinnumber;
    transaction1(String pinnumber){
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
        
        text=new JLabel("PLEASE SELECT YOUR TRANSACTION");
        text.setBounds(165,210,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);
        
        deposit=new JButton("DEPOSIT");
        deposit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                new Deposit1(pinnumber).setVisible(true);
            }
        
        });
        deposit.setBounds(160,265,145,35);
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("Raleway",Font.BOLD,12));
        image.add(deposit);
        
        cashwithdrawl=new JButton("CASH WITHDRAWL");
        cashwithdrawl.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                new Withdrawal1(pinnumber).setVisible(true);
            }
        
        });
        cashwithdrawl.setBounds(160,310,145,35);
        cashwithdrawl.setForeground(Color.BLACK);
        cashwithdrawl.setFont(new Font("Raleway",Font.BOLD,12));
        image.add(cashwithdrawl);
        
        fastcash=new JButton("FAST CASH");
        fastcash.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                new Fastcash1(pinnumber).setVisible(true);
            }
        
        });
        fastcash.setBounds(330,265,145,35);
        fastcash.setForeground(Color.BLACK);
        fastcash.setFont(new Font("Raleway",Font.BOLD,12));
        image.add(fastcash);
        
        ministatement=new JButton("MINI STATEMENT");
        ministatement.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Ministatement1(pinnumber).setVisible(true);
            }
        
        });
        ministatement.setBounds(330,310,145,35);
        ministatement.setForeground(Color.BLACK);
        ministatement.setFont(new Font("Raleway",Font.BOLD,12));
        image.add(ministatement);
        
        pinchange=new JButton("PIN CHANGE");
        pinchange.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                new Pinchange1(pinnumber).setVisible(true);
            }
        
        });
        pinchange.setBounds(330,355,145,35);
        pinchange.setForeground(Color.BLACK);
        pinchange.setFont(new Font("Raleway",Font.BOLD,12));
        image.add(pinchange);
        
        balance=new JButton("BALANCE");
        balance.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                new Balanceenquiry1(pinnumber).setVisible(true);
            }
        
        });
        balance.setBounds(160,355,145,35);
        balance.setForeground(Color.BLACK);
        balance.setFont(new Font("Raleway",Font.BOLD,12));
        image.add(balance);
        
        exit=new JButton("EXIT");
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        exit.setBounds(245,400,145,35);
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("Raleway",Font.BOLD,12));
        image.add(exit);
    }
}

public class transaction {
public static void main(String args[]){
    transaction1 t1 =new transaction1("");
    t1.setVisible(true);
}    
}
