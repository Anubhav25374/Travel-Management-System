package travel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ForgotPassword extends JFrame implements ActionListener{

    JTextField f_username, f_name, f_question, f_answer, f_password;
    JButton f_search , aaja, back;

    ForgotPassword(){
        setBounds(375, 175, 900, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(610, 90, 200, 200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setBounds(30, 30, 500, 300);
        p1.setLayout(null);
        p1.setBackground(Color.GRAY);
        add(p1);

        JLabel label1 = new JLabel("Username");
        label1.setFont(new Font("Tahoma",Font.BOLD, 14));     
        label1.setBounds(40, 20, 100, 20);
        p1.add(label1);
        
        f_username = new JTextField();                                              
        f_username.setBounds(220, 20, 150, 20);                              
        f_username.setBorder(null);                                                    
        p1.add(f_username);

        f_search = new JButton("Search");
        f_search.setBounds(400, 20, 70, 20);
        f_search.setBorder(null);
        f_search.setBackground(Color.DARK_GRAY);
        f_search.setForeground(Color.WHITE);
        f_search.addActionListener(this);
        p1.add(f_search);

        JLabel label2 = new JLabel("Name");
        label2.setFont(new Font("Tahoma",Font.BOLD, 14));     
        label2.setBounds(40, 60, 100, 20);
        p1.add(label2);

        f_name = new JTextField();                                              
        f_name.setBounds(220, 60, 150, 20);                              
        f_name.setBorder(null);                                                    
        p1.add(f_name);

        JLabel label3 = new JLabel("Verfication Question");
        label3.setFont(new Font("Tahoma",Font.BOLD, 14));     
        label3.setBounds(40, 100, 150, 20);
        p1.add(label3);

        f_question = new JTextField();                                              
        f_question.setBounds(220, 100, 150, 20);                              
        f_question.setBorder(null);                                                    
        p1.add(f_question);

        JLabel label4 = new JLabel("Answer");
        label4.setFont(new Font("Tahoma",Font.BOLD, 14));     
        label4.setBounds(40, 140, 150, 20);
        p1.add(label4);

        f_answer = new JTextField();                                              
        f_answer.setBounds(220, 140, 150, 20);                              
        f_answer.setBorder(null);                                                    
        p1.add(f_answer);

        JLabel label5 = new JLabel("Password");
        label5.setFont(new Font("Tahoma",Font.BOLD, 14));     
        label5.setBounds(40, 180, 100, 20);
        p1.add(label5);

        f_password = new JTextField();                                              
        f_password.setBounds(220, 180, 150, 20);                              
        f_password.setBorder(null);                                                    
        p1.add(f_password);

        aaja = new JButton("Retrieve");
        aaja.setBounds(400, 140, 70, 20);
        aaja.setBorder(null);
        aaja.setBackground(Color.DARK_GRAY);
        aaja.setForeground(Color.WHITE);
        aaja.addActionListener(this);
        p1.add(aaja);

        back = new JButton("Retun back");
        back.setBounds(200, 230, 70, 20);
        back.setBorder(null);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == f_search){
            try{
                String query = "select * from accounts where username = '"+f_username.getText()+"' ";
                conn c = new conn();                                     //calling connection
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    f_name.setText(rs.getString("fname"));
                    f_question.setText(rs.getString("question"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == aaja){
            try{
                String query = "select * from accounts where username = '"+f_username.getText()+"' and answer = '"+f_answer.getText()+"' ";
                conn c = new conn();                                     //calling connection
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    f_password.setText(rs.getString("password"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new login();
        }    
    }

    public static void main(String[] args) {
        new ForgotPassword();
    }
}
