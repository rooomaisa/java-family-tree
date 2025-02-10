import java.beans.MethodDescriptor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Person {

//    attriuten
    private final String name;
    private String middleName = "";
    private final String lastname;
    private int age;
    private BiologicalGender biologicalGender;
    private Person mother;
    private Person father;
    private List<Person> children = new ArrayList<>();
    private List<Pet> pets;

//    constructor
    public Person(String name, String lastname, int age, BiologicalGender biologicalGender) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.biologicalGender = biologicalGender;
    }

    public Person(String name, String middleName, String lastname, int age, BiologicalGender biologicalGender) {
        this.name = name;
        this.middleName = middleName;
        this.lastname = lastname;
        this.age = age;
        this.biologicalGender = biologicalGender;
    }

    public String getName() {
        return name;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getLastname() {
        return lastname;
    }
    public int getAge() {
        return age;
    }
    public BiologicalGender getBiologicalGender() {
        return biologicalGender;
    }
    public Person getMother() {
        return mother;
    }
    public Person getFather() {
        return father;
    }

//getters en setters

    public List<Person> getSiblings() {
        return findSiblings();
    }

    private List<Person> findSiblings() {
        var siblings = new HashSet<Person>();

        if (mother != null) {
            siblings.addAll(mother.getSiblings());
        }
        if (father != null) {
            siblings.addAll(father.getSiblings());
        }

        siblings.remove(this); // sibling van zichzelf

        List<Person> siblingList = new ArrayList<>(siblings);
        return siblingList;
    }

    public List<Person> getChildren() {
        return children;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBiologicalGender(BiologicalGender biologicalGender) {
        this.biologicalGender = biologicalGender;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }


//    methodes
    public void addParents(Person father, Person mother) {
        setFather(father);
        setMother(mother);
        father.addChild(this);
        mother.addChild(this);
    }

    public void addChild(Person child) {
        if(!getChildren().contains(child)) {
            getChildren().add(child);
        }
        if(biologicalGender == biologicalGender.Male ){
            child.setFather(this);
        }
        if(biologicalGender == biologicalGender.Female ){
            child.setMother(this);
        }
    }




}
