package codechalenge.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

import codechalenge.model.Organizations;

public class OrganizationsService {

	List<Organizations> orList;

	public List<Organizations> getOrList() {
		return orList;
	}

	public void setOrList(List<Organizations> orList) {
		this.orList = orList;
	}

	public void searchList() {
		System.out.println("---------------------------------");
		System.out.println("Search Organizations with");
		System.out
				.println("_id\nurl\nexternal_id\nname\ndomain_names\ncreated_at\ndetails\nshared_tickets\n" + "tags\n");
	}

	@SuppressWarnings("unchecked")
	public OrganizationsService() {
		orList = new ArrayList<Organizations>();
		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader("./data/organizations.json")) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONArray organizations = (JSONArray) obj;

			ObjectMapper mapper = new ObjectMapper();
			organizations.forEach((em) -> {

				Organizations newPw = mapper.convertValue(em, Organizations.class);
				// System.out.println(newPw.getRole());
				orList.add(newPw);
			});
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void showOrganizationDetail(Organizations u)
	{
		System.out.println("_id                          " + u.get_id());
		System.out.println("url                          " + u.getUrl());
		System.out.println("external_id                  " + u.getExternal_id());
		System.out.println("name                         " + u.getName());
		System.out.println("domain_names                 " + u.getDomain_names());
		System.out.println("created_at                   " + u.getCreated_at());
		System.out.println("details                      " + u.getDetails());
		System.out.println("shared_tickets               " + u.getShared_tickets());
		System.out.println("tags                         " + u.getTags().toString());
	}
	
	public Organizations searchOrganizationsById(int id) {
		return this.orList.stream().filter(o -> o.get_id() == id).findFirst().orElse(null);
	}
	
	public Organizations searchOrganizationsByUrl(String url) {
		return this.orList.stream().filter(o -> o.getUrl().equals(url)).findFirst().orElse(null);
	}
}
