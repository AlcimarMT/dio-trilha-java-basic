package me.dio.controller.dto.pjclientedto;

import me.dio.domain.model.clientepj.Filial;

public record FilialDto(Long id,
                        String nomeCliente,
                        double consumoMensalMedio,
                        String contato){
    public FilialDto(Filial model){
        this(
                model.getId(),
                model.getNomeCliente(),
                model.getConsumoMensalMedio(),
                model.getContato()
        );
    }

    public Filial toModel(){
        Filial model = new Filial();
        model.setId(this.id);
        model.setNomeCliente(this.nomeCliente);
        model.setConsumoMensalMedio(this.consumoMensalMedio);
        model.setContato(this.contato);
        return model;
    }
}

