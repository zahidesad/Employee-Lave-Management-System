package LeaveManangementSystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author zahid
 */
public class Test {

    Login login;

    //Constructor for initializing objects
    public Test() {
        login = new Login();
    }

    public static void main(String[] args) {

        CEO ceo = new CEO();
        ceo.setUsername("admin");
        ceo.setPassword("123");
        Company.users.add(ceo);

        Test test = new Test();
        test.Display();

    }

    void Display() {
        Scanner scan = new Scanner(System.in);
        String username, password;
        int a = 0;
        int total = 0;

        System.out.println("\n\nSelect any one for login procedure\n\n" + "1.CEO \n" + "2.Manager \n" + "3.Employee");
        System.out.print(ConsoleColorsCode.GREEN_BOLD + "\n\nPlease enter your choice : " + ConsoleColorsCode.RESET);

        try {
            a = scan.nextInt();
            System.out.print("\nEnter Username : ");
            username = scan.next();
            System.out.print("Enter Password : ");
            password = scan.next();

            switch (a) {
                case 1:
                    CEO ceo = login.checkCeo(username, password); // Login verification for CEO
                    if (ceo == null) {
                        System.out.println(ConsoleColorsCode.RED_BOLD + "\n\nWrong usernme or password. Try again!" + ConsoleColorsCode.RESET);
                        Display();
                    }

                    while (ceo != null) {

                        System.out.println("""
                                           \n1)Press to add manager or employee
                                           2)Press to remove manager or employee
                                           3)Press to view Manager Requests
                                           4)Press to grant report manager
                                           5)Press to view report of managers
                                           6)Press to view report of employees
                                           7)Press to view all used leaves
                                           8)Press to logout""");

                        System.out.print(ConsoleColorsCode.GREEN_BOLD + "\n\nPlease enter your choice : " + ConsoleColorsCode.RESET);
                        a = scan.nextInt();

                        switch (a) {

                            case 1:
                                System.out.println("\n\nPress 1 to add Manager || Press 2 to add Employee\n");
                                System.out.print(ConsoleColorsCode.GREEN_BOLD + "\n\nPlease enter your choice : " + ConsoleColorsCode.RESET);

                                a = scan.nextInt();

                                switch (a) {
                                    case 1 -> { // Creates Manager
                                        System.out.print("\nPlease write your manager's name :  ");
                                        String firstName = scan.nextLine();
                                        firstName = scan.nextLine();

                                        System.out.print("Please write your manager's first last name : ");
                                        String lastName = scan.nextLine();

                                        String ManagerUsername = firstName + lastName;

                                        System.out.print("Please enter your manager's total annual leave entitlement : ");
                                        int totalDayLeaveValue = scan.nextInt();

                                        ceo.createManager(firstName, lastName, ManagerUsername, totalDayLeaveValue);
                                        Company.users.get(Company.users.size() - 1);
                                        System.out.println("\n\nYour manager's username is " + '"' + ConsoleColorsCode.GREEN_BOLD + ManagerUsername + ConsoleColorsCode.RESET + '"'
                                                + "\t\tYour manager's password is " + '"' + ConsoleColorsCode.GREEN_BOLD + Company.users.get(Company.users.size() - 1).getPassword() + ConsoleColorsCode.RESET + '"'
                                                + ConsoleColorsCode.GREEN_BOLD + "\n\n!!!!!Please forward this informations to your employee so that he/she can log into the system!!!!!!"
                                                + ConsoleColorsCode.RESET);

                                        continue;
                                    }
                                    case 2 -> { //Creates Employee

                                        int managerCount = 0;
                                        for (Users user : Company.users) {
                                            if (user instanceof Manager) {
                                                managerCount++;
                                            }
                                        }

                                        if (managerCount != 0) {
                                            System.out.print("\n\nPlease write your employee's name :  ");
                                            String firstName = scan.nextLine();
                                            firstName = scan.nextLine();

                                            System.out.print("Please write your employee's last name : ");
                                            String lastName = scan.nextLine();

                                            String EmployeeUsername = firstName + lastName;

                                            System.out.print("Please enter your employee's total annual leave entitlement : ");
                                            int totalDayLeaveValue = scan.nextInt();

                                            ceo.viewManagerWithoutPassword();

                                            System.out.print("\n\nSelect the manager who will be responsible for the employee : ");
                                            a = scan.nextInt();

                                            Manager manager = null;
                                            ArrayList<Manager> managers = new ArrayList();
                                            for (Users user : Company.users) {

                                                if (user instanceof Manager) {
                                                    managers.add((Manager) user);

                                                }

                                            }
                                            manager = managers.get(a - 1);

                                            Company.createEmployee(firstName, lastName, EmployeeUsername, manager, totalDayLeaveValue);
                                            System.out.println("\n\nYour employee's username is " + '"' + ConsoleColorsCode.GREEN_BOLD + EmployeeUsername + ConsoleColorsCode.RESET + '"'
                                                    + "\t\tYour employee's password is " + '"' + ConsoleColorsCode.GREEN_BOLD + Company.users.get(Company.users.size() - 1).getPassword() + ConsoleColorsCode.RESET + '"'
                                                    + ConsoleColorsCode.GREEN_BOLD + "\n\n!!!!!Please forward this informations to your employee so that he/she can log into the system!!!!!"
                                                    + ConsoleColorsCode.RESET);
                                            continue;
                                        } else {
                                            System.out.println(ConsoleColorsCode.RED_BOLD + "\n\nEmployee cannot be added without a manager." + ConsoleColorsCode.RESET);
                                            continue;
                                        }
                                    }

                                    default -> {
                                        System.out.println(ConsoleColorsCode.RED_BOLD + "\n\nPlease enter valid choice" + ConsoleColorsCode.RESET);
                                        continue;
                                    }
                                }
                            case 2:
                                System.out.println("\n\nPress 1 to remove Manager || Press 2 to remove Employee\n");
                                System.out.print(ConsoleColorsCode.RED_BOLD + "\n\nPlease enter your choice : " + ConsoleColorsCode.RESET);

                                a = scan.nextInt();

                                switch (a) {
                                    case 1: //Remove Manager

                                        int managerCount = 0;
                                        for (Users user : Company.users) {
                                            if (user instanceof Manager) {
                                                managerCount++;
                                            }
                                        }

                                        if (managerCount != 0) {
                                            String b;
                                            ceo.viewManagerWithPassword();

                                            System.out.print("\n\nPlease enter the username of the manager you want to fire : ");
                                            String removeUsername = scan.nextLine();
                                            removeUsername = scan.nextLine();

                                            System.out.println(ConsoleColorsCode.RED + "\nDo you really want to fire your manager " + removeUsername
                                                    + "? This action cannot be undone.\n\nIf you are sure, please write YES." + ConsoleColorsCode.RESET
                                                    + ConsoleColorsCode.GREEN_BOLD + "\nIf you made a mistake, please write NO." + ConsoleColorsCode.RESET);

                                            System.out.print("\n\nYour choice : ");
                                            b = scan.nextLine();
                                            if (b.equalsIgnoreCase("YES")) {

                                                Manager manager = null;
                                                ArrayList<Manager> managers = new ArrayList();
                                                boolean isUsernameMatch = false;

                                                for (Users user : Company.users) {
                                                    if (user.getUsername().equalsIgnoreCase(removeUsername)) {
                                                        isUsernameMatch = true;
                                                    }
                                                    if (user instanceof Manager) {
                                                        managers.add((Manager) user);
                                                        manager = managers.get(a - 1);
                                                    }

                                                }

                                                if (isUsernameMatch && managers.size() > 1) {

                                                    System.out.println(ConsoleColorsCode.RED_BOLD + "\n\nYou fired a manager and the employees working under that manager are now managerless."
                                                            + " Please select the manager you want to assign these workers to" + ConsoleColorsCode.RESET);
                                                    for (Employee employee : manager.getWhoIsResponsibleEmployees()) {

                                                        ceo.viewManagerWithoutPassword();
                                                        System.out.println("\n\nName and surname : " + employee.getFirstName() + " " + employee.getLastName());
                                                        System.out.print(ConsoleColorsCode.GREEN_BOLD + "\n\nSelect your choice : " + ConsoleColorsCode.RESET);
                                                        a = scan.nextInt();
                                                        employee.setManager(managers.get(a - 1));
                                                        managers.get(a - 1).SetWhoIsResponsibleEmployees(employee);

                                                    }
                                                    ceo.removeManager(removeUsername);
                                                } else if (isUsernameMatch && managers.size() == 1) {
                                                    System.out.println(ConsoleColorsCode.RED_BOLD
                                                            + "\n\nYou are deleting the only existing manager so employees under this manager will also be fired" + ConsoleColorsCode.RESET);
                                                    System.out.println(ConsoleColorsCode.RED_BOLD + "\nIf you still want to continue, write YES" + ConsoleColorsCode.RESET);
                                                    System.out.println(ConsoleColorsCode.GREEN_BOLD + "If you made a mistake, please write NO" + ConsoleColorsCode.RESET);

                                                    System.out.print("\n\nYour choice : ");
                                                    b = scan.nextLine();

                                                    if (b.equalsIgnoreCase("YES")) {
                                                        //int count = Company.users.size();
                                                        //for (int i = 0; i < Company.users.size(); i++) {
                                                        //if (!(Company.users.get(i) instanceof CEO)) {
                                                        Company.users.subList(1, Company.users.size()).clear();
                                                        System.out.println(ConsoleColorsCode.GREEN_BOLD + "\n\nAction successful, you are redirected to the menu..." + ConsoleColorsCode.RESET);
                                                        //  }
                                                        //}
                                                        continue;
                                                    } else if (b.equalsIgnoreCase("NO")) {
                                                        System.out.println(ConsoleColorsCode.GREEN_BOLD + "\n\nAction cancelled, you are redirected to the menu..." + ConsoleColorsCode.RESET);
                                                        continue;
                                                    } else {
                                                        System.out.println(ConsoleColorsCode.RED_BOLD + "\n\nPlease enter valid choice" + ConsoleColorsCode.RESET);
                                                        continue;
                                                    }

                                                } else if (managers.size() == 0) {
                                                    System.out.println(ConsoleColorsCode.RED + "\n\nYou don't have any managers." + ConsoleColorsCode.RESET);

                                                }

                                            }
                                        }
                                        continue;

                                    case 2: //Remove Employee

                                        int employeeCount = 0;
                                        for (Users user : Company.users) {
                                            if (user instanceof Employee) {
                                                employeeCount++;
                                            }
                                        }
                                        if (employeeCount != 0) {
                                            String b;
                                            ceo.viewEmployeeWithPassword();

                                            System.out.print("\n\nPlease enter the username of the employee you want to fire : ");
                                            String removeUsername = scan.nextLine();
                                            removeUsername = scan.nextLine();

                                            System.out.println(ConsoleColorsCode.RED + "\nDo you really want to fire your employee " + removeUsername
                                                    + "? This action cannot be undone.\n\nIf you are sure, please write YES." + ConsoleColorsCode.RESET
                                                    + ConsoleColorsCode.GREEN_BOLD + "\nIf you made a mistake, please write NO." + ConsoleColorsCode.RESET);

                                            System.out.print("\n\nYour choice : ");
                                            b = scan.nextLine();
                                            if (b.equalsIgnoreCase("YES")) {
                                                ceo.removeEmployee(removeUsername);
                                                System.out.println(ConsoleColorsCode.GREEN_BOLD + "\n\nAction successful, you are redirected to the menu..." + ConsoleColorsCode.RESET);
                                                continue;
                                            } else if (b.equalsIgnoreCase("NO")) {
                                                System.out.println(ConsoleColorsCode.GREEN_BOLD + "\n\nAction cancelled, you are redirected to the menu..." + ConsoleColorsCode.RESET);
                                                continue;
                                            } else {
                                                System.out.println(ConsoleColorsCode.RED_BOLD + "\n\nPlease enter valid choice" + ConsoleColorsCode.RESET);
                                                continue;
                                            }

                                        } else {
                                            System.out.println(ConsoleColorsCode.RED + "\n\nYou don't have any employees." + ConsoleColorsCode.RESET);

                                        }

                                    default:
                                        System.out.println(ConsoleColorsCode.RED_BOLD + "\n\nPlease enter valid choice" + ConsoleColorsCode.RESET);
                                        continue;

                                }

                            case 3: // View leave request from manager
                                ceo.viewLeaveRequests();
                                continue;

                            case 4:

                                ceo.confirmationForManagerLeaves(ceo);
                                continue;

                            case 5: // View report of Manager
                                ceo.viewManagerWithPassword();

                                continue;

                            case 6: // View report of Employee
                                ceo.viewEmployeeWithPassword();

                                continue;
                            case 7:
                                System.out.println("Total number of leaves used in the company : " + ceo.SummationOfAllLeaves());

                                continue;

                            case 8: // Display is called for logout
                                Display();
                            default:
                            //continue;
                        }

                    }

                case 2: // Login verification for manager

                    Manager manager = login.checkManager(username, password);

                    if (manager != null) {
                        System.out.println(ConsoleColorsCode.GREEN + "\nLogin successful you are redirected to the Manager screen..." + ConsoleColorsCode.RESET);
                        System.out.print(ConsoleColorsCode.GREEN + "\n----------Welcome " + username + "----------" + ConsoleColorsCode.RESET);

                    } else {
                        System.out.println(ConsoleColorsCode.RED_BOLD + "\n\nWrong usernme or password. Try again!" + ConsoleColorsCode.RESET);
                        Display();

                    }

                    while (manager != null) {
                        int c = 0;
                        int request = 0;
                        System.out.println("\n\n1)View Leaves \n2)Apply for leave \n3)View Report \n4)View Employee Requests \n5)Grant \n6)Logout");
                        System.out.print(ConsoleColorsCode.GREEN_BOLD + "\n\nPlease enter your choice : " + ConsoleColorsCode.RESET);
                        c = scan.nextInt();
                        switch (c) {
                            case 1 ->
                                manager.viewleave();
                            case 2 -> {
                                System.out.println(ConsoleColorsCode.GREEN_BOLD + "\nYour total leaves are " + manager.getNumberOfLeavesLeft() + " days" + ConsoleColorsCode.RESET);
                                System.out.print("How many leaves do you want : ");
                                request = scan.nextInt();
                                manager.requestLeave(request);
                            }
                            case 3 -> // View his/her Employee's leave report
                                manager.viewEmployee(manager);
                            case 4 -> // View request of his/her allocated employee
                                manager.viewLeaveRequests();
                            case 5 ->
                                manager.confirmationForEmployeeLeaves(manager);
                            case 6 ->
                                Display();
                            default -> {
                            }

                        }

                    }
                case 3:
                    //Login verification for employee

                    Employee emp = login.checkEmployee(username, password);

                    if (emp != null) {
                        System.out.println(ConsoleColorsCode.GREEN + "\nLogin successful you are redirected to the Employee screen..." + ConsoleColorsCode.RESET);
                        System.out.print(ConsoleColorsCode.GREEN + "\n----------Welcome " + username + "----------" + ConsoleColorsCode.RESET);

                        while (true) {
                            int b = 0;
                            int request = 0;
                            System.out.println("\n1)View  Leaves" + "\n" + "2)Apply for leave " + "\n" + "3)Logout");

                            System.out.print(ConsoleColorsCode.GREEN_BOLD + "\n\nPlease enter your choice : " + ConsoleColorsCode.RESET);

                            b = scan.nextInt();
                            switch (b) {

                                case 1 -> // Viewing his/her available leave
                                    emp.viewleave();

                                case 2 -> {
                                    // Requesting leave
                                    System.out.println(ConsoleColorsCode.GREEN_BOLD + "\nYour total leaves are: " + emp.getNumberOfLeavesLeft() + ConsoleColorsCode.RESET);
                                    System.out.print("\n\nHow many leaves do you want : ");
                                    request = scan.nextInt();
                                    emp.requestLeave(request);
                                }
                                case 3 -> //Logout
                                    Display();
                                default -> {
                                }

                            }
                        }

                    } else {

                        System.out.println(ConsoleColorsCode.RED_BOLD + "\n\nWrong usernme or password. Try again!" + ConsoleColorsCode.RESET);
                        Display();
                    }
                default:
                    System.out.println(ConsoleColorsCode.RED_BOLD + "Enter valid number " + ConsoleColorsCode.RESET);
                    Display();

            }

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            System.out.println(ConsoleColorsCode.RED_BOLD + "Execption Occurred" + ConsoleColorsCode.RESET);

            Display();

        }
        scan.close();
    }
}
