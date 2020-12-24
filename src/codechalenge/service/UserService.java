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

import codechalenge.model.Tickets;
import codechalenge.model.User;

public class UserService {
	List<User> listUsers;

	public List<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}

	public void searchList() {
		System.out.println("---------------------------------");
		System.out.println("Search User with");
		System.out.println("_id\nurl\nexternal_id\nname\nalias\ncreated_at\nactive\nverified\n"
				+ "shared\nlocale\ntimezone\nlast_login_at\nemail\nphone\nsignature\norganization_id\n"
				+ "tags\nsuspended\nrole\n");
	}

	@SuppressWarnings("unchecked")
	public UserService() {
		listUsers = new ArrayList<User>();
		JSONParser jsonParser = new JSONParser();
		
		try (FileReader reader = new FileReader("./data/users.json")) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONArray employeeList = (JSONArray) obj;

			ObjectMapper mapper = new ObjectMapper();
			employeeList.forEach((em) -> {

				User newPw = mapper.convertValue(em, User.class);
				// System.out.println(newPw.getRole());
				listUsers.add(newPw);
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

	public void showUserDetail(User u, String orgName, List<Tickets> tickets) {
		System.out.println("_id                          " + u.get_id());
		System.out.println("external_id                  " + u.getExternal_id());
		System.out.println("alias                        " + u.getName());
		System.out.println("alias                        " + u.getAlias());
		System.out.println("created_at                   " + u.getCreated_at());
		System.out.println("active                       " + u.getActive());
		System.out.println("verified                     " + u.getVerified());
		System.out.println("shared                       " + u.getShared());
		System.out.println("locale                       " + u.getLocale());
		System.out.println("timezone                     " + u.getTimezone());
		System.out.println("last_login_at                " + u.getLast_login_at());
		System.out.println("email                        " + u.getEmail());
		System.out.println("phone                        " + u.getPhone());
		System.out.println("signature                    " + u.getSignature());
		System.out.println("organization_id              " + u.getOrganization_id());
		System.out.println("tags                         " + u.getTags().toString());
		System.out.println("role                         " + u.getRole());
		
		System.out.println("Organization_Name            " + orgName);
		
		for(int i = 0; i< tickets.size(); i++)
		{
			System.out.println("ticket_"+ i + "                     " + tickets.get(i).getSubject());
		}
	}
	public User searchUserById(int id) {
		return this.listUsers.stream().filter(u -> u.get_id() == id).findFirst().orElse(null);
	}

	public User searchUserByUrl(String url) {
		return this.listUsers.stream().filter(u -> u.getUrl().equals(url)).findFirst().orElse(null);
	}

	public User searchUserByExternalId(String external_id) {
		return this.listUsers.stream().filter(u -> u.getExternal_id().equals(external_id)).findFirst().orElse(null);
	}

	public User searchUserByName(String name) {
		return this.listUsers.stream().filter(u -> u.getName().equals(name)).findFirst().orElse(null);
	}

	public User searchUserByAlias(String alias) {
		return this.listUsers.stream().filter(u -> u.getAlias().equals(alias)).findFirst().orElse(null);
	}

	public User searchUserByCreatedAt(String created_at) {
		return this.listUsers.stream().filter(u -> u.getCreated_at().equals(created_at)).findFirst().orElse(null);
	}

	public User searchUserByActive(Boolean active) {
		return this.listUsers.stream().filter(u -> u.getActive().equals(active)).findFirst().orElse(null);
	}

	public User searchUserByVerified(Boolean verified) {
		return this.listUsers.stream().filter(u -> u.getVerified().equals(verified)).findFirst().orElse(null);
	}

	public User searchUserByShared(Boolean shared) {
		return this.listUsers.stream().filter(u -> u.getShared().equals(shared)).findFirst().orElse(null);
	}

	public User searchUserByLocale(String locale) {
		return this.listUsers.stream().filter(u -> u.getLocale().equals(locale)).findFirst().orElse(null);
	}

	public User searchUserByTimezone(String timezone) {
		return this.listUsers.stream().filter(u -> u.getTimezone().equals(timezone)).findFirst().orElse(null);
	}

	public User searchUserByLastLoginAt(String last_login_at) {
		return this.listUsers.stream().filter(u -> u.getLast_login_at().equals(last_login_at)).findFirst().orElse(null);
	}

	public User searchUserByEmail(String email) {
		return this.listUsers.stream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);
	}

	public User searchUserByPhone(String phone) {
		return this.listUsers.stream().filter(u -> u.getPhone().equals(phone)).findFirst().orElse(null);
	}

	public User searchUserBySignature(String signature) {
		return this.listUsers.stream().filter(u -> u.getSignature().equals(signature)).findFirst().orElse(null);
	}

	public User searchUserByOrganizationId(int organization_id) {
		return this.listUsers.stream().filter(u -> u.getOrganization_id() == organization_id).findFirst().orElse(null);
	}
	
	public User searchUserByTags(String tags) {
		return this.listUsers.stream().filter(u -> u.getTags().contains(tags)).findFirst().orElse(null);
		
	}

	public User searchUserBySuspended(Boolean suspended) {
		return this.listUsers.stream().filter(u -> u.getShared().equals(suspended)).findFirst().orElse(null);
	}

	public User searchUserByRole(String role) {
		return this.listUsers.stream().filter(u -> u.getRole().equals(role)).findFirst().orElse(null);
	}

}
