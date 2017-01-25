import java.util.*;

public class Pr02SoftuniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> numbers = new ArrayList<String>(Arrays.asList("0","1","2","3","4","5","6","7","8","9"));
        HashSet<String> regular = new LinkedHashSet<>();
        TreeSet<String> vip = new TreeSet<>();

        while (true){
            String input = scanner.nextLine();
            if("PARTY".equals(input)){
                break;
            }

            if(numbers.contains(input.charAt(0))){
                vip.add(input);
            }
            else{
                regular.add(input);
            }
        }

        while (true){
            String input = scanner.nextLine();
            if("END".equals(input)){
                break;
            }
            if(numbers.contains(input.charAt(0))){
                vip.remove(input);
            }
            else{
                regular.remove(input);
            }
        }

        vip.addAll(regular);
        System.out.println(vip.size());
        for(String name: vip){
            System.out.println(name);
        }
    }
}
