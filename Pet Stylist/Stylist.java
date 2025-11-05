public class Stylist {
    public boolean busy;
    public int remainingTime;
    public Stylist next;

    public Stylist() {
        busy = false;
        remainingTime = 0;
        next = null;
    }

    public void assign(Pet pet) {
        busy = true;
        remainingTime = pet.careTime;
    }

    public void workOneMinute() {
        if (busy) {
            remainingTime--;
            if (remainingTime <= 0) {
                busy = false;
            }
        }
    }

    public boolean isFree() {
        return !busy;
    }
}
