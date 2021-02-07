import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreGestionnaire extends JFrame implements ActionListener {
    //TODO TOP BAR Configs
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("Fichier");
    JMenu articleMenu = new JMenu("Article");

    //TODO Tabbed BAR init
    JTabbedPane tabbedPane = new JTabbedPane();

    JMenuItem exploreItem = new JMenuItem("Explorer");
    JMenuItem importItem = new JMenuItem("Importer");
    JMenuItem quitItem = new JMenuItem("Quitter");
    JMenuItem newItem = new JMenuItem("Nouveau");
    JMenuItem modifyItem = new JMenuItem("Modifier");
    JMenuItem deleteItem = new JMenuItem("Supprimer");

    public FenetreGestionnaire()
    {
        //TODO Global configs
        fileMenu.add(exploreItem);
        fileMenu.add(importItem);
        fileMenu.add(quitItem);
        newItem.addActionListener(this);
        articleMenu.add(newItem);
        articleMenu.add(modifyItem);
        articleMenu.add(deleteItem);
        menuBar.add(fileMenu);
        menuBar.add(articleMenu);

        //TODO 2 onglets
        JPanel localDataOnglet = new JPanel () ;
        localDataOnglet.setLayout(new GridLayout(2, 2));
        localDataOnglet.setSize(2250, 750);

        JPanel DBOngelt = new JPanel();

        //TODO 4x4 Panel Configs
        JTree tree = new JTree();
        JPanel p = new JPanel();
        JPanel deleteArticlePanel = new JPanel();
        JPanel addArticlePanel = new JPanel();

        //TODO TreePanel Configs
        localDataOnglet.add(new JScrollPane(tree));

        //TODO Add article Panel configurations
        JPanel labelsPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(labelsPanel,BoxLayout.Y_AXIS);
        labelsPanel.setLayout(boxLayout);
        JLabel details = new JLabel("Details article menu ");
        labelsPanel.add(details);
        labelsPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        JLabel name = new JLabel("Nom :");
        labelsPanel.add(name);
        labelsPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        JLabel tarif = new JLabel("Tarif :");
        labelsPanel.add(tarif);
        labelsPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        JLabel article = new JLabel("Article :");
        labelsPanel.add(article);
        labelsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        JPanel quantPanel = new JPanel();
        quantPanel.setLayout(new BoxLayout(quantPanel, BoxLayout.X_AXIS));
        String label = "Quantite: ";
        JLabel l = new JLabel(label, JLabel.HORIZONTAL);
        quantPanel.add(l);
        labelsPanel.add(Box.createRigidArea(new Dimension(15, 10)));
        JPanel Panelbutton = new JPanel () ;
        Panelbutton.setLayout(new BoxLayout(Panelbutton,BoxLayout.Y_AXIS));
        JButton b1 = new JButton("Ajouter");
        Panelbutton.add(b1);
        Panelbutton.add(Box.createRigidArea(new Dimension(25, 20)));
        Panelbutton.add(b1) ;
        JTextField textField = new JTextField(10);
        l.setLabelFor(textField);
        textField.setMaximumSize(new Dimension(300,
                30));
        quantPanel.add(textField);
        quantPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        BoxLayout bigBoxLayout = new BoxLayout(addArticlePanel,BoxLayout.Y_AXIS);

        addArticlePanel.setLayout(bigBoxLayout);
        addArticlePanel.add(labelsPanel);
        addArticlePanel.add(quantPanel);
        addArticlePanel.add(Panelbutton) ;
        localDataOnglet.add(addArticlePanel);

        //TODO List Configs
        DefaultListModel<String> listonglet2 = new DefaultListModel<>();
        JList<String> commandeItemsList = new JList<>(listonglet2);
        localDataOnglet.add(commandeItemsList);

        //TODO Delete article Panel
        JPanel deleteLabels = new JPanel();
        BoxLayout deleteLabelsLayout = new BoxLayout(deleteLabels,BoxLayout.Y_AXIS);
        deleteLabels.setLayout(deleteLabelsLayout);
        JLabel detailsDelete = new JLabel("Details article menu ");
        deleteLabels.add(detailsDelete);
        deleteLabels.add(Box.createRigidArea(new Dimension(0, 15)));
        JLabel nameDelete = new JLabel("Nom :");
        nameDelete.setText( "Nom :" );
        deleteLabels.add(nameDelete);
        deleteLabels.add(Box.createRigidArea(new Dimension(0, 15)));
        JLabel tarifDelete = new JLabel("Tarif :");
        deleteLabels.add(tarifDelete);
        deleteLabels.add(Box.createRigidArea(new Dimension(0, 15)));
        JLabel articleDetele = new JLabel("Article :");
        deleteLabels.add(articleDetele);
        deleteLabels.add(Box.createRigidArea(new Dimension(0, 15)));
        String qte = "Quantite: ";
        JLabel labelQte = new JLabel(qte, JLabel.HORIZONTAL);
        deleteLabels.add(labelQte);
        deleteLabels.add(Box.createRigidArea(new Dimension(15, 10)));
        JButton deleteButton = new JButton();
        deleteButton.setText("Supprimer");
        JButton validateButton = new JButton();
        validateButton.setText("Valider");
        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons,BoxLayout.X_AXIS));
        buttons.add(deleteButton);
        buttons.add(validateButton);

        deleteArticlePanel.add(Box.createRigidArea(new Dimension(0, 15)));

        BoxLayout deletePanelLAyout = new BoxLayout(deleteArticlePanel,BoxLayout.Y_AXIS);
        deleteArticlePanel.setLayout(deletePanelLAyout);
        validateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
//                if ( isSelected) {
//                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//                    LocalDateTime now = LocalDateTime.now();
//                    db.insertCommande(selectedArt.nom, selectedArt.tarif.toString(), dtf.format(now).toString());
//                }
            }
        });

        deleteArticlePanel.add(deleteLabels);
        deleteArticlePanel.add(buttons);
        localDataOnglet.add(deleteArticlePanel);

        //TODO JFrame Global Configs
        tabbedPane.add("Nouvelle commnde " , localDataOnglet) ;
        add (tabbedPane , BorderLayout.CENTER) ;
        setJMenuBar(menuBar);
        add(localDataOnglet);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Gestionnaire des articles");
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newItem)
        {
            JFrame frame = new NouvelArticle();
        }
    }
}
