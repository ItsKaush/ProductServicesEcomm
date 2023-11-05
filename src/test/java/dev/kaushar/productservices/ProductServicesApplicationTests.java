package dev.kaushar.productservices;

import com.mysql.cj.protocol.x.XProtocolDecoder;
import dev.kaushar.productservices.Inheritence.TablePerClass.*;
import dev.kaushar.productservices.Inheritence.TablePerClass.*;

import dev.kaushar.productservices.Inheritence.SingleTable.SingleTableInstructorRepo;
import dev.kaushar.productservices.Inheritence.SingleTable.SingleTableMentorRepo;
import dev.kaushar.productservices.Inheritence.SingleTable.SingleTableStudentRepo;
import dev.kaushar.productservices.Inheritence.SingleTable.SingleTableUserRepo;
import dev.kaushar.productservices.Inheritence.TablePerClass.TablePerClassInstructorRepo;
import dev.kaushar.productservices.Inheritence.TablePerClass.TablePerClassMentorRepo;
import dev.kaushar.productservices.Inheritence.TablePerClass.TablePerClassStudentRepo;
import dev.kaushar.productservices.Inheritence.TablePerClass.TablePerClassUserrepo;
import dev.kaushar.productservices.models.Category;
import dev.kaushar.productservices.models.Product;
import dev.kaushar.productservices.repositories.ProductRepository;
import dev.kaushar.productservices.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServicesApplicationTests {
//    @Autowired
//    private TablePerClassUserrepo userRepo;
//    @Autowired
//    private TablePerClassInstructorRepo instructorRepo;
//    @Autowired
//    private TablePerClassMentorRepo mentorRepo;
//    @Autowired
//    private TablePerClassStudentRepo studentRepo;
    @Test
    void contextLoads() {
    }

//    @Test
//    public void testInheritence(){
//        User user = new User();
//        user.setName("Sam");
//        user.setEmail("sam@gmail.com");
//        userRepo.save(user);
//
//        Mentor mentor = new Mentor();
//        mentor.setName("Pankaj");
//        mentor.setEmail("n@gmail.com");
//        mentor.setMentees(2);
//        mentor.setSession(4);
//        mentorRepo.save(mentor);
//
//        Instructor instructor = new Instructor();
//        instructor.setName("Naman");
//        instructor.setEmail("n@gmail.com");
//        instructor.setPopularity(20);
//        instructorRepo.save(instructor);
//
//        Student student = new Student();
//        student.setName("Kaushar");
//        student.setEmail("n@gmail.com");
//        student.setPsp(65);
//        student.setAttendence(88);
//        studentRepo.save(student);
//    }

//
//    @Autowired
//    private ProductService productService;

//    @Test
//    public void testAddProduct(){
//        Product product = new Product();
//        product.setTitle("test");
//        product.setPrice(400);
//        product.setDescription("test");
//        product.setImageUrl("http://test3");
//        Category category = new Category();
//        category.setName("electronics");
//        product.setCategory(category);
//
//    }



}
