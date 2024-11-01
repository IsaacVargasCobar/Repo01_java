package models;

public class ModelProfesor extends ModelPersona {

    private String departamento;

    public ModelProfesor(String nombre, String identificacion, String email, String estado, String departamento) {
        super(nombre, identificacion, email, estado);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "ModelProfesor{" +
                "departamento='" + departamento + '\'' +
                ", id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", email='" + email + '\'' +
                ", estado='" + estado + '\'' +
                "} " + super.toString();
    }
}
