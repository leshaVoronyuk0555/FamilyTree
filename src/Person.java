import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {

    private int id;
    private String name;
    private String lostName;
    private LocalDate dob;
    private LocalDate dod;
    private List<Person> children;
    private Gender gender;
    private Person mother;
    private Person father;

    public Person(String name,String lostName,LocalDate dob,LocalDate dod,Gender gender){
        this.name = name;
        this.lostName = lostName;
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;
        children = new ArrayList<>();
        this.id = -1;

    }

    public Person(String name,String lostName,LocalDate dob,Gender gender){
        this(name,lostName,dob,null,gender);
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLostName(){
        return lostName;
    }

    public Gender getGender() {
        return gender;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public int getAge(){
        return calculateAge();
    }



    private int calculateAge(){
        if(dod == null){
            return Period.between(dob,LocalDate.now()).getYears();
        }else{
            return Period.between(dob,dod).getYears();
        }
    }

    public List<Person> getChildren(){
        return children;
    }

    public boolean addChildren(Person p){

        if(!(children.contains(p))){
            return children.add(p);
        } else return false;
    }

    public boolean addParent(Person p){
//        if(p.equals(this)) return false;
        if(p.getGender() == Gender.male && father == null){
            father = p;
            return true;
        }
        if(p.getGender() == Gender.female && mother == null){
            mother = p;
            return true;
        }
        return false;
    }

    public void setId(int id){
        this.id = id;
    }


    @Override
    public String toString() {
        return "Id: "+id+", Name: " + name + ", lost name: " + lostName + ", age " + getAge();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Person)) return false;
        Person person = (Person) obj;
        return this.getId() == person.getId();

   }
}
