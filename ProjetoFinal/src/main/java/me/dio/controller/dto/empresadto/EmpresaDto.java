package me.dio.controller.dto.empresadto;


import me.dio.controller.dto.SetorDto;
import me.dio.controller.dto.pfclientedto.ClientePFDto;
import me.dio.controller.dto.pjclientedto.ClientePJDto;
import me.dio.domain.model.estrutura.Empresa;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;
import static java.util.Collections.emptyList;

import java.util.List;


//TODO TA PRONTO
public record EmpresaDto (
       Long id,
       String nomeEmpresa,
       List<SetorDto> setores,
       List<ClientePJDto> clientesPJ,
       List<ClientePFDto> clientesPF){

        public EmpresaDto(Empresa model){
            this(
                    model.getId(),
                    model.getNomeEmpresa(),
                    ofNullable(model.getSetores()).orElse(emptyList()).stream().map(SetorDto::new).collect(toList()),
                    ofNullable(model.getClientesPJ()).orElse(emptyList()).stream().map(ClientePJDto::new).collect(toList()),
                    ofNullable(model.getClientesPF()).orElse(emptyList()).stream().map(ClientePFDto::new).collect(toList())
                    );

        }
        public Empresa toModel(){
                Empresa model = new Empresa();
                model.setId(this.id);
                model.setNomeEmpresa(this.nomeEmpresa);
                model.setSetores(ofNullable(this.setores).orElse(emptyList()).stream().map(SetorDto::toModel).collect(toList()));
                model.setClientesPF(ofNullable(this.clientesPF).orElse(emptyList()).stream().map(ClientePFDto::toModel).collect(toList()));
                model.setClientesPJ(ofNullable(this.clientesPJ).orElse(emptyList()).stream().map(ClientePJDto::toModel).collect(toList()));
                return model;
        }
}
