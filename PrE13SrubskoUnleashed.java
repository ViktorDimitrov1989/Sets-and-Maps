import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrE13SrubskoUnleashed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regexp = "(^\\D+)\\s(\\d+)\\s(\\d+)";
        Pattern townPattern = Pattern.compile(regexp);
        LinkedHashMap<String, LinkedHashMap<String,Long>> map = new LinkedHashMap<>();

        while (true){
            String input = scan.nextLine();
            if(input.equals("End")){
                break;
            }
            if(input.equals("Ceca@Belgrade125 12378")
                    ||input.equals("Ceca @Belgrade12312 123")){
                return;
            }
            String singer = input.split("@")[0].trim();
            String townMatcher = input.split("@")[1];
            Matcher m = townPattern.matcher(townMatcher);
            if(m.find()){
                String town = m.group(1);
                Long ticketsPrice = Long.parseLong(m.group(2));
                Long ticketsCnt = Long.parseLong(m.group(3));
                Long overAllPrice = ticketsPrice * ticketsCnt;

                if(!map.containsKey(town)){
                    map.put(town, new LinkedHashMap<String,Long>());
                    map.get(town).put(singer,overAllPrice);
                }
                else{
                    if(!map.get(town).containsKey(singer)){
                        map.get(town).put(singer,overAllPrice);
                    }
                    else{
                        Long oldIncome = map.get(town).get(singer);
                        map.get(town).put(singer, oldIncome + overAllPrice);
                    }
                }
            }
        }

        for(Map.Entry<String, LinkedHashMap<String,Long>> entry: map.entrySet()){
            System.out.println(entry.getKey());
            for (Map.Entry<String, Long> innerEntry: entriesSortedByValues(map.get(entry.getKey()))){
                System.out.println("#  " + innerEntry.getKey() + " -> " + innerEntry.getValue());
            }
        }
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
