package fr.eni.papeterie.dal.jdbc;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAOJdbcImpl implements ArticleDAO {
    final String SQL_DELETE = "DELETE FROM Articles WHERE idArticle = ?;";

    public final String SQL_INSERT = "INSERT INTO Articles (reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type) values(?,?,?,?,?,?,?,?);";
    public static final String SQL_UPDATE = "UPDATE Articles SET marque = ?, reference= ?, designation = ?, prixUnitaire =?," +
            "qteStock = ?, grammage = ?, couleur = ?,type= ? WHERE idArticle= ?;";

    public Connection getConnection(){
        return null;
    }



    public ArticleDAOJdbcImpl() {
    }

    public Article selectById(int id) throws DALException{

        Article article = null;
        try (Connection connection = JdbcTools.getConnection()) {
            String sql = "SELECT idArticle, reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type From Articles" +
                    " WHERE idArticle = ?;";
            PreparedStatement unStmt = connection.prepareStatement(sql);

            unStmt.setInt(1, id);
            ResultSet rs = unStmt.executeQuery();
            while (rs.next()) {
                int identifiant = rs.getInt("idArticle");
                String reference = rs.getString("reference");
                String marque = rs.getString("marque");
                String designation = rs.getString("designation");
                float prixUnitaire = rs.getFloat("prixUnitaire");
                int quantiteStock = rs.getInt("qteStock");
                int grammage = rs.getInt("grammage");
                String couleur = rs.getString("couleur");
                String type = rs.getString("type");
                if (type.trim().equals("STYLO")) {
                    article = new Stylo(identifiant, reference, marque, designation, prixUnitaire, quantiteStock, couleur);
                } else if (type.trim().equalsIgnoreCase("RAMETTE")) {
                    article = new Ramette(identifiant, reference, marque, designation, prixUnitaire, quantiteStock, grammage);
                }
            }

        } catch (SQLException e) {
            throw new DALException("erreur dans la méthode selectById");
        }

        return article;
    }

    public List<Article> selectAll() throws DALException {
        List<Article> listeArticle = new ArrayList<Article>();
        Article article;

        try (Connection connection = JdbcTools.getConnection()) {
            String sql2 = "SELECT idArticle, reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type From Articles";
            PreparedStatement stmt = connection.prepareStatement(sql2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int identifiant = rs.getInt("idArticle");
                String reference = rs.getString("reference");
                String marque = rs.getString("marque");
                String designation = rs.getString("designation");
                float prixUnitaire = rs.getFloat("prixUnitaire");
                int quantiteStock = rs.getInt("qteStock");
                int grammage = rs.getInt("grammage");
                String couleur = rs.getString("couleur");
                String type = rs.getString("type");

                if (type.trim().equalsIgnoreCase("STYLO")) {
                    article = new Stylo(identifiant, reference, marque, designation, prixUnitaire, quantiteStock, couleur);
                    listeArticle.add(article);
                } else if (type.trim().equalsIgnoreCase("RAMETTE")) {
                    article = new Ramette(identifiant, reference, marque, designation, prixUnitaire, quantiteStock, grammage);
                    listeArticle.add(article);
                }
            }
            stmt.executeQuery();
        } catch (SQLException e) {
            throw new DALException("erreur dans la méthode selectAll");
        }


        return listeArticle;
    }

    public void update(Article article) throws DALException {
        try (Connection connection = JdbcTools.getConnection()) {
            PreparedStatement etatUpdate = connection.prepareStatement(SQL_UPDATE);
            etatUpdate.setString(1, article.getMarque());
            etatUpdate.setString(2, article.getReference());
            etatUpdate.setString(3, article.getDesignation());
            etatUpdate.setFloat(4, article.getPrixUnitaire());
            etatUpdate.setInt(5, article.getQteStock());
            if (article instanceof Ramette) {
                etatUpdate.setInt(6, ((Ramette) article).getGrammage());
                etatUpdate.setNull(7, Types.VARCHAR);
                etatUpdate.setString(8, "RAMETTE");

            } else if (article instanceof Stylo) {
                etatUpdate.setNull(6, Types.INTEGER);
                etatUpdate.setString(7, ((Stylo) article).getCouleur());
                etatUpdate.setString(8, "STYLO");

            }
            etatUpdate.setInt(9, article.getIdArticle());
            etatUpdate.executeUpdate();

        } catch (SQLException e) {
            throw new DALException("erreur dans la méthode update");
        }

    }

    public void delete(int id) throws DALException{

        try (Connection connection = JdbcTools.getConnection()) {

            PreparedStatement reqDelete = connection.prepareStatement(this.SQL_DELETE);
            reqDelete.setInt(1, id);
            reqDelete.executeUpdate();
        } catch (SQLException e) {
            throw new DALException("erreur dans la méthode delete");
        }
    }

    public void insert(Article article) throws DALException {

        try (Connection connection = JdbcTools.getConnection()) {
            PreparedStatement etat = connection.prepareStatement(this.SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            etat.setString(2, article.getMarque());
            etat.setString(1, article.getReference());
            etat.setString(3, article.getDesignation());
            etat.setFloat(4, article.getPrixUnitaire());
            etat.setInt(5, article.getQteStock());
            if (article instanceof Ramette) {
                etat.setInt(6, ((Ramette) article).getGrammage());
                etat.setNull(7, Types.VARCHAR);
                etat.setString(8, "RAMETTE");
            } else if (article instanceof Stylo) {
                etat.setNull(6, Types.INTEGER);
                etat.setString(7, ((Stylo) article).getCouleur());
                etat.setString(8, "STYLO");
            }
            etat.executeUpdate();
            ResultSet clesGenerees = etat.getGeneratedKeys();
            if (clesGenerees.next()) {
                int idGenere = clesGenerees.getInt(1);
                article.setIdArticle(idGenere);
            }

        } catch (SQLException e) {
            throw new DALException("erreur dans la méthode insert");
        }
    }

    public List<Article> selectByMarque(String marque) throws DALException{
        Article article_;
        List<Article> articles = new ArrayList<>();
        try (Connection connection = JdbcTools.getConnection()) {
            String sql_Marque = "SELECT idArticle, reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type From Articles" +
                    " WHERE marque = ?;";
            PreparedStatement etatByMarque = connection.prepareStatement(sql_Marque);

            etatByMarque.setString(1, marque);
            ResultSet rs = etatByMarque.executeQuery();
            while (rs.next()) {
                int identifiant = rs.getInt("idArticle");
                String reference = rs.getString("reference");
                String marque_ = rs.getString("marque");
                String designation = rs.getString("designation");
                float prixUnitaire = rs.getFloat("prixUnitaire");
                int quantiteStock = rs.getInt("qteStock");
                int grammage = rs.getInt("grammage");
                String couleur = rs.getString("couleur");
                String type = rs.getString("type");
                if (type.trim().equals("STYLO")) {
                    article_ = new Stylo(identifiant, reference, marque, designation, prixUnitaire, quantiteStock, couleur);
                    articles.add(article_);
                } else if (type.trim().equalsIgnoreCase("RAMETTE")) {
                    article_ = new Ramette(identifiant, reference, marque, designation, prixUnitaire, quantiteStock, grammage);
                    articles.add(article_);
                }
            }


        } catch (SQLException e) {
            throw new DALException("erreur dans la méthode selectByMarque");
        }
        return articles;
    }

    public List<Article> selectByMotCle(String motCle) throws DALException{
        Article articleMotCle;
        List<Article> articlesMotCle = new ArrayList<>();
        try (Connection connection = JdbcTools.getConnection()) {
            String sql_MotCle = "SELECT idArticle, reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type From Articles" +
                    " WHERE marque LIKE ? OR designation= ?;";
            PreparedStatement etatByMotCle = connection.prepareStatement(sql_MotCle);

            etatByMotCle.setString(1, motCle);
            etatByMotCle.setString(2, motCle);
            ResultSet rs = etatByMotCle.executeQuery();
            while (rs.next()) {
                int identifiant = rs.getInt("idArticle");
                String reference = rs.getString("reference");
                String marque = rs.getString("marque");
                String designation = rs.getString("designation");
                float prixUnitaire = rs.getFloat("prixUnitaire");
                int quantiteStock = rs.getInt("qteStock");
                int grammage = rs.getInt("grammage");
                String couleur = rs.getString("couleur");
                String type = rs.getString("type");
                if (type.trim().equals("STYLO")) {
                    articleMotCle = new Stylo(identifiant, reference, marque, designation, prixUnitaire, quantiteStock, couleur);
                    articlesMotCle.add(articleMotCle);
                } else if (type.trim().equalsIgnoreCase("RAMETTE")) {
                    articleMotCle = new Ramette(identifiant, reference, marque, designation, prixUnitaire, quantiteStock, grammage);
                    articlesMotCle.add(articleMotCle);
                }
            }


        } catch (SQLException e) {
            throw  new DALException("erreur dans la méthode selectByMotCle");
        }
        return articlesMotCle;
    }
}