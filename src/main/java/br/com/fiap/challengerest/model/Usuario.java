package br.com.fiap.challengerest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Calendar;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_chr_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
    @SequenceGenerator(name = "usuario", sequenceName = "sq_chr_usuario", allocationSize = 1)
    @Column(name = "cd_usuario")
    private Long id;


    @Column(name = "nm_usuario", nullable=false, length=100)
    private String nome;

    @Column(name = "sn_usuario", nullable=false)
    @Size(min = 6, max = 20)
    private String senha;

    @Column(name = "cpf_usuario", nullable=false)
    @Size(min = 11, max = 11)
    private String cpf;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_nascimento", nullable=false)
    private Calendar dataNascimento;
}
