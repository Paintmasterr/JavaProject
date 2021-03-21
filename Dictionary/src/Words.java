import java.util.Objects;
import java.util.Scanner;

public class Words {

    private final Scanner scanner;
    private final SimpleDictionary simpleDictionary;

    public Words(Scanner scanner, SimpleDictionary simpleDictionary) {
        this.scanner = scanner;
        this.simpleDictionary = simpleDictionary;
    }

    public void start() {

        while (true) {
            System.out.println("Commands menu: \n add - add a new word and translation to the dictionary \n search - search a word's translation \n end - stopping the program");
            String command = scanner.nextLine();

               if (command.equals("end")) {
                System.out.println("Bye bye!");
                break;
            } else if (command.equals("add")) {
                System.out.println("Word:");
                String word = scanner.nextLine();
                System.out.println("Translation:");
                String translation = scanner.nextLine();
                simpleDictionary.add(word, translation);
            } else if (command.equals("search")) {
                System.out.println("To be translated:");
                String translated = scanner.nextLine();
                String returnTranslation = simpleDictionary.translate(translated);
                   System.out.println(Objects.requireNonNullElseGet(returnTranslation, () -> "Word " + translated + " was not found"));
            } else {
                System.out.println("Unknown command");
                continue;
            }
        }

    }
}