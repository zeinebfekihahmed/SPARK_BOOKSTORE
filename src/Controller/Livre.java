/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author ASUS
 */
public class Livre {

  
 private int id;
    private String nom;
    private double prix;
    private String nom_auteur ;
 private String date ;
  private String description ;
   private String catégorie ;
  private String image ;
    public Livre( String nom, double prix, String nom_auteur, String date, String description, String catégorie, String image) {
       
        this.nom = nom;
        this.prix = prix;
        this.nom_auteur = nom_auteur;
        this.date = date;
        this.description = description;
        this.catégorie = catégorie;
        this.image = image;
    }
   
  public Livre(int id, String nom, double prix, String nom_auteur, String date, String description, String catégorie) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.nom_auteur = nom_auteur;
        this.date = date;
        this.description = description;
        this.catégorie = catégorie;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCatégorie() {
        return catégorie;
    }

    public void setCatégorie(String catégorie) {
        this.catégorie = catégorie;
    }

    public Livre(String nom, double prix, String nom_auteur, String date, String description, String catégorie) {
        this.nom = nom;
        this.prix = prix;
        this.nom_auteur = nom_auteur;
        this.date = date;
        this.description = description;
        this.catégorie = catégorie;
    }

   
 

    public String getNom_auteur() {
        return nom_auteur;
    }

    public void setNom_auteur(String nom_auteur) {
        this.nom_auteur = nom_auteur;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Livre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix= prix;
    }

    @Override
    public String toString() {
        return "Nom_Livre=" + nom + ", Prix_Livre=" + prix +", Nom auteur="+nom_auteur+ ", Date_Edition="+date+", Description="+description+", Catégorie=" +catégorie+" }";
    }
}
      
