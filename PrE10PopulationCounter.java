import java.util.*;

public class PrE10PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String,Long> overallPopulation = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String,Integer>> citiesByCountry = new LinkedHashMap<>();
        while (true){
            String[] input = scan.nextLine().split("\\|");
            if(input[0].equals("report")){
                break;
            }
            String city = input[0];
            String country = input[1];
            Integer population = Integer.parseInt(input[2]);
            if(!citiesByCountry.containsKey(country)){
                citiesByCountry.put(country,new LinkedHashMap<>());
                citiesByCountry.get(country).put(city,population);
                overallPopulation.put(country,0l);
            }
            else{
                if(!citiesByCountry.get(country).containsKey(city)){
                    citiesByCountry.get(country).put(city,0);
                }
                int newPop = citiesByCountry.get(country).get(city) + population;
                citiesByCountry.get(country).put(city,newPop);
            }
            Long newOverall = overallPopulation.get(country) + population;
            overallPopulation.put(country, newOverall);
        }
        for (Map.Entry<String,Long> entry: entriesSortedByValues(overallPopulation)){
            System.out.printf("%s (total population: %d)\n", entry.getKey(), entry.getValue());
            for (Map.Entry<String,Integer> cityEntry: entriesSortedByValues(citiesByCountry.get(entry.getKey()))){
                System.out.printf("=>%s: %d\n", cityEntry.getKey(),cityEntry.getValue());
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
