//package com.imooc.web1.config.redisratelimit;
//
//import com.imooc.web1.Web1Application;
//import com.imooc.web1.common.RateLimitResultEnum;
//import com.imooc.web1.response.RateLimitVo;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import rx.subjects.PublishSubject;
//import rx.subjects.SerializedSubject;
//
//import javax.security.auth.Subject;
//import java.util.Observable;
//import java.util.Random;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Web1Application.class)
//public class RateLimitClientTest {
//    @Autowired
//    private RateLimitClient rateLimitClient;
//
//    @Test
//    public void testInit() {
//        RateLimitVo vo = new RateLimitVo();
//        vo.setInitialPermits(5);
//        vo.setMaxPermits(5);
//        vo.setInterval(1000.0);
//        rateLimitClient.init("test", vo);
//    }
//
//    @Test
//    public void testAcquireSimple() throws InterruptedException {
//
//        ExecutorService executorService = Executors.newFixedThreadPool(20);
//
//        final CountDownLatch cdOrder = new CountDownLatch(1);//指挥官的命令，设置为1，指挥官一下达命令，则cutDown,变为0，战士们执行任务
//        final CountDownLatch cdAnswer = new CountDownLatch(20);//因为有三个战士，所以初始值为3，每一个战士执行任务完毕则cutDown一次，当三个都执行完毕，变为0，则指挥官停止等待。
//
//
//        Runnable acquire = () -> {
//            try {
//                cdOrder.await();
//                System.out.println("执行-线程" + Thread.currentThread().getName());
//                RateLimitResultEnum result = rateLimitClient.acquire("test");
//                System.out.println(result.toString());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                cdAnswer.countDown();
//            }
////            Random random = new Random();
////            while (true) {
//////                try {
//////                    Thread.sleep(30);
//////                } catch (InterruptedException e) {
//////                    e.printStackTrace();
//////                }
////                try {
////                    cdOrder.await();
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                } finally {
////                    cdAnswer.countDown();
////                }
////                RateLimitResultEnum result = rateLimitClient.acquire("test");
////                System.out.println(result.toString());
////            }
//        };
//        //初始时间
//        final long currentMillis = System.currentTimeMillis();
//
//        for (int i = 0; i < 20; i++) {
//            executorService.submit(acquire);
//        }
//
//        try {
//            Thread.sleep((long) (Math.random() * 100));
//
//            System.out.println("线程" + Thread.currentThread().getName() +
//                    "即将发布命令");
//            cdOrder.countDown(); //发送命令，cdOrder减1，处于等待的战士们停止等待转去执行任务。
//            System.out.println("线程" + Thread.currentThread().getName() +
//                    "已发送命令，正在等待结果");
//            cdAnswer.await(); //命令发送后指挥官处于等待状态，一旦cdAnswer为0时停止等待继续往下执行
//            System.out.println("线程" + Thread.currentThread().getName() +
//                    "已收到所有响应结果");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
////        while (true) {
////            Thread.sleep(5000);
////        }
//    }
//
//
////    @Test
////    public void testAcquire() throws InterruptedException {
////        //10个线程
////        ExecutorService executorService = Executors.newFixedThreadPool(20);
////
////        Subject<RateLimitSummary, RateLimitSummary> writeSubject = new SerializedSubject<RateLimitSummary, RateLimitSummary>(PublishSubject.<RateLimitSummary>create());
////        Observable<RateLimitSummary> readSubject = writeSubject.share();
////        Observable<RateLimitSummary> bucketStream = Observable.defer(()->{
////            return readSubject.window(200, TimeUnit.MILLISECONDS)
////                    .flatMap(
////                            observable->
////                                    observable.reduce(new RateLimitSummary(0,0,0),
////                                            (a, b)-> a.reduce(b))
////                    );
////        });
////        Observable<RateLimitSummary> rollingBucketStream = bucketStream.window(5, 1)
////                .flatMap(observable->observable.reduce(new RateLimitSummary(0, 0, 0),
////                        (a, b)-> a.reduce(b)));
////
////        Runnable acquire = () -> {
////            Random random = new Random();
////            while(true){
////                try {
////                    Thread.sleep(30);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////                RateLimitResultEnum result = rateLimitClient.acquire("test");
////                writeSubject.onNext(new RateLimitSummary(result));
////            }
////        };
////        //初始时间
////        final long currentMillis = System.currentTimeMillis();
////        rollingBucketStream.subscribe(summary->{
////            double timestamp = (System.currentTimeMillis() - currentMillis)/1000.0;
////            System.out.println("time:"+ timestamp + ", acquired:" + summary.acquire +
////                    ", reject " + summary.reject + ", error: " + summary.error);
////        });
////        for(int i=0;i<20;i++){
////            executorService.submit(acquire);
////        }
////        while(true){
////            Thread.sleep(5000);
////        }
////    }
//
//    private static class RateLimitSummary {
//        public int acquire;
//        public int reject;
//        public int error;
//
//        public RateLimitSummary(RateLimitResultEnum result) {
//            this.acquire = result == RateLimitResultEnum.SUCCESS ? 1 : 0;
//            this.reject = result == RateLimitResultEnum.ACQUIRE_FAIL ? 1 : 0;
//            this.error = result == RateLimitResultEnum.ERROR ? 1 : 0;
//        }
//
//        public RateLimitSummary(int acquire, int reject, int error) {
//            this.acquire = acquire;
//            this.reject = reject;
//            this.error = error;
//        }
//
//        public RateLimitSummary reduce(RateLimitSummary toAdd) {
//            return new RateLimitSummary(this.acquire + toAdd.acquire,
//                    this.reject + toAdd.reject,
//                    this.error + toAdd.error);
//
//        }
//    }
//}