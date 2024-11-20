package View;

import controller.ControllerCurso;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JButton click;
    private JTable table1;

    public Main() {
        click.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsoleView console = new ConsoleView();
                ControllerCurso controllerCurso = new ControllerCurso(console);
                controllerCurso.obtenerCursos();

            }


        });
    }
}
