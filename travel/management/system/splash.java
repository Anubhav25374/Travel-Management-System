package travel.management.system; 
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class splash extends JFrame implements Runnable{                            //class for frame
    Thread thread;                                                                 //thrad initiallization
    splash(){                                                                      //construtor
        /**     here we are give hardcore size and location, lets try dynamicly in main
         * setSize(1200,600);                                                      //set the size of window
         * setLocation(175,150);                                                   //set the windows location on the desktop
        */
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\splash.jpg"));           //it selects the images for storage
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);        //it sets the size of image on frame
        ImageIcon i3 = new ImageIcon(i2);                                            //we cant place i2 in jlabel so put value in i3
        JLabel image = new JLabel(i3);                                               //i3(image) in jlabel,this will put image in frame
        add(image);                                                                  //continuation of jlabel

        setVisible(true);                                                         //it made the image visible on
        thread = new Thread(this);                                                  //creating object of thread
        thread.start();                                                             //this make our thread work like a multi-thead
    }
    
    public void run(){
        try{
            Thread.sleep(5000);                                             //wait for 7 sec
            setVisible(false);                                                   //close the frame
            new login();                                                           //opening the login frame
        }
        catch(Exception e){}
    }

    public static void main(String[] args) {
        splash frame = new splash();                                                //object of the construtor

        //dynamiclly setting values (by hit and try)
        int x = 1;
        for(int i=1;i<=500;x+=7, i+=6) {                                                                                                                     
            frame.setLocation(750 - (x + i)/2, 400 - (i/2));                        //here we set loc dynamiclly
            frame.setSize(x + i, i);                                                //here we set size dynamiclly
            try{ 
                Thread.sleep(10);                                            //thread.sleep is use as a timer
            }catch(Exception e){}
        }
    }
}
