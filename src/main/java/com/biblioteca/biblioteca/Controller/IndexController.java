package com.biblioteca.biblioteca.Controller;
import com.biblioteca.biblioteca.Model.Adicionar;
import com.biblioteca.biblioteca.Service.DataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    DataBase dataBase;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
      return "index";
    }


    /*  */
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ModelAndView read(){
        ModelAndView mav = new ModelAndView("read");
        mav.addObject("bibi", dataBase.findAll());
        return mav;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Integer id, Model model){
      model.addAttribute("edit", dataBase.findById(id));
      return "atualizar";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String add(Adicionar adicionar){
        dataBase.save(adicionar);
        return "redirect:/";
    }

    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id){
      dataBase.deleteById(id);
      return "redirect:/";
    }
}
