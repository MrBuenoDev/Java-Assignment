import java.awt.*;
import javax.swing.*;

/**
 * Contributed by: KHIEW JUNG HUAT
 * Optimizes the GUI display and interaction logic here.
 */
public class Assignment {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // 1. Instantiate the GUI window design
                EncoderGUI gui = new EncoderGUI();
                
                // Locate the JTextArea at the bottom and assign proper dimensions to prevent text clipping.
                try {
                    // Slightly increase the window size to accommodate the optimized layout
                    gui.setSize(500, 420); 
                    
                    // Traverse through the container components to find the unconfigured JTextArea
                    for (Component comp : gui.getContentPane().getComponents()) {
                        if (comp instanceof JScrollPane) {
                            JScrollPane scroll = (JScrollPane) comp;
                            if (scroll.getViewport().getView() instanceof JTextArea) {
                                JTextArea outputArea = (JTextArea) scroll.getViewport().getView();
                                
                                // Dynamically adjust text area
                                outputArea.setRows(8);
                                outputArea.setColumns(40);
                            }
                        }
                    }
                } catch (Exception e) {
                    // exception handling to prevent runtime crashes
                }

                // 2. Center the window on screen and make it visible
                gui.setLocationRelativeTo(null);
                gui.setVisible(true);
            }
        });
    }
}
