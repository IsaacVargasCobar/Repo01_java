package models;

public class ModelGrupo extends ModelClase {

    public ModelGrupo(String nombre, String descripcion, String estado) {
        super( nombre, descripcion, estado);
    }

    @Override
    public String toString() {
        return "ModelGrupo{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                "} " + super.toString();
    }
}
