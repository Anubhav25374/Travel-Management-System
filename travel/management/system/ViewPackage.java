package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewPackage extends JFrame implements ActionListener{

    JButton back;

    ViewPackage(String username){

        
        setBounds(375, 150, 870, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel tect = new JLabel("VIEW PACKAGE DETAILS");
        tect.setBounds(100, 15, 250, 30);
        tect.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(tect);

        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(200, 50, 150, 25);
        add(labelusername);

        JLabel lblid = new JLabel("ID Proof :");
        lblid.setBounds(30, 100, 150, 25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(200, 100, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("ID Number :");
        lblnumber.setBounds(30, 150, 150, 25);
        add(lblnumber);

        JLabel labelnum = new JLabel();
        labelnum.setBounds(200, 150, 150, 25);
        add(labelnum);

        JLabel lblpackage = new JLabel("Package :");
        lblpackage.setBounds(30, 200, 150, 25);
        add(lblpackage);

        JLabel labelpack = new JLabel();
        labelpack.setBounds(200, 200, 150, 25);
        add(labelpack);

        JLabel lblpeo = new JLabel("Number of people :");
        lblpeo.setBounds(30, 250, 150, 25);
        add(lblpeo);

        JLabel labelpeo = new JLabel();
        labelpeo.setBounds(200, 250, 150, 25);
        add(labelpeo);

        JLabel lblprize = new JLabel("Amount :");
        lblprize.setBounds(30, 300, 150, 25);
        add(lblprize);

        JLabel labelamount = new JLabel();
        labelamount.setBounds(200, 300, 150, 25);
        add(labelamount);

        back = new JButton("Back");
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 350, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(430, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(425, 0, 430, 500);
        add(image);


        try{
            conn conn = new conn();
            String query = " select * from packages where username = '"+username+"' ";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnum.setText(rs.getString("id_num"));
                labelpack.setText(rs.getString("package"));
                labelpeo.setText(rs.getString("no_people"));
                labelamount.setText(rs.getString("amount"));
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
        new ViewPackage("anubhav007");
    }
}
