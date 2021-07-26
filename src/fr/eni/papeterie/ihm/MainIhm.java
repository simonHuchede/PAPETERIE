package fr.eni.papeterie.ihm;

import javax.swing.*;

public class MainIhm {
    public static void main (String[] args ){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                EcranUser ecranUser = new EcranUser();
            }
        });
    }
}
