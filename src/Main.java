public class Main {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("Thread-1: lockA 획득");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                System.out.println("Thread-1: lockB 대기 중...");
                synchronized (lockB) {
                    System.out.println("Thread-1: lockB 획득");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lockB) {
                System.out.println("Thread-2: lockB 획득");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                System.out.println("Thread-2: lockA 대기 중...");
                synchronized (lockA) {
                    System.out.println("Thread-2: lockA 획득");
                }
            }
        });

        t1.start();
        t2.start();
    }
}