package ubi.di.sd;

import ubi.di.sd.Model.Peixe;


import java.io.*;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

       // Peixe peixe = new Peixe("Gagri",10,10,now,5);


        /*
       //Vector<Peixe> vector = new Vector<>();
        for (int i = 0; i < 2; i++) {
            System.out.println("Introduza o Nome: \n");
            String nome = Ler.umaString();

            System.out.println("Introduza o preco: \n");
            double preco = Ler.umDouble();

            System.out.println("Introduza o stock: \n");
            int stock = Ler.umInt();

            Peixe novo = new Peixe(nome, stock, preco);

            vector.add(novo);
        }
        Ficheiros.GuardaPeixaria(vector);
        Ficheiros.lerInformacao();
        */
    }

}
