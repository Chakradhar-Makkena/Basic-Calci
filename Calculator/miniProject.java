import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

class Calculator extends JFrame implements ActionListener {
    JTextField disp=new JTextField();
    JButton b[]=new JButton[10];
    JButton p=new JButton("+");
    JButton s=new JButton("-");
    JButton m=new JButton("*");
    JButton d=new JButton("/");
    JButton r=new JButton("%");
    JButton calc=new JButton("=");
    JButton reset=new JButton("RESET");
    Calculator () {
        setTitle("Basic Calculator");
        Image fI = new ImageIcon("Calci.png").getImage();
        setIconImage(fI);
        //setIconImage(new Image(Calculator.class.getResource("Calci.png")));
        setLayout(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        c.fill=GridBagConstraints.BOTH;
        c.weightx=1;
        c.weighty=1;
        c.gridx=0;
        c.gridy=0;
        c.gridwidth=4;
        disp.setFont(new Font("Arial",Font.PLAIN,25));
        add(disp,c);
        c.gridwidth=1;
        c.insets=new Insets(1,1,1,1);

        c.gridx=0;
        c.gridy=1;
        b[1]=new JButton("1");
        b[1].setFont(new Font("Arial",Font.PLAIN,30));
        b[1].setBackground(new Color(102,178,255));
        b[1].addActionListener(this);
        add(b[1],c);

        c.gridx=1;
        c.gridy=1;
        b[2]=new JButton("2");
        b[2].setFont(new Font("Arial",Font.PLAIN,30));
        b[2].setBackground(new Color(102,178,255));
        b[2].addActionListener(this);
        add(b[2],c);

        c.gridx=2;
        c.gridy=1;
        b[3]=new JButton("3");
        b[3].setFont(new Font("Arial",Font.PLAIN,30));
        b[3].setBackground(new Color(102,178,255));
        b[3].addActionListener(this);
        add(b[3],c);

        c.gridx=3;
        c.gridy=1;
        r.setFont(new Font("Courier",Font.BOLD,30));
        r.setBackground(new Color(255,255,0));
        r.addActionListener(this);
        add(r,c);

        c.gridx=0;
        c.gridy=2;
        b[4]=new JButton("4");
        b[4].setFont(new Font("Arial",Font.PLAIN,30));
        b[4].setBackground(new Color(102,178,255));
        b[4].addActionListener(this);
        add(b[4],c);

        c.gridx=1;
        c.gridy=2;
        b[5]=new JButton("5");
        b[5].setFont(new Font("Arial",Font.PLAIN,30));
        b[5].setBackground(new Color(102,178,255));
        b[5].addActionListener(this);
        add(b[5],c);

        c.gridx=2;
        c.gridy=2;
        b[6]=new JButton("6");
        b[6].setFont(new Font("Arial",Font.PLAIN,30));
        b[6].setBackground(new Color(102,178,255));
        b[6].addActionListener(this);
        add(b[6],c);

        c.gridx=3;
        c.gridy=2;
        d.setFont(new Font("Courier",Font.BOLD,30));
        d.setBackground(new Color(255,255,0));
        d.addActionListener(this);
        add(d,c);

        c.gridx=0;
        c.gridy=3;
        b[7]=new JButton("7");
        b[7].setFont(new Font("Arial",Font.PLAIN,30));
        b[7].setBackground(new Color(102,178,255));
        b[7].addActionListener(this);
        add(b[7],c);

        c.gridx=1;
        c.gridy=3;
        b[8]=new JButton("8");
        b[8].setFont(new Font("Arial",Font.PLAIN,30));
        b[8].setBackground(new Color(102,178,255));
        b[8].addActionListener(this);
        add(b[8],c);

        c.gridx=2;
        c.gridy=3;
        b[9]=new JButton("9");
        b[9].setFont(new Font("Arial",Font.PLAIN,30));
        b[9].setBackground(new Color(102,178,255));
        b[9].addActionListener(this);
        add(b[9],c);

        c.gridx=3;
        c.gridy=3;
        p.setFont(new Font("Courier",Font.BOLD,30));
        p.setBackground(new Color(255,255,0));
        p.addActionListener(this);
        add(p,c);

        c.gridx=0;
        c.gridy=4;
        s.setFont(new Font("Courier",Font.BOLD,30));
        s.setBackground(new Color(255,255,0));
        s.addActionListener(this);
        add(s,c);

        c.gridx=1;
        c.gridy=4;
        b[0]=new JButton("0");
        b[0].setFont(new Font("Arial",Font.PLAIN,30));
        b[0].setBackground(new Color(102,178,255));
        b[0].addActionListener(this);
        add(b[0],c);

        c.gridx=2;
        c.gridy=4;
        m.setFont(new Font("Courier",Font.BOLD,30));
        m.setBackground(new Color(255,255,0));
        m.addActionListener(this);
        add(m,c);

        c.gridx=3;
        c.gridy=4;
        calc.setFont(new Font("Courier",Font.BOLD,30));
        calc.setBackground(new Color(255,128,0));
        calc.addActionListener(this);
        add(calc,c);

        c.gridx=0;  c.gridy=5; c.weighty=0;
        c.gridwidth=4; c.fill=GridBagConstraints.HORIZONTAL; //c.ipady=1;
        reset.setFont(new Font("Courier",Font.BOLD,30));
        reset.setBackground(new Color(255,0,0));
        reset.addActionListener(this);
        
        add(reset,c);
        setSize(400,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent e) {
        String exp=disp.getText();

        if (e.getSource()==b[1]) exp+="1";
        if (e.getSource()==b[2]) exp+="2";
        if (e.getSource()==b[3]) exp+="3";
        if (e.getSource()==b[4]) exp+="4";
        if (e.getSource()==b[5]) exp+="5";
        if (e.getSource()==b[6]) exp+="6";
        if (e.getSource()==b[7]) exp+="7";
        if (e.getSource()==b[8]) exp+="8";
        if (e.getSource()==b[9]) exp+="9";
        if (e.getSource()==b[0]) exp+="0";
        if (e.getSource()==p) exp+="+";
        if (e.getSource()==s) exp+="-";
        if (e.getSource()==d) exp+="/";
        if (e.getSource()==m) exp+="*";
        if (e.getSource()==r) exp+="%";
        if (e.getSource()==calc) {
            try {
                exp+="="+InfixEvaluation(exp);
            }
            catch (ArithmeticException ex) {exp="Divide by Zero error";}
        } 
        if (e.getSource()==reset) exp="";

        disp.setText(exp);
    }

    int preci(char c) {
        if (c=='+' || c=='-')
        return 1;

        else if (c=='*' || c=='/' || c=='%')
        return 2;

        else 
        return 0;
    }

    double evaluate(char opr,double opnd1,double opnd2) throws ArithmeticException {
        if (opr=='-')
        return opnd2-opnd1;

        if (opr=='/')
        return opnd2/opnd1;

        if (opr=='+')
        return opnd2+opnd1;

        if (opr=='*')
        return opnd2*opnd1;

        if (opr=='%')
        return opnd2%opnd1;
        
        return 1;
    }

    double InfixEvaluation(String S) throws ArithmeticException {
        Stack<Double> I=new Stack<>();
        Stack<Character> C=new Stack<>();
        C.push('#');
        int i,l=S.length();

        for (i=0;i<l;i++) {
            if (Character.isDigit(S.charAt(i))) {
                double num=0; boolean f=false;
                if ((i-1==0 && S.charAt(i-1)=='-') || (i-2>=0 && S.charAt(i-1)=='-' && Character.isDigit(S.charAt(i-2))==false)) 
                f=true;
                while (i<l && Character.isDigit(S.charAt(i))) {
                    num=num*10+(S.charAt(i)-'0');
                    i++;
                } i--;
                if (f) num*=-1;
                I.push(num);
            }

            else if (preci(S.charAt(i))>preci(C.peek())) {
                if (!((i==0 && S.charAt(i)=='-') || (i-1>=0 && Character.isDigit(S.charAt(i-1))==false && S.charAt(i)=='-')))
                C.push(S.charAt(i));
            }
            

            else if (preci(S.charAt(i))<=preci(C.peek())) {
                if (!(i-1>=0 && Character.isDigit(S.charAt(i-1))==false && S.charAt(i)=='-')) {
                while (preci(S.charAt(i))<=preci(C.peek())) {
                    I.push(evaluate(C.pop(),I.pop(),I.pop()));
                }
                C.push(S.charAt(i)); }
            }
        }

        while (preci(C.peek())!=0) {
            I.push(evaluate(C.pop(),I.pop(),I.pop()));
        }

        return I.pop();
    }
}

public class miniProject {
    public static void main(String args[]) {
        new Calculator();
    }
}