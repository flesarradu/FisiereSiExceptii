import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);
        double val = (double) scanner.nextInt();
        try{
            System.out.println(impartire(235.4,val));
        }
        catch (ImpartireLaZero ex){
            //System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Mai introduceti o data numarul");
        }
        val = (double) scanner.nextInt();
        try{
            System.out.println(impartire(235.4,val));
        }
        catch (ImpartireLaZero ex){
            //System.out.println(ex.getMessage());
            System.out.println("La revedere!");
        }




        try {
            afiseazaIntPozitive(5);
        } catch (Exception exception){
           exception.printStackTrace();
        }
        catch (ExceptiaMea ex){
            ex.printStackTrace();
        }


        double d = 325.351;

        int max=0, min=Integer.MAX_VALUE;
        File input = new File("fisierinexistent.txt");
        File output = new File("output.txt");
        List<Integer> lista = new ArrayList<>();
        scanner = null;
        try {
            scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(Integer.parseInt(line) > max){
                    max = Integer.parseInt(line);
                }
                if(Integer.parseInt(line)<min){
                    min=Integer.parseInt(line);
                }
                lista.add(Integer.parseInt(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


        Collections.sort(lista);

        FileWriter writer = null;
        try {
            writer = new FileWriter(output);

            for (var x : lista) {
                writer.write(x + "\n");
            }
            writer.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.printf("Maximul din fisier este %d\nMinimul din fisier este %d", max, min);

    }

    public static double impartire(Double x, Double y) throws ImpartireLaZero{
        if(y == 0){
            throw new ImpartireLaZero();
        }
        return x/y;
    }
    public static int zecimale(Double x){
        String number = String.valueOf(x); //number="325.35"
        System.out.println(number);
        String substring = number.substring(number.indexOf('.') + 1);
        return  Integer.parseInt(substring);
    }


    public static void afiseazaIntPozitive(int x) throws Exception, ExceptiaMea {
        if(x < 0){
            throw new Exception("X este mai mic ca 0");
        }
        if(x == 5){
            throw new ExceptiaMea("Nu-mi place ca e 5");
        }
        System.out.println(x);
    }
}
