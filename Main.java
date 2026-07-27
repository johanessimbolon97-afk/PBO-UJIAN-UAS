public class Main {
    public static void main(String[] args) {

        SecurityLogger logger = SecurityLogger.getInstance();
        logger.catatLog("Program dimulai");

        Target target = new Target();
        target.setNamaTarget("Naruto");
        target.setHargaBounty(5000000);

        TargetDAO dao = new TargetDAO();
        dao.simpanTarget(target);

        logger.catatLog("Data berhasil disimpan");

        System.out.println("Selesai");
    }
}