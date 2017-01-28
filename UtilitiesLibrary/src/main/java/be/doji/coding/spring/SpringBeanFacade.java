package be.doji.coding.spring;

import be.doji.coding.exception.BeanNotFoundException;
import be.doji.coding.exception.ExceptionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Doji on 28/01/2017.
 */
@Component("beanFacade") public final class SpringBeanFacade {

    private static ApplicationContext applicationContext;

    @Autowired private SpringBeanFacade(ApplicationContext context) {
        this.applicationContext = context;
    }

    public static <T extends Component> T getBean(String beanName, T clazz) throws BeanNotFoundException {
        try {
            return (T) getApplicationContext().getBean(beanName, clazz);
        } catch (BeansException be) {
            BeanNotFoundException exceptionToThrow = new BeanNotFoundException(
                    "Error while fetching the bean from the application context.", be);
            throw ExceptionFactory.logAndThrowError(exceptionToThrow, SpringBeanFacade.class, Level.SEVERE);
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
