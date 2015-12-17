import javax.swing.*;
import java.awt.*;//NEW STUFF!
import java.awt.event.*;

public class TempConversionWindow extends JFrame implements ActionListener{
    private Container pane;
    private JLabel j;
    private JTextField t;

    public TempConversionWindow() {
         this.setTitle("Temp Converter");
         this.setSize(600,400);
         this.setLocation(100,100);
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);

         pane = this.getContentPane();
         pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

         JButton b = new JButton("Convert to Fahrenheit");
         b.addActionListener(this);
         b.setActionCommand("CtoF");
         JButton b2 = new JButton("Convert to Celsius");
         b2.addActionListener(this);
         b2.setActionCommand("FtoC");


         t = new JTextField(10);

         j = new JLabel("");
         pane.add(t);
         pane.add(b);
         pane.add(b2);
         pane.add(j);
    }

    public double FtoC(double F){
        return (5*(F-32))/9;
    }

    public double CtoF(double C){
        return (1.8*C) + 32;
    }

    public void actionPerformed(ActionEvent e){
         String event = e.getActionCommand();
         String s = t.getText();
         try{
            double num = Double.parseDouble(s);
             if(event.equals("FtoC")){
                 j.setText((new Double(FtoC(num))).toString());
             }
             if(event.equals("CtoF")){
                j.setText((new Double(CtoF(num))).toString());
            }
                
         } catch (NumberFormatException ex){
            j.setText("Please enter a number!");
         }
        
    }

    public static void main(String[] args) {
        TempConversionWindow g = new TempConversionWindow();
        g.setVisible(true);
    }

}


