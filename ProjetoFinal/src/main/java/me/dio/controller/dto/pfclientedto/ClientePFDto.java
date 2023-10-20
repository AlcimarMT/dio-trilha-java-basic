package me.dio.controller.dto.pfclientedto;

import me.dio.domain.model.clientepf.ClienteFisico;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

//TODO TA PRONTO
public record ClientePFDto(
        Long id,
        String nomeCliente,
        double consumoMensalMedio,
        String contato) {

        public ClientePFDto(ClienteFisico model){
            this(
                    model.getId(),
                    model.getNomeCliente(),
                    model.getConsumoMensalMedio(),
                    model.getContato()
                    );
        }

        public ClienteFisico toModel(){
            ClienteFisico model = new ClienteFisico();
            model.setId(this.id);
            model.setNomeCliente(this.nomeCliente);
            model.setConsumoMensalMedio(this.consumoMensalMedio);
            model.setContato(this.contato);
            return model;
        }
}
