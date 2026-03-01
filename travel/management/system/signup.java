package travel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class signup extends JFrame implements ActionListener{
    JButton create, back;                                                                   //globle declaration of field/buttons/choice
    JTextField f_username, f_name, f_password, f_answer;
    Choice ques;
    signup(){
        //setSize(800, 400);
        //setLocation(375, 175);
        setBounds(375, 175, 900, 400);                                       //short-hand for setsize and location
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JPanel p1 = new JPanel();                                                               //creating a panel p1 in window
        p1.setBackground(new Color(131,193,233));                                       //setting bg color in rgb format
        p1.setBounds(0,0,500,400);                                          //setting the size of panel
        p1.setLayout(null);                                                               //used to assign a Layout Manager
        add(p1);

        JLabel label1 = new JLabel("Username");
        label1.setFont(new Font("Tahoma",Font.BOLD, 14));                           //sets the font style , font type and font size of text, optional
        label1.setBounds(50, 20, 125, 25);
        p1.add(label1);

        f_username = new JTextField();                                              
        f_username.setBounds(180, 20, 250, 25);                              
        f_username.setBorder(null);                                                    
        p1.add(f_username);

        JLabel label2 = new JLabel("Name");
        label2.setFont(new Font("Tahoma",Font.BOLD, 14));                  
        label2.setBounds(50, 60, 125, 25);
        p1.add(label2);

        f_name = new JTextField();                                              
        f_name.setBounds(180, 60, 250, 25);                              
        f_name.setBorder(null);                                                    
        p1.add(f_name);

        JLabel label3 = new JLabel("Password");
        label3.setFont(new Font("Tahoma",Font.BOLD, 14));                 
        label3.setBounds(50, 100, 125, 25);
        p1.add(label3);

        f_password = new JTextField();                                              
        f_password.setBounds(180, 100, 250, 25);                             
        f_password.setBorder(null);                                                    
        p1.add(f_password);

        JLabel label4 = new JLabel("Security Question");
        label4.setFont(new Font("Tahoma",Font.BOLD, 14));                  
        label4.setBounds(50, 140, 125, 25);
        p1.add(label4);

        ques = new Choice();                                                                         //it creats a choice bar in the frame
        ques.add("None");                                                                      //listing the choices
        ques.add("what is the real name of Darth Vader");
        ques.add("what is the real name of superman");
        ques.add("how many horcruxes does voldemort created");
        ques.add("In The Matrix,Neo take the blue pill or red pill");
        ques.setBounds(180, 140, 250, 25);
        p1.add(ques);

        JLabel label5 = new JLabel("Answer");
        label5.setFont(new Font("Tahoma",Font.BOLD, 14));               
        label5.setBounds(50, 180, 125, 30);
        p1.add(label5);

        f_answer = new JTextField();                                              
        f_answer.setBounds(180, 180, 250, 25);                             
        f_answer.setBorder(null);
        p1.add(f_answer);

        create = new JButton("Create");                                         //Button
        create.setBounds(100, 220, 100, 30);
        create.setFont(new Font("Tahoma", Font.BOLD, 14));
        create.setBackground(Color.white);
        create.setForeground(new Color(133, 193, 233));
        create.setBorder(null);
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");                                            //Button
        back.setBounds(300, 220, 100, 30);
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setBackground(Color.white);
        back.setForeground(new Color(133, 193, 233));
        back.setBorder(null);
        back.addActionListener(this);
        p1.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 50, 250, 250);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){                               //overwrite the signin class with eventlistner
        if(ae.getSource() == create){                                          //checking condition when create button is clicked
            String username = f_username.getText();                            //pulling data out of the fields after clicking create           
            String fname = f_name.getText();                                                            //     
            String password = f_password.getText();                                                    //
            String question = ques.getSelectedItem();                                                  //
            String answer = f_answer.getText();                                                        //

            String query = "INSERT INTO accounts values('"+username+"', '"+fname+"', '"+password+"', '"+question+"', '"+answer+"')"; //putting_data_into_database

            try{
                conn c = new conn();                                     //calling connection
                c.s.executeUpdate(query);                                //DDL command to put data in sql

                JOptionPane.showMessageDialog(null, "Account created succesfully"); //an alert panel show
                setVisible(false);
                new login();
            }catch(Exception e){
                e.printStackTrace();
            }

                                                     

        }else if(ae.getSource() == back){                                      //checking condition when back button is clicked
            setVisible(false);                                              //frame close
            new login();                                                      //login frame opens
        } 

    }
    public static void main(String[] args) {
        new signup();
    }
}
