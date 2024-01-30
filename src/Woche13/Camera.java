package Woche13;

public class Camera {
    static int countCamera = 0;
    private String brand;
    private int megaPixels;
    private int displaySize;
    private boolean colored;

    Lens lens;


    //konstruktor
    public Camera(String brand, int megPix, int disSiz, boolean colored) {
        this.brand = brand;
        this.megaPixels = megPix;
        this.displaySize = disSiz;
        this.colored = colored;
        countCamera++;
    }
    //konstruktor
    public Camera(String brand, int megaPixel, int displaySize, boolean colored, Lens newlens) {
        this.brand = brand;
        this.megaPixels = megaPixel;
        this.displaySize = displaySize;
        this.colored = colored;
        this.lens = newlens;
        countCamera++;
    }

    //start setters
    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setMegaPixels(int megaPixels){
        this.megaPixels = megaPixels;
    }
    public void setDisplaySize(int displaySize){
        this.displaySize = displaySize;
    }
    public void setColored(boolean colored){
        this.colored = colored;
    }
    public void setLens(Lens lens){ this.lens = lens;}
    //end setters


    //start getters
    public String getBrand(){
        return this.brand;
    }
    public int getMegaPixels(){
        return this.megaPixels;
    }
    public int getDisplaySize(){
        return this.displaySize;
    }
    public boolean getColored(){
        return this.colored;
    }
    //end getters

    // start überschreiben der toString methode
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Marke: ");
        sb.append(this.brand).append(" | ");
        sb.append("Auflösung: ");
        sb.append(this.megaPixels).append( " | ");
        sb.append("Displaygröße: ");
        sb.append(this.displaySize).append(" | ");
        sb.append("Farbephoto: ");
        sb.append(this.colored).append(" | ");
        sb.append(this.lens);
        //sb.append("Lensdetails:");
        //sb.append(this.lens.minFocalWidth);
        //sb.append(this.lens.maxFocalWidth);



        return sb.toString();
    }
    // end überschreiben der toString methode
}
