package Lesson_5;

import java.util.Arrays;

public class ThreadMain {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();

        t1.justCalc();
        System.out.println("---------");
        t1.threadCalc();
    }

}


class MyThread {
    private static final int size = 10000000;
    private static final int h = size / 2;
    private float[] arr = new float[size];

    void justCalc() {


        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        arrayChanger(arr);
        System.out.println("Итого одним потоком: " + (System.currentTimeMillis() - a));
    }

    void threadCalc() {
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        // деление массива
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        long separation = System.currentTimeMillis();

        // обработка массивов
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                arrayChanger(a1);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                arrayChanger(a2);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long processing = System.currentTimeMillis();

        // объединение массивов
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        long assembly = System.currentTimeMillis();

        System.out.println("Время деления: " + (separation - a) + "\n"
                + "Время обработки: " + (processing - separation) + "\n"
                + "Время объединения: " + (assembly - processing) + "\n"
                + "Итого в два потока: " + (System.currentTimeMillis() - a));
    }

    // изменение содержимого массива
    private float[] arrayChanger(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }
}
