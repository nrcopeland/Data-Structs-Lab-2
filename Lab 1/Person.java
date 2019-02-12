
public class Person {

		private String name;
		private int idnumber;

		public Person(String n, int id) 
		{
		  this.name = n;
		  this.idnumber = id;
		}
	  
	  
	  public void setName(String Aname){this.name=Aname;}//getters/setters for parents class
	  public String getName() {return name;}
	  
	  public void setidNumber(int Aid){this.idnumber=Aid;}
	  public int getidNumber() { return idnumber; }
		
		public String toString() //tostring method that sends to subclass
		{
		  return "Person[name=" + name + ",idnumber=" + idnumber + "]";
		}
}
