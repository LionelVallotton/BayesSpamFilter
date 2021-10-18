import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Mail {
    private Set<String> buf = new HashSet<String>();
    private Scanner scanner;
    private String fileName;

    public Mail(String fileName) {
        this.fileName = fileName;
    }

    public void readFile() {
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            Scanner s2 = new Scanner(scanner.nextLine());
            while (s2.hasNext()) {
                String word = s2.next().toLowerCase(Locale.ROOT);
                buf.add(word);
                System.out.println(word);
            }
        }
    }

    public String getFileName(){
        return fileName;
    }

    public List<String> getBuf(){
        return (new ArrayList<String>(buf));
    }

}