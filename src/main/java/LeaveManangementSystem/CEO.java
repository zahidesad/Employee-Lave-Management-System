package LeaveManangementSystem;

import java.util.ArrayList;

/**
 *
 * @author zahid
 */
public class CEO extends Users {

    public  void createEmployee(String firstName, String lastName, String username, Manager manager,
            int numberOfLeavesLeft, int totalDayLeaveValue) {
        Company.createEmployee(firstName, lastName, username, manager, totalDayLeaveValue);
    }

    public  void createManager(String firstName, String lastName, String username,int totalDayLeaveValue) {
        Company.createManager(firstName, lastName, username, totalDayLeaveValue);

    }
    public void removeEmployee(){
    
    }
    public void removeManager(){
    
    }

    public void viewEmployeeWithPassword(ArrayList<Employee> employeeDetails) {
        System.out.println(ConsoleColorsCode.BLUE_BOLD+"\n\nEmployee List With Password" + ConsoleColorsCode.RESET);

        for (Employee employeeDetail : employeeDetails) {
            System.out.println(ConsoleColorsCode.GREEN_BOLD + employeeDetail.getFirstName()+ " " + employeeDetail.getLastName()+
                    ConsoleColorsCode.RESET+ "\t\tUsername is : "+ConsoleColorsCode.GREEN_BOLD + employeeDetail.getUsername() + ConsoleColorsCode.RESET+
                    "\t\tPassword is : "+ConsoleColorsCode.GREEN_BOLD + employeeDetail.getPassword() +ConsoleColorsCode.RESET);
        }

    }

    public void viewManagerWithPassword(ArrayList<Manager> managerDetails) {
        System.out.println(ConsoleColorsCode.BLUE_BOLD+"\n\nManager List With Password :"+ConsoleColorsCode.RESET);

        for (Manager managerDetail : managerDetails) {
            System.out.println(ConsoleColorsCode.GREEN_BOLD + managerDetail.getFirstName()+ " " + managerDetail.getLastName()+
                   ConsoleColorsCode.RESET + "\t\tUsername is : "+ ConsoleColorsCode.GREEN_BOLD + managerDetail.getUsername() + ConsoleColorsCode.RESET+
                    "\t\tPassword is : "+ConsoleColorsCode.GREEN_BOLD + managerDetail.getPassword()+ConsoleColorsCode.RESET);

        }

    }

    public void viewManagerWithoutPassword() {
        System.out.println(ConsoleColorsCode.BLUE_BOLD+"\n\nManager List :"+ConsoleColorsCode.RESET);

        for (int i = 0; i < Company.managers.size(); i++) {
            System.out.println((i + 1) + ") " + Company.managers.get(i).getFirstName() +" "+ Company.managers.get(i).getLastName()
                    + "\t-----> Number of emmployees responsible : " + Company.managers.get(i).getWhoIsResponsibleEmployees().size());

        }

    }

}
