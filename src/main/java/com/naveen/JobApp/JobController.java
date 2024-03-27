package com.naveen.JobApp;

import com.naveen.JobApp.model.JobPost;
import com.naveen.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    JobService js;

    @RequestMapping({"/", "home"})
    public String home(){
        System.out.println("Home page called!");
        return "home";
    }

    @RequestMapping("viewalljobs")
    public String view(Model m){
        System.out.println("all jobs");
        List<JobPost> jobs = js.getAllJobs();
        m.addAttribute("jobPosts", jobs);
        return "viewalljobs";
    }

    @RequestMapping("addjob")
    public String add(){
        System.out.println("adding");
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost){
        System.out.println("handling form");
        js.addJob(jobPost);
        return "success";
    }
}
