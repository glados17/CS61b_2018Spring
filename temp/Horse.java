public class Horse {
    Horse same;
    String jimmy;
    public Horse(String lee) {
        jimmy = lee;
    }

    public Horse same(Horse horse) {
            if (same != null) {
                Horse same1 = horse;
                // System.out.println(same.jimmy);
                same1.same = horse;
                // System.out.println(same.jimmy);
                same1 = horse.same;
                // System.out.println(same.jimmy);
                }
            // System.out.println(same.jimmy);
            return same.same;
        }
    public static void main(String[] args) {
        Horse horse = new Horse("youve been");
        Horse cult = new Horse("horsed");
        cult.same = cult;
        cult = cult.same(horse);
        System.out.println(cult.jimmy);
        System.out.println(horse.jimmy);
        }
}