package co.edu.usbbog.bdd.service;

import java.util.List;

import co.edu.usbbog.bdd.model.Auditoria;

public interface IAuditoriaService {
	public String crearAuditoria(Auditoria Auditoria);
	public Integer contarAuditoria();
	public String modificarAuditoria(Auditoria Auditoria);
	public List<Auditoria> findAll();	
	public String eliminarAuditoria(Auditoria Auditoria);
	public Auditoria mostrarAuditoria(Integer id);
}
