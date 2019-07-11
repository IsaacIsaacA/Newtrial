package com.revature.model;

public class ClaimsProject1 {
	public String username;
	public String password;
	public String claimdescription;
	public String typeofclaim;
	public String statusofapproval;
	public String date;
	public String time;
	public String location;
	public String cost;
	public String gradestandard;
	public String projectedreimbursement;
	public String gradeneeded;
	public boolean urgent;
	public String grade;
	public String Highestapprovalrating;
	public ClaimsProject1(String username, String password, String claimdescription, String typeofclaim,
			String statusofapproval, String date, String time, String location, String cost, String gradestandard,
			String projectedreimbursement, String gradeneeded, boolean urgent, String grade,
			String highestapprovalrating) {
		super();
		this.username = username;
		this.password = password;
		this.claimdescription = claimdescription;
		this.typeofclaim = typeofclaim;
		this.statusofapproval = statusofapproval;
		this.date = date;
		this.time = time;
		this.location = location;
		this.cost = cost;
		this.gradestandard = gradestandard;
		this.projectedreimbursement = projectedreimbursement;
		this.gradeneeded = gradeneeded;
		this.urgent = urgent;
		this.grade = grade;
		Highestapprovalrating = highestapprovalrating;
	}
}
