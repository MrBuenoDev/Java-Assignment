class Encoded {
    private String inputText;
    private int charCount;
    private String resultText;
    private final String groupID = "G04/SE-G06"; // Our group ID 

    // Constructors
    public Encoded() {}

    public Encoded(String inputText) {
        this.inputText = inputText;
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