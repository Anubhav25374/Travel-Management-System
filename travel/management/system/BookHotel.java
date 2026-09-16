package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class BookHotel extends JFrame implements ActionListener{

    Choice CHotel , cac, cfood;
    String username;

    JButton CheckPrize, book, back;
    TextField numDays, numPeople;
    JLabel labelusername, labelcont, labelID, labelIDnum, tota;

    BookHotel(String username){
        this.username = username;
        setBounds(350, 200, 950, 600);
        setLayout(null);
        setBackground(Color.WHITE);

        JLabel item = new JLabel("BOOK HOTEL");
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

        JLabel lblchotel= new JLabel("Select Hotel");
        lblchotel.setBounds(30, 140, 200, 25);
        lblchotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblchotel);

        CHotel = new Choice();
        CHotel.setBounds(250, 145, 150, 25);
        CHotel.setForeground(Color.BLACK);
        add(CHotel);

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from hotels");
            while(rs.next()){
                CHotel.add(rs.getString("Hname"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel no_days = new JLabel("Number of Days:");
        no_days.setBounds(30, 180, 200, 25);
        no_days.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(no_days);

        numDays = new TextField("1");
        numDays.setBounds(250, 180, 150, 25);
        numDays.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(numDays);

        JLabel no_Peo = new JLabel("Number of People :");
        no_Peo.setBounds(30, 220, 200, 25);
        no_Peo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(no_Peo);

        numPeople = new TextField("1");
        numPeople.setBounds(250, 220, 150, 25);
        numPeople.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(numPeople);

        JLabel lblAcRoom = new JLabel("AC/Non-AC :");
        lblAcRoom.setBounds(30, 260, 150, 25);
        lblAcRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblAcRoom);

        cac = new Choice();
        cac.add("AC Room");
        cac.add("NON-AC Room");
        cac.setBounds(250, 260, 150, 25);
        add(cac);

        JLabel lblfood = new JLabel("Meal Included :");
        lblfood.setBounds(30, 300, 150, 25);
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblfood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250, 300, 150, 25);
        add(cfood);

        JLabel lblcont = new JLabel("Contact :");
        lblcont.setBounds(30, 340, 150, 25);
        lblcont.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblcont);

        labelcont = new JLabel();
        labelcont.setBounds(250, 340, 150, 25);
        add(labelcont);

        JLabel lblid = new JLabel("ID :");
        lblid.setBounds(30, 380, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblid);

        labelID = new JLabel();
        labelID.setBounds(250, 380, 150, 25);
        add(labelID);

        JLabel lblIDnum = new JLabel("Number :");
        lblIDnum.setBounds(30, 420, 150, 25);
        lblIDnum.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblIDnum);

        labelIDnum = new JLabel();
        labelIDnum.setBounds(250, 420, 150, 25);
        add(labelIDnum);

        JLabel tot = new JLabel("Total Prize :");
        tot.setBounds(30, 460, 150, 25);
        tot.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(tot);

        tota = new JLabel();
        tota.setBounds(250, 460, 150, 25);
        add(tota);


        try{
            conn conn = new conn();
            String query = " select * from customer where username = '"+username+"' ";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelcont.setText(rs.getString("contact"));
                labelID.setText(rs.getString("id"));
                labelIDnum.setText(rs.getString("number"));
                }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        CheckPrize = new JButton("Check Prize");
        CheckPrize.setBounds(100, 500, 130, 30);
        CheckPrize.setBackground(Color.DARK_GRAY);
        CheckPrize.setForeground(Color.WHITE);
        CheckPrize.addActionListener(this);
        add(CheckPrize);

        book = new JButton("Book Now");
        book.setBounds(270, 500, 130, 30);
        book.setBackground(Color.DARK_GRAY);
        book.setForeground(Color.WHITE);
        book.addActionListener(this);
        add(book);

        back = new JButton("Go Back");
        back.setBounds(440, 500, 130, 30);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(429, 50, 500, 400);
        add(l10);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == CheckPrize){
            try{
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from hotels where Hname = '"+CHotel.getSelectedItem()+"' ");
                while (rs.next()) {
                    int cost = Integer.parseInt(rs.getString("CostPerHead"));
                    int acroom = Integer.parseInt(rs.getString("AC_cost"));
                    int food = Integer.parseInt(rs.getString("meal_cost"));
                    int nPerson = Integer.parseInt(numPeople.getText());
                    int nDays = Integer.parseInt(numDays.getText());

                    String acSelected = cac.getSelectedItem();
                    String foodSelected = cfood.getSelectedItem();

                    if(nPerson * nDays > 0){
                        int totalCost = 0;
                        totalCost += acSelected.equals("AC Room") ? acroom : 0;
                        totalCost += foodSelected.equals("Yes") ? food : 0;
                        totalCost += cost;
                        totalCost = totalCost * nPerson * nDays;
                        tota.setText("Rs "+ totalCost);
                    }else{
                        JOptionPane.showMessageDialog(null, "Error 404");
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == book){
            try{
                conn c = new conn();
                c.s.executeUpdate("insert into Booked_Hotel_History values ('"+labelusername.getText()+"', '"+CHotel.getSelectedItem()+"', '"+numPeople.getText()+"', '"+numDays.getText()+"', '"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"', '"+labelID.getText()+"', '"+labelIDnum.getText()+"', '"+labelcont.getText()+"', '"+tota.getText()+"') ");

                JOptionPane.showMessageDialog(null, "Hotel Booked Succesfully");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == back){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookHotel("anubhav007");
    }
}
