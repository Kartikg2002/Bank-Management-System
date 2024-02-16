
package bank.management.system;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Login extends JFrame{
    private JLabel l1,l2,l3,l4;
    private JButton b1,b2,b3;
    private JTextField tf1,tf2,tf3;
    private JPasswordField tp1;
    Login(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800,600);
        setTitle("ATM");
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Font f1=new Font(Font.SANS_SERIF,Font.ITALIC,40);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bank.jpg"));
        Image i2=i1.getImage().getScaledInstance(150, 100, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        l1=new JLabel(i3);
        l1.setBounds(50,10,150,100);
        add(l1);
        
        l2=new JLabel("WELCOME TO ATM");
        l2.setFont(f1);
        l2.setBounds(280,10,500,100);
        add(l2);
        
        l3=new JLabel("CARD NO. :");
        l3.setFont(new Font("RALEWAY",Font.BOLD,25));
        l3.setBounds(50,150,150,100);
        add(l3);
        tf1=new JTextField();
        tf1.setForeground(Color.RED);
        tf1.setFont(new Font("RALEWAY",Font.BOLD,30));
        tf1.setBounds(300,170,350,50);
        add(tf1);
        
        
        l4=new JLabel("PIN:");
        l4.setFont(new Font("RALEWAY",Font.BOLD,25));
        l4.setBounds(50,250,120,100);
        add(l4);
        tp1=new JPasswordField();
        tp1.setForeground(Color.RED);
        tp1.setFont(new Font("RALEWAY",Font.BOLD,30));
        tp1.setBounds(300,270,350,50);
        add(tp1);
        
        b1=new JButton("LOGIN");
        b1.setBounds(180,400,100,50);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("RALEWAY",Font.BOLD,15));
        add(b1);
        
        b1.addActionListener( new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            try{
            Conn c=new Conn();
            String cardnumber=tf1.getText();
            String pinnumber=tp1.getText();
            String query="SELECT * FROM login WHERE cardno='"+cardnumber+"' AND pinno='"+pinnumber+"'";
            ResultSet resultset=c.statement.executeQuery(query);
            if(resultset.next()){
                setVisible(false);
                new transaction1(pinnumber).setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "INCORRECT CORRECT CARD NO. OR PIN NO.");
            }
            }catch(SQLException ae){
                System.out.println(ae);
            }
        } 
        });
        
        b2=new JButton("CLEAR");
        b2.setBounds(450,400,100,50);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("RALEWAY",Font.BOLD,15));
        add(b2);
        
        b2.addActionListener( new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            tf1.setText(null);
            tp1.setText(null);
            }
        });
        
        b3=new JButton("SIGN UP");
        b3.setBounds(265,495,200,50);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("RALEWAY",Font.BOLD,15));
        add(b3);
        
        b3.addActionListener( new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            setVisible(false);
            new Signup_One().setVisible(true);
            }
        });
        
    }
}
 
public class Login1{

    public static void main(String[] args) {
        Login l=new Login();
        l.setVisible(true);
        
    }
        
    }
    
