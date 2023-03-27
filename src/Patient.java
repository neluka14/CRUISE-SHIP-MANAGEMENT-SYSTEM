public class Patient extends Person{

    private int uniqueId;

    //Constructor
    public Patient(String name, String surname, String dateOfBirth, String mobileNum, int uniqueId) {
        super(name, surname);
        super.setDateOfBirth(dateOfBirth);
        super.setMobileNumber(mobileNum);

        this.uniqueId = uniqueId;
    }

    public int getUniqueId(){
        return uniqueId;
    }

    public void setUniqueId(int uniqueId){
        this.uniqueId = uniqueId;
    }
}
