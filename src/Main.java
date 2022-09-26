import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        for(int i = 0; i < args.length; i++){
            Scanner sc = new Scanner(new File("src/" + args[i]));

            ArrayList<String[]> inArr = new ArrayList<>();
            while (sc.hasNext())
                inArr.add(sc.nextLine().split(","));
            buildDZN(inArr, args[i].split("\\.")[0]);
            sc.close();
        }
    }

    private static void buildDZN(ArrayList<String[]> in, String fileName) throws IOException {
        try {
            File dzn = new File(fileName + ".dzn");
            if (dzn.createNewFile()) {
                System.out.println(fileName + dzn.getName());
                FileWriter fileWriter = new FileWriter(dzn);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                StringBuilder stringBuilder = new StringBuilder();
                for(int x = 0; x < in.get(x).length; x++) {
                    stringBuilder.append(in.get(0)[x]);
                    stringBuilder.append(" = [");
                    for(int y = 1; y < in.size(); y++){
                        stringBuilder.append(in.get(y)[x]);
                        if(y < in.size()-1)
                            stringBuilder.append(",");
                    }
                    stringBuilder.append("];\n");
                }
                bufferedWriter.write(stringBuilder.toString());
                bufferedWriter.close();
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}




