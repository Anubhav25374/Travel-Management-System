package travel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.*;
import javax.swing.*;

public class dashBoard extends JFrame implements ActionListener{
    String username;
    JButton pDetails, viewDetails, updateDetails, checkPackage, bookPackage, viewHotels, bookHotels, destination, vbookHotels;

    dashBoard(String username){
        this.username = username;

        //setBounds(0, 0, 1600, 900);
        setExtendedState(JFrame.MAXIMIZED_BOTH);                             //auto create a frame of full size of desktop
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 1600, 65);
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(5, 0, 70, 70);
        p1.add(image);

        JLabel lal = new JLabel("DashBoard");
        lal.setBounds(80, 0, 500, 70);
        lal.setFont(new Font("Tahoma",Font.BOLD,30 ));
        lal.setForeground(Color.WHITE);
        p1.add(lal);

        JPanel p2 = new JPanel();
        p2.setBounds(0, 65, 400, 800);
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        add(p2);

        pDetails = new JButton("Add personal Details");
        pDetails.setBounds(0, 0, 400, 50);
        pDetails.setFont(new Font("Tohoma",Font.PLAIN,15));
        pDetails.setBackground(new Color(0,0,102));
        pDetails.setMargin(new Insets(0, 0, 0, 147));
        pDetails.setForeground(Color.WHITE);
        p2.add(pDetails);
        pDetails.addActionListener(this);

        updateDetails = new JButton("Update personal Details");
        updateDetails.setBounds(0, 50, 400, 50);
        updateDetails.setFont(new Font("Tohoma",Font.PLAIN,15));
        updateDetails.setBackground(new Color(0,0,102));
        updateDetails.setMargin(new Insets(0, 0, 0, 130));
        updateDetails.setForeground(Color.WHITE);
        p2.add(updateDetails);
        updateDetails.addActionListener(this);

        viewDetails = new JButton("View Details");
        viewDetails.setBounds(0, 100, 400, 50);
        viewDetails.setFont(new Font("Tohoma",Font.PLAIN,15));
        viewDetails.setBackground(new Color(0,0,102));
        viewDetails.setMargin(new Insets(0, 0, 0, 210));
        viewDetails.setForeground(Color.WHITE);
        viewDetails.addActionListener(this);
        p2.add(viewDetails);

        JButton deleteDetails = new JButton("Delete Personal Details");
        deleteDetails.setBounds(0, 150, 400, 50);
        deleteDetails.setFont(new Font("Tohoma",Font.PLAIN,15));
        deleteDetails.setBackground(new Color(0,0,102));
        deleteDetails.setMargin(new Insets(0, 0, 0, 140));
        deleteDetails.setForeground(Color.WHITE);
        p2.add(deleteDetails);
        
        checkPackage = new JButton("Check Package");
        checkPackage.setBounds(0, 200, 400, 50);
        checkPackage.setFont(new Font("Tohoma",Font.PLAIN,15));
        checkPackage.setBackground(new Color(0,0,102));
        checkPackage.setMargin(new Insets(0, 0, 0, 192));
        checkPackage.setForeground(Color.WHITE);
        checkPackage.addActionListener(this);
        p2.add(checkPackage);

        bookPackage = new JButton("Book Package");
        bookPackage.setBounds(0, 250, 400, 50);
        bookPackage.setFont(new Font("Tohoma",Font.PLAIN,15));
        bookPackage.setBackground(new Color(0,0,102));
        bookPackage.setMargin(new Insets(0, 0, 0, 195));
        bookPackage.setForeground(Color.WHITE);
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        JButton viewPackage = new JButton("View Package");
        viewPackage.setBounds(0, 300, 400, 50);
        viewPackage.setFont(new Font("Tohoma",Font.PLAIN,15));
        viewPackage.setBackground(new Color(0,0,102));
        viewPackage.setMargin(new Insets(0, 0, 0, 197));
        viewPackage.setForeground(Color.WHITE);
        p2.add(viewPackage);

        viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(0, 350, 400, 50);
        viewHotels.setFont(new Font("Tohoma",Font.PLAIN,15));
        viewHotels.setBackground(new Color(0,0,102));
        viewHotels.setMargin(new Insets(0, 0, 0, 213));
        viewHotels.setForeground(Color.WHITE);
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        bookHotels = new JButton("Book Hotels");
        bookHotels.setBounds(0, 400, 400, 50);
        bookHotels.setFont(new Font("Tohoma",Font.PLAIN,15));
        bookHotels.setBackground(new Color(0,0,102));
        bookHotels.setMargin(new Insets(0, 0, 0, 213));
        bookHotels.setForeground(Color.WHITE);
        bookHotels.addActionListener(this);
        p2.add(bookHotels);

        vbookHotels = new JButton("View Book Hotels");
        vbookHotels.setBounds(0, 450, 400, 50);
        vbookHotels.setFont(new Font("Tohoma",Font.PLAIN,15));
        vbookHotels.setBackground(new Color(0,0,102));
        vbookHotels.setMargin(new Insets(0, 0, 0, 175));
        vbookHotels.setForeground(Color.WHITE);
        vbookHotels.addActionListener(this);
        p2.add(vbookHotels);

        destination = new JButton("Destination");
        destination.setBounds(0, 500, 400, 50);
        destination.setFont(new Font("Tohoma",Font.PLAIN,15));
        destination.setBackground(new Color(0,0,102));
        destination.setMargin(new Insets(0, 0, 0, 223));
        destination.setForeground(Color.WHITE);
        destination.addActionListener(this);
        p2.add(destination);

        JButton cal = new JButton("Calculator");
        cal.setBounds(0, 550, 400, 50);
        cal.setFont(new Font("Tohoma",Font.PLAIN,15));
        cal.setBackground(new Color(0,0,102));
        cal.setMargin(new Insets(0, 0, 0, 230));
        cal.setForeground(Color.WHITE);
        p2.add(cal);

        JButton note = new JButton("NotePad");
        note.setBounds(0, 600, 400, 50);
        note.setFont(new Font("Tohoma",Font.PLAIN,15));
        note.setBackground(new Color(0,0,102));
        note.setMargin(new Insets(0, 0, 0, 240));
        note.setForeground(Color.WHITE);
        p2.add(note);

        JButton pay = new JButton("Payment");
        pay.setBounds(0, 650, 400, 50);
        pay.setFont(new Font("Tohoma",Font.PLAIN,15));
        pay.setBackground(new Color(0,0,102));
        pay.setMargin(new Insets(0, 0, 0, 240));
        pay.setForeground(Color.WHITE);
        p2.add(pay);

        JButton About = new JButton("About");
        About.setBounds(0, 700, 400, 50);
        About.setFont(new Font("Tohoma",Font.PLAIN,15));
        About.setBackground(new Color(0,0,102));
        About.setMargin(new Insets(0, 0, 0, 250));
        About.setForeground(Color.WHITE);
        p2.add(About);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1200, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel img = new JLabel(i6);
        img.setBounds(150, 0, 1650, 1000);
        add(img);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == pDetails){
            new AddCustomer(username);
        }else if(ae.getSource() == viewDetails){
            new ViewCustomer(username);
        }else if(ae.getSource() == updateDetails){
            new UpdateDetails(username);
        }else if(ae.getSource() == checkPackage){
            new CheckPackage();
        }else if(ae.getSource() == bookPackage){
            new BookPackage(username);
        }else if(ae.getSource() == viewHotels){
            new CheckHotels();
        }else if(ae.getSource() == destination){
            new Destination();
        }else if(ae.getSource() == bookHotels){
            new BookHotel(username);
        }else if(ae.getSource() == vbookHotels){
            new ViewBookedHotel(username);
        }    
    }
    public static void main(String[] args) {
        new dashBoard("anubhav007");
    }
}
