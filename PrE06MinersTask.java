import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PrE06MinersTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        String res = "";
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if(data.equals("stop")){
                break;
            }
            if(i % 2 == 0){
                res = data;
                if(map.get(data) == null){
                    map.put(data,0);
                }
            }
            if(i % 2 != 0){
                int value = Integer.parseInt(data);
                map.put(res, map.get(res) + value);
            }
            data = scan.nextLine();
        }

        for (Map.Entry<String, Integer> entry: map.entrySet()){
            System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}
