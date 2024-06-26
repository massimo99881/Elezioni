package it.elezioni.controller.example;

import it.elezioni.data.example.Contact;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class ContactController {

	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact,
			BindingResult result) {

		System.out.println("First Name:" + contact.getFirstname()
				+ "Last Name:" + contact.getLastname());

		return "redirect:contacts";
	}

	@RequestMapping("/contacts")
	public ModelAndView showContacts() {

		return new ModelAndView("example/form/contact", "commandNameContact", new Contact());
		
	}
}
