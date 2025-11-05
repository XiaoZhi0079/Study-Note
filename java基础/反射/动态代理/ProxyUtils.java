package ProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class ProxyUtils {
    public static StarService starproxy(Star star) {
        StarService sp=(StarService) Proxy.newProxyInstance(star.getClass().getClassLoader(), star.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("dance")) {
                    System.out.println("经纪人收款10w元，经纪人准备好场地");
                } else if (method.getName().equals("sing")) {
                    System.out.println("经纪人收款10w元，经纪人取出话筒");
                }
                Object result=method.invoke(star, args);
                return result;
            }
        });
        return sp;
    }
}
