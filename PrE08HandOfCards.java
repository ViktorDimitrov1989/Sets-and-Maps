import java.util.*;

public class PrE08HandOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        LinkedHashMap<String,HashSet<String>> map = new LinkedHashMap<>();
        LinkedHashMap<String,Integer> result = new LinkedHashMap<>();
        HashSet<String> tmp = new HashSet<>();

        while (!input.equals("JOKER")){
            String name = input.split(": ")[0];
            String cards = input.split(": ")[1];
            if(map.get(name) == null){
                map.put(name, new HashSet<>());
                map.put(name,fillSet(map.get(name),cards.split(", ")));
            }
            else{
                tmp = new HashSet<>(Arrays.asList(cards.split(", ")));
                tmp.addAll(map.get(name));
                map.put(name, tmp);
            }
            input = scan.nextLine();
        }
        for(String key: map.keySet()){
            if(!result.containsKey(key)){
                result.put(key,0);
            }
            result.put(key, result.get(key) + sumCardValues(map.get(key)));
        }

        for (Map.Entry<String, Integer> entry: result.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static HashSet<String> fillSet(HashSet<String> tmp, String[] split) {
        for (String p: split){
            tmp.add(p);
        }
        return tmp;
    }

    private static Integer sumCardValues(HashSet<String> value) {
        int sum = 0;
        for (String val: value){
            int p = 0;
            int t = 0;
            String power = val.split("")[0];
            String type = val.split("")[1];
            switch (power){
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9": p = Integer.parseInt(power);
                    break;
                case "1": p = 10; type = val.split("")[2];
                    break;
                case "J": p = 11;
                    break;
                case "Q": p = 12;
                    break;
                case "K": p = 13;
                    break;
                case "A": p = 14;
                    break;
            }
            switch (type){
                case "S": t = 4;
                    break;
                case "H": t = 3;
                    break;
                case "D": t = 2;
                    break;
                case "C": t = 1;
                    break;
            }
            sum += p * t;
        }
        return sum;
    }
}
