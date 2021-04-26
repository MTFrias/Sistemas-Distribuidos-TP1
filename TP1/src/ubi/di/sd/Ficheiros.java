package ubi.di.sd;

import java.io.*;
import java.util.Vector;

public class Ficheiros {

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

    public static void lerInformacao() {

        Vector<Peixe> vPeixe = new Vector<Peixe>();

        boolean reading = true;
        try {
            System.out.println("Ler Inormação");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Produtos.dat"));

            vPeixe = (Vector<Peixe>) ois.readObject();
            System.out.println("Nome1: " + vPeixe.size());

            ois.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void EscreverPeixes(Vector<Peixe> vPeixe){

        for (int i = 0; i < vPeixe.size(); i++) {
            System.out.println("Li do ficheiro os seguintes dados  ");
            System.out.println("Nome: " + vPeixe.get(i).getNome());
            System.out.println("Preço: " + vPeixe.get(i).getPreco());
            System.out.println("Stock: " + vPeixe.get(i).getStock());
        }

    }


}
