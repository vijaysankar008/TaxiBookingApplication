package app.online.ola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookingController {

    /*
    1.There are 6 points (A, B, C, D, E, F) arranged linearly, and the distance between consecutive points is 15 km.
    2.The travel time between two consecutive points is 1 hour.
    3.All taxis start from point A.
    4.Minimum fare: Rs. 100 for the first 5 km. For every additional kilometer, Rs. 10 is charged.
    5.Allocate a free taxi that is closest to the customer. If two taxis are at the same distance, the one with lower earnings should be allotted.
    6.If no taxis are available, reject the booking.
    7.Display the earnings and booking details of each taxi after every booking.
    */
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
        System.out.println("Select Any Options 1.Taxi Booking  2. View Booking Details 3. Booking Exit");
        
        int selectOption=userInput.nextInt();
        switch (selectOption) {
            case 1:{
                bookTaxi();
                break;
            }
            case 2:{
                viewBookingDetails();
                break;
            }
            case 3:{
                System.out.println("Thank You For Choosing **OLA**");
                break;
            }
            default:
                break;
        }
    }
    }

    public static void viewBookingDetails(){
        System.out.println("Enter Your Booking Id to see the details of Booking...");
        int bookingId=userInput.nextInt();
        Booking booking=null;
        List<Booking> bookingList=null;
        for(Taxi currTaxi : taxisList){
            bookingList=currTaxi.getBookingList().stream().filter(b->b.getBookingId()==bookingId).collect(Collectors.toList());
            if(bookingList!=null && bookingList.size()>0
        )
            booking=bookingList.get(0);
        }
        System.out.println("Your booking Details....Your Booking Id = "+booking.getBookingId()+"  Your name = "+booking.getName()+"  Your PickUpLocation = "+booking.getPickupPoint());

    }

    public static void bookTaxi(){

        System.out.println("Enter Your Name.....");
        String name=userInput.next();
        System.out.println("Enter the pickup location....");
        char pickupLocation=userInput.next().charAt(0);
        System.out.println("Enter the drop location.....");
        char dropLocation=userInput.next().charAt(0);
        System.out.println("Enter the pickup time.....");
        int pickupTime=userInput.nextInt();

        int minDistComparator=Integer.MAX_VALUE;
        double minEarnComparator=Double.MAX_VALUE;
        Taxi allotedTaxi=null;
        for(Taxi currentTaxi : taxisList){
            if(currentTaxi.taxiIsAvailable(pickupTime)){
                int currTaxidist=Math.abs(currentTaxi.getIntialPoint()-pickupLocation);
                if(currTaxidist<minDistComparator||currTaxidist==minDistComparator && currentTaxi.getTotalEarnings()<minEarnComparator){
                    minDistComparator=currTaxidist;
                    allotedTaxi=currentTaxi;
                    minEarnComparator=currentTaxi.getTotalEarnings();
                }

            }
        }
        if(allotedTaxi!=null){
            int bookingCharges=allotedTaxi.calculateBookingCharges(pickupLocation,dropLocation);
            int droptime=pickupTime+Math.abs(pickupLocation-dropLocation);
            Booking booking=new Booking(name,bookingId++, customerId++, pickupTime, droptime, bookingCharges, pickupLocation, dropLocation);
            allotedTaxi.addBooking(booking);
            System.out.println("Your Taxi Has been booked Sucessfully ....Your Booking Id = "+booking.getBookingId());
        }else{
            System.out.println("No Taxi Available");
        }

    }

    public static void createTaxiList(int count){
        for(int i=1;i<=count;i++){
            taxisList.add(new Taxi(i));
            if(i==2)
                taxisList.get(i-1).setIntialPoint('B');
        }
    }
}
