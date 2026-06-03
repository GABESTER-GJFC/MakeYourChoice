import java.util.Scanner;
import java.util.Arrays;
public class MakeYourChoice {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      boolean hasRaccoon = false;
      System.out.println("This is a little TRPG (text roleplaying game) called Make your choice");
      System.out.println("the controls are quite simple");
      System.out.println("simply just type in words or letters that decide what you will do");
      System.out.println("FYI, you dont need to worry about cases, but you will need to spell it correctly");
      System.out.println("all choices will be in this format: <A> choiceA | <B> choiceB | <C> choiceC");
      System.out.println("");
      System.out.println("now, State your name little one");
      String name = scanner.nextLine();
      boolean namePicking = true;
      int pickingCount = 0;
      boolean gameOn = true;
      while (namePicking) {
         if (name.equalsIgnoreCase("Gabster") || name.equalsIgnoreCase("Raccoon") || name.equalsIgnoreCase("Gabriel")) {
            System.out.println("That is not your name");
            System.out.println("state name");
            name = scanner.nextLine();
            pickingCount++;
            if (pickingCount >= 2) {
               System.out.println("lies, lies, and more lies. This path is not for the likes of you...");
               System.exit(0);
            }
         } else {
            namePicking = false;
         }
      }
      Player player = new Player(30, 5, true);
      System.out.println("");
      System.out.println("Start Adventure?");
      System.out.println("");
      System.out.println("<A> yes");
      if (scanner.nextLine().equalsIgnoreCase("A")) {
         System.out.println("");
         System.out.println("");
         System.out.println(name + " wake's up and finds themselve laying atop of a bunch of now crushed cardbored boxes");
         System.out.println("");
         System.out.println("what dose " + name + " do?");
         System.out.println("");
         System.out.println("<A> Look around | <B> nothing");
         String AB = scanner.nextLine();
         if (AB.equalsIgnoreCase("A")) {
            System.out.println(name + " looked around to see a sign");
            System.out.println("");            
         } else if (AB.equalsIgnoreCase("B")) {
            System.out.println(""); 
            System.out.println(name + " lays there, doing nothing. they think about everything they have done to get them into this");
            System.out.println("");
            System.out.println("suddenly, A sign out of no where fall on thier face");
            System.out.println(name + " is hurt by this");
            player.takeDMG(1);
         }
         System.out.println("Dose " + name + " wish to read the sign?");
         System.out.println("<A> Read sign | <B> Start exploring");
         if (scanner.nextLine().equalsIgnoreCase("a")) {
            System.out.println("on the sign writes:");
            System.out.println("\"Love and hate are sides of the same coin\"");
         } else {
            System.out.println(name + " ignores the sign");
         }
         System.out.println("");
         System.out.println(name + " starts to explore");
         System.out.println("After some time, " + name + " stumbles across a punching bag");
         System.out.println("what dose " + name + " do?");
         System.out.println("");
         System.out.println("<A> punch it | <B> nothing | <C> hug it");
         boolean punchingBag = true;
         int punchCount = 0;
         boolean bagFight = false;
         while (punchingBag) {
           String playerInput =  scanner.nextLine();
           if (playerInput.equalsIgnoreCase("a"))
            {
               System.out.println("");
               System.out.println(name + " punches the punching bag");
               System.out.println(name + " gets the feeling that the punching bag didn't like that");
               System.out.println("");
               System.out.println("<A> punch it  (repeatble) | <B> nothing (move on) | <C> hug it (move on)");
               punchCount++;
            }
            if (playerInput.equalsIgnoreCase("b")) {
               System.out.println(name + " does nothing and continues along the path");
               punchingBag = false;
            }
            if (playerInput.equalsIgnoreCase("c")) {
               System.out.println(name + " hugs the punching bag, "  + name + " feels a warmth in thier heart");
               punchingBag = false;
               player.LVChange(-10);
            }
            if (punchCount >= (int)(Math.random() * 5)) {
               System.out.println("The punching bag was angered at the repeated assult");
               System.out.println(name + " and the punching bag enter combat");
               punchingBag = false;
               bagFight = true;
            }
         }
         if (bagFight) {
            Monster bagMonster = new Monster(5, 1, true);
            while (bagFight)
            {
               System.out.println("");
               System.out.println("the bag monster swings at " + name);
               player.takeDMG(bagMonster.monsterAttck());
               System.out.println(name + " has " + player.getHP() + " hit points left");
               System.out.println("");
               System.out.println("what dose name " + name + " do?");
               System.out.println("<A> attack | <B> run away | <C> talk it out");
               String tempInput1 = scanner.nextLine();
              
               if (tempInput1.equalsIgnoreCase("A")) {
                  int tempDMG1 = player.attackDMG();
                  System.out.println("");
                  System.out.println(name + " attacks the bag monster, dealing " + tempDMG1);
                  bagMonster.MTakeDMG(tempDMG1);
                  System.out.println("bag monster has : " + bagMonster.getMonsterHP() + " hit points left");
               } 
               if (tempInput1.equalsIgnoreCase("B")) {
                  System.out.println("");
                  System.out.println(name + " tries to runs away");
                  int bagOdds = (int)(Math.random() * 10);
                  if (bagOdds < 3) {
                     System.out.println("");
                     System.out.println(name + " is stopped before they can get far");
                     player.takeDMG(bagMonster.monsterAttck());
                     System.out.println(name + " has " + player.getHP() + " hit points left");
                  } else {
                     System.out.println("");
                     System.out.println(name + " gets away");
                     System.out.println(name + " continues on their adventure");
                     bagFight = false;
                  }
               }
               if (tempInput1.equalsIgnoreCase("C")) {
                  System.out.println("");
                  System.out.println(name + " tries to talk it out");
                  int bagOdds = (int)(Math.random() * 10);
                  if (bagOdds < 5) {  
                     System.out.println("");
                     System.out.println("the bagMonster dosen't listen and attacks " + name);
                     player.takeDMG(bagMonster.monsterAttck());
                     System.out.println(name + " has " + player.getHP() + " hit points left");
                  } else {
                     System.out.println("");
                     System.out.println(name + " and the bag Monster talk it out");
                     System.out.println("the bag monster is no longer angry");
                     bagFight = false;
                     System.out.println("");
                     System.out.println("after the encouter with the bagMonster");
                     System.out.println(name + " feels better about themselves");
                     System.out.println(name + " continues on their adventure");
                     player.LVChange(-5);
                  }
               }
               if (player.isDead()) {
                  bagFight = false;
                  System.out.println(name + " tried and failed to defeat the bag monster");
                  System.out.println(name + " is no longer able to contine on this path and passes out.");
                  System.out.println("Game Over");
                  System.out.println("Thx for playing");
                  System.exit(0);
               }
               if (bagMonster.isMonsterDead()) {
                  bagFight = false;
                  player.LVChange(10);
                  System.out.println(name + " killed the bag monster");
                  System.out.println(name + " hatred for the monsters grow.");
                  System.out.println(name + " heals for 20 hit points");
                  player.gainHP(20);
               }
            }
         }
      System.out.println("");
      System.out.println("after some time of exploration");
      System.out.println(name + " finds a chest");
      System.out.println("next to the chest was a sign");
      System.out.println("on the sign it said:");
      System.out.println("this chest has a 30 % chance of a healing item, a 20 % chance of it being empty");
      System.out.println("and a 50 % chance of being a mimic");
      System.out.println("");
      System.out.println("dose " + name + " open the chest?");
      System.out.println("<A> open chest || <B> leave it");
      boolean chest = true;
      boolean chestFight = false;
      while (chest) {
         String input = scanner.nextLine();
         if (input.equalsIgnoreCase("A")) {
            int chestChance = (int)(Math.random() * 10);
            if (chestChance <= 2) {
               System.out.println("the chest was empty");
               chest = false;
            } else if (chestChance <= 5) {
               System.out.println("the chest had a healing item");
               System.out.println("the healing item gives them  10 hit points");
               player.gainHP(10);
               chest = false;
            } else {
               System.out.println("unlucky for " + name + " the chest was a mimic!");
               System.out.println("and they don't seem too happy");
               chestFight = true;
               chest = false;
               System.out.println("A brwal begins");
            }
         } else if (input.equalsIgnoreCase("B")) {
            System.out.println(name + " leave the chest un-opened, not wanting to risk it being a mimic");
            chest = false;
         } else {
            System.out.println("i do not understand, could you try again?");
         }
      }
      Monster chestMimic = new Monster(10, 2, true);
      while (chestFight) {
         System.out.println("the Mimic attacks");
         player.takeDMG(chestMimic.monsterAttck());
         System.out.println(name + " has " + player.getHP() + " hit poins left");
         System.out.println("what dose " + name + " do?");
         System.out.println("<A> attack | <B> run away | <C> talk it out");
         String tempInput2 = scanner.nextLine();
         if (tempInput2.equalsIgnoreCase("A")) {
            int tempDMG2 = player.attackDMG();
            System.out.println("");
            System.out.println(name + " attacks the chest mimic, dealing " + tempDMG2);
            chestMimic.MTakeDMG(tempDMG2);
            System.out.println("chest mimic has : " + chestMimic.getMonsterHP() + " hit points left");
         } 
         if (tempInput2.equalsIgnoreCase("B")) {
            System.out.println("");
            System.out.println(name + " tries to runs away");
            int bagOdds = (int)(Math.random() * 10);
            if (bagOdds < 3) {
               System.out.println("");
               System.out.println(name + " is stopped before they can get far");
               player.takeDMG(chestMimic.monsterAttck());
               System.out.println(name + " has " + player.getHP() + " hit points left");
            } else {
               System.out.println("");
               System.out.println(name + " gets away");
               System.out.println(name + " continues on their adventure");
               chestFight = false;
            }
         }
         if (tempInput2.equalsIgnoreCase("C")) {
            System.out.println("");
            System.out.println(name + " tries to talk it out");
            int bagOdds = (int)(Math.random() * 10);
            if (bagOdds < 5) {  
               System.out.println("");
               System.out.println("the chest mimic dosen't listen and attacks " + name);
               player.takeDMG(chestMimic.monsterAttck());
               System.out.println(name + " has " + player.getHP() + " hit points left");
            } else {
               System.out.println("");
               System.out.println(name + " and the chest mimic talk it out");
               System.out.println("the chest mimic is no longer angry");
               chestFight = false;
               System.out.println("");
               System.out.println("after the encouter with the chest mimic");
               System.out.println(name + " feels better about themselves");
               System.out.println(name + " continues on their adventure");
               player.LVChange(-5);
            }
         }
         if (player.isDead()) {
         bagFight = false;
         System.out.println(name + " tried and failed to defeat the chest Mimic");
         System.out.println(name + " is no longer able to contine on this path and passes out.");
         System.out.println("Game Over");
         System.out.println("Thx for playing");
         System.exit(0);
         }
         if (chestMimic.isMonsterDead()) {
            chestFight = false;
            player.LVChange(15);
            System.out.println(name + " murded the chest mimic");
            System.out.println(name + " hatred for the monsters grow.");
            System.out.println(name + " heals for 20 hit points");
            player.gainHP(20);
         }
      }
      System.out.println("");
      System.out.println(name + " travles once again. exploring the area");
      System.out.println("the path a head splits");
      System.out.println("to the right, a dark ally way with a sign that says:");
      System.out.println("\"ToTallY NoT DangerOuS ShORt CuT\"");
      System.out.println("on the left is path to a village, with a sign that says");
      System.out.println("To flurryVill");
      System.out.println("which way dose " + name + " go?");
      System.out.println("<A> Right | <B> Left");
      boolean leftRight = true;
      boolean shortCut = false;
      while (leftRight) {
         String input = scanner.nextLine();
         if (input.equalsIgnoreCase("A")) {
            System.out.println(name + " goes right, into the dark ally");
            System.out.println();
            shortCut = true;
            leftRight = false;
         } else if (input.equalsIgnoreCase("B")) {
            System.out.println(name + " goes left, into flurryVill");
            System.out.println();
            leftRight = false;
         } else {
            System.out.println("invalid input, try again");
         }
      }
      if (shortCut) {
         System.out.println("as " + name + " walks into the dark ally");
         System.out.println("their path behind them was blocked by fallen bolders!");
         System.out.println("just as that happens, a gang of monsters apears infront of them");
         System.out.println("and they don't look frendly");
         System.out.println("what dose " + name + " do?");
         System.out.println("<A> make a run for it | <B> fight them head on");
         boolean choice = true;
         boolean groupFight = false;
         while (choice) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("A")) {
               System.out.println(name + " makes a run for it");
               System.out.println("getting out of there before the group of monsters can react");
               System.out.println();
               choice = false;
            } else if (input.equalsIgnoreCase("B")) {
               System.out.println(name + " choose to fight them head on");
               System.out.println();
               choice = false;
               groupFight = true;
            } else {
            System.out.println("invalid input, try again");
            }
         }
         if (groupFight) {
            System.out.println(name + " is filled with hate");
            player.LVChange(10);
            int count = 1;
            while (groupFight) {
               Monster groupMonsters = new Monster((25 * count), 3, true);
               boolean fighting = true;
               while (fighting) {
                  System.out.println("one of the monsters attacks " + name);
                  player.takeDMG(groupMonsters.monsterAttck());
                  System.out.println(name + " has " + player.getHP() + " hit points left");
                  System.out.println("what dose " + name + " do?");
                  System.out.println("<A> runaway | <B> attck");
                  boolean choice2 = true;
                  while (choice2) {
                     String input = scanner.nextLine();
                     boolean combat = false;
                     if (input.equalsIgnoreCase("A")) {
                        System.out.println("you try to control " + name + " to run");
                        System.out.println();
                        choice2 = false;
                        if (player.getLV() > 20) {
                           System.out.println("but they refused");
                           System.out.println(name + " is blinded by their hatred");
                        } else {
                           System.out.println(name + " manages to get away");
                           fighting = false;
                           groupFight = false;
                        }
                     } else if (input.equalsIgnoreCase("B")) {
                        int tempDMG3 = player.attackDMG();
                        System.out.println(name + " attcks the monster, dealing " + tempDMG3);
                        groupMonsters.MTakeDMG(tempDMG3);
                        System.out.println();
                        choice2 = false;
                        if (groupMonsters.isMonsterDead()) {
                           player.LVChange(5);
                           System.out.println(name + " murded one of the monsters");
                           System.out.println(name + " hatred for the monsters grow.");
                           System.out.println(name + " heals for 25 hit points");
                           System.out.println();
                           player.gainHP(25);
                           count++;
                        }
                        if (count >= 5) {
                           System.out.println(name + " killed them all");
                           System.out.println("not leaving a soul alive");
                           System.out.println(name + " feels thier sins crawing on thier back...");
                           player.LVChange(40);
                           fighting = false;
                           groupFight = false;
                        }
                     } else {
                        System.out.println("invalid input, try again");
                     }
                  }
                  if (player.isDead()) {
                     System.out.println(name + " tried and failed to defeat the group of monsters");
                     System.out.println(name + " is no longer able to contine on this path and passes out.");
                     System.out.println("Game Over");
                     System.out.println("Thx for playing");
                     System.exit(0);
                  }
               }
            }
         }
         System.out.println(name + " makes it out the dark allyway");
         System.out.println("they find themselves infront of a gray door");
         System.out.println("there's no way back. only forward");
      } else {
         System.out.println("as " + name + " makes their way to flurryVill");
         System.out.println("they come across a raccoon");
         System.out.println("the raccoon stands on its hine legs, its paws out at you");
         System.out.println("it was obvouse that it was wanting something from " + name);
         System.out.println("what dose " + name + " give it?");
         System.out.println("<A> a cookie | <B> a hand shake | <C> nothing | <D> A kick");
         boolean choice = true;
         while (choice) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("A")) {
               System.out.println(name + " gives the raccoon a cookie");
               System.out.println("the raccoon is very happy at this");
               System.out.println("the raccoon climbs onto your shoulder");
               System.out.println("it seems that he is going to travel with you");
               hasRaccoon = true;
               System.out.println();
               choice = false;
            } else if (input.equalsIgnoreCase("B")) {
               System.out.println(name + " gives the raccoon a hand shake");
               System.out.println("the raccoon takes the hand shake before moving along");
               System.out.println();
               choice = false;
            } else if (input.equalsIgnoreCase("C")) {
               System.out.println(name + " dosen't do anything");
               System.out.println("after some time of waiting, the raccoon gose on its way");
               System.out.println();
               choice = false;
            } else if (input.equalsIgnoreCase("D")) {
               System.out.println(name + " kicks the Raccoon");
               System.out.println("the Raccoon gose flying, seemingly never to be seen again");
               System.out.println();
               choice = false;
            } else {
            System.out.println("invalid input, try again");
            }
         }
      }
      System.out.println("the demo is over, thx for playing :3");
      } else {
         System.out.println("congdulations. you ended the program.");
         System.out.println("HINT: yes");
         System.out.println("If you don't want to play the game... why did you open the program -_-");
      }
   }
}

/* for Qulity of life for the coder

boolean choice = true;
         while (choice) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("A")) {
               System.out.println("template");
               System.out.println();
               choice = false;
            } else if (input.equalsIgnoreCase("B")) {
               System.out.println("template");
               System.out.println();
               choice = false;
            } else {
            System.out.println("invalid input, try again");
            }



*/ 