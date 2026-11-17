import javax.swing.SwingUtilities;

void main() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MovieTicketsGUI().setVisible(true);
            }
        });
    }