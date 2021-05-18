package co.edu.usbbog.bdd.rest;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.bdd.model.Ciudad;
import co.edu.usbbog.bdd.service.ICiudadService;




@RestController
// @RequestMapping("/prueba")
public class CiudadController {

	@Autowired
	ICiudadService ciudadService;
	
	@GetMapping("/crearCiudad")
//	@Procedure("application/json")
	public String crearCiudad(@RequestBody Ciudad newCiudad) {
		JSONObject respuesta= new JSONObject();
		if(ciudadService.crearCiudad(newCiudad).equals("Se guardo la ciudad")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
	}
	
	
	@PostMapping("/contarCiudad")
	public String contarRol() {
		JSONObject respuesta= new JSONObject();
			int aux=ciudadService.contarCiudad();
			respuesta.put("Count", aux);
			return respuesta.toString();
	}
	
	@PostMapping("/eliminarCiudad")
	public String eliminarRol(@RequestBody Ciudad newCiudad) {
		JSONObject respuesta= new JSONObject();
		if(ciudadService.eliminarCiuadad(newCiudad).equals("Se elimino la ciudad")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/getCiudad")
	public String getRoles() {
		JSONArray array= new JSONArray();
		List<Ciudad> ciudades=ciudadService.findAll();
		for (int i = 0; i < ciudades.size(); i++) {
			JSONObject ciudadJson= new JSONObject();
			ciudadJson.put("id", ciudades.get(i).getId());
			ciudadJson.put("nombre", ciudades.get(i).getNombre());
			array.put(ciudadJson);
		}
		return array.toString();
	}
	
	@PostMapping("/buscarCiudad")
	public String buscarRol(@RequestBody Ciudad ciudad) {
		JSONObject respuesta= new JSONObject();
		if(ciudadService.mostrarCiudad(ciudad.getId())!=null) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/modificarCiudad")
	public String modificarRol(@RequestBody Ciudad newCiudad) {
		JSONObject respuesta= new JSONObject();
		if(ciudadService.modificarCiudad(newCiudad).equals("Se modifico la ciudad")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}

	
}
