import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatabaseInsertPerformance {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Local instance MySQL80";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Opusdei13?";
    private static final int RECORD_COUNT = 1000;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Database Insert Performance");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a DBConnectionPanel for connecting to the database
        DBConnectionPanel connectionPanel = new DBConnectionPanel();

        // Create a button to start the performance test
        JButton startButton = new JButton("Start Test");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection connection = connectionPanel.getConnection();
                if (connection != null) {
                    performInsertTest(connection);
                }
            }
        });

        // Create a container for the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.add(connectionPanel);
        panel.add(startButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private static void performInsertTest(Connection connection) {
        long startTime, endTime;

        // Without Batch Updates
        try {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Temp(num1, num2, num3) VALUES (?, ?, ?)"
            );

            startTime = System.currentTimeMillis();
            for (int i = 0; i < RECORD_COUNT; i++) {
                statement.setDouble(1, Math.random());
                statement.setDouble(2, Math.random());
                statement.setDouble(3, Math.random());
                statement.executeUpdate();
            }
            endTime = System.currentTimeMillis();

            System.out.println("Without Batch Updates: " + (endTime - startTime) + " ms");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // With Batch Updates
        try {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Temp(num1, num2, num3) VALUES (?, ?, ?)"
            );

            startTime = System.currentTimeMillis();
            for (int i = 0; i < RECORD_COUNT; i++) {
                statement.setDouble(1, Math.random());
                statement.setDouble(2, Math.random());
                statement.setDouble(3, Math.random());
                statement.addBatch();
            }
            statement.executeBatch();
            endTime = System.currentTimeMillis();

            System.out.println("With Batch Updates: " + (endTime - startTime) + " ms");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
