package com.test.register.registration1.entity;

public class Assignment {
    private Long facultyId;
    private Long courseId;

    public Assignment() {}

    public Assignment(Long facultyId, Long courseId) {
        this.facultyId = facultyId;
        this.courseId = courseId;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
