public class driver {
    public static void main(String[] args) {
        // Start the ServerRouter
        Thread routerThread = new Thread(() -> {
            try {
                TCPServerRouter.main(new String[]{});
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        routerThread.start();

        // Wait for the router to initialize
        try {
            Thread.sleep(2000); // Adjust the sleep time as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Start the Server
        Thread serverThread = new Thread(() -> {
            try {
                TCPServer.main(new String[]{});
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        serverThread.start();

        // Wait for the server to initialize
        try {
            Thread.sleep(2000); // Adjust the sleep time as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Start the Client
        Thread clientThread = new Thread(() -> {
            try {
                TCPClient.main(new String[]{});
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        clientThread.start();
    }
}