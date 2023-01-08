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
        for (Users user : Company.users) {
            if (user instanceof Employee && !(user instanceof Manager)) {
                Employee employee = (Employee) user;
                if (manager.getUsername().equalsIgnoreCase(employee.getManager().getUsername())) {
                    System.out.println("Name and surname are : " + Colors.GREEN_BOLD + employee.getFirstName() + " " + employee.getLastName()
                            + Colors.RESET + "\t\tAvailable Leaves : " + Colors.GREEN_BOLD + employee.getNumberOfLeavesLeft() + Colors.RESET
                            + "\t\t Used Leaves : " + Colors.GREEN_BOLD + employee.getUsedLeave() + Colors.RESET + "\n");
                }
            }
        }
    }

    //print all the leave viewLeaveRequests of employee (Manager)
    @Override
    public void viewLeaveRequests() {
        for (Users user : Company.users) {
            if (user instanceof Employee && !(user instanceof Manager)) {
                Employee employee = (Employee) user;
                System.out.println("\n\nName and surname are : " + Colors.GREEN_BOLD + employee.getFirstName() + " " + employee.getLastName()
                        + " wants " + employee.getNumberOfLeaveRequest() + " days leave to " + employee.leaveReason + "\n" + Colors.RESET);
            }
        }
    }

    //Confirmation for employee leave to be given or not (Manager)
    public void confirmationForEmployeeLeaves(Manager manager) {
        for (Employee responsbileEmployee : manager.getWhoIsResponsibleEmployees()) {
            if (responsbileEmployee.getNumberOfLeaveRequest() != 0) {
                System.out.println("\n\nName and surname are : " + Colors.GREEN_BOLD + responsbileEmployee.getFirstName() + " " + responsbileEmployee.getLastName()
                        + " wants " + responsbileEmployee.getNumberOfLeaveRequest() + " days leave to " + responsbileEmployee.leaveReason + "\n" + Colors.RESET);

                int a;
                System.out.println("\n\nPlease Select the action you want to do : ");
                System.out.println("1)Confirm " + "\n" + "2)Reject" + "\n" + "3)Quit");
                System.out.print(Colors.GREEN_BOLD + "\n\nYour Choice : " + Colors.RESET);
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

                        switch (responsbileEmployee.leaveReason) {
                            case "DEATH":
                                responsbileEmployee.setDeathCount(deduct + responsbileEmployee.getDeathCount());
                                break;
                            case "ILLNESS":
                                responsbileEmployee.setIllnessCount(deduct + responsbileEmployee.getIllnessCount());
                                break;
                            case "MARRIAGE":
                                responsbileEmployee.setMarriageCount(deduct + responsbileEmployee.getMarriageCount());
                                break;
                            case "OTHER":
                                responsbileEmployee.setOtherCount(deduct + responsbileEmployee.getOtherCount());
                                break;

                        }

                        System.out.println(Colors.GREEN_BOLD + "Leaves granted.\n" + Colors.RESET);
                        break;

                    // if manager rejects request    
                    case 2:
                        System.out.println(Colors.RED_BOLD + "Leaves Rejected.\n" + Colors.RESET);
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
    public void SetWhoIsResponsibleEmployees(Employee employee) {
        getWhoIsResponsibleEmployees().add(employee);

    }

    public ArrayList<Employee> getWhoIsResponsibleEmployees() {
        return WhoIsResponsibleEmployees;
    }

}
