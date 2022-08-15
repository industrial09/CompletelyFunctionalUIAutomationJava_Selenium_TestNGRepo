package framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends Base{
    public BasePage(){
        PageFactory.initElements(Drivercontext.driver, this);
    }

    public <TPage extends BasePage> TPage As(Class<TPage> pageInstance){
        try{
            return (TPage) this;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
