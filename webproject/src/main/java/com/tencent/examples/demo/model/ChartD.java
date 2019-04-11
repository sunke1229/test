package com.tencent.examples.demo.model;

import com.tencent.bk.api.job.model.Job;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChartD {
    private List<String> appnames;
    private List<Integer> counts;
    private String name;
    private Integer total;//总作业数
    private List<Job> jobs;
}
