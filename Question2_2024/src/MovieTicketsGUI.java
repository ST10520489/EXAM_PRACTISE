import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MovieTicketsGUI extends JFrame {

    // Form components (Q.2.1)
    private JComboBox<String> cmbMovie;
    private JTextField txtNumTickets;
    private JTextField txtTicketPrice;
    private JTextArea txtReport;

    // Menu components (Q.2.2)
    private JMenuBar menuBar;
    private JMenu fileMenu, toolsMenu;
    private JMenuItem exitItem, processItem, clearItem;

    public MovieTicketsGUI() {
        setTitle("MOVIE TICKETS");
        setSize(420, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // 1. Menu Bar Setup (Q.2.2)
        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);

        toolsMenu = new JMenu("Tools");
        processItem = new JMenuItem("Process");
        clearItem = new JMenuItem("Clear");
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // 2. Input Fields Panel (Q.2.1)
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));

        inputPanel.add(new JLabel("MOVIE:"));
        String[] movies = {"Napoleon", "Oppenheimer", "Damsel"};
        cmbMovie = new JComboBox<>(movies);
        inputPanel.add(cmbMovie);

        inputPanel.add(new JLabel("NUMBER OF TICKETS:"));
        txtNumTickets = new JTextField();
        inputPanel.add(txtNumTickets);

        inputPanel.add(new JLabel("TICKET PRICE:"));
        txtTicketPrice = new JTextField();
        inputPanel.add(txtTicketPrice);

        inputPanel.add(new JLabel("TICKET REPORT:"));
        inputPanel.add(new JLabel(""));

        add(inputPanel, BorderLayout.NORTH);

        // 3. Read-Only Report Text Area (Q.2.1)
        txtReport = new JTextArea();
        txtReport.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtReport);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));
        add(scrollPane, BorderLayout.CENTER);

        // 4. Menu Event Listeners (Q.2.3, Q.2.4, Q.2.6)
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Q.2.3
            }
        });

        clearItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmbMovie.setSelectedIndex(0); // Q.2.6
                txtNumTickets.setText("");
                txtTicketPrice.setText("");
                txtReport.setText("");
            }
        });

        processItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processTicketSale(); // Q.2.4 & Q.2.5
            }
        });
    }

    private void processTicketSale() {
        try {
            String movieName = (String) cmbMovie.getSelectedItem();
            int numTickets = Integer.parseInt(txtNumTickets.getText().trim());
            double ticketPrice = Double.parseDouble(txtTicketPrice.getText().trim());

            MovieTicketData data = new MovieTicketData(movieName, numTickets, ticketPrice);
            MovieTickets ticketProcessor = new MovieTickets();

            // Validate inputs using Q.2.7 rules
            if (!ticketProcessor.ValidateData(data)) {
                JOptionPane.showMessageDialog(this,
                        "Please ensure a movie is selected and both ticket count and price are greater than 0.",
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Calculate total price including 14% VAT
            double totalWithVat = ticketProcessor.CalculateTotalTicketPrice(numTickets, ticketPrice);

            // Display on GUI text area (Q.2.4)
            String guiReport = "MOVIE NAME: " + movieName + "\n"
                    + "MOVIE TICKET PRICE: R " + ticketPrice + "\n"
                    + "NUMBER OF TICKETS: " + numTickets + "\n"
                    + "TOTAL TICKET PRICE: R " + totalWithVat;
            txtReport.setText(guiReport);

            // Save formatted report to report.txt (Q.2.5)
            saveReportToFile(movieName, ticketPrice, numTickets, totalWithVat);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numeric values for number of tickets and ticket price.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveReportToFile(String movieName, double ticketPrice, int numTickets, double totalWithVat) {
        String fileContent = "MOVIE TICKET REPORT\n"
                + "*****************************************\n"
                + "MOVIE NAME: " + movieName + "\n"
                + "MOVIE TICKET PRICE: R " + ticketPrice + "\n"
                + "NUMBER OF TICKETS: " + numTickets + "\n"
                + "TOTAL TICKET PRICE: R " + totalWithVat + "\n"
                + "*****************************************";

        try (PrintWriter writer = new PrintWriter(new FileWriter("report.txt"))) {
            writer.println(fileContent);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error saving report.txt: " + ex.getMessage(),
                    "File Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}