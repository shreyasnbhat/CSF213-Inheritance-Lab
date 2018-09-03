public class Main {

    public static void main(String[] args) {

        Building building = new Building(1000,100);

        for (int i = 0; i < 5; i++) {
            Building.Floor f = building.new Floor(100);

            BedRoom bedRoom = new BedRoom(100, 100, 100, FloorType.WOODEN);
            Washroom washroom = new Washroom(100, 100, 100, FloorType.VINYL);
            LivingRoom livingRoom = new LivingRoom(100, 100, 100, FloorType.MARBLE);

            Bed bed = new Bed(2, 2, Material.STEEL);
            bedRoom.addBed(bed);

            livingRoom.watchTV();
            washroom.flush();
            bedRoom.sleep();

            f.addRoom(bedRoom);
            f.addRoom(livingRoom);
            f.addRoom(washroom);

            building.addFloor(f);

            System.out.println("Floor  " + building.getFloorCount());
            System.out.println("Floor Height " + f.getFloorHeight());
            System.out.println("Cost " + f.getCost());
            System.out.println("Oper Cost " + f.getOperatingCost());
        }


        System.out.println(building.getCost());
        System.out.println(building.getOperatingCosts());
        System.out.println(building.getSurfaceArea());
    }


}
