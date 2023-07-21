package controlador;

//@author Jesus
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.usuario;
import vista.Login;

public class control implements ActionListener {

    private usuario user;
    private Login view;

    public control(usuario user, Login view) {
        this.user = user;
        this.view = view;
        this.view.BtnIngresar.addActionListener(this);
    }

    public void iniciar() {
        view.setTitle("Ingresar");
        view.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        user.consultarUsuario(view.CampoUsuario.getText(), view.CampoPassword.getText());

    }
}
