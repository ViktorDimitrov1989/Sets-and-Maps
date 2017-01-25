import java.util.*;

public class PrE09UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> map = new TreeMap<>();
        while (true){
            String[] input = scan.nextLine().split(" ");
            if(input[0].equals("end")){
                break;
            }
            String ip = input[0].split("=")[1];
            String message = input[1].split("=")[1];
            String user = input[2].split("=")[1];
            if(!map.containsKey(user)){
                map.put(user,new LinkedHashMap<>());
                map.get(user).put(ip,1);
            }
            else{
                if(map.get(user).containsKey(ip)){
                    map.get(user).put(ip, map.get(user).get(ip) + 1);
                }
                else{
                    map.get(user).put(ip,1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry: map.entrySet()){
            System.out.println(entry.getKey() + ": ");
            String key = entry.getKey();
            for (Map.Entry<String, Integer> innerEntry: map.get(key).entrySet()){
                sb.append(innerEntry.getKey() + " => " + innerEntry.getValue() + ", ");
            }
            System.out.print(sb.substring(0,sb.length() - 2) + ".\n");
            sb.setLength(0);
        }
    }
}
