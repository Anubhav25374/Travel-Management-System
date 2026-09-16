package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewCustomer extends JFrame implements ActionListener{

    JButton back;

    ViewCustomer(String username){
        setBounds(375, 150, 870, 625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(200, 50, 150, 25);
        labelusername.setForeground(Color.MAGENTA);
        add(labelusername);

        JLabel lblid = new JLabel("ID Proof :");
        lblid.setBounds(30, 100, 150, 25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(200, 100, 150, 25);
        labelid.setForeground(Color.MAGENTA);
        add(labelid);

        JLabel lblnumber = new JLabel("ID Number :");
        lblnumber.setBounds(30, 150, 150, 25);
        add(lblnumber);

        JLabel labelnum = new JLabel();
        labelnum.setBounds(200, 150, 150, 25);
        labelnum.setForeground(Color.MAGENTA);
        add(labelnum);

        JLabel lblname = new JLabel("Name :");
        lblname.setBounds(30, 200, 150, 25);
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200, 200, 150, 25);
        labelname.setForeground(Color.MAGENTA);
        add(labelname);

        JLabel lblgender = new JLabel("Gender :");
        lblgender.setBounds(30, 250, 150, 25);
        add(lblgender);

        JLabel labelgender = new JLabel();
        labelgender.setBounds(200, 250, 150, 25);
        labelgender.setForeground(Color.MAGENTA);
        add(labelgender);

        JLabel lblcountry = new JLabel("Nationality :");
        lblcountry.setBounds(400, 50, 150, 25);
        add(lblcountry);

        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(550, 50, 150, 25);
        labelcountry.setForeground(Color.MAGENTA);
        add(labelcountry);

        JLabel lbladdress = new JLabel("Address :");
        lbladdress.setBounds(400, 100, 150, 25);
        add(lbladdress);

        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(550, 100, 150, 25);
        labeladdress.setForeground(Color.MAGENTA);
        add(labeladdress);

        JLabel lblcontact = new JLabel("Contact :");
        lblcontact.setBounds(400, 150, 150, 25);
        add(lblcontact);

        JLabel labelcontact = new JLabel();
        labelcontact.setBounds(550, 150, 150, 25);
        labelcontact.setForeground(Color.MAGENTA);
        add(labelcontact);

        JLabel lblmail = new JLabel("Email :");
        lblmail.setBounds(400, 200, 150, 25);
        add(lblmail);

        JLabel labelmail = new JLabel();
        labelmail.setBounds(550, 200, 150, 25);
        labelmail.setForeground(Color.MAGENTA);
        add(labelmail);

        back = new JButton("Back");
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(480, 300, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(75, 400, 700, 200);
        add(image);


        try{
            conn conn = new conn();
            String query = " select * from customer where username = '"+username+"' ";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnum.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelcontact.setText(rs.getString("contact"));
                labelmail.setText(rs.getString("mail"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewCustomer("anubhav007");
    }
}
