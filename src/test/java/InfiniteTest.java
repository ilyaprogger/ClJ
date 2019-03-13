import org.junit.jupiter.api.Assertions;

class InfiniteTest {

    @org.junit.jupiter.api.Test
    void add() {
        Infinite a = new Infinite("999999999999999");
        Infinite b = new Infinite("1");
        Assertions.assertEquals(a.add(b).toString(),"1000000000000000");
        Infinite c = new Infinite("999999999999999");
        Infinite d = new Infinite("999999999999999");
        Assertions.assertEquals(c.add(d).toString(),"1999999999999998");
        Infinite e = new Infinite("0");
        Infinite f = new Infinite("0");
        Assertions.assertEquals(e.add(f).toString(),"0");
    }
    @org.junit.jupiter.api.Test
    void sub() {
        Infinite a = new Infinite("1000000000000000");
        Infinite b = new Infinite("999999999999999");
        Assertions.assertEquals(a.sub(b).toString(),"1");
        Infinite c = new Infinite("999999999999999");
        Infinite d = new Infinite("999999999999999");
        Assertions.assertEquals(c.sub(d).toString(),"0");
        Infinite e = new Infinite("23");
        Infinite f = new Infinite("11");
        Assertions.assertEquals(e.sub(f).toString(),"12");
    }
    @org.junit.jupiter.api.Test
    void mul() {
        Infinite a = new Infinite("99999999999999999999999999999");
        Infinite b = new Infinite("99999999999999999999999999999");
        Assertions.assertEquals(a.mul(b).toString(),"9999999999999999999999999999800000000000000000000000000001");
        Infinite c = new Infinite("0");
        Infinite d = new Infinite("99999999999999999999999999999");
        Assertions.assertEquals(c.mul(d).toString(),"0");
        Infinite e = new Infinite("1");
        Infinite f = new Infinite("99999999999999999999999999999");
        Assertions.assertEquals(e.mul(f).toString(),"99999999999999999999999999999");
    }
    @org.junit.jupiter.api.Test
    void div() {
        Infinite a = new Infinite("99999999999999999999999999999");
        Infinite b = new Infinite("9999999");
        Assertions.assertEquals(a.div(b).toString(),"10000001000000100000010");
        Infinite c = new Infinite("999999999");
        Infinite d = new Infinite("999999999");
        Assertions.assertEquals(c.div(d).toString(),"1");
        Infinite e = new Infinite("23");
        Infinite f = new Infinite("15");
        Assertions.assertEquals(e.div(f).toString(),"1");
    }
    @org.junit.jupiter.api.Test
    void rem() {
        Infinite a = new Infinite("123");
        Infinite b = new Infinite("122");
        Assertions.assertEquals(a.sub(a.div(b).mul(b)).toString(),"1");
        Infinite c = new Infinite("123");
        Infinite d = new Infinite("24");
        Assertions.assertEquals(c.sub(c.div(d).mul(d)).toString(),"3");
        Infinite e = new Infinite("999999999");
        Infinite f = new Infinite("999999999");
        Assertions.assertEquals(e.sub(e.div(f).mul(f)).toString(),"0");
    }
}