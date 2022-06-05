import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {

        List<List<BigDecimal>> array = new ArrayList<>(100);
        Scanner intScanner = new Scanner(new File("resources/array_int_parts_1.csv"));
        Scanner remainScanner = new Scanner(new File("resources/array_remainders_1.csv"));

        while(intScanner.hasNext() && remainScanner.hasNext()){
            String[] intLine = intScanner.nextLine().split(",");
            String[] remainLine = remainScanner.nextLine().split(",");
            List<BigDecimal> line = new ArrayList<>(100);
            for(int i = 0; i < intLine.length; i++){
                line.add(BigDecimal.valueOf((Double.parseDouble(intLine[i]) * 256d) + Double.parseDouble(remainLine[i])));
            }
            array.add(line);
        }

        int d = 2309;
        int p = 97;
        int q = 149;
        int N = p*q;

        for(List<BigDecimal> line: array){
            for(int i = 0; i < line.size(); i++){
                BigDecimal tmp = line.get(i).pow(d);
                tmp = tmp.remainder(BigDecimal.valueOf(N));
                line.set(i,tmp.setScale(0));
            }
        }

    }

}