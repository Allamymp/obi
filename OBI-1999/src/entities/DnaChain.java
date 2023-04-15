package  entities;
public class DnaChain {
    private String totalChain;
    private String directChain;
    private String indirectChain;
    private int directOcurrency;
    private int indirectOcurrency;

    public DnaChain(String totalChain, String directChain){
        this.totalChain = totalChain.toUpperCase();
        this.directChain = directChain.toUpperCase();
        setIndirectChain(directChain);
        setDirectOcurrency();
        setIndirectOcurrency();
    }

    public void setIndirectChain(String directChain) {
        String [] temp = directChain.split("");
        for(int i = 0;i< temp.length;i++){
            switch (temp[i]){

                case "T"->temp[i] = "A";
                case "A"->temp[i] = "T";
                case "C"->temp[i] = "G";
                case "G"->temp[i] = "C";

            }

        }
        for(int i =0; i< temp.length;i++){
         if(indirectChain!=null) {
             indirectChain = temp[i] + indirectChain;
         }
         else{
             indirectChain = temp[i];
         }
        }
    }

    public String getDirectChain() {
        return directChain;
    }

    public String getIndirectChain() {
        return indirectChain;
    }

    public String getTotalChain() {
        return totalChain;
    }

    public void setDirectOcurrency() {
        int index = getTotalChain().indexOf(getDirectChain());
        while(index>=0){
            this.directOcurrency++;
            index = getTotalChain().indexOf(getDirectChain(), index + 1);
        }
    }
public void setIndirectOcurrency(){
    int index = getTotalChain().indexOf(getIndirectChain());
    while(index>=0){
        this.indirectOcurrency++;
        index = getTotalChain().indexOf(getIndirectChain(), index + 1);
    }
}
    public int getDirectOcurrency() {
        return directOcurrency;
    }

    public int getIndirectOcurrency() {
        return indirectOcurrency;
    }
}
