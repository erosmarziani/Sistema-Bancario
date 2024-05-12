package src.ar.edu.utn.frbb.tup.modelo;

import java.util.Random;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import src.ar.edu.utn.frbb.tup.menu.MenuOperaciones;

public class Cuenta {
    private static int numeroDeCuentas = 1;
    private int idCuenta;
    private String tipoCuenta;
    private final String cbu;
    private double saldo;
    private LocalDate fechaApertura;
    private Cliente cliente;
    private List<MovimientoCuenta> movimientos;
    
    // Constructor
    public Cuenta( String tipoCuenta, double saldo, LocalDate fechaApertura,Cliente cliente) {

        this.idCuenta = numeroDeCuentas ++;
        this.cliente = cliente;
        this.tipoCuenta = tipoCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.cbu = generadorDeCbu();
        this.movimientos = new ArrayList<>();

    }
    
   
    // Getters y setters
    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setClientexDni(String dni){
        MenuOperaciones menu = new MenuOperaciones();
        for(Cliente cliente: menu.getClientes()){
            if (cliente.getDniCliente().equals(dni)) {
                this.cliente = cliente;
            }
    }
    }

    public String getClienteAsociado(){
        return cliente.getNombre() + cliente.getApellido();
    }
    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getCbu(){
        return cbu;
    }
    public List<MovimientoCuenta> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<MovimientoCuenta> movimientos) {
        this.movimientos = movimientos;
    }
    
    public void ingresarDeposito(double montoIngresado){
        this.saldo += montoIngresado;
    }


    public String generadorDeCbu(){
        Random random = new Random();
        StringBuilder cbuAleatorio = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            int digito = random.nextInt(10);
            cbuAleatorio.append(digito);
        }
        String cbu = cbuAleatorio.toString();
        return cbu;
    }
    public void retirarDinero(double monto) {
        if (saldo >= monto) {
            this.saldo -= monto;
        }else{
            System.out.println("Fondos insuficientes!");
        }
            
        }

        public void agregarMovimiento(MovimientoCuenta movimiento) {
            movimientos.add(movimiento);
        }
    
        public void MostrarMovimientos(){
            System.out.println("Movimientos de la cuenta " + getIdCuenta());
            for(MovimientoCuenta movimiento : movimientos){
                System.out.println("Tipo de operacion: " + movimiento.getTipoOperacion());
                System.out.println("Monto: " + movimiento.getMonto());
                System.out.println("Fecha y hora: " + movimiento.getFechaHora());
            }
        }
    }



