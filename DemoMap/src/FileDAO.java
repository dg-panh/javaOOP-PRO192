
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class FileDAO {
    //ham nay de ghi ds dog vao file nhi phan
    public static void writeDogsToFile(String filename, ArrayList<Dog> data) {
        FileOutputStream f = null;
        ObjectOutputStream of = null;
        try {
            f = new FileOutputStream(filename);
            of = new ObjectOutputStream(f);
            of.writeObject(data);
        }
        catch (IOException e) {
            System.out.println(e);
        }
        finally {
            try {
                if (f != null) f.close();
                if (of != null) of.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    
    public static ArrayList<Dog> readDogsFromFile(String filename) {
        FileInputStream f = null;
        ObjectInputStream of = null;
        ArrayList<Dog> list = null;
        
        try {
            f = new FileInputStream(filename);
            of = new ObjectInputStream(f);
            list = (ArrayList<Dog>) of.readObject();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            try {
                if (f != null) f.close();
                if (of != null) of.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return list;        
    }
}
