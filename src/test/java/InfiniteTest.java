import org.junit.jupiter.api.*;

class InfiniteTest {

    @Test
    void add() {
        Infinite a = new Infinite("999999999999999");
        Infinite b = new Infinite("1");
        Assertions.assertEquals(a.add(b).toString(), "1000000000000000");
        Infinite c = new Infinite("999999999999999");
        Infinite d = new Infinite("999999999999999");
        Assertions.assertEquals(c.add(d).toString(), "1999999999999998");
        Infinite e = new Infinite("0");
        Infinite f = new Infinite("0");
        Assertions.assertEquals(e.add(f).toString(), "0");
    }

    @Test
    void sub() {
        Infinite a = new Infinite("1000000000000000");
        Infinite b = new Infinite("999999999999999");
        Assertions.assertEquals(a.sub(b).toString(), "1");
        Infinite c = new Infinite("999999999999999");
        Infinite d = new Infinite("999999999999999");
        Assertions.assertEquals(c.sub(d).toString(), "0");
        Infinite e = new Infinite("23");
        Infinite f = new Infinite("11");
        Assertions.assertEquals(e.sub(f).toString(), "12");
        Infinite q = new Infinite("999999999999999");
        Infinite t = new Infinite("9999999999999999");
        Assertions.assertEquals(q.sub(t).toString(), "9000000000000000");
    }

    @Test
    void mul() {
        Infinite a = new Infinite("99999999999999999999999999999");
        Infinite b = new Infinite("99999999999999999999999999999");
        Assertions.assertEquals(a.mul(b).toString(), "9999999999999999999999999999800000000000000000000000000001");
        Infinite c = new Infinite("0");
        Infinite d = new Infinite("99999999999999999999999999999");
        Assertions.assertEquals(c.mul(d).toString(), "0");
        Infinite e = new Infinite("99999999999999999999999999999");
        Infinite f = new Infinite("3");
        Assertions.assertEquals(e.mul(f).toString(), "299999999999999999999999999997");
    }

    @Test
    void div() {
        Infinite a = new Infinite("99999999999999999999999999999");
        Infinite b = new Infinite("9999999");
        Assertions.assertEquals(a.div(b).toString(), "10000001000000100000010");
        Infinite c = new Infinite("999999999");
        Infinite d = new Infinite("999999999");
        Assertions.assertEquals(c.div(d).toString(), "1");
        Infinite e = new Infinite("23");
        Infinite f = new Infinite("15");
        Assertions.assertEquals(e.div(f).toString(), "1");
    }



    @Test
    void equals() {
        Infinite a = new Infinite("999999999");
        Infinite b = new Infinite("999999999");
        Assertions.assertTrue(a.equals(b));
        Infinite c = new Infinite("99999999");
        Infinite d = new Infinite("999999999");
        Assertions.assertFalse(c.equals(d));
    }
}

