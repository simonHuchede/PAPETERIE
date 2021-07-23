package fr.eni.papeterie.dal;

import fr.eni.papeterie.dal.jdbc.ArticleDAOJdbcImpl;

public class DAOFactory {
    public static ArticleDAO getArticleDAO(){
        ArticleDAO articleDAO = new ArticleDAOJdbcImpl();
        return  articleDAO;
    }
}
