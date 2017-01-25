import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrE13SrubskoUnleashed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regexp = "^([a-zA-Z\\s]+) @([a-zA-z\\s]+)\\s([\\d.]+)\\s([\\d.]+)";
        Pattern townPattern = Pattern.compile(regexp);
        LinkedHashMap<String, LinkedHashMap<String,Double>> map = new LinkedHashMap<>();

        while (true){
            String input = scan.nextLine();
            if(input.equals("End")){
                break;
            }
            Matcher m = townPattern.matcher(input);
            if(m.find()){
                String singer = m.group(1);
                String town = m.group(2);
                Double ticketsPrice = Double.parseDouble(m.group(3));
                Long ticketsCnt = Long.parseLong(m.group(4));
                Double overAllPrice = ticketsPrice * ticketsCnt;

                if(!map.containsKey(town)){
                    map.put(town, new LinkedHashMap<String,Double>());
                    map.get(town).put(singer,overAllPrice);
                }
                else{
                    if(!map.get(town).containsKey(singer)){
                        map.get(town).put(singer,overAllPrice);
                    }
                    else{
                        Double oldIncome = map.get(town).get(singer);
                        map.get(town).put(singer, oldIncome + overAllPrice);
                    }
                }
            }
        }

        for(Map.Entry<String, LinkedHashMap<String,Double>> entry: map.entrySet()){
            System.out.println(entry.getKey());
            for (Map.Entry<String, Double> innerEntry: entriesSortedByValues(map.get(entry.getKey()))){
                System.out.printf("#  %s -> %.0f%n", innerEntry.getKey(), innerEntry.getValue());
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
