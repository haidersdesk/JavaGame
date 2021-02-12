import java.util.Arrays;

public class Inventory {
    private GameObject[] list;


    public Inventory(int size){
        list = new GameObject[size];
    }
    //inv
    public void addObject(GameObject go){
        int index = getFirstEmptyIndex();

        if (index ==-1){
            //index++;
        }
        this.list[index] = go;

    }

    public void removeObject(GameObject go) {
        int index=getFirstEmptyIndex();
        this.list[index] = null;

    }


    public String toString() {
        return Arrays.toString(this.list);
    }

    private int getFirstEmptyIndex(){

        for (int i = 0; i<this.list.length; i++){
            if (this.list[i] == null){
                return i;
            }
        }
        return 0;
    }

    public void moveObject(Inventory inv, GameObject go) {

        inv.addObject(go);

    }



}