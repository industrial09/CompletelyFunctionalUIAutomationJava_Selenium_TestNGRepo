package framework.base;

import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

public class Base {
    public static BasePage CurrentPage;

    public <TPage extends BasePage> TPage GetInstance(Class<TPage> page){
        Object obj = PageFactory.initElements(Drivercontext.driver, page);
        return page.cast(obj);
    }
}
