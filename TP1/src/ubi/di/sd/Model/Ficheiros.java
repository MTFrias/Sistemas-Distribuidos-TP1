package ubi.di.sd.Model;

import Ler.Ler;


import java.io.*;
import java.util.Vector;

public  class Ficheiros {


    public static void InserirNovoPeixe(){

        //Verificar se esta função está a funcionar
        //Recebe a informação do ficheiro!
        Vector<Peixe> vectorPeixes = lerInformacao();

        System.out.println("Quantos produtos novos quer inserir?");
        int quantidade= Ler.umInt();

        for (int i = 0; i<quantidade; i++) {
            System.out.println("Introduza o Nome: ");
            String nome = Ler.umaString();

            System.out.println("Introduza o preco: ");
            double preco = Ler.umDouble();

            System.out.println("Introduza o stock: ");
            int stock = Ler.umInt();

            Peixe novoPeixe = new Peixe(nome, stock, preco);
            vectorPeixes.add(novoPeixe);
        }
    }


    public static void GuardaPeixaria(Vector<Peixe> obj) {

        try {
            System.out.println("Guardar Ficheiro \n");

            File file = new File("Peixaria.dat");
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
            os.writeObject(obj);
            os.flush();
            os.close();

            System.out.println("Ficheiro guardado com sucesso!!");

        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    public static Vector<Peixe> lerInformacao() {

        Vector<Peixe> vPeixe;
        try {
            System.out.println("Ler Informação Relativa à Peixaria");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Produtos.dat"));

            vPeixe = (Vector<Peixe>) ois.readObject();

            System.out.println("Nome1: " + vPeixe.size());

            ois.close();

            return vPeixe;

        } catch (Exception e) {

            e.getStackTrace();
            return null;
        }
    }

    public static void EscreverPeixes(Vector<Peixe> vPeixe){

        for (int i = 0; i < vPeixe.size(); i++) {
            System.out.println("Li do ficheiro os seguintes dados  ");
            System.out.println("Nome: " + vPeixe.get(i).getNome());
            System.out.println("Preço: " + vPeixe.get(i).getPreco());
            System.out.println("Stock: " + vPeixe.get(i).getPreco());

        }

    }


}
