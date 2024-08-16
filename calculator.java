import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class calculator implements ActionListener {
     JFrame f;
     JTextField t;
     JPanel p;
     JButton[] buttons;
     String operator;
     double num1, num2, result;

    public calculator() {
        // Initialize the frame, text field, and panel
        f = new JFrame("Calculator");
        f.setSize(400, 400);
        t = new JTextField(16);
        p = new JPanel(new GridLayout(4, 4, 2, 2));
        
        // Initialize buttons
        buttons = new JButton[16];
        String[] buttonLabels = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "/", "*", "=", "AC"};
        
        // Create buttons and add event listeners
        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].addActionListener(this);
            p.add(buttons[i]);
        }

        // Add components to the frame
        f.add(t, BorderLayout.NORTH);
        f.add(p, BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // If a number button is pressed
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            t.setText(t.getText() + command);
        } 
        // If an operator is pressed
        else if (command.equals("+") || command.equals("-") || command.equals("/") || command.equals("*")) {
            num1 = Double.parseDouble(t.getText());
            operator = command;
            t.setText("");
        } 
        // If the equals button is pressed
        else if (command.equals("=")) {
            num2 = Double.parseDouble(t.getText());
            switch (operator) {
                case "+" -> result = num1 + num2;
                case "-" -> result = num1 - num2;
                case "*" -> result = num1 * num2;
                case "/" -> result = num1 / num2;
            }
            t.setText(String.valueOf(result));
            num1 = result;
        } 
        // If the AC (All Clear) button is pressed
        else if (command.equals("AC")) {
            t.setText("");
        }
    }

    public static void main(String[] args) {
        new calculator();
    }
}