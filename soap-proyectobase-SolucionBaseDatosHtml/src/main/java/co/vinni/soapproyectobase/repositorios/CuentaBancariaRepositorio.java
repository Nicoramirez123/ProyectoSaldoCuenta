package co.vinni.soapproyectobase.repositorios;


import co.vinni.soapproyectobase.entidades.CuentaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaBancariaRepositorio extends JpaRepository<CuentaBancaria, Long> {
}
