import java.util.*;

public class Pr03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> player1 = new LinkedHashSet<>();
        LinkedHashSet<Integer> player2 = new LinkedHashSet<>();

        String[] player1Numbers = scanner.nextLine().split(" ");
        String[] player2Numbers = scanner.nextLine().split(" ");

        for (int i = 0; i < 20; i++) {
            player1.add(Integer.parseInt(player1Numbers[i]));
            player2.add(Integer.parseInt(player2Numbers[i]));
        }

        for (int i = 0; i < 50; i++) {
            int firstNumber = player1.iterator().next();
            player1.remove(firstNumber);
            int secondNumber = player2.iterator().next();
            player2.remove(secondNumber);
            if(firstNumber > secondNumber){
                player1.add(firstNumber);
                player1.add(secondNumber);
            }
            else if(secondNumber > firstNumber){
                player2.add(firstNumber);
                player2.add(secondNumber);
            }
            else{
                continue;
            }
        }
        if(player1.size() > player2.size()){
            System.out.println("First player win!");
        }
        else if(player2.size() > player1.size()){
            System.out.println("Second player win!");
        }
        else{
            System.out.println("Draw");
        }
    }
}
