package da;

import models.ModelGrupo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class GruposDao {

    private Connection connecition;

    public GruposDao (Connection connection){
        this.connecition = connection;
    }

    public void agregarGrupo(ModelGrupo objeto) throws SQLException {
        String query = "INSERT INTO `208320548_Grupo`( `nombre` , `descripcion` , `estado`) values (?,?,?)";

        try(PreparedStatement stmt = connecition.prepareStatement(query)){
            stmt.setString(1,objeto.getNombre());
            stmt.setString(2,objeto.getDescripcion());
            stmt.setString(3,objeto.getEstado());
            stmt.executeUpdate();
        }
    }

    public void modificarGrupo(ModelGrupo objeto) throws SQLException {
        String query = "UPDATE  `208320548_Grupo` SET `nombre`=? , `descripcion` =? , `estado`=? WHERE `id` =?";

        try(PreparedStatement stmt = connecition.prepareStatement(query)){
            stmt.setString(1,objeto.getNombre());
            stmt.setString(2,objeto.getDescripcion());
            stmt.setString(3,objeto.getEstado());
            stmt.setString(4,objeto.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminarGrupo(String id) throws SQLException {
        String query = "DELETE FROM `208320548_Grupo` WHERE `id` = ?";
        try(PreparedStatement stmt = connecition.prepareStatement(query)){
            stmt.setString(1,id);
            stmt.executeUpdate();
        }
    }

    public ArrayList<ModelGrupo> obtenerGrupo() throws SQLException{
        ArrayList<ModelGrupo> modelGrupos = new ArrayList<>();
        String query = "SELECT `id`, `nombre`, `descripcion` , `estado` FROM `208320548_Grupo` ";
        try(PreparedStatement stmt = connecition.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                ModelGrupo objecto = new ModelGrupo
                        (rs.getString("nombre"),
                                rs.getString("descripcion"),
                                rs.getString("estado"));


                objecto.setId(rs.getString("id"));
                modelGrupos.add(objecto);

            }
            return modelGrupos;
        }
    }


}
