import java.util.Arrays;

public class Inventory {
    private GameObject[] list;


    public Inventory(int size, Gui g){
        list = new GameObject[size];
    }

    public GameObject returnGameObject(String objectName){
        for (GameObject g : list){
            if(g.getName().equals(objectName)){
                return g;
            }
        }
        return null;
    }



    //inv
    public boolean addObject(GameObject go){
        int index = getFirstEmptyIndex();

        if (index ==-1){
            System.out.println("No more space");
            return false;
        }
        this.list[index] = go;
        return true;

    }


    public void removeObject(GameObject go) {
        for (int index = 0; index < list.length; index++) {
            if (this.list[index] != null && this.list[index].equals(go)) {
                this.list[index] = null;
                return;
            }
        }

    }


    public String toString() {
        return Arrays.toString(this.list);
    }

    public boolean contains(String objectName) {
        for (GameObject go : this.list) {
            if (go != null) {

                if (go.getName().equals(objectName)) {
                    return true;
                }
            }

        }
        return false;
    }

    int getFirstEmptyIndex(){

        for (int i = 0; i<this.list.length; i++){
            if (this.list[i] == null ){
                return i;
            }
        }
        return -1;
    }

    public GameObject getFirstObject() {
        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i] != null && this.list[i].isMoveable()) {
                return this.list[i];
            }
        }
        return null;
    }


    public void moveObject(Inventory inv, GameObject go) {

        inv.addObject(go);

    }



}