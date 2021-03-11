package br.fullstacks.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.fullstacks.spring.model.AgFinanceiro;

public interface AgFinanceiroRepo extends CrudRepository<AgFinanceiro, Integer> {    
    public List<AgFinanceiro> findTop10ByOrderByVolumeTransacionalDesc();
}
