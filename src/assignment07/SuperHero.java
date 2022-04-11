import java.util.Random;



class SuperHero {
    private String name, gender, alignment;
    private int intel, str, spd, dur, pwr, cmbt;
    private Random rand;
    
    //constructors
    SuperHero(){
        name = gender = "undefined";
        alignment = "neutral";
        intel = str = spd = dur = pwr = cmbt = 0;
        rand = new Random();
    }
    SuperHero(String name, int intel, int str, int spd, int dur, int pwr, int cmbt, String alignment, String gender) {
        this.name = name;
        this.intel = intel;
        this.str = str;
        this.spd = spd;
        this.dur = dur;
        this.pwr = pwr;
        this.cmbt = cmbt;
        this.alignment = alignment;
        this.gender = gender;
        rand = new Random();
    }

    //setters
    void setName(String x){name=x;}
    void setIntelligence(int x){intel=x;}
    void setStrength(int x){str=x;}
    void setSpeed(int x){spd=x;}
    void setDurability(int x){dur=x;}
    void setPower(int x){pwr=x;}
    void setCombat(int x){cmbt=x;}
    void setAlignment(String x){alignment=x;}
    void setGender(String x){gender=x;}

    //getters
    String getName(){return name;}
    int getIntelligence(){return intel;}
    int getStrength(){return str;}
    int getSpeed(){return spd;}
    int getDurability(){return dur;}
    int getPower(){return pwr;}
    int getCombat(){return cmbt;}
    String getAlignment() {return alignment;}
    String getGender(){return gender;}

    int getScore() {
        return ((intel * (dur + spd) * (str + pwr + cmbt)) >> 10) + rand.nextInt(10) + (alignment.equals("good") ? 2 : -2); //because in hero universes good is at the advantage
    }
}