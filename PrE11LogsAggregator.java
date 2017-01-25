import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class PrE11LogsAggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        TreeMap<String, Integer> userDurationMap = new TreeMap<>();
        TreeMap<String,TreeSet<String>> userIpMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            String ip = input[0];
            String user = input[1];
            int duration = Integer.parseInt(input[2]);
            if(!userDurationMap.containsKey(user)){
                userDurationMap.put(user,duration);
                userIpMap.put(user,new TreeSet<String>());
                userIpMap.get(user).add(ip);
            }
            else{
                int oldDur = userDurationMap.get(user);
                userDurationMap.put(user,oldDur + duration);
                userIpMap.get(user).add(ip);
            }
        }
        for (Map.Entry<String,Integer> entry: userDurationMap.entrySet()){
            TreeSet<String> ipArr = userIpMap.get(entry.getKey());
            System.out.printf("%s: %d " + ipArr + "\n", entry.getKey(), entry.getValue());
        }
    }
}
