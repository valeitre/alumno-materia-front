package com.mx.manytoone;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {


    private static  int [] arr;

    public static void main(String[] args) {
        
    }

    public static void main(String[] args) {

        String input = "jhon-Hotmail-22/04/1997-doe-H+katty-Gmail-" +
                "05/08/2002-taylor-M+james-Yahoo-14/02/2005- green-" +
                "H+allison-Hotmail-25/12/1980-parker-M";

        Random random = new Random();
        Integer randomNum = 1000 + random.nextInt(9000);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Se deberá de crear un flujo(Stream) donde se pase dicha cadena y
        //llenar los atributos del objeto con las siguientes reglas sin salir del Stream.
        List<Persona> personaList = Arrays.stream(input.split("\\+"))
                .map(persona -> {
                    String[] detalles = persona.split("-");
                    String nombreCompleto = mayusculas(detalles[0] + " " + detalles[3]);
                    LocalDate fecha = LocalDate.parse(detalles[2], formatter);
                    Integer edad = Period.between(fecha, LocalDate.now()).getYears();
                    String genero = detalles[4];
                    String dominio = detalles[1];
                    String id = detalles[0].toLowerCase() + edad + genero.toLowerCase() + randomNum;
                    String email = String.format("%s.%d.%s@%s.com", detalles[0].toLowerCase(), edad, id, dominio.toLowerCase());
                    return new Persona(nombreCompleto, genero, fecha, email, id);
                })
                .collect(Collectors.toList());
                personaList.forEach(System.out::println);

        System.out.println("Ejercicio 2");

        Optional<Persona> mayorEdad = personaList.stream()
                .filter(p -> p.getEdad() >=18)
                .min(Comparator.comparing(Persona::getFechaNacimiento).reversed());

        List<Persona> correoHatmail = personaList.stream()
                .filter(p -> p.getCorreo().endsWith("@hotmail.com"))
                .collect(Collectors.toList());

        List<Persona> hombre = personaList.stream()
                .filter(p -> p.getGenero().equals("H"))
                .collect(Collectors.toList());

        List<Persona> mujeres = personaList.stream()
                .filter(p -> p.getGenero().equals("M"))
                .collect(Collectors.toList());

        mayorEdad.stream().forEach(System.out::println);

        correoHatmail.stream().forEach(System.out::println);

        hombre.stream().forEach(System.out::println);

        mujeres.stream().forEach(System.out::println);




    }
    //para cambiar la primera letra a mayuscula
    private static String mayusculas(String s){
        if (s == null || s.isEmpty()){
            return s;
        }
        return s.substring(0,1).toUpperCase() +
                s.substring(1).toLowerCase();
    }

}
