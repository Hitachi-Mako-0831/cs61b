public class OffByN implements CharacterComparator {
    public int Num;

    public OffByN(int N) {
        Num = N;
    }

    public boolean equalChars(char x, char y) {
        return (x - y == Num || y - x == Num);
    }
}
