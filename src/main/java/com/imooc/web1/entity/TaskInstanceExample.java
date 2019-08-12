package com.imooc.web1.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskInstanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskInstanceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("task_id like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("task_id not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andDagIdIsNull() {
            addCriterion("dag_id is null");
            return (Criteria) this;
        }

        public Criteria andDagIdIsNotNull() {
            addCriterion("dag_id is not null");
            return (Criteria) this;
        }

        public Criteria andDagIdEqualTo(String value) {
            addCriterion("dag_id =", value, "dagId");
            return (Criteria) this;
        }

        public Criteria andDagIdNotEqualTo(String value) {
            addCriterion("dag_id <>", value, "dagId");
            return (Criteria) this;
        }

        public Criteria andDagIdGreaterThan(String value) {
            addCriterion("dag_id >", value, "dagId");
            return (Criteria) this;
        }

        public Criteria andDagIdGreaterThanOrEqualTo(String value) {
            addCriterion("dag_id >=", value, "dagId");
            return (Criteria) this;
        }

        public Criteria andDagIdLessThan(String value) {
            addCriterion("dag_id <", value, "dagId");
            return (Criteria) this;
        }

        public Criteria andDagIdLessThanOrEqualTo(String value) {
            addCriterion("dag_id <=", value, "dagId");
            return (Criteria) this;
        }

        public Criteria andDagIdLike(String value) {
            addCriterion("dag_id like", value, "dagId");
            return (Criteria) this;
        }

        public Criteria andDagIdNotLike(String value) {
            addCriterion("dag_id not like", value, "dagId");
            return (Criteria) this;
        }

        public Criteria andDagIdIn(List<String> values) {
            addCriterion("dag_id in", values, "dagId");
            return (Criteria) this;
        }

        public Criteria andDagIdNotIn(List<String> values) {
            addCriterion("dag_id not in", values, "dagId");
            return (Criteria) this;
        }

        public Criteria andDagIdBetween(String value1, String value2) {
            addCriterion("dag_id between", value1, value2, "dagId");
            return (Criteria) this;
        }

        public Criteria andDagIdNotBetween(String value1, String value2) {
            addCriterion("dag_id not between", value1, value2, "dagId");
            return (Criteria) this;
        }

        public Criteria andExecutionDateIsNull() {
            addCriterion("execution_date is null");
            return (Criteria) this;
        }

        public Criteria andExecutionDateIsNotNull() {
            addCriterion("execution_date is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionDateEqualTo(Date value) {
            addCriterion("execution_date =", value, "executionDate");
            return (Criteria) this;
        }

        public Criteria andExecutionDateNotEqualTo(Date value) {
            addCriterion("execution_date <>", value, "executionDate");
            return (Criteria) this;
        }

        public Criteria andExecutionDateGreaterThan(Date value) {
            addCriterion("execution_date >", value, "executionDate");
            return (Criteria) this;
        }

        public Criteria andExecutionDateGreaterThanOrEqualTo(Date value) {
            addCriterion("execution_date >=", value, "executionDate");
            return (Criteria) this;
        }

        public Criteria andExecutionDateLessThan(Date value) {
            addCriterion("execution_date <", value, "executionDate");
            return (Criteria) this;
        }

        public Criteria andExecutionDateLessThanOrEqualTo(Date value) {
            addCriterion("execution_date <=", value, "executionDate");
            return (Criteria) this;
        }

        public Criteria andExecutionDateIn(List<Date> values) {
            addCriterion("execution_date in", values, "executionDate");
            return (Criteria) this;
        }

        public Criteria andExecutionDateNotIn(List<Date> values) {
            addCriterion("execution_date not in", values, "executionDate");
            return (Criteria) this;
        }

        public Criteria andExecutionDateBetween(Date value1, Date value2) {
            addCriterion("execution_date between", value1, value2, "executionDate");
            return (Criteria) this;
        }

        public Criteria andExecutionDateNotBetween(Date value1, Date value2) {
            addCriterion("execution_date not between", value1, value2, "executionDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterion("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterion("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterion("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterion("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterion("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterion("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterion("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterion("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Float value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Float value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Float value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Float value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Float value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Float value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Float> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Float> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Float value1, Float value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Float value1, Float value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andTryNumberIsNull() {
            addCriterion("try_number is null");
            return (Criteria) this;
        }

        public Criteria andTryNumberIsNotNull() {
            addCriterion("try_number is not null");
            return (Criteria) this;
        }

        public Criteria andTryNumberEqualTo(Integer value) {
            addCriterion("try_number =", value, "tryNumber");
            return (Criteria) this;
        }

        public Criteria andTryNumberNotEqualTo(Integer value) {
            addCriterion("try_number <>", value, "tryNumber");
            return (Criteria) this;
        }

        public Criteria andTryNumberGreaterThan(Integer value) {
            addCriterion("try_number >", value, "tryNumber");
            return (Criteria) this;
        }

        public Criteria andTryNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("try_number >=", value, "tryNumber");
            return (Criteria) this;
        }

        public Criteria andTryNumberLessThan(Integer value) {
            addCriterion("try_number <", value, "tryNumber");
            return (Criteria) this;
        }

        public Criteria andTryNumberLessThanOrEqualTo(Integer value) {
            addCriterion("try_number <=", value, "tryNumber");
            return (Criteria) this;
        }

        public Criteria andTryNumberIn(List<Integer> values) {
            addCriterion("try_number in", values, "tryNumber");
            return (Criteria) this;
        }

        public Criteria andTryNumberNotIn(List<Integer> values) {
            addCriterion("try_number not in", values, "tryNumber");
            return (Criteria) this;
        }

        public Criteria andTryNumberBetween(Integer value1, Integer value2) {
            addCriterion("try_number between", value1, value2, "tryNumber");
            return (Criteria) this;
        }

        public Criteria andTryNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("try_number not between", value1, value2, "tryNumber");
            return (Criteria) this;
        }

        public Criteria andHostnameIsNull() {
            addCriterion("hostname is null");
            return (Criteria) this;
        }

        public Criteria andHostnameIsNotNull() {
            addCriterion("hostname is not null");
            return (Criteria) this;
        }

        public Criteria andHostnameEqualTo(String value) {
            addCriterion("hostname =", value, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameNotEqualTo(String value) {
            addCriterion("hostname <>", value, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameGreaterThan(String value) {
            addCriterion("hostname >", value, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameGreaterThanOrEqualTo(String value) {
            addCriterion("hostname >=", value, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameLessThan(String value) {
            addCriterion("hostname <", value, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameLessThanOrEqualTo(String value) {
            addCriterion("hostname <=", value, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameLike(String value) {
            addCriterion("hostname like", value, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameNotLike(String value) {
            addCriterion("hostname not like", value, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameIn(List<String> values) {
            addCriterion("hostname in", values, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameNotIn(List<String> values) {
            addCriterion("hostname not in", values, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameBetween(String value1, String value2) {
            addCriterion("hostname between", value1, value2, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameNotBetween(String value1, String value2) {
            addCriterion("hostname not between", value1, value2, "hostname");
            return (Criteria) this;
        }

        public Criteria andUnixnameIsNull() {
            addCriterion("unixname is null");
            return (Criteria) this;
        }

        public Criteria andUnixnameIsNotNull() {
            addCriterion("unixname is not null");
            return (Criteria) this;
        }

        public Criteria andUnixnameEqualTo(String value) {
            addCriterion("unixname =", value, "unixname");
            return (Criteria) this;
        }

        public Criteria andUnixnameNotEqualTo(String value) {
            addCriterion("unixname <>", value, "unixname");
            return (Criteria) this;
        }

        public Criteria andUnixnameGreaterThan(String value) {
            addCriterion("unixname >", value, "unixname");
            return (Criteria) this;
        }

        public Criteria andUnixnameGreaterThanOrEqualTo(String value) {
            addCriterion("unixname >=", value, "unixname");
            return (Criteria) this;
        }

        public Criteria andUnixnameLessThan(String value) {
            addCriterion("unixname <", value, "unixname");
            return (Criteria) this;
        }

        public Criteria andUnixnameLessThanOrEqualTo(String value) {
            addCriterion("unixname <=", value, "unixname");
            return (Criteria) this;
        }

        public Criteria andUnixnameLike(String value) {
            addCriterion("unixname like", value, "unixname");
            return (Criteria) this;
        }

        public Criteria andUnixnameNotLike(String value) {
            addCriterion("unixname not like", value, "unixname");
            return (Criteria) this;
        }

        public Criteria andUnixnameIn(List<String> values) {
            addCriterion("unixname in", values, "unixname");
            return (Criteria) this;
        }

        public Criteria andUnixnameNotIn(List<String> values) {
            addCriterion("unixname not in", values, "unixname");
            return (Criteria) this;
        }

        public Criteria andUnixnameBetween(String value1, String value2) {
            addCriterion("unixname between", value1, value2, "unixname");
            return (Criteria) this;
        }

        public Criteria andUnixnameNotBetween(String value1, String value2) {
            addCriterion("unixname not between", value1, value2, "unixname");
            return (Criteria) this;
        }

        public Criteria andJobIdIsNull() {
            addCriterion("job_id is null");
            return (Criteria) this;
        }

        public Criteria andJobIdIsNotNull() {
            addCriterion("job_id is not null");
            return (Criteria) this;
        }

        public Criteria andJobIdEqualTo(Integer value) {
            addCriterion("job_id =", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotEqualTo(Integer value) {
            addCriterion("job_id <>", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThan(Integer value) {
            addCriterion("job_id >", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("job_id >=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThan(Integer value) {
            addCriterion("job_id <", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThanOrEqualTo(Integer value) {
            addCriterion("job_id <=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdIn(List<Integer> values) {
            addCriterion("job_id in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotIn(List<Integer> values) {
            addCriterion("job_id not in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdBetween(Integer value1, Integer value2) {
            addCriterion("job_id between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotBetween(Integer value1, Integer value2) {
            addCriterion("job_id not between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andPoolIsNull() {
            addCriterion("pool is null");
            return (Criteria) this;
        }

        public Criteria andPoolIsNotNull() {
            addCriterion("pool is not null");
            return (Criteria) this;
        }

        public Criteria andPoolEqualTo(String value) {
            addCriterion("pool =", value, "pool");
            return (Criteria) this;
        }

        public Criteria andPoolNotEqualTo(String value) {
            addCriterion("pool <>", value, "pool");
            return (Criteria) this;
        }

        public Criteria andPoolGreaterThan(String value) {
            addCriterion("pool >", value, "pool");
            return (Criteria) this;
        }

        public Criteria andPoolGreaterThanOrEqualTo(String value) {
            addCriterion("pool >=", value, "pool");
            return (Criteria) this;
        }

        public Criteria andPoolLessThan(String value) {
            addCriterion("pool <", value, "pool");
            return (Criteria) this;
        }

        public Criteria andPoolLessThanOrEqualTo(String value) {
            addCriterion("pool <=", value, "pool");
            return (Criteria) this;
        }

        public Criteria andPoolLike(String value) {
            addCriterion("pool like", value, "pool");
            return (Criteria) this;
        }

        public Criteria andPoolNotLike(String value) {
            addCriterion("pool not like", value, "pool");
            return (Criteria) this;
        }

        public Criteria andPoolIn(List<String> values) {
            addCriterion("pool in", values, "pool");
            return (Criteria) this;
        }

        public Criteria andPoolNotIn(List<String> values) {
            addCriterion("pool not in", values, "pool");
            return (Criteria) this;
        }

        public Criteria andPoolBetween(String value1, String value2) {
            addCriterion("pool between", value1, value2, "pool");
            return (Criteria) this;
        }

        public Criteria andPoolNotBetween(String value1, String value2) {
            addCriterion("pool not between", value1, value2, "pool");
            return (Criteria) this;
        }

        public Criteria andQueueIsNull() {
            addCriterion("queue is null");
            return (Criteria) this;
        }

        public Criteria andQueueIsNotNull() {
            addCriterion("queue is not null");
            return (Criteria) this;
        }

        public Criteria andQueueEqualTo(String value) {
            addCriterion("queue =", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueNotEqualTo(String value) {
            addCriterion("queue <>", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueGreaterThan(String value) {
            addCriterion("queue >", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueGreaterThanOrEqualTo(String value) {
            addCriterion("queue >=", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueLessThan(String value) {
            addCriterion("queue <", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueLessThanOrEqualTo(String value) {
            addCriterion("queue <=", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueLike(String value) {
            addCriterion("queue like", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueNotLike(String value) {
            addCriterion("queue not like", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueIn(List<String> values) {
            addCriterion("queue in", values, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueNotIn(List<String> values) {
            addCriterion("queue not in", values, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueBetween(String value1, String value2) {
            addCriterion("queue between", value1, value2, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueNotBetween(String value1, String value2) {
            addCriterion("queue not between", value1, value2, "queue");
            return (Criteria) this;
        }

        public Criteria andPriorityWeightIsNull() {
            addCriterion("priority_weight is null");
            return (Criteria) this;
        }

        public Criteria andPriorityWeightIsNotNull() {
            addCriterion("priority_weight is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityWeightEqualTo(Integer value) {
            addCriterion("priority_weight =", value, "priorityWeight");
            return (Criteria) this;
        }

        public Criteria andPriorityWeightNotEqualTo(Integer value) {
            addCriterion("priority_weight <>", value, "priorityWeight");
            return (Criteria) this;
        }

        public Criteria andPriorityWeightGreaterThan(Integer value) {
            addCriterion("priority_weight >", value, "priorityWeight");
            return (Criteria) this;
        }

        public Criteria andPriorityWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("priority_weight >=", value, "priorityWeight");
            return (Criteria) this;
        }

        public Criteria andPriorityWeightLessThan(Integer value) {
            addCriterion("priority_weight <", value, "priorityWeight");
            return (Criteria) this;
        }

        public Criteria andPriorityWeightLessThanOrEqualTo(Integer value) {
            addCriterion("priority_weight <=", value, "priorityWeight");
            return (Criteria) this;
        }

        public Criteria andPriorityWeightIn(List<Integer> values) {
            addCriterion("priority_weight in", values, "priorityWeight");
            return (Criteria) this;
        }

        public Criteria andPriorityWeightNotIn(List<Integer> values) {
            addCriterion("priority_weight not in", values, "priorityWeight");
            return (Criteria) this;
        }

        public Criteria andPriorityWeightBetween(Integer value1, Integer value2) {
            addCriterion("priority_weight between", value1, value2, "priorityWeight");
            return (Criteria) this;
        }

        public Criteria andPriorityWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("priority_weight not between", value1, value2, "priorityWeight");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andQueuedDttmIsNull() {
            addCriterion("queued_dttm is null");
            return (Criteria) this;
        }

        public Criteria andQueuedDttmIsNotNull() {
            addCriterion("queued_dttm is not null");
            return (Criteria) this;
        }

        public Criteria andQueuedDttmEqualTo(Date value) {
            addCriterion("queued_dttm =", value, "queuedDttm");
            return (Criteria) this;
        }

        public Criteria andQueuedDttmNotEqualTo(Date value) {
            addCriterion("queued_dttm <>", value, "queuedDttm");
            return (Criteria) this;
        }

        public Criteria andQueuedDttmGreaterThan(Date value) {
            addCriterion("queued_dttm >", value, "queuedDttm");
            return (Criteria) this;
        }

        public Criteria andQueuedDttmGreaterThanOrEqualTo(Date value) {
            addCriterion("queued_dttm >=", value, "queuedDttm");
            return (Criteria) this;
        }

        public Criteria andQueuedDttmLessThan(Date value) {
            addCriterion("queued_dttm <", value, "queuedDttm");
            return (Criteria) this;
        }

        public Criteria andQueuedDttmLessThanOrEqualTo(Date value) {
            addCriterion("queued_dttm <=", value, "queuedDttm");
            return (Criteria) this;
        }

        public Criteria andQueuedDttmIn(List<Date> values) {
            addCriterion("queued_dttm in", values, "queuedDttm");
            return (Criteria) this;
        }

        public Criteria andQueuedDttmNotIn(List<Date> values) {
            addCriterion("queued_dttm not in", values, "queuedDttm");
            return (Criteria) this;
        }

        public Criteria andQueuedDttmBetween(Date value1, Date value2) {
            addCriterion("queued_dttm between", value1, value2, "queuedDttm");
            return (Criteria) this;
        }

        public Criteria andQueuedDttmNotBetween(Date value1, Date value2) {
            addCriterion("queued_dttm not between", value1, value2, "queuedDttm");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}