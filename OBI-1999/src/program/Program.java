package program;

import entities.DnaChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Program {
    public static void main(String[] args) {
      String totalChain ="TCATATGCAAATAGCTGCATACCGA";
      String direcChain = "CATA";

      DnaChain test = new DnaChain(totalChain,direcChain);
      System.out.println("Total Chain: "+test.getTotalChain());
      System.out.println("direct: "+test.getDirectChain());
      System.out.println("indirect: "+test.getIndirectChain());
      System.out.println("direct ocurrencys: "+test.getDirectOcurrency());
      System.out.println("Indirect ocurrencys: "+test.getIndirectOcurrency());




    }
}