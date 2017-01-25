import java.util.HashSet;
import java.util.Scanner;

public class pr01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        HashSet<String> parkingLot = new HashSet<>();
        while (true){
            String input = scanner.nextLine();
            if(input.equals("END")){
                break;
            }
            String direction = input.split(", ")[0];
            String carNumber = input.split(", ")[1];
            if(direction.equals("IN")){
                parkingLot.add(carNumber);
            }
            else{
                parkingLot.remove(carNumber);
            }
        }
        if(parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
        else{
            for (String number: parkingLot){
                System.out.println(number);
            }
        }
    }
}

