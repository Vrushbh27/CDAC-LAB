//What will be the output ?
//Are there any objects marked for GC ?

class Tank {
  private int level;

  Tank(int l) {
    level = l;
  }

  public void setLevel(int level1) {
    level = level1;
  }

  public int getLevel() {
    return level;
  }
}

public class Assignment {
  public static void main(String[] args) {
    Tank t1 = new Tank(10);
    Tank t2 = new Tank(20);
   //10 20
    System.out.println("1: t1.level: " + t1.getLevel() +
        ", t2.level: " + t2.getLevel());
    t1 = t2;
    //20 20
    System.out.println("2: t1.level: " + t1.getLevel() +
        ", t2.level: " + t2.getLevel());
    t1.setLevel(27);
    //27 20
    System.out.println("3: t1.level: " + t1.getLevel() +
        ", t2.level: " + t2.getLevel());
        //27 37
    t2.setLevel(t1.getLevel() + 10);
    System.out.println("4: t1.level: " + t1.getLevel() +
        ", t2.level: " + t2.getLevel());
  }
}