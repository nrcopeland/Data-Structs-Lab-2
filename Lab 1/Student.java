
	public class Student extends Person {//initialize subclass
	    private int credits;
	    private int gradepoints;
	    
	  public Student (String n, int id, int c, int gp){
	  //call the parent constructor
	    super(n,id);
	  //finish instantiating things declared in this class.
	    this.credits = c;
	    this.gradepoints = gp;
	   }
	   public String getStudentName() { return this.getName(); }
	   public int getStudentidNumber() { return this.getidNumber(); } 
	     
	     public int getCredits() {return credits;}
	     public void setCredits(int acredits){this.credits=acredits;}
	     
	     public int getGradepoints() {return gradepoints;}
	     public void setGradepoints(int agradpoints){this.gradepoints=agradpoints;}
	     
	    public boolean equals(Student s) { //compares two students by their idnumber
	        if(this.getidNumber() == s.getidNumber())
	        	return true;
	        return false;
	    }
	  public float calculategpa(){ //calculates gpa
	    int n, t;
	    n = this.getCredits();
	    t = this.getGradepoints();
	    return t/n;    
	}}