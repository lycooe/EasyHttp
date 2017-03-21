package com.lewis.easyhttp.samples.model;

import java.util.List;

public class CourseListModel {
    public int currentPageNO;
    public int pageSize;
    public int totalRecord;
    public int totalPage;
    public List<Course> courses;

    public static class Course extends BaseCourseModel {
        public int id;
        public String fromSchool;
        public String recommendedByCourse;
    }
}
