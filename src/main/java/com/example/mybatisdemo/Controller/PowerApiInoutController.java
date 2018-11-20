package com.example.mybatisdemo.Controller;

import com.example.mybatisdemo.domain.PoweronApiInout;
import com.example.mybatisdemo.services.PowerApiInoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PowerApiInoutController {

    @Autowired
    private  PowerApiInoutService powerApiInoutService;



    @RequestMapping("/test")
    public PoweronApiInout findAll(){
       PoweronApiInout poweronApiInout =  powerApiInoutService.selectAll("CPEC-ABLAA000099");
       return poweronApiInout;
    }

    @RequestMapping("/testXml")
    public PoweronApiInout findAllXml(){
        PoweronApiInout poweronApiInout =  powerApiInoutService.selectAllXml("CPEC-ABLAA000099");
        return poweronApiInout;
    }

    @GetMapping("/api")
    public List<PoweronApiInout> selectList(){
        return powerApiInoutService.selectList();
    }
}
