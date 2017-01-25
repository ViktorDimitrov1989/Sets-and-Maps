import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrE05PhoneBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> map = new HashMap<>();
        String input = scan.nextLine();
        while (true){
            if(input.equals("stop")){
                break;
            }
            if(input.contains("-")){
                String name = input.split("-")[0];
                String phoneNum = input.split("-")[1];
                map.put(name,phoneNum);
                input = scan.nextLine();
            }
            else{
                if(map.containsKey(input)){
                    System.out.println(input + " -> " + map.get(input));
                }
                else if(!input.equals("search")){
                    System.out.printf("Contact %s does not exist.\n", input);
                }
                input = scan.nextLine();
            }
        }

    }
}
