import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.CopyOnWriteArrayList;



public class Main {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(100);
        Scanner scanner = new Scanner(System.in);
        List<Integer> openPorts = new CopyOnWriteArrayList<>();


        System.out.println("Enter IP/hostname");
        String Host = scanner.nextLine();

        System.out.println("Enter start port");
        int s = scanner.nextInt();

        System.out.println("Enter end port");
        int f = scanner.nextInt();


        for(int port = s; port <= f; port++){
            int finalPort = port;
            executor.submit(() -> {
                try{
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(Host, finalPort), 200);
                    openPorts.add(finalPort);
                    socket.close();
                } catch (IOException e) {
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(1 , java.util.concurrent.TimeUnit.MINUTES);
        System.out.println("Open ports: " + openPorts);
            }

        }
