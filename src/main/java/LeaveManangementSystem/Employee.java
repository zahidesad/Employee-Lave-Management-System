package LeaveManangementSystem;

/**
 *
 * @author zahid
 */
public class Employee extends Users {

    private Manager manager;
    protected int numberOfLeaveRequest, usedLeave, numberOfLeavesLeft, totalDayLeaveValue;
    private int deathCount;
    private int illnessCount;
    private int marriageCount;
    private int otherCount;
    public String leaveReason;

    public static final String[] LeaveTypes = {
        "DEATH",
        "ILLNESS",
        "MARRIAGE",
        "OTHER"
    };

    //Beginning of the Constructor
    public Employee(String firstName, String lastName, String username,
            int totalDayLeaveValue) {
        super(firstName, lastName, username);
        this.totalDayLeaveValue = totalDayLeaveValue;
        numberOfLeavesLeft = totalDayLeaveValue;

    }

    public Employee() {
    }
    //End of the Constructor

    public void requestLeave(int request, int leaveReason) {

        // it checks if requested number of leaves are available or not
        if (request > numberOfLeavesLeft || request > numberOfLeavesLeft - numberOfLeaveRequest
                || totalDayLeaveValue - numberOfLeaveRequest < request) {
            System.out.println(Colors.RED + "\nYou don't have sufficient free leaves. Please enter a valid number of days leave" + Colors.RESET);
        } else {

            System.out.println(Colors.GREEN + "\nYour request for a " + request + " day leave request has been received " + Colors.RESET);
            numberOfLeaveRequest += request;
            this.leaveReason= LeaveTypes[leaveReason-1];
        }
        
    }

    //Number of leave available
    public void viewleave() {
        System.out.println(Colors.GREEN_BOLD + "\n\nYour free leaves are " + getNumberOfLeavesLeft() + " days"
                + Colors.RESET + "\n");
    }

    //To update the number of leaves left after the leave has been used
    public void updateLeave(int update) {
        this.numberOfLeavesLeft = update;
    }

    //Beginning of Encapsulation
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

    //Number of days leave left
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

    public int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(int deathCount) {
        this.deathCount = deathCount;
    }

    public int getIllnessCount() {
        return illnessCount;
    }

    public void setIllnessCount(int illnessCount) {
        this.illnessCount = illnessCount;
    }

    public int getMarriageCount() {
        return marriageCount;
    }

    public void setMarriageCount(int marriageCount) {
        this.marriageCount = marriageCount;
    }

    public int getOtherCount() {
        return otherCount;
    }

    public void setOtherCount(int otherCount) {
        this.otherCount = otherCount;
    }
    //End of Encapsulation

}
