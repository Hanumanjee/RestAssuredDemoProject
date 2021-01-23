package shivam.chapter11.pojomedical;

public class GetMedical {
    private Medications medications;
    private Labs labs;
    private Imaging imaging;

    public Medications getMedications() {
        return medications;
    }

    public void setMedications(Medications medications) {
        this.medications = medications;
    }

    public Labs getLabs() {
        return labs;
    }

    public void setLabs(Labs labs) {
        this.labs = labs;
    }

    public Imaging getImaging() {
        return imaging;
    }

    public void setImaging(Imaging imaging) {
        this.imaging = imaging;
    }
}
