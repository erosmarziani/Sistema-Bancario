package src.ar.edu.utn.frbb.tup.vista;

import java.util.Scanner;

import src.ar.edu.utn.frbb.tup.menu.MenuOperaciones;
import src.ar.edu.utn.frbb.tup.modelo.Cuenta;

public class InterfazGrafica {
    
    Scanner scanner = new Scanner(System.in);
    
    MenuOperaciones operaciones = new MenuOperaciones();
    public void interfazPrincipal(){
        boolean salir = false;
        
        while (!salir) {
            System.out.println("######################");
            System.out.println("   SISTEMA BANCARIO   ");
            System.out.println("######################"); 
        
        
            System.out.println("1- Menu Clientes");
            System.out.println("2- Menu Cuentas");
            System.out.println("3- Realizar Operaciones");
            System.out.println("0- Salir del programa");

            System.out.print("Ingrese una opcion: ");
            String opcion = scanner.nextLine();

            System.out.println();
        
        
            switch (opcion) {
                case "1":
                    interfazClientes();
                    break;
                case "2":
                    interfazCuentas();
                    break;
                case "3":
                    realizarOperacion(operaciones.elegirCuenta());
                    break;
                case "0":
                    System.out.println("Gracias por utilizar el sistema bancario");   
                    salir = true;
                default:
                    break;
                }
            }
            
            scanner.close();
    }
    
    //Menu clientes
    private void interfazClientes() {
        System.out.println("#####################");
        System.out.println("    MENU CLIENTES    ");
        System.out.println("#####################");
        
        System.out.println("1- Ingresar un nuevo cliente");
        System.out.println("2- Modificar un cliente existente");
        System.out.println("3- Eliminar un cliente");
        System.out.println("0- Volver al menu principal");
        
        System.out.println("Ingrese una opcion: ");
        String opcion = scanner.nextLine();

        System.out.println(opcion);

        switch (opcion) {
            case "1":
                operaciones.ingresarCliente();
                break;
            case "2":
                
                operaciones.modificarCliente();
                break;
            case "3":
                operaciones.EliminarCliente();
                break;
            case "0":
                break;
            default:
                System.out.println("Ingrese una opcion correcta");
                break;
        }
    }

    //Menu Cuentas
    private void interfazCuentas() {
        boolean salir = false;
        while (!salir) {
            
            System.out.println("#######################");
            System.out.println("    MENU CUENTAS    ");
            System.out.println("#########################");
    
            System.out.println("1- Crear Cuenta");
            System.out.println("2- Ver Listado Cuentas");
            System.out.println("0- Volver al menu principal");
           String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    operaciones.ingresarCuenta();
                    break;
                case "2":
                    operaciones.mostrarCuentas();
                    break;
                case "0":
                    System.out.println("Volviendo al menu principal");
                    salir = true;
                    break;
                default:
                    break;
            }
        }
    }



public void realizarOperacion(Cuenta cuenta) {
    boolean salir = false;
    
    while (!salir) {
        System.out.println("----- MENU DE OPERACIONES -----");
        System.out.println("1. Depósito");
        System.out.println("2. Retiro");
        System.out.println("3. Transferencia");
        System.out.println("4. Consulta de Saldo");
        System.out.println("5- Consulta de Movimientos");
        System.out.println("0. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        
        String opcion = scanner.nextLine();
        
        switch (opcion) {
            case "1":
                operaciones.realizarDeposito(cuenta);
                break;
            case "2":
                operaciones.realizarRetiro(cuenta);
                break;
            case "3":
                operaciones.realizarTransferencia(cuenta);
                break;
            case "4":
                operaciones.consultarSaldo(cuenta);
                break;
            case "5":
                operaciones.mostrarMovimientos(cuenta);
            case "0":
                salir = true;
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
                break;
        }
    }
}

}