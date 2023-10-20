package me.dio.domain.repository;

import me.dio.domain.model.estrutura.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    boolean existsByNomeEmpresa(String nomeEmpresa);

}
