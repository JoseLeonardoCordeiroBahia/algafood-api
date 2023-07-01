package com.algaworks.algafood.api.openapi.controller;

import java.util.List;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.GrupoModel;
import com.algaworks.algafood.api.model.input.GrupoInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Grupos")
public interface GrupoControllerOpenApi {

	@ApiOperation("Lista os grupos")
	List<GrupoModel> listar();

	@ApiOperation("Busca um grupo por ID")
	@ApiResponses({
		@ApiResponse(code = 400, message = "ID do grupo inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Grupo não encontrado", response = Problem.class)
	})
	GrupoModel buscar(
			@ApiParam(value = "ID de um grupo", example = "1")
			Long grupoId);

	@ApiOperation("Cadastra um grupo")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Grupo cadastrado")
	})
	GrupoModel adicionar(
			@ApiParam(name = "corpo", value = "Representação de um novo grupo")
			GrupoInput grupoInput);

	@ApiOperation("Atualiza um grupo por ID")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Grupo atualizado", response = Problem.class),
		@ApiResponse(code = 404, message = "Grupo não encontrado", response = Problem.class)
	})
	GrupoModel atualizar(
			@ApiParam(value = "ID de um grupo", example = "1")
			Long grupoId, 
			
			@ApiParam(name = "corpo", value = "Representação de um grupo com os novos dados")
			GrupoInput grupoInput);

	@ApiOperation("Exclui um grupo por ID")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Grupo excluído"),
		@ApiResponse(code = 404, message = "Grupo não encontrado", response = Problem.class)
	})
	void remover(
			@ApiParam(value = "ID de um grupo", example = "1")
			Long grupoId);

}