import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
    ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();

    @Test
    public void testDeque(){
        int N = 10000;
        for (int i = 0; i <N; i++){
            Integer randomNum = StdRandom.uniform(10);
            if (randomNum < 5){
                student.addFirst(randomNum);
                solution.addFirst(randomNum);
            }
            else{
                student.addLast(randomNum);
                solution.addLast(randomNum);
            }
        }
        for (int i = 0; i <N; i++){
            Integer expected;
            Integer actual;
            double randomNum = StdRandom.uniform();
            if (randomNum <0.5) {
                expected = solution.removeLast();
                actual = student.removeLast();
                assertEquals("Oh noooo!\nThis is bad:\n   removeLast():", expected, actual);
            }
            else {
                expected = solution.removeFirst();
                actual = student.removeFirst();
            }
                assertEquals("Oh noooo!\nThis is bad:\n   removeFirst()", expected, actual);


        }

    }
}
