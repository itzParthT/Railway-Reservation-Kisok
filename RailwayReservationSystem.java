import java.util.Scanner;

class PassengerDetails {
    String name;
    int train_num;
    int num_of_seats;

    PassengerDetails(String name, int train_num, int num_of_seats) {
        this.name = name;
        this.train_num = train_num;
        this.num_of_seats = num_of_seats;
    }
}

public class RailwayReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu_choice;

        System.out.println("\t\t===============================================");
        System.out.println("\t\t                                              ");
        System.out.println("\t\t        -----------------------------         ");
        System.out.println("\t\t         Railway Reservation System           ");
        System.out.println("\t\t        -----------------------------         ");
        System.out.println("\t\t                                              ");
        System.out.println("\t\t                                              ");
        System.out.println("\t\t         Presented by:-                       ");
        System.out.println("\t\t              Parth Tagadpallewar             ");
        System.out.println("\t\t                                              ");
        System.out.println("\t\t===============================================");

        System.out.print("\n Press any key to continue: ");
       // sc.nextLine();
        sc.nextLine(); // This is to clear the newline character from the buffer.

        while (true) {
            clearScreen();
            System.out.println("\n=================================");
            System.out.println("    TRAIN RESERVATION SYSTEM");
            System.out.println("=================================");
            System.out.println("1 Reserve A Ticket");
            System.out.println("------------------------");
            System.out.println("2 View All Available Trains");
            System.out.println("------------------------");
            System.out.println("3 Exit");
            System.out.println("------------------------");
            System.out.print("\nEnter the option: ");

            menu_choice = sc.nextInt();
            sc.nextLine(); // Consume newline character.

            switch (menu_choice) {
                case 1:
                    reservation(sc);
                    break;
                case 2:
                    viewDetails();
                    System.out.print("\nPress Enter to go back to Main Menu...");
                    sc.nextLine(); // Wait for Enter key.
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice");
                    break;
            }
        }
    }

    public static void viewDetails() {
        clearScreen();
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Tr.No\tName\t\t\tDestinations\t\tCharges\t\tTime");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("1000\tKolhapur Express  \tPurna to Kolhapur  \tRs.5000\t\t6am");
        System.out.println("1001\tDevgiri Express   \tNanded to Pune     \tRs.5000\t\t9am");
        System.out.println("1002\tChennai Express   \tMumbai to Chennai  \tRs.5000\t\t12pm");
        System.out.println("1003\tPune City Express \tNanded to Pune     \tRs.4500\t\t8am");
        System.out.println("1004\tNandigram Express \tNanded to Mumbai   \tRs.4500\t\t11am");
        System.out.println("1005\tHigh Court        \tManmad to Nanded   \tRs.4000\t\t7am");
        System.out.println("1006\tSach khand Express\tNanded to Amrutsar \tRs.4000\t\t9.30am");
        System.out.println("1007\tPanvel Express        \tNanded to Panvel   \tRs.3500\t\t1pm");
        System.out.println("1008\tHaidrabad Express     \tNanded to Haidrabad\tRs.3500\t\t4pm");
        System.out.println("1009\tNagarsol Express      \tNanded to Miami    \tRs.6000\t\t3.35pm");
        System.out.println("1010\tLokmanya Tilak Express\tMumbai to Kolkatta \tRs.6000\t\t4.15pm");
    }

    public static void reservation(Scanner sc) {
        char confirm;
        int train_num;
        float charges;

        clearScreen();
        System.out.print("\nEnter Your Name: ");    
        String name = sc.nextLine();

        System.out.print("\nEnter Number of seats: ");
        int num_of_seats = sc.nextInt();

        sc.nextLine(); // Consume newline character.

        clearScreen();
        viewDetails();
        System.out.print("\nEnter train number: ");
        train_num = sc.nextInt();

        charges = charge(train_num, num_of_seats);

        printTicket(name, num_of_seats, train_num, charges);

        System.out.print("\n\nConfirm Ticket (y/n): ");
        confirm = sc.next().charAt(0);

        if (confirm == 'y' || confirm == 'Y') {
            System.out.println("==================");
            System.out.println(" Reservation Done");
            System.out.println("==================");
            System.out.print("\nPress Enter to go back to Main Menu...");
            sc.nextLine(); // Consume newline character.
        } else {
            System.out.println("Reservation Not Done!");
            System.out.print("Press Enter to go back to Main Menu...");
            sc.nextLine(); // Consume newline character.
        }
    }

    public static void printTicket(String name, int num_of_seats, int train_num, float charges) {
        clearScreen();
        System.out.println("    -------------------");
        System.out.println("\t       TICKET");
        System.out.println("    -------------------");
        System.out.println("Name:\t\t\t" + name);
        System.out.println("Number Of Seats:\t" + num_of_seats);
        System.out.println("Train Number:\t\t" + train_num);
        specificTrain(train_num);
        System.out.println("Charges:\t\t" + charges);
    }

    public static void specificTrain(int train_num) {
        String trainName = "";
        String destination = "";
        String departure = "";

        switch (train_num) {
            case 1000:
                trainName = "Kolhapur Express";
                destination = "Purna to Kolhapur";
                departure = "9am";
                break;
            case 1001:
                trainName = "Devgiri Express";
                destination = "Nanded to Pune";
                departure = "12pm";
                break;
            case 1002:
                trainName = "Chennai Express";
                destination = "Mumbai to Chennai";
                departure = "8am";
                break;
            case 1003:
                trainName = "Pune City Express";
                destination = "Nanded to Pune";
                departure = "11am";
                break;
            case 1004:
                trainName = "Nandigram Express";
                destination = "Nanded to Mumbai";
                departure = "7am";
                break;
            case 1005:
                trainName = "High Court";
                destination = "Manmad to Nanded";
                departure = "9.30am";
                break;
            case 1006:
                trainName = "Sach khand Express";
                destination = "Nanded to Amrutsar";
                departure = "1pm";
                break;
            case 1007:
                trainName = "Panvel Express";
                destination = "Nanded to Panvel";
                departure = "4pm";
                break;
            case 1008:
                trainName = "Haidrabad Express";
                destination = "Nanded to Haidrabad";
                departure = "3.35pm";
                break;
            case 1009:
                trainName = "Nagarsol Express";
                destination = "Nanded to Miami";
                departure = "1.15";
                break;
            case 1010:
                trainName = "Lokmanya Tilak Express";
                destination = "Mumbai to Kolkatta";
                departure = "1.15";
                break;
        }

        System.out.println("Train:\t\t\t" + trainName);
        System.out.println("Destination:\t\t" + destination);
        System.out.println("Departure:\t\t" + departure);
    }

    public static float charge(int train_num, int num_of_seats) {
        switch (train_num) {
            case 1000:
            case 1001:
                return 5000.0f * num_of_seats;
            case 1002:
            case 1003:
                return 4500.0f * num_of_seats;
            case 1004:
            case 1005:
            case 1006:
                return 4000.0f * num_of_seats;
            case 1007:
            case 1008:
                return 3500.0f * num_of_seats;
            case 1009:
            case 1010:
                return 6000.0f * num_of_seats;
            default:
                return 0.0f;
        }
    }

    public static void clearScreen() {
        System.out.print("");
        System.out.flush();
    }
}
