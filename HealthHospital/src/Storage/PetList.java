/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import java.util.Scanner;
import util.Validation;
import DTO.Pet;

/**
 *
 * @author PC
 */
public class PetList {

    Pet[] list;
    final int MAX = 100;
    int count = 0;

    public PetList() {
        list = new Pet[MAX];
        count = 0;
    }

    public boolean addPet(Pet p) {
        int pos;
        if (count >= MAX) return false;
        do {
            p.setId(Validation.getString("Input pet's id: ", "Pet's id is empty or contains all whitespace characters. Please input pet's id again!", 1, 6));
            pos = searchPetReturnPos(p.getId());
            if (pos != -1)
                System.out.println("The pet's id already exists. Input another one!");
        } while (pos != -1);
        p.setName(Validation.getString("Input pet's name: ", "Pet's name is empty or contains all whitespace characters. Please input pet's name again!", 1, 15));
        list[count] = p;
        count++;
        return true;
    }

    public void displayAll() {
        if (count == 0) {
            System.out.println("The pet list is empty. Nothing to print");
            return;
        }
        for (int i = 0; i < count; i++) {
            list[i].output();
        }
    }

    //ham nay de kt id cua Pet co ton tai trong list hay k
    //input: id canf tim
    //output: vi tri tim thay trong list
    public int searchPetReturnPos(String id) {
        for (int i = 0; i < count; i++) {
            if (list[i].getId().equals(id)) {
                return i;
            }
        }
        return -1; //k thay
    }

    public Pet searchPetReturnObj(String id) {
        for (int i = 0; i < count; i++) {
            if (list[i].getId().equals(id)) {
                return list[i];
            }
        }
        return null; //k thay
    }

    public boolean updatePet(String id) {
        Pet p = searchPetReturnObj(id);
        if (p == null) {
            return false;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Input new name: ");
        p.setName(sc.nextLine());
        System.out.print("Input new gender: ");
        p.setGender(sc.nextLine());
        System.out.print("Input new birthday: ");
        p.setBirthday(sc.nextLine());
        return true;
    }

    public boolean removePet(String id) {
        int i = searchPetReturnPos(id);
        if (i == -1) {
            return false;
        }
        for (int j = i; j < count; j++) {
            list[j] = list[j + 1];
        }
        count--;
        return true;
    }

}
