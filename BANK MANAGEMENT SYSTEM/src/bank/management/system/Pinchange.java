package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

class Pinchange1 extends JFrame{
    JLabel image,text,pintext,repintext;
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    Pinchange1(String pinnumber){
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
        
        text=new JLabel("CHANGE YOUR PIN  ");
        text.setBounds(240,250,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);
        
        pintext=new JLabel("NEW PIN: ");
        pintext.setBounds(150,300,700,35);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(pintext);
                       
        pin =new JPasswordField();
        pin.setForeground(Color.BLACK);
        pin.setFont(new Font("Raleway",Font.BOLD,16));
        pin.setBounds(330,305,150,25);
        image.add(pin);
        
        repintext=new JLabel("RE-ENTER NEW PIN:");
        repintext.setBounds(150,350,700,35);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(repintext);
        
        repin =new JPasswordField();
        repin.setForeground(Color.BLACK);
        repin.setFont(new Font("Raleway",Font.BOLD,16));
        repin.setBounds(330,350,150,25);
        image.add(repin);
        
        
        change=new JButton("CHANGE");
        change.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    String spin = pin.getText();
                    String srepin=repin.getText();
                    
                    if(!spin.equals(srepin)){
                        JOptionPane.showMessageDialog(null, "ENTERED PIN DOES NOT MATCH ");
                        return;
                    }
                    if(spin.equals("")){
                        JOptionPane.showMessageDialog(null, "PLEASE ENTER NEW PIN ");
                        return;
                    }
                    if(srepin.equals("")){
                        JOptionPane.showMessageDialog(null, "PLEASE RE-ENTER NEW PIN ");
                        return;
                    }
                    Conn c=new Conn();
                    String query1=String.format("UPDATE bank SET pin='"+srepin+"' WHERE pin='"+pinnumber+"'");
                    String query2=String.format("UPDATE login SET pinno='"+srepin+"' WHERE pinno='"+pinnumber+"'");
                    String query3=String.format("UPDATE signup3 SET pinno='"+srepin+"' WHERE pinno='"+pinnumber+"'");
                    
                    c.statement.executeUpdate(query1);
                    c.statement.executeUpdate(query2);
                    c.statement.executeUpdate(query3);
                    
                    JOptionPane.showMessageDialog(null, "PIN CHANGED SUCCESSFULLY");
                    setVisible(false);
                    new transaction1(srepin).setVisible(true);        
          
                }catch(Exception ae){
                    System.out.println(e);
                }
            }
        });
        change.setBounds(160,430,100,35);
        change.setForeground(Color.BLACK);
        change.setFont(new Font("Raleway",Font.BOLD,12));
        image.add(change);
        
        
        back=new JButton("BACK");
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                new transaction1(pinnumber).setVisible(true);
            }
        });
        back.setBounds(340,430,100,35);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Raleway",Font.BOLD,12));
        image.add(back);
        
        
    }
}
public class Pinchange {
    public static void main(String args[]){
        Pinchange1 p1 = new Pinchange1("");
        p1.setVisible(true);
    }
}
