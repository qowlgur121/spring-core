package hello.core.logdemo;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

public class LogDemoService {

    @Service
    @RequiredArgsConstructor
    public class LogDemoService {

        private final ObjectProvider<MyLogger> myLoggerObjectProvider;

        public void logic(String id) {
            MyLogger myLogger = myLoggerObjectProvider.getObject();
            myLogger.log("service id = " + id);
        }
    }
}
