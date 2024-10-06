package com.boris.screenmatch.principal;

import com.boris.screenmatch.modelos.ConsultaApi;
import com.boris.screenmatch.modelos.GeneradorDeArchivos;
import com.boris.screenmatch.modelos.MonedaOmdb;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author BORIS
 */
public class _Principal {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
         ConsultaApi consulta = new ConsultaApi();

        while (true) {
            System.out.println("""
                ******************************************************
                Bienvenido/a al conversor de monedas

                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar   
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Soles
                6) Soles =>> Dólar
                7) Dólar =>> Peso colombiano
                8) Peso colombiano =>> Dólar
                9) Salir
                ******************************************************""");

            String monedaBase = "";
            String monedaConvertir = "";
            double monto = 0;

            boolean continuar;

            do {
                continuar = false;
                System.out.println("Elija una opción válida:");
                int opcion = scanner.nextInt(); 

                switch (opcion) {
                    case 1 -> {
                        monedaBase = "USD";
                        monedaConvertir = "ARS";
                    }
                    case 2 -> {
                        monedaBase = "ARS";
                        monedaConvertir = "USD";
                    }
                    case 3 -> {
                        monedaBase = "USD";
                        monedaConvertir = "BRL";
                    }
                    case 4 -> {
                        monedaBase = "BRL";
                        monedaConvertir = "USD";
                    }
                    case 5 -> {
                        monedaBase = "USD";
                        monedaConvertir = "PEN";
                    }
                    case 6 -> {
                        monedaBase = "PEN";
                        monedaConvertir = "USD";
                    }
                    case 7 -> {
                        monedaBase = "USD";
                        monedaConvertir = "COP";
                    }
                    case 8 -> {
                        monedaBase = "COP";
                        monedaConvertir = "USD";
                    }
                    case 9 -> {
                        System.out.println("Saliendo del programa.");
                        return;
                    }
                    default -> {
                        System.out.println("Opción inválida. Por favor, elija una opción válida.");
                        continuar = true;
                        break;
                    }
                }
            } while (continuar);  

            System.out.println("Estás convirtiendo " + monedaBase + " a " + monedaConvertir);

            while (monto <= 0) {
                System.out.println("Ingrese el monto que deseas convertir:");
                monto = scanner.nextInt();

                if (monto <= 0) {
                    System.out.println("Por favor, ingrese un monto mayor a 0.");
                }
            }
            
            try{
            MonedaOmdb moneda = consulta.buscarMoneda(monedaBase, monedaConvertir, monto);
            System.out.println("*******************************************************************************");
            System.out.println("Vas a convertir con el valor de mercado de: " + moneda.conversion_rate());
            System.out.println("El valor de " + monto + " " + monedaBase + " equivale a " + moneda.conversion_result() + " " + monedaConvertir);
            
            GeneradorDeArchivos generarArchivos = new GeneradorDeArchivos();
            generarArchivos.guardarJson(moneda,monto);
            
            }catch(NumberFormatException e){
            System.out.println("Numero no encontrado " + e.getMessage());
            }catch(RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicacion.");
            }
        }
    }
}
