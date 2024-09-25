package lab2;

public class Phone {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String accountNumber;
    private int localCallDuration;
    private int longDistanceCallDuration;

    public Phone(int id, String lastName, String firstName, String middleName, String accountNumber, int localCallDuration, int longDistanceCallDuration) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.accountNumber = accountNumber;
        this.localCallDuration = localCallDuration;
        this.longDistanceCallDuration = longDistanceCallDuration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getLocalCallDuration() {
        return localCallDuration;
    }

    public void setLocalCallDuration(int localCallDuration) {
        this.localCallDuration = localCallDuration;
    }

    public int getLongDistanceCallDuration() {
        return longDistanceCallDuration;
    }

    public void setLongDistanceCallDuration(int longDistanceCallDuration) {
        this.longDistanceCallDuration = longDistanceCallDuration;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", localCallDuration=" + localCallDuration +
                ", longDistanceCallDuration=" + longDistanceCallDuration +
                '}';
    }
}
