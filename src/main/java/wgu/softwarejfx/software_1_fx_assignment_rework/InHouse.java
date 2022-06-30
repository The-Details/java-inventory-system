package wgu.softwarejfx.software_1_fx_assignment_rework;

/**
 * FUTURE ENHANCEMENT: Adding more granularity to the class, allowing it to process more things
 */
public class InHouse extends Part{

    private int machineId;

    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
    }
    public void setMachineId(int machineId){
        this.machineId = machineId;
    }
    public int getMachineId(){
        return machineId;
    }
}

