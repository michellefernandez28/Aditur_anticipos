/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Login {

    // datos usuario y contra
    private final String usuarioCorrecto = "Admin01";
    private String contraseñaCorrecta = "Admin@1234";

    public boolean validarLogin(String usuario, String contraseña){

        // quitar espacios al inicio y final
        usuario = usuario.trim();
        contraseña = contraseña.trim();

        // validar campos vacíos
        if(usuario.isEmpty() || contraseña.isEmpty()){
            return false;
        }

        // comparar con los datos usu y contra
        return usuario.equals(usuarioCorrecto) && contraseña.equals(contraseñaCorrecta);

    }

}