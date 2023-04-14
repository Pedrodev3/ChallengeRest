package br.com.fiap.challengerest.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_chr_pergunta")
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pergunta")
    @SequenceGenerator(name = "pergunta", sequenceName = "sq_chr_pergunta", allocationSize = 1)
    @Column(name = "cd_pergunta")
    private Long id;

    @Column(name = "st_pergunta", nullable=false, length=250)
    private String pergunta;

}
