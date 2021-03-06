/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.infraestrutura.repositorio;

import br.org.apaebrasil.spag.dominio.Agendamento;
import br.org.apaebrasil.spag.dominio.Paciente;
import br.org.apaebrasil.spag.dominio.Profissional;
import br.org.apaebrasil.spag.dominio.repositorio.Agendamentos;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Query;

/**
 *
 * @author Pc
 */
public class AgendamentosHibernate extends RepositorioHibernate<Agendamento, Integer> implements Agendamentos {

    @Override
    public List<Agendamento> porDataHora(Date dataHora) {
        Objects.requireNonNull(dataHora, "data ou hora inválida");

        Query query = manager.createQuery("FROM Agendamento a WHERE a.dataHora = :dataHora");
        query.setParameter("dataHora", dataHora);

        return query.getResultList();
    }

    @Override
    public List<Agendamento> porPaciente(Paciente nome) {
        return manager.createQuery("from Agendamento a where a.nome = :nome").getResultList();
    }

    @Override
    public List<Agendamento> porEspecializacao(Profissional especializacao) {
        return manager.createQuery("from Agendamento a where a.especializacao = :especializacao").getResultList();
    }
}
