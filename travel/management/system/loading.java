package travel.management.system;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class loading extends JFrame implements Runnable{
    Thread t;

    public void run(){
        try{
            for(int i=0;i<101;i++){
                int max = bar.getMaximum();
                int value = bar.getValue();
                if(value<max){
                    bar.setValue(bar.getValue() + 1);
                }else{
                    Thread.sleep(1000);
                    setVisible(false);
                }
                Thread.sleep(50);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    JProgressBar bar;

    loading(){

        t = new Thread(this); 

        setBounds(500, 150, 600, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Travel Management Application");
        text.setBounds(30, 20, 550, 50);
        text.setFont(new Font("RAILWAY", Font.BOLD, 35));
        text.setBackground(Color.MAGENTA);
        add(text);

        bar = new JProgressBar();
        bar.setBounds(40, 120, 500, 25);
        bar.setStringPainted(true);
        add(bar);

        JLabel load = new JLabel("Loading, Please wait...");
        load.setBounds(400, 150, 300, 15);
        load.setForeground(Color.red);
        load.setFont(new Font("RAILWAY", Font.BOLD, 10));
        add(load);

        JLabel well = new JLabel("Welcome User");
        well.setBounds(200, 250, 300, 25);
        well.setForeground(Color.BLUE);
        well.setFont(new Font("RAILWAY", Font.BOLD, 25));
        add(well);

        t.start();

        setVisible(true);
    }
    public static void main(String[] args) {
        new loading();
    }
}
