/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zigulich.classeimpressao;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.Normalizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan Zigulich
 */
public class BEMATECH {
    public static PrintWriter Impressora;
    
    public static String subsTexto(String t){
        String Receive = Normalizer.normalize(t, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        String Return  = Receive.toUpperCase();
        return Return;
    }
    
    public static void ConfigurarImpressora( String PortaImpressao ){
        FileOutputStream fos;
        try{
            fos             = new FileOutputStream( PortaImpressao );
            PrintWriter ps  = new PrintWriter(fos);
            BEMATECH.Impressora = ps;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possível imprimir na porta "+PortaImpressao+" | "+e.getMessage(), "Erro na impressão", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    
    public static void LinhaDupla( String Texto ){
        Texto = BEMATECH.subsTexto(Texto);
        BEMATECH.Impressora.print( "\n"+(char )27+(char)86+Texto+(char)27+( char)86);
    }
    
    public static void LinhaNegrito(String Texto){
        Texto = BEMATECH.subsTexto(Texto);
        BEMATECH.Impressora.print( "\n"+(char )27+(char)69+Texto+(char)27+( char)70);
    }
    
    public static void LinhaNormal(String Texto){
        Texto = BEMATECH.subsTexto(Texto);
        BEMATECH.Impressora.print(Texto);  
    }
    
    public static void LinhaItalico(String Texto){
        Texto = BEMATECH.subsTexto(Texto);
        BEMATECH.Impressora.print( "\n"+(char )27+(char)52+Texto+(char)27+( char)53);
    }
    
    public static void corteParcial(){
        BEMATECH.Impressora.print( ""+(char )27+(char)109); // aciona guilhotina 
    }
    
    public static void FinalizarImpressao(){
        BEMATECH.Impressora.print( ""+(char )27+(char)119); // aciona guilhotina
        BEMATECH.Impressora.close();
    }
}
