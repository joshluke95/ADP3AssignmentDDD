package za.ac.cput.Views;

/**
 *
 * @author Liyabona Saki
 * @Date 19/10/2021
 * @Class Menu.java
 */
public class Menu extends javax.swing.JFrame {


    public Menu() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        appointments = new javax.swing.JButton();
        doctors = new javax.swing.JButton();
        patients = new javax.swing.JButton();
        nurses = new javax.swing.JButton();
        exit = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        consultations = new javax.swing.JButton();
        Receptionist = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        appointments.setText("Manage Appointments");
        appointments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointmentsMouseClicked(evt);
            }
        });
        getContentPane().add(appointments, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, 210, 60));

        doctors.setText("Manage Doctors");
        doctors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doctorsMouseClicked(evt);
            }
        });
        getContentPane().add(doctors, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 200, 60));

        patients.setText("Manage Patients");
        patients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientsMouseClicked(evt);
            }
        });
        getContentPane().add(patients, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 200, 60));

        nurses.setText("Manage Nurses");
        nurses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nursesMouseClicked(evt);
            }
        });
        getContentPane().add(nurses, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 210, 60));

        exit.setText("EXIT");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 200, 60));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("                            Welcome to the Treat Hospital Management System");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 990, 100));

        consultations.setText("Consultations");
        consultations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consultationsMouseClicked(evt);
            }
        });
        getContentPane().add(consultations, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 210, 60));

        Receptionist.setText("Manage Receptionist");
        Receptionist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReceptionistMouseClicked(evt);
            }
        });
        getContentPane().add(Receptionist, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 210, 60));

        pack();
    }// </editor-fold>

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }


    //Manage doctors
    private void doctorsMouseClicked(java.awt.event.MouseEvent evt) {
        String link = "http://localhost:8080/getAll";

        try {
            String url = link;
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (java.io.IOException e) {
            e.getStackTrace();

        }
//        this.dispose();

    }

    //Manage patients
    private void patientsMouseClicked(java.awt.event.MouseEvent evt) {

    }


    //Manage Nurses
    private void nursesMouseClicked(java.awt.event.MouseEvent evt) {

    }


    //Consultations
    private void consultationsMouseClicked(java.awt.event.MouseEvent evt) {

    }


    //Manage receptionists
    private void ReceptionistMouseClicked(java.awt.event.MouseEvent evt) {

    }


    //    Manage appointments
    private void appointmentsMouseClicked(java.awt.event.MouseEvent evt) {

    }


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton Receptionist;
    private javax.swing.JButton appointments;
    private javax.swing.JButton consultations;
    private javax.swing.JButton doctors;
    private javax.swing.JToggleButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton nurses;
    private javax.swing.JButton patients;
    // End of variables declaration
}

