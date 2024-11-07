package test.java;
import java.sql.SQLException;

import View.ConsoleView;
import controller.ControllerCurso;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import da.CursosDao;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

        verify(mockView).mostrarMensaje("id: 3 | nombre: Matematicas | descripcion: C32024 | estado: Inactivo");

    }

}

