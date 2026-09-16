package travel.management.system;
import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame{
    CheckPackage(){
        setBounds(375, 175, 900, 600);

        String[] Package1 = {"GOLDEN PACKAGE", "6 Days and 7 Nights", "Airport Pickup Cab", "City Tour", "Luxury AC room with City view", "Experienced Guide", "Buffet", "12000/-", "package1.jpg"};
        String[] Package2 = {"SILVER PACKAGE", "3 Days and 4 Nights", "Airport Pickup Cab", "City Tour", "Luxury AC room","Buffet","", "8000/-", "package2.jpg"};
        String[] Package3 = {"BRONZE PACKAGE", "1 Days and 2 Nights", "AC room","Buffet", "24 hours Assistence","","", "4000/-", "package3.jpg"};
        
        JTabbedPane tab = new JTabbedPane();

        JPanel p1 = createPackage(Package1);
        tab.addTab("package 1", null, p1);

        JPanel p2 = createPackage(Package2);
        tab.addTab("package 2", null, p2);

        JPanel p3 = createPackage(Package3);
        tab.addTab("package 3", null, p3);

        add(tab);

        setVisible(true);
    }

    public JPanel createPackage(String[] pack){
        JPanel p1 = new JPanel();
        p1.setBackground(Color.WHITE);
        p1.setLayout(null);
        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(30, 30, 300, 30);
        l1.setForeground(new Color(0xCFB53B));
        l1.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(l1);

        JLabel l2 = new JLabel(pack[1]);
        l2.setBounds(30, 80, 300, 30);
        l2.setForeground(new Color(207, 181, 59));
        l2.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l2);

        JLabel l3 = new JLabel(pack[2]);
        l3.setBounds(30, 130, 300, 30);
        l3.setForeground(new Color(207, 181, 59));
        l3.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l3);

        JLabel l4 = new JLabel(pack[3]);
        l4.setBounds(30, 180, 300, 30);
        l4.setForeground(new Color(207, 181, 59));
        l4.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l4);

        JLabel l5 = new JLabel(pack[4]);
        l5.setBounds(30, 230, 300, 30);
        l5.setForeground(new Color(207, 181, 59));
        l5.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l5);

        JLabel l6 = new JLabel(pack[5]);
        l6.setBounds(30, 280, 300, 30);
        l6.setForeground(new Color(207, 181, 59));
        l6.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l6);

        JLabel l7 = new JLabel(pack[6]);
        l7.setBounds(30, 330, 300, 30);
        l7.setForeground(new Color(207, 181, 59));
        l7.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l7);

        JLabel l8 = new JLabel("Book Now Just at");
        l8.setBounds(70, 400, 300, 40);
        l8.setForeground(Color.BLACK);
        l8.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(l8);

        JLabel l9 = new JLabel(pack[7]);
        l9.setBounds(400, 400, 300, 40);
        l9.setForeground(new Color(207, 181, 59));
        l9.setFont(new Font("Tahoma", Font.BOLD, 40));
        p1.add(l9);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[8]));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(350, 50, 500, 300);
        p1.add(l10);

        return p1;
    }
    public static void main(String[] args) {
        new CheckPackage();
    }
}
