import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main extends JFrame implements ActionListener {

    JPanel jp = new JPanel();

    JPanel backpanel = new JPanel();
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

    JButton shuffleButton = new JButton("Shuffle");


    public Main () {

        this.add(jp);
        jp.setLayout(null);

        add(backpanel);
        backpanel.setLayout(new BorderLayout());
        backpanel.add(jp);
        backpanel.add(shuffleButton, BorderLayout.NORTH);
        shuffleButton.addActionListener(this);

        jb1.setBounds(0, 0, 50, 50);
        jb2.setBounds(50, 0, 50, 50);
        jb3.setBounds(100, 0, 50, 50);
        jb4.setBounds(150, 0, 50, 50);
        jb5.setBounds(0, 50, 50, 50);
        jb6.setBounds(50, 50, 50, 50);
        jb7.setBounds(100, 50, 50, 50);
        jb8.setBounds(150, 50, 50, 50);
        jb9.setBounds(0, 100, 50, 50);
        jb10.setBounds(50, 100, 50, 50);
        jb11.setBounds(100, 100, 50, 50);
        jb12.setBounds(150, 100, 50, 50);
        jb13.setBounds(0, 150, 50, 50);
        jb14.setBounds(50, 150, 50, 50);
        jb15.setBounds(150, 150, 50, 50);
        jbx.setBounds(100, 150, 50, 50);

        jp.add(jb1);
        jp.add(jb2);
        jp.add(jb3);
        jp.add(jb4);
        jp.add(jb5);
        jp.add(jb6);
        jp.add(jb7);
        jp.add(jb8);
        jp.add(jb9);
        jp.add(jb10);
        jp.add(jb11);
        jp.add(jb12);
        jp.add(jb13);
        jp.add(jb14);
        jp.add(jb15);
        jp.add(jbx);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jb6.addActionListener(this);
        jb7.addActionListener(this);
        jb8.addActionListener(this);
        jb9.addActionListener(this);
        jb10.addActionListener(this);
        jb11.addActionListener(this);
        jb12.addActionListener(this);
        jb13.addActionListener(this);
        jb14.addActionListener(this);
        jb15.addActionListener(this);
        jbx.addActionListener(this);
        shuffleButton.addActionListener(this);

        setSize(300,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JButton tempButton = (JButton) e.getSource();

        int temp1 = tempButton.getX();
        int temp2 = tempButton.getY();

        if (jp.getComponentAt(temp1+50, temp2) == jbx) {
            jbx.setLocation(jbx.getX()-50, jbx.getY());
            tempButton.setLocation(temp1+50, temp2);
        }
        if (jp.getComponentAt(temp1-50, temp2) == jbx) {
            jbx.setLocation(jbx.getX()+50, jbx.getY());
            tempButton.setLocation(temp1-50, temp2);
        }
        if (jp.getComponentAt(temp1, temp2+50) == jbx) {
            jbx.setLocation(jbx.getX(), jbx.getY()-50);
            tempButton.setLocation(temp1, temp2+50);
        }
        if (jp.getComponentAt(temp1, temp2-50) == jbx) {
            jbx.setLocation(jbx.getX(), jbx.getY()+50);
            tempButton.setLocation(temp1, temp2-50);
        }

        if (e.getSource() == shuffleButton) {
            this.shuffle(jp);
        }


        this.isWin();

    }

    public void isWin () {

        if (jp.getComponentAt(0,0) == jb1 &&
            jp.getComponentAt(50,0) == jb2 &&
            jp.getComponentAt(100, 0) == jb3 &&
            jp.getComponentAt(150, 0) == jb4 &&
            jp.getComponentAt(0,50) == jb5 &&
            jp.getComponentAt(50, 50) == jb6 &&
            jp.getComponentAt(100, 50) == jb7 &&
            jp.getComponentAt(150, 50) == jb8 &&
            jp.getComponentAt(0, 100) == jb9 &&
            jp.getComponentAt(50, 100) == jb10 &&
            jp.getComponentAt(100, 100) == jb11 &&
            jp.getComponentAt(150, 100) == jb12 &&
            jp.getComponentAt(0, 150) == jb13 &&
            jp.getComponentAt(50, 150) == jb14 &&
            jp.getComponentAt(100, 150) == jb15 &&
            jp.getComponentAt(150, 150) == jbx) {
            JOptionPane.showMessageDialog(null, "Du har vunnit");
        }
    }

    public void shuffle (JPanel jp) {

        Component buttonList[] = jp.getComponents();
        List <Point> lista = new ArrayList<>();

        for (Component i : buttonList) {
            lista.add(i.getLocation());
        }

        Collections.shuffle(lista);

        int j = 0;
        for (Component i : buttonList){
            i.setLocation(lista.get(j));
            j++;
        }


    }



    public static void main(String[] args) {Main main = new Main();}

}