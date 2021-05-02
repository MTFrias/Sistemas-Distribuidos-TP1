package ubi.di.sd.Model;

//import Ler.Ler;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

public class Ficheiros {


    public static void GuardaInformacao(Object obj) {
        try {
            if (((ArrayList) obj).size() != 0) {

                if (((ArrayList) obj).get(0).getClass() == Peixe.class) {
                    System.out.println("Class do tipo peixe");

                    File file = new File("fPeixe.dat");
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
                    os.writeObject((ArrayList<Peixe>)obj);
                    os.flush();
                    os.close();

                    System.out.println("Ficheiro para peixe guardado com sucesso!!");

                } else if (((ArrayList) obj).get(0).getClass() == Carne.class) {
                    File file = new File("fCarne.dat");
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
                    os.writeObject(obj);
                    os.flush();
                    os.close();

                    System.out.println("Ficheiro para carne guardado com sucesso!!");
                } else if (((ArrayList) obj).get(0).getClass() == Bebidas.class) {
                    File file = new File("fBebidas.dat");
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
                    os.writeObject(obj);
                    os.flush();
                    os.close();

                    System.out.println("Ficheiro para bebidas guardado com sucesso!!");
                } else if (((ArrayList) obj).get(0).getClass() == Frutos.class) {
                    File file = new File("fFrutos.dat");
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
                    os.writeObject(obj);
                    os.flush();
                    os.close();

                    System.out.println("Ficheiro para frutos guardado com sucesso!!");
                } else if (((ArrayList) obj).get(0).getClass() == Limpeza.class) {
                    File file = new File("fLimpeza.dat");
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
                    os.writeObject(obj);
                    os.flush();
                    os.close();

                    System.out.println("Ficheiro para limpeza guardado com sucesso!!");
                } else if (((ArrayList) obj).get(0).getClass() == Mercearia.class) {
                    File file = new File("fMercearia.dat");
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
                    os.writeObject(obj);
                    os.flush();
                    os.close();

                    System.out.println("Ficheiro para mercearia guardado com sucesso!!");
                }
            } else {
                System.out.println("O Array encontra-se vazio!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    public static ArrayList<Produto> CarregarTodosProdutos() {

        ArrayList<Produto> obj = new ArrayList<>();

        //Carregar Peixe
        if (CarregarPeixe() != null) {
            ArrayList<Peixe> px = CarregarPeixe();
            for (Peixe item : px) {
                obj.add(item);
                System.out.println(item.getNome());
            }
        }

        //Carregar Carne
        if (CarregarCarne() != null) {
            ArrayList<Carne> px = CarregarCarne();
            for (Carne item : px) {
                obj.add(item);
            }
        }

        //Carregar Bebidas
        if (CarregarBebidas() != null) {
            ArrayList<Bebidas> px = CarregarBebidas();
            for (Bebidas item : px) {
                obj.add(item);
            }
        }

        //Carregar Fruta
        if (CarregarFrutos() != null) {
            ArrayList<Frutos> px = CarregarFrutos();
            for (Frutos item : px) {
                obj.add(item);
            }
        }


        //Carregar Limpeza
        if (CarregarLimpeza() != null) {
            ArrayList<Limpeza> px = CarregarLimpeza();
            for (Limpeza item : px) {
                obj.add(item);
            }
        }

        //Carregar Mercearia
        if (CarregarMercearia() != null) {
            ArrayList<Mercearia> px = CarregarMercearia();
            for (Mercearia item : px) {
                obj.add(item);
            }
        }

        return obj;
    }

    //Guardar num ficheiro o historico de vendas do tipo Produto
    public static void GuardarHistoricoVendas(ArrayList<Produto> lst) {

        try {
            File file = new File("fvendas.dat");
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
            os.writeObject(lst);
            os.flush();
            os.close();

            System.out.println("Ficheiro para historico de vendas guardado com sucesso!!");
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    //Carrega o Historico de Vendas a aprtir do ficheiro
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
            System.out.println(vBebidas);
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
 /*   public static void EscreverPeixes(Vector<Peixe> vPeixe){

        for (int i = 0; i < vPeixe.size(); i++) {
            System.out.println("Li do ficheiro os seguintes dados  ");
            System.out.println("Nome: " + vPeixe.get(i).getNome());
            System.out.println("Preço: " + vPeixe.get(i).getPreco());
            System.out.println("Stock: " + vPeixe.get(i).getPreco());

        }

    }*/

}
