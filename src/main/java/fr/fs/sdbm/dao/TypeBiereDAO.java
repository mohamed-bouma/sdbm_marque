package fr.fs.sdbm.dao;



import fr.fs.sdbm.metier.TypeBiere;


import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class TypeBiereDAO extends DAO<TypeBiere, TypeBiere> {
    public TypeBiereDAO(Connection connexion) {
        super(connexion);
    }

    public ArrayList<TypeBiere> getAll() {
        ArrayList<TypeBiere> liste = new ArrayList<>();

        try (Statement stmt = connexion.createStatement()) {

            // Determine the column set column

            String strCmd = "SELECT id_typeBiere,nom_typeBiere from couleur order by nom_typeBiere";
            ResultSet rs = stmt.executeQuery(strCmd);
            TypeBiere typeBiereLue;
            while (rs.next()) {
                typeBiereLue = new TypeBiere(rs.getInt(1), rs.getString(2));

                liste.add(typeBiereLue);
            }
            rs.close();
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }


    @Override
    public TypeBiere getByID(int id) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public ArrayList<TypeBiere> getLike(TypeBiere objet) {
        // TODO Auto-generated method stub
        return new ArrayList<>();
    }
    @Override
    public boolean insert(TypeBiere objet) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(TypeBiere object) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(TypeBiere object) {
        // TODO Auto-generated method stub
        return false;
    }
}



