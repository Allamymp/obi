package program;

import entities.DnaChain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Program{
public static void main(String[] args) {
        ArrayList<String> listDirect = new ArrayList<>();
        ArrayList<String> listTotal = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("./src/GENOMA.in"))) {
                String line;

                while (!Objects.equals(line = br.readLine(), "0 0")) {
                        listDirect.add(br.readLine());
                        listTotal.add(br.readLine());
                }
        } catch (IOException e) {
                System.out.println("Error reading file");
                e.printStackTrace();
        }

        DnaChain test = new DnaChain(listTotal, listDirect);


        for (int i =0; i< listTotal.size();i++){
                System.out.println("Test "+(i+1));
                System.out.println("-----------------------");
                System.out.println("Dna chain : "+test.getTotalChain().get(i));
                System.out.println("Direct ocurrence searched: "+test.getDirectChain().get(i));
                System.out.println("Indirect ocurrence searched: "+test.getIndirectChain().get(i));
                System.out.println("Direct ocurrences found: "+test.getDirectOcurrency().get(i));
                System.out.println("Indirect ocurrences found: "+test.getIndirectOcurrency().get(i));
                System.out.println("-----------------------");

        }



}
}