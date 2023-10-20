package me.dio.controller.dto.pjclientedto;

import me.dio.controller.dto.pfclientedto.ClientePFDto;
import me.dio.domain.model.clientepf.ClienteFisico;
import me.dio.domain.model.clientepj.ClienteJuridico;
import me.dio.domain.model.clientepj.Filial;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public record ClientePJDto(
    Long id,
    String nomeCliente,
    double consumoMensalMedio,

    String contato,

    List<FilialDto> filiais
    ) {

        public ClientePJDto(ClienteJuridico model){
            this(
                    model.getId(),
                    model.getNomeCliente(),
                    model.getConsumoMensalMedio(),
                    model.getContato(),
                    ofNullable(model.getFiliais()).orElse(emptyList()).stream().map(FilialDto::new).collect(toList())
            );
        }

        public ClienteJuridico toModel(){
            ClienteJuridico model = new ClienteJuridico();
            model.setId(this.id);
            model.setNomeCliente(this.nomeCliente);
            model.setConsumoMensalMedio(this.consumoMensalMedio);
            model.setContato(this.contato);
            model.setFiliais(ofNullable(this.filiais).orElse(emptyList()).stream().map(FilialDto::toModel).collect(toList()));
            return model;
        }
}
