package com.mycompany.proyectofelinus;

import controlador.control;
import modelo.consultarUsuario;
import modelo.usuario;
import vista.Login;

public class ProyectoFelinus {

    public static void main(String[] args) {
        usuario us = new usuario();
        Login in = new Login();
        consultarUsuario acceso = new consultarUsuario();

        control ctrl = new control(us, in, acceso);
        ctrl.iniciar();
        in.setVisible(true);
    }
}
