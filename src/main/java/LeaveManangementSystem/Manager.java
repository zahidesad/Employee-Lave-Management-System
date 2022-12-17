package LeaveManangementSystem;

import java.util.ArrayList;

/**
 *
 * @author zahid
 */
public class Manager extends Employee {
    private ArrayList<Employee> WhoIsResponsibleEmployees = new ArrayList();  
    
    //Beginning of the Constructor
    public Manager(String firstName, String lastName, String username,
            int totalDayLeaveValue){
        super(firstName, lastName, username, totalDayLeaveValue);
        this.totalDayLeaveValue = totalDayLeaveValue;
        numberOfLeavesLeft = totalDayLeaveValue;
    
    }
    public Manager(){
    }
    //End of the Constructor
    

    //Used to determine which employee will work under which manager   
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
