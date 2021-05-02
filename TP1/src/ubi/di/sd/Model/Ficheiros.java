package ubi.di.sd.Model;

//import Ler.Ler;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

public  class Ficheiros {

    //Guardar ficheiros
    public static void GuardarFpeixe(ArrayList<Peixe> p){
        try {
            System.out.println("A guardar ficheiro de peixe...");

            File file = new File("fPeixe.dat");
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
            os.writeObject(p);
            os.flush();
            os.close();

            System.out.println("Ficheiro para peixe guardado com sucesso!!");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void GuardarFcarne(ArrayList<Carne> c){
        try {
            System.out.println("A guardar ficheiro de carne...");

            File file = new File("fCarne.dat");
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
            os.writeObject(c);
            os.flush();
            os.close();

            System.out.println("Ficheiro para carne guardado com sucesso!!");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void GuardarFbebidas(ArrayList<Bebidas> b){
        try {
            System.out.println("A guardar ficheiro de bebidas...");

            File file = new File("fBebidas.dat");
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
            os.writeObject(b);
            os.flush();
            os.close();

            System.out.println("Ficheiro para bebidas guardado com sucesso!!");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void GuardarFfrutos(ArrayList<Frutos> f){
        try {
            System.out.println("A guardar ficheiro de Frutos...");

            File file = new File("fFrutos.dat");
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
            os.writeObject(f);
            os.flush();
            os.close();

            System.out.println("Ficheiro para frutos guardado com sucesso!!");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void GuardarFlimpeza(ArrayList<Limpeza> l){
        try {
            System.out.println("A guardar ficheiro de Limpeza...");

            File file = new File("fLimpeza.dat");
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
            os.writeObject(l);
            os.flush();
            os.close();

            System.out.println("Ficheiro para Limpeza guardado com sucesso!!");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void GuardarFMercearia(ArrayList<Mercearia> M){
        try {
            System.out.println("A guardar ficheiro de Mercearia...");

            File file = new File("fMercearia.dat");
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
            os.writeObject(M);
            os.flush();
            os.close();

            System.out.println("Ficheiro para mercearia guardado com sucesso!!");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //Carregar todos os produtos de todos os tipos no arraylist obj
    public static ArrayList<Produto> CarregarTodosProdutos(){

        ArrayList<Produto> obj = new ArrayList<>();

        //Carregar Peixe
        if(CarregarPeixe() != null && CarregarPeixe().size() >0){
            ArrayList<Peixe> px = CarregarPeixe();
            for (Peixe item : px) {
                obj.add(item);
            }
        }

        //Carregar Carne
        if(CarregarCarne() != null  && CarregarCarne().size() > 0) {
            ArrayList<Carne> px = CarregarCarne();
            for (Carne item : px) {
                obj.add(item);
            }
        }

        //Carregar Bebidas
        if(CarregarBebidas() != null && CarregarBebidas().size() >0){
            ArrayList<Bebidas> px = CarregarBebidas();
            for (Bebidas item : px) {
                obj.add(item);
            }
        }

        //Carregar Fruta
        if(CarregarFrutos() != null && CarregarFrutos().size() > 0){
            ArrayList<Frutos> px = CarregarFrutos();
            for (Frutos item : px) {
                obj.add(item);
            }
        }


        //Carregar Limpeza
        if(CarregarLimpeza() != null && CarregarLimpeza().size() > 0){
            ArrayList<Limpeza> px = CarregarLimpeza();
            for (Limpeza item : px) {
                obj.add(item);
            }
        }

        //Carregar Mercearia
        if(CarregarMercearia() != null && CarregarMercearia().size() > 0){
            ArrayList<Mercearia> px = CarregarMercearia();
            for (Mercearia item : px) {
                obj.add(item);
            }
        }

        return obj;
    }

    //Guardar num ficheiro o historico de vendas do tipo Produto
    public static void GuardarHistoricoVendas(ArrayList<Produto> lst){

        try {
            File file = new File("fvendas.dat");
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
            os.writeObject(lst);
            os.flush();
            os.close();

            System.out.println("Ficheiro para historico de vendas guardado com sucesso!!");
        } catch (Exception e){

            System.out.println(e.getMessage());
        }

    }

    //Carrega o Historico de Vendas a apartir do ficheiro
    public static ArrayList<Produto> CarregarHistoricoVendas() {
        ArrayList<Produto> vProduto;

        try {
            System.out.println("A ler informação do ficheiro hostorico de vendas...");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fvendas.dat"));

            vProduto = (ArrayList<Produto>) ois.readObject();
            ois.close();
            return vProduto;

        } catch (Exception e) {

            e.getStackTrace();
            return null;
        }

    }

    //Carregar os arraylist aparitr dos ficheiros
    public static ArrayList<Peixe> CarregarPeixe() {

        ArrayList<Peixe> vPeixe;

        try {
            System.out.println("A ler informação do ficheiro peixe...");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fPeixe.dat"));

            vPeixe = (ArrayList<Peixe>) ois.readObject();
            ois.close();
            return vPeixe;

        } catch (Exception e) {

            e.getStackTrace();
            return null;
        }
    }

    public static ArrayList<Carne> CarregarCarne() {

        ArrayList<Carne> vCarne;
        try {
            System.out.println("A ler informação do ficheiro carne...");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fCarne.dat"));

            vCarne = (ArrayList<Carne>) ois.readObject();
            ois.close();
            return vCarne;

        } catch (Exception e) {

            e.getStackTrace();
            return null;
        }
    }
    public static ArrayList<Bebidas> CarregarBebidas() {
        ArrayList<Bebidas> vBebidas;

        try {
            System.out.println("A ler informação do ficheiro bebidas...");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fBebidas.dat"));

            vBebidas = (ArrayList<Bebidas>) ois.readObject();
            ois.close();
            return vBebidas;

        } catch (Exception e) {

            e.getStackTrace();
            return null;
        }
    }
    public static ArrayList<Frutos> CarregarFrutos() {
        ArrayList<Frutos> vFrutos;

        try {
            System.out.println("A ler informação do ficheiro fruto...");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fFrutos.dat"));

            vFrutos = (ArrayList<Frutos>) ois.readObject();
            ois.close();
            return vFrutos;

        } catch (Exception e) {

            e.getStackTrace();
            return null;
        }
    }
    public static ArrayList<Limpeza> CarregarLimpeza() {
        ArrayList<Limpeza> vLimpeza;

        try {
            System.out.println("A ler informação do ficheiro limpeza...");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fLimpeza.dat"));

            vLimpeza = (ArrayList<Limpeza>) ois.readObject();
            ois.close();
            return vLimpeza;

        } catch (Exception e) {

            e.getStackTrace();
            return null;
        }
    }
    public static ArrayList<Mercearia> CarregarMercearia() {
        ArrayList<Mercearia> vMercearia;

        try {
            System.out.println("A ler informação do ficheiro mercearia...");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fMercearia.dat"));

            vMercearia = (ArrayList<Mercearia>) ois.readObject();
            ois.close();
            return vMercearia;

        } catch (Exception e) {

            e.getStackTrace();
            return null;
        }
    }

}
