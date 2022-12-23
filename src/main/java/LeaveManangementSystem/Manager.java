package LeaveManangementSystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author zahid
 */
public class Manager extends Employee {
    
    Scanner scan = new Scanner(System.in);

    private ArrayList<Employee> WhoIsResponsibleEmployees = new ArrayList();

    //Beginning of the Constructor
    public Manager(String firstName, String lastName, String username,
            int totalDayLeaveValue) {
        super(firstName, lastName, username, totalDayLeaveValue);
        this.totalDayLeaveValue = totalDayLeaveValue;
        numberOfLeavesLeft = totalDayLeaveValue;

    }

    public Manager() {
    }
    //End of the Constructor

    //it is showing all employee names, available leaves and used leaves (Manager)
    public void viewEmployee(Manager manager) {
        for (Employee employee : Company.employees) {
            if (manager.getUsername().equalsIgnoreCase(employee.getManager().getUsername())) {
                System.out.println("Name and surname are : " + ConsoleColorsCode.GREEN_BOLD + employee.getFirstName() + " " + employee.getLastName()
                        + ConsoleColorsCode.RESET + "\t\tAvailable Leaves : " + ConsoleColorsCode.GREEN_BOLD + employee.getNumberOfLeavesLeft() + ConsoleColorsCode.RESET
                        + "\t\t Used Leaves : " + ConsoleColorsCode.GREEN_BOLD + employee.getUsedLeave() + ConsoleColorsCode.RESET + "\n");
            }

        }
    }
    
    //print all the leave viewLeaveRequests of employee (Manager)
    @Override
    public void viewLeaveRequests() {
        for (Employee employee : Company.employees) {
            System.out.println(ConsoleColorsCode.GREEN_BOLD + employee.getFirstName() + " " + employee.getLastName()
                    + " wants for " + employee.getNumberOfLeaveRequest() + " days leave" + ConsoleColorsCode.RESET + "\n");
        }

    }
    
    //Confirmation for employee leave to be given or not (Manager)
    public void confirmationForEmployeeLeaves(Manager manager) {
        for (Employee responsbileEmployee : manager.getWhoIsResponsibleEmployees()) {
            if (responsbileEmployee.getNumberOfLeaveRequest() != 0) {
                System.out.println(ConsoleColorsCode.GREEN_BOLD + responsbileEmployee.getFirstName() + " " + responsbileEmployee.getLastName()
                        + " wants for " + responsbileEmployee.getNumberOfLeaveRequest() + " days leave" + ConsoleColorsCode.RESET + "\n");

                int a;
                System.out.println("\n\nPlease Select the action you want to do : ");
                System.out.println("1)Confirm " + "\n" + "2)Reject" + "\n" + "3)Quit");
                a = scan.nextInt();

                switch (a) {
                    //if manager confirms the request
                    case 1:
                        int leave = responsbileEmployee.getNumberOfLeavesLeft();
                        int deduct = responsbileEmployee.getNumberOfLeaveRequest();
                        leave -= deduct;

                        responsbileEmployee.updateLeave(leave);
                        int used = responsbileEmployee.getUsedLeave() + responsbileEmployee.getNumberOfLeaveRequest();

                        responsbileEmployee.setUsedLeave(used);
                        responsbileEmployee.setNumberOfLeaveRequest(0);
                        System.out.println(ConsoleColorsCode.GREEN_BOLD+ "Leaves granted.\n" + ConsoleColorsCode.RESET);
                        break;

                    // if manager rejects request    
                    case 2:
                        System.out.println(ConsoleColorsCode.RED_BOLD+ "Leaves Rejected.\n" + ConsoleColorsCode.RESET);
                        responsbileEmployee.setNumberOfLeaveRequest(0);
                        break;

                    case 3:
                        System.out.println("Logging out from the system...");
                        break;
                    default:
                        break;

                }

            } else {
                continue;
            }
        }

    }

    //Used to determine which employee will work under which manager   
    void SetWhoIsResponsibleEmployees(Employee employee) {
        getWhoIsResponsibleEmployees().add(employee);

    }

    //Beggining of encapsulation
    public ArrayList<Employee> getWhoIsResponsibleEmployees() {
        return WhoIsResponsibleEmployees;
    }

    public void setWhoIsResponsibleEmployees(ArrayList<Employee> aWhoIsResponsibleEmployees) {
        WhoIsResponsibleEmployees = aWhoIsResponsibleEmployees;
    }
    //End of encapsulation

}
