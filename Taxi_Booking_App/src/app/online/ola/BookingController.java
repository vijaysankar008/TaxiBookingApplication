package app.online.ola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookingController {
    static Scanner userInput=new Scanner(System.in); 
    static List<Taxi> taxisList=new ArrayList<>();
    static int bookingId=1;
    static int customerId=1;

    public static void main(String[] args) {
        
        System.out.println("Add How many taxi you want");
        int taxiCount=userInput.nextInt();
        createTaxiList(taxiCount);
        System.out.println("***Welcome to Taxi Booking Application***");
        while (true) {       
        System.out.println("Select Any Options 1.Taxi Booking");
        
        int selectOption=userInput.nextInt();
        switch (selectOption) {
            case 1:{
                bookTaxi();
                break;
            }
        
            default:
                break;
        }
    }
    }

    public static void bookTaxi(){

        System.out.println("Enter the pickup location");
        char pickupLocation=userInput.next().charAt(0);
        System.out.println("Enter the drop location");
        char dropLocation=userInput.next().charAt(0);
        System.out.println("Enter the pickup time");
        int pickupTime=userInput.nextInt();

        List<Taxi> availableTaxis=taxisList.stream().filter(taxi->taxi.taxiIsAvailable(pickupTime))
                           .collect(Collectors.toList());

        if(availableTaxis.size()>0){
            Taxi allotedTaxi=availableTaxis.get(0);
            int bookingCharges=allotedTaxi.calculateBookingCharges(pickupLocation,dropLocation);
            int droptime=pickupTime+Math.abs(pickupLocation-dropLocation);
            Booking booking=new Booking(bookingId++, customerId++, pickupTime, droptime, bookingCharges, pickupLocation, dropLocation);
            allotedTaxi.addBooking(booking);
            System.out.println(taxisList);
        }else{
            System.out.println("No Taxi Available");
        }

    }

    public static void createTaxiList(int count){
        for(int i=1;i<=count;i++){
            taxisList.add(new Taxi(i));
        }
    }
}
