// Contributed by Elisa
public class Encoded {

    // Method 1: Validate Input
    public static boolean checkStringValidity(String text) {

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            // check if character is NOT lowercase letter or space
            if (!(ch >= 'a' && ch <= 'z') && ch != ' ') {
                return false;
            }
        }

        return true;
    }

    // Method 2: Count non-space characters
    public static int countCharacters(String text) {

        int count = 0;

        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) != ' ') {
                count++;
            }
        }

        return count;
    }

    // Method 3: Generate group shift using hashCode
    public static int generateShift(String groupID) {

        int hash = groupID.hashCode();

        // make positive number
        hash = Math.abs(hash);

        // limit shift between 1 and 10
        int shift = (hash % 10) + 1;

        return shift;
    }

    // Contributed by: [FERNANDEZ RUGU]
    public String applyCipher(String inputText, int finalShift) {
        StringBuilder result = new StringBuilder();

        // Loop through each character in the input string
        for (int i = 0; i < inputText.length(); i++) {
            char c = inputText.charAt(i);

            if (c >= 'a' && c <= 'z') {
                // For lowercase letters a-z
                // 1. (c - 'a') converts the char to an index (0 to 25).
                // 2. Add the shift.
                // 3. % 26 wraps it back around if it goes past 'z'.
                // 4. + 'a' converts it back to the ASCII character
                char shiftedChar = (char) (((c - 'a' + finalShift) % 26) + 'a');
                result.append(shiftedChar);
                
            } else if (c >= '0' && c <= '9') {
                // For digits 0-9
                // 1. (c - '0') converts the char to a numeric index (0 to 9).
                // 2. Add the shift.
                // 3. % 10 wraps it back around if it goes past '9'
                // 4. + '0' converts it back to the ASCII character
                char shiftedChar = (char) (((c - '0' + finalShift) % 10) + '0');
                result.append(shiftedChar);
                
            } else if (c == ' ') {
                // Spaces remain unchanged
                result.append(c);
            }
        }
        
        return result.toString();
    }
}