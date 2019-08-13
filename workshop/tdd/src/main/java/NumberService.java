public class NumberService {

    private MyRandom random;

    public void setRandom(MyRandom random) {
        this.random = random;
    }

    public int generate() {
        return random.nextInt(10);
    }

}
