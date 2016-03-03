package springapp.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springapp.manager.AnnuaireManager;
import springapp.model.Group;
import springapp.model.Person;
import springapp.recovery.recoveryManager;

/**
 * 
 * @author Frederic and Livia
 *
 */
@Controller()
@RequestMapping("/Annuaire")
public class AnnuaireController {

	@Autowired
	AnnuaireManager manager;
	@Autowired()
    Person pers;
	@Autowired
	PersonValidator persValidator;
	@Autowired
	GroupValidator groupValidator;

	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * @return Person pers
	 */
	@ModelAttribute("pers")
    public Person newPerson() {
		if (pers.getIdP() == null) {
			pers.setMail("p0@rien.truc");
			pers.setPwd("p0");
		}
        return pers;
    }
	
	@RequestMapping(value = "/")
    public String racine() {
        return "index";
    }
	
	/**
	 * @return String
	 */
    @RequestMapping(value = "/logged")
    public String logged(ModelMap model) {
    	if (pers == null || pers.getIdP() == null) {
    		return "redirect:list";
		}
        logger.info("login user " + pers.getName());
        model.addAttribute("logged", "");
    	model.addAttribute("unlogged", "none");
        return "AnnuaireListGroups";
    }
    
    /**
     * @return String 
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
	public String setSession(@ModelAttribute Person p, BindingResult result) {
    	Person tempo = manager.authPers(p.getMail(), p.getPwd());
    	if (tempo == null || result.hasErrors() ) {
			return "AnnuaireLogin";
		}
    	pers.copy(tempo);
    	
		return "redirect:logged"; // anciennement return "productsList" => F5 =
								// ajout d'un nouveau produit
	}
    
    /**
     * @return String
     */
    @RequestMapping(value = "/login")
    public String login(ModelMap model) {
    	model.addAttribute("logged", "");
    	model.addAttribute("unlogged", "none");
        return "AnnuaireLogin";
    }
    
    /**
     * @return String
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editPers(ModelMap model) {
    	if (pers == null || pers.getIdP() == null) {
    		return "redirect:listGroups";			
		}
    	model.addAttribute("pers", pers);
    	model.addAttribute("gr_list", manager.findAllGroups());
		return "AnnuaireEdit";
	}
    
    /**
     * @return String
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String updatePers(ModelMap model, @ModelAttribute @Valid Person p, BindingResult result) {
    	persValidator.validate(p, result);
		if (result.hasErrors() ) {
			model.addAttribute("pers", p);
			model.addAttribute("gr_list", manager.findAllGroups());
			return "AnnuaireEdit";
		}
    	if (pers != null) {
    		p.setIdP(pers.getIdP());
    		manager.savePers(p);
    		pers.copy(p);
    	}
		return "redirect:groupsList"; // anciennement return "productsList" => F5 =
								// ajout d'un nouveau produit
	}
    
    /**
     * @return String
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newPers(ModelMap model) {
    	model.addAttribute("gr_list", manager.findAllGroups());
		return "AnnuaireNewPerson";
	}
    
    /**
     * @return String
     */
    @RequestMapping(value = "/new", method = RequestMethod.POST)
	public String savePers(ModelMap model, @ModelAttribute @Valid Person p, BindingResult result) {
    	persValidator.validate(p, result);
		if (result.hasErrors() ) {
			model.addAttribute("gr_list", manager.findAllGroups());
			return "AnnuaireNewPerson";
		}
		manager.savePers(p);
		return "redirect:groupsList"; // anciennement return "productsList" => F5 =
								// ajout d'un nouveau produit
	}

    /**
     * @return String
     */
    @RequestMapping(value = "/logout")
    public String logout(ModelMap model) {
        pers.reset();
		pers.setMail("p0@rien.truc");
		pers.setPwd("p0");
		model.addAttribute("logged", "none");
		model.addAttribute("unlogged", "");
        return "AnnuaireListGroups";
    }
    
    /**
     * @return String
     */
    @RequestMapping(value = "/newPassword", method = RequestMethod.GET)
    public String gotonewPassword(ModelMap model, @RequestParam(value = "link", required = false) String link) {
    	recoveryManager rM = recoveryManager.init();
    	String mail = rM.getMail(link);
    	if (mail == null) {
			return "AnnuaireErr";
		}
    	if (manager.getLink(mail) == null) {
			return "AnnuaireErr";
		}
    	Person p;
    	p = manager.findByMail(mail);
    	if (p == null) {
			return "AnnuaireErr";
		}
    	model.addAttribute("pers", p);
        return "AnnuaireNewPwd";
    }
    
    /**
     * @return String
     */
    @RequestMapping(value = "/newPassword", method = RequestMethod.POST)
    public String newPassword(@RequestParam(value = "mail", required = false) String mail, HttpServletRequest request) {
    	if (mail == null) {return "AnnuaireErr";}
    	if (manager.getLink(mail) == null) {
			return "AnnuaireErr";
		}
    	
    	Person p = null;
    	p = manager.findByMail(mail);
    	if (p == null) {return "AnnuaireErr";}
    	
    	String pwd = request.getParameter("pwd");
    	p.setPwd(pwd);
    	manager.savePers(p);
		pers.copy(p);
		manager.deleteLink(p.getMail());
        return "redirect:groupsList";
    }
    
    /**
     * @return String
     */
    @RequestMapping(value = "/newGroup", method = RequestMethod.GET)
    public String gotoNewGroup() {
    	new ModelAndView("AnnuaireNewGroup");
        return "AnnuaireNewGroup";
    }
    
    /**
     * @return String
     */
    @RequestMapping(value = "/newGroup", method = RequestMethod.POST)
    public String NewGroup(ModelMap model, HttpServletRequest request) {
    	String nameGr = request.getParameter("nameGr");
    	String years = request.getParameter("years");
    	Group g = new Group(nameGr, years);
    	BindingResult result = new BeanPropertyBindingResult(g, "g");
    	groupValidator.validate(g, result);
		if (result.hasErrors() ) {
			return "AnnuaireNewGroup";
		}
    	manager.addGroup(g);
    	return "redirect:groupsList";
    }

    /**
     * @return String
     */
    @RequestMapping(value = "/reset")
    public String gotoReset(ModelMap model) {
        return "AnnuaireReset";
    }
    
    /**
     * @return String
     */
    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public String reset(@RequestParam(value = "mail", required = false) String mail) {
    	if (manager.checkMail(mail) == false) {
    		return "AnnuaireReset";
		}
    	recoveryManager rM = recoveryManager.init();
    	rM.resetPwd(mail);
    	return "redirect:groupsList";
    }
    
    /**
     * @return String
     */
    @RequestMapping(value = "/fullList", method = RequestMethod.GET)
	public String list(ModelMap model) {
		logger.info("AnnuaireFullList");
		if (pers == null || pers.getIdP() == null) {
			model.addAttribute("logged", "none");
			model.addAttribute("unlogged", "");
		}
		else
		{
			model.addAttribute("logged", "");
			model.addAttribute("unlogged", "none");
		}
		return "AnnuaireFullList";
	}
    
    /**
     * @return Map
     */
    @ModelAttribute("list")
    Map<String, List<Person>> creatList() {
		logger.info("Making list");
		return manager.preparList();
	}
    
    @RequestMapping(value = "/groupsList", method = RequestMethod.GET)
	public String listGroups(ModelMap model) {
		logger.info("AnnuaireListGroups");
		if (pers == null || pers.getIdP() == null) {
			model.addAttribute("logged", "none");
			model.addAttribute("unlogged", "");
		}
		else
		{
			model.addAttribute("logged", "");
			model.addAttribute("unlogged", "none");
		}
		model.addAttribute("gr_list", manager.findAllGroups());
		return "AnnuaireListGroups";
	}
    
    @RequestMapping(value = "/personsList", method = RequestMethod.GET)
	public String listPersons(ModelMap model, @RequestParam(value = "nameGr", required = false) String nameGr) {
		logger.info("AnnuaireListPersons");
		if (pers == null || pers.getIdP() == null) {
			model.addAttribute("logged", "none");
			model.addAttribute("unlogged", "");
		}
		else
		{
			model.addAttribute("logged", "");
			model.addAttribute("unlogged", "none");
		}
		model.addAttribute("Pers_list", manager.findByGroup(nameGr));
		return "AnnuaireListPersons";
	}
    
    /**
     * @return String
     */
    @RequestMapping(value = "/details", method = RequestMethod.GET)
	public String details(ModelMap model, @RequestParam(value = "idP", required = false) Integer idP) {
    	Person p = null;
    	if (idP != null) {
			logger.info("find person " + idP);
			p = manager.findPerson(idP);
		}
    	if (p == null) {
    		new ModelAndView("AnnuaireErr");
    		return "AnnuaireErr";
		}
    	if (pers == null || pers.getIdP() == null) {
    		Person fictive = new Person();
    		fictive.setFirstname(p.getFirstname());
    		fictive.setName(p.getName());
    		fictive.setWeb(p.getWeb());
    		model.addAttribute("pers", fictive);
    		model.addAttribute("logged", "none");
		}
    	else
    	{
    		model.addAttribute("logged", "inline");
    		model.addAttribute("pers", p);
    	}
		return "AnnuaireDetails";
	}
}