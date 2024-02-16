package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.sql.*;
class Signup_Two extends JFrame{
    private JLabel l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    private JButton b1;
    private JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
    private JRadioButton rb1,rb2,rb3,rb4;
    String formno;
    Signup_Two(String formno){
        this.formno=formno;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(850,720);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE2");
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
               
        l2=new JLabel("PAGE 2: ADDITIONAL DETAILS");
        l2.setFont(new Font("RALEWAY",Font.BOLD,25));
        l2.setBounds(260,40,400,20);
        add(l2);
        
        l3=new JLabel("RELIGION:");
        l3.setFont(new Font("RALEWAY",Font.BOLD,20));
        l3.setBounds(50,120,150,80);
        add(l3);
        String valreligion[]={"HINDU","MUSLIM","CHRISTIAN","SIKH","OTHER"};
        JComboBox religion=new JComboBox(valreligion);
        religion.setBackground(Color.WHITE);
        religion.setBounds(380,140,300,30);
        religion.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(religion);
       
        
        l4=new JLabel("CATEGORY:");
        l4.setFont(new Font("RALEWAY",Font.BOLD,20));
        l4.setBounds(50,175,200,80);
        add(l4);
        String valcategory[]={"GENERAL","OBC","SC","ST","OTHER"};
        JComboBox category=new JComboBox(valcategory);
        category.setBackground(Color.WHITE);
        category.setBounds(380,195,300,30);
        category.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(category);
       
        
        l5=new JLabel("INCOME:");
        l5.setFont(new Font("RALEWAY",Font.BOLD,20));
        l5.setBounds(50,225,200,80);
        add(l5);
        String valincome[]={"NULL","<1,50,000","2,50,000","5,00,000","UPTO 10,00,000"};
        JComboBox income=new JComboBox(valincome);
        income.setBackground(Color.WHITE);
        income.setBounds(380,245,300,30);
        income.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(income);
       
        
        l6=new JLabel("EDUCATION");
        l6.setFont(new Font("RALEWAY",Font.BOLD,20));
        l6.setBounds(50,280,150,80);
        add(l6);
        l7=new JLabel("QUALIFICATION:");
        l7.setFont(new Font("RALEWAY",Font.BOLD,20));
        l7.setBounds(50,300,200,80);
        add(l7);
        String valeducation[]={"NON-GRADUATION","GRADUATE","POST-GRADUATION","DOCTRATE","OTHERS"};
        JComboBox education=new JComboBox(valeducation);
        education.setBackground(Color.WHITE);
        education.setBounds(380,310,300,30);
        education.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(education);
      
        
        l8=new JLabel("OCCUPATION:");
        l8.setFont(new Font("RALEWAY",Font.BOLD,20));
        l8.setBounds(50,370,200,80);
        add(l8);
        String valoccupation[]={"SALARIED","SELF-EMPLOYED","BUSSINESS","STUDENT","RETIRED","OTHERS"};
        JComboBox occupation=new JComboBox(valoccupation);
        occupation.setBackground(Color.WHITE);
        occupation.setBounds(380,390,300,30);
        occupation.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(occupation);
        
        
        l9=new JLabel("PAN NUMBER:");
        l9.setFont(new Font("RALEWAY",Font.BOLD,20));
        l9.setBounds(50,420,200,80);
        add(l9);
        tf4=new JTextField();
        tf4.setBounds(380,445,300,30);
        tf4.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(tf4);
        
        
        l10=new JLabel("AADHAR NUMBER:");
        l10.setFont(new Font("RALEWAY",Font.BOLD,20));
        l10.setBounds(50,470,200,80);
        add(l10); 
        tf5=new JTextField();
        tf5.setBounds(380,495,300,30);
        tf5.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(tf5);
        
        
        l11=new JLabel("SENIOR CITIZEN:");
        l11.setFont(new Font("RALEWAY",Font.BOLD,20));
        l11.setBounds(50,525,200,80);
        add(l11);
        rb1=new JRadioButton("YES");
        rb1.setBounds(380,545,90,30);
        rb1.setFont(new Font("RALEWAY",Font.BOLD,20));
        rb1.setBackground(Color.WHITE);
        add(rb1);
        rb2=new JRadioButton("NO");
        rb2.setFont(new Font("RALEWAY",Font.BOLD,20));
        rb2.setBounds(500,545,100,30);
        rb2.setBackground(Color.WHITE);
        add(rb2);
        ButtonGroup bg1=new ButtonGroup();
        bg1.add(rb1);
        bg1.add(rb2);

        
        l12=new JLabel("EXISTING ACCOUNT:");
        l12.setFont(new Font("RALEWAY",Font.BOLD,20));
        l12.setBounds(50,575,210,80);
        add(l12);
        rb3=new JRadioButton("YES");
        rb3.setBounds(380,595,90,30);
        rb3.setFont(new Font("RALEWAY",Font.BOLD,20));
        rb3.setBackground(Color.WHITE);
        add(rb3);
        rb4=new JRadioButton("NO");
        rb4.setFont(new Font("RALEWAY",Font.BOLD,20));
        rb4.setBounds(500,595,100,30);
        rb4.setBackground(Color.WHITE);
        add(rb4);
        ButtonGroup bg2=new ButtonGroup();
        bg2.add(rb3);
        bg2.add(rb4);
        
        b1=new JButton("NEXT");
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                String sreligion=(String)religion.getSelectedItem();
                String scategory=(String)category.getSelectedItem();
                String sincome=(String)income.getSelectedItem();
                String seducation=(String)education.getSelectedItem();
                String soccupation=(String)occupation.getSelectedItem();
                String span=tf4.getText();
                String saadhar=tf5.getText();
                String sseniorcitizen="null";
                if(rb1.equals("Yes")){
                    sseniorcitizen="Yes";
                }
                else{
                    sseniorcitizen="No";
                }
                 String sexistingaccount="null";
                if(rb3.equals("Yes")){
                    sexistingaccount="Yes";
                }
                else{
                    sexistingaccount="No";
                }
                //validatons------
                if(saadhar.equals("")){
                    JOptionPane.showMessageDialog(null,"AADHAR NO. IS MANADATORY TO BE FILLED");
                }
                else{
                    try{
                        Conn c=new Conn();
                        String query= String.format("INSERT INTO signup2 VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
                        formno,sreligion,scategory,sincome,seducation,soccupation,span,saadhar,sseniorcitizen,
                        sexistingaccount);
                        c.statement.executeUpdate(query);
                        
                        setVisible(false);
                        new Signup_Three(formno).setVisible(true);
                    }catch(Exception ae){
                        System.out.println(ae);
                    }
                }
            }
        });
        b1.setBounds(690,640,70,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);


    }
}
public class Signup2{
    public static void main(String args[]){
        Signup_Two s2=new Signup_Two("");
        s2.setVisible(true);
    }
}
    

