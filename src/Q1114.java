import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 按顺序打印first，second，third，用多线程实现
 */

class Test{
    public static void main(String[] args) {

        new Thread(()->{

        },"a").start();
    }
}
public class Q1114 {
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    public void Foo() {

    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        while (num!=0){
            this.wait();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        num = 1;
        this.notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (num!=1){
            this.wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        num = 2;
        this.notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (num!=2){
            this.wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        num = 0;
        this.notifyAll();
    }
}
