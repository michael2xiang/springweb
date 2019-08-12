package com.imooc.web1.entity;

import java.util.Date;

public class TaskInstance {
    private String taskId;

    private String dagId;

    private Date executionDate;

    private Date startDate;

    private Date endDate;

    private Float duration;

    private String state;

    private Integer tryNumber;

    private String hostname;

    private String unixname;

    private Integer jobId;

    private String pool;

    private String queue;

    private Integer priorityWeight;

    private String operator;

    private Date queuedDttm;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getDagId() {
        return dagId;
    }

    public void setDagId(String dagId) {
        this.dagId = dagId == null ? null : dagId.trim();
    }

    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Integer getTryNumber() {
        return tryNumber;
    }

    public void setTryNumber(Integer tryNumber) {
        this.tryNumber = tryNumber;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname == null ? null : hostname.trim();
    }

    public String getUnixname() {
        return unixname;
    }

    public void setUnixname(String unixname) {
        this.unixname = unixname == null ? null : unixname.trim();
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool == null ? null : pool.trim();
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue == null ? null : queue.trim();
    }

    public Integer getPriorityWeight() {
        return priorityWeight;
    }

    public void setPriorityWeight(Integer priorityWeight) {
        this.priorityWeight = priorityWeight;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getQueuedDttm() {
        return queuedDttm;
    }

    public void setQueuedDttm(Date queuedDttm) {
        this.queuedDttm = queuedDttm;
    }
}