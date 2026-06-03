public class Player {
   private int healthPool; // this will be used to  store the players hitpoints
   private int empathy; // this will be used to store the players Level
   private boolean vitals; // this will be used to store rather or not the player is alive
   
   public Player(int HP, int love, boolean alive) {
      healthPool = HP;
      empathy = love;
      vitals = alive;
   }
   
   public int getHP() {
      return healthPool;
   }
   
   public void takeDMG(int damage) {
      if (healthPool < damage) {
         vitals = false;
      } else {
         healthPool -= damage;
      }
   }
   
   public boolean isDead() {
      return !vitals;
   }
   
   
   public void LVChange(int love) {
      empathy += love;
   }
   
   public int getLV() {
      return empathy;
   }
   
   public int attackDMG() {
      int baseDMG = (int)(Math.random() * 10);
      int modifier = (empathy / 5);
      if (modifier <= 0) {
         modifier = 1;
      }
      return (baseDMG * modifier);
   }
   
   public void gainHP (int heal) {
      healthPool += heal;
   }
   
}