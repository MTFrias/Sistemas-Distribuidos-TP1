package ubi.di.sd.Model;

import ubi.di.sd.Fornecedor.Interface_Fornecedor_Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Validacao {

    public static String readString ()
    {
        BufferedReader canal;
        canal = new BufferedReader ( new InputStreamReader(System.in));
        try
        {
            return canal.readLine();
        }
        catch (IOException ex)
        {
            return null;
        }
    }

    public static void adicionar_fornecedor(ArrayList<Interface_Fornecedor_Servidor> fornecedores, Interface_Fornecedor_Servidor fornecedor){
        if(!fornecedores.contains(fornecedor))
        {
            System.out.println("Fornecedor Adicionado com sucesso!");
            fornecedores.add(fornecedor);
            return;
        }
        System.out.println("Fornecedor já foi adicionado!");
    }
}
