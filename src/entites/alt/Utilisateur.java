/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites.alt;

/**
 *
 * @author HP
 */
public class Utilisateur {

    private int id;
    private String prenom;
    private String nom;
    private String adresse;
    private String email;
    private String login;
    private String motdepasse;
    private String rolee;

    public Utilisateur(String prenom, String nom, String adresse, String email, String login, String motdepasse, String rolee) {

        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.login = login;
        this.motdepasse = motdepasse;
        this.rolee = rolee;

    }

    public Utilisateur(int id, String prenom, String nom, String adresse, String email, String login, String motdepasse, String rolee) {

        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.login = login;
        this.motdepasse = motdepasse;
        this.rolee = rolee;

    }

    public Utilisateur() {

    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getprenom() {
        return prenom;
    }

    public void setprenom(String prenom) {
        this.prenom = prenom;
    }

    public String getnom() {
        return nom;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getadresse() {
        return adresse;
    }

    public void setadresse(String adresse) {
        this.adresse = adresse;
    }

    public String getlogin() {
        return login;
    }

    public void setlogin(String login) {
        this.login = login;
    }

    public String getmotdepasse() {
        return motdepasse;
    }

    public void setmotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getrolee() {
        return "utilisateur";
    }

    public void setrolee(String rolee) {
        this.rolee = rolee;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
                + ", adresse=" + adresse + ", login=" + login + ", motdepasse=" + motdepasse + '}';
    }

}
