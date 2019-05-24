package com.pojo.xlw;

import java.util.ArrayList;
import java.util.List;

public class CourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseExample() {
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

        public Criteria andCourseidIsNull() {
            addCriterion("courseid is null");
            return (Criteria) this;
        }

        public Criteria andCourseidIsNotNull() {
            addCriterion("courseid is not null");
            return (Criteria) this;
        }

        public Criteria andCourseidEqualTo(Integer value) {
            addCriterion("courseid =", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotEqualTo(Integer value) {
            addCriterion("courseid <>", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidGreaterThan(Integer value) {
            addCriterion("courseid >", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("courseid >=", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidLessThan(Integer value) {
            addCriterion("courseid <", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidLessThanOrEqualTo(Integer value) {
            addCriterion("courseid <=", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidIn(List<Integer> values) {
            addCriterion("courseid in", values, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotIn(List<Integer> values) {
            addCriterion("courseid not in", values, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidBetween(Integer value1, Integer value2) {
            addCriterion("courseid between", value1, value2, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotBetween(Integer value1, Integer value2) {
            addCriterion("courseid not between", value1, value2, "courseid");
            return (Criteria) this;
        }

        public Criteria andCoursecodeIsNull() {
            addCriterion("coursecode is null");
            return (Criteria) this;
        }

        public Criteria andCoursecodeIsNotNull() {
            addCriterion("coursecode is not null");
            return (Criteria) this;
        }

        public Criteria andCoursecodeEqualTo(Integer value) {
            addCriterion("coursecode =", value, "coursecode");
            return (Criteria) this;
        }

        public Criteria andCoursecodeNotEqualTo(Integer value) {
            addCriterion("coursecode <>", value, "coursecode");
            return (Criteria) this;
        }

        public Criteria andCoursecodeGreaterThan(Integer value) {
            addCriterion("coursecode >", value, "coursecode");
            return (Criteria) this;
        }

        public Criteria andCoursecodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("coursecode >=", value, "coursecode");
            return (Criteria) this;
        }

        public Criteria andCoursecodeLessThan(Integer value) {
            addCriterion("coursecode <", value, "coursecode");
            return (Criteria) this;
        }

        public Criteria andCoursecodeLessThanOrEqualTo(Integer value) {
            addCriterion("coursecode <=", value, "coursecode");
            return (Criteria) this;
        }

        public Criteria andCoursecodeIn(List<Integer> values) {
            addCriterion("coursecode in", values, "coursecode");
            return (Criteria) this;
        }

        public Criteria andCoursecodeNotIn(List<Integer> values) {
            addCriterion("coursecode not in", values, "coursecode");
            return (Criteria) this;
        }

        public Criteria andCoursecodeBetween(Integer value1, Integer value2) {
            addCriterion("coursecode between", value1, value2, "coursecode");
            return (Criteria) this;
        }

        public Criteria andCoursecodeNotBetween(Integer value1, Integer value2) {
            addCriterion("coursecode not between", value1, value2, "coursecode");
            return (Criteria) this;
        }

        public Criteria andCoursenameIsNull() {
            addCriterion("coursename is null");
            return (Criteria) this;
        }

        public Criteria andCoursenameIsNotNull() {
            addCriterion("coursename is not null");
            return (Criteria) this;
        }

        public Criteria andCoursenameEqualTo(String value) {
            addCriterion("coursename =", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameNotEqualTo(String value) {
            addCriterion("coursename <>", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameGreaterThan(String value) {
            addCriterion("coursename >", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameGreaterThanOrEqualTo(String value) {
            addCriterion("coursename >=", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameLessThan(String value) {
            addCriterion("coursename <", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameLessThanOrEqualTo(String value) {
            addCriterion("coursename <=", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameLike(String value) {
            addCriterion("coursename like", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameNotLike(String value) {
            addCriterion("coursename not like", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameIn(List<String> values) {
            addCriterion("coursename in", values, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameNotIn(List<String> values) {
            addCriterion("coursename not in", values, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameBetween(String value1, String value2) {
            addCriterion("coursename between", value1, value2, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameNotBetween(String value1, String value2) {
            addCriterion("coursename not between", value1, value2, "coursename");
            return (Criteria) this;
        }

        public Criteria andCourseteacherIsNull() {
            addCriterion("courseteacher is null");
            return (Criteria) this;
        }

        public Criteria andCourseteacherIsNotNull() {
            addCriterion("courseteacher is not null");
            return (Criteria) this;
        }

        public Criteria andCourseteacherEqualTo(String value) {
            addCriterion("courseteacher =", value, "courseteacher");
            return (Criteria) this;
        }

        public Criteria andCourseteacherNotEqualTo(String value) {
            addCriterion("courseteacher <>", value, "courseteacher");
            return (Criteria) this;
        }

        public Criteria andCourseteacherGreaterThan(String value) {
            addCriterion("courseteacher >", value, "courseteacher");
            return (Criteria) this;
        }

        public Criteria andCourseteacherGreaterThanOrEqualTo(String value) {
            addCriterion("courseteacher >=", value, "courseteacher");
            return (Criteria) this;
        }

        public Criteria andCourseteacherLessThan(String value) {
            addCriterion("courseteacher <", value, "courseteacher");
            return (Criteria) this;
        }

        public Criteria andCourseteacherLessThanOrEqualTo(String value) {
            addCriterion("courseteacher <=", value, "courseteacher");
            return (Criteria) this;
        }

        public Criteria andCourseteacherLike(String value) {
            addCriterion("courseteacher like", value, "courseteacher");
            return (Criteria) this;
        }

        public Criteria andCourseteacherNotLike(String value) {
            addCriterion("courseteacher not like", value, "courseteacher");
            return (Criteria) this;
        }

        public Criteria andCourseteacherIn(List<String> values) {
            addCriterion("courseteacher in", values, "courseteacher");
            return (Criteria) this;
        }

        public Criteria andCourseteacherNotIn(List<String> values) {
            addCriterion("courseteacher not in", values, "courseteacher");
            return (Criteria) this;
        }

        public Criteria andCourseteacherBetween(String value1, String value2) {
            addCriterion("courseteacher between", value1, value2, "courseteacher");
            return (Criteria) this;
        }

        public Criteria andCourseteacherNotBetween(String value1, String value2) {
            addCriterion("courseteacher not between", value1, value2, "courseteacher");
            return (Criteria) this;
        }

        public Criteria andCourselocaltionIsNull() {
            addCriterion("courselocaltion is null");
            return (Criteria) this;
        }

        public Criteria andCourselocaltionIsNotNull() {
            addCriterion("courselocaltion is not null");
            return (Criteria) this;
        }

        public Criteria andCourselocaltionEqualTo(String value) {
            addCriterion("courselocaltion =", value, "courselocaltion");
            return (Criteria) this;
        }

        public Criteria andCourselocaltionNotEqualTo(String value) {
            addCriterion("courselocaltion <>", value, "courselocaltion");
            return (Criteria) this;
        }

        public Criteria andCourselocaltionGreaterThan(String value) {
            addCriterion("courselocaltion >", value, "courselocaltion");
            return (Criteria) this;
        }

        public Criteria andCourselocaltionGreaterThanOrEqualTo(String value) {
            addCriterion("courselocaltion >=", value, "courselocaltion");
            return (Criteria) this;
        }

        public Criteria andCourselocaltionLessThan(String value) {
            addCriterion("courselocaltion <", value, "courselocaltion");
            return (Criteria) this;
        }

        public Criteria andCourselocaltionLessThanOrEqualTo(String value) {
            addCriterion("courselocaltion <=", value, "courselocaltion");
            return (Criteria) this;
        }

        public Criteria andCourselocaltionLike(String value) {
            addCriterion("courselocaltion like", value, "courselocaltion");
            return (Criteria) this;
        }

        public Criteria andCourselocaltionNotLike(String value) {
            addCriterion("courselocaltion not like", value, "courselocaltion");
            return (Criteria) this;
        }

        public Criteria andCourselocaltionIn(List<String> values) {
            addCriterion("courselocaltion in", values, "courselocaltion");
            return (Criteria) this;
        }

        public Criteria andCourselocaltionNotIn(List<String> values) {
            addCriterion("courselocaltion not in", values, "courselocaltion");
            return (Criteria) this;
        }

        public Criteria andCourselocaltionBetween(String value1, String value2) {
            addCriterion("courselocaltion between", value1, value2, "courselocaltion");
            return (Criteria) this;
        }

        public Criteria andCourselocaltionNotBetween(String value1, String value2) {
            addCriterion("courselocaltion not between", value1, value2, "courselocaltion");
            return (Criteria) this;
        }

        public Criteria andCoursetimeIsNull() {
            addCriterion("coursetime is null");
            return (Criteria) this;
        }

        public Criteria andCoursetimeIsNotNull() {
            addCriterion("coursetime is not null");
            return (Criteria) this;
        }

        public Criteria andCoursetimeEqualTo(String value) {
            addCriterion("coursetime =", value, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeNotEqualTo(String value) {
            addCriterion("coursetime <>", value, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeGreaterThan(String value) {
            addCriterion("coursetime >", value, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeGreaterThanOrEqualTo(String value) {
            addCriterion("coursetime >=", value, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeLessThan(String value) {
            addCriterion("coursetime <", value, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeLessThanOrEqualTo(String value) {
            addCriterion("coursetime <=", value, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeLike(String value) {
            addCriterion("coursetime like", value, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeNotLike(String value) {
            addCriterion("coursetime not like", value, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeIn(List<String> values) {
            addCriterion("coursetime in", values, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeNotIn(List<String> values) {
            addCriterion("coursetime not in", values, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeBetween(String value1, String value2) {
            addCriterion("coursetime between", value1, value2, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursetimeNotBetween(String value1, String value2) {
            addCriterion("coursetime not between", value1, value2, "coursetime");
            return (Criteria) this;
        }

        public Criteria andCoursepowerIsNull() {
            addCriterion("coursepower is null");
            return (Criteria) this;
        }

        public Criteria andCoursepowerIsNotNull() {
            addCriterion("coursepower is not null");
            return (Criteria) this;
        }

        public Criteria andCoursepowerEqualTo(String value) {
            addCriterion("coursepower =", value, "coursepower");
            return (Criteria) this;
        }

        public Criteria andCoursepowerNotEqualTo(String value) {
            addCriterion("coursepower <>", value, "coursepower");
            return (Criteria) this;
        }

        public Criteria andCoursepowerGreaterThan(String value) {
            addCriterion("coursepower >", value, "coursepower");
            return (Criteria) this;
        }

        public Criteria andCoursepowerGreaterThanOrEqualTo(String value) {
            addCriterion("coursepower >=", value, "coursepower");
            return (Criteria) this;
        }

        public Criteria andCoursepowerLessThan(String value) {
            addCriterion("coursepower <", value, "coursepower");
            return (Criteria) this;
        }

        public Criteria andCoursepowerLessThanOrEqualTo(String value) {
            addCriterion("coursepower <=", value, "coursepower");
            return (Criteria) this;
        }

        public Criteria andCoursepowerLike(String value) {
            addCriterion("coursepower like", value, "coursepower");
            return (Criteria) this;
        }

        public Criteria andCoursepowerNotLike(String value) {
            addCriterion("coursepower not like", value, "coursepower");
            return (Criteria) this;
        }

        public Criteria andCoursepowerIn(List<String> values) {
            addCriterion("coursepower in", values, "coursepower");
            return (Criteria) this;
        }

        public Criteria andCoursepowerNotIn(List<String> values) {
            addCriterion("coursepower not in", values, "coursepower");
            return (Criteria) this;
        }

        public Criteria andCoursepowerBetween(String value1, String value2) {
            addCriterion("coursepower between", value1, value2, "coursepower");
            return (Criteria) this;
        }

        public Criteria andCoursepowerNotBetween(String value1, String value2) {
            addCriterion("coursepower not between", value1, value2, "coursepower");
            return (Criteria) this;
        }

        public Criteria andCoursetypeIsNull() {
            addCriterion("coursetype is null");
            return (Criteria) this;
        }

        public Criteria andCoursetypeIsNotNull() {
            addCriterion("coursetype is not null");
            return (Criteria) this;
        }

        public Criteria andCoursetypeEqualTo(String value) {
            addCriterion("coursetype =", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeNotEqualTo(String value) {
            addCriterion("coursetype <>", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeGreaterThan(String value) {
            addCriterion("coursetype >", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeGreaterThanOrEqualTo(String value) {
            addCriterion("coursetype >=", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeLessThan(String value) {
            addCriterion("coursetype <", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeLessThanOrEqualTo(String value) {
            addCriterion("coursetype <=", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeLike(String value) {
            addCriterion("coursetype like", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeNotLike(String value) {
            addCriterion("coursetype not like", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeIn(List<String> values) {
            addCriterion("coursetype in", values, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeNotIn(List<String> values) {
            addCriterion("coursetype not in", values, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeBetween(String value1, String value2) {
            addCriterion("coursetype between", value1, value2, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeNotBetween(String value1, String value2) {
            addCriterion("coursetype not between", value1, value2, "coursetype");
            return (Criteria) this;
        }

        public Criteria andSelcountIsNull() {
            addCriterion("selcount is null");
            return (Criteria) this;
        }

        public Criteria andSelcountIsNotNull() {
            addCriterion("selcount is not null");
            return (Criteria) this;
        }

        public Criteria andSelcountEqualTo(Integer value) {
            addCriterion("selcount =", value, "selcount");
            return (Criteria) this;
        }

        public Criteria andSelcountNotEqualTo(Integer value) {
            addCriterion("selcount <>", value, "selcount");
            return (Criteria) this;
        }

        public Criteria andSelcountGreaterThan(Integer value) {
            addCriterion("selcount >", value, "selcount");
            return (Criteria) this;
        }

        public Criteria andSelcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("selcount >=", value, "selcount");
            return (Criteria) this;
        }

        public Criteria andSelcountLessThan(Integer value) {
            addCriterion("selcount <", value, "selcount");
            return (Criteria) this;
        }

        public Criteria andSelcountLessThanOrEqualTo(Integer value) {
            addCriterion("selcount <=", value, "selcount");
            return (Criteria) this;
        }

        public Criteria andSelcountIn(List<Integer> values) {
            addCriterion("selcount in", values, "selcount");
            return (Criteria) this;
        }

        public Criteria andSelcountNotIn(List<Integer> values) {
            addCriterion("selcount not in", values, "selcount");
            return (Criteria) this;
        }

        public Criteria andSelcountBetween(Integer value1, Integer value2) {
            addCriterion("selcount between", value1, value2, "selcount");
            return (Criteria) this;
        }

        public Criteria andSelcountNotBetween(Integer value1, Integer value2) {
            addCriterion("selcount not between", value1, value2, "selcount");
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