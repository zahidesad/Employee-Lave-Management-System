package LeaveManangementSystem;

/**
 *
 * @author zahid
 */
public class Login {

    //CEO verification
    public CEO checkCeo(String username, String password) {
        Company.ceo.setUsername("admin");
        Company.ceo.setPassword("123");
        if (username.equalsIgnoreCase(Company.ceo.getUsername()) && password.equals(Company.ceo.getPassword())) {
            System.out.println(ConsoleColorsCode.GREEN+ "\nLogin successful you are redirected to the CEO screen..." + ConsoleColorsCode.RESET);
            System.out.print(ConsoleColorsCode.GREEN+"\n----------Welcome " + username + "----------"+ConsoleColorsCode.RESET);
            return Company.ceo;
        }
        return null;

    }

    //Manager verification
    public Manager checkManager(String username, String password) {
        for (Manager checkManager : Company.managers) {
            if (username.equalsIgnoreCase(checkManager.getUsername()) && password.equals(checkManager.getPassword())) {

                return checkManager;
            }

        }

        return null;
    }

    //Employee verification
    public Employee checkEmployee(String username, String password) {
        for (Employee checkEmployee : Company.employees) {
            if (username.equalsIgnoreCase(checkEmployee.getUsername())
                    && password.equals(checkEmployee.getPassword())) {

                return checkEmployee;

            }
        }

        return null;
    }

}
