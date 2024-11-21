package test.java;

import View.ConsoleView;
import controller.ControllerGrupo;
import da.GruposDao;
import models.ModelCurso;
import models.ModelGrupo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class GruposControllerTest {
    @Mock
    private GruposDao mockGruposDao;
    @Mock
    private ConsoleView mockView;
    @InjectMocks
    private ControllerGrupo controllerGrupo;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testObtenerGrupos() throws SQLException {
        when(mockGruposDao.obtenerGrupo()).thenReturn(null);

        controllerGrupo.obtenerGrupos();

        verify(mockView).mostrarMensaje("id: 1 | nombre: Grupo1 | descripcion: Gupo22 | estado: GrupoActivo");

    }

    @Test
    public void testModificarGrupos() throws SQLException {

        String id = "1";
        String nombre = "Grupo1";
        String descripcion = "Gupo22";
        String estado = "GrupoActivo";

        ModelGrupo mockGrupo = new ModelGrupo(nombre, descripcion, estado);
        mockGrupo.setId(id);

        doNothing().when(mockGruposDao).modificarGrupo(mockGrupo);


        controllerGrupo.modificarGrupo(nombre, descripcion, estado, id);


        verify(mockView).mostrarMensaje("Datos actualizados");
    }
    @Test
    public void testEliminarGrupos() throws SQLException {

        String id = "5";

        doNothing().when(mockGruposDao).eliminarGrupo(id);

        controllerGrupo.eliminarGrupo(id);
        verify(mockView).mostrarMensaje("Grupo eliminado correctamente");
    }
    @Test
    public void testCrearGrupos() throws SQLException {


        String nombre = "NuevogrupoTEST";
        String descripcion = "NuevogrupoTEST";
        String estado = "NuevogrupoTEST";

        ModelGrupo mockGrupo = new ModelGrupo(nombre, descripcion, estado);

        doNothing().when(mockGruposDao).agregarGrupo(mockGrupo);


        controllerGrupo.agregarGrupos(nombre, descripcion, estado);



        verify(mockView).mostrarMensaje("Datos insertados");
    }

}
