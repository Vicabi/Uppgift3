import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    JPanel jp = new JPanel();
    JButton jb1 = new JButton("1");
    JButton jb2 = new JButton("2");
    JButton jb3 = new JButton("3");
    JButton jb4 = new JButton("4");
    JButton jb5 = new JButton("5");
    JButton jb6 = new JButton("6");
    JButton jb7 = new JButton("7");
    JButton jb8 = new JButton("8");
    JButton jb9 = new JButton("9");
    JButton jb10 = new JButton("10");
    JButton jb11 = new JButton("11");
    JButton jb12 = new JButton("12");
    JButton jb13 = new JButton("13");
    JButton jb14 = new JButton("14");
    JButton jb15 = new JButton("15");
    JButton jbx = new JButton("X");


    public Main () {

        this.add(jp);
        jp.setLayout(null);

        jb1.setBounds(0,0,50,50);
        jb2.setBounds(50,0,50, 50);
        jb3.setBounds(100,0,50,50);
        jb4.setBounds(150,0,50,50);
        jb5.setBounds(0,50,50,50);
        jb6.setBounds(50,50,50,50);
        jb7.setBounds(100,50,50,50);
        jbx.setBounds(150,50,50,50);

        jp.add(jb1);
        jp.add(jb2);
        jp.add(jb3);
        jp.add(jb4);
        jp.add(jb5);
        jp.add(jb6);
        jp.add(jb7);
        jp.add(jbx);

        jb7.addActionListener(this);

        setSize(300,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JButton tempButton = new JButton();

        tempButton = (JButton) e.getSource();

        int temp1 = tempButton.getX();
        int temp2 = tempButton.getY();

        if (jp.getComponentAt(temp1+50, temp2) == jbx) {
            jbx.setLocation(jbx.getX()-50, jbx.getY());
            jb7.setLocation(temp1+50, temp2);
        }
        if (jp.getComponentAt(temp1-50, temp2) == jbx) {
            jbx.setLocation(jbx.getX()+50, jbx.getY());
            jb7.setLocation(temp1-50, temp2);
        }



    }



    public static void main(String[] args) {Main main = new Main();}

}