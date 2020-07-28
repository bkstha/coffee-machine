import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String string1 = scanner.nextLine().replaceAll("\\s", "");
        String string2 = scanner.nextLine().replaceAll("\\s", "");

        if (string1.equalsIgnoreCase(string2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
