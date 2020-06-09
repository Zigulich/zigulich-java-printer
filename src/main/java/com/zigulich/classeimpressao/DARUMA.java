/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zigulich.classeimpressao;

import br.com.daruma.jna.DUAL;
import java.text.Normalizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan Zigulich
 */
public class DARUMA {
    
    public String subsTexto(String t){
        String Receive = Normalizer.normalize(t, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        String Return  = Receive.toUpperCase();
        return Return;
    }
    
    public static void ConfigurarImpressora(){
//        DUAL.regPortaComunicacao( PortaImpressao );
        DUAL.eBuscarPortaVelocidade();
    }
    
    public static void LinhaDupla( String Texto ){
        DUAL.iImprimirTexto("<da>"+Texto+"</da>", 0);
    }
    
    public static void LinhaNegrito(String Texto){
        DUAL.iImprimirTexto("<b>"+Texto+"</b>", 0);
    }
    
    public static void LinhaNormal(String Texto){
        DUAL.iImprimirTexto(Texto, 0);
    }
    
    public static void LinhaItalico(String Texto){
        DUAL.iImprimirTexto("<i>"+Texto+"</i>", 0);
    }
    
    public static void LinhaCondensado(String Texto){
        DUAL.iImprimirTexto("<c>"+Texto+"</c>", 0);
    }
    
    public static void LinhaExpandido(String Texto){
        DUAL.iImprimirTexto("<e>"+Texto+"</e>", 0);
    }
    
    public static void corteParcial(){
        DUAL.iImprimirTexto("<confgui>P</confgui>", 0);
        DUAL.iImprimirTexto("<gui></gui>", 0);
    }
    
    public static void FinalizarImpressao(){
        DUAL.iImprimirTexto("<confgui>T</confgui>", 0);
        DUAL.iImprimirTexto("<gui></gui>", 0);
    }
}
