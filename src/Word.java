public class Word {
    private double hamProb;
    private double spamProb;
    private int hamAmount;
    private int spamAmount;
    private int amountOfHamMails;
    private int amountOfSpamMails;
    private double alpha = 0.000001;
    private String name;

    public Word(String name, int hamAmount, int spamAmount, int amountOfHamMails, int amountOfSpamMails) {
        this.name = name;
        this.hamAmount = hamAmount;
        this.spamAmount = spamAmount;
        setHamProb(amountOfHamMails);
        setSpamProb(amountOfSpamMails);
    }

    public void setSpamAmount(int spamAmount) {
        this.spamAmount = spamAmount;
    }

    public int getSpamAmount() { return spamAmount; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public void setHamProb(int amountOfMails) {
        double ha = hamAmount;
        double am = amountOfMails;
        hamProb = ha/am;
        if(hamAmount == 0) {
            hamProb = alpha;
        }
    }

    public double getHamProb() {
        return hamProb;
    }

    public double getSpamProb() {
        return spamProb;
    }

    public void setSpamProb(int amountOfMails) {
        double sa = spamAmount;
        double am = amountOfMails;
        spamProb = sa/am;
        if(spamAmount == 0) {
            spamProb = alpha;
        }
    }

    @Override
    public boolean equals(Object o){
        {
            if (o instanceof Word)
            {
                Word c = (Word) o;
                if ( this.name.equals(c.name) )
                    return true;
            }
            return false;
        }
    }

    public boolean equals(String o){
        {
            if (this.name.equals(o))
            {
                return true;
            }
            return false;
        }
    }


}
