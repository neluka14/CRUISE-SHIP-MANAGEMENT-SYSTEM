public class Doctor extends Person{

    private String medicalLicenceNumber;
    private String specialisation;

    public static int doctorCount;

    public Doctor(String name, String surname, String medicalLicenceNumber, String specialisation){
        super(name, surname);
        this.medicalLicenceNumber = medicalLicenceNumber;
        this.specialisation = specialisation;

    }
    public String getMedicalLicenceNumber(){
        return medicalLicenceNumber;
    }

    public String getSpecialisation(){
        return specialisation;
    }

    public void setMedicalLicenceNumber(String medicalLicenceNumber){
        this.medicalLicenceNumber = medicalLicenceNumber;
    }

    public void setSpecialisation(String specialisation){
        this.specialisation = specialisation;
    }

}
