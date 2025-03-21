import javax.swing.*;
import java.awt.*;

public class test2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Score");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout(10, 10));

        JLabel titleLabel = new JLabel("Input Scores Below", JLabel.CENTER);
        titleLabel.setForeground(Color.MAGENTA);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridLayout(8, 2, 5, 5));
        String[] subjects = {"Math", "English", "Computer", "History", "Khmer", "Total", "Average", "Comment"};
        JTextField[] textFields = new JTextField[8];

        for (int i = 0; i < 8; i++) {
            inputPanel.add(new JLabel(subjects[i] + ":"));
            textFields[i] = new JTextField();
            if (i >= 5) textFields[i].setEditable(false);
            inputPanel.add(textFields[i]);
        }

        frame.add(inputPanel, BorderLayout.CENTER);

        JButton calculateButton = new JButton("CALCULATE");
        frame.add(calculateButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}