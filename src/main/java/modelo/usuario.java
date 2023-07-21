
package modelo;

//@author Jesus

public class usuario {

    private String usuario;
    private String password;
    private int rol;

    public usuario() {
    }

    public usuario(String usuario, String password, int rol) {
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    

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

}
