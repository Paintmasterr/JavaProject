
package dictionary;

public class Main {

    public static void main(String[] args) {
        // You can test your dictionary here
        Dictionary test = new Dictionary("Words.txt");
        if (test.load()) {
            test.add("car", "машина");
            test.translate("peace");
            test.save();
        }

    }
}