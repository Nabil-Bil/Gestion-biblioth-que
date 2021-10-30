package SGBD;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

    public static Connection connection()
    {
        Connection con=null;
        try {
           con= DriverManager.getConnection("jdbc:postgresql://by44qb0haw0soz5y9tuw-postgresql.services.clever-cloud.com/by44qb0haw0soz5y9tuw","uykbmcaoylda9mux9otp","OJpAILFvV2IsrU7MKDVg");

        }
        catch (Exception e)
        {
            System.out.println("Erreur de connextion a la base de données");
        }

        return con;
    }
}
