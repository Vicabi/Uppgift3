import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
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
    JButton jbx = new JButton();

    JButton shuffleButton = new JButton("Shuffle/New Game");


    List<JButton> buttonList = Arrays.asList(jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb10, jb11, jb12, jb13, jb14, jb15, jbx);


    public Main() {

        add(backpanel);
        backpanel.setLayout(new BorderLayout());
        backpanel.add(jp);
        jp.setLayout(null);
        backpanel.add(shuffleButton, BorderLayout.NORTH);
        shuffleButton.addActionListener(e -> shuffle());
        jbx.setBackground(Color.WHITE);

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

        for (JButton button : buttonList) {
            jp.add(button);
            button.setFont(new Font("Impact", Font.PLAIN,16));
            button.addActionListener(this);
        }

        setSize(215, 265);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    public void shuffle() {

        List<Point> lista = new ArrayList<>();

        for (Component i : buttonList) {
            lista.add(i.getLocation());
        }

        Collections.shuffle(lista);

        int j = 0;
        for (Component i : buttonList) {
            i.setLocation(lista.get(j));
            j++;
        }
        if (!isSolvable()){
            JOptionPane.showMessageDialog(null, "Går ej att lösa! Vänligen starta om spelet");
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
            isWin();
        }
        if (jp.getComponentAt(temp1 - 50, temp2) == jbx) {
            jbx.setLocation(jbx.getX() + 50, jbx.getY());
            tempButton.setLocation(temp1 - 50, temp2);
            isWin();
        }
        if (jp.getComponentAt(temp1, temp2 + 50) == jbx) {
            jbx.setLocation(jbx.getX(), jbx.getY() - 50);
            tempButton.setLocation(temp1, temp2 + 50);
            isWin();
        }
        if (jp.getComponentAt(temp1, temp2 - 50) == jbx) {
            jbx.setLocation(jbx.getX(), jbx.getY() + 50);
            tempButton.setLocation(temp1, temp2 - 50);
            isWin();

        }
    }

    public void isWin() {

        if (jp.getComponentAt(0, 0) == jb1 &&
                jp.getComponentAt(50, 0) == jb2 &&
                jp.getComponentAt(100, 0) == jb3 &&
                jp.getComponentAt(150, 0) == jb4 &&
                jp.getComponentAt(0, 50) == jb5 &&
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
            JOptionPane.showMessageDialog(null, "Grattis, du vann!");
        }
    }

    //https://ssaurel.medium.com/developing-a-15-puzzle-game-of-fifteen-in-java-dfe1359cc6e3
    private boolean isSolvable() {

        List <JButton> temp = new ArrayList<>();


        int x = 0;
        int y = 0;
        for (int i = 0; i < 15; i++) {
            temp.add( (JButton) jp.getComponentAt(x, y));
            x = x +50;
            if (x == 200) {
                x = 0;
                y = y + 50;
            }
        }
        temp.remove(jbx);

        int countInversions = 0;
        int[] buttons = new int[14];

        for (int i = 0; i < 14; i++) {
                buttons [i] = Integer.parseInt(temp.get(i).getText());
        }
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < i; j++) {
                if (buttons[j] > buttons[i])
                    countInversions++;
            }
        }
        return countInversions % 2 == 0;
    }


    public static void main(String[] args) {
        Main main = new Main();
    }

}