package abstracts;

public abstract class Person {
 protected String name;
 protected String email;

 public Person(String name, String email) {
     this.name = name;
     this.email = email;
 }

 public abstract void viewProfile();
 public abstract void editProfile();
 
 public String getName() {
     return name;

}
 
 public abstract String getDetails();
}
