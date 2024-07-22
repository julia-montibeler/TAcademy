public class Main {
    public static void main(String[] args) {
        DownloadThread dw1 = new DownloadThread(1);
        DownloadThread dw2 = new DownloadThread(2);
        DownloadThread dw3 = new DownloadThread(3);
        DownloadThread dw4 = new DownloadThread(4);

        dw1.start();
        dw2.start();
        dw3.start();
        dw4.start();
    }
}
