package com.practica1.nole.base.domain.controller.arreglos;

import java.io.BufferedReader;
import java.io.FileReader;

public class Primos {

    public Boolean detectarDuplicado(Integer[] arreglo, int posActual){
        Integer valor = arreglo[posActual];
        for (int j = 0; j < arreglo.length; j++) {
            if (j != posActual && arreglo[j] != null && arreglo[j].equals(valor)) {
                return true;
            }
        }
        return false;
    }
    

    public Integer contarLines(){
        Integer cantidad =0;
        String direccion ="/home/debian2025/EStrucutra de datos/data.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(direccion));
            String txt = "";
            while ((txt = br.readLine()) != null){
                cantidad++;
            }
        } catch (Exception e) {
            System.out.println("no se encontro el archivo, error :" + e.getMessage());
        }
        return cantidad;
    }

    public void  numArreglo(){
        
        Long timeInicio = System.nanoTime();

        String direccion ="/home/debian2025/EStrucutra de datos/data.txt";
        Integer arreglo[] = new Integer[contarLines()];
        Integer arreglo2[] = new Integer[contarLines()];
        Integer i =0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(direccion));
            String txt = "";
            while ((txt = br.readLine()) != null){
                if (!txt.trim().isEmpty()){
                    arreglo[i] = Integer.parseInt(txt.trim());
                    i++;
                }
            }
        } catch (Exception e) {
            System.out.println("no se encontro el archivo, error :" + e.getMessage());
        }
        
        Integer cantidadDupli = 0;

        for (int i = 0 ; i < arreglo.length ; i++){
            if (arreglo[i] != null && detectarDuplicado(arreglo, i)) {
                arreglo2[cantidadDupli] = arreglo[i];
                cantidadDupli++;
            }
        }
        

        Long timeFinal = System.nanoTime();


        presentar(arreglo2);
        System.out.println("La cantidad de duplicados son:" + cantidadDupli);
        Long timeTotal = timeFinal - timeInicio;
        System.out.println("el tiempo de ejecucion es:" + timeTotal + " nanosegundos");
    }

    public void presentar(Integer[] n){
        System.out.println("Arreglo de primos");
        System.out.print("[");
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i]);
            if (i < n.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Primos p = new Primos();

        p.numArreglo();
    }

}
