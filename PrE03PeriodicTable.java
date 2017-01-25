import java.util.Scanner;
import java.util.TreeSet;

class PrE03PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            addElements(set, input);
        }
        StringBuilder sb = new StringBuilder();
        for (String el: set){
            sb.append(el + " ");
        }
        System.out.println(sb);
    }

    private static TreeSet<String> addElements(TreeSet<String> set, String[] elements) {
        String[] els = elements;
        for (String el: els){
            set.add(el);
        }
        return set;
    }
}
