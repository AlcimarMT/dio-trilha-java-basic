package me.dio.controller.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import me.dio.controller.dto.empresadto.EquipeDto;
import me.dio.domain.model.clientepf.ClienteFisico;
import me.dio.domain.model.estrutura.Equipe;
import me.dio.domain.model.estrutura.Setor;

import static java.util.Optional.ofNullable;


//TODO: parece pronto
public record SetorDto(
        Long id,
        String nomeSetor,

        EquipeDto equipe){

    public SetorDto(Setor model){
        this(
                model.getId(),
                model.getNomeSetor(),
                ofNullable(model.getEquipe()).map(EquipeDto::new).orElse(null)
        );
    }
    public Setor toModel(){
        Setor model = new Setor();
        model.setId(this.id);
        model.setNomeSetor(this.nomeSetor);
        model.setEquipe(ofNullable(this.equipe).map(EquipeDto::toModel).orElse(null));
        return model;
    }
}
