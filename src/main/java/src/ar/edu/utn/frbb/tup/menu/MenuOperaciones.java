package src.ar.edu.utn.frbb.tup.menu;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import src.ar.edu.utn.frbb.tup.modelo.Cliente;
import src.ar.edu.utn.frbb.tup.modelo.Cuenta;
import src.ar.edu.utn.frbb.tup.modelo.MovimientoCuenta;
import src.ar.edu.utn.frbb.tup.modelo.TipoOperacion;
public class MenuOperaciones {
    
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Cuenta> cuentas = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


    public List<Cliente> getClientes(){
        return clientes;
    }


    public Cliente ingresarCliente(){

        System.out.println("Ingrese el numero de documento: ");
        String dni = scanner.nextLine();

        if (buscarClientePorDni(dni) != null) {
            System.out.println("Ya existe un cliente con el numero de documento");
            return null;
        }

        System.out.println("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido del cliente: ");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese su numero de telefono: ");
        String telefono = scanner.nextLine();

        System.out.println("Ingrese su domicilio: ");
        String domicilio = scanner.nextLine();

        String tipoPersona;
        do{
        System.out.println("Ingrese el tipo de persona (J) Juridica o (F) Fisica: ");
         tipoPersona = scanner.nextLine().toUpperCase();
        } while(!tipoPersona.equals("J") && !tipoPersona.equals("F"));
        tipoPersona = tipoPersona.equals("J") ? "Juridica":"Fisica";


        
        Cliente cliente = new Cliente(dni, nombre, apellido, domicilio, telefono, tipoPersona);
    
        clientes.add(cliente);
        System.out.println("Cliente agregado con exito!");
        return cliente;
        }


        private Cliente buscarClientePorDni(String dni) {
            for (Cliente cliente : clientes) {
                if (dni.equals(cliente.getDniCliente())) {
                    return cliente;
                }
            }
            return null;

        }

        public void EliminarCliente(){
            System.out.println("Ingrese el dni del cliente que desea eliminar");
            String dniIngresado = scanner.nextLine();
            Cliente clienteAEliminar = buscarClientePorDni(dniIngresado);
            if (clienteAEliminar == null) {
                System.out.println("No se encontro ningun cliente con ese dni");
            }else{
                clientes.remove(clienteAEliminar);
                System.out.println("Cliente eliminado exitosamente");
            }
        }
        
        public void modificarCliente(){
            System.out.println("Ingrese el dni del cliente que desea modificar: ");
            String dniIngresado = scanner.nextLine();
            Cliente clienteAModificar = buscarClientePorDni(dniIngresado);
            if (clienteAModificar != null) {
                System.out.println("Ingrese el nuevo nombre del cliente: ");
                String nuevoNombre = scanner.nextLine();
                clienteAModificar.setNombre(nuevoNombre);
                    
                System.out.println("Ingrese el nuevo apellido del cliente: ");
                String nuevoApellido = scanner.nextLine();
                clienteAModificar.setApellido(nuevoApellido);
                    
                System.out.println("Ingrese el nuevo domicilio del cliente: ");
                String nuevoDomicilio = scanner.nextLine();
                clienteAModificar.setDireccion(nuevoDomicilio);
                    
                    System.out.println("Ingrese el nuevo telefono del usuario: ");
                    String nuevoTelefono = scanner.nextLine();
                    clienteAModificar.setTelefono(nuevoTelefono);
                    
                    System.out.println("Cliente modificado exitosamente");
                    return;
            }else{
                    System.out.println("No se ha encontrado el cliente");
                }
            
        }
        
        public Cuenta ingresarCuenta(){
    
           LocalDate fechaApertura = LocalDate.now();
           String tipoCuenta;
           do{
    
            System.out.println("Ingrese el tipo de cuenta (1) Caja de Ahorro o (2) Cuenta Corriente: ");
            tipoCuenta = scanner.nextLine();
    
           }while(!tipoCuenta.equals("1") && !tipoCuenta.equals("2"));
           tipoCuenta = tipoCuenta.equals("1") ? "Caja de Ahorro" : "Cuenta Corriente";
    
           System.out.println("Ingrese un cliente al cual desea asociarle");
           Cliente clienteCuenta;
           String dniIngresado = scanner.nextLine();
                clienteCuenta=buscarClientePorDni(dniIngresado);
                
           if (clienteCuenta == null) {
               System.out.println("No se ha encontrado el cliente, ingrese uno correcto");
                return null;
           }

            MovimientoCuenta nuevoMovimiento = new MovimientoCuenta(TipoOperacion.ALTA, 0, LocalDateTime.now());
            
            Cuenta cuenta = new Cuenta(tipoCuenta, 0, fechaApertura, clienteCuenta);

            cuenta.agregarMovimiento(nuevoMovimiento);
            cuentas.add(cuenta);
            return cuenta;
           }
    
        public void mostrarCuentas(){
            for(Cuenta cuenta: cuentas){
                System.out.println("Numero de cuenta: " + cuenta.getIdCuenta());
                System.out.println("Nombre del titular: " + cuenta.getClienteAsociado());
                System.out.println("Tipo de cuenta: " + cuenta.getTipoCuenta());
                System.out.println("CBU: " + cuenta.getCbu());
                System.out.println("Saldo: $" + cuenta.getSaldo());
                System.out.println();
            }
        }
        
            public void realizarDeposito(Cuenta cuenta) {
                try{
                System.out.print("Ingrese el monto a depositar: ");
                double monto = Double.parseDouble(scanner.nextLine());
                cuenta.ingresarDeposito(monto);
                System.out.println("Depósito realizado con éxito.");
                MovimientoCuenta nuevoMovimiento = new MovimientoCuenta(TipoOperacion.DEPOSITO, monto, LocalDateTime.now());
                cuenta.agregarMovimiento(nuevoMovimiento);
                } catch (NumberFormatException e){
                    System.out.println("Error: el valor ingresado no es un valor numerico. Intente nuevamente.");
                }
            }
    

        public void realizarRetiro(Cuenta cuenta) {
            try{
            System.out.print("Ingrese el monto a retirar: ");
            double monto = Double.parseDouble(scanner.nextLine());
            cuenta.retirarDinero(monto);
            MovimientoCuenta nuevoMovimiento = new MovimientoCuenta(TipoOperacion.RETIRO, monto, LocalDateTime.now());
            cuenta.agregarMovimiento(nuevoMovimiento);
            } catch (NumberFormatException e ){
                System.out.println("Error: el valor ingresado no es un valor numerico. Intente nuevamente. ");
            }
        }
    
        public void realizarTransferencia(Cuenta cuentaManejada) {
            System.out.println("Ingrese el cbu de la cuenta a transferir");
            String cbuIngresado = scanner.nextLine();
            for(Cuenta cuentaDepositada: cuentas){
                if (cbuIngresado.equals(cuentaDepositada.getCbu())) {
                    System.out.println("Ingrese el importe a depositar");
                    double montoTransferido = Double.parseDouble(scanner.nextLine());
                    if (cuentaManejada.getSaldo() < montoTransferido) {
                        System.out.println("No tiene fondos suficientes para realizar esta operacion");
                    }else{
                        cuentaManejada.setSaldo(cuentaManejada.getSaldo() - montoTransferido);
                        cuentaDepositada.setSaldo(cuentaDepositada.getSaldo()+ montoTransferido);
                        MovimientoCuenta nuevMovimiento = new MovimientoCuenta(TipoOperacion.TRANSFERENCIA_ENVIADA, montoTransferido, LocalDateTime.now());
                        MovimientoCuenta nuevMovimiento2 = new MovimientoCuenta(TipoOperacion.TRANSFERENCIA_RECIBIDA, montoTransferido, LocalDateTime.now());

                        cuentaManejada.agregarMovimiento(nuevMovimiento);
                        cuentaDepositada.agregarMovimiento(nuevMovimiento2);
                    }
                }
            }
            System.out.println("No se ha encontrado ninguna cuenta relacionada a ese cbu");

        }

        public void mostrarMovimientos(Cuenta cuenta){
            System.out.println("Movimientos de la cuenta " + cuenta.getIdCuenta());
            for(MovimientoCuenta movimiento : cuenta.getMovimientos()){
                System.out.println("Tipo de operacion: " + movimiento.getTipoOperacion());
                System.out.println("Monto: " + movimiento.getMonto());
                System.out.println("Fecha y hora: " + movimiento.getFechaHora());
            }
        }
    
        public void consultarSaldo(Cuenta cuenta) {
           System.out.println("Saldo actual: $" + cuenta.getSaldo());
        }

        public Cuenta elegirCuenta(){
            System.out.println("Ingrese la cuenta que desea operar: ");
            int idCuenta = Integer.parseInt(scanner.nextLine());
            for(Cuenta cuenta: cuentas){
                if (idCuenta == cuenta.getIdCuenta()) {
                    return cuenta;
                }
            }
            System.out.println("No se ha encontrado ninguna cuenta: ");
            return null;
        }

       
        
    }

