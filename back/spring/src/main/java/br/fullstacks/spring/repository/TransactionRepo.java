package br.fullstacks.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.fullstacks.spring.dto.ContagemStatus;
import br.fullstacks.spring.model.Transaction;

public interface TransactionRepo extends CrudRepository<Transaction, Integer> {    
    
    @Query("SELECT new br.fullstacks.spring.dto.ContagemStatus(t.agFinanceiro.nomeAgente, t.agFinanceiro.volumeTransacional, t.status, COUNT(t.status)) FROM Transaction AS t WHERE t.agFinanceiro.idAgente = ?1 GROUP BY t.agFinanceiro.nomeAgente, t.status ORDER By t.status")
    List<ContagemStatus> countStatusByAgent(int idAgente);
}
