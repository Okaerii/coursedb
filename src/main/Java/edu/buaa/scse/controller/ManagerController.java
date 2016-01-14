package edu.buaa.scse.controller;

import edu.buaa.scse.entity.*;
import edu.buaa.scse.entity.Class;
import edu.buaa.scse.service.ManagerService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wood on 2016/1/13.
 */
@Controller
@RequestMapping("/root")
@SessionAttributes("userObj")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
//    ��ʦ��Ϣ

    @RequestMapping("/teacher/info")
    public ModelAndView teacherinfo(@ModelAttribute("userObj") User u){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("teacherinfoROOT");
        modelAndView.addObject("teachers", managerService.getTeachers());
        return modelAndView;
    }
    @RequestMapping("/teacher/add")
    public ModelAndView teacheradd(@ModelAttribute("userObj") User u,@RequestParam(value = "id1",required = true) String id1,@RequestParam(required = true) String name,
                                  @RequestParam(required = true) Integer age,@RequestParam(required = true) String gender,@RequestParam(required = false) String title,@RequestParam(required = false) String phonenum){
        Teacher teacher = new Teacher();
        teacher.setId(id1);
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
    @RequestMapping("/teacher/delete/{id1}")
    public ModelAndView teacherdelete(@ModelAttribute("userObj") User u,@PathVariable("id1") String id){
        managerService.deleteTeacher(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("teacherinfoROOT");
        modelAndView.addObject("teachers", managerService.getTeachers());
        return modelAndView;
    }
//    ��ʦ����

    @RequestMapping("/teacher/evaluate")
    public ModelAndView teacherevaluate(@ModelAttribute("userObj") User u){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("teacherevaluateROOT");
        modelAndView.addObject("teacherevaluates", managerService.getTeacherEvaluates());
        return modelAndView;
    }
    @RequestMapping("/teacher/evaluate/add")
    public ModelAndView teacherevaluateadd(@ModelAttribute("userObj") User u,@RequestParam(required = true) String teacher_id,@RequestParam(required = true) String course_id,
                                           @RequestParam(required = false) String level){
        TeacherEvaluate teacherEvaluate = new TeacherEvaluate();
        teacherEvaluate.setCourse_id(course_id);
        teacherEvaluate.setTeacher_id(teacher_id);
        teacherEvaluate.setLevel(level);
        managerService.addTeacherEvaluate(teacherEvaluate);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("teacherevaluateROOT");
        modelAndView.addObject("teacherevaluates", managerService.getTeacherEvaluates());
        return modelAndView;
    }
    @RequestMapping("/teacher/evaluate/delete/{id1}")
    public ModelAndView teacherevaluatedelete(@ModelAttribute("userObj") User u,@PathVariable("id1") String id){
        managerService.deleteTeacherEvaluate(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("teacherevaluateROOT");
        modelAndView.addObject("teacherevaluates", managerService.getTeacherEvaluates());
        return modelAndView;
    }

//        ѧ����Ϣ
    @RequestMapping("/students/info")
    public ModelAndView studentinfo(@ModelAttribute("userObj") User u){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentinfoROOT");
        modelAndView.addObject("students", managerService.getStudents());
        return modelAndView;
    }
    @RequestMapping("/student/add")
    public ModelAndView studentadd(@ModelAttribute("userObj") User u,@RequestParam(value = "id1",required = true) String id1,@RequestParam(required = true) String name,
                                  @RequestParam(required = true) int age,@RequestParam(required = true) String gender,@RequestParam(required = false) String classid){
        Student student = new Student();
        student.setId(id1);
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
    @RequestMapping("/student/delete/{id1}")
    public ModelAndView studentdelete(@ModelAttribute("userObj") User u,@PathVariable("id1") String id){
        managerService.deleteStudent(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentinfoROOT");
        modelAndView.addObject("students", managerService.getStudents());
        return modelAndView;
    }
    //�γ�
    @RequestMapping("/course/info")
    public ModelAndView courseinfo(@ModelAttribute("userObj") User u){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("courseinfoROOT");
        modelAndView.addObject("courses", managerService.getCourses());
        return modelAndView;
    }
    @RequestMapping("/course/add")
    public ModelAndView courseadd(@ModelAttribute("userObj") User u,@RequestParam(value = "id1",required = true) String id1,@RequestParam(required = true) String name,
                                     @RequestParam(required = false) Integer time, @RequestParam(required = false) String teacherid,@RequestParam(required = false) String classroom){
        Course course = new Course();
        course.setId(id1);
        course.setName(name);
        course.setTime(time);
        Teacher teacher = new Teacher();
        teacher.setId(teacherid);
        List<Teacher> teachers =new ArrayList<Teacher>();
        teachers.add(teacher);
        Classroom classroom1 = new Classroom();
        classroom1.setId(classroom);
        course.setClassroom(classroom1);
        course.setTeachers(teachers);
        managerService.addCourse(course);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("courseinfoROOT");
        modelAndView.addObject("courses", managerService.getCourses());
        return modelAndView;
    }
    @RequestMapping("/course/delete/{id1}")
    public ModelAndView coursedelete(@ModelAttribute("userObj") User u,@PathVariable("id1") String id){
        managerService.deleteCourse(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("courseinfoROOT");
        modelAndView.addObject("courses", managerService.getCourses());
        return modelAndView;
    }
//    ���Ҳ���
    @RequestMapping("/classroom/info")
    public ModelAndView classroominfo(@ModelAttribute("userObj") User u){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classroominfoROOT");
       modelAndView.addObject("classrooms", managerService.getClassrooms());
        return modelAndView;
    }
    @RequestMapping("/classroom/add")
    public ModelAndView classroomadd(@ModelAttribute("userObj") User u,@RequestParam(value = "id1" ,required = true) String id1,@RequestParam(required = true) String location,
                                     @RequestParam(value = "size",defaultValue = "0") Integer size){
        Classroom classroom = new Classroom();
        classroom.setId(id1);
        classroom.setLocation(location);
        classroom.setSize(size);
        managerService.addClassroom(classroom);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classroominfoROOT");
        modelAndView.addObject("classrooms", managerService.getClassrooms());
        return modelAndView;
    }
    @RequestMapping("/classroom/delete/{id1}")
    public ModelAndView classroomdelete(@ModelAttribute("userObj") User u,@PathVariable("id1") String id){
        managerService.deleteClassroom(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classroominfoROOT");
        modelAndView.addObject("classrooms", managerService.getClassrooms());
        return modelAndView;
    }
//    �༶
    @RequestMapping("/class/info")
      public ModelAndView classinfo(@ModelAttribute("userObj") User u){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classinfoROOT");
        modelAndView.addObject("classes", managerService.getClasses());
        return modelAndView;
    }
    @RequestMapping("/class/add")
    public ModelAndView classadd(@ModelAttribute("userObj") User u,@RequestParam(value ="id1",required = true) String id1,@RequestParam(required = false) String monitorid,
                                     @RequestParam(required = false) String departmentid){
        Class class1 = new Class();
        class1.setId(id1);
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
    @RequestMapping("/class/delete/{id1}")
    public ModelAndView classdelete(@ModelAttribute("userObj") User u,@PathVariable("id1") String id){
        managerService.deleteClass(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classinfoROOT");
        modelAndView.addObject("classes", managerService.getClasses());
        return modelAndView;
    }
//    �ɼ�
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
        grade1.setGrades(grade);
        managerService.addGrade(grade1);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gradeinfoROOT");
        modelAndView.addObject("grades", managerService.getGrades());
        return modelAndView;
    }
    @RequestMapping("/grade/delete/{id1}")
    public ModelAndView gradedelete(@ModelAttribute("userObj") User u,@PathVariable("id1") String id){
        managerService.deleteGrade(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gradeinfoROOT");
        modelAndView.addObject("grades", managerService.getGrades());
        return modelAndView;
    }
//Ժϵ��Ϣ
    @RequestMapping("/department/info")
    public ModelAndView departmentinfo(@ModelAttribute("userObj") User u){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("departmentinfoROOT");
        modelAndView.addObject("departments", managerService.getDepartments());
        return modelAndView;
    }
    @RequestMapping("/department/add")
    public ModelAndView departmentadd(@ModelAttribute("userObj") User u,@RequestParam(value = "id1",required = true) String id1,@RequestParam(required = true) String name,@RequestParam(required = false) String chairman,
                                 @RequestParam(required = false) String phonenum){
        Department department = new Department();
        department.setId(id1);
       department.setName(name);
        department.setChairman(chairman);
        department.setPhonenum(phonenum);
        managerService.addDepartment(department);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("departmentinfoROOT");
        modelAndView.addObject("departments", managerService.getDepartments());
        return modelAndView;
    }
    @RequestMapping("/department/delete/{id1}")
    public ModelAndView departmentdelete(@ModelAttribute("userObj") User u,@PathVariable("id1") String id){
        managerService.deleteDepartment(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("departmentinfoROOT");
        modelAndView.addObject("departments", managerService.getDepartments());
        return modelAndView;
    }
}
