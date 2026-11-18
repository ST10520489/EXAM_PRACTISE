import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class EstateAgentReportGUI extends JFrame {

    private JComboBox<String> cmbLocation;
    private JTextField txtAgentName;
    private JTextField txtPropertyPrice;
    private JTextField txtCommissionPercentage;
    private JTextArea txtReport;
    private final EstateAgent estateAgent = new EstateAgent();

    public EstateAgentReportGUI() {
        setTitle("Estate Agent Report");
        setSize(450, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // --- Menu Bar (Q.2.2) ---
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processReportItem = new JMenuItem("Process Report");
        JMenuItem clearItem = new JMenuItem("Clear");
        JMenuItem saveReportItem = new JMenuItem("Save Report");
        toolsMenu.add(processReportItem);
        toolsMenu.add(clearItem);
        toolsMenu.add(saveReportItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // --- Form Panel (Q.2.1) ---
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 12));

        formPanel.add(new JLabel("AGENT LOCATION:"));
        String[] locations = {"Cape Town", "Durban", "Pretoria"};
        cmbLocation = new JComboBox<>(locations);
        formPanel.add(cmbLocation);

        formPanel.add(new JLabel("ESTATE AGENT NAME:"));
        txtAgentName = new JTextField();
        formPanel.add(txtAgentName);

        formPanel.add(new JLabel("PROPERTY PRICE:"));
        txtPropertyPrice = new JTextField();
        formPanel.add(txtPropertyPrice);

        formPanel.add(new JLabel("COMMISSION PERCENTAGE:"));
        txtCommissionPercentage = new JTextField();
        formPanel.add(txtCommissionPercentage);

        // --- Report Output Area ---
        JPanel reportPanel = new JPanel(new BorderLayout(5, 5));
        reportPanel.add(new JLabel("ESTATE AGENT REPORT:"), BorderLayout.NORTH);

        txtReport = new JTextArea(7, 30);
        txtReport.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtReport);
        reportPanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(reportPanel, BorderLayout.CENTER);
        add(mainPanel);

        // --- Event Listeners ---
        // Q.2.3: Exit
        exitItem.addActionListener(e -> System.exit(0));

        // Q.2.4 & Q.2.7: Process Report with Validation
        processReportItem.addActionListener(e -> processReport());

        // Q.2.6: Clear
        clearItem.addActionListener(e -> clearFields());

        // Q.2.5: Save Report to report.txt
        saveReportItem.addActionListener(e -> saveReport());
    }

    private void processReport() {
        String location = (String) cmbLocation.getSelectedItem();
        String name = txtAgentName.getText().trim();
        String priceStr = txtPropertyPrice.getText().trim();
        String commissionStr = txtCommissionPercentage.getText().trim();

        Data data = new Data(location, name, priceStr, commissionStr);

        if (!estateAgent.ValidateData(data)) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid values:\n- Agent Location and Name cannot be empty.\n- Property Price and Commission Percentage must be greater than 0.",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        double price = Double.parseDouble(priceStr);
        double commissionPct = Double.parseDouble(commissionStr);
        double calculatedCommission = estateAgent.CalculateCommission(priceStr, commissionStr);

        String report = "AGENT LOCATION: " + location + "\n"
                + "AGENT NAME: " + name + "\n"
                + "PROPERTY PRICE: R " + price + "\n"
                + "COMMISSION PERCENTAGE: " + commissionPct + "%\n"
                + "CALCULATED COMMISSION: R " + calculatedCommission;

        txtReport.setText(report);
    }

    private void clearFields() {
        cmbLocation.setSelectedIndex(0);
        txtAgentName.setText("");
        txtPropertyPrice.setText("");
        txtCommissionPercentage.setText("");
        txtReport.setText("");
    }

    private void saveReport() {
        String reportContent = txtReport.getText();
        if (reportContent.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No report to save. Please process a report first.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (FileWriter writer = new FileWriter("report.txt")) {
            writer.write("ESTATE AGENT REPORT\n");
            writer.write("************************************\n");
            writer.write(reportContent + "\n");
            writer.write("************************************");
            JOptionPane.showMessageDialog(this, "Report saved successfully to report.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving report: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}