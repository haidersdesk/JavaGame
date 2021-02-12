package GameText;


public class Player {
    Inventory inventory;
    public int hp;
    private GameObject currentWeapon;

   public String getCurrentWeapon(){
      return  inventory.showName();
   }

   public int getCurrentWeaponDamage(){
       return inventory.showDamage();
   }




}
