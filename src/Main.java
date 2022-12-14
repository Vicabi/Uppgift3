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

        //placerar ut alla knappar
        int x = 0;
        int y = 0;
        for (JButton button : buttonList) {
            button.setBounds(x, y, 50, 50);
            x = x +50;
            if (x == 200) {
                x = 0;
                y = y + 50;
            }
        }

        for (JButton button : buttonList) { // lägger till knapparna i panel och lägger till actionListners
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

        for (Component i : buttonList) { // lägger till en lista av postioner
            lista.add(i.getLocation());
        }

        Collections.shuffle(lista);

        int j = 0;
        for (Component i : buttonList) { //sätter nya positioner baserat på hur de var omkastade i listan lista
            i.setLocation(lista.get(j));
            j++;
        }
        if (!isSolvable()){ // kollar om positionen går att lösa annars shufflar den tills det går
            //JOptionPane.showMessageDialog(null, "Går ej att lösa! Vänligen starta om spelet");
            shuffle();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JButton tempButton = (JButton) e.getSource();

        int temp1 = tempButton.getX();
        int temp2 = tempButton.getY();

        if (jp.getComponentAt(temp1 + 50, temp2) == jbx) { //kollar om den x är till höger if(true) byter plats
            jbx.setLocation(jbx.getX() - 50, jbx.getY());
            tempButton.setLocation(temp1 + 50, temp2);
            isWin();
        }
        if (jp.getComponentAt(temp1 - 50, temp2) == jbx) {  //kollar om den x är till vänster if(true) byter plats
            jbx.setLocation(jbx.getX() + 50, jbx.getY());
            tempButton.setLocation(temp1 - 50, temp2);
            isWin();
        }
        if (jp.getComponentAt(temp1, temp2 + 50) == jbx) {  //kollar om den x är till ner if(true) byter plats
            jbx.setLocation(jbx.getX(), jbx.getY() - 50);
            tempButton.setLocation(temp1, temp2 + 50);
            isWin();
        }
        if (jp.getComponentAt(temp1, temp2 - 50) == jbx) {  //kollar om den x är till upp if(true) byter plats
            jbx.setLocation(jbx.getX(), jbx.getY() + 50);
            tempButton.setLocation(temp1, temp2 - 50);
            isWin();

        }
    }

    public void isWin() { // kollar att varje knapp är i den position den ska vara för att vinna

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
    private boolean isSolvable() {  // tog från länken ovan och modifierade för att fungera i vårt program

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