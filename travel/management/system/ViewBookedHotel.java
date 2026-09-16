package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewBookedHotel extends JFrame implements ActionListener{

    JButton back;

    ViewBookedHotel(String username){

        
        setBounds(400, 200, 1000, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel tect = new JLabel("VIEW HOTEL DETAILS");
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

        JLabel lblpackage = new JLabel("Hotel :");
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

        JLabel lbldays = new JLabel("Number of Days :");
        lbldays.setBounds(30, 300, 150, 25);
        add(lbldays);

        JLabel labeldays = new JLabel();
        labeldays.setBounds(200, 300, 150, 25);
        add(labeldays);

        JLabel lblac = new JLabel("AC/NON AC :");
        lblac.setBounds(30, 350, 150, 25);
        add(lblac);

        JLabel labelac = new JLabel();
        labelac.setBounds(200, 350, 150, 25);
        add(labelac);

        JLabel lblfood = new JLabel("Food Included :");
        lblfood.setBounds(30, 400, 150, 25);
        add(lblfood);

        JLabel labelfood = new JLabel();
        labelfood.setBounds(200, 400, 150, 25);
        add(labelfood);

        JLabel lblamount = new JLabel("Total Amount :");
        lblamount.setBounds(30, 450, 150, 25);
        add(lblamount);

        JLabel labelamount = new JLabel();
        labelamount.setBounds(200, 450, 150, 25);
        add(labelamount);

        back = new JButton("Back");
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 475, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(430, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 40, 430, 500);
        add(image);


        try{
            conn conn = new conn();
            String query = " select * from Booked_Hotel_History where username = '"+username+"' ";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnum.setText(rs.getString("idnum"));
                labelpack.setText(rs.getString("Hname"));
                labelpeo.setText(rs.getString("no_people"));
                labeldays.setText(rs.getString("no_days"));
                labelac.setText(rs.getString("RoomType"));
                labelfood.setText(rs.getString("food"));
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
        new ViewBookedHotel("anubhav007");
    }
}
