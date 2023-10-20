package me.dio.domain.model.clientepj;

import jakarta.persistence.*;
import me.dio.domain.model.CodBasicoCliente;

import java.util.List;

@Entity(name = "tb_clientejuridico")
public class ClienteJuridico extends CodBasicoCliente {


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Filial> filiais;

    public List<Filial> getFiliais() {
        return filiais;
    }

    public void setFiliais(List<Filial> filiais) {
        this.filiais = filiais;
    }
}
