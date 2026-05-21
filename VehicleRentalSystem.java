package com.vehiclerental;

import java.util.Scanner;

interface VehicleRental {
    void rentVehicle(int customerIndex);
}

class AlreadyBookedException extends Exception {
    public AlreadyBookedException(String message) {
        super(message);
    }
}

class CarRental {
    static final int MAX_CUSTOMERS = 99;
    String[] names = new String[MAX_CUSTOMERS];
    String[] details = new String[MAX_CUSTOMERS];
    int customerCount = 0;

    int addCustomer(String name) {
        if (customerCount >= MAX_CUSTOMERS) {
            System.out.println("Maximum customer limit reached!");
            return -1;
        }
        names[customerCount] = name;
        details[customerCount] = null;
        return customerCount++;
    }

    int findCustomerIndex(String name) {
        for (int i = 0; i < customerCount; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    void deleteDetail(int index) {
        if (index >= 0 && index < customerCount) {
            details[index] = null;
            System.out.println("Booking deleted for customer: " + names[index]);
        }
    }

    void displayInfo() {
        System.out.println("\n--- Booking and Customer Details ---");
        for (int i = 0; i < customerCount; i++) {
            System.out.println("Customer: " + names[i] + " | Booked Vehicle: " + (details[i] == null ? "None" : details[i]));
        }
    }

    boolean isBooked(String vehicle) {
        for (String detail : details) {
            if (vehicle != null && vehicle.equals(detail)) return true;
        }
        return false;
    }

    void setBooking(int customerIndex, String vehicle) {
        details[customerIndex] = vehicle;
    }
}

class Cars implements VehicleRental {
    private String[] mehranModels = {"Mehran 2012 Red MT 895", "Mehran 2015 Blue XY 123", "Mehran 2018 White AB 456", "Mehran 2020 Black MN 789"};

    private Scanner sc;
    private CarRental rental;

    public Cars(CarRental rental, Scanner sc) {
        this.rental = rental;
        this.sc = sc;
    }

    @Override
    public void rentVehicle(int customerIndex) {
        rentMehran(customerIndex);
    }

    void rentMehran(int customerIndex) {
        System.out.println("Available Mehran Cars:");
        for (int i = 0; i < mehranModels.length; i++) {
            System.out.println((i + 1) + ") " + mehranModels[i]);
        }
        System.out.print("Select a choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice < 1 || choice > mehranModels.length) {
            System.out.println("Invalid choice!");
            return;
        }
        String selectedCar = mehranModels[choice - 1];
        try {
            if (rental.isBooked(selectedCar)) {
                throw new AlreadyBookedException("This car is already booked!");
            }
            rental.setBooking(customerIndex, selectedCar);
            System.out.println("This Mehran is selected and booked: " + selectedCar);
        } catch (AlreadyBookedException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Bikes implements VehicleRental {
    private String[] bikeModels = {"Red CD 70 2013 kk-905", "Black 125 2018 OP-666"};

    private Scanner sc;
    private CarRental rental;

    public Bikes(CarRental rental, Scanner sc) {
        this.rental = rental;
        this.sc = sc;
    }

    @Override
    public void rentVehicle(int customerIndex) {
        rentBike(customerIndex);
    }

    void rentBike(int customerIndex) {
        System.out.println("Available Bikes:");
        for (int i = 0; i < bikeModels.length; i++) {
            System.out.println((i + 1) + ") " + bikeModels[i]);
        }
        System.out.print("Select a choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice < 1 || choice > bikeModels.length) {
            System.out.println("Invalid choice!");
            return;
        }
        String selectedBike = bikeModels[choice - 1];
        try {
            if (rental.isBooked(selectedBike)) {
                throw new AlreadyBookedException("This bike is already booked!");
            }
            rental.setBooking(customerIndex, selectedBike);
            System.out.println("This Bike is selected and booked: " + selectedBike);
        } catch (AlreadyBookedException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Trucks implements VehicleRental {
    private String[] truckModels = {"Grey Isuzui 2016 xd-065", "Brown Mercedes 2010 pf-691", "Blue Daihatsu 2009 FG-566"};

    private Scanner sc;
    private CarRental rental;

    public Trucks(CarRental rental, Scanner sc) {
        this.rental = rental;
        this.sc = sc;
    }

    @Override
    public void rentVehicle(int customerIndex) {
        rentTruck(customerIndex);
    }

    void rentTruck(int customerIndex) {
        System.out.println("Available Trucks:");
        for (int i = 0; i < truckModels.length; i++) {
            System.out.println((i + 1) + ") " + truckModels[i]);
        }
        System.out.print("Select a choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice < 1 || choice > truckModels.length) {
            System.out.println("Invalid choice!");
            return;
        }
        String selectedTruck = truckModels[choice - 1];
        try {
            if (rental.isBooked(selectedTruck)) {
                throw new AlreadyBookedException("This truck is already booked!");
            }
            rental.setBooking(customerIndex, selectedTruck);
            System.out.println("This Truck is selected and booked: " + selectedTruck);
        } catch (AlreadyBookedException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class VehicleRentalSystem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CarRental rental = new CarRental();
        Cars cars = new Cars(rental, sc);
        Bikes bikes = new Bikes(rental, sc);
        Trucks trucks = new Trucks(rental, sc);

        boolean running = true;
        while (running) {
            System.out.println("\n--- Vehicle Rental System Menu ---");
            System.out.println("1. Add New Customer");
            System.out.println("2. Book Vehicle");
            System.out.println("3. Delete Booking");
            System.out.println("4. Show All Bookings");
            System.out.println("5. Exit");
            System.out.println("6. Update Booking");   // <-- Added menu option here
            System.out.print("Enter your choice: ");
            int mainChoice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (mainChoice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();
                    int custIndex = rental.addCustomer(name);
                    if (custIndex != -1) {
                        System.out.println("Customer added with ID: " + custIndex);
                    }
                    break;

                case 2:
                    System.out.print("Enter your name for booking: ");
                    String custName = sc.nextLine();
                    int index = rental.findCustomerIndex(custName);
                    if (index == -1) {
                        System.out.println("Customer not found! Please add customer first.");
                        break;
                    }

                    System.out.println("Choose Vehicle Type:");
                    System.out.println("1) Car");
                    System.out.println("2) Bike");
                    System.out.println("3) Truck");
                    System.out.print("Enter choice: ");
                    int vehicleType = sc.nextInt();
                    sc.nextLine();

                    switch (vehicleType) {
                        case 1:
                            System.out.println("Choose Car Brand:");
                            System.out.println("1) Mehran");
                            System.out.print("Enter choice: ");
                            int carChoice = sc.nextInt();
                            sc.nextLine();
                            switch (carChoice) {
                                case 1: cars.rentVehicle(index); break;
                                default: System.out.println("Invalid car choice."); break;
                            }
                            break;
                        case 2:
                            bikes.rentVehicle(index);
                            break;
                        case 3:
                            trucks.rentVehicle(index);
                            break;
                        default:
                            System.out.println("Invalid vehicle type choice.");
                    }
                    break;

                case 3:
                    System.out.print("Enter customer name to delete booking: ");
                    String delName = sc.nextLine();
                    int delIndex = rental.findCustomerIndex(delName);
                    if (delIndex != -1) {
                        rental.deleteDetail(delIndex);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 4:
                    rental.displayInfo();
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting Vehicle Rental System. Goodbye!");
                    break;

                case 6:
                    System.out.print("Enter your name to update booking: ");
                    String updateName = sc.nextLine();
                    int updateIndex = rental.findCustomerIndex(updateName);
                    if (updateIndex == -1) {
                        System.out.println("Customer not found!");
                        break;
                    }
                    if (rental.details[updateIndex] == null) {
                        System.out.println("No existing booking found for customer to update.");
                        break;
                    }

                    System.out.println("Choose Vehicle Type to update:");
                    System.out.println("1) Car");
                    System.out.println("2) Bike");
                    System.out.println("3) Truck");
                    System.out.print("Enter choice: ");
                    int updateVehicleType = sc.nextInt();
                    sc.nextLine();

                    switch (updateVehicleType) {
                        case 1:
                            System.out.println("Choose Car Brand:");
                            System.out.println("1) Mehran");
                            System.out.print("Enter choice: ");
                            int updateCarChoice = sc.nextInt();
                            sc.nextLine();
                            if (updateCarChoice == 1) {
                                rental.deleteDetail(updateIndex);   // Delete old booking
                                cars.rentVehicle(updateIndex);      // Book new car
                            } else {
                                System.out.println("Invalid car choice.");
                            }
                            break;
                        case 2:
                            rental.deleteDetail(updateIndex);
                            bikes.rentVehicle(updateIndex);
                            break;
                        case 3:
                            rental.deleteDetail(updateIndex);
                            trucks.rentVehicle(updateIndex);
                            break;
                        default:
                            System.out.println("Invalid vehicle type choice.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        sc.close();
    }
}  
