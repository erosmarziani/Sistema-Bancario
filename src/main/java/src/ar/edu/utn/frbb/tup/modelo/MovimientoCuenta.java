package src.ar.edu.utn.frbb.tup.modelo;

import java.time.LocalDateTime;

public class MovimientoCuenta {
    private TipoOperacion tipoOperacion;
    private double monto;
    private LocalDateTime fechaHora;

    public MovimientoCuenta(TipoOperacion tipoOperacion, double monto, LocalDateTime fechaHora){
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
        this.fechaHora = fechaHora;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion){
        this.tipoOperacion = tipoOperacion;
    }

    public void setMonto(double monto){
        this.monto = monto;
    }

    public void setfechaHora(LocalDateTime fechaHora){
        this.fechaHora = fechaHora;
    }

}
