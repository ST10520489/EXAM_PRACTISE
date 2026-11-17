import javax.swing.SwingUtilities;

    void main () {
        SwingUtilities.invokeLater(() -> {
            new ProductSalesGUI().setVisible(true);
        });
    }
