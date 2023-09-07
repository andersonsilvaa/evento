package com.devsuperior.evento.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_atividade")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "atividade")
    private List<Bloco> blocos;

    @Setter(AccessLevel.NONE)
    @ManyToMany(mappedBy = "atividades")
    private Set<Participante> participantes;
}
