/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Ghazi
 */
public class Favoris {

    private int id;

    private int idLivre;
    private int id_user;
    private String image;
    private String nomLivre;
    private double prix;

    public Favoris() {

    }

    public Favoris(String image, String nomLivre, double prix) {
        this.image = image;
        this.nomLivre = nomLivre;
        this.prix = prix;
    }

    public Favoris(int idLivre,int id_user) {

        this.idLivre=idLivre;
        this.id_user=id_user;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdLivre(int idLivre) {
        this.idLivre = idLivre;
    }

    public int getIdLivre() {
        return idLivre;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setNomLivre(String nomLivre) {
        this.nomLivre = nomLivre;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public String getNomLivre() {
        return nomLivre;
    }

    public double getPrix() {
        return prix;
    }



 

}
