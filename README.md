# Leave_Management_Systmem

![EmployeeLeaveTracker](https://user-images.githubusercontent.com/116666407/211184947-34274c08-a6cd-4921-9e66-2020ce8b0056.jpg)


 Aim of The Project and Requirements:
The purpose of this project is to keep track of the leaves of employees and managers in a company. For the project to work correctly, it is necessary to have the JDK (Java Development Kit) and the IDE named Apache NetBeans. Also, if you want the color codes in the project to work, you must have Apache Maven version 3.3.3 or below.

Rules:
Initially, there is only one CEO in the company, whose username is admin and password is 123. There can be only one CEO in the company. No additions or removals can be made for the CEO. You can run the system by coming to the "Test" class and pressing the Shift+F6 keys. You can log in to the system by entering the CEO's username and password by pressing the 1 button on the screen that appears.  Before explaining the rules, there are colors in the console. It was made to make the front-end part of this project more appealing to the eye. All rules are explained below in bullet points.


1)	Adding and removing employee and manager can only be done by the CEO.
2)	When a manager or employee is added, the first name, last name and number of annual leave entitlements are entered by the CEO.
3)	After the name and surname are entered, the entered name and surname without spaces will automatically become the username. For example, the username of someone named "Zahid Esad" would be "ZahidEsad". The user's password is automatically given as a 10-digit number. This feature is provided by importing "java.util.Random".
4)	Employee cannot be added when there is no manager in the company because every employee must work under a manager.
5)	After a manager is added, when a new worker is wanted to be added, the manager list and the number of employees working under this manager are displayed. The CEO chooses which manager the employee he/she adds will work under.
6)	When the CEO wants to fire a manager, if there is more than one manager, the employees working under the manager he/she fired should be given under a new manager. The CEO can choose the new manager of all the employees one by one.
7)	If the number of managers is only one, all workers working under this manager are fired together with the manager, so there is no employees and manager left in the company.
8)	Employees can be fired directly.
9)	The CEO only deals with managers' leave requests. The manager of that worker deals with the leave requests of the employees.
10)	CEO and Managers have the right to confirm and reject leave, if the leave is confirmed, it is deducted from the number of annual leave entitlements. If rejected, the number of annual leave entitlements remains constant.
11)	The CEO can view the list of managers and employees with their passwords.
12)	The CEO can see the total number of leaves used in the company.
13)	Managers can view their annual leave count.
14)	Managers can apply for leave, if they enter more than the annual leave number, they will get an error.
15)	Managers can view, approve, and reject leave requests from employees working under them.
16)	Employees can view their annual leave entitlements and apply for leave.

