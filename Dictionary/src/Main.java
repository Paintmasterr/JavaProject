import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDictionary dictionary = new SimpleDictionary();

        Words textUI = new Words(scanner, dictionary);
        textUI.start();
        System.out.println(dictionary.translate(""));
    }
}