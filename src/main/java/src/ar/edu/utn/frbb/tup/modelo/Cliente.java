package src.ar.edu.utn.frbb.tup.modelo;

public class Cliente {
    private String dniCliente;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String tipoPersona;
    
    // Constructor
    public Cliente(String dniCliente, String nombre, String apellido, String direccion, String telefono, String tipoPersona) {
        this.dniCliente = dniCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoPersona = tipoPersona;
    }
    
    // Getters y setters
    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void setTipoPersona(String tipoPersona){
        this.tipoPersona = tipoPersona;
    }

    public String getTipoPersona(){
        return tipoPersona;
    }

    
}

