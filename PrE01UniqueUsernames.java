import java.util.LinkedHashSet;
import java.util.Scanner;

public class PrE01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(scan.nextLine());
        }

        for (String name: set){
            System.out.println(name);
        }
    }
}
