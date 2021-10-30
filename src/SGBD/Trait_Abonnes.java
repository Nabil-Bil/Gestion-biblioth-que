package SGBD;

import Bibliothèque.Abonnes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Trait_Abonnes {

    static Connection con=Connect.connection();
    
    
    
    
    public static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
    
    public static java.util.Date convertSqlToUtil(java.sql.Date uDate)
    {
    	java.util.Date sDate= new java.util.Date(uDate.getTime());
    	return sDate;
    }
    
    public static String convertSqlToString(java.sql.Date uDate)
    {
    	DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
    	String sDate=df.format(uDate);
    	return sDate;
    }
    
    
    
    
    public static Abonnes Recherche(String matricule) {
        Abonnes abonnes = new Abonnes();
        try {
            
            PreparedStatement statement = con.prepareStatement("SELECT * FROM abonnes where matricule= ?");
            statement.setString(1, matricule);

            ResultSet resultSet = statement.executeQuery();


            if (resultSet.next()) {
                abonnes.setMatricule(resultSet.getString(1));
                abonnes.setNom(resultSet.getString(2));
                abonnes.setPrenom(resultSet.getString(3));
                abonnes.setDate_naissance(Trait_Abonnes.convertSqlToUtil(resultSet.getDate(4)));
       
                abonnes.setDate_enregistrement(Trait_Abonnes.convertSqlToUtil(resultSet.getDate(5)));
                abonnes.setNumero_telephone(resultSet.getString(6));
                abonnes.setSpecialite(resultSet.getString(7));

            }


        } catch (Exception e) {
            e.getMessage();
        }

        return abonnes;

    }
    
    public static ResultSet RechercheSet(String matricule) {
    	ResultSet resultSet =null;
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM abonnes where matricule= ?");
            statement.setString(1, matricule);

            resultSet = statement.executeQuery();


          

        } catch (Exception e) {
            e.getMessage();
        }

        return resultSet;

    }


    public static ResultSet affichage()
    {
       
       
        ResultSet resultSet=null;


        try
        {
            PreparedStatement statement=con.prepareStatement("SELECT * FROM abonnes");
            resultSet=statement.executeQuery();
           

        }
        catch (Exception e)
        {
            System.out.print("coucou");
        }


        return  resultSet;

    }

    public static void add(Abonnes abonnes)
    {
        try
        {
        	java.sql.Date date_naissance=Trait_Abonnes.convertUtilToSql(abonnes.getDate_naissance());
        	
        	java.sql.Date date_enregistrement=Trait_Abonnes.convertUtilToSql(abonnes.getDate_enregistrement());
            PreparedStatement statement=con.prepareStatement("INSERT INTO abonnes (matricule,nom,prenom,date_naissance,date_enregistrement,numero_telephone,specialite) values (?,?,?,?,?,?,?)");
            
            
            statement.setString(1,abonnes.getMatricule());
            statement.setString(2,abonnes.getNom());
            statement.setString(3,abonnes.getPrenom());
            statement.setDate(4,date_naissance);
            statement.setDate(5,date_enregistrement);
            statement.setString(6,abonnes.getNumero_telephone());
            statement.setString(7,abonnes.getSpecialite());

            statement.execute();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    public static void delete(String matricule)
    {
        try
        {
            PreparedStatement statement=con.prepareStatement("delete from abonnes where matricule=?");
            statement.setString(1,matricule);
            statement.execute();

        }
        catch (Exception e)
        {
            e.getMessage();
        }

    }

    public static void update(Abonnes abonnes,String matricule)
    {
        try {
            PreparedStatement statement=con.prepareStatement("UPDATE  abonnes SET matricule=? , nom=? , prenom=? , date_naissance=? , date_enregistrement=? , numero_telephone=? , specialite =? where matricule=? ");
            statement.setString(1,abonnes.getMatricule());
            statement.setString(2,abonnes.getNom());
            statement.setString(3,abonnes.getPrenom());
            statement.setDate(4,Trait_Abonnes.convertUtilToSql(abonnes.getDate_naissance()));
            statement.setDate(5,Trait_Abonnes.convertUtilToSql(abonnes.getDate_enregistrement()));
            statement.setString(6,abonnes.getNumero_telephone());
            statement.setString(7,abonnes.getSpecialite());
            statement.setString(8,matricule);

            statement.execute();



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
