package com.study.java.day1;

import java.io.*;

public class SerializeTest {
    /*
     * 다른 환경에서 직렬화를 한다고 생각할 경우 UID를 일치시켜야 한다
     * 디시리얼라이즈 과정에서 형태가 변경되거나 할 때, 불리
     */
    public static class SerializeClass implements Serializable {
        public String parameter = "";
        public String message() {
            return "wow";
        }
    }

    public static byte[] serialize(Object object) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(object);
                return baos.toByteArray();
            }
        }
    }

    public static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes)) {
            try (ObjectInputStream ois = new ObjectInputStream(bais)) {
                return ois.readObject();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("java study 2018");

        // serialize
        SerializeTest.SerializeClass serializeClass = new SerializeTest.SerializeClass();
        serializeClass.parameter = "go serialize";

        byte[] bytes = null;
        try {
            bytes = serialize(serializeClass);
            System.out.println("bytes : " + new String(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Object object = null;
        try {
            object = deserialize(bytes);
            System.out.println("object : " + object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
