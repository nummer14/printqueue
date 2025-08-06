import java.util.concurrent.Semaphore;

public class PrintQueue {
    private final Semaphore semaphore = new Semaphore(2);

    public void printJob(String user) {
        try {
            semaphore.acquire();
            System.out.println(user + "프린트 시작");
            Thread.sleep(3000);
            System.out.println(user + "프린트 완료");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}