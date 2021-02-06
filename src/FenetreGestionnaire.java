import javax.swing.*;
import java.awt.*;

public class FenetreGestionnaire extends JFrame
{
    public FenetreGestionnaire()
    {
        // TOP BAR Configs
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Fichier");
        JMenu articleMenu = new JMenu("Article");

        JMenuItem exploreItem = new JMenuItem("Explorer");
        fileMenu.add(exploreItem);
        JMenuItem importItem = new JMenuItem("Importer");
        fileMenu.add(importItem);
        JMenuItem quitItem = new JMenuItem("Quitter");
        fileMenu.add(quitItem);
        JMenuItem newItem = new JMenuItem("Nouveau");
        articleMenu.add(newItem);
        JMenuItem modifyItem = new JMenuItem("Modifier");
        articleMenu.add(modifyItem);
        JMenuItem deleteItem = new JMenuItem("Supprimer");
        articleMenu.add(deleteItem);

        menuBar.add(fileMenu);
        menuBar.add(articleMenu);

        setJMenuBar(menuBar);


        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Gestionnaire des articles");
        this.pack();
        this.setVisible(true);
    }
}
