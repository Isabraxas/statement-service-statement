package cc.viridian.service.statement.controller;

import cc.viridian.service.statement.payload.ListJobsResponse;
import cc.viridian.service.statement.payload.RegisterJobPost;
import cc.viridian.service.statement.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")

public class JobController {

    @Autowired
    JobService jobService;

    @RequestMapping(method = RequestMethod.POST, value="/job")
    @ResponseBody
    public String registerNewJob(
        @RequestBody RegisterJobPost body)
    {
        return jobService.registerSingleJob(body);
    }

    @RequestMapping("/job")
    public ListJobsResponse listJobs(
        @RequestParam(value= "start", required = false, defaultValue = "0") Integer start,
        @RequestParam(value= "length", required = false, defaultValue = "25") Integer length
    ) {
        return jobService.listJobs(start, length);
    }

    @RequestMapping(method = RequestMethod.POST, value="/job/single")
    @ResponseBody
    public String processSingleJob(
        @RequestBody RegisterJobPost body)
    {
        return jobService.registerSingleJob(body);
    }


}
