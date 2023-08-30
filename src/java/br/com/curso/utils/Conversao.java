/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;


/**
 *
 * @author Usuario
 */
public class Conversao {
    public static Date converterData(String data) throws ParseException {
    SimpleDateFormat fmt = new SimpleDateFormat ("yyyy-mm-dd");
    if(data == null || data.trim().equals("")){
    return null;
    }else{
    Date date = fmt.parse(data);
    return date;
    }
    }
    public static String data2string (Date data){
    SimpleDateFormat fmt = new SimpleDateFormat ("dd/MM/yyyy");
    String dataFormatada = fmt.format(data);
    return dataFormatada;
    }
    public static Date dataAtual(){
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
    Date novaData = new Date(System.currentTimeMillis());
        return novaData;
    }
    public static double valorDinheiro(String valor){
    String conversao = valor.substring(2, valor.length());
    conversao = conversao.replaceAll("[./-]", "");
    conversao = conversao.replace(",",".").trim();
    return Double.parseDouble(conversao);
    }
    public static String valorDinheiro(double valor, String pais){
    NumberFormat formatter = null;
    if (pais.equals("BR")){
        formatter = NumberFormat.getCurrencyInstance();
    }else if (pais.equals("US")){
        formatter = NumberFormat.getCurrencyInstance(new Locale("en","US"));
    }
    String moneyString = formatter.format(valor);
    return moneyString;
    }
}