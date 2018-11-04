package com.study.java.day1;

public class ObjectTest {

    public static class NonTest {
        private int a;
        public NonTest(int a) { this.a = a; }
    }

    public static class EqualsTest {
        private int a;

        public EqualsTest(int a) { this.a = a; }

        @Override
        public boolean equals(Object obj) {
            if (EqualsTest.class.isInstance(obj)) {
                return Integer.valueOf(a).equals(EqualsTest.class.cast(obj).a);
            }
            return super.equals(obj);
        }
    }

    public static class HashCodeTest {
        private int a;

        public HashCodeTest(int a) { this.a = a; }

        @Override
        public int hashCode() {
            return Integer.hashCode(a);
        }
    }

    public static class EqualsHashCodeTest {
        private int a;

        public EqualsHashCodeTest(int a) { this.a = a; }

        @Override
        public boolean equals(Object obj) {
            if (EqualsTest.class.isInstance(obj)) {
                return Integer.valueOf(a).equals(EqualsTest.class.cast(obj).a);
            }
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(a);
        }
    }

    public static void main(String[] args) {
        System.out.println("java study 2018");
    }
}
