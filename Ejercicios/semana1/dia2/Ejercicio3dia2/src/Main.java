import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        double base;
        double heigth;
        double area;
        Scanner sc = new Scanner(System.in);
        System.out.println("introduce una base para tu triangulo");
        base = sc.nextDouble();
        System.out.println("introduce una altura para tu triangulo");
        heigth = sc.nextDouble();
        area = (base * heigth) / 2;
        System.out.println("El area de tu triangulo es " + area);
    }
}