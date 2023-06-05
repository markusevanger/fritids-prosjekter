

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MGUI {

    Kontroller kontroller;

    public MGUI(Kontroller kontroller){

        this.kontroller = kontroller;

        // GENERELT OPPSETT:
        // Set vinduer osv til platform (Windows, mac) sin stil.
        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } 
        catch (Exception e) { 
            System.out.println("Klarte ikke å finne CrossPlatformLookAndFeel");
            System.exit(1); 
        }

        JFrame vindu = new JFrame("scuffed minesweiper");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vindu.setSize(900, 900);


        JPanel hovedpanel = new JPanel();
        vindu.add(hovedpanel,  BorderLayout.CENTER);

        JPanel rutenettPanel = new JPanel();
        rutenettPanel.setLayout(new GridLayout(kontroller.rader, kontroller.kolonner));
        hovedpanel.add(rutenettPanel);

        JButton[][] alleKnapper = opprettRutenett(rutenettPanel);
        

        vindu.setLocationRelativeTo(null);
        //vindu.pack(); // foreløpig(?) skaper problemer med størrelse på vindu. 
        vindu.setVisible(true);

    }


    public JButton[][] opprettRutenett(JPanel rutenettPanel){

        JButton[][] alleKnapper = new JButton[kontroller.rader][kontroller.kolonner];


        for (int rad = 0; rad < kontroller.rader; rad++){
            for (int kol = 0; kol < kontroller.kolonner; kol++){

                alleKnapper[rad][kol] = new JButton(kontroller.hentRute(rad, kol).toString());
                rutenettPanel.add(alleKnapper[rad][kol]);
            }
        }

        return alleKnapper;
    }
    
}
