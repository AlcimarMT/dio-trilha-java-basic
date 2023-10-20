package me.dio.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import me.dio.controller.dto.empresadto.EmpresaDto;
import me.dio.domain.model.clientepf.ClienteFisico;
import me.dio.domain.model.estrutura.Empresa;
import me.dio.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final EmpresaService empresaService;

    public UserController(EmpresaService empresaService){
        this.empresaService = empresaService;
    }


    @GetMapping
    @Operation(summary = "Encontrar empresas", description = "Retornar todas as empresas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação Sucedida.")
    })
    public ResponseEntity<List<EmpresaDto>> findAll() {
        var empresas = empresaService.findall();
        var empresaDto = empresas.stream().map(EmpresaDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(empresaDto);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Achar a empresa pelo ID", description = "Retornar uma empresa pelo seu respectivo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação Sucedida."),
            @ApiResponse(responseCode = "404", description = "Erro.")
    })
    public ResponseEntity<Empresa> findById(@PathVariable Long id){
        Empresa user = empresaService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    @Operation(summary = "Registrar uma nova empresa", description = "Registrar uma nova empresa e retornar os seus dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Empresa registrada com sucesso."),
            @ApiResponse(responseCode = "422", description = "Dados inválidos.")
    })
    public ResponseEntity<Empresa> create(@RequestBody Empresa empresaToCreate){
        Empresa empresaToBeCreated = empresaService.create(empresaToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(empresaToCreate.getId())
                .toUri();
        return ResponseEntity.created(location).body(empresaToBeCreated);
    }

}
