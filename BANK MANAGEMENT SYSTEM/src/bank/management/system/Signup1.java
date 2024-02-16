package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
class Signup_One extends JFrame{
    Random r= new Random();
    long random=Math.abs((r.nextLong() % 90000L) + 1000L);
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    private JButton b1;
    private JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
    private JRadioButton rb1,rb2,rb3,rb4;
    Signup_One(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(850,720);
        setTitle("ATM");
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        l1=new JLabel("APPLICATION FORM NO." +"   " + random );
        l1.setBounds(180,5,500,70);
        l1.setFont(new Font("Raleway",Font.BOLD,30));
        l1.setForeground(Color.BLUE);
        add(l1);
        
        l2=new JLabel("PAGE 1: PERSONAL DETAILS");
        l2.setFont(new Font("RALEWAY",Font.BOLD,15));
        l2.setBounds(280,70,300,20);
        add(l2);
        
        l3=new JLabel("NAME:");
        l3.setFont(new Font("RALEWAY",Font.BOLD,20));
        l3.setBounds(50,120,150,80);
        add(l3);
        tf1=new JTextField();
        tf1.setBounds(380,145,300,30);
        tf1.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(tf1);
        
        l4=new JLabel("FATHERS'S NAME:");
        l4.setFont(new Font("RALEWAY",Font.BOLD,20));
        l4.setBounds(50,170,200,80);
        add(l4);
        tf2=new JTextField();
        tf2.setBounds(380,195,300,30);
        tf2.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(tf2);
        
        l5=new JLabel("DATE OF BIRTH:");
        l5.setFont(new Font("RALEWAY",Font.BOLD,20));
        l5.setBounds(50,220,200,80);
        add(l5);
        JDateChooser date=new JDateChooser();
        date.setBounds(380,245,300,30);
        date.setFont(new Font("Raleway",Font.BOLD,20));
        add(date);
        
        l6=new JLabel("GENDER:");
        l6.setFont(new Font("RALEWAY",Font.BOLD,20));
        l6.setBounds(50,270,150,80);
        add(l6);
        rb1=new JRadioButton("MALE");
        rb1.setBounds(380,290,60,30);
        rb1.setBackground(Color.WHITE);
        add(rb1);
        rb2=new JRadioButton("FEMALE");
        rb2.setBounds(500,290,70,30);
        rb2.setBackground(Color.WHITE);
        add(rb2);
        ButtonGroup bg=new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        
        l7=new JLabel("EMAIL ADDRESS:");
        l7.setFont(new Font("RALEWAY",Font.BOLD,20));
        l7.setBounds(50,320,200,80);
        add(l7);
        tf3=new JTextField();
        tf3.setBounds(380,345,300,30);
        tf3.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(tf3);
        
        l8=new JLabel("MARITAL STATUS:");
        l8.setFont(new Font("RALEWAY",Font.BOLD,20));
        l8.setBounds(50,370,200,80);
        add(l8);
        rb3=new JRadioButton("MARRIED");
        rb3.setBounds(380,390,90,30);
        rb3.setBackground(Color.WHITE);
        add(rb3);
        rb4=new JRadioButton("UNMARRIED");
        rb4.setBounds(500,390,100,30);
        rb4.setBackground(Color.WHITE);
        add(rb4);
        ButtonGroup bg1=new ButtonGroup();
        bg1.add(rb3);
        bg1.add(rb4);
        
        l9=new JLabel("ADDRESS:");
        l9.setFont(new Font("RALEWAY",Font.BOLD,20));
        l9.setBounds(50,420,200,80);
        add(l9);
        tf4=new JTextField();
        tf4.setBounds(380,445,300,30);
        tf4.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(tf4);
        
        l10=new JLabel("CITY:");
        l10.setFont(new Font("RALEWAY",Font.BOLD,20));
        l10.setBounds(50,470,150,80);
        add(l10); 
        tf5=new JTextField();
        tf5.setBounds(380,495,300,30);
        tf5.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(tf5);
        
        l11=new JLabel("STATE:");
        l11.setFont(new Font("RALEWAY",Font.BOLD,20));
        l11.setBounds(50,525,150,80);
        add(l11); 
        tf6=new JTextField();
        tf6.setBounds(380,545,300,30);
        tf6.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(tf6);
        
        l12=new JLabel("PINCODE:");
        l12.setFont(new Font("RALEWAY",Font.BOLD,20));
        l12.setBounds(50,575,150,80);
        add(l12);
        tf7=new JTextField();
        tf7.setBounds(380,595,300,30);
        tf7.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(tf7);
        b1=new JButton("NEXT");
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String formno=""+random;
                    String name=tf1.getText();
                    String fname=tf2.getText();
                    String dob=((JTextField) date.getDateEditor().getUiComponent()).getText();
                    String gender=null;
                    if(rb1.isSelected()){
                        gender="male";
                    }
                    else if(rb2.isSelected()){
                    gender="female";
                }
                    String email=tf3.getText();
                    String marital=null; 
                    if(rb3.isSelected()){
                        marital="married";
                    }
                    else if(rb4.isSelected()){
                    marital="unmarried";
                }
                    String address=tf4.getText();
                    String city=tf5.getText();
                    String state=tf6.getText();
                    String pin=tf7.getText();     
                    //Validation--------------
                    if(name.equals("")){
                        JOptionPane.showMessageDialog(null,"NAME IS MANDATORY TO BE FILLED");
                    }
                    else{
                        Conn c=new Conn();
                        String query=String.format("INSERT INTO signup VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s',"
                        + "'%s','%s')",formno,name,fname,dob,gender,email,marital,address
                        ,city,state,pin);
                        c.statement.executeUpdate(query);
                        
                        setVisible(false);
                        new Signup_Two(formno).setVisible(true);
                    }
                }catch(Exception ae){
                    System.out.println(ae);
                }
            }
        });
        b1.setBounds(690,640,70,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
    }
}

public class Signup1 {
    public static void main(String [] args){
        Signup_One s = new Signup_One();
        s.setVisible(true);
    }
    
}
