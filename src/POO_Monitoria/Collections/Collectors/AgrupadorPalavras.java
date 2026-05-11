package Collections.Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Agrupa palavras por tamanho e conta quantas palavras existem de cada tamanho.
 * Também junta as palavras maiores que 4 letras em uma string formatada.
 */

public class AgrupadorPalavras {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList(
            "casa", "carro", "bicicleta", "moto", "avião", 
            "barco", "trem", "ônibus", "pé", "skate"
        );
        
        System.out.println("\n Palavras: " + palavras);
        
        Map<Integer, Long> contagemPorTamanho = palavras.stream()
            .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        
        System.out.println("\nContagem por tamanho:");
        contagemPorTamanho.forEach((tamanho, count) -> 
            System.out.println(tamanho + " letras: " + count + " palavra(s)"));
        
        String palavrasGrandes = palavras.stream()
            .filter(p -> p.length() > 4)
            .collect(Collectors.joining(", ", "Palavras grandes: [", "] \n"));
        
        System.out.println("\n" + palavrasGrandes);
    }
}
