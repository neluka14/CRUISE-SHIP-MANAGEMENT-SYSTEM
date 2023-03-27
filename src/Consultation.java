import java.time.LocalDateTime;

public class Consultation {
    private LocalDateTime dateAndTime;
    private int cost;
    private String notes;
    private Doctor doctor;
    private Patient patient;

    //default constructor
    public Consultation(){
    }

    public Consultation(Doctor doctor, Patient patient, LocalDateTime dateAndTime){
        this.dateAndTime = dateAndTime;
        this.doctor = doctor;
        this.patient = patient;
    }

    public LocalDateTime getDateAndTime(){
        return dateAndTime;
    }

    public int getCost(){
        return cost;
    }

    public String getNotes(){
        return notes;
    }

    public Doctor getDoctor(){
        return doctor;
    }

    public Patient getPatient(){
        return patient;
    }

    public void setDateAndTime(LocalDateTime dateAndTime){
        this.dateAndTime = dateAndTime;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    public void setNotes(String notes){
        this.notes = notes;
    }

    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }

    public void setPatient(Patient patient){
        this.patient = patient;
    }

}
