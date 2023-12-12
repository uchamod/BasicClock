package basicclock;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat; //we can set date and time formt
import java.util.Calendar;         //we can get current date and time
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class clock extends JFrame {

    // Calendar cal;
    SimpleDateFormat timeformat;
    String t;
    JLabel Tlbl;

    SimpleDateFormat dayformat;
    String d;
    JLabel dlbl;

    SimpleDateFormat dateformat;
    String df;
    JLabel dflbl;

    clock() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Date & Time");
        this.setLayout(new FlowLayout()); //set flow layout
        this.setSize(400, 250);
        this.setResizable(false);
        this.setBackground(Color.black);

        timeformat = new SimpleDateFormat("hh:mm:ss a"); //set time format
        Tlbl = new JLabel();
        Tlbl.setFont(new Font("Verdana", Font.PLAIN, 60));//set font family,type and size for jlable,we can use it any kind of lable
        Tlbl.setBackground(Color.black);
        Tlbl.setForeground(Color.GREEN);
        Tlbl.setOpaque(true);
        this.add(Tlbl);

        dayformat = new SimpleDateFormat("EEEE"); //set day format
        dlbl = new JLabel();
        dlbl.setFont(new Font("Comic Sans MS", Font.BOLD, 45));
        //dlbl.setForeground(Color.GREEN);
        // dlbl.setBackground(Color.black);
        dlbl.setOpaque(true);
        this.add(dlbl);

        dateformat = new SimpleDateFormat("MMMMM dd, yyyy"); //set date format
        dflbl = new JLabel();
        dflbl.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        //dflbl.setForeground(Color.GREEN);
        //dflbl.setBackground(Color.black);
        dflbl.setOpaque(true);
        this.add(dflbl);
        time();

    }

    public void time() {
        while (true) {
            t = timeformat.format(Calendar.getInstance().getTime()); //get current time
            Tlbl.setText(t);                                         //set current time

            d = dayformat.format(Calendar.getInstance().getTime()); //get current day
            dlbl.setText(d);                                        //set current day

            df = dateformat.format(Calendar.getInstance().getTime()); //get current date
            dflbl.setText(df);                                        //set current date
            try {
                Thread.sleep(1000); //set time delay
            } catch (InterruptedException ex) {
                Logger.getLogger(clock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
