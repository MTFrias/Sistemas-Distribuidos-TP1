package ubi.di.sd;

import Ler.Ler;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        Vector<Peixe> vector = new Vector<>();
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
    }

}
