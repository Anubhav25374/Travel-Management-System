package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{

    JLabel labelUsername, labelname;
    JComboBox comboid;   
    TextField idnum, tfnationality, tfaddress, tfcontact, tfmail;                                            //Id dropdown choice
    JRadioButton male, female;
    JButton add, back;

    AddCustomer(String username){
        setBounds(375, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblusername = new JLabel("Username : ");
        lblusername.setBounds(30, 25, 150, 25);
        add(lblusername);

        labelUsername = new JLabel();
        labelUsername.setBounds(220, 25, 150, 25);
        add(labelUsername);

        JLabel Id = new JLabel("ID Proof : ");
        Id.setBounds(30, 75, 150, 25);
        add(Id);

        comboid = new JComboBox(new String[] {"Passport", "Aadhar", "PAN", "Driving licence"});
        comboid.setBounds(220, 75, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

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

        male = new JRadioButton("Male");
        male.setBounds(220, 225, 75, 25);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(300, 225, 75, 25);
        female.setBackground(Color.WHITE);
        add(female);

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

        add = new JButton("Add");
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

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);


        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from accounts where username = '"+username+"' ");
            while (rs.next()) {
                labelUsername.setText(rs.getString("username"));
                labelname.setText(rs.getString("fname"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String username = labelUsername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = idnum.getText();
            String name = labelname.getText();
            String gender = null;
            if(male.isSelected()){
                gender = "male";
            }else{
                gender = "female";
            }
            String country = tfnationality.getText();
            String address = tfaddress.getText();
            String contact = tfcontact.getText();
            String mail = tfmail.getText();

            try{
                conn c = new conn();
                String query = "insert into customer values ('"+username+"', '"+id+"', '"+number+"',  '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+contact+"', '"+mail+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer details added");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddCustomer("");
    }
}
