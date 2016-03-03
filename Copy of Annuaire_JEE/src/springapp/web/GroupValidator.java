package springapp.web;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import springapp.model.Group;

/**
 * 
 * @author Frederic and Livia
 *
 */
@Service
public class GroupValidator implements Validator {
	
	public boolean supports(Class<?> clazz) {
		return Group.class.isAssignableFrom(clazz);
	}

	/**
	 * validates the format of data in a group in order to add it to the database
	 */
	public void validate(Object target, Errors errors) {
		Group group = (Group) target;
		String nameGr = group.getNameGr();
		String years = group.getYears();
		String[] yearsTab = years.split("/");
		if (yearsTab.length < 1 || yearsTab.length >3 || 
				Integer.getInteger(yearsTab[0])== null || 
				Integer.getInteger(yearsTab[1])== null) {
		}
		else
		{
			int beginYear = Integer.getInteger(yearsTab[0]);			
			int endYear = Integer.getInteger(yearsTab[1]);			
			if (beginYear < endYear) {
				errors.rejectValue("years", "group.years.beginYear");
			}
		}

		if (nameGr != null && nameGr.isEmpty() == false) {
			if (!nameGr.matches("^[A-Za-z0-9]+$")) {
				errors.rejectValue("nameGr", "group.nameGr");
			}
		}

		if (years != null  && years.isEmpty() == false) {
			if (!years.matches("^[0-9]+/[0-9]+$")) {
				errors.rejectValue("years", "group.years");
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "years", "person.years");
	}
}
