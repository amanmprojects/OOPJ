import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
    TextField mainDisplay;
    Label historyDisplay; // For showing the previous input and operation
    String currentInput = "";
    String operator = "";
    double result = 0;

    public Calculator() {
        // Setting up the frame
        setLayout(new BorderLayout());
        setTitle("Enhanced Calculator");
        setSize(400, 600);
        setResizable(false);

        // History display (for showing the previous operations)
        historyDisplay = new Label(" ", Label.RIGHT);
        historyDisplay.setFont(new Font("Arial", Font.PLAIN, 18));
        historyDisplay.setBackground(Color.LIGHT_GRAY);
        add(historyDisplay, BorderLayout.NORTH);

        // Main display for the current input
        mainDisplay = new TextField();
        mainDisplay.setFont(new Font("Arial", Font.BOLD, 24));
        mainDisplay.setEditable(false);
        add(mainDisplay, BorderLayout.CENTER);

        // Panel for buttons
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

        // Adding buttons to the panel
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String label : buttonLabels) {
            Button button = new Button(label);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            // Number button pressed
            currentInput += command;
            mainDisplay.setText(currentInput);
        } else if (command.equals("C")) {
            // Clear button
            currentInput = "";
            operator = "";
            result = 0;
            historyDisplay.setText(" ");
            mainDisplay.setText("");
        } else if (command.equals("=")) {
            // Equals button
            calculate();
            operator = "";
            currentInput = String.valueOf(result);
            mainDisplay.setText(currentInput);
            historyDisplay.setText(" ");
        } else {
            // Operator button
            if (!currentInput.isEmpty()) {
                calculate();
                operator = command;
                historyDisplay.setText(result + " " + operator);
                currentInput = "";
            }
        }
    }

    private void calculate() {
        double input = currentInput.isEmpty() ? 0 : Double.parseDouble(currentInput);

        switch (operator) {
            case "+":
                result += input;
                break;
            case "-":
                result -= input;
                break;
            case "*":
                result *= input;
                break;
            case "/":
                if (input != 0) {
                    result /= input;
                } else {
                    mainDisplay.setText("Error");
                }
                break;
            default:
                result = input;
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }
}
