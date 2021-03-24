package dictionary;

public class Main {

    public static void main(String[] args) {
        Dictionary test = new Dictionary("hello.txt");
        if (test.load()) {
            test.add("Hello", "привет");
            test.add("Peace", "мир");
            test.translate("Hello");
            test.save();
            System.out.println("Peace: " + test.translate("Peace"));
        }

    }
}