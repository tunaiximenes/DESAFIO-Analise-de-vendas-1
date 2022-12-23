package application;

import entities.Sale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String path = "c:\\temp\\base-de-dados.csv";
        System.out.println("Entre o caminho do arquivo: " + path);
        System.out.println();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<Sale> lstSale = new ArrayList<Sale>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                lstSale.add(new Sale(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), fields[2], Integer.parseInt(fields[3]),Double.parseDouble(fields[4])));
                line = br.readLine();

            }

            lstSale.stream().filter(x -> x.getYear() == 2016).collect(Collectors.toList());

            System.out.println("Cinco primeiras vendas de 2016 de maior preço médio");
            lstSale.stream().filter(x -> x.getYear() == 2016).collect(Collectors.toList()).forEach(System.out::println);

            Double sum = lstSale.stream()
                    .filter(s -> (s.getSeller().equals("Logan") && s.getMoth() == 1) ||
                    (s.getSeller().equals("Logan") && s.getMoth() == 7))
                    .map(s -> s.getTotal())
                    .reduce(0.0, (x,y) -> x + y);

            System.out.println();
            System.out.printf("Valor total vendido pelo vendedor Logan nos meses 1 e 7 = " + String.format("%.2f",sum));


        }catch (IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
