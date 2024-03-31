package task1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dog extends Animal{

    private List<String> commands = Arrays.asList("Sit", "Secure");

    public Dog(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void  makeSound(){
        System.out.println("Woff");
    }
     public void addNewCommand(String newCommand){
        commands.add(newCommand);
     }

     public void getCommands(){
        for (String s: commands){
            System.out.println(s);
        }
     }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age  +
                ", commands: " + commands
                +'}';
    }
}
