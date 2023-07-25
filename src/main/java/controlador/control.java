package controlador;

//@author Jesus
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.consultarUsuario;
import modelo.usuario;
import vista.Home;
import vista.Login;
import vista.Principal;

public class control implements ActionListener {

    private usuario user;
    private Login view;
    private consultarUsuario login;

    public control(usuario user, Login view, consultarUsuario login) {
        this.user = user;
        this.view = view;
        this.login = login;
        this.view.BtnIngresar.addActionListener(this);
    }

    public void iniciar() {
        view.setTitle("Ingresar");
        view.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            user.setUsuario(view.CampoUsuario.getText());
            user.setPassword(String.valueOf(view.CampoPassword.getPassword()));

            int intentos = login.contarErroresLog(user); // Contar intentos fallidos solo una vez

            if (intentos >= 3) {
                // Si el número de intentos excede el límite, muestra un mensaje y no inicia sesión
                JOptionPane.showMessageDialog(null, "Limite de intentos excedidos. Consulte con el administrador");
            } else {
                if (login.log(user)) {
                    switch (login.getRolUsuario(user)) {
                        case 1:
                            // Abre la ventana del Administrador
                            Principal jefe = new Principal();
                            view.setVisible(false);
                            jefe.setVisible(true);
                            break;
                        case 2:
                            // Abre la ventana del Usuario normal
                            Home home = new Home();
                            view.setVisible(false);
                            home.setVisible(true);
                            break;
                        default:
                            // Si el rol no se reconoce, muestra un mensaje de error
                            JOptionPane.showMessageDialog(null, "Rol no reconocido");
                    }
                    // Agrega más casos para otros roles, si los tienes
                } else {
                    // Manejar el caso en que el inicio de sesión no fue exitoso
                    JOptionPane.showMessageDialog(null, "Inicio de sesión fallido");
                }
            }
        } catch (NoSuchAlgorithmException | SQLException ex) {
            Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
