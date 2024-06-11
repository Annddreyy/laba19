import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Clothing[] clothings = new Clothing[]{
                new Skirt(ClothingSize.L, 1300, "red"),
                new Tie(ClothingSize.M, 2500, "green"),
                new Trousers(ClothingSize.XXS, 1300, "black"),
                new TShirt(ClothingSize.XS, 1000, "black")
        };

        Studio studio = new Studio();
        studio.dressFemale(clothings);
        studio.dressMan(clothings);
    }
}
enum ClothingSize{
    XXS(32) {
        public void getDescription() {
            System.out.println("Детский размер");
        }
    },
    XS(34),
    S(36),
    M(38),
    L(40);
    int euroSize;
    ClothingSize(int euroSize){
        this.euroSize = euroSize;
    }

    public void getDescription(){
        System.out.println("Взрослый размер");
    }
}

interface MaleClothing {
    void DressAMan();
}

interface FemaleClothing {
    void DressAFemale();
}

abstract class Clothing {
    ClothingSize size;
    double price;
    String color;

    public Clothing(ClothingSize size, double price, String color){
        this.size = size;
        this.price = price;
        this.color = color;
    }
}

class TShirt extends Clothing implements MaleClothing, FemaleClothing{
    public TShirt(ClothingSize size, double price, String color){
        super(size, price, color);
    }
    public void DressAFemale(){
        System.out.printf("Женщина одела футболку (размер - %s, цена - %f, цвет - %s)\n", size.name(), price, color);
    }
    public void DressAMan() {
        System.out.printf("Мужчина одел футболку (размер - %s, цена - %f, цвет - %s)\n", size.name(), price, color);
    }
}

class Trousers extends Clothing implements  MaleClothing, FemaleClothing{
    public Trousers(ClothingSize size, double price, String color){
        super(size, price, color);
    }
    public void DressAFemale(){
        System.out.printf("Женщина одела штаны (размер - %s, цена - %f, цвет - %s)\n", size.name(), price, color);
    }
    public void DressAMan() {
        System.out.printf("Мужчина одел штаны (размер - %s, цена - %f, цвет - %s)\n", size.name(), price, color);
    }
}

class Skirt extends Clothing implements FemaleClothing{
    public Skirt(ClothingSize size, double price, String color){
        super(size, price, color);
    }
    public void DressAFemale(){
        System.out.printf("Женщина одела юбку (размер - %s, цена - %f, цвет - %s)\n", size.name(), price, color);
    }
}

class Tie extends Clothing implements MaleClothing {
    public Tie(ClothingSize size, double price, String color){
        super(size, price, color);
    }
    public void DressAMan(){
        System.out.printf("Мужчина одел галстук (размер - %s, цена - %f, цвет - %s)\n", size.name(), price, color);
    }
}

class Studio {
    public void dressMan(Clothing[] clothing) {
        for (Clothing cloth: clothing) {
            if (cloth instanceof MaleClothing){
                ((MaleClothing)cloth).DressAMan();
            }
        }
    }

    public void dressFemale(Clothing[] clothing) {
        for (Clothing cloth: clothing) {
            if (cloth instanceof FemaleClothing){
                ((FemaleClothing)cloth).DressAFemale();
            }
        }
    }
}