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
		}
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
		}
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
			Organizations userOrgani = this.getOrSer().searchOrganizationsById(user.getOrganization_id());
			List<Tickets> userTicket = this.getTicketsSer().searchTicketsByAssigneeId(user.get_id());
			this.getuService().showUserDetail(user, userOrgani.getName(), userTicket);
		}
		// return user;
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
