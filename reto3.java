package com.reto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class reto3 {
    /*- Enunciado: Dada una cadena de texto (String) con el nombre completo de una persona, debes crear un método que devuelva 3 campos: nombre, apellido1, apellido2. Debes tener en cuenta que hay nombres compuestos y que puedes recibir un nombre completo sin apellido2 o sin ningún apellido.
Ejemplos: José Martínez Pérez -> nombre: José, apellido1: Martínez, apellido2: Pérez.
                   José María Martínez -> nombre: José María, apellido1: Martínez
                   José -> nombre: José
- Consideraciones: Deberías tener los nombres de pila en un array o fichero, para poder diferenciar entre un nombre de pila y un apellido.*/

    public static void main(String[] args) {
        String[] nombredepila = {"antonio", "jose", "manuel", "jesus", "maria"};

        System.out.println("Porfavor introduzca su nombre");
        //creacion de escaner
        Scanner sc = new Scanner(System.in);
        //damos limite al scanner para \n
        sc.useDelimiter("\n");
        String username = sc.next();

        //función comprobar si es un nombre compuesto
        int numbersname = doublename(nombredepila, username);
        String solucion = namesFinal(username,numbersname);
        System.out.println(solucion);
    }



    public static int doublename(String[] nombredepila, String username) {
        username = username.toLowerCase();



        System.out.println("He llegado aqui");
        //reinicio contador
        int contador = 0;


        //comprobamos que no encuentre dos nombres dentro dato username
        for(String i : nombredepila){
            if(username.contains(i)){
                contador ++;
            }
        }
        return contador;
    }

    public static String namesFinal(String username, int numbersname) {
        List<String> nameFinal = new ArrayList<>();

        String actualname = ""; // lo necesitaremos para ir guardando el nombre en la iteracion
        int listsize;  // necesitaremos el tamaño de la lista más adelante
        username = username + ' '; // necesitaremos añadir un espacio al final para que añada el útlimo nombre
        for(int i = 0 ; i < username.length(); i++) {
            if (username.charAt(i) == ' ') {
                nameFinal.add(actualname);
                actualname ="";
            }else{
                actualname = actualname + username.charAt(i);
            }
        }


            // comprobamos el tamaño de la lista
            listsize = nameFinal.size();
        String solucion = "";
        switch (numbersname) {
            case 0, 1 -> {
                if (listsize == 0) {
                    solucion = "Nombre: " + nameFinal.get(0);

                } else if (listsize == 1) {
                    solucion = "Nombre: " + nameFinal.get(0) + " Apellido: " + nameFinal.get(1);
                } else {
                    solucion = "Nombre " + nameFinal.get(0) + " Apellido1: " + nameFinal.get(1) + " Apellido 2: " + nameFinal.get(2);
                }

            }
            case 2 -> {
                if (listsize == 0) {
                    solucion = " Nombre: " + nameFinal.get(0);

                } else if (listsize == 1) {
                    solucion = " Nombre: " + nameFinal.get(0) + " Nombre2: " + nameFinal.get(1);
                } else {
                    solucion = "Nombre " + nameFinal.get(0) + " Nombre2: " + nameFinal.get(1) + " Apellido 1: " + nameFinal.get(2);
                }


            }
            default -> throw new IllegalStateException("Unexpected value: " + numbersname);
        }
        return solucion;
    }
}
