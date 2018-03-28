package hh.palvelinohjelmointi.todolist.webcontrol;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.palvelinohjelmointi.todolist.domain.Object;
import hh.palvelinohjelmointi.todolist.domain.ObjectRepository;
import hh.palvelinohjelmointi.todolist.domain.CategoryRepository;

@Controller
public class ObjectController {

@Autowired
private ObjectRepository orepo;
@Autowired
private CategoryRepository crepo;

@RequestMapping(value="/login")
public String login() {
	return "login";
}

@RequestMapping(value="/objectlist")
public String marketplace(Model model){
	model.addAttribute("objects", orepo.findAll());
	return "objectlist";
}

@RequestMapping(value="/objects", method = RequestMethod.GET)
public @ResponseBody List <Object> objectlistrest(){
	return (List<Object>) orepo.findAll();
}
@RequestMapping(value="products/{id}", method = RequestMethod.GET)
public @ResponseBody Optional<Object> findObjectRest (@PathVariable("id") Long objectid) {
	return orepo.findById(objectid);
}
@RequestMapping(value="/add")
public String addProduct(Model model) {
	model.addAttribute("object", new Object());
	model.addAttribute("categories", crepo.findAll());
	return "addobject";
}
@RequestMapping(value="/save", method=RequestMethod.POST)
public String save(Object object){
	orepo.save(object);
	return "redirect:objectlist";
}
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
public String deleteObject(@PathVariable("id") Long objectid, Model model) {
	orepo.deleteById(objectid);
	return "redirect:/objectlist";
}
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value="/edit/{id}")
public String editProduct(@PathVariable("id") Long objectid, Model model){
	model.addAttribute("object", orepo.findById(objectid));
	model.addAttribute("categories", crepo.findAll());
	return "editobject";
}
}



