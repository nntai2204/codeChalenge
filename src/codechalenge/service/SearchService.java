package codechalenge.service;

import java.util.List;
import java.util.Scanner;

import codechalenge.model.Organizations;
import codechalenge.model.Tickets;
import codechalenge.model.User;

public class SearchService {

	UserService uService;
	TicketsService ticketsSer;
	OrganizationsService orSer;

	public SearchService() {
		ticketsSer = new TicketsService();
		orSer = new OrganizationsService();
		uService = new UserService();

	}

	public void showMessage()
	{
		System.out.println("\n===================================");
		System.out.println("Type 'quit' to exit at any time, Press 'Enter' to continue\n\n");
		System.out.println("Select search options:");
		System.out.println("* Press 1 to search");
		System.out.println("* Press 2 to view a list of searchale fields");
		System.out.println("* Press 'quit' to exit");
	}
	public void findTickets() {

		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		System.out.println("Enter Search term");

		String seachTerm = myObj.nextLine(); // Read user input
		String value = "";
		System.out.println("seach Term is: " + seachTerm);
		@SuppressWarnings("unused")
		Tickets tic = null;
		switch (seachTerm) {
		case "_id":
			System.out.println("Enter Search value");
			String id = myObj.nextLine();
			tic = ticketsSer.searchTicketsById(id);
			break;
		case "url":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			tic = ticketsSer.searchTicketsByUrl(value);
			break;
		case "external_id":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			tic = ticketsSer.searchTicketsByExternalId(value);
			break;
		case "created_at":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			tic = ticketsSer.searchTicketsByCreatedAt(value);
			break;
		case "type":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			tic = ticketsSer.searchTicketsByType(value);
			break;
		case "subject":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			tic = ticketsSer.searchTicketsBySubject(value);
			break;
		case "description":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			tic = ticketsSer.searchTicketsByDescription(value);
			break;
		case "priority":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			tic = ticketsSer.searchTicketsByPriority(value);
			break;
		case "status":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			tic = ticketsSer.searchTicketsByStatus(value);
			break;
		case "submitter_id":
			System.out.println("Enter Search value");
			int submitter_id = myObj.nextInt();
			tic = ticketsSer.searchTicketsBySubmitterId(submitter_id);
			break;
		case "assignee_id":
			System.out.println("Enter Search value");
			int assignee_id = myObj.nextInt();
			tic = ticketsSer.searchTicketsByAssigneeId(assignee_id).get(0);
			break;
		case "organization_id":
			System.out.println("Enter Search value");
			int organization_id = myObj.nextInt();
			tic = ticketsSer.searchTicketsByOrganizationId(organization_id);
			break;
		case "tags":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			tic = ticketsSer.searchTicketsByTags(value);
			break;
		case "due_at":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			tic = ticketsSer.searchTicketsByDueAt(value);
			break;
		case "via":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			tic = ticketsSer.searchTicketsByVia(value);
			break;
		default:
			break;
		}
		if(tic != null)
		{
			System.out.println("\n===============Result===============");
			Organizations o = this.getOrSer().searchOrganizationsById(tic.getOrganization_id());
			User assi = this.getuService().searchUserById(tic.getAssignee_id());
			User submit = this.getuService().searchUserById(tic.getSubmitter_id());
		
			this.getTicketsSer().showTicketDetail(tic, o.getName(), assi.getName(), submit.getName());
		}else {
			System.out.println("Tickeck Not Found");
		}
		this.showMessage();
	}

	public void findOrganizations() {
		
		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		System.out.println("Enter Search term");

		String seachTerm = myObj.nextLine(); // Read user input
		String value = "";
		System.out.println("seach Term is: " + seachTerm);
		@SuppressWarnings("unused")
		Organizations org = null;
		switch (seachTerm) {
		case "_id":
			System.out.println("Enter Search value");
			int id = myObj.nextInt();
			org = orSer.searchOrganizationsById(id);
			break;
		case "url":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			org = orSer.searchOrganizationsByUrl(value);
			break;
		case "external_id":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			org = orSer.searchOrganizationsByExternalId(value);
			break;
		case "name":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			org = orSer.searchOrganizationsByName(value);
			break;
		case "domain_names":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			org = orSer.searchOrganizationsByDomainNames(value);
			break;
		case "created_at":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			org = orSer.searchOrganizationsByCreatedAt(value);
			break;
		case "details":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			org = orSer.searchOrganizationsByDetails(value);
			break;
		case "shared_tickets":
			System.out.println("Enter Search value");
			Boolean share = myObj.nextBoolean();
			org = orSer.searchOrganizationsBySharedTickets(share);
			break;
		case "tags":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			org = orSer.searchOrganizationsByTags(value);
			break;
		default:
			break;
		}
		if(org != null) {
			System.out.println("\n===============Result===============");
			User u = this.getuService().searchUserByOrganizationId(org.get_id());
			Tickets t = this.getTicketsSer().searchTicketsByOrganizationId(org.get_id());
			
			this.getOrSer().showOrganizationDetail(org, t.getSubject(), u.getName());
		}else {
			System.out.println("Organization Not Found");
		}
		this.showMessage();
	}

	public void findUser() {

		User user = null;
		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		System.out.println("Enter Search term");

		String seachTerm = myObj.nextLine(); // Read user input
		String value = "";
		System.out.println("seach Term is: " + seachTerm); // Output user input
		switch (seachTerm) {
		case "_id":
			System.out.println("Enter Search value");
			int id = myObj.nextInt();
			user = uService.searchUserById(id);
			break;
		case "url":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			user = uService.searchUserByUrl(value);
			break;
		case "external_id":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			user = uService.searchUserByExternalId(value);
			break;
		case "name":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			user = uService.searchUserByName(value);
			break;
		case "alias":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			user = uService.searchUserByAlias(value);
			break;
		case "created_at":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			user = uService.searchUserByCreatedAt(value);
			break;
		case "active":
			System.out.println("Enter Search value");
			Boolean valuea = myObj.nextBoolean();
			user = uService.searchUserByActive(valuea);
			break;
		case "verified":
			System.out.println("Enter Search value");
			Boolean valuev = myObj.nextBoolean();
			user = uService.searchUserByVerified(valuev);
			break;
		case "shared":
			System.out.println("Enter Search value");
			Boolean values = myObj.nextBoolean();
			user = uService.searchUserByShared(values);
			break;
		case "locale":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			user = uService.searchUserByLocale(value);
			break;
		case "timezone":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			user = uService.searchUserByTimezone(value);
			break;
		case "last_login_at":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			user = uService.searchUserByLastLoginAt(value);
			break;
		case "email":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			user = uService.searchUserByEmail(value);
			break;
		case "phone":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			user = uService.searchUserByPhone(value);
			break;
		case "signature":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			user = uService.searchUserBySignature(value);
			break;
		case "organization_id":
			System.out.println("Enter Search value");
			int oId = myObj.nextInt();
			user = uService.searchUserByOrganizationId(oId);
			break;
		case "tags":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			user = uService.searchUserByTags(value);
			break;
		case "suspended":
			System.out.println("Enter Search value");
			Boolean valuesu = myObj.nextBoolean();
			user = uService.searchUserBySuspended(valuesu);
			break;
		case "role":
			System.out.println("Enter Search value");
			value = myObj.nextLine();
			user = uService.searchUserByRole(value);
			break;
		default:
			break;
		}
		if (user != null) {
			System.out.println("\n===============Result===============");
			Organizations userOrgani = this.getOrSer().searchOrganizationsById(user.getOrganization_id());
			List<Tickets> userTicket = this.getTicketsSer().searchTicketsByAssigneeId(user.get_id());
			this.getuService().showUserDetail(user, userOrgani.getName(), userTicket);
		}else {
			System.out.println("User Not Found");
		}
		this.showMessage();
	}

	public UserService getuService() {
		return uService;
	}

	public void setuService(UserService uService) {
		this.uService = uService;
	}

	public TicketsService getTicketsSer() {
		return ticketsSer;
	}

	public void setTicketsSer(TicketsService ticketsSer) {
		this.ticketsSer = ticketsSer;
	}

	public OrganizationsService getOrSer() {
		return orSer;
	}

	public void setOrSer(OrganizationsService orSer) {
		this.orSer = orSer;
	}

}
