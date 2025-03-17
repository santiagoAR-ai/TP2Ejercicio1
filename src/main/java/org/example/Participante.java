package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Participante {
    private String nombre;
    private String apellido;
    private int puntos = 0;

    public Participante(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }


    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
    }
}