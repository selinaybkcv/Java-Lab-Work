import java.util.Scanner;

public class DungeonCrawler {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int golemHp = 19;
      int golemAttack = 14;
      String code = "";
      String classTitle = "";
      String special1 = "";
      String tag = "";
      int hp = 0;
      int damage = 0;
      int bonus = 0;
      int defense = 0;
      boolean valid = true;
      int special2 = 0;
 
      
      System.out.print("Hero name: ");
      String name = input.nextLine().trim();
      
      if (name.equals("")) {
         System.out.println("Invalid name.");
         valid = false; }
      else {
         System.out.print("Hero class: ");
         String className = input.nextLine().trim().toLowerCase();
         switch (className) {
            case "warrior": code = "WAR";
                            hp = 68;
                            damage = 17;
                            bonus = 0;
                            defense = 5;
                            special1 = "Block 5";
                            special2 = 5;
                            break;
            case "rogue": code = "ROG";
                          hp = 51;
                          damage = 16;
                          bonus = 4;
                          defense = 0;
                          special1 = "Critical +4";
                          special2 = 4;
                          break;
            case "ranger": code = "RAN";
                           hp = 56;
                           damage = 16;
                           bonus = 0;
                           defense = 3;
                           special1 = "Range 3";
                           special2 = 3;
                           break;
            case "mage": code = "MAG";
                         hp = 39;
                         damage = 12;
                         bonus = 7;
                         defense = 0;
                         special1 = "Spell Power +7";
                         special2 = 7;
                         break;
            default : System.out.println("Invalid class."); 
                      valid = false;
         }
         if (valid) {
            if (name.length() > 3){
               tag = name.substring(0,3).toUpperCase() + "-" + code; }
            else {
               tag = name.toUpperCase() + "-" + code; }
         
            String title = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase() + " the " + className.substring(0,1).toUpperCase()+ className.substring(1);
            System.out.println(tag +  " "+ title + " | HP "+ hp + " | DMG "+ damage + " | "+ special1);
            int hit = damage + bonus;
            int golemLeft = Math.max(0, 19- hit);
            int damageHero = golemAttack - special2;
      
            System.out.println(tag + " hits the Stone Golem for "+ hit);
            System.out.println("Stone Golem HP Left: "+ golemLeft);
      
      
      
            if (golemLeft == 0)
               System.out.println("Result: Victory"); 
            else {
               System.out.println("Stone Golem hits "+ tag +" for "+ damageHero +", HP left "+ (hp - damageHero));
               System.out.println("Result: The battle continues");  }
         
            System.out.println("XP: "+ tag + " "+ hit);
            }
         
         
      }
         
   }
}