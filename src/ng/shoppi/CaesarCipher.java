package ng.shoppi;

public class CaesarCipher {


    private String output;
    private StringBuilder builder;

    public CaesarCipher() {

    }

    public String caesar(String input) {
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException("Bad input.");

        String[] split = input.split(":");
        if (split[0].equals(input))
            throw new IllegalArgumentException("Bad input.");
        String shiftData = split[1];
        if (shiftData == null || shiftData.isEmpty())
            throw new IllegalArgumentException("Bad input.");

        int shift;
        try {
            shift = Integer.parseInt(split[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Bad shift value.");
        }

        if (shift < -1000000000 || shift > 1000000000)
            throw new IllegalArgumentException("Shift value out of range.");

        String letters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < shiftData.length(); i++) {
            char c = shiftData.charAt(i);
            char newCharacter;
            if (c >= 'A' && c <= 'Z')
                newCharacter = getNewCharacter(letters.toUpperCase().indexOf(c), shift, letters.toUpperCase());
            else if (c >= 'a' && c <= 'z')
                newCharacter = getNewCharacter(letters.indexOf(c), shift, letters);
            else if (c >= '0' && c <= '9')
                newCharacter = getNewCharacter(numbers.indexOf(c), shift, numbers);
            else
                newCharacter = c;
            System.out.print(c + " ");

            builder.append(newCharacter);
        }
        return builder.toString();
    }

    private char getNewCharacter(int index, int shift, String letters) {
        int totalShift = index + shift;
        if (totalShift > letters.length() - 1)
            return letters.charAt((totalShift % (letters.length() - 1) - 1));
        else
            return letters.charAt(totalShift);
    }

    public static void main(String[] args) {
        CaesarCipher caesarCipher = new CaesarCipher();
        String caesar = caesarCipher.caesar("2:hzWBC109");
        System.out.println("Caesar is " + caesar);
    }
}
