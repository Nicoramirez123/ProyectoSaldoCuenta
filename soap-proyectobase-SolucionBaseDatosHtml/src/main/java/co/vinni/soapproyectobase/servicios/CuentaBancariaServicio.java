package co.vinni.soapproyectobase.servicios;


import co.vinni.soapproyectobase.entidades.CuentaBancaria;
import co.vinni.soapproyectobase.repositorios.CuentaBancariaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaBancariaServicio {

    @Autowired
    private CuentaBancariaRepositorio cuentaBancariaRepositorio;

    public CuentaBancaria crearCuenta(CuentaBancaria cuenta) {
        return cuentaBancariaRepositorio.save(cuenta);
    }

    public CuentaBancaria obtenerCuenta(Long id) {
        return cuentaBancariaRepositorio.findById(id).orElse(null);
    }

    public CuentaBancaria consignar(Long id, double cantidad) {
        CuentaBancaria cuenta = cuentaBancariaRepositorio.findById(id).orElse(null);
        if (cuenta != null) {
            cuenta.setSaldo(cuenta.getSaldo() + cantidad);
            return cuentaBancariaRepositorio.save(cuenta);
        }
        return null;
    }

    public CuentaBancaria retirar(Long id, double cantidad) {
        CuentaBancaria cuenta = cuentaBancariaRepositorio.findById(id).orElse(null);
        if (cuenta != null && cuenta.getSaldo() >= cantidad) {
            cuenta.setSaldo(cuenta.getSaldo() - cantidad);
            return cuentaBancariaRepositorio.save(cuenta);
        }
        return null;
    }

    public boolean transferir(Long idOrigen, Long idDestino, double cantidad) {
        CuentaBancaria cuentaOrigen = cuentaBancariaRepositorio.findById(idOrigen).orElse(null);
        CuentaBancaria cuentaDestino = cuentaBancariaRepositorio.findById(idDestino).orElse(null);
        if (cuentaOrigen != null && cuentaDestino != null && cuentaOrigen.getSaldo() >= cantidad) {
            cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - cantidad);
            cuentaDestino.setSaldo(cuentaDestino.getSaldo() + cantidad);
            cuentaBancariaRepositorio.save(cuentaOrigen);
            cuentaBancariaRepositorio.save(cuentaDestino);
            return true;
        }
        return false;
    }
}


