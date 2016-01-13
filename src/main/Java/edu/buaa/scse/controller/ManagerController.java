package edu.buaa.scse.controller;

import edu.buaa.scse.entity.*;
import edu.buaa.scse.entity.Class;
import edu.buaa.scse.service.ManagerService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wood on 2016/1/13.
 */
@Controller
@RequestMapping("/root")
@SessionAttributes("userObj")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
//    教师信息

    @RequestMapping("/teacher/info")
    public ModelAndView teacherinfo(@ModelAttribute("userObj") User u){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("teacherinfoROOT");
        modelAndView.addObject("teachers", managerService.getTeachers());
        return modelAndView;
    }
    @RequestMapping("/teacher/add")
    public ModelAndView teacheradd(@ModelAttribute("userObj") User u,@RequestParam(required = true) String id,@RequestParam(required = true) String name,
                                  @RequestParam(required = true) Integer age,@RequestParam(required = true) String gender,@RequestParam(required = false) String title,@RequestParam(required = false) String phonenum){
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setName(name);
        teacher.setAge(age);
        teacher.setGender(gender);
        teacher.setTitle(title);
        teacher.setPhonenum(phonenum);
        managerService.addTeacher(teacher);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("teacherinfoROOT");
        modelAndView.addObject("teachers", managerService.getTeachers());
        return modelAndView;
    }
    @RequestMapping("/teacher/delete/{id}")
    public ModelAndView teacherdelete(@ModelAttribute("userObj") User u,@PathVariable("id") String id){
        managerService.deleteClassroom(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("teacherinfoROOT");
        modelAndView.addObject("teachers", managerService.getTeachers());
        return modelAndView;
    }
//    教师评价

    @RequestMapping("/teacher/evaluate")
    public ModelAndView teacherevaluate(@ModelAttribute("userObj") User u){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("teacherevaluateROOT");
        modelAndView.addObject("teacherevaluates", managerService.getTeacherEvaluates());
        return modelAndView;
    }
    @RequestMapping("/teacher/evaluate/add")
    public ModelAndView teacherevaluateadd(@ModelAttribute("userObj") User u,@RequestParam(required = true) String teacher_id,@RequestParam(required = true) String course_id,
                                           @RequestParam(required = false) Integer level){
        TeacherEvaluate teacherEvaluate = new TeacherEvaluate();
        teacherEvaluate.setCourse_id(course_id);
        teacherEvaluate.setTeacher_id(teacher_id);
        managerService.addTeacherEvaluate(teacherEvaluate);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("teacherevaluateROOT");
        modelAndView.addObject("teacherevaluates", managerService.getTeacherEvaluates());
        return modelAndView;
    }
    @RequestMapping("/teacher/evaluate/delete/{id}")
    public ModelAndView teacherevaluatedelete(@ModelAttribute("userObj") User u,@PathVariable("id") String id){
        managerService.deleteTeacherEvaluate(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("teacherevaluateROOT");
        modelAndView.addObject("teacherevaluates", managerService.getTeacherEvaluates());
        return modelAndView;
    }

//        学生信息
    @RequestMapping("/students/info")
    public ModelAndView studentinfo(@ModelAttribute("userObj") User u){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentinfoROOT");
        modelAndView.addObject("students", managerService.getStudents());
        return modelAndView;
    }
    @RequestMapping("/student/add")
    public ModelAndView studentadd(@ModelAttribute("userObj") User u,@RequestParam(required = true) String id,@RequestParam(required = true) String name,
                                  @RequestParam(required = true) int age,@RequestParam(required = true) String gender,@RequestParam(required = false) String classid){
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setGender(gender);
        edu.buaa.scse.entity.Class _class = new edu.buaa.scse.entity.Class();
        _class.setId(classid);
        student.setClassid(_class);
        Classroom classroom1 = new Classroom();
        managerService.addStudent(student);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentinfoROOT");
        modelAndView.addObject("students", managerService.getStudents());
        return modelAndView;
    }
    @RequestMapping("/student/delete/{id}")
    public ModelAndView studentdelete(@ModelAttribute("userObj") User u,@PathVariable("id") String id){
        managerService.deleteClassroom(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentinfoROOT");
        modelAndView.addObject("students", managerService.getStudents());
        return modelAndView;
    }
    //课程
    @RequestMapping("/course/info")
    public ModelAndView courseinfo(@ModelAttribute("userObj") User u){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("courseinfoROOT");
        modelAndView.addObject("courses", managerService.getCourses());
        return modelAndView;
    }
    @RequestMapping("/course/add")
    public ModelAndView courseadd(@ModelAttribute("userObj") User u,@RequestParam(required = true) String id,@RequestParam(required = true) String name,
                                     @RequestParam(required = false) Integer time,@RequestParam(required = false) String classroom){
        Course course = new Course();
        course.setId(id);
        course.setName(name);
        course.setTime(time);
        Classroom classroom1 = new Classroom();
        course.setClassroom(classroom1);
        managerService.addCourse(course);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("courseinfoROOT");
        modelAndView.addObject("courses", managerService.getCourses());
        return modelAndView;
    }
    @RequestMapping("/course/delete/{id}")
    public ModelAndView coursedelete(@ModelAttribute("userObj") User u,@PathVariable("id") String id){
        managerService.deleteClassroom(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("courseinfoROOT");
        modelAndView.addObject("courses", managerService.getCourses());
        return modelAndView;
    }
//    教室操作
    @RequestMapping("/classroom/info")
    public ModelAndView classroominfo(@ModelAttribute("userObj") User u){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classroominfoROOT");
       modelAndView.addObject("classrooms", managerService.getClassrooms());
        return modelAndView;
    }
    @RequestMapping("/classroom/add")
    public ModelAndView classroomadd(@ModelAttribute("userObj") User u,@RequestParam(required = true) String id,@RequestParam(required = true) String location,
                                     @RequestParam(value = "size",defaultValue = "0") Integer size){
        Classroom classroom = new Classroom();
        classroom.setId(id);
        classroom.setLocation(location);
        classroom.setSize(size);
        managerService.addClassroom(classroom);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classroominfoROOT");
        modelAndView.addObject("classrooms", managerService.getClassrooms());
        return modelAndView;
    }
    @RequestMapping("/classroom/delete/{id}")
    public ModelAndView classroomdelete(@ModelAttribute("userObj") User u,@PathVariable("id") String id){
        managerService.deleteClassroom(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classroominfoROOT");
        modelAndView.addObject("classrooms", managerService.getClassrooms());
        return modelAndView;
    }
//    班级
    @RequestMapping("/class/info")
      public ModelAndView classinfo(@ModelAttribute("userObj") User u){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classinfoROOT");
        modelAndView.addObject("classes", managerService.getClasses());
        return modelAndView;
    }
    @RequestMapping("/class/add")
    public ModelAndView classadd(@ModelAttribute("userObj") User u,@RequestParam(required = true) String id,@RequestParam(required = false) String monitorid,
                                     @RequestParam(required = false) String departmentid){
        Class class1 = new Class();
        class1.setId(id);
        Department department = new Department();
        department.setId(departmentid);
        class1.setMonitorid(monitorid);
        class1.setDepartmentid(department);
        managerService.addClass(class1);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classinfoROOT");
        modelAndView.addObject("classes", managerService.getClasses());
        return modelAndView;
    }
    @RequestMapping("/class/delete/{id}")
    public ModelAndView classdelete(@ModelAttribute("userObj") User u,@PathVariable("id") String id){
        managerService.deleteClass(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classinfoROOT");
        modelAndView.addObject("classes", managerService.getClasses());
        return modelAndView;
    }
//    成绩
    @RequestMapping("/grade/info")
    public ModelAndView  gradeinfo(@ModelAttribute("userObj") User u){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gradeinfoROOT");
        modelAndView.addObject("grades", managerService.getGrades());
        return modelAndView;
    }
    @RequestMapping("/grade/add")
    public ModelAndView gradeadd(@ModelAttribute("userObj") User u,@RequestParam(required = true) String student_id,@RequestParam(required = true) String course_id,
                                           @RequestParam(required = true) Integer grade){
       Grade grade1 = new Grade();
        grade1.setCourse_id(course_id);
        grade1.setStudent_id(student_id);
        managerService.addGrade(grade1);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gradeROOT");
        modelAndView.addObject("grades", managerService.getGrades());
        return modelAndView;
    }
    @RequestMapping("/grade/delete/{id}")
    public ModelAndView gradedelete(@ModelAttribute("userObj") User u,@PathVariable("id") String id){
        managerService.deleteGrade(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gradeROOT");
        modelAndView.addObject("grades", managerService.getGrades());
        return modelAndView;
    }
//院系信息
    @RequestMapping("/department/info")
    public ModelAndView departmentinfo(@ModelAttribute("userObj") User u){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("departmentinfoROOT");
        modelAndView.addObject("departments", managerService.getDepartments());
        return modelAndView;
    }
    @RequestMapping("/department/add")
    public ModelAndView departmentadd(@ModelAttribute("userObj") User u,@RequestParam(required = true) String id,@RequestParam(required = true) String name,@RequestParam(required = false) String chairman,
                                 @RequestParam(required = false) String phonenum){
        Department department = new Department();
        department.setId(id);
       department.setName(name);
        department.setChairman(chairman);
        department.setPhonenum(phonenum);
        managerService.addDepartment(department);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("departmentinfoROOT");
        modelAndView.addObject("departments", managerService.getDepartments());
        return modelAndView;
    }
    @RequestMapping("/department/delete/{id}")
    public ModelAndView departmentdelete(@ModelAttribute("userObj") User u,@PathVariable("id") String id){
        managerService.deleteDepartment(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("departmentinfoROOT");
        modelAndView.addObject("departments", managerService.getDepartments());
        return modelAndView;
    }
}
