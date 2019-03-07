import org.junit.jupiter.api.Assertions;

class InfiniteTest {

    @org.junit.jupiter.api.Test
    void add() {
        Infinite a = new Infinite("999999999999999");
        Infinite b = new Infinite("1");
        Assertions.assertEquals(a.add(b).toString(),"1000000000000000");
    }
    @org.junit.jupiter.api.Test
    void sub() {
        Infinite a = new Infinite("1000000000000000");
        Infinite b = new Infinite("999999999999999");
        Assertions.assertEquals(a.sub(b).toString(),"1");
    }
    @org.junit.jupiter.api.Test
    void mul() {
        Infinite a = new Infinite("99999999999999999999999999999");
        Infinite b = new Infinite("99999999999999999999999999999");
        Assertions.assertEquals(a.mul(b).toString(),"9999999999999999999999999999800000000000000000000000000001");
    }
    @org.junit.jupiter.api.Test
    void div() {
        Infinite a = new Infinite("99999999999999999999999999999");
        Infinite b = new Infinite("9999999");
        Assertions.assertEquals(a.div(b).toString(),"10000001000000100000010");
    }
    @org.junit.jupiter.api.Test
    void rem() {
        Infinite a = new Infinite("123");
        Infinite b = new Infinite("122");
        Assertions.assertEquals(a.sub(a.div(b).mul(b)).toString(),"1");
    }
}