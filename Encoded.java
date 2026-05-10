// Contributed by Elisa
public class Encoded {
    
    //Method 1: Validate Input
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

    public static void main(String[] args) {

        String text = "TMF 2954 Java Programming (Semester 2, 2025/2026)";
        String invalid = "Hello123";
        String groupID = "G04/SE-G06";

        System.out.println("Valid text: "
                + checkStringValidity(text));

        System.out.println("Invalid text: "
                + checkStringValidity(invalid));

        System.out.println("Character count: "
                + countCharacters(text));

        System.out.println("Generated shift: "
                + generateShift(groupID));
    }
}