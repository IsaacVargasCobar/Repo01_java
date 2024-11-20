package test.java;
import java.sql.SQLException;

import View.ConsoleView;
import controller.ControllerCurso;

import da.CursosDao;
import models.ModelCurso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;


public class CursoControllerTest {

    @Mock
    private CursosDao mockCursosDao;

    @Mock
    private ConsoleView mockView;

    @InjectMocks
    private ControllerCurso controllerCurso;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testObtenerCursos() throws SQLException{
        when(mockCursosDao.obtenerCursos()).thenReturn(null);

        controllerCurso.obtenerCursos();

        verify(mockView).mostrarMensaje("id: 5 | nombre: Grupoa | descripcion: descriopcionGrupo | estado: inactivo");

    }

    @Test
    public void testModificarCursos() throws SQLException {

        String id = "5";
        String nombre = "Grupoa";
        String descripcion = "descriopcionGrupo";
        String estado = "Inactivo";

        ModelCurso mockCurso = new ModelCurso(nombre, descripcion, estado);
        mockCurso.setId(id);

        doNothing().when(mockCursosDao).modificarCurso(mockCurso);


        controllerCurso.modificarCursos(nombre, descripcion, estado, id);


        verify(mockView).mostrarMensaje("Datos actualizados");
    }
    @Test
    public void testEliminarCursos() throws SQLException {

        String id = "1";

        doNothing().when(mockCursosDao).eliminarCurso(id);

        controllerCurso.eliminarCurso(id);
        verify(mockView).mostrarMensaje("Curso eliminado correctamente");
    }


}

