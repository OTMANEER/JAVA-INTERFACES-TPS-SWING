package TP9;

//Otmane ER-RAGRAGUI
//Abdessamad BOUZEKRI

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mainpanel extends JFrame implements MouseListener {


    public static JPanel panelPrincipal;

    public static JPanel AllPanels;

    public static JLabel user_nom_labelPrincipal, user_sexe_labelPrincipal, user_sports_labelPrincipal;

    Mainpanel() {
        AllPanels = new JPanel(new FlowLayout());


        panelPrincipal = new JPanel(new BorderLayout());
        user_nom_labelPrincipal = new JLabel();
        user_sports_labelPrincipal = new JLabel();
        user_sexe_labelPrincipal = new JLabel();
        panelPrincipal = new JPanel(new GridLayout(4, 2));

        panelPrincipal.add(user_nom_labelPrincipal);
        panelPrincipal.add(user_sports_labelPrincipal);
        panelPrincipal.add(user_sexe_labelPrincipal);

        AllPanels.add(panelPrincipal);

        this.add(AllPanels);
        this.addMouseListener(this);

        setSize(700, 700);
        setTitle("Clique dans le cadre pour t'inscrire");
        setLocationRelativeTo(null);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        LoginDemo loginDemo = new LoginDemo();


        //  System.out.println(loginDemo.getUserName());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
