package co.edu.usbbog.bdd.rest;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.bdd.model.Auditoria;
import co.edu.usbbog.bdd.service.IAuditoriaService;




@RestController
// @RequestMapping("/prueba")
public class AuditoriaController {

	@Autowired
	IAuditoriaService auditoriaService;
	
	@GetMapping("/crearAuditoria")
//	@Procedure("application/json")
	public String crearAuditoria(@RequestBody Auditoria newAuditoria) {
		JSONObject respuesta= new JSONObject();
		if(auditoriaService.crearAuditoria(newAuditoria).equals("Se guardo la transacción en la auditoria")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
	}
	
	
	@PostMapping("/contarAuditoria")
	public String contarRol() {
		JSONObject respuesta= new JSONObject();
			int aux=auditoriaService.contarAuditoria();
			respuesta.put("Count", aux);
			return respuesta.toString();
	}
	
	@PostMapping("/eliminarAuditoria")
	public String eliminarRol(@RequestBody Auditoria newAuditoria) {
		JSONObject respuesta= new JSONObject();
		if(auditoriaService.eliminarAuditoria(newAuditoria).equals("Se elimino la transacción en la auditoria")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/getAuditoria")
	public String getRoles() {
		JSONArray array= new JSONArray();
		List<Auditoria> auditorias=auditoriaService.findAll();
		for (int i = 0; i < auditorias.size(); i++) {
			JSONObject ciudadJson= new JSONObject();
			ciudadJson.put("ID", auditorias.get(i).getId());
			ciudadJson.put("Valor", auditorias.get(i).getValor());
			ciudadJson.put("Fecha", auditorias.get(i).getFecha());
			ciudadJson.put("Ciudad", auditorias.get(i).getCiudad());
			ciudadJson.put("Cuenta", auditorias.get(i).getCuenta());
			ciudadJson.put("Tipo", auditorias.get(i).getTipo());
			array.put(ciudadJson);
		}
		return array.toString();
	}
	
	@PostMapping("/buscarAuditoria")
	public String buscarRol(@RequestBody Auditoria Auditoria) {
		JSONObject respuesta= new JSONObject();
		if(auditoriaService.mostrarAuditoria(Auditoria.getId())!=null) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/modificarAuditoria")
	public String modificarRol(@RequestBody Auditoria newAuditoria) {
		JSONObject respuesta= new JSONObject();
		if(auditoriaService.modificarAuditoria(newAuditoria).equals("Se modifico la transacción en la auditoria")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}

	
}
