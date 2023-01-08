package LeaveManangementSystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author zahid
 */
public class CEO extends Users {

    Scanner scan = new Scanner(System.in);

    public void createEmployee(String firstName, String lastName, String username, Manager manager,
            int numberOfLeavesLeft, int totalDayLeaveValue) {
        Company.createEmployee(firstName, lastName, username, manager, totalDayLeaveValue);
    }

    public void createManager(String firstName, String lastName, String username, int totalDayLeaveValue) {
        Company.createManager(firstName, lastName, username, totalDayLeaveValue);

    }

    public void removeEmployee(String removeUsername) {
        Company.removeEmployee(removeUsername);

    }

    public void removeManager(String removeUsername) {
        Company.removeManager(removeUsername);

    }

    public int SummationOfAllLeaves() {
        int total = 0;

        for (Users user : Company.users) {
            if (user instanceof Employee) {
                Employee employee = (Employee) user;
                total += employee.getUsedLeave();
            }
        }
        return total;
    }

    //print all the leave viewLeaveRequests of manager 
    @Override
    public void viewLeaveRequests() {
        for (Users user : Company.users) {
            if (user instanceof Manager) {
                Manager manager = (Manager) user;
                System.out.println("\n\nName and surname are : " + Colors.GREEN_BOLD + manager.getFirstName() + " " + manager.getLastName()
                        + " wants " + manager.getNumberOfLeaveRequest() + " days leave to " + manager.leaveReason + "\n" + Colors.RESET);
            }
        }
    }

    public void viewLeaveRequestStatistics() {
        int deathCount = 0;
        int illnessCount = 0;
        int marriageCount = 0;
        int otherCount = 0;
        for (Users user : Company.users) {
            if (user instanceof Employee employee) {
                deathCount += employee.getDeathCount();
                illnessCount += employee.getIllnessCount();
                marriageCount += employee.getMarriageCount();
                otherCount += employee.getOtherCount();

            }
        }
        System.out.println("Total leaves used in type of death : " + deathCount);
        System.out.println("Total leaves used in type of illness : " + illnessCount);
        System.out.println("Total leaves used in type of marriage : " + marriageCount);
        System.out.println("Total leaves used in type of other : " + otherCount);

    }
    // //Confirmation for manager leave to be given or not 
    public void confirmationForManagerLeaves(CEO ceo) {
        for (Users user : Company.users) {
            if (user instanceof Manager) {
                Manager manager = (Manager) user;
                if (manager.getNumberOfLeaveRequest() != 0) {
                    System.out.println("\n\nName and surname are : " + Colors.GREEN_BOLD + manager.getFirstName() + " " + manager.getLastName()
                            + " wants " + manager.getNumberOfLeaveRequest() + " days leave to " + manager.leaveReason + "\n" + Colors.RESET);

                    int a;
                    System.out.println("Please Select the action you want to do : ");
                    System.out.println("1)Confirm " + "\n" + "2)Reject" + "\n" + "3)Quit");
                    System.out.print(Colors.GREEN_BOLD + "\n\nYour Choice : " + Colors.RESET);
                    a = scan.nextInt();

                    switch (a) {
                        //if CEO confirms the request
                        case 1:
                            int leave = manager.getNumberOfLeavesLeft();
                            int deduct = manager.getNumberOfLeaveRequest();
                            leave -= deduct;

                            manager.updateLeave(leave);
                            int used = manager.getUsedLeave() + manager.getNumberOfLeaveRequest();

                            manager.setUsedLeave(used);
                            manager.setNumberOfLeaveRequest(0);

                            switch (manager.leaveReason) {
                                case "DEATH":
                                    manager.setDeathCount(deduct + manager.getDeathCount());
                                    break;
                                case "ILLNESS":
                                    manager.setIllnessCount(deduct + manager.getIllnessCount());
                                    break;
                                case "MARRIAGE":
                                    manager.setMarriageCount(deduct + manager.getMarriageCount());
                                    break;
                                case "OTHER":
                                    manager.setOtherCount(deduct + manager.getOtherCount());
                                    break;

                            }

                            System.out.println(Colors.GREEN_BOLD + "Leaves granted.\n" + Colors.RESET);
                            break;

                        // if manager rejects request    
                        case 2:
                            System.out.println(Colors.RED_BOLD + "Leaves Rejected.\n" + Colors.RESET);
                            manager.setNumberOfLeaveRequest(0);
                            break;

                        case 3:
                            System.out.println(Colors.GREEN_BOLD + "\n\nLogging out from the system..." + Colors.RESET);
                            break;
                        default:
                            break;

                    }

                } else {
                    continue;
                }
            }
        }
    }

    public void viewEmployeeWithPassword() {
        System.out.println(Colors.BLUE_BOLD + "\n\nEmployee List With Password :" + Colors.RESET);

        for (int i = 0; i < Company.users.size(); i++) {
            if (Company.users.get(i) instanceof Employee && !(Company.users.get(i) instanceof Manager)) {
                Employee employee = (Employee) Company.users.get(i);
                System.out.println(Colors.GREEN_BOLD + employee.getFirstName() + " " + employee.getLastName()
                        + Colors.RESET + "\t\tUsername is : " + Colors.GREEN_BOLD + employee.getUsername() + Colors.RESET
                        + "\t\tPassword is : " + Colors.GREEN_BOLD + employee.getPassword() + Colors.RESET);
            }
        }
    }

    public void viewManagerWithPassword() {
        System.out.println(Colors.BLUE_BOLD + "\n\nManager List With Password :" + Colors.RESET);

        for (int i = 0; i < Company.users.size(); i++) {
            if (Company.users.get(i) instanceof Manager) {
                Manager manager = (Manager) Company.users.get(i);
                System.out.println(Colors.GREEN_BOLD + manager.getFirstName() + " " + manager.getLastName()
                        + Colors.RESET + "\t\tUsername is : " + Colors.GREEN_BOLD + manager.getUsername() + Colors.RESET
                        + "\t\tPassword is : " + Colors.GREEN_BOLD + manager.getPassword() + Colors.RESET);

            }
        }
    }

    public void viewManagerWithoutPassword() {
        System.out.println(Colors.BLUE_BOLD + "\n\nManager List :" + Colors.RESET);
        int count = 1;
        for (int i = 0; i < Company.users.size(); i++) {
            if (Company.users.get(i) instanceof Manager) {
                Manager manager = (Manager) Company.users.get(i);
                System.out.println((count + ") " + manager.getFirstName() + " " + manager.getLastName()
                        + "\t-----> Number of emmployees responsible : " + manager.getWhoIsResponsibleEmployees().size()));
                count++;
            }

        }

    }

}
