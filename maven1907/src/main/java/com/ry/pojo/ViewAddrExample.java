package com.ry.pojo;

import java.util.ArrayList;
import java.util.List;

public class ViewAddrExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table view_addr
     *
     * @mbg.generated Wed Dec 25 13:54:15 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table view_addr
     *
     * @mbg.generated Wed Dec 25 13:54:15 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table view_addr
     *
     * @mbg.generated Wed Dec 25 13:54:15 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table view_addr
     *
     * @mbg.generated Wed Dec 25 13:54:15 CST 2019
     */
    public ViewAddrExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table view_addr
     *
     * @mbg.generated Wed Dec 25 13:54:15 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table view_addr
     *
     * @mbg.generated Wed Dec 25 13:54:15 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table view_addr
     *
     * @mbg.generated Wed Dec 25 13:54:15 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table view_addr
     *
     * @mbg.generated Wed Dec 25 13:54:15 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table view_addr
     *
     * @mbg.generated Wed Dec 25 13:54:15 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table view_addr
     *
     * @mbg.generated Wed Dec 25 13:54:15 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table view_addr
     *
     * @mbg.generated Wed Dec 25 13:54:15 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table view_addr
     *
     * @mbg.generated Wed Dec 25 13:54:15 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table view_addr
     *
     * @mbg.generated Wed Dec 25 13:54:15 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table view_addr
     *
     * @mbg.generated Wed Dec 25 13:54:15 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table view_addr
     *
     * @mbg.generated Wed Dec 25 13:54:15 CST 2019
     */
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

        public Criteria andProvenceidIsNull() {
            addCriterion("provenceid is null");
            return (Criteria) this;
        }

        public Criteria andProvenceidIsNotNull() {
            addCriterion("provenceid is not null");
            return (Criteria) this;
        }

        public Criteria andProvenceidEqualTo(Integer value) {
            addCriterion("provenceid =", value, "provenceid");
            return (Criteria) this;
        }

        public Criteria andProvenceidNotEqualTo(Integer value) {
            addCriterion("provenceid <>", value, "provenceid");
            return (Criteria) this;
        }

        public Criteria andProvenceidGreaterThan(Integer value) {
            addCriterion("provenceid >", value, "provenceid");
            return (Criteria) this;
        }

        public Criteria andProvenceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("provenceid >=", value, "provenceid");
            return (Criteria) this;
        }

        public Criteria andProvenceidLessThan(Integer value) {
            addCriterion("provenceid <", value, "provenceid");
            return (Criteria) this;
        }

        public Criteria andProvenceidLessThanOrEqualTo(Integer value) {
            addCriterion("provenceid <=", value, "provenceid");
            return (Criteria) this;
        }

        public Criteria andProvenceidIn(List<Integer> values) {
            addCriterion("provenceid in", values, "provenceid");
            return (Criteria) this;
        }

        public Criteria andProvenceidNotIn(List<Integer> values) {
            addCriterion("provenceid not in", values, "provenceid");
            return (Criteria) this;
        }

        public Criteria andProvenceidBetween(Integer value1, Integer value2) {
            addCriterion("provenceid between", value1, value2, "provenceid");
            return (Criteria) this;
        }

        public Criteria andProvenceidNotBetween(Integer value1, Integer value2) {
            addCriterion("provenceid not between", value1, value2, "provenceid");
            return (Criteria) this;
        }

        public Criteria andProvencenameIsNull() {
            addCriterion("provenceName is null");
            return (Criteria) this;
        }

        public Criteria andProvencenameIsNotNull() {
            addCriterion("provenceName is not null");
            return (Criteria) this;
        }

        public Criteria andProvencenameEqualTo(String value) {
            addCriterion("provenceName =", value, "provencename");
            return (Criteria) this;
        }

        public Criteria andProvencenameNotEqualTo(String value) {
            addCriterion("provenceName <>", value, "provencename");
            return (Criteria) this;
        }

        public Criteria andProvencenameGreaterThan(String value) {
            addCriterion("provenceName >", value, "provencename");
            return (Criteria) this;
        }

        public Criteria andProvencenameGreaterThanOrEqualTo(String value) {
            addCriterion("provenceName >=", value, "provencename");
            return (Criteria) this;
        }

        public Criteria andProvencenameLessThan(String value) {
            addCriterion("provenceName <", value, "provencename");
            return (Criteria) this;
        }

        public Criteria andProvencenameLessThanOrEqualTo(String value) {
            addCriterion("provenceName <=", value, "provencename");
            return (Criteria) this;
        }

        public Criteria andProvencenameLike(String value) {
            addCriterion("provenceName like", value, "provencename");
            return (Criteria) this;
        }

        public Criteria andProvencenameNotLike(String value) {
            addCriterion("provenceName not like", value, "provencename");
            return (Criteria) this;
        }

        public Criteria andProvencenameIn(List<String> values) {
            addCriterion("provenceName in", values, "provencename");
            return (Criteria) this;
        }

        public Criteria andProvencenameNotIn(List<String> values) {
            addCriterion("provenceName not in", values, "provencename");
            return (Criteria) this;
        }

        public Criteria andProvencenameBetween(String value1, String value2) {
            addCriterion("provenceName between", value1, value2, "provencename");
            return (Criteria) this;
        }

        public Criteria andProvencenameNotBetween(String value1, String value2) {
            addCriterion("provenceName not between", value1, value2, "provencename");
            return (Criteria) this;
        }

        public Criteria andCityidIsNull() {
            addCriterion("cityid is null");
            return (Criteria) this;
        }

        public Criteria andCityidIsNotNull() {
            addCriterion("cityid is not null");
            return (Criteria) this;
        }

        public Criteria andCityidEqualTo(Integer value) {
            addCriterion("cityid =", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotEqualTo(Integer value) {
            addCriterion("cityid <>", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidGreaterThan(Integer value) {
            addCriterion("cityid >", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cityid >=", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidLessThan(Integer value) {
            addCriterion("cityid <", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidLessThanOrEqualTo(Integer value) {
            addCriterion("cityid <=", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidIn(List<Integer> values) {
            addCriterion("cityid in", values, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotIn(List<Integer> values) {
            addCriterion("cityid not in", values, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidBetween(Integer value1, Integer value2) {
            addCriterion("cityid between", value1, value2, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotBetween(Integer value1, Integer value2) {
            addCriterion("cityid not between", value1, value2, "cityid");
            return (Criteria) this;
        }

        public Criteria andCitynameIsNull() {
            addCriterion("cityname is null");
            return (Criteria) this;
        }

        public Criteria andCitynameIsNotNull() {
            addCriterion("cityname is not null");
            return (Criteria) this;
        }

        public Criteria andCitynameEqualTo(String value) {
            addCriterion("cityname =", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotEqualTo(String value) {
            addCriterion("cityname <>", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameGreaterThan(String value) {
            addCriterion("cityname >", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameGreaterThanOrEqualTo(String value) {
            addCriterion("cityname >=", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLessThan(String value) {
            addCriterion("cityname <", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLessThanOrEqualTo(String value) {
            addCriterion("cityname <=", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLike(String value) {
            addCriterion("cityname like", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotLike(String value) {
            addCriterion("cityname not like", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameIn(List<String> values) {
            addCriterion("cityname in", values, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotIn(List<String> values) {
            addCriterion("cityname not in", values, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameBetween(String value1, String value2) {
            addCriterion("cityname between", value1, value2, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotBetween(String value1, String value2) {
            addCriterion("cityname not between", value1, value2, "cityname");
            return (Criteria) this;
        }

        public Criteria andXnameIsNull() {
            addCriterion("xName is null");
            return (Criteria) this;
        }

        public Criteria andXnameIsNotNull() {
            addCriterion("xName is not null");
            return (Criteria) this;
        }

        public Criteria andXnameEqualTo(String value) {
            addCriterion("xName =", value, "xname");
            return (Criteria) this;
        }

        public Criteria andXnameNotEqualTo(String value) {
            addCriterion("xName <>", value, "xname");
            return (Criteria) this;
        }

        public Criteria andXnameGreaterThan(String value) {
            addCriterion("xName >", value, "xname");
            return (Criteria) this;
        }

        public Criteria andXnameGreaterThanOrEqualTo(String value) {
            addCriterion("xName >=", value, "xname");
            return (Criteria) this;
        }

        public Criteria andXnameLessThan(String value) {
            addCriterion("xName <", value, "xname");
            return (Criteria) this;
        }

        public Criteria andXnameLessThanOrEqualTo(String value) {
            addCriterion("xName <=", value, "xname");
            return (Criteria) this;
        }

        public Criteria andXnameLike(String value) {
            addCriterion("xName like", value, "xname");
            return (Criteria) this;
        }

        public Criteria andXnameNotLike(String value) {
            addCriterion("xName not like", value, "xname");
            return (Criteria) this;
        }

        public Criteria andXnameIn(List<String> values) {
            addCriterion("xName in", values, "xname");
            return (Criteria) this;
        }

        public Criteria andXnameNotIn(List<String> values) {
            addCriterion("xName not in", values, "xname");
            return (Criteria) this;
        }

        public Criteria andXnameBetween(String value1, String value2) {
            addCriterion("xName between", value1, value2, "xname");
            return (Criteria) this;
        }

        public Criteria andXnameNotBetween(String value1, String value2) {
            addCriterion("xName not between", value1, value2, "xname");
            return (Criteria) this;
        }

        public Criteria andXcodeIsNull() {
            addCriterion("xCode is null");
            return (Criteria) this;
        }

        public Criteria andXcodeIsNotNull() {
            addCriterion("xCode is not null");
            return (Criteria) this;
        }

        public Criteria andXcodeEqualTo(Integer value) {
            addCriterion("xCode =", value, "xcode");
            return (Criteria) this;
        }

        public Criteria andXcodeNotEqualTo(Integer value) {
            addCriterion("xCode <>", value, "xcode");
            return (Criteria) this;
        }

        public Criteria andXcodeGreaterThan(Integer value) {
            addCriterion("xCode >", value, "xcode");
            return (Criteria) this;
        }

        public Criteria andXcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("xCode >=", value, "xcode");
            return (Criteria) this;
        }

        public Criteria andXcodeLessThan(Integer value) {
            addCriterion("xCode <", value, "xcode");
            return (Criteria) this;
        }

        public Criteria andXcodeLessThanOrEqualTo(Integer value) {
            addCriterion("xCode <=", value, "xcode");
            return (Criteria) this;
        }

        public Criteria andXcodeIn(List<Integer> values) {
            addCriterion("xCode in", values, "xcode");
            return (Criteria) this;
        }

        public Criteria andXcodeNotIn(List<Integer> values) {
            addCriterion("xCode not in", values, "xcode");
            return (Criteria) this;
        }

        public Criteria andXcodeBetween(Integer value1, Integer value2) {
            addCriterion("xCode between", value1, value2, "xcode");
            return (Criteria) this;
        }

        public Criteria andXcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("xCode not between", value1, value2, "xcode");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table view_addr
     *
     * @mbg.generated do_not_delete_during_merge Wed Dec 25 13:54:15 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table view_addr
     *
     * @mbg.generated Wed Dec 25 13:54:15 CST 2019
     */
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