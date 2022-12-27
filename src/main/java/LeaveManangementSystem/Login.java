package LeaveManangementSystem;

/**
 *
 * @author zahid
 */
public class Login {

    //CEO verification
    public CEO checkCeo(String username, String password) {
        for (Users user : Company.users) {
            if (user instanceof CEO) {
                CEO ceo = (CEO) user;
                if (username.equalsIgnoreCase(ceo.getUsername()) && password.equals(ceo.getPassword())) {
                    System.out.println(ConsoleColorsCode.GREEN + "\nLogin successful you are redirected to the CEO screen..." + ConsoleColorsCode.RESET);
                    System.out.print(ConsoleColorsCode.GREEN + "\n----------Welcome " + username + "----------" + ConsoleColorsCode.RESET);
                    return ceo;
                }
            }

        }

        return null;

    }

    //Manager verification
    public Manager checkManager(String username, String password) {
        for (Users user : Company.users) {
            if (user instanceof Manager) {
                Manager checkManager = (Manager) user;
                if (username.equalsIgnoreCase(checkManager.getUsername()) && password.equals(checkManager.getPassword())) {

                    return checkManager;
                }

            }
        }

        return null;
    }

    //Employee verification
    public Employee checkEmployee(String username, String password) {
        for (Users user : Company.users) {
            if (user instanceof Employee && !(user instanceof Manager)) {
                Employee checkEmployee = (Employee) user;
                if (username.equalsIgnoreCase(checkEmployee.getUsername())
                        && password.equals(checkEmployee.getPassword())) {

                    return checkEmployee;

                }
            }
        }

        return null;
    }

}
