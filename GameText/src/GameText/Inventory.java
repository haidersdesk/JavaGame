package GameText;

import java.util.Arrays;


public class Inventory {
    private GameObject[] gameObjects;


    public Inventory(int size){
        gameObjects = new GameObject[size];
    }

    public void addObject(GameObject go){
        int index = getFirstEmptyIndex();

        if (index ==-1){

        }
        this.gameObjects[index] = go;

    }

    public void removeObject(GameObject go) {
        int index=getFirstEmptyIndex();
        this.gameObjects[index] = null;

    }


    public String showName() {
       return Arrays.toString(Arrays.stream(gameObjects)
               .map(x -> x.name)
               .toArray());


    }

    public int showDamage(){

        return Arrays.stream(gameObjects)
                             .mapToInt(x->x.damage)
                             .sum();
    }




    private int getFirstEmptyIndex(){

        for (int i = 0; i<this.gameObjects.length; i++){
            if (this.gameObjects[i] == null){
                return i;
            }
        }
        return 0;
    }



}