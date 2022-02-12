package TP9;

//Otmane ER-RAGRAGUI
//Abdessamad BOUZEKRI

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static TP9.Mainpanel.user_nom_labelPrincipal;
import static TP9.Mainpanel.user_sports_labelPrincipal;

public class LoginDemo extends JFrame implements ActionListener {
    JPanel panelPrincipal;
    JPanel panel;
    JLabel user_nom_label, user_prenom_lable, user_adresse_label, user_sexe_label;
    JTextField userNom_text;
    JTextField userPrenom_text;
    JTextField userAdresse_text;
    JCheckBox check1 = new JCheckBox("Homme");
    JCheckBox check2 = new JCheckBox("Femme ");


    JCheckBox[] jCheckBoxes = new JCheckBox[6];


    String userName, userPrenom, userSexe;

    String[] sports = new String[6];


    JLabel message;

    JButton ok, annuler;

    LoginDemo() {
        panelPrincipal = new JPanel(new BorderLayout());


        // User Label
        user_nom_label = new JLabel();
        user_nom_label.setText("Nom :");
        userNom_text = new JTextField();

        user_prenom_lable = new JLabel();
        user_prenom_lable.setText("Prenom :");
        userPrenom_text = new JTextField();

        user_adresse_label = new JLabel();
        user_adresse_label.setText("Adresse:");
        userAdresse_text = new JTextField();
        userAdresse_text = new JTextField();
        this.setLocationRelativeTo(null);
        // Password
        jCheckBoxes[0] = new JCheckBox("Petanque");
        jCheckBoxes[1] = new JCheckBox("Tennis");
        jCheckBoxes[2] = new JCheckBox("Squarsh");
        jCheckBoxes[3] = new JCheckBox("Natation");
        jCheckBoxes[4] = new JCheckBox("Basket");
        jCheckBoxes[5] = new JCheckBox("Volet");
        // Submit

        user_sexe_label = new JLabel();
        user_sexe_label.setText("Sexe: ");
        ok = new JButton("OK");
        ok.addActionListener(e -> {
            //System.out.println(this.getUserName());
            user_nom_labelPrincipal.setText(this.getUserName() + " (" + this.getUserSexe() + " )");
            //  System.out.println(this.getUserSexe());
            // user_sexe_labelPrincipal.setText(this.getUserSexe());

            String ss = "";
            int i = 0;
            for (String s : sports) {
                if (s != null)
                    ss += s + " \t";

            }
            user_sports_labelPrincipal.setText(ss);
        });
        annuler = new JButton("Annuler");
        annuler.addActionListener(e -> {
            this.dispose();
        });

        panel = new JPanel(new GridLayout(4, 2));
        panel.add(user_nom_label);
        panel.add(userNom_text);

        panel.add(user_prenom_lable);
        panel.add(userPrenom_text);

        panel.add(user_adresse_label);
        panel.add(userAdresse_text);
        panel.add(user_sexe_label);


        JPanel sexePanel = new JPanel(new GridLayout(1, 2));

        sexePanel.add(check1);
        sexePanel.add(check2);

        panel.add(sexePanel);
        panelPrincipal.add(panel, BorderLayout.CENTER);


        JPanel tempPane = new JPanel(new FlowLayout());

        tempPane.add(ok);
        tempPane.add(annuler);
        panel.setBorder(BorderFactory.createTitledBorder("Membre"));

        panelPrincipal.add(tempPane, BorderLayout.SOUTH);


        //


        // Set up the title for different panels

        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createTitledBorder("Sport"));


        BoxLayout layout2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
        panel2.setLayout(layout2);

        panel2.add(jCheckBoxes[0]);

        panel2.add(jCheckBoxes[1]);
        panel2.add(jCheckBoxes[2]);
        panel2.add(jCheckBoxes[3]);
        panel2.add(jCheckBoxes[4]);
        panel2.add(jCheckBoxes[5]);

        panelPrincipal.add(panel2, BorderLayout.EAST);
        panelPrincipal.setVisible(true);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the listeners to components..

        this.pack();
        this.add(panelPrincipal);
        ok.addActionListener(this);
        setTitle("Inscription!");
        setSize(500, 250);
        setVisible(true);

    }

    public static void main(String[] args) {
        Mainpanel mainpanel = new Mainpanel();


        //     new LoginDemo();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (!userNom_text.getText().isEmpty()) {
            this.userName = userNom_text.getText();
            this.userPrenom = userPrenom_text.getText();
            if (check1.isSelected()) {
                this.userSexe = " Homme";
            } else if (check2.isSelected()) {
                this.userSexe = "Femme";
            }

            for (int i = 0; i < 6; i++) {
                if (jCheckBoxes[i].isSelected()) {
                    sports[i] = jCheckBoxes[i].getText();
                }
            }
        } else if (userNom_text.getText().isEmpty())
            new MyJOptionPane();
    }

    String getUserName() {
        return userName;
    }

    String getUserPrenom() {
        return userPrenom;
    }

    String getUserSexe() {
        return userSexe;
    }

    private class MyJOptionPane {
        MyJOptionPane() {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(
                    frame,
                    "Champs NOM OBLIGATOIRE!",
                    "Alert",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }
}

