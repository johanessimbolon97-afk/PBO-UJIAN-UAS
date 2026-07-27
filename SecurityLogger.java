import java.util.ArrayList;

public class SecurityLogger {

    private static SecurityLogger instance;

    private ArrayList<String> logs;

    // [UAS] - Bukti Pemahaman
    // Constructor private agar hanya ada satu Logger
    private SecurityLogger() {
        logs = new ArrayList<>();
    }

    public static synchronized SecurityLogger getInstance() {

        if (instance == null) {
            instance = new SecurityLogger();
        }

        return instance;
    }

    public synchronized void catatLog(String aksi) {

        logs.add(aksi);

        System.out.println("[LOG] " + aksi);

    }

    public ArrayList<String> getLogs() {
        return logs;
    }

}