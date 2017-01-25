import java.util.LinkedHashSet;
import java.util.Scanner;

public class PrE02SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] length = scan.nextLine().split(" ");
        int n = Integer.parseInt(length[0]);
        int m = Integer.parseInt(length[1]);

        LinkedHashSet<Integer> set1 = new LinkedHashSet<>();
        LinkedHashSet<Integer>  set2 = new LinkedHashSet<>();
        for (int i = 0; i < n + m; i++) {
            if(i < n){
                set1.add(scan.nextInt());
            }
            else{
                set2.add(scan.nextInt());
            }
        }

        set1.retainAll(set2);
        for (int num: set1){
            System.out.print(num + " ");
        }
    }
}
