package me.dio.domain.model.estrutura;

import jakarta.persistence.*;
import me.dio.domain.model.clientepf.ClienteFisico;
import me.dio.domain.model.clientepj.ClienteJuridico;

import java.util.List;

@Entity(name = "tb_empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeEmpresa;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Setor> setores;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ClienteJuridico> clientesPJ;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ClienteFisico> clientePF;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public List<Setor> getSetores() {
        return setores;
    }

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }

    public List<ClienteJuridico> getClientesPJ() {
        return clientesPJ;
    }

    public void setClientesPJ(List<ClienteJuridico> clientesPJ) {
        this.clientesPJ = clientesPJ;
    }

    public List<ClienteFisico> getClientesPF() {
        return clientePF;
    }

    public void setClientesPF(List<ClienteFisico> clientePF) {
        this.clientePF = clientePF;
    }
}
