/*Author name : Kusalani Ransala Dandeniya
Date : 2nd March 2023
Subject : SD II Programming (Course Work)
 */

import java.io.*;
import java.util.*;
import java.io.File;
import java.util.ArrayList;
public class Theatre {                                                       //main class
    static Scanner input = new Scanner(System.in);
    static ArrayList<Ticket> list = new ArrayList<>();
    static Ticket ticket;
    //task1
    public static void main(String[] args) {        // Main driver method
        String[] Row_1_Seats = new String[12];      //array1
        String[] Row_2_Seats = new String[16];      //array2
        String[] Row_3_Seats = new String[20];      //array3

        System.out.println();
        System.out.println(" /////////////////////////////////////////// Welcome to the New Theatre!! ////////////////////////////////////////"); //start of the program
        System.out.println();

//----------------------------------------------------------------------------------------------------------------------
        Arrays.fill(Row_1_Seats, "0");

        Arrays.fill(Row_2_Seats, "0");

        Arrays.fill(Row_3_Seats, "0");
//task2
//----------------------------------------------------------------------------------------------------------------------
        System.out.println("\n");
        System.out.print("----------------------------------------------------------------------------------------------");   //menu border
        System.out.println("\n");

        String option;
        do {                                                                            //menu
            System.out.println();
            System.out.println("Please select an option:");
            System.out.println();

            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by price");
            System.out.println("   0) Quit");

            System.out.println();
            System.out.print("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -");   //menu border
            System.out.println("\n");

            System.out.print("Enter option: ");
            option = input.next();

            switch (option) {
                case "1" -> buy_tickets(Row_1_Seats, Row_2_Seats, Row_3_Seats);           //for option 1
                case "2" -> print_seating_area(Row_1_Seats, Row_2_Seats, Row_3_Seats);    //for option 2
                case "3" -> cancel_ticket(Row_1_Seats, Row_2_Seats, Row_3_Seats);         //for option 3
                case "4" -> show_available(Row_1_Seats, Row_2_Seats, Row_3_Seats);        //for option 4
                case "5" -> save_files(Row_1_Seats, Row_2_Seats, Row_3_Seats);            //for option 5
                case "6" -> load();                                                       //for option 6
                case "7" -> show_tickets_info();                                          //for option 7
                case "8" -> sort_ticket();                                                //for option 8
                case "0" -> System.out.print("""                                            
                        
                        Goodbye!
                        Have a nice day!
                        \n***********************************************************************************************""");   //for option 0 (for terminate the program whether your necessity)
                default -> System.out.println("\nInvalid option, please try again");
            }
        } while (!option.equals("0"));
    }
    //task3
    public static void buy_tickets(String[] row_1, String[] row_2, String[] row_3) {         //option1 (buy tickets)
        System.out.print("\n~~~~~~~~~~~~~~~~~This is for buy tickets!~~~~~~~~~~~~~~~~ ");
        System.out.println();
        char Ticket;
        double price;
        do {
            int row_no;
            int seat_no;

            System.out.print("\nEnter Name: ");                         //get inputs
            String name = input.next();
            System.out.print("\nEnter Surname: ");
            String surname = input.next();
            System.out.print("\nEnter Email: ");
            String email = input.next();
            System.out.print("\nEnter price: ");
            price = input.nextDouble();
            Person object1 = new Person(name, surname, email);
            do {
                System.out.print("\nEnter row number: ");
                row_no = input.nextInt();
                if (row_no <= 3) {                                       //check whether the row number is equal to or less than 3
                    System.out.print("Valid row number.\n");
                } else {
                    System.out.print("Invalid row number.\n");
                }
            }while (row_no > 3 || row_no <= 0);
            while (true) {
                System.out.print("\nEnter seat number: ");
                seat_no = input.nextInt();
                if (row_no == 1 && seat_no < 13 && seat_no > 0) {                    //check whether the row number is equal to 1, seat number less than 13 and seat no greater than 0
                    System.out.print("Valid seat number.\n");
                    ticket = new Ticket(row_no, seat_no, price,object1);
                    list.add(ticket);                                                //add information to the ticket information list in task 13
                    if ("1".equals(row_1[seat_no - 1])) {                            //check whether seat booked or not
                        System.out.println("\nThis seat has been taken");
                    } else if ("0".equals(row_1[seat_no - 1])) {
                        row_1[seat_no - 1] = "1";
                        break;
                    }
                } else if (row_no == 2 && seat_no < 17 && seat_no > 0) {
                    ticket = new Ticket(row_no, seat_no,price, object1);            //add information to the ticket information list in task 13
                    list.add(ticket);                                               //check whether seat booked or not
                    System.out.print("Valid seat number.\n");
                    if ("1".equals(row_2[seat_no - 1])) {
                        System.out.println("\nThis seat has been taken");
                    } else if ("0".equals(row_2[seat_no - 1])) {
                        row_2[seat_no - 1] = "1";
                        break;
                    }
                } else if (row_no == 3 && seat_no < 21 && seat_no > 0) {
                    ticket = new Ticket(row_no, seat_no,price, object1);            //add information to the ticket information list in task 13
                    list.add(ticket);                                               //check whether seat booked or not
                    System.out.print("Valid seat number.\n");
                    if ("1".equals(row_3[seat_no - 1])) {
                        System.out.println("\nThis seat has been taken");
                    } else if ("0".equals(row_3[seat_no - 1])) {
                        row_3[seat_no - 1] = "1";
                        break;
                    }
                } else {
                    System.out.println("Invalid seat number. ");
                }
            }System.out.println("\n************** Purchased successfully! **************");
            System.out.print("\nYou have successfully purchased SEAT NUMBER " + seat_no + " in ROW " + row_no);
            System.out.print("\nIf you want to buy another ticket enter 'y' for yes otherwise enter any other letter: ");    //for continue buying tickets

            Ticket = input.next().charAt(0);

        } while ((Ticket == 'y') || (Ticket == 'Y'));                                               //valid for the capital and simple letter both
        System.out.println("\nThank you for buy tickets!");
        System.out.println("\n------------------------------------------------------------------------------------------");  //buy tickets border
    }
    //task4
    public static void print_seating_area(String[] row_1, String[] row_2, String[] row_3) {             //option 2 (print seating areas)
        System.out.print("\n~~~~~~~~~~~~~~~~~This is for printing seating areas!~~~~~~~~~~~~~~~~~");
        System.out.println();
        System.out.println();

        System.out.println("     ***********");    //stage pattern
        System.out.println("     *  STAGE  *");    //stage pattern
        System.out.println("     ***********");    //stage pattern

//------------------------------------------ ROW 1 ------------------------------------------------------------------
        System.out.print("    ");
        for (int i = 0; i < row_1.length / 2; i++) {                              //for row 1 first 6 seats (first half)
            if ("0".equals(row_1[i])) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }System.out.print(" ");
        for (int i = row_1.length / 2; i < row_1.length; i++) {                 //for row 1 second 6 seats (second half)
            if ("0".equals(row_1[i])) {
                System.out.print("O");
            } else if ("1".equals(row_1[i])) {
                System.out.print("X");
            }
        }System.out.println();

//------------------------------------------ ROW 2 ------------------------------------------------------------------
        System.out.print("  ");
        for (int i = 0; i < row_2.length / 2; i++) {                              //for row 2 first 8 seats (first half)
            if ("0".equals(row_2[i])) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }System.out.print(" ");
        for (int i = row_2.length / 2; i < row_2.length; i++) {                 //for row 2 second 8 seats (second half)
            if ("0".equals(row_2[i])) {
                System.out.print("O");
            } else if ("1".equals(row_2[i])) {
                System.out.print("X");
            }
        }System.out.println();

//------------------------------------------ ROW 3 ------------------------------------------------------------------
        for (int i = 0; i < row_3.length / 2; i++) {                             //for row 3 first 10 seats (first half)
            if ("0".equals(row_3[i])) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }System.out.print(" ");
        for (int i = row_3.length / 2; i < row_3.length; i++) {                //for row 3 second 10 seats (second half)
            if ("0".equals(row_3[i])) {
                System.out.print("O");
            } else if ("1".equals(row_3[i])) {
                System.out.print("X");
            }
        }System.out.println();
        System.out.println("\n");
        System.out.println("\n------------------------------------------------------------------------------------------");//print seating areas border
    }
    //----------------------------------------------------------------------------------------------------------------------
    //task5
    public static void cancel_ticket(String[] row_1, String[] row_2, String[] row_3) {              //option 3 (cancel tickets)
        System.out.print("\n~~~~~~~~~~~~~~~~~This is for the cancel tickets!~~~~~~~~~~~~~~~~~");
        System.out.println();
        char Ticket;
        do {
            int row_no;
            int seat_no;
            boolean x=true;
            do {
                    System.out.print("\nEnter row number: ");             //get inputs
                    row_no = input.nextInt();
                    if (row_no <= 3) {                                                        //check whether row number less than or equals to 3
                        System.out.println("Valid row number.");
                        x = false;
                    } else {
                        System.out.println("Invalid row number.");
                    }
            } while (x);
            while (true) {
                Scanner input = new Scanner(System.in);
                System.out.print("\nEnter seat number: ");                              //if row number in valid range, get the seat number
                seat_no = input.nextInt();

                if (row_no == 1 && (seat_no < 13 && seat_no > 0)) {       //check whether the ticket to be canceled is in row number 1, seat number less than 13 or more than 0
                    System.out.print("Valid seat number.\n ");          //check whether seat number in valid range or not
                    if ("0".equals(row_1[seat_no - 1])) {
                        System.out.println("\nThis seat is not booked");
                        break;
                    } else if ("1".equals(row_1[seat_no - 1])) {
                        row_1[seat_no - 1] = "0";
                        for(int i = 0; i < list.size(); i++){                                           //cancel tickets information from sort tickets and show ticket info part also
                            if(list.get(i).getRow() == row_no && list.get(i).getSeat() == seat_no){
                                list.remove(list.get(i));
                                break;
                            }
                        }System.out.println("\ncanceled");
                        break;
                    }
                } else if (row_no == 2 && (seat_no < 17 && seat_no > 0)) {            //check whether the ticket to be canceled is in row number 2, seat number less than 17 or more than 0
                    System.out.print("Valid seat number.\n ");
                    if ("0".equals(row_2[seat_no - 1])) {
                        System.out.println("\nThis seat has been canceled!");
                        break;
                    } else if ("1".equals(row_2[seat_no - 1])) {
                        row_2[seat_no - 1] = "0";
                        for(int i = 0; i < list.size(); i++){                                           //cancel tickets information from sort tickets and show ticket info part also
                            if(list.get(i).getRow() == row_no && list.get(i).getSeat() == seat_no){
                                list.remove(list.get(i));
                                break;
                            }
                        }System.out.println("\ncanceled");
                        break;
                    }
                } else if (row_no == 3 && (seat_no < 21 && seat_no > 0)) {            //check whether the ticket to be canceled is in row number 3, seat number less than 21 or more than 0
                    System.out.print("Valid seat number.\n ");
                    if ("0".equals(row_3[seat_no - 1])) {
                        System.out.println("\nThis seat has been canceled!");
                        break;
                    } else if ("1".equals(row_3[seat_no - 1])) {
                        row_3[seat_no - 1] = "0";
                        for(int i = 0; i < list.size(); i++){                                           //cancel tickets information from sort tickets and show ticket info part also
                            if(list.get(i).getRow() == row_no && list.get(i).getSeat() == seat_no){
                                list.remove(list.get(i));
                                break;
                            }
                        }System.out.println("\ncanceled");
                        break;
                    }
                } else{
                    System.out.println("Invalid Seat number");
                }
            }
            System.out.println("\n************** Canceled successfully! **************");
            System.out.println("You have successfully canceled SEAT NUMBER " + seat_no + " in ROW " + row_no);
            System.out.println("Money will be refunded.\n");
            System.out.print("If you want to cancel another ticket enter 'y' for yes otherwise enter any other letter:");  //for continue cancel tickets

            Ticket = input.next().charAt(0);

        } while ((Ticket == 'y') || (Ticket == 'Y'));
        System.out.println("\nThank you for buy tickets!");
        System.out.println(" ");
        System.out.println("\n------------------------------------------------------------------------------------------"); //cancel tickets border
    }
    //task6
    public static void show_available(String[] row_1, String[] row_2, String[] row_3) {         //option 4 (show available seats)
        int seat_no;
        System.out.print("\n~~~~~~~~~~~~~~~~~This is for the list of available seats!~~~~~~~~~~~~~~~~~");
        System.out.print("\n");
        System.out.print("\nSeats available in row_1: ");
        for (seat_no = 1; seat_no <= 12; seat_no++) {
            if ("0".equals(row_1[seat_no - 1])) {
                System.out.print(seat_no + " ");
            }
        }System.out.print("\n");
        System.out.print("\nSeats available in row_2: ");
        for (seat_no = 1; seat_no <= 16; seat_no++) {
            if ("0".equals(row_2[seat_no - 1])) {
                System.out.print(seat_no + " ");
            }
        }System.out.print("\n");
        System.out.print("\nSeats available in row_3: ");
        for (seat_no = 1; seat_no <= 20; seat_no++) {
            if ("0".equals(row_3[seat_no - 1])) {
                System.out.print(seat_no + " ");
            }
        }System.out.print("\n");
        System.out.println();
        System.out.println("\n------------------------------------------------------------------------------------------"); //show available seats border
    }
    //task7
    public static void save_files(String[] row1, String[] row2, String[] row3) {                        //option 5 (save available seats to the file)
        System.out.print("\n~~~~~~~~~~~~~~~~~This is for the save information!~~~~~~~~~~~~~~~~~\n");
        try {
            FileWriter fileWrite = new FileWriter("arr.txt");                       //file name (arr.text)

            fileWrite.write("\nrow 1" + " " + "seats = 12 " + " \t\t\tnow available seats ");
            fileWrite.write(Arrays.toString(row1));

            fileWrite.write("\nrow 2" + " " + "seats = 16 " + " \t\t\tnow available seats ");
            fileWrite.write(Arrays.toString(row2));

            fileWrite.write("\nrow 3" + " " + "seats = 20 " + " \t\t\tnow available seats ");
            fileWrite.write(Arrays.toString(row3));

            fileWrite.close();                                                            //always close file connection
            System.out.println("\nSUCCESSFULLY wrote to the file!( arr.text )");
        } catch (IOException ex) {
            System.err.println("\nThis file wasn't found!");
        }
        System.out.println();
        System.out.println("\n------------------------------------------------------------------------------------------"); //save files part border
    }
    //task8
    public static void load() {                                                             //option 6 (load available seats from saved file)
        System.out.print("\n~~~~~~~~~~~~~~~~~This is for the load from file!~~~~~~~~~~~~~~~~~\n");
        System.out.print("\n                            Available seats\n");
        try {
            File myObj = new File("arr.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("\nAn error occurred.");
            e.printStackTrace();

            System.out.print("\n");
        }
        System.out.print("\n");
        System.out.println();
        System.out.println("\n------------------------------------------------------------------------------------------"); //load from file border
    }
    /*----------------------------------------------------------------------------------------------------------------------
        task11 = Person.java (new class file)
        task12 = Ticket.java (new class file)
    ----------------------------------------------------------------------------------------------------------------------*/
    //task13
    public static void show_tickets_info() {                        //option 7 (show ticket information)
        System.out.print("\n~~~~~~~~~~~~~~~~~This is for the show ticket information!~~~~~~~~~~~~~~~~~\n");
        double t=0;
        for (Ticket value : list) {
            t += value.getPrice();
            value.print();
            System.out.println("\n");
        }
        System.out.println("\nTotal: "+t);//print total price
        System.out.println();
        System.out.println("\n------------------------------------------------------------------------------------------"); //show ticket info border
    }
    //task14
    public static void sort_ticket() {                   //option 8 (sort tickets)
        System.out.print("\n~~~~~~~~~~~~~~~~~This is for the sort ticket information!~~~~~~~~~~~~~~~~~");
        int len = list.size();
        Ticket sort;
        for (int i = 0; i < len - 1; i++) {                                                // outer loop
            for (int j = 0; j < len - 1; j++) {                                            // inner nested loop pointing 1 index ahead
                if (list.get(j).getPrice() > list.get(j + 1).getPrice()) {                 // checking elements
                    sort = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, sort);
                }
            }
        }
        System.out.println("\n");
        System.out.println("Sorted prices:");
        for (Ticket value : list)value.print();                                           // printing sorted array elements
        System.out.println();
        System.out.println("\n------------------------------------------------------------------------------------------"); //sort ticket info border
    }
}
