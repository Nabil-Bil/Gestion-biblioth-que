package Bibliothèque;



public class Abonnes {

    //Attributs
    private String matricule,nom,prenom,numero_telephone,specialite;
    private java.util.Date date_naissance,date_enregistrement;


    //Constructeurs
    public Abonnes()
    {
    	 this.matricule="";
         this.nom="";
         this.prenom="";
         this.date_naissance=null;
         this.date_enregistrement=null;
         this.numero_telephone="";
         this.specialite="";
    }
    public Abonnes(String matricule,String nom , String prenom , java.util.Date date_naissance,java.util.Date date_enregistrement,String numero_telephone,String specialite)
    {
        this.matricule=matricule;
        this.nom=nom;
        this.prenom=prenom;
        this.date_naissance=date_naissance;
        this.date_enregistrement=date_enregistrement;
        this.numero_telephone=numero_telephone;
        this.specialite=specialite;
    }

    //Setters

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDate_naissance(java.util.Date date_naissance) {
        this.date_naissance = date_naissance;
    }


    public void setDate_enregistrement(java.util.Date date_enregistrement) {
        this.date_enregistrement = date_enregistrement;
    }


    public void setNumero_telephone(String numero_telephone) {
        this.numero_telephone = numero_telephone;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    //Getters


    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public java.util.Date getDate_naissance() {
        return date_naissance;
    }

    public java.util.Date getDate_enregistrement() {
        return date_enregistrement;
    }

    public String getNumero_telephone() {
        return numero_telephone;
    }

    public String getSpecialite() {
        return specialite;
    }

    @Override
    public String toString() {
        return "Bibliothèque.Abonnes{" +
                "matricule='" + matricule + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numero_telephone='" + numero_telephone + '\'' +
                ", specialite='" + specialite + '\'' +
                ", date_naissance=" + date_naissance +
                ", date_enregistrement=" + date_enregistrement +
                '}';
    }
}
