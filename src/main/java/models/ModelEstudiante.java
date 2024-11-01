package models;

public class ModelEstudiante extends ModelPersona {

    private String fechaNacimiento;

    public ModelEstudiante(String nombre, String identificacion, String email, String estado, String fechaNacimiento ) {
        super(nombre, identificacion, email, estado);
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "ModelEstudiante{" +
                "fechaNacimiento=" + fechaNacimiento +
                ", id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", email='" + email + '\'' +
                ", estado='" + estado + '\'' +
                "} " + super.toString();
    }
}


