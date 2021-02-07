import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NouvelArticle extends JFrame implements ActionListener {

    FenetreGestionnaire f = new FenetreGestionnaire(); // mere
    JLabel l1, l2, l3, l4, l5;
    JTextField testField1, testField2, testField3;
    JButton bouton, bouton1;
    JCheckBox checkbox1;
    JPanel panneau;
    JComboBox cb;

    public NouvelArticle() {

        super("Ajouter Article"); //titre

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        addWindowListener(l);

        panneau = new JPanel(); // pannel
        panneau.setLayout(null);
        l1 = new JLabel("Nom"); //label
        l1.setBounds(50, 50, 150, 30);
        testField1 = new JTextField("");
        testField1.setBounds(250, 50, 150, 30);
        testField1.setPreferredSize(new Dimension(100, 20));
        l2 = new JLabel("Nouvelle catégorie");
        l2.setBounds(50, 80, 180, 45);
        checkbox1 = new JCheckBox("");
        checkbox1.setBounds(250, 80, 180, 45);

        checkbox1.addActionListener((ActionListener) this); // listenner
        l3 = new JLabel("Catégorie");
        l3.setBounds(50, 110, 200, 50);
        String catégories[] = {"Boisson chaude", "Boisson froide", "Sandwich:Libanais Thon"};
        cb = new JComboBox(catégories);
        cb.setBounds(250, 125, 150, 30);
        cb.addActionListener((ActionListener) this); // listenner , condition
        l4 = new JLabel("Nom catégorie");
        l4.setBounds(50, 140, 250, 60);
        testField2 = new JTextField("");
        testField2.setBounds(250, 160, 150, 30);
        testField2.setPreferredSize(new Dimension(100, 20));
        testField2.addActionListener((ActionListener) this);
        l5 = new JLabel("Tarif");
        l5.setBounds(50, 170, 270, 70);
        testField3 = new JTextField("");
        testField3.setBounds(250, 190, 150, 30);
        testField3.setPreferredSize(new Dimension(100, 20));
        bouton = new JButton("Ajouter");
        bouton.setBounds(50, 250, 120, 40);
        bouton.addActionListener(this);
        bouton1 = new JButton("Annuler");
        bouton1.setBounds(210, 250, 120, 40);
        bouton1.addActionListener(this);

        panneau.add(testField1);
        panneau.add(testField2);
        panneau.add(testField3);
        panneau.add(checkbox1);
        panneau.add(l1);
        panneau.add(l2);
        panneau.add(l3);
        panneau.add(l4);
        panneau.add(l5);
        panneau.add(cb);
        panneau.add(bouton);
        panneau.add(bouton1);
        setContentPane(panneau);
        setSize(500, 350);
        setVisible(true);

//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                f.annulerAjoutArticle();
//            }
//        });
//    }
//
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == checkbox1) {
//            cb.setEnabled(!checkbox1.isSelected());
//            testField2.setEnabled(checkbox1.isSelected());
//        }
//
//        Object source = e.getSource();
//        if (source == bouton) {
//
//            f.ajouterArticle(testField1.getText(), testField2.getText(), testField3.getText());
//            System.out.println(testField1.getText());
//
//        } else if (source == bouton1) {
//            //  f.annulerAjoutArticle();
//            dispose();
//        }
//    }

//    public interface NouvelArticleEvent {
//
//        public void ajouterArticle(String nomArticle, String nomCategorie, String tarif);
//
//        public void annulerAjoutArticle();
//    }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
