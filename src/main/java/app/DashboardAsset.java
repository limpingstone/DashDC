public abstract class DashboardAsset{
    private int[] position = new int[2];
    private int[] size = new int[2];
    //private Style style;

    public void setPosition(int[] position) {
        this.position = position;
    }

    public int[] getPosition(){
        return this.position;
    }

    public void setSize(int[] size){
        this.size = size;
    }

    public int[] getSize(){
        return this.size;
    }

    /*
    public Style setStyle(Style style){
        this.Style = style;
    }

    public Style getStyle(){
        return this.style;
    }
    */

    abstract String display();
}