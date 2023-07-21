/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

//@author Jesus
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class usuario {

    private String usuario;
    private String password;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void consultarUsuario(String user, String pass) {
        // TODO add your handling code here:
        ConexionDB db = new ConexionDB();
        // Se inicializa a null
        String usuarioCorrecto = null;
        String passCorrecto = null;
        try {

            Connection cn = db.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT nombre_usuario, contraseña FROM usuario");
            ResultSet rs = pst.executeQuery();

            boolean usuarioEncontrado = false;

            while (rs.next()) {
                usuarioCorrecto = rs.getString("nombre_usuario");
                passCorrecto = rs.getString("contraseña");

                if (user.equals(usuarioCorrecto) && pass.equals(passCorrecto)) {
                    usuarioEncontrado = true;
                    JOptionPane.showMessageDialog(null, "Login correcto. ¡Bienvenido " + user + "!");
                    break;
                }
            }

            if (!usuarioEncontrado) {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }

    }
}
