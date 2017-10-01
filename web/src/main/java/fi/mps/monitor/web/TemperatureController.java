package fi.mps.monitor.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.mps.monitor.repo.Details;
import fi.mps.monitor.repo.DetailsRepo;
import fi.mps.monitor.repo.filter.DS1820ValueFilter;

@Controller
@RequestMapping("/temperature")
public class TemperatureController {

	@Autowired
	private DetailsRepo repo;

	@RequestMapping(value = "/report", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Pojo report(@RequestBody Pojo pojo) {
		System.out.println(pojo);
		return pojo;
	}

	@RequestMapping(value = "/set", method = RequestMethod.GET)
	public @ResponseBody String set(@RequestParam String id, @RequestParam String value) {
		repo.put(id, value);
		return "ok";
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody String get(@RequestParam String id) {
		return repo.get(id);
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public @ResponseBody String register(@RequestParam String id, @RequestParam String title, 
			@RequestParam String label, @RequestParam String min, @RequestParam String max) {
		repo.registerSensor(id, title, label, min, max);
		return "ok";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ReportPojo> list() {
		List<ReportPojo> pojos = new ArrayList<>();

		for (String id : repo.getIds()) {
			addToPojos(pojos, id);
		}

		return pojos;

	}

	private void addToPojos(List<ReportPojo> pojos, String id) {
		ReportPojo pojo = new ReportPojo();
		
		pojo.setId(id);
		pojo.setValue(DS1820ValueFilter.convert(repo.get(id)));
		//pojo.setValue(repo.get(id));
		
		Details details = repo.getDetails(id);
		
		pojo.setTitle(details.getTitle());
		pojo.setLabel(details.getLabel());
		pojo.setMax(details.getMax());
		pojo.setMin(details.getMin());
		
		
		pojos.add(pojo);
	}
}
