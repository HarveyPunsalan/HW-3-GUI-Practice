import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeCalculator {

    private JFrame frame;
    private JTextField tfMilestone1;
    private JTextField tfMilestone2;
    private JTextField tfTermAssess;
    private JButton btnCalcGrade;

    // This is the Main method to run the program
    public static void main(String[] args) {
        GradeCalculator practiceGui = new GradeCalculator();
        practiceGui.frame.setVisible(true);
    }

    // Constructor
    public GradeCalculator() {
        initialize();
    }

    // Method to initialize the contents of the frame
    private void initialize() {
        frame = new JFrame("Milestone Calculator");
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(5, 2, 10, 10));

        // Label and text field for Milestone 1
        JLabel lblMilestone1 = new JLabel("Milestone 1 (0-25)");
        frame.getContentPane().add(lblMilestone1);

        tfMilestone1 = new JTextField();
        frame.getContentPane().add(tfMilestone1);
        tfMilestone1.setColumns(10);

        // Label and text field for Milestone 2
        JLabel lblMilestone2 = new JLabel("Milestone 2 (0-40)");
        frame.getContentPane().add(lblMilestone2);

        tfMilestone2 = new JTextField();
        frame.getContentPane().add(tfMilestone2);
        tfMilestone2.setColumns(10);

        // Label and text field for Terminal Assessment
        JLabel lblTerminal = new JLabel("Terminal Assessment (0-35)");
        frame.getContentPane().add(lblTerminal);

        tfTermAssess = new JTextField();
        frame.getContentPane().add(tfTermAssess);
        tfTermAssess.setColumns(10);

        // Calculate button
        btnCalcGrade = new JButton("Calculate");
        frame.getContentPane().add(btnCalcGrade);

        // Action listener for the calculate button
        btnCalcGrade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });
    }

    // Method to calculate the final grade and display it in a pop-up message
    private void calculateGrade() {
        try {
            // This validate inputs and get their values
            double milestone1 = validateInput(tfMilestone1.getText(), 25);
            double milestone2 = validateInput(tfMilestone2.getText(), 40);
            double terminal = validateInput(tfTermAssess.getText(), 35);

            // Calculate the final grade
            double finalGrade = milestone1 + milestone2 + terminal;

            // pop-up message to display the final grade
            JOptionPane.showMessageDialog(frame, "Your final grade is: " + finalGrade, "Final Grade", JOptionPane.INFORMATION_MESSAGE);

        } catch (IllegalArgumentException ex) {
            // Show error message if input is invalid
            JOptionPane.showMessageDialog(frame, "Ohh ohh, there was an issue with your input: " + ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to validate the input
    private double validateInput(String input, double maxValue) {
        double value;
        try {
            value = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Please enter a valid number");
        }

        if (value < 0 || value > maxValue) {
            throw new IllegalArgumentException("The value must be between 0 and " + maxValue);
        }

        return value;
    }
}
