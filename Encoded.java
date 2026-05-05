import java.util.*;
import javax.swing.*;
import java.awt.*;

//Main Function
public class Encoded {

    public static void main(String[] args) {

        //Variable declaration
        String inputText;
        int charCount;
        String resultText;
        String groupID = "G02/SE";

        //Contributed by Andrean, 103325
        //User input String
        inputText = JOptionPane.showInputDialog("Enter your full name in lowercase:");

        //Contributed by Andrean, 103325
        //Condition to check string input
        if (checkStringValidity(inputText)){
            charCount = countCharacters(inputText);
            JOptionPane.showMessageDialog(null, "Total number of characters are " + charCount);
            int groupShift = generateShift(groupID);
            int finalShift = groupShift + charCount;

            // Contributed by afiq
            // Process the input string through the encryption algorithm
            resultText = applyCipher(inputText, finalShift);

            //required UI
            JFrame frame = new JFrame("Final Shift Result");
            frame.setSize(250, 250); // Increased height from 150 to 250 so the new text box fits
            frame.setLayout(new FlowLayout());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel label = new JLabel("Final Shift:");
            JTextField field = new JTextField(10);
            field.setText(String.valueOf(finalShift));
            field.setEditable(false);

            // Contibutd by afiq
            JLabel resultLabel = new JLabel("Encoded Result:");
            JTextArea resultArea = new JTextArea(2, 15);
            resultArea.setText(resultText);
            resultArea.setEditable(false);

            frame.add(label);
            frame.add(field);
            
            // Contributed by afiq
            frame.add(resultLabel);
            frame.add(resultArea);

            frame.setVisible(true);
        }
        else 
            JOptionPane.showMessageDialog(null, "Your input is not a String in lowercase!");
    }

//Contributed by Andrean, 103325
//Subclass: To validate String Characters - Only accepts lowercase letters and whitespace
public static boolean checkStringValidity(String inputText){
    String input = inputText.replaceAll(" ", ""); //To remove whitespace from the String

    //Contributed by Andrean, 103325
    //To loop through each character in the String
    for (char str : input.toCharArray()){
        //Condition: Check if characters are lower than 'a' and larger than 'z'
        if (str < 'a' || str > 'z'){
            return false;
        }
        //Otherwise, it is lowercase letters!
        else
            continue;
    }
    return true;
}

//Contributed by Andrean, 103325
// Subclass: Count Characters
public static int countCharacters(String inputText){
    //Count characters in String excluding the whitespace
    int count = inputText.replace(" ", "").length();
    return count;
}
// ================= MEMBER 2 =================
// Contributed by: Ailin Najwa
// Role: Hashing & Shift Engine
// - Generates groupShift using hashCode()
// - Ensures shift range between 1 and 10
// - Supports finalShift calculation
  public static int generateShift(String groupID) {
        int hash = Math.abs(groupID.hashCode()); //convert to positive number
          // ensure value between 1 and 10
        return (hash % 10) + 1;
    }

// ================= MEMBER 3 =================
// Contributed by: Abg Afiq Aiman
// Role: The Encryption Algorithm
// - Applies cipher to lowercase letters and digits
// - Leaves spaces unchanged
  public static String applyCipher(String inputText, int shift) {
        String encodedText = ""; 
        
        for (int i = 0; i < inputText.length(); i++) {
            char c = inputText.charAt(i);
            
            if (c >= 'a' && c <= 'z') {
                int shiftedValue = (c - 'a' + shift) % 26;
                char newChar = (char) (shiftedValue + 'a');
                encodedText = encodedText + newChar;
            } 
            else if (c >= '0' && c <= '9') {
                int shiftedValue = (c - '0' + shift) % 10;
                char newChar = (char) (shiftedValue + '0');
                encodedText = encodedText + newChar;
            } 
            else if (c == ' ') {
                encodedText = encodedText + c;
            } 
            else {
                encodedText = encodedText + c;
            }
        }
        
        return encodedText;
    }
}
