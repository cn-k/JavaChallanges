import bcycle.Bcycle;
import bcycle.MountainBcycle;
import bcycle.RoadBike;

public class MainApp {
    public static void main(String[] args) {
        MountainBcycle mountainBcycle = new MountainBcycle();
        mountainBcycle.speedUp(10);
        var res = mountainBcycle.speedUp(10);

        RoadBike roadBike = new RoadBike();
        roadBike.speedDown(10);
        var roadBikeSpeed = roadBike.speedDown(10);
        System.out.println(res);
        System.out.println(roadBikeSpeed);
    }
}
