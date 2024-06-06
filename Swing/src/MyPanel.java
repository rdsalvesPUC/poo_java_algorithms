import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel {
    private JTextField stringField;
    private JTextField intField;
    private JTextField doubleField;

    public MyPanel() {
        setLayout(new GridLayout(4, 2));

        // Labels
        add(new JLabel("String:"));
        add(new JLabel("Integer:"));
        add(new JLabel("Double:"));

        // Text Fields
        stringField = new JTextField();
        intField = new JTextField();
        doubleField = new JTextField();

        add(stringField);
        add(intField);
        add(doubleField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });

        add(submitButton);
    }

    private void handleSubmit() {
        // Obter e manipular os dados dos campos de texto
        String stringValue = stringField.getText();

        int intValue = 0;
        try {
            intValue = Integer.parseInt(intField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid integer");
            return;
        }

        double doubleValue = 0.0;
        try {
            doubleValue = Double.parseDouble(doubleField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid double");
            return;
        }

        // Processar os valores
        JOptionPane.showMessageDialog(this, "String: " + stringValue + "\nInteger: " + intValue + "\nDouble: " + doubleValue);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Input Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new MyPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
