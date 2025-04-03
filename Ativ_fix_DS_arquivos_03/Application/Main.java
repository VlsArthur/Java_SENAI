package Ativ_fix_DS_arquivos_03.Application;

import Ativ_fix_DS_arquivos_03.Entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        String path = "src/main/java/Ativ_fix_DS_arquivos_03/src/file";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();
            ArrayList<Product> products = new ArrayList<Product>();
            while (line!=null) {
                String[] attributes = line.split(",");
                products.add(new Product(attributes[0], Double.parseDouble(attributes[1]), Integer.parseInt(attributes[2])));
                line = bufferedReader.readLine();
            }

            path = "src/main/java/Ativ_fix_DS_arquivos_03/out/summary.csv";

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
                for (Product product : products) {
                    line = product.getName() + ", " + String.format("%.2f", product.totalValue());
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
