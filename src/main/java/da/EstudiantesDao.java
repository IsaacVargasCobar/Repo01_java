package da;


import models.ModelEstudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EstudiantesDao {


    private Connection connecition;

    public EstudiantesDao(Connection connection) {
        this.connecition = connection;
    }

    public void agregarEstudiantes(ModelEstudiante objeto) throws SQLException {
        String query = "INSERT INTO `208320548_Estudiante`( `nombre` , `identificacion` , `email`, `estado`,`fechaNacimiento` ) values (?,?,?,?,?)";

        try (PreparedStatement stmt = connecition.prepareStatement(query)) {
            stmt.setString(1, objeto.getNombre());
            stmt.setString(2, objeto.getIdentificacion());
            stmt.setString(3, objeto.getEmail());
            stmt.setString(4, objeto.getEstado());
            stmt.setString(5, objeto.getFechaNacimiento());
            stmt.executeUpdate();
        }
    }

    public void modificarEstudiantes(ModelEstudiante objeto) throws SQLException {
        String query = "UPDATE  `208320548_Estudiante` SET `nombre`=? , `identificacion` =? , `email`=? , `estado`=?, `fechaNacimiento` =? WHERE `id` =?";

        try (PreparedStatement stmt = connecition.prepareStatement(query)) {
            stmt.setString(1, objeto.getNombre());
            stmt.setString(2, objeto.getIdentificacion());
            stmt.setString(3, objeto.getEmail());
            stmt.setString(4, objeto.getEstado());
            stmt.setString(5, objeto.getFechaNacimiento());
            stmt.setString(6, objeto.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminarEstudiantes(String id) throws SQLException {
        String query = "DELETE FROM `208320548_Estudiante` WHERE `id` = ?";
        try (PreparedStatement stmt = connecition.prepareStatement(query)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }

    public ArrayList<ModelEstudiante> obtenerEstudiantes() throws SQLException {
        ArrayList<ModelEstudiante> modelEstudiantes = new ArrayList<>();
        String query = "SELECT   `id`,`nombre` , `identificacion` , `email`, `estado`,`fechaNacimiento` FROM `208320548_Estudiante` ";
        try (PreparedStatement stmt = connecition.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ModelEstudiante objecto = new ModelEstudiante
                        (rs.getString("nombre"),
                                rs.getString("identificacion"),
                                rs.getString("email"),
                                rs.getString("estado"),
                                rs.getString("fechaNacimiento"));


                objecto.setId(rs.getString("id"));
                modelEstudiantes.add(objecto);

            }
            return modelEstudiantes;
        }
    }
}




