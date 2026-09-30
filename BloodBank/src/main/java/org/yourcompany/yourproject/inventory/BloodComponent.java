package org.yourcompany.yourproject.inventory;

public enum BloodComponent{
    WHOLE_BLOOD(35), 
    PRBC(42),
    PLATELETS(5),
    FPP(365);

    private int ShelfLifeDays;
    BloodComponent(int ShelfLifeDays) {
        this.ShelfLifeDays = ShelfLifeDays;
    }

    public int getShelfLife(){
        return ShelfLifeDays;
    }
   
}