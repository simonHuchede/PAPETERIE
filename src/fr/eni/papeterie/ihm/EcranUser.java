package fr.eni.papeterie.ihm;

import javax.swing.*;
import java.awt.*;

public class EcranUser extends JFrame {
    JLabel labelReference;
    JTextField txtReference;
    JLabel labelDesignation;
    JTextField txtDesignation;
    JLabel labelMarque;
    JTextField txtMarque;
    JLabel labelStock;
    JTextField txtStock;
    JLabel labelPrix;
    JTextField txtPrix;
    JPanel panelType;
    JLabel labelType;
    ButtonGroup buttonGroupType;
    JRadioButton radioTypeRamette;
    JRadioButton radioTypeStylo;
    JPanel panelGrammage;
    JLabel labelGrammage;
    ButtonGroup buttonGroupGrammage;
    JCheckBox  checkBoxGrammage80;
    JCheckBox  checkBoxGrammage100;
    JLabel labelCouleur;
    JComboBox comboBoxCouleur;
    JPanel panelButton;
    JButton buttonGauche;
    JButton buttonFeuille;
    JButton buttonEnregistrer;
    JButton buttonBin;
    JButton buttonDroite;
    Icon iconGauche = new ImageIcon("C:\\Users\\shuchede2021\\IdeaProjects\\papeterie\\images\\Back24.gif");
    Icon iconFeuille = new ImageIcon("C:\\Users\\shuchede2021\\IdeaProjects\\papeterie\\images\\New24.gif");
    Icon iconsave = new ImageIcon("C:\\Users\\shuchede2021\\IdeaProjects\\papeterie\\images\\Save24.gif");
    Icon iconBin = new ImageIcon("C:\\Users\\shuchede2021\\IdeaProjects\\papeterie\\images\\Delete24.gif");
    Icon iconForward = new ImageIcon("C:\\Users\\shuchede2021\\IdeaProjects\\papeterie\\images\\Forward24.gif");


    public EcranUser(){
        this.setSize(350,350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel= new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc= new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        panel.add(this.getLabelReference(),gbc);
        gbc.insets = new Insets(0,3,5, 3);
        gbc.gridx=1;
        gbc.gridy=0;
        panel.add(this.getTxtReference(),gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        panel.add(this.getLabelDesigation(),gbc);
        gbc.gridx=1;
        gbc.gridy=1;
        panel.add(this.getTxtDesignation(),gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        panel.add(this.getLabelMarque(),gbc);
        gbc.gridx=1;
        gbc.gridy=2;
        panel.add(this.getTxtMarque(),gbc);
        gbc.gridx=0;
        gbc.gridy=3;
        panel.add(this.getLabelStock(),gbc);
        gbc.gridx=1;
        gbc.gridy=3;
        panel.add(this.getTxtStock(),gbc);
        gbc.gridx=0;
        gbc.gridy=4;
        panel.add(this.getLabelPrix(),gbc);
        gbc.gridx=1;
        gbc.gridy=4;
        panel.add(this.getTxtPrix(),gbc);
        gbc.gridx= 0;
        gbc.gridy= 5;
        panel.add(this.getLabelType(),gbc);
        gbc.gridx= 1;
        gbc.gridy= 5;
        panel.add(this.getPanelType(),gbc);
        gbc.gridx=0;
        gbc.gridy=7;
        panel.add(this.getLabelGrammage(),gbc);
        gbc.gridx=1;
        gbc.gridy=7;
        panel.add(this.getPanelGrammage(),gbc);
        gbc.gridx=0;
        gbc.gridy=9;
        panel.add(this.getLabelCouleur(),gbc);
        gbc.gridx=1;
        gbc.gridy=9;
        panel.add(this.getComboBoxCouleur(),gbc);
        gbc.gridx=0;
        gbc.gridy=10;
        gbc.gridwidth= 2;
        panel.add(this.getPanelButton(),gbc);
        this.setContentPane(panel);
        this.setVisible(true);
    }
    public JLabel getLabelReference() {
        if (this.labelReference == null) {
            this.labelReference = new JLabel("Réference");
        }
        return labelReference;
    }
    public JTextField getTxtReference() {
        if (this.txtReference == null) {
            this.txtReference = new JTextField(20);
        }
        return txtReference;
    }
    public JLabel getLabelDesigation() {
        if (this.labelDesignation == null) {
            this.labelDesignation = new JLabel("Désigation");
        }
        return labelDesignation;
    }
    public JTextField getTxtDesignation() {
        if (this.txtDesignation == null) {
            this.txtDesignation = new JTextField(20);
        }
        return txtDesignation;
    }
    public JLabel getLabelMarque() {
        if (this.labelMarque == null) {
            this.labelMarque = new JLabel("Marque");
        }
        return labelMarque;
    }
    public JTextField getTxtMarque() {
        if (this.txtMarque == null) {
            this.txtMarque = new JTextField(20);
        }
        return txtMarque;
    }
    public JLabel getLabelStock() {
        if (this.labelStock == null) {
            this.labelStock= new JLabel("Stock");
        }
        return labelStock;
    }
    public JTextField getTxtStock() {
        if (this.txtStock == null) {
            this.txtStock = new JTextField(20);
        }
        return txtStock;
    }
    public JLabel getLabelPrix() {
        if (this.labelPrix == null) {
            this.labelPrix = new JLabel("Prix");
        }
        return labelPrix;
    }
    public JTextField getTxtPrix() {
        if (this.txtPrix == null) {
            this.txtPrix = new JTextField(20);
        }
        return txtPrix;
    }
    public JPanel getPanelType(){
        if(this.panelType == null){
            this.panelType = new JPanel();
            panelType.setLayout(new BoxLayout(panelType,BoxLayout.Y_AXIS));
            panelType.add(this.getRadioTypeRamette());
            panelType.add(this.getRadioTypeStylo());
            buttonGroupType = new ButtonGroup();
            buttonGroupType.add(this.getRadioTypeRamette());
            buttonGroupType.add(this.getRadioTypeStylo());

        }
        return panelType;
    }
    public JLabel getLabelType() {
        if (this.labelType == null) {
            this.labelType = new JLabel("Type");
        }
        return labelType;
    }

    public JRadioButton getRadioTypeRamette() {
        if (this.radioTypeRamette == null) {
            this.radioTypeRamette = new JRadioButton("Ramette");
        }
        return radioTypeRamette;
    }
    public JRadioButton getRadioTypeStylo() {
        if (this.radioTypeStylo == null) {
            this.radioTypeStylo = new JRadioButton("Stylo");
        }
        return radioTypeStylo;
    }
    public JPanel getPanelGrammage(){
        if(this.panelGrammage==null){
            this.panelGrammage= new JPanel();
            panelGrammage.setLayout(new BoxLayout(panelGrammage,BoxLayout.Y_AXIS));
            panelGrammage.add(this.getCheckBoxGrammage80());
            panelGrammage.add(this.getCheckBoxGrammage100());


        }
        return panelGrammage;
    }
    public JLabel getLabelGrammage() {
        if (this.labelGrammage == null) {
            this.labelGrammage = new JLabel("Grammage");
        }
        return labelGrammage;
    }
    public JCheckBox getCheckBoxGrammage80() {
        if (this.checkBoxGrammage80 == null) {
            this.checkBoxGrammage80 = new JCheckBox("80 grammes");
        }
        return checkBoxGrammage80;
    }
    public JCheckBox getCheckBoxGrammage100() {
        if (this.checkBoxGrammage100 == null) {
            this.checkBoxGrammage100 = new JCheckBox("100 grammes");
        }
        return checkBoxGrammage100;
    }
    public JLabel getLabelCouleur() {
        if (this.labelCouleur == null) {
            this.labelCouleur = new JLabel("Couleur");
        }
        return labelCouleur;
    }
    public JComboBox getComboBoxCouleur() {
        if (this.comboBoxCouleur == null) {
            this.comboBoxCouleur = new JComboBox();
        }
        return comboBoxCouleur;
    }
    public JPanel getPanelButton(){
        if(panelButton == null){
            panelButton = new JPanel();

            panelButton.add(this.getButtonGauche());
            panelButton.add(this.getButtonFeuille());
            panelButton.add(this.getButtonEnregistrer());
            panelButton.add(this.getButtonBin());
            panelButton.add(this.getButtonDroite());
        }
        return panelButton;
    }
    public JButton getButtonGauche() {
        if (this.buttonGauche == null) {
            this.buttonGauche = new JButton(iconGauche);
        }
        return buttonGauche;
    }
    public JButton getButtonFeuille() {
        if (this.buttonFeuille == null) {
            this.buttonFeuille = new JButton(iconFeuille);
        }
        return buttonFeuille;
    }
    public JButton getButtonEnregistrer() {
        if (this.buttonEnregistrer == null) {
            this.buttonEnregistrer = new JButton(iconsave);
        }
        return buttonEnregistrer;
    }
    public JButton getButtonBin() {
        if (this.buttonBin == null) {
            this.buttonBin = new JButton(iconBin);
        }
        return buttonBin;
    }
    public JButton getButtonDroite() {
        if (this.buttonDroite == null) {
            this.buttonDroite = new JButton(iconForward);
        }
        return buttonDroite;
    }
}
