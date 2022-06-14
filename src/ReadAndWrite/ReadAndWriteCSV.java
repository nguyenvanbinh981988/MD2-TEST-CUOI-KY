package ReadAndWrite;

import Model.Product;

import java.io.*;
import java.util.List;

public class ReadAndWriteCSV {
    public List<Product> readFile(List<Product> products){
        try {
            File file = new File("ProductList.csv");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String str = bufferedReader.readLine();
            products.clear();
            while (str != null) {
                String[] arr = str.split(",");
                String id = arr[0];
                String name = arr[1];
                double price = Double.parseDouble(arr[2]);
                double amount = Double.parseDouble(arr[3]);
                String describe = arr[4];

                Product product = new Product(id,name,price,amount,describe);
                products.add(product);
                str = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }




    public void writeFile(List<Product> products) {
        File file = new File("ProductList.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Product st : products) {
                bufferedWriter.write(st.toWrite());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
