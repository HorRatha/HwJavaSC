import javax.swing.*;
import java.awt.*;

public class test {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Student Score");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 400);
        frame.setLayout(new GridLayout(10, 2, 5, 5));

        // Create title label
        JLabel titleLabel = new JLabel("Input Score in the Box Below :", JLabel.CENTER);
        titleLabel.setForeground(Color.MAGENTA);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Create labels and text fields
        String[] subjects = {"Math", "English", "Computer", "History", "Khmer", "Total", "Average", "Comment"};
        JTextField[] textFields = new JTextField[subjects.length];

        // Panel to hold title
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);

        // Add title panel at the top
        frame.add(titlePanel);
        frame.add(new JLabel()); // Empty cell to align grid properly

        for (int i = 0; i < subjects.length; i++) {
            frame.add(new JLabel(subjects[i])); // Label
            textFields[i] = new JTextField();
            frame.add(textFields[i]); // Input field
        }

        // Set some default values for demonstration
        textFields[0].setText("65.50");
        textFields[1].setText("74.00");
        textFields[2].setText("76.50");
        textFields[3].setText("98.50");
        textFields[4].setText("90.50");
        textFields[5].setText("405.00");
        textFields[6].setText("81.00");
        textFields[7].setText("He/She is good.");

        // Disable total, average, and comment fields
        textFields[5].setEditable(false);
        textFields[6].setEditable(false);
        textFields[7].setEditable(false);

        // Create the calculate button
        JButton calculateButton = new JButton("CALCULATE");
        frame.add(new JLabel()); // Empty cell to align button properly
        frame.add(calculateButton);

        // Set frame visibility
        frame.setVisible(true);
    }
}