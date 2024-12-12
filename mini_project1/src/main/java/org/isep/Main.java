// MAFILLE Thomas - 62303
// MAILLARD Rémy - 62304

package org.isep;

import org.isep.airlineManagment.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creation of the times for the flight's timetable.
        LocalDateTime time_2024_12_05_10_12_15 = LocalDateTime.of(2024,12,5,10,12,15);
        LocalDateTime time_2026_12_05_10_12_15 = LocalDateTime.of(2026,12,5,10,12,15);
        LocalDateTime time_2024_12_06_10_12_15 = LocalDateTime.of(2024,12,6,10,12,15);
        LocalDateTime time_2024_02_05_15_25_36 = LocalDateTime.of(2024,2,5,15,25,36);
        LocalDateTime time_2025_01_18_23_59_25 = LocalDateTime.of(2025,1,18,23,59,25);
        LocalDateTime time_2027_07_18_14_25_59 = LocalDateTime.of(2027,7,18,14,25,59);
        LocalDateTime time_2027_07_18_15_25_59 = LocalDateTime.of(2027,7,18,15,25,59);

        // Creation of the airports
        Airport CDG = new Airport("CDG", "Paris", "Paris-Charles-de-Gaulle");
        Airport LHR = new Airport("LHR", "London", "London-Heathrow");

        // Creation of the aircraft
        Aircraft boeing747 = new Aircraft("ABC","Boeing 747",416);
        Aircraft airbusA380 = new Aircraft("DEF","Airbus A380",853);

        // Creations of 3 passengers
        Passenger passenger1 = new Passenger(3000001, "Thomas", "10 rue de Vanves, 92130 Issy-les-Moulineaux", "+33769418460", "FR78AAAAAA");
        Passenger passenger2 = new Passenger(3000002, "Rémy", "Place Lenoncourt, 51100 Reims", "+33782691801", "FR78BBBBBB");
        Passenger passenger3 = new Passenger(3000003, "Seb", "28 rue Notre-Dame-des-Champs, 75006 Paris", "+33101010101", "FR78CCCCCC");

        // Creation of 3 pilots
        AirlinePilot pilot1 = new AirlinePilot(1000001,"Florian","16 Rue d'Antrain, 35000 Rennes","mail",1,"I can fly, trust me",500,LocalDateTime.now());
        AirlinePilot pilot2 = new AirlinePilot(1000002,"Steve","adress1","mail2",2,"What does this button do ?",200,LocalDateTime.now());
        AirlinePilot pilot3 = new AirlinePilot(1000003,"Marilou","adress2","mail3",3,"I afraid of heights",1000,LocalDateTime.now());

        // Creation of 3 crew members
        StaffCabin crew1 = new StaffCabin(2000001,"Alex","adress3","contact",4,"Trust me",LocalDateTime.now());
        StaffCabin crew2 = new StaffCabin(2000002,"George","address4","contact2",5,"I'm an engineer",LocalDateTime.now());
        StaffCabin crew3 = new StaffCabin(2000004,"Ilno","address5","contact3",6,"I think that this should go right here",LocalDateTime.now());

        // Creation of the flights
        // flight1 flies from 05/12/2024 to 05/12/2026
        // flight2 flies from 06/12/2024 to 18/01/2025
        // flight3 flies from 05/02/2024 to 06/12/2024
        // flight4 flies from 06/12/2024 to 18/07/2027
        // flight5 flies from 18/07/2027 to 18/07/2027
        // flight6 flies from 18/07/2027 to 18/07/2027
        Flight flight1 = new Flight(000001, CDG, LHR, time_2024_12_05_10_12_15, time_2026_12_05_10_12_15, "Currently Flying");
        Flight flight2 = new Flight(000002, CDG, LHR, time_2024_12_06_10_12_15, time_2025_01_18_23_59_25, "Currently Flying");
        Flight flight3 = new Flight(000003, CDG, LHR, time_2024_02_05_15_25_36, time_2024_12_06_10_12_15, "Currently Flying");
        Flight flight4 = new Flight(000004, CDG, LHR, time_2024_12_06_10_12_15, time_2027_07_18_14_25_59, "Currently Flying");
        Flight flight5 = new Flight(000005, CDG, LHR, time_2027_07_18_14_25_59, time_2027_07_18_15_25_59, "Currently Flying");
        Flight flight6 = new Flight(000006, CDG, LHR, time_2027_07_18_14_25_59, time_2027_07_18_15_25_59, "Currently Flying");

        // Assigning the planes to each flight
        // Return either 'True' if the assignment was successful, or return 'False' otherwise
        System.out.println(boeing747.assignFlight(flight1));        // True, first flight assigned
        System.out.println(boeing747.assignFlight(flight2));        // False, the flight's fly time is during the fly time of flight1
        System.out.println(boeing747.assignFlight(flight3));        // False, the flight arrives during the fly time of flight1
        System.out.println(boeing747.assignFlight(flight4));        // False, the flight departs during the fly time of flight1
        System.out.println(boeing747.assignFlight(flight5));        // True, the flight is after the fly time of flight1
        System.out.println(airbusA380.assignFlight(flight6));       // True, assignation of another aircraft to the flight6

        // Assigning the pilots to the plane ('True' if success, 'False' otherwise)
        System.out.print("\n");                                     // Blank space for visibility
        System.out.println(pilot1.assignFlight(flight1));           // True, successfully assigned pilot1 to flight1
        System.out.println(pilot1.assignFlight(flight2));           // False, pilot1 cannot be assigned to 2 flights
        System.out.println(pilot2.assignFlight(flight2));           // True, successfully assigned pilot2 to flight2

        // Assigning the pilots to the plane ('True' if success, 'False' otherwise)
        System.out.print("\n");                                     // Blank space for visibility
        System.out.println(crew1.assignFlight(flight1));            // True, successfully assigned crew1 to flight1
        System.out.println(crew1.assignFlight(flight2));            // False, crew1 cannot be assigned to 2 flights
        System.out.println(crew2.assignFlight(flight2));            // True, successfully assigned crew2 to flight2

        // Creation, adding and removing reservations
        System.out.print("\n");                                     // Blank space for visibility
        // Creation of a book object for a new reservation (with a new id, and a new time of reservation)
        Book bookFlight1 = new Book(1,LocalDateTime.now(),".");
        // Adding twice flight1 to the reservation
        passenger1.bookFlight(flight1);
        passenger1.bookFlight(flight1);
        // Creation of a book object for a new reservation
        Book bookFlight2 = new Book(2,LocalDateTime.now(),".");
        // Adding flight2 to the reservation
        passenger1.bookFlight(flight2);
        // Creation of a book object for a new reservation
        Book bookFlight3 = new Book(3,LocalDateTime.now(),".");
        // Adding flight3 to the reservation
        passenger1.bookFlight(flight3);
        // Output of all the reservations
        passenger1.getReservations();
        System.out.println("\n");                                   // Blank space for visibility
        // Removing flight2 from the reservation
        passenger1.cancelFlight(flight2);
        // Output of all the reservations
        passenger1.getReservations();


        // Menu
        // Scanner scanner;
        int userChoice1;
        int userChoice2;
        int userChoice3;
        String userChoice4;
        boolean flag = true;
        ArrayList<LocalDateTime> dates = new ArrayList<LocalDateTime>();
        ArrayList<Airport> airports = new ArrayList<Airport>();
        ArrayList<Aircraft> aircrafts = new ArrayList<Aircraft>();
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        ArrayList<AirlinePilot> pilots = new ArrayList<AirlinePilot>();
        ArrayList<StaffCabin> staffCabins = new ArrayList<StaffCabin>();
        ArrayList<Flight> flights = new ArrayList<Flight>();
        LocalDateTime date;
        Airport airport;
        Aircraft aircraft;
        Passenger passenger;
        AirlinePilot pilot;
        StaffCabin staffCabin;
        Flight flight;
        do {
            System.out.println("");
            userChoice1 = getInt("Choose a function. Enter the corresponding number : \n0.\tQuit\n1.\tDate\n2.\tAirport\n3.\tAircraft\n4.\tPassenger\n5.\tPilot\n6.\tStaff Cabin\n7.\tFlight", 0);
            switch (userChoice1) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    System.out.println("");
                    userChoice2 = getInt("Choose a function. Enter the corresponding number : \n0.\tBack\n1.\tView a list of all Dates\n2.\tAdd a new Date\n3.\tChange an existing Date\n4.\tRemove a Date", 0);
                    switch (userChoice2) {
                        case 0:
                            break;
                        case 1:
                            int i = 0;
                            for (LocalDateTime d : dates) {
                                System.out.println(i + " : " + d);
                                i++;
                            }
                            if (i == 0) {
                                System.out.println("You currently have no Dates");
                            }
                            break;
                        case 2:
                            date = LocalDateTime.of(getInt("Enter a year", 0), getInt("Enter a month", 0), getInt("Enter a day", 0), getInt("Enter an hour", 0), getInt("Enter a minute", 0), getInt("Enter a second", 0));
                            dates.add(date);
                            break;
                        case 3:
                            System.out.println("");
                            userChoice3 = getInt("Enter the index of the date to modify", -1);
                            System.out.println("You are modifying the following date : ");
                            System.out.println(dates.get(userChoice3));
                            date = LocalDateTime.of(getInt("Enter a year", 0), getInt("Enter a month", 0), getInt("Enter an hour", 0), getInt("Enter a minute", 0), getInt("Enter a minute", 0), getInt("Enter a second", 0));
                            dates.set(userChoice3, date);
                            break;
                        case 4:
                            System.out.println("");
                            userChoice3 = getInt("Enter the index of the date to delete", -1);
                            dates.remove(userChoice3);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("");
                    userChoice2 = getInt("Choose a function. Enter the corresponding number : \n0.\tBack\n1.\tView a list of all Airports\n2.\tAdd a new Airport\n3.\tChange an existing Airport\n4.\tRemove an Airport", 0);
                    switch (userChoice2) {
                        case 0:
                            break;
                        case 1:
                            int i = 0;
                            for (Airport a : airports) {
                                System.out.println(i + " : " + a);
                                i++;
                            }
                            if (i == 0) {
                                System.out.println("You currently have no Airports");
                            }
                            break;
                        case 2:
                            airport = new Airport(getString("Enter a name"), getString("Enter a city"), getString("Enter a description"));
                            airports.add(airport);
                            break;
                        case 3:
                            System.out.println("");
                            userChoice3 = getInt("Enter the index of the airport to modify", -1);
                            System.out.println("You are modifying the following airport : ");
                            System.out.println(airports.get(userChoice3));
                            airport = new Airport(getString("Enter a name"), getString("Enter a city"), getString("Enter a description"));
                            airports.set(userChoice3, airport);
                            break;
                        case 4:
                            System.out.println("");
                            userChoice3 = getInt("Enter the index of the airport to delete", -1);
                            airports.remove(userChoice3);
                            break;
                    }
                    break;
                case 3:
                    System.out.println("");
                    userChoice2 = getInt("Choose a function. Enter the corresponding number : \n0.\tBack\n1.\tView a list of all Aircrafts\n2.\tAdd a new Aircraft\n3.\tChange an existing Aircraft\n4.\tRemove an Aircraft", 0);
                    switch (userChoice2) {
                        case 0:
                            break;
                        case 1:
                            int i = 0;
                            for (Aircraft a : aircrafts) {
                                System.out.println(i + " : " + a);
                                i++;
                            }
                            if (i == 0) {
                                System.out.println("You currently have no Aircrafts");
                            }
                            break;
                        case 2:
                            aircraft = new Aircraft(getString("Enter a registration"), getString("Enter a model"), getInt("Enter a capacity", -1));
                            aircrafts.add(aircraft);
                            break;
                        case 3:
                            System.out.println("");
                            userChoice3 = getInt("Enter the index of the aircraft to modify", -1);
                            System.out.println("You are modifying the following aircraft : ");
                            System.out.println(aircrafts.get(userChoice3));
                            aircraft = new Aircraft(getString("Enter a registration"), getString("Enter a model"), getInt("Enter a capacity", -1));
                            aircrafts.set(userChoice3, aircraft);
                            break;
                        case 4:
                            System.out.println("");
                            userChoice3 = getInt("Enter the index of the aircraft to delete", -1);
                            aircrafts.remove(userChoice3);
                            break;
                    }
                    break;
                case 4:
                    System.out.println("");
                    userChoice2 = getInt("Choose a function. Enter the corresponding number : \n0.\tBack\n1.\tView a list of all Passengers\n2.\tAdd a new Passenger\n3.\tChange an existing Passenger\n4.\tRemove an Passenger", 0);
                    switch (userChoice2) {
                        case 0:
                            break;
                        case 1:
                            int i = 0;
                            for (Passenger p : passengers) {
                                System.out.println(i + " : " + p);
                                i++;
                            }
                            if (i == 0) {
                                System.out.println("You currently have no Passengers");
                            }
                            break;
                        case 2:
                            passenger = new Passenger(getInt("Enter an ID", -1), getString("Enter a name"), getString("Enter an address"), getString("Enter a contact"), getString("Enter a passport"));
                            passengers.add(passenger);
                            break;
                        case 3:
                            System.out.println("");
                            userChoice3 = getInt("Enter the index of the passenger to modify", -1);
                            System.out.println("You are modifying the following passenger : ");
                            System.out.println(passengers.get(userChoice3));
                            passenger = new Passenger(getInt("Enter an ID", -1), getString("Enter a name"), getString("Enter an address"), getString("Enter a contact"), getString("Enter a passport"));
                            passengers.set(userChoice3, passenger);
                            break;
                        case 4:
                            System.out.println("");
                            userChoice3 = getInt("Enter the index of the passenger to delete", -1);
                            passengers.remove(userChoice3);
                            break;
                    }
                    break;
                case 5:
                    System.out.println("");
                    userChoice2 = getInt("Choose a function. Enter the corresponding number : \n0.\tBack\n1.\tView a list of all Pilots\n2.\tAdd a new Pilot\n3.\tChange an existing Pilot\n4.\tRemove an Pilot", 0);
                    switch (userChoice2) {
                        case 0:
                            break;
                        case 1:
                            int i = 0;
                            for (AirlinePilot p : pilots) {
                                System.out.println(i + " : " + p);
                                i++;
                            }
                            if (i == 0) {
                                System.out.println("You currently have no Pilots");
                            }
                            break;
                        case 2:
                            pilot = new AirlinePilot(getInt("Enter an ID", -1), getString("Enter a name"), getString("Enter an address"), getString("Enter a contact"), getInt("Enter an employee ID", -1), getString("Enter a license"), getInt("Enter a number of flight hours", 0), dates.get(getInt("Enter the index of the hiring date", -1)));
                            pilots.add(pilot);
                            break;
                        case 3:
                            System.out.println("");
                            userChoice3 = getInt("Enter the index of the pilot to modify", -1);
                            System.out.println("You are modifying the following pilot : ");
                            System.out.println(pilots.get(userChoice3));
                            pilot = new AirlinePilot(getInt("Enter an ID", -1), getString("Enter a name"), getString("Enter an address"), getString("Enter a contact"), getInt("Enter an employee ID", -1), getString("Enter a license"), getInt("Enter a number of flight hours", 0), dates.get(getInt("Enter the index of the hiring date", -1)));
                            pilots.set(userChoice3, pilot);
                            break;
                        case 4:
                            System.out.println("");
                            userChoice3 = getInt("Enter the index of the pilot to delete", -1);
                            pilots.remove(userChoice3);
                            break;
                    }
                    break;
                case 6:
                    System.out.println("");
                    userChoice2 = getInt("Choose a function. Enter the corresponding number : \n0.\tBack\n1.\tView a list of all Staffs Cabin\n2.\tAdd a new Staff Cabin\n3.\tChange an existing Staff Cabin\n4.\tRemove an Staff Cabin", 0);
                    switch (userChoice2) {
                        case 0:
                            break;
                        case 1:
                            int i = 0;
                            for (StaffCabin s : staffCabins) {
                                System.out.println(i + " : " + s);
                                i++;
                            }
                            if (i == 0) {
                                System.out.println("You currently have no Staffs Cabin");
                            }
                            break;
                        case 2:
                            staffCabin = new StaffCabin(getInt("Enter an ID", -1), getString("Enter a name"), getString("Enter an address"), getString("Enter a contact"), getInt("Enter an employee ID", -1), getString("Enter the qualifications"),  dates.get(getInt("Enter the index of the hiring date", -1)));
                            staffCabins.add(staffCabin);
                            break;
                        case 3:
                            System.out.println("");
                            userChoice3 = getInt("Enter the index of the Staff Cabin to modify", -1);
                            System.out.println("You are modifying the following Staff Cabin : ");
                            System.out.println(staffCabins.get(userChoice3));
                            staffCabin = new StaffCabin(getInt("Enter an ID", -1), getString("Enter a name"), getString("Enter an address"), getString("Enter a contact"), getInt("Enter an employee ID", -1), getString("Enter the qualifications"),  dates.get(getInt("Enter the index of the hiring date", -1)));
                            staffCabins.set(userChoice3, staffCabin);
                            break;
                        case 4:
                            System.out.println("");
                            userChoice3 = getInt("Enter the index of the Staff Cabin to delete", -1);
                            staffCabins.remove(userChoice3);
                            break;
                    }
                    break;
                case 7:
                    System.out.println("");
                    userChoice2 = getInt("Choose a function. Enter the corresponding number : \n0.\tBack\n1.\tAdd a new Flight\n2.\tChange an existing Flight\n3.\tCreate a new Flight", 0);
                    switch (userChoice2) {
                        case 0:
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }
                    break;
            }
        } while (flag);
    }


    public static int getInt(String message, int threshold) {
        Scanner scanner;
        int userChoice;
        do {
            scanner = new Scanner(System.in);
            System.out.println(message);
            try {
                userChoice = scanner.nextInt();
            } catch (Exception e) {
                // if user entered anything else but an integer
                userChoice = -1;
            }
        } while (userChoice < threshold);
        return userChoice;
    }


    public static String getString(String message) {
        Scanner scanner;
        String userChoice;
        scanner = new Scanner(System.in);
        System.out.println(message);
        userChoice = scanner.nextLine();
        return userChoice;
    }
}
