package lab2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class BMICalculator extends JFrame {
    private JLabel weightLabel, heightLabel, bmiLabel;
    private JTextField weightTextField, heightTextField;
    private JButton calculateButton;

    public BMICalculator() {
        setTitle("BMI Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        weightLabel = new JLabel("Weight (kg): ");
        heightLabel = new JLabel("Height (m): ");
        bmiLabel = new JLabel("");

        weightTextField = new JTextField();
        heightTextField = new JTextField();

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateBMI();
            }
        });

        add(weightLabel);
        add(weightTextField);
        add(heightLabel);
        add(heightTextField);
        add(calculateButton);
        add(bmiLabel);

        setVisible(true);
    }

    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightTextField.getText());
            double height = Double.parseDouble(heightTextField.getText());

            Pair<Double, Double> person = new Pair<>(weight, height);

            double bmi = calculateBMI(person);
            bmiLabel.setText("BMI: " + bmi);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for weight and height.");
        }
    }

    private double calculateBMI(Pair<Double, Double> person) {
        double weight = person.getFirst();
        double height = person.getSecond();

        return weight / (height * height);
    }

    public static void main(String[] args) {
        new BMICalculator();
    }
}
