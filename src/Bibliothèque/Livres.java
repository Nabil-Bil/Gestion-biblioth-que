package Bibliothèque;


public class Livres {
    //Attributs
    private String code_livre,titre,auteur,type;

    //Constructeurs
    public Livres()
    {
    	 this.code_livre="";
         this.titre="";
         this.auteur="";
         this.type="";
    }

    public Livres(String code_livre,String titre,String auteur,String type)
    {
        this.code_livre=code_livre;
        this.titre=titre;
        this.auteur=auteur;
        this.type=type;
    }

    //Setters


    public void setCode_livre(String code_livre) {
        this.code_livre = code_livre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setType(String type) {
        this.type = type;
    }



    //Getters
    public String getCode_livre() {
        return code_livre;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Bibliothèque.Livres{" +
                "code_livre='" + code_livre + '\'' +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", type='" + type + '\'' +
                '}'+"\n--------------------------------------------------------------------------------------";
    }


}
