package fr.eni.papeterie.bll;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Panier;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;
import fr.eni.papeterie.dal.DAOFactory;
import fr.eni.papeterie.dal.jdbc.ArticleDAOJdbcImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CatalogueManager {
    private ArticleDAO daoArticle;

    private static CatalogueManager instance;

    public static CatalogueManager getInstance() throws BLLException {
        if (instance == null) {
            instance = new CatalogueManager();
        }
        return instance;
    }

    CatalogueManager() throws BLLException {
        this.daoArticle = DAOFactory.getArticleDAO();
    }

    public List<Article> getCatalogue() throws BLLException {
        List<Article> catalogue;
        try {
            catalogue = daoArticle.selectAll();
        } catch (DALException e) {
            throw new BLLException("erreur dans la méthode getCatalogue");
        }
        return catalogue;
    }

    public void addArticle(Article a) throws BLLException {
        try {
            validerArticle(a);
            daoArticle.insert(a);

        } catch (DALException e) {
            throw new BLLException("erreur dans la méthode addArticle");
        }
    }

    public void updateArticle(Article a) throws BLLException {
        try {
            validerArticle(a);
            daoArticle.update(a);
        } catch (DALException e) {
            throw new BLLException("erreur dans la méthode updateAricle");
        }
    }

    public void removeArticle(int index) throws BLLException {
        try {

            daoArticle.delete(index);
        } catch (DALException e) {
            throw new BLLException("erreur dans la méthode removeArticle");
        }
    }

    public void validerArticle(Article a) throws BLLException {

        if (a.getMarque() == null || a.getMarque().equalsIgnoreCase("")
                || a.getReference() == null || a.getReference().equalsIgnoreCase("")
                || a.getDesignation() == null || a.getDesignation().equalsIgnoreCase("")
                || a.getPrixUnitaire() < 0.f
                || a.getQteStock() < 0) {
            throw new BLLException("erreur ");
        }
        if (a instanceof Stylo) {
            if (
                    ((Stylo) a).getCouleur() == null || ((Stylo) a).getCouleur().equalsIgnoreCase("")) {
                throw new BLLException("erreur stylo");
            }
        } else if (a instanceof Ramette) {
            if (((Ramette) a).getGrammage() < 0) {
                throw new BLLException("erreur Ramette");
            }
        }
    }

        public Article getArticle ( int index) throws BLLException {
            Article article;
            try {
                article = daoArticle.selectById(index);
            } catch (DALException e) {
                throw new BLLException("erreur dans la méthode getArticle");
            }
            return article;
        }

    }
