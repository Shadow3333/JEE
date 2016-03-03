package springapp.web;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import springapp.model.Person;

/**
 * 
 * @author Frederic and Livia
 *
 */
@Service
public class PersonValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }
    
    /**
     * validates the data of a person in order to add it to the database
     */
    public void validate(Object target, Errors errors) {
    	Person person = (Person) target;
    	String firstname = person.getFirstname();
    	String birth = person.getBirth(); // récupérée sous la forme 01/01/1970
    	String mail = person.getMail();
    	String web = person.getWeb();
        
        if (firstname != null && firstname.isEmpty() == false) {
            if (!firstname.matches("^[A-Za-z]+-?[A-Za-z]+$")) {
            	System.out.println("prob firstname1");
                errors.rejectValue("firstname", "person.firstnameWrong", "prob firstname1");
            }
            
            if(firstname.length() > 20) {
            	System.out.println("prob firstname2");
            	errors.rejectValue("firstname", "person.firstnameLength : length");
            }
        }
        
        if (mail != null && mail.isEmpty() == false) {
            if (!mail.matches("^[a-z.0-9]+[a-z._0-9]+@[a-z]+[.]{1}[a-z]+$")) {
            	System.out.println("prob mail1");
                errors.rejectValue("mail", "person.mailWrong");
            }
            
            if(mail.length() > 100) {
            	System.out.println("prob mail2");
            	errors.rejectValue("mail", "person.mailLength : length");
            }
        }
        
        if (web != null && web.isEmpty() == false) {
            if (!web.matches("^w{3}[.]{1}[a-z|A-Z|0-9]+[.]{1}[a-z]+$")) //http[s]?[:]{1}//
            {
            	System.out.println("prob web1");
                errors.rejectValue("web", "person.webWrong");
            }
        }
        
        if(birth != null && birth.isEmpty() == false) {
           if (!birth.matches("^[0-9]{2}+/[0-9]{2}+/[0-9]{4}+$")) {

        		System.out.println("prob birth1");
        		errors.rejectValue("birth", "person.birth");
        	}
        }
    	
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
                "person.name");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail",
                "person.mail");
    }
}