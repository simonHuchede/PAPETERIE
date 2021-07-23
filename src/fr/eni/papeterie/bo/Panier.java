package fr.eni.papeterie.bo;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Panier {
    private float montant;
    private Ligne ligne;
    private List<Ligne> lignesPanier;

    public Panier() {
        this.montant = 0;
        this.lignesPanier = new ArrayList<>();
    }

    public float getMontant() {
        return montant;
    }
    public Ligne getLigne(int index){
        return this.lignesPanier.get(index);
    }
    public List getLignesPanier() {
        return lignesPanier;
    }
    public void addLigne(Article article ,int qte){
        Ligne ligneAajouter = new Ligne(article,qte);
        lignesPanier.add(ligneAajouter);
        this.montant = this.montant + (ligneAajouter.getPrix()*ligneAajouter.getQte());
    }
    public void removeLigne(int index){
        Ligne lignesAsupprimer = this.getLigne(index);
        this.montant = this.montant - (lignesAsupprimer.getPrix()*lignesAsupprimer.getQte());
        this.lignesPanier.remove(index);
    }
    public  void updateLigne(int index, int newQte){
    this.getLigne(index).setQte(newQte);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
