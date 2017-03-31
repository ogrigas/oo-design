package oo;

import static org.mockito.Mockito.mock;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentMap;

import com.google.common.collect.MapMaker;
import com.google.common.collect.Range;
import org.junit.Test;

public class DesignPatternsTest {

    @Test
    public void abstractFactory() throws SQLException {
        Driver driver = mock(Driver.class);
        Connection conn = driver.connect("jdbc:url", null);
    }

    @Test
    public void factoryMethod_forPolymorphism() {
        Calendar calendar = Calendar.getInstance(new Locale("th", "TH"));
        System.out.println(calendar.getClass());
    }

    @Test
    public void factoryMethod_forReadability() {
        Range a = Range.closed(1, 9);
        Range b = Range.open(0, 10);
        Range c = Range.atLeast(1);
        Range d = Range.lessThan(10);
        Range e = Range.all();
    }

    @Test
    public void flyweight() {
        Currency currency = Currency.getInstance("LTL");
    }

    @Test
    public void builder() {
        ConcurrentMap<Object, Object> map =
            new MapMaker()
                .initialCapacity(10)
                .concurrencyLevel(3)
                .weakKeys()
                .weakValues()
                .makeMap();
    }

    @Test
    public void adapter() throws IOException {
        InputStream stream = new ByteArrayInputStream(new byte[] {0, 0, 0, 0});
        Reader reader = new InputStreamReader(stream);
        reader.read();
    }

    @Test
    public void decorator() throws IOException {
        Reader original = new StringReader("abcdefghij....");
        Reader buffered = new BufferedReader(original, 1024);
        buffered.read();
    }

    @Test
    public void facade() throws Exception {
        Class c = DesignPatternsTest.class;
        c.getResource("name");  // delegates to ClassLoader
        c.getTypeParameters();  // delegates to ClassRepository
    }

    /**
     * AKA. functional interface.
     * Better than Template Method.
     * Better than Observer.
     */
    @Test
    public void strategy() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        };

        List<Integer> list = Arrays.asList(4, 2, 3, 5, 1);
        Collections.sort(list, comparator);
        System.out.println(list);
    }
}
