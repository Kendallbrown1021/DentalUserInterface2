import java.time.Month;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        UIManager manager = new UIManager();
        calendar.initializeApplication();
        manager.startUI();
        //calendar.startUI();
    }
}


class Calendar {
    public final HashMap<Enum, HashMap<Integer, HashMap<String, String>>> monthMap = new HashMap<>(); //HashMap of the months as keys and the dayMap as the value
    public  HashMap<String, String> appointmentMap = new HashMap<>(); //HashMap of the appointment times for a given day and the purpose of the appointment
    private final HashMap<Integer, HashMap<String, String>> janDays = new HashMap<>(); //HashMap of the days of the month as the key and the appointmentMap as the value
    private final HashMap<Integer, HashMap<String, String>> febDays = new HashMap<>();
    private final HashMap<Integer, HashMap<String, String>> marchDays = new HashMap<>();
    private final HashMap<Integer, HashMap<String, String>> aprDays = new HashMap<>();
    private final HashMap<Integer, HashMap<String, String>> mayDays = new HashMap<>();
    private final HashMap<Integer, HashMap<String, String>> juneDays = new HashMap<>();
    private final HashMap<Integer, HashMap<String, String>> julyDays = new HashMap<>();
    private final HashMap<Integer, HashMap<String, String>> augustDays = new HashMap<>();
    private final HashMap<Integer, HashMap<String, String>> septemberDays = new HashMap<>();
    private final HashMap<Integer, HashMap<String, String>> octoberDays = new HashMap<>();
    private final HashMap<Integer, HashMap<String, String>> novemberDays = new HashMap<>();
    private final HashMap<Integer, HashMap<String, String>> decemberDays = new HashMap<>();


    public void populateAppointment() {
        //Dummy Data to be loaded into the hashmap
        appointmentMap.put("6:00 AM - 6:15 AM", "Clock In");
    }

    public void populateMonths() {

        /* Loops through each month of the year using index 1-13.
            applies the i variable to a switch case that goes through each month
            and then loops over the days of that month to create the hashmap of days for each month and stores the
            dummy appointment  data  for each day key
         */
        for (int i = 1; i < 13; i++) {
            Month month = Month.of(i);
            int newMonth = month.length(false);
            switch (i) {
                case 1:

                    for (int j = 1; j <= newMonth; j++) {
                        janDays.put(j, appointmentMap);
                        //System.out.println("hello");
                        monthMap.put(month, janDays);
                    }
                    break;
                case 2:

                    for (int j = 1; j <= newMonth; j++) {
                        febDays.put(j, appointmentMap);
                        //System.out.println("hello");
                        monthMap.put(month, febDays);
                    }
                    break;
                case 3:

                    for (int j = 1; j <= newMonth; j++) {
                        marchDays.put(j, appointmentMap);
                        //System.out.println("hello");
                        monthMap.put(month, marchDays);
                    }
                    break;
                case 4:

                    for (int j = 1; j <= newMonth; j++) {
                        aprDays.put(j, appointmentMap);
                        //System.out.println("hello");
                        monthMap.put(month, aprDays);
                    }
                    break;
                case 5:

                    for (int j = 1; j <= newMonth; j++) {
                        mayDays.put(j, appointmentMap);
                        //System.out.println("hello");
                        monthMap.put(month, mayDays);
                    }
                    break;
                case 6:

                    for (int j = 1; j <= newMonth; j++) {
                        juneDays.put(j, appointmentMap);
                        //System.out.println("hello");
                        monthMap.put(month, juneDays);
                    }
                    break;
                case 7:

                    for (int j = 1; j <= newMonth; j++) {
                        julyDays.put(j, appointmentMap);
                        //System.out.println("hello");
                        monthMap.put(month, julyDays);
                    }
                    break;
                case 8:

                    for (int j = 1; j <= newMonth; j++) {
                        augustDays.put(j, appointmentMap);
                        //System.out.println("hello");
                        monthMap.put(month, augustDays);
                    }
                    break;
                case 9:

                    for (int j = 1; j <= newMonth; j++) {
                        septemberDays.put(j, appointmentMap);
                        //System.out.println("hello");
                        monthMap.put(month, septemberDays);
                    }
                    break;
                case 10:

                    for (int j = 1; j <= newMonth; j++) {
                        octoberDays.put(j, appointmentMap);
                        //System.out.println("hello");
                        monthMap.put(month, octoberDays);
                    }
                    break;
                case 11:

                    for (int j = 1; j <= newMonth; j++) {
                        novemberDays.put(j, appointmentMap);
                        //System.out.println("hello");
                        monthMap.put(month, novemberDays);
                    }
                    break;
                case 12:

                    for (int j = 1; j <= newMonth; j++) {
                        decemberDays.put(j, appointmentMap);
                        //System.out.println("hello");
                        monthMap.put(month, decemberDays);
                    }
                    break;
            }
        }
    }

    /* *************************************************
    Initializes the Calendar data
    ****************************************************
     */
    public void initializeApplication() {
        populateAppointment();
        populateMonths();
    }

    /* *************************************************
    Starts the UI command line prompt to select next action to be taken and returns to main menu after completion or
    exits the application when 4 is entered.
    ************************************************ */


    /* **********************************************************
    Class for managing appointments

    -add Appointments
    -delete appointments

    **************************************************************
     */
    class AppointmentManager {

        /* *******************************************************
        Method for adding a new appointment to the calendar
         ********************************************************** */
        public void addAppointment(String month,int day, String purpose, String timeSlot ){

            Month myMonth = Month.of(Integer.parseInt(month));

            Appointment newAppointment = new Appointment(purpose,timeSlot,Integer.parseInt(month),day);

            if(monthMap.containsKey(myMonth)){

                HashMap<Integer, HashMap<String, String>> dayMap = monthMap.get(myMonth);

                Map<String, String> purposeMap = dayMap.get(newAppointment.day);

                purposeMap.put(newAppointment.timeSlot,newAppointment.purpose);

            }else{
                System.out.println("""
                    Please enter the month of the appointment. : 
                    1. January
                    2. February
                    3. March
                    4. April
                    5. May
                    6. June
                    7. July
                    8. August
                    9. September
                    10. October
                    11. November
                    12. December
                    """);
            }
        }

         /* *******************************************************
        Method for canceling an appointment, deletes it from the calendar
         ********************************************************** */

        public void deleteAppointment(String month, int day, String timeSlot){

            Month myMonth = Month.of(Integer.parseInt(month));

            if(monthMap.containsKey(myMonth)) {

                HashMap<Integer, HashMap<String, String>> myMonthMap = monthMap.get(myMonth);

                Map<String, String> DayMap = myMonthMap.get(day);

                DayMap.remove(timeSlot);

            }else{
                System.out.println("Please enter a valid month (ex. January, February): ");
            }
        }
    }
}

class UIManager extends Calendar {
         /* *************************************************
    Starts the UI command line prompt to select next action to be taken and returns to main menu after completion or
    exits the application when 4 is entered.
    ************************************************ */

    public void startUI() {

        Scanner scanner = new Scanner(System.in);

        Calendar.AppointmentManager myAppointment = new Calendar.AppointmentManager();

        System.out.println("""
                Hello!
                What would you like to do today?:
                
                1: Add Appointment
                
                2: Cancel Appointment
                
                3: View Appointments
                
                4: Exit
                
                Please enter 1, 2, 3, or 4:
                """);

        String Input = scanner.nextLine();

        int userInput = Integer.parseInt((Input));

        if (userInput == 1) {
            //add appointment case takes user input and stores it in variables which are then passed to the my appointment object to create a new appointment
            System.out.println("""
                    Please enter the month of the appointment. :
                    1. January
                    2. February
                    3. March
                    4. April
                    5. May
                    6. June
                    7. July
                    8. August
                    9. September
                    10. October
                    11. November
                    12. December
                    """);
            String month = scanner.nextLine();

            System.out.println("Please enter the day you would like to schedule: ");

            int day = Integer.parseInt(scanner.nextLine());

            System.out.println("Please enter the purpose of the Appointment: ");

            String purpose = scanner.nextLine();

            System.out.println(" Please enter time  for the appointment (Ex. 11:00 AM - 11:15 AM):");

            String timeSlot = scanner.nextLine();

            myAppointment.addAppointment(month, day, purpose, timeSlot);

            System.out.println("Appointment scheduled");

            startUI();
        }
        if (userInput == 2) {
            //delete appointment case takes user input and passes it to the my appointment object which deletes the entry from the hashmap object
            System.out.println("""
                    Please enter the month of the appointment. :
                    1. January
                    2. February
                    3. March
                    4. April
                    5. May
                    6. June
                    7. July
                    8. August
                    9. September
                    10. October
                    11. November
                    12. December
                    """);
            String month = scanner.nextLine();

            System.out.println("Please enter the day: ");

            int day = Integer.parseInt(scanner.nextLine());

            System.out.println(" Please enter time for the appointment (Ex. 11:00 AM - 11:15 AM):");

            String timeSlot = scanner.nextLine();

            myAppointment.deleteAppointment(month, day, timeSlot);

            System.out.println("Appointment Canceled.");

            startUI();

        }if(userInput == 3) {
            //View Appointments for the day
            System.out.println("""
                    Please enter the month of the appointment. :
                    1. January
                    2. February
                    3. March
                    4. April
                    5. May
                    6. June
                    7. July
                    8. August
                    9. September
                    10. October
                    11. November
                    12. December
                    """);

            String month = scanner.nextLine();

            Month viewMonth = Month.of(Integer.parseInt(month));

            System.out.println("Please enter the day: ");

            int day = Integer.parseInt(scanner.nextLine());

            System.out.println("*********"+ "\n"+ monthMap.get(viewMonth).get(day) + "\n" + "**********");

            startUI();
        } if(userInput == 4){

            System.exit(0);
        } else {
            System.out.println("""
                    Please enter the month of the appointment. : 
                    1. January
                    2. February
                    3. March
                    4. April
                    5. May
                    6. June
                    7. July
                    8. August
                    9. September
                    10. October
                    11. November
                    12. December
                    """);

            startUI();
        }
    }

}
/* *******************************************************
       Appointment class for initializing a new appointment obj
 ********************************************************** */
class Appointment {
    public String purpose;
    public String timeSlot;
    public Integer month;
    public int day;

    public Appointment(String purpose, String timeSlot, int month, int day){
        this.day =day;
        this.month = month;
        this.purpose = purpose;
        this.timeSlot = timeSlot;

    }
}
