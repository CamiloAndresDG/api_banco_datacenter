package co.edu.usbbog.bdd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbbog.bdd.model.Auditoria;



public interface IAuditoriaRepository extends JpaRepository<Auditoria, Integer>{
	
}
