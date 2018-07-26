package test.prog.controller;
import test.prog.controller.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import test.prog.model.Profile;
import test.prog.model.MyDataObject;
import test.prog.dao.ProfileDao;
import test.prog.model.ProfileInfo;
import test.prog.request.ProfileRequest;
import test.prog.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Value;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.Calendar;



/*@RestController
@RequestMapping(value = "/profile",
        produces = { MediaType.APPLICATION_JSON_VALUE, //
                MediaType.APPLICATION_XML_VALUE })


public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(value = "/{personId:\\d+}")
    public Profile getProfile(@PathVariable int personId) {
        return profileService.getProfile(personId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProfile(@Valid @RequestBody ProfileRequest request) {
        profileService.createProfile(
                request.getFirstName(),
                request.getLastName(),
                request.getAddress(),
                request.getAge()
        );
    }


    @DeleteMapping(value = "/{personId:\\d+}")
    public void deleteProfile(@PathVariable int personId) {
        profileService.deleteProfile(personId);
    }
}*/
@Controller


public class ProfileController {






    private static final Logger log = LoggerFactory.getLogger(ProfileController.class);
    @Autowired
    private ProfileDao profileDao;


    private final ProfileService profileService;


    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }







    @Controller
// мапим наш REST на /myservice
    @RequestMapping(value = "/myservice")
    public class MainController {

        // этот метод будет принимать время методом GET и на его основе
        // отвечать клиенту
        @RequestMapping(value= "/{time}", method = RequestMethod.GET)
        @ResponseBody
        public MyDataObject getMyData(@PathVariable long time) {
            return new MyDataObject(Calendar.getInstance(), "Это ответ метода GET!");
        }

        // этот метод будет принимать Объект MyDataObject и отдавать его клиенту
        // обычно метод PUT используют для сохранения либо для обновления объекта
        @RequestMapping(method = RequestMethod.PUT)
        @ResponseBody
        public MyDataObject putMyData(@RequestBody MyDataObject md) {
            return md;
        }

        // этот метод будет методом POST отдавать объект MyDataObject
        @RequestMapping(method = RequestMethod.POST)
        @ResponseBody
        public MyDataObject postMyData() {
            return new MyDataObject(Calendar.getInstance(), "это ответ метода POST!");
        }

        // этот метод будет принимать время методом DELETE
        // и на его основе можно удалит объект
        @RequestMapping(value= "/{time}", method = RequestMethod.DELETE)
        @ResponseBody
        public MyDataObject deleteMyData(@PathVariable long time) {
            return new MyDataObject(Calendar.getInstance(), "Это ответ метода DELETE!");
        }
    }






















    @RequestMapping(value = "/getTest/{personId}", method = RequestMethod.GET)
    public String showBankAccounts(Model model,@PathVariable int personId) {


        model.addAttribute("profile", profileService.getProfile(personId));

        return "getTest";
    }


    @GetMapping("/postTest")
    public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {


        return "postTest";
    }

    @PostMapping("/postTest")
    public String doPost(@Valid  ProfileRequest request,HttpServletRequest requestHttp, HttpServletResponse response) throws ServletException {
        try {
            requestHttp.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



        profileService.createProfile(
                requestHttp.getParameter("firstName"),
                requestHttp.getParameter("lastName"),
                requestHttp.getParameter("address"),
                Integer.valueOf(requestHttp.getParameter("age")),
                requestHttp.getParameter("email"),
                requestHttp.getParameter("country"));
        return "postTest";
    }


    @GetMapping("/deleteTest")
    public String doDeleteGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {


        return "deleteTest";
    }
    @PostMapping("/deleteTest")
    public String doDeletePost(HttpServletRequest requestHttp, HttpServletResponse response) throws ServletException {


        int ProfileId=Integer.valueOf(requestHttp.getParameter("id"));
        profileService.deleteProfile(ProfileId);

        log.info("Запись c ID {} удалена",  ProfileId);
        return "deleteTest";
    }

   /* @PostMapping(value = {"/postTest"},  produces = "application/json")
    @ResponseBody
    public JsonResultBean saveTicketTemplate(@RequestBody TicketTemplateFieldBean fieldBean){

        profileService.createProfile(
                firstName,
                lastName,
                address,
                age,
                email,
                country
        );

    }*/
   /* @RequestMapping(value = {"/postTest"}, method = RequestMethod.POST)
    public String updateTask(@ModelAttribute("task") Profile profile) {
        ProfileService.CreateProfile(profile);
        return "redirect:/";
    }*/
/*
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showProfiles(Model model) {
        List<ProfileInfo> list = profileDao.listProfileInfo();

        model.addAttribute("accountInfos", list);

        return "accountsPage";
    }
*/


    @RequestMapping(value = "/profile/get/{personId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })

    @ResponseBody

    public Profile getProfile(@PathVariable int personId) {
        return profileService.getProfile(personId);
    }



  /*  @GetMapping("/getTest/{personId}")
    public String getTestForm(Model model,@PathVariable int personId) {

        model.addAttribute("profile", profileService.getProfile(personId));
        return "getTest";
    }*/








    @RequestMapping(value = "/profile/post", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void createProfile(@Valid @RequestBody ProfileRequest request) {
        profileService.createProfile(
                request.getFirstName(),
                request.getLastName(),
                request.getAddress(),
                request.getAge(),
                request.getEmail(),
                request.getCountry()
                );

        log.info("Запись {} {} {} {} {} {} добавлена",
                request.getFirstName(),
                request.getLastName(),
                request.getAddress(),
                request.getAge(),
                request.getEmail(),
                request.getCountry());


    }

    @RequestMapping(value = "/profile/delete/{personId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    @DeleteMapping(value = "/{personId:\\d+}")
    public void deleteProfile(@PathVariable int personId) {
        profileService.deleteProfile(personId);

        log.info("Запись c ID {} удалена",  personId);

    }

}