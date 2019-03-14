
import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.max;

public class Infinite {

    private List<Integer> number = new ArrayList<>();
    private String result;
    private final static int BASE = 1000000000;

    public Infinite(String number) {
        if (number.chars().allMatch(Character::isDigit)) {
            result = number;
            for (int i = number.length(); i > 0; i -= 9) {
                if (i < 9) {
                    this.number.add(Integer.parseInt(number.substring(0, i)));
                } else
                    this.number.add(Integer.parseInt(number.substring(i - 9, i)));
            }
        } else throw new NumberFormatException("Not number");
    }

    void formRes2(ArrayList<Integer> a, StringBuilder b) {
        while (a.size() > 1 && a.get(a.size() - 1) == 0)
            a.remove(a.size() - 1);
        b.append(a.isEmpty() ? "0" : a.get(a.size() - 1).toString());
        for (int i = a.size() - 2; i >= 0; --i) {
            b.append(String.format("%09d", a.get(i)));
        }
    }
    public Infinite add(Infinite other) {
        int counter = 0;
        StringBuilder result = new StringBuilder();
        List<Integer> n1 = this.number;
        List<Integer> n2 = other.number;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < max(n1.size(), n2.size()) || counter == 1; i++) {
            res.add(0);
            res.set(i,  n1.get(i) + counter + (i < n2.size() ? n2.get(i) : 0));
            if (res.get(i) >= BASE)
                counter = 1;
            else if (res.get(i) < BASE)
                counter = 0;
            if (counter == 1) res.set(i, res.get(i) - BASE);
        }
        formRes2(res, result);
        return new Infinite(result.toString());
    }

    public Infinite sub(Infinite other) {
        int counter = 0;
        StringBuilder result = new StringBuilder();
        List<Integer> n1 = this.number;
        List<Integer> n2 = other.number;
        ArrayList<Integer> res = new ArrayList<>();
        if (n1.size() < n2.size() || n1.get(n1.size() - 1) < n2.get(n2.size() - 1)) {
            n1 = other.number;
            n2 = this.number;
        }
        for (int i = 0; i < n2.size() || counter == 1; ++i) {
            res.add(0);
            res.set(i,  n1.get(i) - counter - (i < n2.size() ? n2.get(i) : 0)); //helper function
            if (res.get(i) < 0)
                counter = 1;
            else if (res.get(i) >= 0)
                counter = 0;
            if (counter == 1)
                res.set(i, res.get(i) + BASE);
        }
        formRes2(res, result);
        return new Infinite(result.toString());
    }
    void formRes(ArrayList<Long> a, StringBuilder b) {
        while (a.size() > 1 && a.get(a.size() - 1) == 0)
            a.remove(a.size() - 1);
        b.append(a.isEmpty() ? "0" : a.get(a.size() - 1).toString());
        for (int i = a.size() - 2; i >= 0; --i) {
            b.append(String.format("%09d", a.get(i)));
        }
    }
    public Infinite mul(Infinite other) {
        long counter = 0;
        StringBuilder result = new StringBuilder();
        List<Integer> n1 = this.number;
        List<Integer> n2 = other.number;
        ArrayList<Long> res = new ArrayList<>();
        for (int i = 0; i < n1.size(); ++i)
            for (int j = 0; j < n2.size() || counter != 0; ++j) {
                res.add(0L);
                long count = res.get(i + j) + n1.get(i).longValue() * (j < n2.size() ? n2.get(j).longValue() : 0) + counter;
                res.set(i + j, count % BASE);
                counter = count / BASE;
            }
        formRes(res, result);
        return new Infinite(result.toString());
    }

    public Infinite div(Infinite other) {
        long counter = 0L;
        StringBuilder result = new StringBuilder();
        List<Integer> n1 = this.number;
        List<Integer> n2 = other.number;
        ArrayList<Long> res = new ArrayList<>();
        for (int i = 0; i < n2.size() + n1.size(); i++) {
            res.add(0L);
        }
        for (int i = n1.size() - 1; i >= 0; --i) {
            long count = n1.get(i) + counter * BASE;
            res.set(i, count / (n2.get(0)));
            counter = count % n2.get(0);
        }
        formRes(res, result);
        return new Infinite(result.toString());
    }

    @Override
    public String toString() {
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Infinite) {
            return this.number.equals(((Infinite) obj).number);
        }
        return false;
    }
}