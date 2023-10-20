package me.dio.service.impl;

import me.dio.domain.model.clientepj.ClienteJuridico;
import me.dio.domain.model.estrutura.Setor;
import me.dio.service.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;
import me.dio.domain.model.clientepf.ClienteFisico;
import me.dio.domain.model.estrutura.Empresa;
import me.dio.domain.repository.EmpresaRepository;
import me.dio.service.EmpresaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

import static java.util.Optional.ofNullable;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private static final Long UNCHANGEABLE_USER_ID = 1998L;
    private final EmpresaRepository empresaRepository;

    //Constructor de EmpresaRepository
    public EmpresaServiceImpl(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    @Transactional(readOnly = true)
    public List<Empresa> findall() {
        return this.empresaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Empresa findById(Long id) {
        return this.empresaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public Empresa create(Empresa empresaToCreate) {
        //Checando a integridade do novo objeto
        //Checando se o objeto da empresa está vazio.
        ofNullable(empresaToCreate).orElseThrow(() -> new BusinessException("O objeto da empresa não foi definido corretamente."));

        //Checando se há um nome para a empresa que está sendo inserida no banco de dados.
        ofNullable(empresaToCreate.getNomeEmpresa()).orElseThrow(() -> new BusinessException("O nome da empresa deve ser fornecido."));

        //Checando a existência de setores informados incorretamente na lista de setores.
        ofNullable(empresaToCreate.getSetores())
                .orElseThrow(() -> new BusinessException("A lista com os setores não foi encontrada."))
                .stream()
                .forEach(setor -> {
                    if (setor.getId() == 0L || setor.getNomeSetor() == null || setor.getEquipe() == null) {
                        throw new BusinessException("Um ou mais atributos do setor não foram informados corretamente.");
                    }
                });


        //Checando se o ID do novo objeto não é o mesmo do ID restrito.
        this.validateChangeableId(empresaToCreate.getId(), "updated");


        //Checando se o nome do novo objeto é o mesmo de algum outro objeto que esteja no repositório.
        if (empresaRepository.existsByNomeEmpresa(empresaToCreate.getNomeEmpresa())) {
            throw new BusinessException("O nome dessa empresa ja existe no repositório.");
        }

        /*Se não tiver nenhum problema com as informações do novo objeto,
         e não houver algum no repositória que tenha o mesmo id e
        nome que o novo objeto, esse será salvo no repositório*/
        return this.empresaRepository.save(empresaToCreate);
    }

    @Transactional
    public Empresa update(Long id, Empresa empresaToUpdate) {
        //Essa linha garante que o id a ser atualizado não tenha o mesmo id que o atributo 'UNCHANGEABLE_USER_ID = 1L;'
        this.validateChangeableId(id, "atualizar");
        Empresa dbEmpresa = this.findById(id);


        if (!dbEmpresa.getId().equals(empresaToUpdate.getId())) {
            throw new BusinessException("O id fornecido como argumento não corresponde ao id da empresa.");
        }
        //
        dbEmpresa.setNomeEmpresa(empresaToUpdate.getNomeEmpresa());


        //Verificando a existência da lista, e dos itens em seu interior.
        List<Setor> updatedSetors = empresaToUpdate.getSetores();
        if (updatedSetors == null || updatedSetors.isEmpty()) {
            throw new BusinessException("A lista com os setores não foi encontrada ou está vazia.");
        }

        //Verificando cada elemento da lista
        updatedSetors.forEach(setor -> {
            //Verificando o tipo do objeto
            if (!(setor instanceof Setor)){throw new BusinessException("O Objeto Não é do tipo correto");}
            //Verificando os atributos do objeto
            if (setor.getId() == 0L || setor.getNomeSetor() == null || setor.getEquipe() == null) {
                throw new BusinessException("Um ou mais atributos do setor não foram informados corretamente.");
            }
        });
        dbEmpresa.setSetores(updatedSetors);


        List<ClienteFisico> clientesPFUpdate = empresaToUpdate.getClientesPF();
        if (clientesPFUpdate == null) {
            throw new BusinessException("A lista com os clientes não foi encontrada.");
        }

        //Verificando cada elemento da lista
        clientesPFUpdate.forEach(cliente -> {
            //Verificando o tipo do objeto
            if (!(cliente instanceof ClienteFisico)){throw new BusinessException("O Objeto Não é do tipo correto");}

            //Verificando os atributos do objeto
            if (    cliente.getId() == 0L ||
                    cliente.getNomeCliente() == null ||
                    cliente.getContato() == null ||
                    cliente.getConsumoMensalMedio() == 0.0) {
                throw new BusinessException("Um ou mais atributos do setor não foram informados corretamente.");
            }
        });
        dbEmpresa.setClientesPF(clientesPFUpdate);

        List<ClienteJuridico> clientesPJUpdate = empresaToUpdate.getClientesPJ();
        //Verificando o tipo do objeto
        if (clientesPJUpdate == null) {
            throw new BusinessException("A lista com os clientes não foi encontrada.");
        }

        //Verificando cada elemento da lista
        clientesPJUpdate.forEach(cliente -> {
            //Verificando o tipo do objeto
            if (!(cliente instanceof ClienteJuridico)){throw new BusinessException("O Objeto Não é do tipo correto");}

            //Verificando os atributos do objeto
            if (    cliente.getId() == 0L ||
                    cliente.getNomeCliente() == null ||
                    cliente.getContato() == null ||
                    cliente.getFiliais() == null ||
                    cliente.getConsumoMensalMedio() == 0.0
            ) {
                throw new BusinessException("Um ou mais atributos do setor não foram informados corretamente.");
            }
        });
        dbEmpresa.setClientesPJ(clientesPJUpdate);


        //Salvando
        return this.empresaRepository.save(dbEmpresa);
    }

    @Transactional
    public void delete(Long id) {
        this.validateChangeableId(id, "deletar");
        Empresa dbEmpresa = this.findById(id);
        this.empresaRepository.delete(dbEmpresa);
    }


    private void validateChangeableId(Long id, String operation) {
        if (UNCHANGEABLE_USER_ID.equals(id)) {
            throw new BusinessException("O id informado é de outra empresa %d, e não podera %s.".formatted(UNCHANGEABLE_USER_ID, operation));
        }
    }

}
