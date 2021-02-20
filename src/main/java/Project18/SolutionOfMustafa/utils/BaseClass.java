package utils;

import org.openqa.selenium.WebDriver;
import pages.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;


public class BaseClass {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static ThreadLocal<String> browserName = new ThreadLocal<>();
    private static List<Page> list = new ArrayList<>();


    public static WebDriver setUp(){
        if(threadDriver.get()==null){
            setWebDriver(DriverFactory.createInstance(browserName.get()));
            initPageList();
        }
        return threadDriver.get();
    }

    public static void setWebDriver(WebDriver driver){
        threadDriver.set(driver);
    }


    public static void tearDown() {

        if (threadDriver.get() != null) {

            threadDriver.get().quit();
            WebDriver driver = threadDriver.get();
            driver = null;
            threadDriver.set(driver);
        }
    }
    // ****************** Upper block is to handle the Driver ****************

    // ****************** Lower block is to handle the List<Pages> which would be used in Common steps ****************

    public static Page getPage(String pageName){
       // in this method, I am getting the Page according to the String parameter out of List<Pages>
      Predicate<Page> predicate = obj -> obj.getClass().toString().toUpperCase(Locale.ROOT).contains(pageName.toUpperCase(Locale.ROOT));
      Page page = list.stream().filter(predicate).findFirst().orElse(null);

        if (page == null) {
            throw new RuntimeException("Page not found " + pageName);
        }
        return page;
    }

    private static void initPageList(){
        // all new created Pages must be put in the list in this method.
        list.add(new DemoPage());
        list.add(new TestCampusPage());
    }
}
