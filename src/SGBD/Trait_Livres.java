package SGBD;

import Bibliothèque.Livres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Trait_Livres {

    static Connection con=Connect.connection();

    public static Livres Recherche(String code_livre)
    {
        Livres livre=new Livres();
        
       
        try {
            PreparedStatement statement=con.prepareStatement("SELECT * FROM Livres where code_livre= ?");
            statement.setString(1,code_livre);

            ResultSet resultSet=statement.executeQuery();


            if(resultSet.next())
            {
                livre.setCode_livre(resultSet.getString(1));
                
                livre.setTitre(resultSet.getString(2));
                livre.setAuteur(resultSet.getString(3));
                livre.setType(resultSet.getString(4));
            }


        }
        catch (Exception e)
        {
            e.getMessage();
        }

        return livre;
    }
    
    public static ResultSet Recherche_result(String code_livre)
    {
        
        ResultSet resultSet=null;
        
       
        try {
            PreparedStatement statement=con.prepareStatement("SELECT * FROM Livres where code_livre= ?");
            statement.setString(1,code_livre);

            resultSet=statement.executeQuery();



        }
        catch (Exception e)
        {
            e.getMessage();
        }

        return resultSet;
    }

    public static ResultSet affichage()
    {
     
    	ResultSet resultSet=null;


        try
        {
            PreparedStatement statement=con.prepareStatement("SELECT * FROM livres");
            resultSet=statement.executeQuery();
         

        }
        catch (Exception e)
        {
            e.getMessage();
        }


		return  resultSet;

    }

    public static void add(Livres livre)
    {
        try
        {
            PreparedStatement statement=con.prepareStatement("INSERT INTO livres (code_livre,titre,auteur,type) VALUES(?,?,?,?)");

            statement.setString(1,livre.getCode_livre());
            statement.setString(2,livre.getTitre());
            statement.setString(3,livre.getAuteur());
            statement.setString(4,livre.getType());

            statement.execute();

        }
        catch (Exception e)
        {
            e.getMessage();
        }



    }

    public static void delete(String code_livre)
    {
        try
        {
            PreparedStatement statement=con.prepareStatement("delete from livres where code_livre=?");
            statement.setString(1,code_livre);
            statement.execute();

        }
        catch (Exception e)
        {
            e.getMessage();
        }

    }

    public static void update(Livres livre,String code_livre)
    {
        try {
                PreparedStatement statement=con.prepareStatement("UPDATE  livres SET code_livre=? , titre=? , auteur=? , type=? where code_livre=? ");
                statement.setString(1,livre.getCode_livre());
                statement.setString(2,livre.getTitre());
                statement.setString(3,livre.getAuteur());
                statement.setString(4,livre.getType());
                statement.setString(5,code_livre);

                statement.execute();



        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }


}
