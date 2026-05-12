// ================= MEMBER 1 =================
// Contributed by: Andrean Kong Gang Hung
// Role: Ensuring input integrity and initial class setup
// - Create Encoded() class and checkStringValidity() method to validate input
// - Finalizing, checking and testing code based on requirements

public class Encoded {
        //Variable declaration - 'final' improves security
        private final String inputText;
        private final int charCount;
        private String resultText;
        private final String groupID = "G04/SE-G10"; //Hardcoded secret group ID | groupShift value = 6

        //Constructors
        public Encoded() {
            this.inputText = "";
            this.charCount = 0;
        }

        public Encoded (String inputText) {
            this.inputText = inputText;
            this.charCount = countCharacters(inputText);
        }

        //Validation Logic
        //Subclass: To validate String Characters - Only accepts lowercase letters and whitespace
        public static boolean checkStringValidity(String inputText){
            if (inputText == null || inputText.isEmpty()) return false;

            for (char str : inputText.toCharArray()){
                //Condition: If it's not a letter and not a digit and not a space, it;s invalid
                if (!Character.isLowerCase(str) && !Character.isDigit(str) && str != ' ') {
                    return false;
                }
        
            }
            return true;
        }

        //Subclass: Count characters excluding the whitespace
        //Contributed by Andrean | Fixed by Ainin: Added 'final' to satisfy constructor safety
        public final int countCharacters(String inputText){
            if (inputText == null) return 0;
            return inputText.replace(" ", "").length();
        }

    // ================= MEMBER 2 =================
    // Contributed by: Ailin Najwa
    // Role: Hashing & Shift Engine
    // - Generates groupShift using hashCode() from "G04/SE-G10"
    // - Ensures shift range between 1 and 10
    // - Supports finalShift calculation
    public static int generateShift(String groupID) {
        int hash = Math.abs(groupID.hashCode()); //convert to positive number
        // ensure value between 1 and 10
        //groupShift value = 6
        return (hash % 10) + 1;
    }

    // ================= MEMBER 3 =================
    // Contributed by: Abg Afiq Aiman
    // Role: The Encryption Algorithm
    // - Applies cipher to lowercase letters and digits
    // - Leaves spaces unchanged
    public String applyCipher(String inputText, int shift) {
        StringBuilder encodedText = new StringBuilder(); //(StringBuilder = Java tools(string) to improve memory efficiency
        
        for (int i = 0; i < inputText.length(); i++) {
            char c = inputText.charAt(i);
            
            if (c >= 'a' && c <= 'z') {
                // Formula: (c - 'a' + shift) % 26 + 'a'
                int shiftedValue = (c - 'a' + shift) % 26;
                encodedText.append((char) (shiftedValue + 'a'));
            } 
            else if (c >= '0' && c <= '9') {
                // Formula: (c - '0' + shift) % 10 + '0'
                int shiftedValue = (c - '0' + shift) % 10;
                encodedText.append((char) (shiftedValue + '0'));
            } 
            else {
                encodedText.append(c);
            }
        }
        this.resultText = encodedText.toString();
        return this.resultText;
    }
    public String getInputText() {
        return this.inputText;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public int getCharCount() {
        return this.charCount;
    }
    
    public String getResultText() {
        return this.resultText;
    }
}

