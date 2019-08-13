package com.example.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
/*    private List<Course> topics = new ArrayList<>(Arrays.asList(
            new Course("Spring", "Spring Framework", "Spring Framework Description"),
            new Course("JAVA", "Core JAVA", "Core JAVA Description"),
            new Course("Javascript", "Javascript", "Javascript Description 1"),
            new Course("Javascript", "Javascript", "Javascript Description 2")
    ));

    public List<Course> getCourses() {
        return topics;
    }

    public Course getCourse(String id) {
        return topics.stream().filter(topic -> topic.getId().equals(id)).findAny().get();
    }

    public void addCourse(Course topic) {
        topics.add(topic);
    }

    public void updateCourse(Course topic, String id) {
        for (int i = 0; i < topics.size(); i++) {
            Course topic1 = topics.get(i);
            if (topic1.getId().equals(id)) {
                topics.set(i,topic);
                return;
            }
        }
    }

    public void deleteCourse(String id) {
        topics.removeIf(topic -> topic.getId().equals(id));
    }*/


    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourses(String topicId) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id) {
        return courseRepository.findById(id).get();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
