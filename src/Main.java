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

        jp.add(jb1); jp.add(jb2); jp.add(jb3); jp.add(jb4);
        jp.add(jb5); jp.add(jb6); jp.add(jb7); jp.add(jb8);
        jp.add(jb9); jp.add(jb10); jp.add(jb11); jp.add(jb12);
        jp.add(jb13); jp.add(jb14); jp.add(jb15); jp.add(jbx);


        jp.setLayout(new GridLayout(4, 4));

        jb15.addActionListener(this);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jb15)
            


    }



    public static void main(String[] args) {Main main = new Main();}

}