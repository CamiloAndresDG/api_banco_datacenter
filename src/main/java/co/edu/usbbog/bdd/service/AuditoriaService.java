package co.edu.usbbog.bdd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import co.edu.usbbog.bdd.model.Auditoria;
import co.edu.usbbog.bdd.repo.IAuditoriaRepository;

@Service
public class AuditoriaService implements IAuditoriaService{
	
	@Autowired
	IAuditoriaRepository audiRepo;


	@Override
	public String crearAuditoria(Auditoria Auditoria) {
		try {
			audiRepo.save(Auditoria);
			return "Se guardo la Auditoria";
		} catch (IllegalArgumentException e) {
			return "No se guardo la Auditoria: " + e.getMessage();
		}
	}
	

	@Override
	public Integer contarAuditoria() {
		try {
			long cantidad=0;
			cantidad=audiRepo.count();
			Integer i=(int) cantidad;
			return i;
		} catch (IllegalArgumentException e) {
			return 0;
		}
	}

	@Override
	public String modificarAuditoria(Auditoria Auditoria) {
		try {
        	int busqueda= Auditoria.getId();
            if(audiRepo.getOne(busqueda)!=null) {
            	audiRepo.delete(Auditoria);
            	audiRepo.save(Auditoria);
                return "Se modifico la Auditoria";
            }else {
                return "No se modifico la Auditoria";
            }
        } catch (IllegalArgumentException e) {
            return "No se modifico la Auditoria: " + e.getMessage();
        }
	}

	@Override
	public List<Auditoria> findAll() {
		try {
			List<Auditoria> encontrado=audiRepo.findAll();
			return encontrado;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public String eliminarAuditoria(Auditoria Auditoria) {
		try {
			if(audiRepo.getOne(Auditoria.getId())!=null) {
				audiRepo.delete(Auditoria);
				return "Se elimino la Auditoria";
			}else {
			return "No Se elimino la Auditoria";
			}
		} catch (IllegalArgumentException e) {
			return "No Se elimino la Auditoria: " + e.getMessage();
		}
	}

	@Override
	public Auditoria mostrarAuditoria(Integer id) {
		Auditoria tran= new Auditoria();
		try {
			if(audiRepo.getOne(id)!=null) {
				tran=audiRepo.getOne(id);
				return tran;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	

		
	
}
