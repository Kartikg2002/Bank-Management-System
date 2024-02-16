
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Random;
class Signup_Three extends JFrame{
    private JLabel header,accounttype,cardno,number,pinno,pnumber,carddetail,pindetail,services;
    private JRadioButton savingaccount,fdaccount,currentaccount,rdaccount;
    private ButtonGroup bg1;
    String formno;
    private JButton submit,cancel;
    private JCheckBox atmcard,internetbank,estatement,cheque,emailalert,mobilebank,declaration;
    Signup_Three(String formno){
        this.formno=formno;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(850,740);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       
        
        header=new JLabel("PAGE3: ACCOUNT DETAILS");
        header.setFont(new Font("Raleway",Font.BOLD,22));
        header.setBounds(260,20,400,20);
        add(header);
        
        
        accounttype=new JLabel("ACCOUNT TYPE");
        accounttype.setFont(new Font("Raleway",Font.BOLD,18));
        accounttype.setBounds(25,110,200,20);
        add(accounttype);
        
        
        savingaccount=new JRadioButton("Saving Account");
        savingaccount.setBackground(Color.WHITE);
        savingaccount.setFont(new Font("Raleway",Font.BOLD,16));
        savingaccount.setBounds(90,155,150,20);
        add(savingaccount);
        
        
        fdaccount=new JRadioButton("Fixed Deposit Account");
        fdaccount.setBackground(Color.WHITE);
        fdaccount.setFont(new Font("Raleway",Font.BOLD,16));
        fdaccount.setBounds(400,155,240,20);
        add(fdaccount);
        
        
        currentaccount=new JRadioButton("Current Account");
        currentaccount.setBackground(Color.WHITE);
        currentaccount.setFont(new Font("Raleway",Font.BOLD,16));
        currentaccount.setBounds(90,190,180,20);
        add(currentaccount);
        
        
        rdaccount=new JRadioButton("Recurring Deposit Account");
        rdaccount.setBackground(Color.WHITE);
        rdaccount.setFont(new Font("Raleway",Font.BOLD,16));
        rdaccount.setBounds(400,190,250,20);
        add( rdaccount);
        
        
        bg1=new ButtonGroup();
        bg1.add(savingaccount);
        bg1.add(rdaccount);
        bg1.add(fdaccount);
        bg1.add(currentaccount);
        
        
        cardno=new JLabel("CARD N0.");
        cardno.setFont(new Font("Raleway",Font.BOLD,18));
        cardno.setBounds(25,270,200,20);
        add(cardno);
        
        carddetail=new JLabel("(YOUR 16 DIGIT CARD NUMBER)");
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail.setBounds(25,290,250,20);
        add(carddetail);
        
        
        number=new JLabel("XXXX-XXXX-XXXX-8765");
        number.setFont(new Font("Raleway",Font.BOLD,18));
        number.setBounds(320,270,220,20);
        add(number);
        
        
        pinno=new JLabel("PIN N0.");
        pinno.setFont(new Font("Raleway",Font.BOLD,18));
        pinno.setBounds(25,340,200,20);
        add(pinno);
        
        pindetail=new JLabel("(YOUR 4 DIGIT PIN)");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(25,360,250,20);
        add(pindetail);
        
        
        pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,18));
        pnumber.setBounds(320,340,100,20);
        add(pnumber);
        
        services=new JLabel("SERVICES REQUIRED");
        services.setFont(new Font("Raleway",Font.BOLD,18));
        services.setBounds(25,430,200,20);
        add(services);
        
        atmcard=new JCheckBox("ATM CARD");
        atmcard.setBackground(Color.WHITE);
        atmcard.setFont(new Font("Raleway",Font.BOLD,16));
        atmcard.setBounds(90,470,200,30);
        add(atmcard);
        
        internetbank=new JCheckBox("INTERNET BANKING");
        internetbank.setBackground(Color.WHITE);
        internetbank.setFont(new Font("Raleway",Font.BOLD,16));
        internetbank.setBounds(400,470,200,30);
        add(internetbank);
        
        mobilebank=new JCheckBox("MOBILE BANKING");
        mobilebank.setBackground(Color.WHITE);
        mobilebank.setFont(new Font("Raleway",Font.BOLD,16));
        mobilebank.setBounds(90,505,200,30);
        add(mobilebank);
        
        emailalert=new JCheckBox("EMAIL & SMS ALERT");
        emailalert.setBackground(Color.WHITE);
        emailalert.setFont(new Font("Raleway",Font.BOLD,16));
        emailalert.setBounds(400,505,200,30);
        add(emailalert);
        
        cheque=new JCheckBox("CHEQUE BOOK");
        cheque.setBackground(Color.WHITE);
        cheque.setFont(new Font("Raleway",Font.BOLD,16));
        cheque.setBounds(90,540,200,30);
        add(cheque);
        
        estatement=new JCheckBox("E-STATEMENT");
        estatement.setBackground(Color.WHITE);
        estatement.setFont(new Font("Raleway",Font.BOLD,16));
        estatement.setBounds(400,540,200,30);
        add(estatement);

        declaration=new JCheckBox("I HEREBY DECLARES THAT THE ABOVE ENTERED DETAILS ARE CORRECT TO THE BEST OF MY KNOWLEDGE.");
        declaration.setBackground(Color.WHITE);
        declaration.setFont(new Font("Raleway",Font.BOLD,14));
        declaration.setBounds(25,595,800,30);
        add(declaration);
        
        submit=new JButton("SUBMIT");
        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String saccounttype = null;
                if(savingaccount.isSelected()){
                    saccounttype="Saving Account";
                }
                else if(fdaccount.isSelected()){
                    saccounttype="Fixed Deposit Account";
                }
                else if(rdaccount.isSelected()){
                    saccounttype="Reccuring Account";
                }
                else if(currentaccount.isSelected()){
                    saccounttype="Current Account";
                }
                
                Random ran =new Random();
                String scardno=""+ Math.abs((ran.nextLong()%90000000L)+5040936000000000L);
                String spinno=""+Math.abs((ran.nextLong()%9000L)+1000L);
                
                ArrayList<String> sservice=new ArrayList<String>();
                if(atmcard.isSelected()){
                    sservice.add("ATM Card");
                }
                if(internetbank.isSelected()){
                    sservice.add("InternetBanking");
                }
                if(mobilebank.isSelected()){
                    sservice.add("Mobile Banking");
                }
                if(emailalert.isSelected()){
                    sservice.add("Email & SMS Alert");
                }
                if(cheque.isSelected()){
                    sservice.add("Cheque Book");
                }
                if(estatement.isSelected()){
                    sservice.add("E- Statement");
                }
               
                //validations--------------
                
                
                if(!declaration.isSelected()){
                       JOptionPane.showMessageDialog(null, "Declaration Must Be Filled");
                }
                if(saccounttype.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type Is Required");
                }
                else{
                try{
                     Conn c=new Conn();
                      
                     String query1= String.format("INSERT INTO signup3 VALUES('%s','%s','%s','%s','%s')"
                     ,formno,saccounttype,scardno,spinno,sservice);
                     
                     String query2=String.format("INSERT INTO login VALUES('%s','%s','%s')",formno,scardno,spinno);
                     
                     c.statement.executeUpdate(query1);
                     c.statement.executeUpdate(query2);
                     
                     JOptionPane.showMessageDialog(null,"Card Number: "+scardno+"\n"+"PIN: "+spinno);
                     setVisible(false);
                     new Deposit1(spinno).setVisible(true);
                     
                        }catch(Exception ae){
                            System.out.println(ae);
                        }
                }
            }
        
        });
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(140,650,100,30);
        add(submit);
        
        cancel=new JButton("CANCEL");
        cancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                new Login().setVisible(true);
            }
        });
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(540,650,100,30);
        add(cancel);


        
    }
}
        
public class Signup3 {
    public static void main(String args[]){
        Signup_Three s3=new Signup_Three("");
        s3.setVisible(true);
        
    }
    
}
