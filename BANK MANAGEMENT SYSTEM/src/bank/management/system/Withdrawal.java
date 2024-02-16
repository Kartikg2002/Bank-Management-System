package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class Withdrawal1 extends JFrame{
    JLabel image,text;
    JTextField amount;
    JButton withdrawal,back;
    String pinnumber;
    Withdrawal1(String pinnumber){
        this.pinnumber=pinnumber;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(850,740);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(850, 740, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,0,850,740);
        add(image);
        
        text =new JLabel("Enter the amount you want to Withdrawal :");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(155,230,700,35);
        image.add(text);
        
        amount =new JTextField();
        amount.setForeground(Color.BLACK);
        amount.setFont(new Font("Raleway",Font.BOLD,16));
        amount.setBounds(155,270,320,25);
        image.add(amount);
        
        withdrawal =new JButton("WITHDRAWAL");
        withdrawal.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String samount=amount.getText();
                Date date=new Date();
                if(samount.equals("")){
                    JOptionPane.showMessageDialog(null,"PLEASE ENTER THE AMOUNT!!!!");
                }
                else{
                    try{
                    Conn c=new Conn();
                    String query=String.format("INSERT INTO bank VALUES('%s','%s','%s','%s')",pinnumber,date,"Withdrawal",samount);
                    c.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+samount+" WITHDRAWAL SUCCESSFULLY");
                    setVisible(false);
                    new transaction1(pinnumber).setVisible(true);
                    }catch(Exception ae){
                        System.out.println(ae);
                    }  
                }
            }
        
        });
        withdrawal.setForeground(Color.BLACK);
        withdrawal.setFont(new Font("Raleway",Font.BOLD,16));
        withdrawal.setBounds(320,380,160,25);
        image.add(withdrawal);
        
        
        back =new JButton("BACK");
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                new transaction1(pinnumber).setVisible(true);
            }
        
        });
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.setBounds(320,420,160,25);
        image.add(back);
        
        
        
    }
}

public class Withdrawal {
    public static void main(String args[]){
    Withdrawal1 w1 = new Withdrawal1("");
    w1.setVisible(true);
    }
}
