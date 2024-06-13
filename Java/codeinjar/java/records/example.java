public record Person(String firstName, String lastName){
  
}

public class Main{
  public static void main (String[] args) {
    Person p = new Person("Shakil", "Ahmed");
    System.out.println(p.firstName +" "+p.lastName);
  }
}

 record Person(String firstName, String lastName){
  
}