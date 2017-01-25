import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PrE04CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        char[] text = input.toCharArray();
        TreeMap<Character,Integer> map = new TreeMap<>();
        for(Character ch: text){
            if(map.get(ch) == null){
                map.put(ch,1);
            }
            else{
                map.put(ch, map.get(ch) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            System.out.printf("%s: %d time/s \n", entry.getKey(), entry.getValue());
        }
    }
}
