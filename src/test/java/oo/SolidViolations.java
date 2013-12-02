package oo;

import static com.google.common.collect.Sets.newHashSet;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

public class SolidViolations {

    @Test
    public void singleResponsibility() throws Exception {
        NumberFormat nf = NumberFormat.getInstance(new Locale("lt", "LT"));
        nf.setCurrency(Currency.getInstance("LTL"));
        nf.setRoundingMode(RoundingMode.HALF_UP);

        String s = nf.format(123.45);
        Number n = nf.parse("123,45");
        Object o = nf.parseObject("123,45"); // inherited from Format (also in DateFormat, ChoiceFormat, etc.)
    }

    @Test
    public void openClosed() {
        Calendar.getInstance(); // see createCalendar() method
    }

    @Test
    public void liskovSubstitution() {
        Set<String> set = newHashSet("Anakin", "Darth Maul", "Jar-Jar", "Obi-Wan", "Yoda");
        // set = Collections.unmodifiableSet(set);
        System.out.println(withoutAnnoyingCharacters(set));
    }

    private Set<String> withoutAnnoyingCharacters(Set<String> set) {
        set.remove("Anakin");
        set.remove("Jar-Jar");
        return set;
    }

    @Test
    public void interfaceSegregation() {
        Map<String, String> map = new HashMap<String, String>();
        
        // reader's interface
        map.get("key");
        map.size();
        map.entrySet();
        map.keySet();
        map.values();

        // writer's interface
        map.put("key", "value");
        map.remove("key");

        // reader's utility interface (implemented in AbstractMap)
        map.isEmpty();
        map.containsKey("key");
        map.containsValue("value");

        // writer's utility interface (implemented in AbstractMap)
        map.putAll(ImmutableMap.of("key2", "value2", "key3", "value3"));
        map.clear();
    }

    @Test
    public void dependencyInversion() {
        new Date(1999, 11, 31, 23, 59, 59); // see getCalendarSystem(int year)
    }
}
