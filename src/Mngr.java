import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mngr {
    private HashMap<String, Integer> hamWords = new HashMap<>();
    private HashMap<String, Integer> spamWords = new HashMap<>();
    private HashMap<String, Double> onlySpamWords = new HashMap<>();
    private List<Mail> hamMails = new ArrayList<>();
    private List<Mail> spamMails = new ArrayList<>();

    private double alpha = 0.000001;

    private double genSpamProb = 0.5;
    private double genHamProb = 1 - genSpamProb;

    private File hamDir;
    private File spamDir;
    private String[] hamNames;
    private String[] spamNames;

    public Mngr(String hamDir, String spamDir) {
        this.hamDir = new File(hamDir);
        this.spamDir = new File(spamDir);
        setHamNames();
        setSpamNames();
    }

    public void setHamNames() {
        hamNames = hamDir.list();
    }

    public void setSpamNames() { spamNames = spamDir.list(); }

    public void createMails(List<Mail> mailList, String[] nameList, File dir) {
        for(int i = 0; i < nameList.length; i++) {
            Mail mail = new Mail(dir.getName() + "\\" + nameList[i]);
            mail.readFile();
            mailList.add(mail);
        }
    }

    public void countWords(List<Mail> mailList, HashMap<String, Integer> goalMap) {
        for(int i = 0; i < mailList.size(); i++) {
            for(int j = 0; j < mailList.get(i).getBuf().size(); j++) {
                goalMap.merge(mailList.get(i).getBuf().get(j), 1, Integer::sum);
            }
        }
    }


    public static void main(String[] args) {
        Mngr mngr = new Mngr("hamDir", "spamDir");
        mngr.createMails(mngr.hamMails, mngr.hamNames, mngr.hamDir);
        //mngr.createMails(mngr.spamNames, mngr.spamDir);
        mngr.countWords(mngr.hamMails, mngr.hamWords);
        //mngr.countWords(mngr.spamMails, mngr.spamWords);
        System.out.println(mngr.hamWords);

    }

    public double spamProbability(){
        List<String> wordsInMail = toCompare.getBuf();
        for (int i = 0; i< wordsInMail.size(); i++){
            Word w = getExistingWord(wordsInMail.get(i));
            if (!(w == null)){
                as = as*w.getSpamProb();
                ah = ah*w.getHamProb();
            }
        }
        return as/(as+ah);
    }


}