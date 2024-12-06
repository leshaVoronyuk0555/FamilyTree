import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable{


    private List<Person> tree;
    private int humanId;

    public FamilyTree(){
        this.tree = new ArrayList<>();
    }

    public void addPerson(Person person){
        if(!(tree.contains(person))){
            person.setId(humanId++);
            tree.add(person);
            addToChildren(person);
            addToParents(person);
        }
    }

    private void addToChildren(Person person){
        for(Person p : person.getChildren()){
            p.addParent(person);
        }
    }

    private void addToParents(Person person){
        if(person.getFather() != null){
            person.getFather().addChildren(person);
        }
        if(person.getMother() != null){
            person.getMother().addChildren(person);
        }
    }

    public List<Person> getSiblings(Person person){
        List<Person> siblings = new ArrayList<>();
        for(Person p : person.getMother().getChildren()){
            if(!(p.equals(person))){
                siblings.add(p);
            }
        }
        return siblings;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    private String getInfo(){
        StringBuilder str = new StringBuilder();
        for(Person p : tree){
            str.append(p);
            str.append("\n");
        }
        return str.toString();
    }






}
