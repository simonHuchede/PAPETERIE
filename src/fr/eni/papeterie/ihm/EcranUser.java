package fr.eni.papeterie.ihm;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EcranUser extends JFrame {
    public static final int GRAMMAGE_80 = 80;
    public static final int GRAMMAGE_100 = 100;
    private  int indexArticle;
    private JLabel labelReference;
   private JTextField txtReference;
   private JLabel labelDesignation;
   private JTextField txtDesignation;
   private JLabel labelMarque;
   private JTextField txtMarque;
   private JLabel labelStock;
   private JTextField txtStock;
   private JLabel labelPrix;
   private JTextField txtPrix;
   private JPanel panelType;
   private JLabel labelType;
   private ButtonGroup buttonGroupType;
   private JRadioButton radioTypeRamette;
   private JRadioButton radioTypeStylo;
   private JPanel panelGrammage;
   private JLabel labelGrammage;
   private ButtonGroup buttonGroupGrammage;
   private JCheckBox  checkBoxGrammage80;
   private JCheckBox  checkBoxGrammage100;
   private JLabel labelCouleur;
   private JComboBox comboBoxCouleur;
   private JPanel panelButton;
   private JButton buttonBack;
   private JButton buttonNew;
   private JButton buttonSave;
   private JButton buttonDelete;
   private JButton buttonForward;
   private List<Article> catalogue;
   private Article article;
   private int indexArcticle;


   private Icon iconBack = new ImageIcon(this.getClass().getResource("images/Back24.gif"));
   private Icon iconNew = new ImageIcon(this.getClass().getResource("images/New24.gif"));
   private Icon iconSave = new ImageIcon(this.getClass().getResource("images/Save24.gif"));
   private Icon iconDelete = new ImageIcon(this.getClass().getResource("images/Delete24.gif"));
   private Icon iconForward = new ImageIcon(this.getClass().getResource("images/Forward24.gif"));





    public EcranUser(){

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("detail Article");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel= new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc= new GridBagConstraints();
        this.setContentPane(panel);
        try {
            catalogue = CatalogueManager.getInstance().getCatalogue();
            System.out.println(catalogue);
        } catch (BLLException e) {
            e.printStackTrace();
        }

        afficheUnArticle(indexArticle);
        gbc.gridx=0;
        gbc.gridy=0;
        panel.add(this.getLabelReference(),gbc);
        gbc.insets = new Insets(01,3,5, 3);
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
        this.pack();
        this.setVisible(true);
    }

    private void afficheUnArticle(int indexArticle) {


            article=catalogue.get(indexArticle);
            getTxtReference().setText(article.getReference());
            getTxtDesignation().setText(article.getDesignation());
            getTxtMarque().setText(article.getMarque());
            getTxtStock().setText(String.valueOf(article.getQteStock()));
            getTxtPrix().setText(String.valueOf(article.getPrixUnitaire()));
            if(article instanceof Ramette){
                getRadioTypeRamette().setSelected(true);
                getComboBoxCouleur().setEnabled(false);
                getCheckBoxGrammage80().setEnabled(true);
                getCheckBoxGrammage100().setEnabled(true);
                if(((Ramette) article).getGrammage() == 80){
                    getCheckBoxGrammage80().setSelected(true);
                    getCheckBoxGrammage100().setSelected(false);
                }else {
                    getCheckBoxGrammage100().setSelected(true);
                    getCheckBoxGrammage80().setSelected(false);
                }
            }else if(article instanceof Stylo){
                getRadioTypeStylo().setSelected(true);
                getCheckBoxGrammage80().setEnabled(false);
                getCheckBoxGrammage100().setEnabled(false);
                getComboBoxCouleur().setEnabled(true);
                getComboBoxCouleur().setSelectedItem(((Stylo) article).getCouleur());

            }


    }
    public int getIndexArticle() {
        return indexArticle;
    }

    public  void setIndexArticle(int indexArticle) {
        indexArticle = indexArticle;
    }

    public JLabel getLabelReference() {
        if (this.labelReference == null) {
            this.labelReference = new JLabel("Réference");
        }
        return labelReference;
    }
    public JTextField getTxtReference() {
        if (this.txtReference == null) {
            this.txtReference = new JTextField(25);
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
            this.txtDesignation = new JTextField(25);
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
            this.txtMarque = new JTextField(25);
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
            this.txtStock = new JTextField(25);
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
            this.txtPrix = new JTextField(25);
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
            radioTypeStylo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(getRadioTypeStylo().isSelected()) {
                        getCheckBoxGrammage100().setEnabled(false);
                        getCheckBoxGrammage80().setEnabled(false);
                        getComboBoxCouleur().setEnabled(true);
                    }
                }
            });

        }
        return panelGrammage;
    }
    public JLabel getLabelGrammage() {
        if (this.labelGrammage == null) {
            this.labelGrammage = new JLabel("Grammage");
            radioTypeRamette.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(getRadioTypeRamette().isSelected()) {
                        getComboBoxCouleur().setEnabled(false);
                        getCheckBoxGrammage100().setEnabled(true);
                        getCheckBoxGrammage80().setEnabled(true);
                    }
                }
            });
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
            String[] couleurs ={"","noir","bleu","rouge","vert","jaune"};
            this.comboBoxCouleur = new JComboBox(couleurs);

        }
        return comboBoxCouleur;
    }
    public JPanel getPanelButton(){
        if(panelButton == null){
            panelButton = new JPanel();

            panelButton.add(this.getbuttonBack());
            panelButton.add(this.getButtonNew());
            panelButton.add(this.getButtonsave());
            panelButton.add(this.getButtonDelete());
            panelButton.add(this.getButtonForward());
        }
        return panelButton;
    }
    public JButton getbuttonBack() {
        if (this.buttonBack == null) {
            this.buttonBack = new JButton(iconBack);
            buttonBack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (indexArticle == -99) {
                        indexArticle = catalogue.size() - 2;
                    } else {
                        if (indexArticle == 0) {
                            indexArticle = catalogue.size() - 1;
                        } else {
                            indexArticle = getIndexArticle() - 1;
                        }
                        afficheUnArticle(indexArticle);

                    }
                }
            });
        }
        return buttonBack;
    }
    public JButton getButtonNew() {
        if (this.buttonNew == null) {
            this.buttonNew = new JButton(iconNew);
        buttonNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getTxtReference().setText("");
                getTxtDesignation().setText("");
                getTxtMarque().setText("");
                getTxtPrix().setText("");
                getTxtStock().setText("");
                getRadioTypeRamette().setSelected(true);
                getCheckBoxGrammage80().setSelected(false);
                getCheckBoxGrammage100().setSelected(false);
                getCheckBoxGrammage100().setEnabled(true);
                getCheckBoxGrammage80().setEnabled(true);
                getComboBoxCouleur().setSelectedIndex(0);
                getComboBoxCouleur().setEnabled(true);
                indexArticle=-99;

                }

        });
        }
        return buttonNew;
    }
    public JButton getButtonsave() {
        if (this.buttonSave == null) {
            this.buttonSave = new JButton(iconSave);
            buttonSave.addActionListener(new ActionListener() {
                @SneakyThrows
                @Override
                public void actionPerformed(ActionEvent e) {
                   // if (CatalogueManager.getInstance().getCatalogue(catalogue.get(indexArticle).getIdArticle())==-99) {
                        String marque = getTxtMarque().getText();
                        String ref = getTxtReference().getText();
                        String designation = getTxtDesignation().getText();
                        float pu = Float.parseFloat(getTxtPrix().getText());
                        int qte = Integer.parseInt(getTxtStock().getText());

                        if (getRadioTypeRamette().isSelected()) {
                            int grammage = 0;

                            if (getCheckBoxGrammage80().isSelected()) {
                                grammage = GRAMMAGE_80;
                            } else if (getCheckBoxGrammage100().isSelected()) {
                                grammage = GRAMMAGE_100;
                            }
                            Ramette ramette = new Ramette(ref, designation, marque, pu, qte, grammage);
                            article = ramette;
                        } else if (getRadioTypeStylo().isSelected()) {
                            String couleur = null;
                            couleur = String.valueOf(getComboBoxCouleur().getSelectedIndex());
                            Stylo stylo = new Stylo(ref, designation, marque, pu, qte, couleur);
                            article = stylo;
                        }
                        if (indexArticle == -99) {
                        CatalogueManager.getInstance().addArticle(article);
                        catalogue.add(article);
                        }else {
                            CatalogueManager.getInstance().getCatalogue();
                        CatalogueManager.getInstance().updateArticle(article);
                        }
                    }
            });
        }
        return buttonSave;
    }
    public JButton getButtonDelete() {
        if (this.buttonDelete == null) {
            this.buttonDelete = new JButton(iconDelete);
            buttonDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        CatalogueManager.getInstance().removeArticle(catalogue.get(indexArticle).getIdArticle());
                        catalogue= CatalogueManager.getInstance().getCatalogue();
                        if(indexArticle<catalogue.size()){
                            afficheUnArticle(indexArticle);
                        }else if(indexArticle==catalogue.size()){
                            afficheUnArticle(indexArticle-1);
                        }else if(catalogue.size() == 0){
                            getButtonNew().doClick();
                        }
                        catalogue= CatalogueManager.getInstance().getCatalogue();
                    } catch (BLLException bllException) {
                        bllException.printStackTrace();
                    }
                }
            });

        }
        return buttonDelete;
    }
    public JButton getButtonForward() {
        if (this.buttonForward == null) {
            this.buttonForward = new JButton(iconForward);
           buttonForward.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   if (indexArticle == -99) {
                       indexArticle = 0;
                   } else {
                       if (indexArticle < catalogue.size() - 1) {
                           indexArticle++;

                       } else {
                           indexArticle = 0;
                       }
                       afficheUnArticle(indexArticle);

                   }
               }


           });
        }
        return buttonForward;
    }
}
