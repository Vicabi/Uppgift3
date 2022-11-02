import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    List<JButton> buttonList = new ArrayList<>();


    public Main() {

        add(backpanel);
        backpanel.setLayout(new BorderLayout());
        backpanel.add(jp);
        jp.setLayout(null);
        backpanel.add(shuffleButton, BorderLayout.NORTH);
        shuffleButton.addActionListener(this);

        jb1.setBounds(0, 0, 50, 50);
        buttonList.add(jb1);
        jb2.setBounds(50, 0, 50, 50);
        buttonList.add(jb2);
        jb3.setBounds(100, 0, 50, 50);
        buttonList.add(jb3);
        jb4.setBounds(150, 0, 50, 50);
        buttonList.add(jb4);
        jb5.setBounds(0, 50, 50, 50);
        buttonList.add(jb5);
        jb6.setBounds(50, 50, 50, 50);
        buttonList.add(jb6);
        jb7.setBounds(100, 50, 50, 50);
        buttonList.add(jb7);
        jb8.setBounds(150, 50, 50, 50);
        buttonList.add(jb8);
        jb9.setBounds(0, 100, 50, 50);
        buttonList.add(jb9);
        jb10.setBounds(50, 100, 50, 50);
        buttonList.add(jb10);
        jb11.setBounds(100, 100, 50, 50);
        buttonList.add(jb11);
        jb12.setBounds(150, 100, 50, 50);
        buttonList.add(jb12);
        jb13.setBounds(0, 150, 50, 50);
        buttonList.add(jb13);
        jb14.setBounds(50, 150, 50, 50);
        buttonList.add(jb14);
        jb15.setBounds(100, 150, 50, 50);
        buttonList.add(jb15);
        jbx.setBounds(150, 150, 50, 50);
        buttonList.add(jbx);


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


        setSize(300, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    public void shuffleButtons(List<JButton> buttonList) {
        int a0Counter = 0;
        int a50Counter = 0;
        int a100Counter = 0;
        int a150Counter = 0;
        int b0Counter = 0;
        int b50Counter = 0;
        int b100Counter = 0;
        int b150Counter = 0;
        int a = 0;
        int b = 0;
        for (JButton element : buttonList) {
            Random random = new Random();
             a = random.nextInt(4);
             b = random.nextInt(4);
             if (a == 0 && b == 0){
                 a=0;
                 b=0;
                 break;
             }
             if (a == 1 && b == 1){
                 a=50;
                 b=50;
                 break;
             }
             if (a == 2 && b == 2){
                 a = 100;
                 b= 100;
                 break;
            }
            if (a == 3 && b == 3){
                a = 150;
                b= 150;
                break;
            }
            if (a == 1) {
                a = 50;
                a50Counter++;
                if (a50Counter == 4){break;}
            } else if (a == 2) {
                a = 100;
                a100Counter++;
                if (a100Counter == 4){break;}
            } else if (a == 3) {
                a = 150;
                a150Counter++;
                if (a150Counter == 4){break;}
            } else if (a == 0){
                a = 0;
                a0Counter++;
                if (a0Counter == 4){break;}
            }
            if (b == 1){
                b = 50;
                b50Counter++;
                if (b50Counter == 4){break;}
            } else if (b == 2) {
                b = 100;
                b100Counter++;
                if (b100Counter == 4){break;}
            } else if (b == 3) {
                b = 150;
                b150Counter++;
                if (b150Counter == 4){break;}
            } else if (b == 0) {
                b = 0;
                b0Counter++;
                if (b0Counter == 4){break;}
            }
            element.setBounds(a, b, 50, 50);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JButton tempButton = (JButton) e.getSource();

        int temp1 = tempButton.getX();
        int temp2 = tempButton.getY();

        if (jp.getComponentAt(temp1 + 50, temp2) == jbx) {
            jbx.setLocation(jbx.getX() - 50, jbx.getY());
            tempButton.setLocation(temp1 + 50, temp2);
        }
        if (jp.getComponentAt(temp1 - 50, temp2) == jbx) {
            jbx.setLocation(jbx.getX() + 50, jbx.getY());
            tempButton.setLocation(temp1 - 50, temp2);
        }
        if (jp.getComponentAt(temp1, temp2 + 50) == jbx) {
            jbx.setLocation(jbx.getX(), jbx.getY() - 50);
            tempButton.setLocation(temp1, temp2 + 50);
        }
        if (jp.getComponentAt(temp1, temp2 - 50) == jbx) {
            jbx.setLocation(jbx.getX(), jbx.getY() + 50);
            tempButton.setLocation(temp1, temp2 - 50);
        }
        if (tempButton == shuffleButton) {
            shuffleButtons(buttonList);
        }


    }


    public static void main(String[] args) {
        Main main = new Main();
    }

}