# codeChalenge
This program provides human can search for Users, Tickets, and Organizations
It can search 
- User by:
*   _id
	  url
	  external_id
	  name
	  alias
	  created_at
	  active
	  verified
	  shared
	  locale
	  timezone
	  last_login_at
	  email
	  phone
	  signature
	  organization_id
	  tags
	  suspended
	  role
- Ticket by:
*   _id
	  url
	  external_id
	  created_at
	  type
	  subject
	  description
	  priority
	  status
	  submitter_id
	  assignee_id
	  organization_id
	  tags
	  has_incidents
	  due_at
	  via
- Organizations by:
*   _id
	  url
	  external_id
	  name
	  domain_names
	  created_at
	  details
	  shared_tickets
	  tags
* For each search action, it can return for one record or null.
* This program requires the user to input the correct keyword to search.
