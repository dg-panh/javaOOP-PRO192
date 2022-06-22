/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import DTO.Owner;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class OwnerList {
    Owner[] list;
    int n;
    final int MAX = 100;

    public OwnerList() {
        list = new Owner[MAX];
        n = 0;
    }
    
    public boolean addOwner(Owner o) {
        if (n >= MAX) return false;
        list[n] = o;
        n++;
        return true;
    }
    
    public void displayAll() {
        for (int i = 0; i < n; i++) {
            list[i].output();
        }
    }
    
    public Owner searchOwner(String id) {
        for (int i = 0; i < n; i++) {
            if (list[i].getId().equals(id)) {
                return list[i];
            }
        }
        return null;
    }
    
    public boolean updatePet(String id) {
        Owner o = searchOwner(id);
        if (o == null) return false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Input new name: ");
        o.setName(sc.nextLine());
        System.out.print("Input new address: ");
        o.setAddress(sc.nextLine());
        return true;
    }

}
