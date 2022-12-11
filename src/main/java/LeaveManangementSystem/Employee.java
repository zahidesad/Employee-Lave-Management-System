package LeaveManangementSystem;

/**
 *
 * @author zahid
 */
public class Employee extends Users {

    private Manager manager;
    private int numberOfLeaveRequest, usedLeave, numberOfLeavesLeft, totalDayLeaveValue;

    public void requestLeave(int request) {

        // it checks if requested number of leaves are available or not
        if (request > getNumberOfLeavesLeft()) {
            System.out.println("You don't have sufficient free leaves");
        } else {
            System.out.println("Requested for " + request + "days");
            requestLeave(request);

        }
    }
    //Beginning of Encapsulation

    //Number of leave available
    public void viewleave() {
        System.out.println("Your free leaves are:" + getNumberOfLeavesLeft());
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    //The number of days leave requested
    public int getNumberOfLeaveRequest() {
        return numberOfLeaveRequest;
    }

    public void setNumberOfLeaveRequest(int numberOfDaysLeave) {
        this.numberOfLeaveRequest = numberOfDaysLeave;
    }

    //Number of leave used
    public int getUsedLeave() {
        return usedLeave;
    }

    public void setUsedLeave(int usedLeave) {
        this.usedLeave = usedLeave;
    }

    //Number of days leave remaining
    public int getNumberOfLeavesLeft() {
        return numberOfLeavesLeft;
    }

    public void setNumberOfLeavesLeft(int numberOfLeavesLeft) {
        this.numberOfLeavesLeft = numberOfLeavesLeft;
    }

    public int getTotalDayLeaveValue() {
        return totalDayLeaveValue;
    }

    //Determine the total value of days leave
    public void setTotalDayLeaveValue(int totalDayLeaveValue) {
        this.totalDayLeaveValue = totalDayLeaveValue;
    }
    //End of Encapsulation

    public void updateLeave(int update) {
        this.numberOfLeavesLeft = update;
    }

}
