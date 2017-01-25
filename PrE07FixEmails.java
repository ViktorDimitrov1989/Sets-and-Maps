import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PrE07FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        String name = scanner.nextLine();
        while (!"stop".equals(name)){
            String email = scanner.nextLine();

            if(!map.containsKey(name)){
                map.put(name,"");
            }

            String lastChars = email.substring(email.lastIndexOf('.') + 1,email.length()).toLowerCase();
            if(!lastChars.equals("us")
                    && !lastChars.equals("uk")
                    && !lastChars.equals("com")){
                map.put(name, map.get(name) + email);
            }
            else{
                map.remove(name);
            }
            name = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry: map.entrySet()){
            System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
        }
    }
}
