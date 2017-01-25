import java.util.*;

public class PrE12LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        TreeMap<String,Integer> junk = new TreeMap<>();
        TreeMap<String,Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards",0);
        keyMaterials.put("motes",0);
        keyMaterials.put("fragments",0);
        boolean isFound = false;
        while (true){
            String[] input = scan.nextLine().split(" ");
            if(input[0].equals("")){
                break;
            }
            for (int i = 0; i < input.length; i+=2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase();
                if(material.equals("shards")
                        || material.equals("motes")
                        || material.equals("fragments")){
                    int oldQuantity = keyMaterials.get(material);
                    int overAll = oldQuantity + quantity;
                    keyMaterials.put(material,overAll);
                    if(overAll >= 250){
                        String item = getItem(material);
                        System.out.printf("%s obtained!\n", item);
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        isFound = true;
                        break;
                    }
                }
                else{
                    if(!junk.containsKey(material)){
                        junk.put(material,0);
                    }
                    int oldJunkQuantity = junk.get(material);
                    junk.put(material,oldJunkQuantity + quantity);
                }
            }
            if(isFound){
                break;
            }
        }

        for (Map.Entry<String,Integer> entry: entriesSortedByValues(keyMaterials)){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        for (Map.Entry<String, Integer> entry: junk.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static String getItem(String material) {
        String item = "";
        switch (material){
            case "shards": item = "Shadowmourne";
                break;
            case "fragments": item = "Valanyr";
                break;
            case "motes": item = "Dragonwrath";
                break;
        }
        return item;
    }

    static <K,V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
                new Comparator<Map.Entry<K,V>>() {
                    @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        int res = e2.getValue().compareTo(e1.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}
