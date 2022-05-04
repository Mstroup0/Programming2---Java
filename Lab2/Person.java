public class Person
{
  private String name;
  private int    id;
  private static int personCount = 0;

  // constructor
  public Person(String pname)
  {
    name = pname;
    personCount++;
    id = 100 + personCount;
  }
  
  public Person()
 {
   name = "N/a";
   id = -1;
   personCount++;
 }

  public String  toString()
  {
    return "name: " + name + "  id: " + id 
      + "  (Person count: " + personCount + ")";
  }

  // static/class method
  public static int getCount()
  {
    return personCount;
  }

// reset method
  public void reset(int newId, String newName)
 {
     name = newName;
     id = newId;
 }

// Get name
   public String getName()
  {
	return name;
  }

// Get id
  public int getId()
  {
   
   return id;
  }

  
}
