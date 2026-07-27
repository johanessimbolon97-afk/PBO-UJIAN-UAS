public class Target {

    private int id;
    private String namaTarget;
    private int hargaBounty;

    public Target() {

    }

    public Target(String namaTarget, int hargaBounty) {
        this.namaTarget = namaTarget;
        this.hargaBounty = hargaBounty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaTarget() {
        return namaTarget;
    }

    public void setNamaTarget(String namaTarget) {
        this.namaTarget = namaTarget;
    }

    public int getHargaBounty() {
        return hargaBounty;
    }

    public void setHargaBounty(int hargaBounty) {
        this.hargaBounty = hargaBounty;
    }

}