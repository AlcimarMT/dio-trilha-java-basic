package me.dio.controller.dto.empresadto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import me.dio.domain.model.estrutura.Equipe;
import me.dio.domain.model.estrutura.Membro;

import java.util.List;

import static java.util.Optional.ofNullable;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;


//TODO TA PRONTO
public record EquipeDto(
        Long id,
        String funcao,
        List<MembroDto> membros){

    public EquipeDto(Equipe model){
        this(
                model.getId(),
                model.getFuncao(),
                ofNullable(model.getMembros()).orElse(emptyList()).stream().map(MembroDto::new).collect(toList())
        );
    }

    public Equipe toModel(){
        Equipe model = new Equipe();
        model.setId(this.id);
        model.setFuncao(this.funcao);
        model.setMembros(ofNullable(this.membros).orElse(emptyList()).stream().map(MembroDto::toModel).collect(toList()));
        return model;
    }

}
