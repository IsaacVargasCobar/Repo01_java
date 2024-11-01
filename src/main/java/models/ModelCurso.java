package models;

public class ModelCurso extends ModelClase {

    public ModelCurso(String nombre, String descripcion, String estado ) {
        super(nombre, descripcion, estado);
    }

    @Override
    public String toString() {
        return "ModelCurso{" +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                "} " + super.toString();
    }
}
