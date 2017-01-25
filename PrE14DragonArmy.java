import java.util.*;

public class PrE14DragonArmy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        LinkedHashMap<String, TreeMap<String,ArrayDeque<String>>> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            String type = input[0];
            String name = input[1];
            String damage = input[2].equals("null")?"45":input[2];
            String health = input[3].equals("null")?"250":input[3];
            String armor = input[4].equals("null")?"10":input[4];
            if(!map.containsKey(type)){
                map.put(type, new TreeMap<String, ArrayDeque<String>>());
                if(!map.get(type).containsKey(name)){
                    map.get(type).put(name, new ArrayDeque<>());
                }
                map.get(type).get(name).add(damage);
                map.get(type).get(name).add(health);
                map.get(type).get(name).add(armor);
            }
            else{
                if(!map.get(type).containsKey(name)){
                    map.get(type).put(name, new ArrayDeque<String>());
                    ArrayDeque<String> statsStack = map.get(type).get(name);
                    statsStack.add(damage);
                    statsStack.add(health);
                    statsStack.add(armor);
                    map.get(type).put(name, statsStack);
                }
                else{
                    ArrayDeque<String> statsStack = map.get(type).get(name);
                    while (!statsStack.isEmpty()){
                        statsStack.pop();
                    }
                    statsStack.push(damage);
                    statsStack.push(health);
                    statsStack.push(armor);
                    map.get(type).put(name, statsStack);
                }
            }
        }

        LinkedHashMap<String,ArrayDeque<Double>> averageMap = new LinkedHashMap<>();
        for (Map.Entry<String, TreeMap<String, ArrayDeque<String>>> entry: map.entrySet()){
            calcAverageStats(entry.getValue(),entry.getKey(),averageMap);
        }

        for(Map.Entry<String,ArrayDeque<Double>> entry: averageMap.entrySet()){
            String type = entry.getKey();
            String stats = "";
            while (entry.getValue().size() != 0){
                stats += "/" + String.format("%.2f", entry.getValue().removeLast());
            }
            System.out.printf("%s::(%s)\n", type, stats.substring(1,stats.length()));
            for(Map.Entry<String, ArrayDeque<String>> nameEntry: map.get(entry.getKey()).entrySet()){
                String[] statsArr = getStats(nameEntry.getValue());
                System.out.printf("-%s -> damage: %s, health: %s, armor: %s\n",nameEntry.getKey(),statsArr[0],statsArr[1],statsArr[2]);
            }
        }
    }

    private static String[] getStats(ArrayDeque<String> value) {
        String[] s = new String[3];
        int index = 0;
        while (value.size() != 0){
            s[index] = value.removeFirst();
            index++;
        }
        return s;
    }

    private static LinkedHashMap<String, ArrayDeque<Double>> calcAverageStats(TreeMap<String, ArrayDeque<String>> value, String key, LinkedHashMap<String, ArrayDeque<Double>> averageMap) {
        Double avgDamage = 0d;
        Double avgHealth = 0d;
        Double avgArmor = 0d;
        int cnt = 0;
        int size = value.size();
        for(Map.Entry<String, ArrayDeque<String>> entry: value.entrySet()){
            while (cnt != 3){
                String current = entry.getValue().pop();
                if(cnt == 0){
                    avgDamage += Double.parseDouble(current);
                }
                else if(cnt == 1){
                    avgHealth += Double.parseDouble(current);
                }
                else{
                    avgArmor += Double.parseDouble(current);
                }
                entry.getValue().add(current);
                cnt++;
            }
            cnt = 0;
        }
        avgDamage /= size;
        avgHealth /= size;
        avgArmor /= size;
        averageMap.put(key,new ArrayDeque<Double>());
        averageMap.get(key).push(avgDamage);
        averageMap.get(key).push(avgHealth);
        averageMap.get(key).push(avgArmor);
        return averageMap;
    }
}
