package org.example;

import java.sql.*;

public class FacebookConnect {

    public static void main(String[] args) {

        String SQL_SELECT="select * from june2020.student";


        try(Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/june2020","root","root");
            PreparedStatement prestatement =con.prepareStatement(SQL_SELECT))
        {

            ResultSet resultset=prestatement.executeQuery();
            while (resultset.next()){

                int id=resultset.getInt("sid");
                String name=resultset.getString("sname");
                double sal= resultset.getDouble("ssalary");
                String desg= resultset.getString("sdesg");

                System.out.println("id:"+id+"name:"+name+"sal:"+sal+"desg:"+desg);
            }
        }catch(SQLException e){
            System.err.format("SQL State",e.getSQLState(),e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
