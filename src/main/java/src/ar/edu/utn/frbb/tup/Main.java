package src.ar.edu.utn.frbb.tup;

import java.util.Scanner;

import src.ar.edu.utn.frbb.tup.vista.InterfazGrafica;

public class Main {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        InterfazGrafica interfaz = new InterfazGrafica();
        interfaz.interfazPrincipal();
    }
}