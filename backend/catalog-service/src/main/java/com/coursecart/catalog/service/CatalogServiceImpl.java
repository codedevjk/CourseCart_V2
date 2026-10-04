package com.coursecart.catalog.service;

import com.coursecart.catalog.dto.*;
import com.coursecart.catalog.entity.Category;
import com.coursecart.catalog.entity.Course;
import com.coursecart.catalog.entity.CourseStatus;
import com.coursecart.catalog.entity.Lesson;
import com.coursecart.catalog.exception.CatalogServiceException;
import com.coursecart.catalog.exception.ErrorMessages;
import org.springframework.http.HttpStatus;
import com.coursecart.catalog.repository.CategoryRepository;
import com.coursecart.catalog.repository.CourseRepository;
import com.coursecart.catalog.repository.LessonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CategoryRepository categoryRepository;
    private final CourseRepository courseRepository;
    private final LessonRepository lessonRepository;
    private final ModelMapper modelMapper;

    public CatalogServiceImpl(CategoryRepository categoryRepository, CourseRepository courseRepository, LessonRepository lessonRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.courseRepository = courseRepository;
        this.lessonRepository = lessonRepository;
        this.modelMapper = modelMapper;
    }

    // --- CATEGORIES ---

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(this::mapToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CategoryDTO createCategory(CategoryRequest request) {
        if (categoryRepository.findByName(request.getName()).isPresent()) {
            throw new CatalogServiceException(HttpStatus.CONFLICT, ErrorMessages.CATEGORY_NAME_EXISTS);
        }
        Category category = new Category();
        category.setName(request.getName());
        Category saved = categoryRepository.save(category);
        return mapToCategoryDTO(saved);
    }

    @Override
    @Transactional
    public CategoryDTO updateCategory(Long id, CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CatalogServiceException(HttpStatus.NOT_FOUND, ErrorMessages.CATEGORY_NOT_FOUND));

        if (!category.getName().equals(request.getName()) && categoryRepository.findByName(request.getName()).isPresent()) {
            throw new CatalogServiceException(HttpStatus.CONFLICT, ErrorMessages.CATEGORY_NAME_EXISTS);
        }

        category.setName(request.getName());
        Category updated = categoryRepository.save(category);
        return mapToCategoryDTO(updated);
    }

    @Override
    @Transactional
        public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CatalogServiceException(HttpStatus.NOT_FOUND, ErrorMessages.CATEGORY_NOT_FOUND));
        List<Course> attachedCourses = courseRepository.findByCategoryId(id);
        
        boolean hasActiveCourses = attachedCourses.stream()
                .anyMatch(course -> course.getStatus() == CourseStatus.ACTIVE);
                
        if (hasActiveCourses) {
            throw new CatalogServiceException(HttpStatus.CONFLICT, ErrorMessages.CATEGORY_HAS_ACTIVE_COURSES);
        }
        categoryRepository.delete(category);
    }

    // --- COURSES PUBLIC ---

    @Override
    public Page<CourseDTO> getActiveCourses(Pageable pageable, Long categoryId, String title) {
        Page<Course> courses;
        if (categoryId != null && title != null && !title.isEmpty()) {
            courses = courseRepository.findByStatusAndCategoryIdAndTitleContainingIgnoreCase(CourseStatus.ACTIVE, categoryId, title, pageable);
        } else if (categoryId != null) {
            courses = courseRepository.findByStatusAndCategoryId(CourseStatus.ACTIVE, categoryId, pageable);
        } else if (title != null && !title.isEmpty()) {
            courses = courseRepository.findByStatusAndTitleContainingIgnoreCase(CourseStatus.ACTIVE, title, pageable);
        } else {
            courses = courseRepository.findByStatus(CourseStatus.ACTIVE, pageable);
        }
        return courses.map(this::mapToCourseDTO);
    }

    @Override
    public CourseDetailDTO getActiveCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CatalogServiceException(HttpStatus.NOT_FOUND, ErrorMessages.COURSE_NOT_FOUND));

        return mapToCourseDetailDTO(course);
    }

    // --- COURSES ADMIN ---

    @Override
    public List<CourseDTO> getAllCoursesAdmin() {
        throw new UnsupportedOperationException("TODO[TRAINEE]: Implement getAllCoursesAdmin");
    }

    @Override
    @Transactional
    public CourseDTO createCourse(CourseRequest request) {
        throw new UnsupportedOperationException("TODO[TRAINEE]: Implement createCourse");
    }

    @Override
    @Transactional
    public CourseDTO updateCourse(Long id, CourseRequest request) {
        throw new UnsupportedOperationException("TODO[TRAINEE]: Implement updateCourse");
    }

    @Override
    @Transactional
    public CourseDTO updateCourseStatus(Long id, CourseStatusRequest request) {
        throw new UnsupportedOperationException("TODO[TRAINEE]: Implement updateCourseStatus");
    }

    @Override
    @Transactional
        public void deleteCourse(Long id) {
        throw new UnsupportedOperationException("TODO[TRAINEE]: Implement deleteCourse");
    }

    @Override
    public long countActiveCourses() {
        throw new UnsupportedOperationException("TODO[TRAINEE]: Implement countActiveCourses for Admin Dashboard");
    }

    // --- LESSONS ---

    @Override
    public List<LessonDTO> getLessonsForCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CatalogServiceException(HttpStatus.NOT_FOUND, ErrorMessages.COURSE_NOT_FOUND));
        return lessonRepository.findByCourseIdOrderByDisplayOrderAsc(course.getId()).stream()
                .map(this::mapToLessonDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public LessonDTO createLesson(Long courseId, LessonRequest request) {
        throw new UnsupportedOperationException("TODO[TRAINEE]: Implement createLesson");
    }

    @Override
    @Transactional
    public LessonDTO updateLesson(Long courseId, Long lessonId, LessonRequest request) {
        throw new UnsupportedOperationException("TODO[TRAINEE]: Implement updateLesson");
    }

    @Override
    @Transactional
    public void deleteLesson(Long courseId, Long lessonId) {
        throw new UnsupportedOperationException("TODO[TRAINEE]: Implement deleteLesson");
    }

    // --- MAPPERS ---

    private CategoryDTO mapToCategoryDTO(Category category) {
        if (category == null) {
            return null;
        }
        return modelMapper.map(category, CategoryDTO.class);
    }

    private CourseDTO mapToCourseDTO(Course course) {
        return modelMapper.map(course, CourseDTO.class);
    }

    private CourseDetailDTO mapToCourseDetailDTO(Course course) {
        CourseDetailDTO dto = modelMapper.map(course, CourseDetailDTO.class);
        List<LessonDTO> lessons = lessonRepository.findByCourseIdOrderByDisplayOrderAsc(course.getId())
                .stream()
                .map(this::mapToLessonDTO)
                .collect(Collectors.toList());
        dto.setLessons(lessons);
        return dto;
    }

    private LessonDTO mapToLessonDTO(Lesson lesson) {
        return modelMapper.map(lesson, LessonDTO.class);
    }
}







