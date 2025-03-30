package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Participante {
    private String nombre;
    private String apellido;
    private int puntos = 0;
    private int id;
    private String email;

    public Participante(String nombre, String apellido,int id,String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.email=email;
    }

    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getId() {
        return this.id;
    }

    public String getEmail(){
        return this.email;
    }
}