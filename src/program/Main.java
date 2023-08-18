package program;

import entities.CarRental;
import entities.Vehicle;
import service.BrazilTaxService;
import service.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rent data: ");
        System.out.print("Car model: ");
        String model = sc.nextLine();
        System.out.print("Pickup (dd/MM/yyyy hh:mm): ");
        LocalDateTime pickup = LocalDateTime.parse(sc.nextLine(),dft);
        System.out.print("Return (dd/MM/yyyy hh:mm): ");
        LocalDateTime carReturn = LocalDateTime.parse(sc.nextLine(),dft);
        System.out.print("Enter price per hour: ");
        double pricePerHour = sc.nextDouble();
        System.out.print("Enter price per day: ");
        double pricePerDay = sc.nextDouble();

        CarRental carRental = new CarRental(pickup,carReturn,new Vehicle(model));
        RentalService rentalService = new RentalService(pricePerHour,pricePerDay,new BrazilTaxService());
        rentalService.processInvoice(carRental);
        System.out.println(carRental.getInvoice().toString());

        /*System.out.println("Invoice: ");
        System.out.println("Basice payment: "+String.format("%.2f", carRental.getInvoice().getBasicPayment()));
        System.out.println("Tax: "+String.format("%.2f",carRental.getInvoice().getTax()));
        System.out.println("Total payment: "+String.format("%.2f",carRental.getInvoice().getTotalPayment()));*/


        sc.close();

    }
}
