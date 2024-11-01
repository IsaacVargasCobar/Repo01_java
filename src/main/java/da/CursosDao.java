package da;

import models.ModelCurso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursosDao {

    private Connection connecition;

    public CursosDao (Connection connection){
        this.connecition = connection;
    }

    public void agregarCurso(ModelCurso objeto) throws SQLException {
        String query = "INSERT INTO `208320548_Curso`( `nombre` , `descripcion` , `estado`) values (?,?,?)";

        try(PreparedStatement stmt = connecition.prepareStatement(query)){
            stmt.setString(1,objeto.getNombre());
            stmt.setString(2,objeto.getDescripcion());
            stmt.setString(3,objeto.getEstado());
            stmt.executeUpdate();
        }
    }

    public void modificarCurso(ModelCurso objeto) throws SQLException {
        String query = "UPDATE  `208320548_Curso` SET `nombre`=? , `descripcion` =? , `estado`=? WHERE `id` =?";

        try(PreparedStatement stmt = connecition.prepareStatement(query)){
            stmt.setString(1,objeto.getNombre());
            stmt.setString(2,objeto.getDescripcion());
            stmt.setString(3,objeto.getEstado());
            stmt.setString(4,objeto.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminarCurso(String id) throws SQLException {
        String query = "DELETE FROM `208320548_Curso` WHERE `id` = ?";
        try(PreparedStatement stmt = connecition.prepareStatement(query)){
            stmt.setString(1,id);
            stmt.executeUpdate();
        }
    }

    public ArrayList<ModelCurso> obtenerCursos() throws SQLException{
        ArrayList<ModelCurso> modelCursos = new ArrayList<>();
        String query = "SELECT `id`, `nombre`, `descripcion` , `estado` FROM `208320548_Curso` ";
        try(PreparedStatement stmt = connecition.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
            ModelCurso objecto = new ModelCurso(
                    rs.getString("nombre"),
                rs.getString("descripcion"),
                        rs.getString("estado"));


                objecto.setId(rs.getString("id"));
            modelCursos.add(objecto);

            }
        return modelCursos;
        }
    }


}
