package com.details.Store.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.details.Store.model.userpersonaldetails;
import com.details.Store.repository.MySqlrepository;

@RestController
public class storecontroller {
    
    @Autowired
    MySqlrepository mySqlRepository;

    @GetMapping("/get-all-details")
    public List<userpersonaldetails> getalldetails(){
        return mySqlRepository.findAll();
    }

    
    @GetMapping("/get-details/{identity}")
    public userpersonaldetails getSingleAddress(@PathVariable("identity") Integer id){
        return mySqlRepository.findById(id).get();
    
    }

    @PostMapping("/post-details")
    public userpersonaldetails create(@RequestBody Map<String, String> body){
        String age = body.get("userage");
        String name = body.get("username");
        String occupation = body.get("occupation");
        String gender = body.get("gender");
        return mySqlRepository.save(new userpersonaldetails(name, Integer.parseInt(age), occupation, gender));
    }

    @PutMapping("/put-details/{id}")
    public userpersonaldetails updateEmployee(@PathVariable Integer id,@RequestBody userpersonaldetails employeeDetails) {
        userpersonaldetails updateEmployee = mySqlRepository.findById(id)
                .orElseThrow();

        updateEmployee.setUsername(employeeDetails.getUsername());
        updateEmployee.setUserage(employeeDetails.getUserage());
        updateEmployee.setOccupation(employeeDetails.getOccupation());
        updateEmployee.setGender(employeeDetails.getGender());
        
        return mySqlRepository.save(updateEmployee);


    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable String id){
        int Id = Integer.parseInt(id);
        mySqlRepository.deleteById(Id);
        return true;
    }

}