
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class DogList {
    HashMap<Integer, Dog> h;

    public DogList() {
        h = new HashMap<>();
    }
    
    public boolean addDog(Dog d) {
        h.put(d.id, d);
        return true;
    }
    
    public void displayAll() {
        Collection<Dog> tmp = h.values();
        tmp.forEach(dog -> {
            System.out.println(dog);
        });
    }
    
    public boolean searchDog(int id) {
        h.keySet();
        return true;
    }
    
    public void saveFile() {
        String filename = "dogs.data";
        Collection<Dog> tmp = h.values();
        ArrayList<Dog> data = new ArrayList<>();
        for (Dog dog : tmp) {
            data.add(dog);
        }
        FileDAO.writeDogsToFile(filename, data);
    }
    
    public void testWriteFile() {
        String filename = "dog.dat";
        ArrayList<Dog> data = new ArrayList<>();
        data.add(new Dog(1, "Tung"));
        data.add(new Dog(2, "Son"));
        data.add(new Dog(3, "Khoa"));
        FileDAO.writeDogsToFile(filename, data);
    }
    
    public void testReadFile() {
        String filename = "dog.dat";
        ArrayList<Dog> list = FileDAO.readDogsFromFile(filename);
        System.out.println(list);
    }
}
