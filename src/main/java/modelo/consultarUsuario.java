/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

//@author Jesus
import controlador.control;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.Home;
import vista.Principal;

public class consultarUsuario {

    
        try {
            //user.consultarUsuario(view.CampoUsuario.getText(), String.valueOf(view.CampoPassword.getPassword()));
            ConexionDB db = new ConexionDB();
        Connection cn = db.conectar();

        String nombreUsuario = view.CampoUsuario.getText();
        String passwordUsuario = new String(view.CampoPassword.getPassword());

        // Hasheamos la contraseña proporcionada por el usuario con SHA-256
        String hashedPasswordUsuario = getSHA256Hash(passwordUsuario);

        PreparedStatement pst = cn.prepareStatement("SELECT * FROM usuario WHERE nombre_usuario=?");
        pst.setString(1, nombreUsuario);

        ResultSet rs = pst.executeQuery();

        boolean usuarioEncontrado = false;
        while (rs.next()) {
            String usuarioBD = rs.getString("nombre_usuario");
            String passwordBD = rs.getString("contraseña");
            int intentosAcceso = rs.getInt("IntentosAcceso");

            // Hasheamos la contraseña almacenada en la base de datos con SHA-256
            String hashedPasswordBD = rs.getString("contraseña");

            if (nombreUsuario.equals(usuarioBD) && hashedPasswordUsuario.equals(hashedPasswordBD)) {
                usuarioEncontrado = true;
                user.setRol(rs.getInt(4));

                // Restablecer los intentos fallidos a cero
                if (intentosAcceso > 0) {
                    String resetIntentosQuery = "UPDATE usuario SET IntentosAcceso=0 WHERE id_usuario=?";
                    PreparedStatement resetPst = cn.prepareStatement(resetIntentosQuery);
                    resetPst.setInt(1, rs.getInt("id_usuario"));
                    resetPst.executeUpdate();
                }

                JOptionPane.showMessageDialog(null, "Login correcto. ¡Bienvenido " + usuarioBD + "!");
                switch (user.getRol()) {
                    case 1:
                        // Abre la ventana del Administrador
                        Principal admin = new Principal();
                        admin.setVisible(true);
                        break;
                    case 2:
                        // Abre la ventana del Administrador
                        ocultar();
                        Home home = new Home();
                        home.setVisible(true);
                        break;
                    // Agrega más casos para otros roles, si los tienes
                    default:
                        // Si el rol no se reconoce, muestra un mensaje de error
                        JOptionPane.showMessageDialog(null, "Rol no reconocido");
                        break;
                }
                break;
            }
        }

        if (!usuarioEncontrado) {
            // Incrementar los intentos fallidos
            String incrementIntentosQuery = "UPDATE usuario SET IntentosAcceso=IntentosAcceso+1 WHERE nombre_usuario=?";
            PreparedStatement incrementPst = cn.prepareStatement(incrementIntentosQuery);
            incrementPst.setString(1, nombreUsuario);
            incrementPst.executeUpdate();

            // Verificar si se alcanzó el límite de intentos fallidos (3)
            String checkIntentosQuery = "SELECT IntentosAcceso FROM usuario WHERE nombre_usuario=?";
            PreparedStatement checkPst = cn.prepareStatement(checkIntentosQuery);
            checkPst.setString(1, nombreUsuario);
            ResultSet checkRs = checkPst.executeQuery();

            if (checkRs.next()) {
                int intentosActuales = checkRs.getInt("IntentosAcceso");
                if (intentosActuales >= 3) {
                    JOptionPane.showMessageDialog(null, "Ha excedido el límite de intentos fallidos. Por favor, contacte al administrador.");
                    // Aquí podrías implementar alguna lógica adicional, como bloquear temporalmente la cuenta o registrar el intento fallido en un archivo de registro.
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            }
        }

    }
}
