package task1;

public class Fish extends Animal{

    private final String type;

    public Fish(String name, int age, String type){
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getType(){
        return type;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
