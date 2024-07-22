import java.util.Random;

public class DownloadThread extends Thread{

    int id;
    DownloadThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        Random r = new Random();
        int n = r.nextInt(10);
        super.run();
        System.out.println("Fazendo download "+this.id);
        try {
            Thread.sleep(n*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("download concluído "+this.id);
    }
}
