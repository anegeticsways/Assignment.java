import java.awt.*;
import javax.swing.*;

// ================= MEMBER 4 =================
// Contributed by: Nur Ainin Sofiya binti Jeffery
// Role: GUI Framework & Integration
// - Create the main class and the main(String[] args) entry point
// - Improve the Encode Button to fetch input, run Member 1-3's method, and update the UI.

//Main function
public class Assignment {
    public static void main(String[] args) {
        String groupID = "G04/SE-G10";  //groupShift value = 6
        String input = JOptionPane.showInputDialog("Enter text to encode (lowercase/numbers):");

        if (input == null) return;

        //Contirbuted by Andrean | Improved by Ainin: separate input from Encoded.java
        if (Encoded.checkStringValidity(input)) {
            // Demonstrate OOP by creating the object
            Encoded encoder = new Encoded(input);
            
            int groupShift = Encoded.generateShift(groupID); //groupShift value = 6
            int finalShift = groupShift + encoder.getCharCount(); //calling via 'encoder' because removed static for encapsulation
            String resultText = encoder.applyCipher(input, finalShift);

            //required GUI
            //contributed by afiq, improved by Ainin
            JFrame frame = new JFrame("Encoding Result");
            frame.setSize(400, 300);
            frame.setLayout(new GridLayout(5, 1, 0, 10)); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.add(new JLabel("  Non-space Characters: " + encoder.getCharCount()));
            frame.add(new JLabel("  Final Shift: " + finalShift));
            frame.add(new JLabel("  Encoded Result:"));

            JTextArea resultArea = new JTextArea(2, 20);
            resultArea.setText(resultText);
            resultArea.setEditable(false);
            resultArea.setLineWrap(true);  //Wrap text so it does not go off-screen
            resultArea.setWrapStyleWord(true); //Ensures words are not split off mid-line

            //contributed by Ainin
            frame.add(new JScrollPane(resultArea));

            frame.setVisible(true);
            JOptionPane.showMessageDialog(null, "Encoding completed successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input! Use lowercase letters, numbers, and spaces only.");
        }
    }
}
