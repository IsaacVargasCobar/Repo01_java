package da;


import models.ModelProfesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfesoresDao {


    private Connection connecition;

    public ProfesoresDao(Connection connection) {
        this.connecition = connection;
    }

    public void agregarProfesores(ModelProfesor objeto) throws SQLException {
        String query = "INSERT INTO `208320548_Profesor`( `nombre` , `identificacion` , `email`, `estado`,`departamento` ) values (?,?,?,?,?)";

        try (PreparedStatement stmt = connecition.prepareStatement(query)) {
            stmt.setString(1, objeto.getNombre());
            stmt.setString(2, objeto.getIdentificacion());
            stmt.setString(3, objeto.getEmail());
            stmt.setString(4, objeto.getEstado());
            stmt.setString(5, objeto.getDepartamento());
            stmt.executeUpdate();
        }
    }

    public void modificarProfesores(ModelProfesor objeto) throws SQLException {
        String query = "UPDATE  `208320548_Profesor` SET `nombre`=? , `identificacion` =? , `email`=? , `estado`=?, `departamento` =? WHERE `id` =?";

        try (PreparedStatement stmt = connecition.prepareStatement(query)) {
            stmt.setString(1, objeto.getNombre());
            stmt.setString(2, objeto.getIdentificacion());
            stmt.setString(3, objeto.getEmail());
            stmt.setString(4, objeto.getEstado());
            stmt.setString(5, objeto.getDepartamento());
            stmt.setString(6, objeto.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminarProfesores(String id) throws SQLException {
        String query = "DELETE FROM `208320548_Profesor` WHERE `id` = ?";
        try (PreparedStatement stmt = connecition.prepareStatement(query)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }

    public ArrayList<ModelProfesor> obtenerProfesores() throws SQLException {
        ArrayList<ModelProfesor> modelProfesores = new ArrayList<>();
        String query = "SELECT `nombre` , `identificacion` , `email`, `estado`,`departamento`,`id` FROM `208320548_Profesor` ";
        try (PreparedStatement stmt = connecition.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ModelProfesor objeto = new ModelProfesor
                        (rs.getString("nombre"),
                                rs.getString("identificacion"),
                                rs.getString("email"),
                                rs.getString("estado"),
                                rs.getString("departamento"));


                objeto.setId(rs.getString("id"));
                modelProfesores.add(objeto);

            }
            return modelProfesores;
        }
    }
}





