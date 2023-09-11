package model;

public class InHousePart extends Part {

    private int machineID;

    public InHousePart(int partID, String name, int stock, int min, int max, double price, int machineID) {


        super(partID, name, stock, min, max, price);

        this.setMachineID(machineID);

    }


    public void setMachineID(int machineID) {

        this.machineID = machineID;

    }


    public int getMachineID() {

        return this.machineID;

    }


}
