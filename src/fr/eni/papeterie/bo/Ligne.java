package fr.eni.papeterie.bo;

public class Ligne {


    protected  int qte;
    private Article article;

    public Ligne(Article article, int qte){
         this.article= article;
         this.qte = qte;
    }

    public int getQte() {
        return qte;
    }

    public Article getArticle() {
        return article;
    }

    private void setArticle(Article article) {
        this.article = article;
    }
   public float getPrix(){
        return this.article.getPrixUnitaire();
   }

    public void setQte(int qte) {
        this.qte = qte;
    }

    @Override
    public String toString() {
        return "Ligne{" +
                "article=" + article +
                '}';
    }
}
