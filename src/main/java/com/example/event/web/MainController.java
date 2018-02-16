package com.example.event.web;

import com.example.event.model.Event;
import com.example.event.repository.EventDataJpaRepository;
import com.example.event.repository.EventFileRepository;
import com.example.event.to.EventSsoidFormid;
import com.example.event.to.EventSsoidSubtype;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/start")
public class MainController {

    public static final String FILE_NAME = "src\\main\\resources\\test_case.csv";

    @Autowired
    EventFileRepository eventFileRepository;

    @Autowired
    EventDataJpaRepository eventDataJpaRepository;

    @GetMapping
    public ModelAndView getStartPage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("menu");
        return  mav;
    }

    @GetMapping(value = "/prepare")
    public int putDataIntoDB(){
        List<Event> list = new ArrayList<>();
        try {
            list = eventFileRepository.getAllFromFile(FILE_NAME);
            eventDataJpaRepository.save(list);
        }
        catch (Exception E){ return 0;}
        return list.size();
    }

    @GetMapping(value = "/report1")
    public ModelAndView getUsersFormsMinutes(@RequestParam(value="mins", defaultValue="60") int minutes){
        List<EventSsoidFormid> list = eventDataJpaRepository.getUsersAndForms(Timestamp.valueOf(LocalDateTime.now().minusMinutes(minutes)));
        Map<String,Set<String>> map = new HashMap<>();
        list.forEach(
                ev -> {
                    String key = ev.getSsoid();
                    if (map.containsKey(key)){
                        map.get(key).add(ev.getFormid());
                    }
                    else{
                        HashSet<String> set = new HashSet<String>();
                        set.add(ev.getFormid());
                        map.put(key,set);
                    }
                }
        );

        ModelAndView mav = new ModelAndView();
        mav.setViewName("report1");
        mav.addObject("users",map);
        return  mav;
    }

    @GetMapping(value = "/report2")
    public  ModelAndView getUsersNotFinshed(){
        List<EventSsoidSubtype> list = eventDataJpaRepository.getUsersNotFinshed();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("report2");
        mav.addObject("users",list);
        return mav;
    }

    @GetMapping(value = "/report3"/*, produces = MediaType.APPLICATION_JSON_VALUE*/)
    public ModelAndView getTopNForms(@RequestParam(value="n", defaultValue="6") int n){
        List<String> list =eventDataJpaRepository.getForms(n);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("report3");
        mav.addObject("forms",list);
        return mav;
    }



}
