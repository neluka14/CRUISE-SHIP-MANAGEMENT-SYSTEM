import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {

    public static ArrayList<Doctor> listOfDoctors = WestminsterSkinConsultationManager.ListOfDoctors;

    public GUI(){
    }

    public static void main(String[] args){

        JFrame frame = new JFrame();

        JLabel label = new JLabel("Skin Consultation center");
        label.setBounds(540,0, 100, 30);
        frame.add(label);

        String[] tableHeadings = {"First Name", "Surname", "Medical License Number", "Specialization"};

        Object[][] tableInfo = new String[10][4];
        for(int i = 0; i < listOfDoctors.size(); i++) {
            tableInfo[i][0] = listOfDoctors.get(i).getName();
            tableInfo[i][1] = listOfDoctors.get(i).getSurname();
            tableInfo[i][2] = listOfDoctors.get(i).getMedicalLicenceNumber();
            tableInfo[i][3] = listOfDoctors.get(i).getSpecialisation();
        }

        JTable jTable = new JTable(tableInfo, tableHeadings);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(0,80, 1080, 190);
        frame.add(jScrollPane);

        JButton sortBtn = new JButton("Click to sort");
        sortBtn.setBounds(350, 290, 100, 30);
        frame.add(sortBtn);

        frame.setSize(1200, 800);
        frame.setLayout(null);
        frame.setVisible(true);

        sortBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listOfDoctors = WestminsterSkinConsultationManager.sortDoctors(listOfDoctors);

                jTable.setVisible(false);

                //Updating data in doctors table
                for(int i = 0; i < listOfDoctors.size(); i++) {
                    tableInfo[i][0] = listOfDoctors.get(i).getName();
                    tableInfo[i][1] = listOfDoctors.get(i).getSurname();
                    tableInfo[i][2] = listOfDoctors.get(i).getMedicalLicenceNumber();
                    tableInfo[i][3] = listOfDoctors.get(i).getSpecialisation();
                }

                jTable.setVisible(true);
            }
        });
    }
}
