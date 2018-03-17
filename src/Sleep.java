
public class Sleep {
    public static void Sleep(int time) {
        try {

            //sleep 5 seconds
            Thread.sleep(time);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
