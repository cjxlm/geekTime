package com.learn.test;

import java.io.*;

/**
 * Created by XJH on 2019/3/15.
 *
 * @Description:
 */
public class TestSerialize {
    public static void main(String[] args) {
        float[] array = {10.2f, 11.11f, 4.4f};
        TestSerialize ts = new TestSerialize();
        byte[] bytes = ts.toByteArray(array);

        float[] test = (float[]) ts.toObject(bytes);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }

    /**
     * 对象转数组
     *
     * @param obj
     * @return
     */
    public byte[] toByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

    /**
     * 数组转对象
     *
     * @param bytes
     * @return
     */
    public Object toObject(byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return obj;
    }
}
