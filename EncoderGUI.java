import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * EncoderGUI class
 * ----------------
 * This class builds a simple Java Swing window (GUI) that lets the user:
 *  1. Type a string into a text box.
 *  2. Click the "Encode" button.
 *  3. See the encoded result, the number of non-space characters,
 *     and the final shift value in a display area.
 *
 * It uses the Encoded class to perform the actual encoding logic.
 */
public class EncoderGUI extends JFrame {
    // GUI Components
    private JTextField inputField;   // Text box where user types the string
    private JButton encodeButton;    // Button to start encoding
    private JTextArea outputArea;    // Text area to show results

    // Constructor: sets up the GUI window
    public EncoderGUI() {
        // Window setup (title, size, close behavior, layout style)
        setTitle("EncoderGUI - G04/SE-G06"); // Group ID is hidden inside Encoded class
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Divide window into NORTH, CENTER, SOUTH sections

        // Input Panel 
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter text to encode:")); // Label before text box
        inputField = new JTextField(30); // Text box for user input 
        inputPanel.add(inputField);
        add(inputPanel, BorderLayout.NORTH); // Place at the top

        //  Button Panel (middle of window) 
        JPanel buttonPanel = new JPanel();
        encodeButton = new JButton("Encode"); // Button with label "Encode"
        encodeButton.setPreferredSize(new Dimension(100, 30)); // Fix button size
        buttonPanel.add(encodeButton);
        add(buttonPanel, BorderLayout.CENTER); // Place in the middle

        //  Output Area (bottom of window) 
        outputArea = new JTextArea();
        outputArea.setEditable(false); // User cannot type here, only see results
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14)); // Clear fixed-width font
        add(new JScrollPane(outputArea), BorderLayout.SOUTH); // Add scroll bar if text is long

        //  Button Action Listener
        // This runs when the user clicks "Encode"
        encodeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Step 1: Get text from input box
                String text = inputField.getText();
                Encoded encoder = new Encoded(); // Temporary encoder object

                // Step 2: Validate input where only lowercase letters, digits, spaces allowed
                if (!encoder.checkStringValidity(text)) {
                    // Display error pop up if invalid
                    JOptionPane.showMessageDialog(null,
                        "Invalid input. Use lowercase letters, digits, and spaces only.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Step 3: Create encoder with valid input and this will runs encoding automatically
                    encoder = new Encoded(text);

                    // Step 4: Display results in output area
                    outputArea.setText(
                        "Non-space characters: " + encoder.getCharCount() +
                        "\nFinal shift: " + encoder.getFinalShift() +
                        "\nEncoded result: " + encoder.getResultText() +
                        "\nEncoding completed successfully."
                    );
                }
            }
        });
    }
}
