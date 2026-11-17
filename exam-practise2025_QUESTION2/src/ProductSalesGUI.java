import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProductSalesGUI extends JFrame {
    // GUI Components (Q.2.1)
    private JButton btnLoad;
    private JButton btnSave;
    private JTextArea txtDisplay;
    private JLabel lblYearsProcessed;

    // Menu Components (Q.2.3)
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu toolsMenu;
    private JMenuItem exitMenuItem;
    private JMenuItem loadMenuItem;
    private JMenuItem saveMenuItem;
    private JMenuItem clearMenuItem;

    // Data class instance from Q.2.4
    private final IProductSales productSales;

    public ProductSalesGUI() {
        productSales = new ProductSales();
        initComponents();
    }

    private void initComponents() {
        // Window Setup (Q.2.1)
        setTitle("Product Sales Application");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // 1. Menu Bar Setup (Q.2.3 - File & Tools)
        menuBar = new JMenuBar();

        // File Menu
        fileMenu = new JMenu("File");
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitMenuItem);

        // Tools Menu
        toolsMenu = new JMenu("Tools");
        loadMenuItem = new JMenuItem("Load Product Data");
        saveMenuItem = new JMenuItem("Save Product Data");
        clearMenuItem = new JMenuItem("Clear");

        loadMenuItem.addActionListener(e -> loadProductData());
        saveMenuItem.addActionListener(e -> saveProductData());
        clearMenuItem.addActionListener(e -> clearData());

        toolsMenu.add(loadMenuItem);
        toolsMenu.add(saveMenuItem);
        toolsMenu.add(clearMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // 2. Top Panel: Load & Save Buttons (Q.2.1 & Q.2.2)
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 5, 8));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 40, 5, 40));

        btnLoad = new JButton("Load Product Data");
        btnSave = new JButton("Save Product Data");

        btnLoad.addActionListener(e -> loadProductData());
        btnSave.addActionListener(e -> saveProductData());

        buttonPanel.add(btnLoad);
        buttonPanel.add(btnSave);
        add(buttonPanel, BorderLayout.NORTH);

        // 3. Center Panel: Text Area inside ScrollPane (Q.2.1)
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));

        txtDisplay = new JTextArea();
        txtDisplay.setEditable(false);
        txtDisplay.setFont(new Font("Monospaced", Font.PLAIN, 13));

        JScrollPane scrollPane = new JScrollPane(txtDisplay);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // 4. Bottom Panel: Read-Only Label (Q.2.1)
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));

        lblYearsProcessed = new JLabel("Years Processed: ");
        bottomPanel.add(lblYearsProcessed);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    // Q.2.2 & Q.2.3: Load Product Data Logic
    private void loadProductData() {
        int totalSales = productSales.GetTotalSales();
        long averageSales = Math.round(productSales.GetAverageSales());
        int salesOverLimit = productSales.GetSalesOverLimit();
        int salesUnderLimit = productSales.GetSalesUnderLimit();
        int yearsProcessed = productSales.GetProductSales().length;

        String report = "Total Sales: " + totalSales + "\n"
                + "Average Sales: " + averageSales + "\n"
                + "Sales over limit: " + salesOverLimit + "\n"
                + "Sales under limit: " + salesUnderLimit;

        txtDisplay.setText(report);
        lblYearsProcessed.setText("Years Processed: " + yearsProcessed);
    }

    // Q.2.2 & Q.2.3: Save Product Data Logic
    private void saveProductData() {
        String content = txtDisplay.getText();
        if (content.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No product data to save. Please load data first.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
            writer.write("DATA LOG\n");
            writer.write("*********************************\n");
            writer.write(content + "\n");
            writer.write("*********************************");
            JOptionPane.showMessageDialog(this, "Product data saved successfully to data.txt",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void clearData() {
        txtDisplay.setText("");
        lblYearsProcessed.setText("");
    }
}