public class Monster {
   private int healthPool; // this will be used to store the monsters hitpoints
   private int difficulty; // this will be used to store the monsters Level
   private boolean vitals; // this will be used to store rather or not the monster is alive


   public Monster(int HP, int LV, boolean alive) {
      healthPool = HP;
      difficulty = LV;
      vitals = alive;
   }
   
   public int monsterAttck() {
      int baseDMG = (int)(Math.random() * 5);
      int modifier = difficulty;
      return (baseDMG * modifier);
   }
   
   public void MTakeDMG(int damage) {
      if (healthPool < damage) {
         vitals = false;
      } else {
         healthPool -= damage;
      }
   }
   
   public boolean isMonsterDead() {
      return !vitals;
   }
   public int getMonsterHP() {
      return healthPool;
   }
}