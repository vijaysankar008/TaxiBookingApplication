package app.online.ola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingController {
    static List<Taxi> taxisList=new ArrayList<>();
    public static void main(String[] args) {
        Scanner userInput=new Scanner(System.in); 
        System.out.println("Add How many taxi you want");
        int taxiCount=userInput.nextInt();
        createTaxiList(taxiCount);

        System.out.println("***Welcome to Taxi Booking Application***");
        System.out.println("Select Any Options 1.Taxi Booking");
        
        int selectOption=userInput.nextInt();
        switch (selectOption) {
            case 1:{
                System.out.println("You have selected the Booking option");
            }
                
                break;
        
            default:
                break;
        }
    }

    public static void createTaxiList(int count){
        for(int i=1;i<=count;i++){
            taxisList.add(new Taxi(i));
        }
    }
}
