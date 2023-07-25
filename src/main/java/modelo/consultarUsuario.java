package modelo;

//@author Jesus
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import static modelo.ConexionDB.con;

public class consultarUsuario extends ConexionDB {

    public boolean log(usuario user) throws NoSuchAlgorithmException {
        try {

            PreparedStatement ps = null;
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

    public int getRolUsuario(usuario user) {
        int rolUsuario = 0; // Valor por defecto o algún valor que represente un rol inválido

        try {
            // Realiza la consulta para obtener el rol del usuario
            
            String obtenerRolQuery = "SELECT id_rol FROM usuario WHERE nombre_usuario=?";
            PreparedStatement obtenerRolPst = con.prepareStatement(obtenerRolQuery);
            obtenerRolPst.setString(1, user.getUsuario()); // Asumiendo que existe un método getId() en la clase Usuario para obtener el id_usuario
            ResultSet rs = obtenerRolPst.executeQuery();

            if (rs.next()) {
                rolUsuario = rs.getInt("id_rol");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción si es necesario
        }

        return rolUsuario;
    }

    public int contarErroresLog(usuario user) throws SQLException, NoSuchAlgorithmException {
        PreparedStatement ps = null;
        Connection cn = conectar();
        int intentos = 0;
        String sha2;
        String pbd;

        String query = "SELECT * FROM usuario WHERE nombre_usuario=?";
        ps = con.prepareStatement(query);
        ps.setString(1, user.getUsuario());
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            sha2 = getSHA256Hash(user.getPassword());
            pbd = rs.getString("contraseña");
            user.setIntentos(rs.getInt("IntentosAcceso"));
            if (!pbd.equals(sha2)) {
                String setQuery = "UPDATE usuario SET IntentosAcceso=? WHERE id_usuario=?";
                PreparedStatement setIntentosPst = con.prepareStatement(setQuery);
                setIntentosPst.setInt(1, (user.getIntentos() + 1));
                setIntentosPst.setInt(2, rs.getInt("id_usuario"));
                setIntentosPst.executeUpdate();
                intentos = user.getIntentos() + 1;
            } else {
                intentos = user.getIntentos(); // En este caso, la contraseña coincide, mantén el valor actual de intentos.
            }
        }
        return intentos;
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
