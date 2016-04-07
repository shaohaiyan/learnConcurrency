/**
 * <p>Description：</p>
 * <p>Copyright：Copyright (c) 2016</p>
 * <p>Company：SenseTime</p>
 * <p>Email：shaohaiyan@sensetime.com</p>
 *
 * @author shaohaiyan
 * @date 16-4-7:上午10:47
 */
public class Test {
    public static void main(String[] args) {
        Thread.interrupted();

        /**
         * waxon:
         *  sleep模拟打蜡；
         *  waxed();标识已经打蜡完毕，准备抛光
         *      waxon=true;
         *      notifyAll();
         *  waitingForBuffing
         *      while(wax==true) wait();只要不进行抛光或者抛光完毕那么就一直等待
         *
         *  waxoff:
         *   waitFOrWaxing()
         *      while(wax==false) wait();只要打蜡还在进行那么这个线程就等待
         *      sleep；模拟抛光
         *      buffed（）；抛光完毕
         *          waxon=fasle；抛光完毕准备下一轮的打蜡，当waxon为true时，waitForBuffer会一直进行，只有设置为false，waxon线程才不会等待
         *          notifyAll（）；唤醒等待的waxon线程
         *
         *
         */
    }
}
