import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager{

    public static ArrayList <Doctor> ListOfDoctors = new ArrayList<>(10);
    public static Scanner scanner = new Scanner(System.in);

    public static void main (String[] args) throws IOException {

        while (true) {
            System.out.println("Add a new Doctor - 1");
            System.out.println("Delete a Doctor - 2");
            System.out.println("Print the list of the Doctors - 3");
            System.out.println("Save in a file - 4");
            System.out.println("Read info from file - 5");
            System.out.println("Open Graphical User Interface(GUI) - 6");
            System.out.println("Exit - 0");

            System.out.println("Enter menu choice: ");
            int menuChoice = scanner.nextInt();

            if (menuChoice == 1) {
                addNewDoctor();
            } else if (menuChoice == 2) {
                deleteDoctor();
            } else if (menuChoice == 3) {
                printListOfDoctors(ListOfDoctors);
            } else if (menuChoice == 4) {
                saveToAFile();
            } else if (menuChoice == 5){
                readFromFile();
            } else if (menuChoice == 6){
                openGUI();
            } else if (menuChoice == 0) {
                break;
            } else {
                System.out.println("Input not valid");
            }
        }
    }

    public static void addNewDoctor() {

        System.out.println("First name ");
        String name = scanner.next();

        System.out.println("Surname ");
        String surname = scanner.next();

        System.out.println("Medical Licence number ");
        String medicalLicenceNumber = scanner.next();

        System.out.println("Specialisation ");
        String specialisation = scanner.next();


        if (Doctor.doctorCount < 10){
            Doctor doctor = new Doctor(name ,surname, medicalLicenceNumber, specialisation);
            ListOfDoctors.add(doctor);

            Doctor.doctorCount += 1;
        }
    }

    public static void deleteDoctor(){

        System.out.println("Medical Licence number ");
        String medicalLicenceNumber = scanner.next();

        for (int i = 0; i < ListOfDoctors.size(); i ++){

            if(ListOfDoctors.get(i).getMedicalLicenceNumber().equals(medicalLicenceNumber)){
                Doctor doctor  = ListOfDoctors.get(i);

                System.out.println("doctor name : " + doctor.getName() + " " + doctor.getSurname() );
                System.out.println("medical license number :" + doctor.getMedicalLicenceNumber());
                System.out.println("specialisation : " + doctor.getSpecialisation());

                ListOfDoctors.remove(ListOfDoctors.get(i));
            }else{
                System.out.println("Doctor doesn't exist.");
            }
        }

        Doctor.doctorCount -=1;

        System.out.println("Doctor count: " + Doctor.doctorCount);

    }

    public static void printListOfDoctors(ArrayList<Doctor> doctorArrayList) {

        ArrayList<Doctor> sortedDoctorList = sortDoctors(doctorArrayList);

        for(int i = 0; i < sortedDoctorList.size(); i ++){
            Doctor doctor  = sortedDoctorList.get(i);
            System.out.println("doctor name : " + doctor.getName() + " " + doctor.getSurname() );
            System.out.println("medical license number :" + doctor.getMedicalLicenceNumber());
            System.out.println("specialisation : " + doctor.getSpecialisation());
        }

    }

    public static ArrayList<Doctor> sortDoctors(ArrayList<Doctor> doctorList){

        ArrayList<Doctor> sortedDoctorList = (ArrayList<Doctor>)doctorList.clone();

        for(int i = 0; i < sortedDoctorList.size(); i++){
            for(int j = i + 1; j < sortedDoctorList.size(); j++){

                Doctor temp;
                if(sortedDoctorList.get(i).getSurname().compareTo(sortedDoctorList.get(j).getSurname()) > 0){
                    temp = sortedDoctorList.get(i);
                    sortedDoctorList.set(i, sortedDoctorList.get(j));
                    sortedDoctorList.set(j, temp);
                }
            }
        }

        return sortedDoctorList;
    }

    public static void saveToAFile() throws IOException {

        //File to store Doctor information
        FileWriter fileWriter = new FileWriter("File.txt");

        for(int i = 0; i< ListOfDoctors.size(); i ++) {
            Doctor doctor = ListOfDoctors.get(i);
            fileWriter.write(doctor.getName() + " ");
            fileWriter.write(doctor.getSurname() + " ");
            fileWriter.write(doctor.getMedicalLicenceNumber() + " ");
            fileWriter.write(doctor.getSpecialisation() + " ");
            fileWriter.write('\n');
        }
        fileWriter.close();
    }

    public static void readFromFile() throws FileNotFoundException {

        File myObj = new File("File.txt");
        Scanner fileReader = new Scanner(myObj);
        while (fileReader.hasNextLine()) {

            String data = fileReader.nextLine();
            String[] doctorDataRow = data.split(" ");

            String name = doctorDataRow[0];
            String surname = doctorDataRow[1];
            String medicalLicenceNumber = doctorDataRow[2];
            String specialisation = doctorDataRow[3];

            Doctor doctor = new Doctor(name, surname, medicalLicenceNumber, specialisation);

            ListOfDoctors.add(doctor);

            Doctor.doctorCount += 1;
        }
        fileReader.close();
    }

    public static void openGUI(){
        GUI gui = new GUI();
    }
}
