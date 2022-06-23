package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.company.service.Menu.*;

public class Main {

    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input;
            do{
                System.out.println("Wprowadź cyfre z przedziału 1-5, żeby wybrać tryb pracy.");
                System.out.println("Wprowadź znak @, żeby zakończyć działanie programu");
                System.out.println("1.Stwórz obiekt");
                System.out.println("2.Usuń obiekt");
                System.out.println("3.Wyświetl wszystkie obiekty");
                System.out.println("4.Wyświetl obiekty poszczególnych podtypów");
                System.out.println("5.Wyświetl obiekty, których nazwa zawiera podany ciąg znaków");
                System.out.println("6.Awansuj pracownika o podanym indeksie");

                input = reader.readLine();
                switch (input){
                    case "1":
                        createObject();
                        break;
                    case "2":
                        removeObject();
                        break;
                    case "3":
                        showObjects();
                        break;
                    case "4":
                        showSpecyficTypesOfObjects();
                        break;
                    case "5":
                        searchForSpecyficObject();
                        break;
                    case "6":
                        promoteEmployee();
                        break;
                    case "@":
                        System.out.println("Program zakończył działanie");
                        break;
                    default:
                        System.out.println(input + " to niepoprawna wartość, prosze wybrać wartości z przedziału 1-6\n");
                        break;
                }
            }while(!input.equals("@"));
        }catch (IOException ex){
            System.out.println("Niepoprawne wejsce");
        }
    }
}
