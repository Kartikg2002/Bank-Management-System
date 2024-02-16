
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class Deposit1 extends JFrame{
    JLabel image,text;
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    Deposit1(String pinnumber){
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
        
        text =new JLabel("Enter the amount you want to deposit :");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(155,230,700,35);
        image.add(text);
        
        amount =new JTextField();
        amount.setForeground(Color.BLACK);
        amount.setFont(new Font("Raleway",Font.BOLD,16));
        amount.setBounds(155,270,320,25);
        image.add(amount);
        
        deposit =new JButton("Deposit");
        deposit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String samount=amount.getText();
                Date date=new Date();
                if(samount.equals("")){
                    JOptionPane.showMessageDialog(null,"PLEASE ENTER THE AMOUNT!!!!");
                }
                else{
                    try{
                    Conn c=new Conn();
                    String query=String.format("INSERT INTO bank VALUES('%s','%s','%s','%s')",pinnumber,date,"Deposit",samount);
                    c.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+samount+" DEPOSIT SUCCESSFULLY");
                    setVisible(false);
                    new transaction1(pinnumber).setVisible(true);
                    }catch(Exception ae){
                        System.out.println(ae);
                    }  
                }
            }
        
        });
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("Raleway",Font.BOLD,16));
        deposit.setBounds(360,380,120,25);
        image.add(deposit);
        
        
        back =new JButton("Back");
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                new transaction1(pinnumber).setVisible(true);
            }
        
        });
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.setBounds(360,420,120,25);
        image.add(back);
        
        
        
    }
}

public class Depsoit {
    public static void main(String args[]){
    Deposit1 d1 = new Deposit1("");
    d1.setVisible(true);
    }
}
