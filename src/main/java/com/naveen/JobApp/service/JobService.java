package com.naveen.JobApp.service;

import com.naveen.JobApp.model.JobPost;
import com.naveen.JobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    JobRepo jobRepo;

    public void addJob(JobPost job){
        jobRepo.addJob(job);
        System.out.println(jobRepo.getAllJobs());
    }

    public List<JobPost> getAllJobs(){
        return jobRepo.getAllJobs();
    }

}
