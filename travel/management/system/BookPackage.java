package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class BookPackage extends JFrame implements ActionListener{

    Choice Cpackage;
    String username;

    JButton CheckPrize, book, back;
    TextField numPeo;
    JLabel labelusername, labelid, labelidnum, tota;

    BookPackage(String username){
        this.username = username;
        setBounds(350, 200, 900, 500);
        setLayout(null);
        setBackground(Color.WHITE);

        JLabel item = new JLabel("BOOK PACKAGE");
        item.setBounds(150, 10, 200, 30);
        item.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(item);

        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(30, 100, 150, 25);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(250, 100, 150, 25);
        add(labelusername);

        JLabel lblcpackage = new JLabel("Chose Your Package:");
        lblcpackage.setBounds(30, 140, 200, 25);
        lblcpackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblcpackage);

        Cpackage = new Choice();
        Cpackage.add("GOLD PACKAGE");
        Cpackage.add("SILVER PACKAGE");
        Cpackage.add("BRONZE PACKAGE");
        Cpackage.setBounds(250, 145, 150, 25);
        Cpackage.setForeground(Color.BLACK);
        add(Cpackage);

        JLabel no_people = new JLabel("Number of people:");
        no_people.setBounds(30, 180, 200, 25);
        no_people.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(no_people);

        numPeo = new TextField("1");
        numPeo.setBounds(250, 180, 150, 25);
        numPeo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(numPeo);

        JLabel lblid = new JLabel("ID :");
        lblid.setBounds(30, 220, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 220, 150, 25);
        add(labelid);

        JLabel lblidnum = new JLabel("ID No. :");
        lblidnum.setBounds(30, 260, 150, 25);
        lblidnum.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblidnum);

        labelidnum = new JLabel();
        labelidnum.setBounds(250, 260, 150, 25);
        add(labelidnum);

        JLabel lblcont = new JLabel("Contact :");
        lblcont.setBounds(30, 300, 150, 25);
        lblcont.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblcont);

        JLabel labelcont = new JLabel();
        labelcont.setBounds(250, 300, 150, 25);
        add(labelcont);

        JLabel tot = new JLabel("Total Prize :");
        tot.setBounds(30, 340, 150, 25);
        tot.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(tot);

        tota = new JLabel();
        tota.setBounds(250, 340, 150, 25);
        add(tota);


        try{
            conn conn = new conn();
            String query = " select * from customer where username = '"+username+"' ";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelidnum.setText(rs.getString("number"));
                labelcont.setText(rs.getString("contact"));
                }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        CheckPrize = new JButton("Check Prize");
        CheckPrize.setBounds(100, 400, 130, 30);
        CheckPrize.setBackground(Color.DARK_GRAY);
        CheckPrize.setForeground(Color.WHITE);
        CheckPrize.addActionListener(this);
        add(CheckPrize);

        book = new JButton("Book Now");
        book.setBounds(270, 400, 130, 30);
        book.setBackground(Color.DARK_GRAY);
        book.setForeground(Color.WHITE);
        book.addActionListener(this);
        add(book);

        back = new JButton("Go Back");
        back.setBounds(440, 400, 130, 30);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookPackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(450, 50, 425, 300);
        add(l10);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == CheckPrize){
            String pack = Cpackage.getSelectedItem();
            int cost = 0;
            if(pack.equals("GOLD PACKAGE")){
                cost = 12000;
            }else if(pack.equals("SILVER PACKAGE")){
                cost = 8000;
            }else{
                cost = 4000;
            }
            int person = Integer.parseInt(numPeo.getText());
            cost *= person;
            tota.setText("Rs" + cost);
        }else if(ae.getSource() == book){
            try{
                conn c = new conn();
                c.s.executeUpdate("insert into packages values('"+labelusername.getText()+"', '"+Cpackage.getSelectedItem()+"', '"+numPeo.getText()+"', '"+labelid.getText()+"', '"+labelidnum.getText()+"', '"+tota.getText()+"' )");

                JOptionPane.showMessageDialog(null, "Package booked succesfully");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == back){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new BookPackage("anubhav007");
    }
}
