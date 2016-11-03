package model;

import java.util.Date;
import java.util.List;

public class Ticket {
	private static final long serialVersionUID = 1L;
	
	private int id; // Ticket's unique id.
	private String usernameRequestor; // The user who requested the ticket.
	private int technicianId; // The user/technician who will respond to the
								// ticket.
	private String phone; // Requestor's phone
	private String email; // Requestor's email. May be different from the User's
							// login email.

	private enum Progress {
		OPEN(0), ASSIGNED(1), INPROGREGSS(2), ONHOLD(3), COMPLETED(4);

		private int progress;

		Progress(int progress) {
			this.progress = progress;
		};

		@SuppressWarnings("unused")
		public String getProgressValue() {
			if(progress == 0){
				return "Open";
			}
			else{
				if(progress == 1){
					return "Assigned";
				}
				else{
					if(progress == 2){
						return "In Progress";
					}
					else{
						if(progress == 3){
							return "On Hold";
						}
						else{
							return "Compeleted";
						}
					}
				}
			}
		}

	};

	// Constant values that apply to the status of a project
	// private Status status; //<-- This was changed into a list of comments
	private Progress currentProgress;
	private String details; // Text concerning the project.
	private Date startDate; // Project's starting date.
	private Date endDate; // Project's completed date.
	private String ticketLocation; // Location where the project is.
	private List<Update> updates;
	// Needs more work...
	private String completionDetails; // Information pertaining vendors, cost,
										// materials used.

	// Full constructor for every field, probably need when pulling existing
	// data from database
	public Ticket(int id, String requestor, int technician, String phone, String email, int progress, String details,
			Date startDate, Date endDate, String ticketLocation, List<Update> updates, String completionDetails) {
		this.id = id;
		this.usernameRequestor = requestor;
		this.technicianId = technician;
		this.phone = phone;
		this.email = email;

		switch (progress) {
		case 0:
		default:
			this.currentProgress = Progress.OPEN;
			break;
		case 1:
			this.currentProgress = Progress.ASSIGNED;
			break;
		case 2:
			this.currentProgress = Progress.INPROGREGSS;
			break;
		case 3:
			this.currentProgress = Progress.ONHOLD;
			break;
		case 4:
			this.currentProgress = Progress.COMPLETED;
			break;
		}
		this.details = details;
		this.startDate = startDate;
		this.endDate = endDate;
		this.updates = updates;
		this.ticketLocation = ticketLocation;
		this.completionDetails = completionDetails;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRequestor() {
		return usernameRequestor;
	}

	public void setRequestor(String requestor) {
		this.usernameRequestor = requestor;
	}

	public int getTechnicianId() {
		return technicianId;
	}

	public void setTechnician(int technician) {
		this.technicianId = technician;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getTicketLocation() {
		return ticketLocation;
	}

	public void setTicketLocation(String ticketLocation) {
		this.ticketLocation = ticketLocation;
	}

	public String getCompletionDetails() {
		return completionDetails;
	}

	public void setCompletionDetails(String completionDetails) {
		this.completionDetails = completionDetails;
	}

	public List<Update> getUpdates() {
		return updates;
	}

	public void setUpdates(List<Update> updateComments) {
		this.updates = updateComments;
	}

	public String getProgress() {
		return currentProgress.getProgressValue();
	}

	public void setProgress(int progress) {
		switch (progress) {
		case 0:
			this.currentProgress = Progress.OPEN;
			break;
		case 1:
			this.currentProgress = Progress.ASSIGNED;
			break;
		case 2:
			this.currentProgress = Progress.INPROGREGSS;
			break;
		case 3:
			this.currentProgress = Progress.ONHOLD;
			break;
		case 4:
			this.currentProgress = Progress.COMPLETED;
			break;
		default:
			break; // Does nothing if it is outside range
		}
	}

}
