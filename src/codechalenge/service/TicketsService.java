package codechalenge.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

import codechalenge.model.Tickets;

public class TicketsService {

	List<Tickets> listTickets;
	public List<Tickets> getListTickets() {
		return listTickets;
	}
	public void setListTickets(List<Tickets> listTickets) {
		this.listTickets = listTickets;
	}
	public void searchList() {
		System.out.println("---------------------------------");
		System.out.println("Search Ticket with");
		System.out.println("_id\nurl\nexternal_id\nname\nalias\ncreated_at\ntype\nsubject\n"
				+ "description\npriority\nstatus\nsubmitter_id\nassignee_id\norganization_id\ntags\nhas_incidents\n"
				+ "due_at\nvia\n");
	}
	@SuppressWarnings("unchecked")
	public TicketsService(){
		listTickets = new ArrayList<Tickets>();
		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader("./data/tickets.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray tickets = (JSONArray) obj;
            
            ObjectMapper mapper = new ObjectMapper();
            tickets.forEach((em)->{
            	
            	Tickets newPw = mapper.convertValue(em, Tickets.class);
            	//System.out.println(newPw.getRole());
            	listTickets.add(newPw);
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
	
	public void showTicketDetail(Tickets u)
	{
		System.out.println("_id                          " + u.get_id());
		System.out.println("alias                        " + u.getUrl());
		System.out.println("external_id                  " + u.getExternal_id());
		System.out.println("created_at                   " + u.getCreated_at());
		System.out.println("active                       " + u.getType());
		System.out.println("verified                     " + u.getSubject());
		System.out.println("shared                       " + u.getDescription());
		System.out.println("locale                       " + u.getPriority());
		System.out.println("timezone                     " + u.getStatus());
		System.out.println("last_login_at                " + u.getSubmitter_id());
		System.out.println("email                        " + u.getAssignee_id());
		System.out.println("phone                        " + u.getOrganization_id());
		System.out.println("tags                         " + u.getTags().toString());
		System.out.println("role                         " + u.getHas_incidents());
		System.out.println("signature                    " + u.getDue_at());
		System.out.println("organization_id              " + u.getVia());
	}
	
	public Tickets searchTicketsById(String id) {
		return this.listTickets.stream().filter(u -> u.get_id() == id).findFirst().orElse(null);
	}

	public Tickets searchTicketsByUrl(String url) {
		return this.listTickets.stream().filter(u -> u.getUrl().equals(url)).findFirst().orElse(null);
	}

	public Tickets searchTicketsByExternalId(String external_id) {
		return this.listTickets.stream().filter(u -> u.getExternal_id().equals(external_id)).findFirst().orElse(null);
	}

	public Tickets searchTicketsByCreatedAt(String created_at) {
		return this.listTickets.stream().filter(u -> u.getCreated_at().equals(created_at)).findFirst().orElse(null);
	}
	
	public Tickets searchTicketsByType(String type) {
		return this.listTickets.stream().filter(u -> u.getType().equals(type)).findFirst().orElse(null);
	}

	public Tickets searchTicketsBySubject(String subject) {
		return this.listTickets.stream().filter(u -> u.getSubject().equals(subject)).findFirst().orElse(null);
	}

	public Tickets searchTicketsByDescription(String description) {
		return this.listTickets.stream().filter(u -> u.getDescription().equals(description)).findFirst().orElse(null);
	}

	public Tickets searchTicketsByPriority(String priority) {
		return this.listTickets.stream().filter(u -> u.getPriority().equals(priority)).findFirst().orElse(null);
	}

	public Tickets searchTicketsByStatus(String status) {
		return this.listTickets.stream().filter(u -> u.getStatus().equals(status)).findFirst().orElse(null);
	}

	public Tickets searchTicketsBySubmitterId(int submitter_id) {
		return this.listTickets.stream().filter(u -> u.getSubmitter_id() == submitter_id).findFirst().orElse(null);
	}
	
	public List<Tickets> searchTicketsByAssigneeId(int assignee_id) {
		return this.listTickets.stream().filter(u -> u.getAssignee_id() == assignee_id).collect(Collectors.toList());
	}
	
	public Tickets searchTicketsByOrganizationId(int organization_id) {
		return this.listTickets.stream().filter(u -> u.getOrganization_id() == organization_id).findFirst().orElse(null);
	}
	
	public Tickets searchTicketsByTags(String tags) {
		return this.listTickets.stream().filter(u -> u.getTags().contains(tags)).findFirst().orElse(null);
		
	}

	public Tickets searchTicketsByHasIncidents(Boolean has_incidents) {
		return this.listTickets.stream().filter(u -> u.getHas_incidents().equals(has_incidents)).findFirst().orElse(null);
	}

	public Tickets searchTicketsByDueAt(String due_at) {
		return this.listTickets.stream().filter(u -> u.getVia().equals(due_at)).findFirst().orElse(null);
	}
	
	public Tickets searchTicketsByVia(String via) {
		return this.listTickets.stream().filter(u -> u.getVia().equals(via)).findFirst().orElse(null);
	}
}
