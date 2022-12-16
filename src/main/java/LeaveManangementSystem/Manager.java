package LeaveManangementSystem;

import java.util.ArrayList;

/**
 *
 * @author zahid
 */
public class Manager extends Employee {

    private ArrayList<Employee> WhoIsResponsibleEmployees = new ArrayList();

    void WhoIsResponsibleEmployees(Employee employee) {
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
