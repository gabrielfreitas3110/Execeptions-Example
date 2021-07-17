/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Reservation;
import model.exceptions.DomainExceptions;

/**
 *
 * @author Gabriel Augusto
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date: (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date: (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number,checkIn,checkOut);
            System.out.println("Reservation: " + reservation);
            System.out.println("");
            System.out.println("Enter date to update the reservation; ");
            System.out.print("Check-in date: (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date: (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());
            reservation.updateDates(checkIn, checkOut);

            System.out.println("Reservation: " + reservation);
        } catch(ParseException e) {
           System.out.println("Invalid date format.");
        } catch(DomainExceptions e) {
           System.out.println("Error in reservation: " + e.getMessage());
        } catch(RuntimeException e) {
            System.out.println("unexpected error");
        }
        
        sc.close();

    }
}
