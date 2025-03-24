package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Participante {
    private String nombre;
    private String apellido;
    private int puntos = 0;
    private int id;

    public Participante(String nombre, String apellido,int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id=id;
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
}