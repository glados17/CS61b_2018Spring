
public class OffByN implements CharacterComparator {

    private int offsetN;

    public OffByN(int N){
        offsetN = N;
    }

    @Override
    public boolean equalChars(char x, char y){
        return x - y == offsetN || y - x == offsetN;
    }
}
