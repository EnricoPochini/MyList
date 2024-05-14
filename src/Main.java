import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        //region load
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MyList<String> str = new MyList<>();
        boolean continua = true;
        while (continua) {
            System.out.print("Inserisci un elemento (digita 'fine' per terminare): ");
            String elemento = br.readLine();

            if (elemento.equalsIgnoreCase("fine")) {
                continua = false;
            } else {
                str.add(elemento);
            }
        }
        //endregion


        System.out.println("quale elemento: ");
        int index = Integer.parseInt(br.readLine());
        System.out.println("elemento: "+str.get(index));

        System.out.println("size: "+str.size());

        System.out.println("remove: ");
        String ess = br.readLine();

        str.remove(ess);

        System.out.println(str);


    }
}