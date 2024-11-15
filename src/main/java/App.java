
import model.AutoComplete;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String prefix = null;

        if (args.length > 0) {
            prefix = args[0];
        }

        while (prefix == null || prefix.isEmpty()) {
            System.out.println("Please provide a prefix as an argument:");
            prefix = scanner.nextLine();
        }

        AutoComplete autoComplete = new AutoComplete();
        System.out.println(autoComplete.getAutoCompleteSuggestions(prefix));
    }
}