
public class Instructor extends Person {
	private String department;
	public Instructor(String n, int id, String d) {
		super(n, id);
		// TODO Auto-generated constructor stub
	this.department = d;
	}
	public String getInstructorName() { return this.getName(); }//getters superclass
	public int getInstructoridNumber() { return this.getidNumber(); }
	
	public String getDepartment() {return department;}
    public void setDepartment(String adepartment){this.department=adepartment;}
	     
}
