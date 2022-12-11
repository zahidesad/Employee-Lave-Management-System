package LeaveManangementSystem;

/**
 *
 * @author zahid
 */
public class CEO extends Users{
    
    public static void createEmployee(String firstName, String lastName, String username, Manager manager, String password){
    Company.createEmployee(firstName, lastName, username, manager, password);
    }
    
    public static void createManger(String firstName, String lastName, String username, String password){
    Company.createManager(firstName, lastName, username, password);

    }
    
    
    
}
