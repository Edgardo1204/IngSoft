package modelo;

//@author Jesus
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static modelo.ConexionDB.con;

public class consultarUsuario {

    public boolean log(usuario user) throws NoSuchAlgorithmException {
        try {

            PreparedStatement ps = null;
            ConexionDB db = new ConexionDB();
            Connection cn = db.conectar();
            ResultSet rs = null;
            String queryInsert = "SELECT * FROM usuario WHERE nombre_usuario=? AND contraseña=?";

            String pass = user.getPassword();
            String passSha2 = getSHA256Hash(pass);
            ps = con.prepareStatement(queryInsert);
            ps.setString(1, user.getUsuario());
            ps.setString(2, passSha2);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;

            } else {
                return false;
            }

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    private String getSHA256Hash(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(input.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }

}
