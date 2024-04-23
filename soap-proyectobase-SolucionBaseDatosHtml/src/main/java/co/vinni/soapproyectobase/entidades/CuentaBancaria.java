package co.vinni.soapproyectobase.entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "Cuentas")
@Table(name = "CUENTAS")

public class CuentaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DOCUMENTO", nullable = false)
    private String documento;


    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false)
    private String apellido;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "SALDO", nullable = false)
    private double saldo;
    }