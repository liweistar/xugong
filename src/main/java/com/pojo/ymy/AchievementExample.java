package com.pojo.ymy;

import java.util.ArrayList;
import java.util.List;

public class AchievementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AchievementExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(Integer value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(Integer value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(Integer value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(Integer value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(Integer value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<Integer> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<Integer> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(Integer value1, Integer value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andKeoneIsNull() {
            addCriterion("keone is null");
            return (Criteria) this;
        }

        public Criteria andKeoneIsNotNull() {
            addCriterion("keone is not null");
            return (Criteria) this;
        }

        public Criteria andKeoneEqualTo(Double value) {
            addCriterion("keone =", value, "keone");
            return (Criteria) this;
        }

        public Criteria andKeoneNotEqualTo(Double value) {
            addCriterion("keone <>", value, "keone");
            return (Criteria) this;
        }

        public Criteria andKeoneGreaterThan(Double value) {
            addCriterion("keone >", value, "keone");
            return (Criteria) this;
        }

        public Criteria andKeoneGreaterThanOrEqualTo(Double value) {
            addCriterion("keone >=", value, "keone");
            return (Criteria) this;
        }

        public Criteria andKeoneLessThan(Double value) {
            addCriterion("keone <", value, "keone");
            return (Criteria) this;
        }

        public Criteria andKeoneLessThanOrEqualTo(Double value) {
            addCriterion("keone <=", value, "keone");
            return (Criteria) this;
        }

        public Criteria andKeoneIn(List<Double> values) {
            addCriterion("keone in", values, "keone");
            return (Criteria) this;
        }

        public Criteria andKeoneNotIn(List<Double> values) {
            addCriterion("keone not in", values, "keone");
            return (Criteria) this;
        }

        public Criteria andKeoneBetween(Double value1, Double value2) {
            addCriterion("keone between", value1, value2, "keone");
            return (Criteria) this;
        }

        public Criteria andKeoneNotBetween(Double value1, Double value2) {
            addCriterion("keone not between", value1, value2, "keone");
            return (Criteria) this;
        }

        public Criteria andKetwoIsNull() {
            addCriterion("ketwo is null");
            return (Criteria) this;
        }

        public Criteria andKetwoIsNotNull() {
            addCriterion("ketwo is not null");
            return (Criteria) this;
        }

        public Criteria andKetwoEqualTo(Double value) {
            addCriterion("ketwo =", value, "ketwo");
            return (Criteria) this;
        }

        public Criteria andKetwoNotEqualTo(Double value) {
            addCriterion("ketwo <>", value, "ketwo");
            return (Criteria) this;
        }

        public Criteria andKetwoGreaterThan(Double value) {
            addCriterion("ketwo >", value, "ketwo");
            return (Criteria) this;
        }

        public Criteria andKetwoGreaterThanOrEqualTo(Double value) {
            addCriterion("ketwo >=", value, "ketwo");
            return (Criteria) this;
        }

        public Criteria andKetwoLessThan(Double value) {
            addCriterion("ketwo <", value, "ketwo");
            return (Criteria) this;
        }

        public Criteria andKetwoLessThanOrEqualTo(Double value) {
            addCriterion("ketwo <=", value, "ketwo");
            return (Criteria) this;
        }

        public Criteria andKetwoIn(List<Double> values) {
            addCriterion("ketwo in", values, "ketwo");
            return (Criteria) this;
        }

        public Criteria andKetwoNotIn(List<Double> values) {
            addCriterion("ketwo not in", values, "ketwo");
            return (Criteria) this;
        }

        public Criteria andKetwoBetween(Double value1, Double value2) {
            addCriterion("ketwo between", value1, value2, "ketwo");
            return (Criteria) this;
        }

        public Criteria andKetwoNotBetween(Double value1, Double value2) {
            addCriterion("ketwo not between", value1, value2, "ketwo");
            return (Criteria) this;
        }

        public Criteria andKethreeIsNull() {
            addCriterion("kethree is null");
            return (Criteria) this;
        }

        public Criteria andKethreeIsNotNull() {
            addCriterion("kethree is not null");
            return (Criteria) this;
        }

        public Criteria andKethreeEqualTo(Double value) {
            addCriterion("kethree =", value, "kethree");
            return (Criteria) this;
        }

        public Criteria andKethreeNotEqualTo(Double value) {
            addCriterion("kethree <>", value, "kethree");
            return (Criteria) this;
        }

        public Criteria andKethreeGreaterThan(Double value) {
            addCriterion("kethree >", value, "kethree");
            return (Criteria) this;
        }

        public Criteria andKethreeGreaterThanOrEqualTo(Double value) {
            addCriterion("kethree >=", value, "kethree");
            return (Criteria) this;
        }

        public Criteria andKethreeLessThan(Double value) {
            addCriterion("kethree <", value, "kethree");
            return (Criteria) this;
        }

        public Criteria andKethreeLessThanOrEqualTo(Double value) {
            addCriterion("kethree <=", value, "kethree");
            return (Criteria) this;
        }

        public Criteria andKethreeIn(List<Double> values) {
            addCriterion("kethree in", values, "kethree");
            return (Criteria) this;
        }

        public Criteria andKethreeNotIn(List<Double> values) {
            addCriterion("kethree not in", values, "kethree");
            return (Criteria) this;
        }

        public Criteria andKethreeBetween(Double value1, Double value2) {
            addCriterion("kethree between", value1, value2, "kethree");
            return (Criteria) this;
        }

        public Criteria andKethreeNotBetween(Double value1, Double value2) {
            addCriterion("kethree not between", value1, value2, "kethree");
            return (Criteria) this;
        }

        public Criteria andKefourIsNull() {
            addCriterion("kefour is null");
            return (Criteria) this;
        }

        public Criteria andKefourIsNotNull() {
            addCriterion("kefour is not null");
            return (Criteria) this;
        }

        public Criteria andKefourEqualTo(Double value) {
            addCriterion("kefour =", value, "kefour");
            return (Criteria) this;
        }

        public Criteria andKefourNotEqualTo(Double value) {
            addCriterion("kefour <>", value, "kefour");
            return (Criteria) this;
        }

        public Criteria andKefourGreaterThan(Double value) {
            addCriterion("kefour >", value, "kefour");
            return (Criteria) this;
        }

        public Criteria andKefourGreaterThanOrEqualTo(Double value) {
            addCriterion("kefour >=", value, "kefour");
            return (Criteria) this;
        }

        public Criteria andKefourLessThan(Double value) {
            addCriterion("kefour <", value, "kefour");
            return (Criteria) this;
        }

        public Criteria andKefourLessThanOrEqualTo(Double value) {
            addCriterion("kefour <=", value, "kefour");
            return (Criteria) this;
        }

        public Criteria andKefourIn(List<Double> values) {
            addCriterion("kefour in", values, "kefour");
            return (Criteria) this;
        }

        public Criteria andKefourNotIn(List<Double> values) {
            addCriterion("kefour not in", values, "kefour");
            return (Criteria) this;
        }

        public Criteria andKefourBetween(Double value1, Double value2) {
            addCriterion("kefour between", value1, value2, "kefour");
            return (Criteria) this;
        }

        public Criteria andKefourNotBetween(Double value1, Double value2) {
            addCriterion("kefour not between", value1, value2, "kefour");
            return (Criteria) this;
        }

        public Criteria andKefiveIsNull() {
            addCriterion("kefive is null");
            return (Criteria) this;
        }

        public Criteria andKefiveIsNotNull() {
            addCriterion("kefive is not null");
            return (Criteria) this;
        }

        public Criteria andKefiveEqualTo(Double value) {
            addCriterion("kefive =", value, "kefive");
            return (Criteria) this;
        }

        public Criteria andKefiveNotEqualTo(Double value) {
            addCriterion("kefive <>", value, "kefive");
            return (Criteria) this;
        }

        public Criteria andKefiveGreaterThan(Double value) {
            addCriterion("kefive >", value, "kefive");
            return (Criteria) this;
        }

        public Criteria andKefiveGreaterThanOrEqualTo(Double value) {
            addCriterion("kefive >=", value, "kefive");
            return (Criteria) this;
        }

        public Criteria andKefiveLessThan(Double value) {
            addCriterion("kefive <", value, "kefive");
            return (Criteria) this;
        }

        public Criteria andKefiveLessThanOrEqualTo(Double value) {
            addCriterion("kefive <=", value, "kefive");
            return (Criteria) this;
        }

        public Criteria andKefiveIn(List<Double> values) {
            addCriterion("kefive in", values, "kefive");
            return (Criteria) this;
        }

        public Criteria andKefiveNotIn(List<Double> values) {
            addCriterion("kefive not in", values, "kefive");
            return (Criteria) this;
        }

        public Criteria andKefiveBetween(Double value1, Double value2) {
            addCriterion("kefive between", value1, value2, "kefive");
            return (Criteria) this;
        }

        public Criteria andKefiveNotBetween(Double value1, Double value2) {
            addCriterion("kefive not between", value1, value2, "kefive");
            return (Criteria) this;
        }

        public Criteria andPointIsNull() {
            addCriterion("point is null");
            return (Criteria) this;
        }

        public Criteria andPointIsNotNull() {
            addCriterion("point is not null");
            return (Criteria) this;
        }

        public Criteria andPointEqualTo(Double value) {
            addCriterion("point =", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotEqualTo(Double value) {
            addCriterion("point <>", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThan(Double value) {
            addCriterion("point >", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThanOrEqualTo(Double value) {
            addCriterion("point >=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThan(Double value) {
            addCriterion("point <", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThanOrEqualTo(Double value) {
            addCriterion("point <=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointIn(List<Double> values) {
            addCriterion("point in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotIn(List<Double> values) {
            addCriterion("point not in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointBetween(Double value1, Double value2) {
            addCriterion("point between", value1, value2, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotBetween(Double value1, Double value2) {
            addCriterion("point not between", value1, value2, "point");
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