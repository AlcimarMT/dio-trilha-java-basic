package me.dio.controller.dto.empresadto;

import me.dio.domain.model.estrutura.Membro;


//TODO TA PRONTO
public record MembroDto(
        Long id,
        String nome,
        String dataNascimento,
        String profissao){

        public MembroDto(Membro model){
            this(
                    model.getId(),
                    model.getNome(),
                    model.getDataNascimento(),
                    model.getProfissao());
        }

        public Membro toModel(){
            Membro model = new Membro();
            model.setId(this.id);
            model.setNome(this.nome);
            model.setDataNascimento(this.dataNascimento);
            model.setProfissao(this.profissao);
            return model;
        }
}
