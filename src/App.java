import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws IOException {
        Person person1 = new Person("Alex","Voronyuk", LocalDate.of(2000,4,
                12),Gender.male);
        Person person2 = new Person("Anna","Voronyuk",LocalDate.of(1971,7,
                29),Gender.female);
        Person person3 = new Person("Eugene","Voronyuk",LocalDate.of(1964,5,
                9),Gender.male);
        Person person4 = new Person("Marina","Voronyuk",LocalDate.of(2001,10,
                5),Gender.female);
        Person person5 = new Person("Vlad","Sotnikov",LocalDate.of(2001,6,29),
                Gender.male);

        
        person1.addParent(person2);
        person1.addParent(person3);
        person4.addParent(person2);
        person4.addParent(person3);
        person5.addParent(person2);
        person5.addParent(person3);


        FamilyTree familyTree1 = new FamilyTree();
        familyTree1.addPerson(person1);
        familyTree1.addPerson(person2);
        familyTree1.addPerson(person3);
        familyTree1.addPerson(person4);
        familyTree1.addPerson(person5);


//        System.out.println(familyTree1.getSiblings(person5));
        saveTree(familyTree1,"C:\\Users\\HP\\Desktop\\JavaProjects\\FamilyTree\\src\\file_familyTree.txt");
        FamilyTree familyTree2 = (FamilyTree) readObject(
                "C:\\Users\\HP\\Desktop\\JavaProjects\\FamilyTree\\src\\file_familyTree.txt");
        System.out.println(familyTree2);

    }

    static void saveTree(Serializable obj, String filePath) throws IOException {
        Writable writer = new Writer();
        writer.writeObject(obj,filePath);
    }

    static Object readObject(String filePath){
        Writable reader = new Writer();
        return reader.readObject(filePath);
    }

}
