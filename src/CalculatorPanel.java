import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorPanel extends JPanel implements ActionListener, ICalculatorPanel {
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton zero;
    private JButton dot;
    private JButton plus;
    private JButton minus;
    private JButton equals;
    private JButton clear;
    private StatefullCalculator calcEngine;
    private JTextArea prevCommands;
    private JTextArea screen;

    public CalculatorPanel(){
        super();

        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        zero = new JButton("0");
        dot = new JButton(".");
        plus = new JButton("+");
        minus = new JButton("-");
        equals = new JButton("=");
        clear = new JButton("c");
        prevCommands = new JTextArea();
        prevCommands.setEditable(false);
        JScrollPane hist = new JScrollPane(prevCommands);
        hist.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        hist.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        hist.setAutoscrolls(true);

        screen = new JTextArea("0");
        screen.setEditable(false);
        JScrollPane screen2 = new JScrollPane(screen);
        screen2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        screen2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        zero.addActionListener(this);
        dot.addActionListener(this);
        clear.addActionListener(this);
        plus.addActionListener(this);
        minus.addActionListener(this);
        equals.addActionListener(this);


        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTH;
        c.gridx=0;
        c.gridy=0;
        c.gridwidth=4;
        c.insets = new Insets(2,2,2,2);
        c.fill=GridBagConstraints.BOTH;
        add(hist, c);

        c.gridy=1;
        add(screen2, c);

        c.gridy=2;
        c.gridwidth=1;
        add(one, c);
        c.gridx=1;
        add(two, c);
        c.gridx=2;
        add(three, c);
        c.gridx=3;
        add(clear, c);

        c.gridy=3;
        c.gridx=0;
        add(four, c);
        c.gridx=1;
        add(five, c);
        c.gridx=2;
        add(six, c);
        c.gridx=3;
        add(minus, c);

        c.gridy=4;
        c.gridx=0;
        add(seven, c);
        c.gridx=1;
        add(eight, c);
        c.gridx=2;
        add(nine, c);
        c.gridx=3;
        add(plus, c);


        c.gridy=5;
        c.gridx=1;
        add(zero, c);
        c.gridx=2;
        add(dot, c);
        c.gridx=3;
        add(equals, c);



    }
    
    public boolean setCalcEngine(StatefullCalculator calculator){
        this.calcEngine = calculator;
        return true;
    }

    @Override
    public boolean setHistory(String history) {
        prevCommands.setText(history);
        return true;
    }

    @Override
    public String getScreen() {
        return screen.getText();

    }

    @Override
    public boolean setScreen(String screen) {
        this.screen.setText(screen);
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();
        if(calcEngine != null){
            if (clicked == one){
                calcEngine.number(1);
            }else if (clicked == two){
                calcEngine.number(2);
            }else if (clicked == three){
                calcEngine.number(3);
            }else if (clicked == four){
                calcEngine.number(4);
            }else if (clicked == five){
                calcEngine.number(5);
            }else if (clicked == six){
                calcEngine.number(6);
            }else if (clicked == seven){
                calcEngine.number(7);
            }else if (clicked == eight){
                calcEngine.number(8);
            }else if (clicked == nine){
                calcEngine.number(9);
            }else if (clicked == zero) {
                calcEngine.number(0);
            }else if (clicked == dot){
                calcEngine.number(10);



            }else if (clicked == clear){
                calcEngine.clear();
            }else if (clicked == plus){
                calcEngine.operator('+');
            }else if (clicked == minus){
                calcEngine.operator('-');
            }else if (clicked == equals){
                calcEngine.operator('=');
            }

        }
    }

}
