package test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"C:\\Users\\tusshar\\eclipse-workspace\\gmailbdd\\src\\test\\resources\\gmailresources\\feature1.feature","C:\\Users\\tusshar\\eclipse-workspace\\gmailbdd\\src\\test\\resources\\gmailresources\\feature2.feature"},plugin={"pretty","html:target"},monochrome=true)
public class GmailRunner 
{

}
