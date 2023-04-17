package  entities;

import java.util.ArrayList;

public class DnaChain {
    private ArrayList<String> totalChain;
    private ArrayList<String> directChain;
    private ArrayList<String> indirectChain;
    private ArrayList<Integer> directOcurrency;
    private ArrayList<Integer> indirectOcurrency;

    public DnaChain(ArrayList<String> totalChain, ArrayList<String> directChain){
        this.totalChain = new ArrayList<String>(totalChain);
        this.directChain = new ArrayList<String>(directChain);
        this.indirectChain=new ArrayList<>();
        this.directOcurrency = new ArrayList<>();
        this.indirectOcurrency=new ArrayList<>();


        setIndirectChain();
        setDirectOcurrency();
        setIndirectOcurrency();

    }

    public ArrayList<String> getTotalChain() {
        return totalChain;
    }



    public ArrayList<String> getDirectChain() {
        return directChain;
    }



    public ArrayList<String> getIndirectChain() {
        return indirectChain;
    }

    public void setIndirectChain() {
        for (int i = 0; i<getDirectChain().size();i++){
            String temp="";
        for(int j =0; j<getDirectChain().get(i).length();j++){
            String character = String.valueOf(getDirectChain().get(i).charAt(j));
            switch (character){
                case "A"->character="T";
                case "T"->character="A";
                case "C"->character="G";
                case "G"->character="C";
            }
            temp = character+temp;
        }
        this.indirectChain.add(temp);
        }
    }

    public ArrayList<Integer> getDirectOcurrency() {
        return directOcurrency;
    }

    public void setDirectOcurrency() {
        for (int i = 0; i < getTotalChain().size(); i++) {
            String directChain = getDirectChain().get(i);
            String totalChain = getTotalChain().get(i);
            int count = 0;
            int index = totalChain.indexOf(directChain);
            while (index >= 0) {
                count++;
                index = totalChain.indexOf(directChain, index + directChain.length());
            }
            if (i < directOcurrency.size()) {
                directOcurrency.set(i, count);
            } else {
                directOcurrency.add(count);
            }
        }
    }

    public ArrayList<Integer> getIndirectOcurrency() {
        return indirectOcurrency;
    }

    public void setIndirectOcurrency() {
        for (int i = 0; i < getTotalChain().size(); i++) {
            String indirectChain = getIndirectChain().get(i);
            String totalChain = getTotalChain().get(i);
            int count = 0;
            int index = totalChain.indexOf(indirectChain);
            while (index >= 0) {
                count++;
                index = totalChain.indexOf(indirectChain, index + indirectChain.length());
            }
            if (i < indirectOcurrency.size()) {
                indirectOcurrency.set(i, count);
            } else {
                indirectOcurrency.add(count);
            }
        }
    }
}
