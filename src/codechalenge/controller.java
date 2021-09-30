package codechalenge;

import java.util.Scanner;

import codechalenge.service.SearchService;

public class controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in); //
		SearchService serchService = new SearchService();
		serchService.showMessage();
		String run = "";
		while (!run.equals("quit")) {
			run = myObj.nextLine();

			if (run.equals("1")) {
				System.out.println("Select 1) Users or 2) Tickets or 3) Oganizations");
				int select = myObj.nextInt();
				if (select == 1) {
					serchService.findUser();
				}
				if (select == 2) {
					serchService.findTickets();
				}
				if (select == 3) {
					serchService.findOrganizations();
				}
			}
			if (run.equals("2")) {
				serchService.getuService().searchList();
				serchService.getTicketsSer().searchList();
				serchService.getOrSer().searchList();
				
				serchService.showMessage();
			}
		}
		//System.out.print("finished");
	}
}
