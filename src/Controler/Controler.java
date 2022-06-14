package Controler;

import Model.Product;
import ReadAndWrite.ReadAndWriteCSV;
import ValiDate.ValiDate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controler {
        List<Product> products = new ArrayList<>();
        ValiDate valiDate = new ValiDate();

        ReadAndWriteCSV readAndWriteCSV = new ReadAndWriteCSV();

        {readAndWriteCSV.readFile(products);}

        public void productManageMenu(){
            System.out.println("Menu :");
            System.out.println("1. show product list");
            System.out.println("2. Add new product");
            System.out.println("3. Edit product");
            System.out.println("4. delete product");
            System.out.println("5. sort follow price");
            System.out.println("6. find max of price");
            System.out.println("7. read from file");
            System.out.println("8. write in file");
            System.out.println("9. Exit");

            int choice = valiDate.choice1("choice");

            switch (choice){
                case 1:
                    showProductList();
                    break;
                case 2:
                    addNewProduct();
                    break;
                case 3:
                    editProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    sortFllowPrice();
                    break;
                case 6:
                    findFllowMaxPrice();
                    break;
                case 7:
                    readFromFile();
                    break;
                case 8:
                    writetoFile();
                    break;
                case 9:
                    System.exit(0);
            }
        }

        //    case1:
        public void showProductList(){
            System.out.println("Product list:");
            for (Product pt: products) {
                System.out.println(pt);
            }
        }

        //    case 2
        public void addNewProduct(){
            System.out.println("Enter information off new product:");
            String id = valiDate.importString("id");
            for (int i = 0; i < products.size(); i++) {
                if (id.equals(products.get(i).getId())){
                    System.out.println("there are this product in list, please choice other id");
                    creatNewProduct(id);
                }
            }
            products.add(creatNewProduct(id));
            System.out.println("Add product is successful \n \n");

        }

        //    case 3:
        public void editProduct() {
            String id = valiDate.importString("id of editProduct");

            boolean check = true;

            for (int i = 0; i < products.size(); i++) {
                if (id.equals(products.get(i).getId())){
                    check=false;
                    break;
                }

            }
            if (!check) {
                String newId = valiDate.importString("newId of Product");

                if (id.equals(newId)) {
                    for (int i = 0; i < products.size(); i++) {
                        if (id.equals(products.get(i).getId())) {
                            products.set(i, creatNewProduct(newId));
                        }
                    }
                } else {
                    for (int i = 0; i < products.size(); i++) {
                        if (newId.equals(products.get(i).getId())) {
                            System.out.println("this is this id in list, please try again by other id");
                            productManageMenu();
                        }
                    }
                    for (int i = 0; i < products.size(); i++) {
                        if (id.equals(products.get(i).getId())) {
                            products.set(i, creatNewProduct(newId));
                            productManageMenu();
                        }
                    }
                }
                System.out.println("Edit product is successful \n \n");
            } else {
                System.out.println("there is not EditProducts  in list, please check again");
            }
        }

        //    case 4
        public void deleteProduct() {
            String id = valiDate.importString("id of deleteProduct");
            boolean check = true;
            for (int i = 0; i < products.size(); i++) {
                if (id.equals(products.get(i).getId())) {
                    products.remove(i);
                    check = false;
                    break;
                }
                }
            if (check){
                    System.out.println("this is not this ID in list, please check again");
                    productManageMenu();
            } else {
                System.out.println("Delete ID " + id +" is successful \n");
            }
        }

        //    case 5
        public void sortFllowPrice(){
            Collections.sort(products);
            System.out.println("sort by ascending price successfully \n");

        }

        //    case 6
        public void findFllowMaxPrice(){
            List<Product> productsTG = products;
            Collections.sort(productsTG);
            System.out.println("MaxPriceProduct is " + productsTG.get(productsTG.size()-1).toString());
        }

        //    case 7
        public void readFromFile(){
            System.out.println("warning:Actions from the previous reading will be disabled and lost");
            System.out.println("Cảnh báo:các thao tác của mảng products từ lần đọc trước sẽ bị vô hiệu hóa và mất đi");
            System.out.println("1. OK");
            System.out.println("2. Cancel");

            int choice = valiDate.choice2("choice");

            switch (choice) {
                case 1:
                    readAndWriteCSV.readFile(products);
                    System.out.println("read file is successful \n");
                    break;
                case 2:
                    productManageMenu();
                    break;
            }


        }

        //   case 8
        public void writetoFile(){
            System.out.println("warning:If you write a file, the file content will change according to the content you manipulated since the last time you wrote the file");
            System.out.println("Cảnh báo:Nếu bạn ghi file thì nội dung file sẽ thay đổi theo nội dung bạn thao tác tính từ lần ghi file trước");
            System.out.println("1. OK");
            System.out.println("2. Cancel");

            int choice = valiDate.choice2("choice");

            switch (choice) {
                case 1:
                    readAndWriteCSV.writeFile(products);
                    System.out.println("write file is successful \n");
                    break;
                case 2:
                    productManageMenu();
                    break;
            }

        }





        public Product creatNewProduct(String id){
            String name = valiDate.importString("name");
            double price = valiDate.importDouble("price");
            double amount= valiDate.importDouble("amount");
            String describe= valiDate.importString("describe");

            Product product = new Product(id,name,price,amount,describe);
            return product;
        }
    }
