import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void test1() {
        StudentArrayDeque<Integer> testArray = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> stdArray = new ArrayDequeSolution<>();
        String message = "";
        for (int i = 0; i < 100; i++) {
            if (stdArray.isEmpty()) {
                double firstOrLast = StdRandom.uniform();
                int newNumber = StdRandom.uniform(1000);
                if (firstOrLast < 0.5) {
                    message = message + "addFirst(" + newNumber + ")\n";
                    stdArray.addFirst(newNumber);
                    testArray.addFirst(newNumber);
                } else {
                    message = message + "addLast(" + newNumber + ")\n";
                    stdArray.addLast(newNumber);
                    testArray.addLast(newNumber);
                }
            } else {
                int x = StdRandom.uniform(4);
                int addNumber = StdRandom.uniform(1000);
                Integer testRemoveNumber = 1;
                Integer stdRemoveNumber = 1;
                switch (x) {
                    case 0: {
                        message = message + "addFirst(" + addNumber + ")\n";
                        testArray.addFirst(addNumber);
                        stdArray.addFirst(addNumber);
                        break;
                    }
                    case 1: {
                        message = message + "addLast(" + addNumber + ")\n";
                        testArray.addLast(addNumber);
                        stdArray.addLast(addNumber);
                        break;
                    }
                    case 2: {
                        message = message + "removeFirst()\n";
                        testRemoveNumber = testArray.removeFirst();
                        stdRemoveNumber = stdArray.removeFirst();
                        break;
                    }
                    case 3: {
                        message = message + "removeLast()\n";
                        testRemoveNumber = testArray.removeLast();
                        stdRemoveNumber = stdArray.removeLast();
                        break;
                    }
                    default: {}
                }
                assertEquals(message, stdRemoveNumber, testRemoveNumber);
            }
        }
    }
}
