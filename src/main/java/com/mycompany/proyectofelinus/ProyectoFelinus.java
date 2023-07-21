package com.mycompany.proyectofelinus;

import controlador.control;
import modelo.usuario;
import vista.Login;

public class ProyectoFelinus {

    public static void main(String[] args) {
        usuario us = new usuario();
        Login in = new Login();

        control ctrl = new control(us, in);
        ctrl.iniciar();
        in.CampoPassword.setEchoChar('*');
        in.setVisible(true);
    }
}
