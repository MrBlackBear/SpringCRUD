package crud.servlet;

import crud.model.Role;
import crud.model.User;
import crud.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import crud.service.UserService;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Set;


@Controller
public class AppController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(String error, String logout, ModelAndView modelAndView) {
        if (error != null) {
            modelAndView.addObject("error", "Username or password is incorrect.");
        }
        if (logout != null) {
            modelAndView.addObject("message", "Logged out successfully.");
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView startPageAdmin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject( "user", new User());
        modelAndView.addObject("users", this.userService.listUsers());
        modelAndView.addObject("roles", this.roleService.getRoles());
        modelAndView.setViewName("admin_menu");
        return modelAndView;
    }

    @RequestMapping(value = {"/admin/add"}, method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("user") User user, HttpServletRequest request) {
        Set<Role> roleSet = Collections.singleton(roleService.getRoleById(Long.valueOf(request.getParameter("role"))));
        user.setRoles(roleSet);
        userService.addUser(user);
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value = {"/admin/delete"}, method = RequestMethod.POST)
    public ModelAndView deleteEmployee(HttpServletRequest request) {
        userService.removeUser(Integer.valueOf(request.getParameter("id")));
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value = {"/admin/update"}, method = RequestMethod.POST)
    public ModelAndView updatePost(@ModelAttribute("admin/user") User user, HttpServletRequest request) {
        Set<Role> roleSet = Collections.singleton(roleService.getRoleById(Long.valueOf(request.getParameter("role"))));
        user.setRoles(roleSet);
        userService.updateUser(user);
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value = {"/admin/update"}, method = RequestMethod.GET)
    public ModelAndView updateGet(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserById(employeeId);
        ModelAndView model = new ModelAndView("update");
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView helloPageUser(ModelAndView modelAndView) {
        modelAndView.setViewName("user_hello");
        return modelAndView;
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView error(ModelAndView modelAndView){
        modelAndView.setViewName("error");
        return modelAndView;
    }
}