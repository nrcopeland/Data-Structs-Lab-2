
public class Course{ 

private String coursename;
private int registrationcode;
private int capacity;
private int currentenroll;
private int waitlistmax;
int waitlistcurr;
private Instructor instructor;

private Student[] studList;
private Student[] waitList;

public boolean findStud;
public boolean findWait;
public boolean findStudId;

public Course(String cn, int rc, int cap, int wm, Instructor instructor) {
	this.coursename = cn;
	this.registrationcode = rc;
	this.capacity = cap;
	this.waitlistmax = wm;
	this.instructor = instructor;
	studList = new Student[capacity];
	waitList = new Student[waitlistmax];
}
//Getters and setters for all the private variable in the constructor
public String getTitle() {return coursename;}
public void setTitle(String title) {this.coursename = title;}

public int getRegistrationCode() {return registrationcode;}
public void setregistrationcode(int theregistrationcode) {this.registrationcode = theregistrationcode;}

public int getCapacity() {return capacity;}
public void setCapacity(int thecapacity) {this.registrationcode = thecapacity;}

public int getwaitlistmax() {return waitlistmax;}
public void setwaitlistmax(int thewaitlistmax) {this.waitlistmax = thewaitlistmax;}

public Instructor instructor() {return instructor;}
public void setInstructors(Instructor instructor) {this.instructor = instructor;}

public Student[] getstudlist() {return studList;}
public void setStudents(Student[] students) {this.studList = students;}

public Student[] getwaitlist() {return waitList;}
public void setwaitlist(Student[] waitlist) {this.waitList = waitlist;}

public boolean findStudId(Student s) {//finds out if there exists a student with specific id#
	for(int i = 0; i < currentenroll; i++)
		if(studList[i].getidNumber() == s.getidNumber())
			return true;
			System.out.println("The student with id#: " +s.getidNumber()+ " is enrolled in the course");
	for(int j = 0; j < waitlistcurr; j++)
		if(waitList[j].getidNumber() == s.getidNumber())
				return true;
	            System.out.println("the student with id#: " +s.getidNumber()+ " is in the wait list" );
	return false;
}

public boolean findStud(Student s) {//method to find out if student is in the course
	for(int i = 0; i<currentenroll; i++)
		if(studList[i].equals(s))
		return true;
	return false;
}

public boolean findWait(Student s) {//method to find out if student is on the waitlist
	for(int i = 0; i<waitlistcurr; i++)
		if(waitList[i].equals(s))
			return true;
	return false;
}

public void addStudent(Student s) {
	
	if(findStud(s) == true) {
		System.out.println("Student has already registered for this course.");//checks if student is in the course already
	}
	else if(findWait(s) == true) {
		System.out.println("Student is already the wait list for this course.");//checks if student is already on the waitlist
	}
	
	else if(currentenroll != capacity) {
		for(int i = 0; i < studList.length; i++) {//checks if the course is at capacity yet
			if(studList[i] == null) {
				studList[i] = s;
				currentenroll++;	
			}		
			System.out.println("This student has been added to the course.");
		}
	}
	else if (waitList[waitList.length-1] == null) {//checks if waitlist is full
		for(int j =0; j< waitList.length; j++) {//adds to waitlist if not full
			if(waitList[j] == null) {
				waitList[j] = s;
				waitlistcurr++;
				System.out.println("the number of students on the waitlist is:" +waitlistcurr);
			}
		}
	}
	else {
		System.out.println("Unforntunately, the course and waitlist are both full");//if both the course and the waitlist are full this prints out
	}
}

public void removeStudent(Student s) {//removes a student from the course
	if(findStud == false && findWait == false) {
		System.out.println("This is not enrolled in the course.");
	}
	else if(findWait == true) {
		for(int j = 0; j <waitList.length; j++) {
			if(waitList[j].equals(s)) {
				for(int a = j; a<waitList.length; a++){
					waitList[a] = waitList[a+1];
			    }
			}
		}
	}
	
	else if(findStud == true) {
		for(int i = 0; i < studList.length; i++) {
			if(studList[i].equals(s)) {
				studList[i] = waitList[0];
				for(int j = 0; j< waitList.length; j++) {
					waitList[j] = waitList[j+1];
				}
			}
		}
	}}
	public static void main(String[] args) {//basic main that adds an instuctor and student to the class
		Instructor i0 = new Instructor("dr jave", 16511321, "Computer Science");
		Course n1 = new Course("Math", 2410, 32, 10, i0);
		Student s0 = new Student("Tajh",5199,12, 48);
		n1.addStudent(s0);
		
}
}


