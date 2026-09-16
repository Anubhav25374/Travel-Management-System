package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateDetails extends JFrame implements ActionListener{

    JLabel labelUsername, labelname;
    JComboBox comboid;   
    TextField idnum, tfnationality, tfaddress, tfcontact, tfmail, tfid, tfgender;                                            //Id dropdown choice
    JRadioButton male, female;
    JButton add, back;

    UpdateDetails(String username){
        setBounds(425, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("UPDATE YOUR DETAILS");
        text.setBounds(50, 0, 300, 25);
        text.setFont(new Font("Tahoma", Font.PLAIN, 25));
        add(text);
        
        JLabel lblusername = new JLabel("Username : ");
        lblusername.setBounds(30, 25, 150, 25);
        add(lblusername);

        labelUsername = new JLabel();
        labelUsername.setBounds(220, 25, 150, 25);
        add(labelUsername);

        JLabel Id = new JLabel("ID Proof : ");
        Id.setBounds(30, 75, 150, 25);
        add(Id);

        tfid = new TextField();
        tfid.setBounds(220, 75, 150, 25);
        add(tfid);

        JLabel Idnumber = new JLabel("ID Number : ");
        Idnumber.setBounds(30, 125, 150, 25);
        add(Idnumber);

        idnum = new TextField();
        idnum.setBounds(220, 125, 150, 25);
        add(idnum);

        JLabel lblname = new JLabel("Name : ");
        lblname.setBounds(30, 175, 150, 25);
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(220, 175, 150, 25);
        add(labelname);

        JLabel gender = new JLabel("Gender : ");
        gender.setBounds(30, 225, 150, 25);
        add(gender);

        tfgender = new TextField();
        tfgender.setBounds(220, 225, 150, 25);
        add(tfgender);

        ButtonGroup bg = new ButtonGroup();                                  // with this only 1 radion button can me selected
        bg.add(male);
        bg.add(female);

        JLabel country = new JLabel("Nationality : ");
        country.setBounds(30, 275, 150, 25);
        add(country);

        tfnationality = new TextField();
        tfnationality.setBounds(220, 275, 150, 25);
        add(tfnationality);

        JLabel address = new JLabel("Address : ");
        address.setBounds(30, 325, 150, 25);
        add(address);

        tfaddress = new TextField();
        tfaddress.setBounds(220, 325, 150, 25);
        add(tfaddress);

        JLabel contact = new JLabel("Contact no. : ");
        contact.setBounds(30, 375, 150, 25);
        add(contact);

        tfcontact = new TextField();
        tfcontact.setBounds(220, 375, 150, 25);
        add(tfcontact);

        JLabel mail = new JLabel("Email ID : ");
        mail.setBounds(30, 427, 150, 25);
        add(mail);

        tfmail = new TextField();
        tfmail.setBounds(220, 425, 150, 25);
        add(tfmail);

        add = new JButton("Update");
        add.setBackground(Color.DARK_GRAY);
        add.setForeground(Color.WHITE);
        add.setBounds(70, 470, 100, 30);
        add(add);
        add.addActionListener(this);
        back = new JButton("Back");
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 470, 100, 30);
        add(back);
        back.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 100, 450, 300);
        add(image);


        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"' ");
            while (rs.next()) {
                labelUsername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                idnum.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfnationality.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfcontact.setText(rs.getString("contact"));
                tfmail.setText(rs.getString("mail"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String username = labelUsername.getText();
            String id = tfid.getText();
            String number = idnum.getText();
            String name = labelname.getText();
            String gender = tfgender.getText();
            String country = tfnationality.getText();
            String address = tfaddress.getText();
            String contact = tfcontact.getText();
            String mail = tfmail.getText();

            try{
                conn c = new conn();
                String query = "update customer set username = '"+username+"', id = '"+id+"', number = '"+number+"', name = '"+name+"', gender = '"+gender+"', country = '"+country+"', address = '"+address+"', contact = '"+contact+"', mail = '"+mail+"'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer details updated");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new UpdateDetails("anubhav007");
    }
}
