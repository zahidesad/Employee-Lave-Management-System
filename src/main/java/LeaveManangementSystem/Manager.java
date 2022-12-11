package LeaveManangementSystem;

import java.util.ArrayList;

/**
 *
 * @author zahid
 */
public class Manager extends Users {

    private static ArrayList<Employee> WhoIsResponsibleEmployees = new ArrayList();

    void WhoIsResponsibleEmployees(Employee employee) {
        getWhoIsResponsibleEmployees().add(employee);

    }

    void viewEmployeeWithPassword(ArrayList<Employee> employeeDetails) {
        System.out.println("Employee List With Password");

        for (Employee employeeDetail : employeeDetails) {
            System.out.println("Name and surname are : " + employeeDetail.getFirstName() + employeeDetail.getLastName()
                    + "\t\tUsername is : " + employeeDetail.getUsername() + "\t\tPassword is : " + employeeDetail.getPassword());
        }

    }

    //Beggining of encapsulation
    public static ArrayList<Employee> getWhoIsResponsibleEmployees() {
        return WhoIsResponsibleEmployees;
    }

    public static void setWhoIsResponsibleEmployees(ArrayList<Employee> aWhoIsResponsibleEmployees) {
        WhoIsResponsibleEmployees = aWhoIsResponsibleEmployees;
    }
    //End of encapsulation

}
