package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class login extends JFrame implements ActionListener{

    JButton login, signin, password;
    JTextField f_username, f_password;

    login(){
        setSize(800,400);
        setLocation(375, 175);
        setLayout(null);
        getContentPane().setBackground(Color.white);                                            //getContent selects the whole frame to add a property


        //panel 1 = p1
        JPanel p1 = new JPanel();                                                               //creating a panel p1 in window
        //p1.setBackground(Color.CYAN);
        p1.setBackground(new Color(131,193,233));                                        //setting bg color in rgb format
        p1.setBounds(0,0,400,400);                                           //setting the size of panel
        p1.setLayout(null);                                                                //used to assign a Layout Manager
        add(p1);                                                                               //used to insert components into a container

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,120,200,200);
        p1.add(image);

        //panel 2 = p2
        JPanel p2 = new JPanel();
        p2.setLayout(null);                                                                //used to assign a Layout Manager
        p2.setBounds(400,10,400,380);                                       //setting the size of panel                                              
        add(p2);

        JLabel lblusername = new JLabel("Username");                                      //main use of JLabel is to add text on the window
        lblusername.setBounds(60, 20, 100, 25);                             //it will fix the location of that text in the panel
        lblusername.setFont(new Font("SAN_SERIR",Font.PLAIN, 15));                  //sets the font style , font type and font size of text, optional
        p2.add(lblusername);

        f_username = new JTextField();                                              //JField is use to add a input bar(field) onto the panel
        f_username.setBounds(60, 50, 250, 25);                              //it will fix the location of that input field in the panel
        f_username.setBorder(null);                                                    //it removes the border of the input field,  optional
        p2.add(f_username);

        JLabel lblpassword = new JLabel("Password");                                    
        lblpassword.setBounds(60, 95, 100, 25);                             
        lblpassword.setFont(new Font("SAN_SERIR",Font.PLAIN, 15));                 
        p2.add(lblpassword);

        f_password = new JTextField();
        f_password.setBounds(60, 120, 250, 25);
        f_password.setBorder(null);
        p2.add(f_password);


        login = new JButton("Login");                                            //JButton is use to created a button
        login.setBounds(60, 180, 100, 25);                                 //it will fix the location of that button in the panel
        login.setBackground(new Color(131,193,233));                                                      //it sets the color of button
        login.setForeground(Color.black); 
        login.setBorder(null);                                                    //it sets the color of the text in the button
        login.addActionListener(this);
        p2.add(login);

        signin = new JButton("Signin");                                            //JButton is use to created a button
        signin.setBounds(210, 180, 100, 25);                                 //it will fix the location of that button in the panel
        signin.setBackground(new Color(131,193,233));                                                      //it sets the color of button
        signin.setForeground(Color.black); 
        signin.setBorder(null);                                                    //it sets the color of the text in the button
        signin.addActionListener(this);
        p2.add(signin);

        password = new JButton("Forgot Password");                                            //JButton is use to created a button
        password.setBounds(60, 220, 250, 25);                                 //it will fix the location of that button in the panel
        password.setBackground(new Color(131,193,233));                                                      //it sets the color of button
        password.setForeground(Color.black); 
        password.setBorder(null);                                                    //it sets the color of the text in the button
        password.addActionListener(this);
        p2.add(password);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            try{
                String username = f_username.getText();
                String pass = f_password.getText();

                String query = "select * from accounts where username = '"+username+"' and password = '"+pass+"' ";
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new loading();
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect input ");
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == signin){
            setVisible(false);
            new signup();

        }else{
            setVisible(false);
            new ForgotPassword();
        }
    }


    public static void main(String[] args){
        new login(); 
    }
}
