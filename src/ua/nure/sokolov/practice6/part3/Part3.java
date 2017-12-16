package ua.nure.sokolov.practice6.part3;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Part3 {
    public static void main(String[] args) {
        Parking parking = new Parking();
        System.out.println(parking.createParking().toString());
        parking.searchFreePlaces();
    }
}

class Parking{
    List<FreePlace> parc = new LinkedList<>();
    FreePlace fp1 = new FreePlace(false);
    FreePlace fp2 = new FreePlace(true);

    public List<FreePlace> createParking(){
        for (int j = 0; j < 5; j++){
            parc.add(fp1);
            if (j == 2 || j == 4){
                parc.add(fp2);
            }

        }
        return parc;
    }

    public void searchFreePlaces(){
        for (int j = 0; j < parc.size(); j++){
            Scanner scanner = new Scanner(System.in);
                if (parc.get(j) == fp2) {
                    System.out.println("Find free place!");
                    arrivalCar(j);
                    System.out.println(parc.toString());
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    leavingCar(j);
                    System.out.println(parc.toString());
                    break;
                }
        }
    }

    public void arrivalCar(int j){
        parc.remove(j);
        parc.add(j, fp1);
    }

    public void leavingCar(int j){
        parc.remove(j);
        parc.add(j, fp2);
    }
}

class FreePlace{
    private boolean free = false;

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public FreePlace(boolean free) {
        this.free = free;
    }

    @Override
    public String toString() {
        if (free == true) {
            return "Free Place" ;//+ free;
        }else {
            return "Not free place";// + free;
        }
    }
}