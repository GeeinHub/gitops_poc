package g.gitops.poc.infrastructure.common.handler;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//https://github.com/krushnaDash/spring-aop-log
@Aspect
@Component
@Slf4j
public class LoggingAspect {

    /**
     * This method uses Around advice which ensures that an advice can run before
     * and after the method execution, to and log the execution time of the method
     * This advice will be be applied to all the method which are annotate with the
     * annotation @LogExecutionTime @see com.example.springaop.logging.LogExecutionTime
     * <p>
     * Any method where execution times need to be measure and log, annotate the method with @LogExecutionTime
     * example
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     * @LogExecutionTime public void m1();
     */
    @Around("@annotation(g.gitops.poc.infrastructure.common.handler.LogExecutionTime)")
    public Object methodTimeLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        // Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        // Measure method execution time
        StopWatch stopWatch = new StopWatch(className + "->" + methodName);
        stopWatch.start(methodName);
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
        // Log method execution time
        if (log.isInfoEnabled()) {
            log.info(stopWatch.prettyPrint());
        }
        return result;
    }
}