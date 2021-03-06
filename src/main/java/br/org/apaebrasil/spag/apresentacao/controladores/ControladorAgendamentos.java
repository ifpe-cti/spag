/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.apresentacao.controladores;

import br.org.apaebrasil.spag.dominio.Agendamento;
import br.org.apaebrasil.spag.dominio.Paciente;
import br.org.apaebrasil.spag.dominio.repositorio.Agendamentos;
import br.org.apaebrasil.spag.dominio.repositorio.Pacientes;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Pc
 */
@Named
@ViewScoped
public class ControladorAgendamentos implements Serializable {

    private static final long serialVersionUID = 1;

    @Inject
    private Agendamentos agendamentos;

    @Inject
    private Pacientes pacientes;

    private Agendamento agendamento;
    private List<Agendamento> todosAgendamentos;

    public void consultar() {
        todosAgendamentos = agendamentos.recuperarTodos();
    }

    public void novo() {
        agendamento = new Agendamento();
    }

    public void adicionar() {
        agendamentos.inserir(agendamento);
        consultar();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agendamento realizado com sucesso!"));
    }

    public void alterar() {
        agendamentos.alterar(agendamento);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agendamento alterado com sucesso!"));
    }

    public void excluir() {
        agendamentos.remover(Integer.SIZE);
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public List<Agendamento> getTodosAgendamentos() {
        return todosAgendamentos;
    }

    public List<Paciente> getPacientes() {
        return pacientes.recuperarTodos();
    }

    public List<Paciente> pacientesPorNome(String nome) {
        return pacientes.porNome(nome);
    }
}
