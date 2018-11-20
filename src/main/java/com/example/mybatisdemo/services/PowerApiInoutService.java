package com.example.mybatisdemo.services;

import com.example.mybatisdemo.Dao.PowerApiInoutDao;
import com.example.mybatisdemo.Dao.PoweronApiInoutXmlDao;
import com.example.mybatisdemo.domain.PoweronApiInout;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PowerApiInoutService {

    @Autowired
    private PowerApiInoutDao powerApiInoutDao;

    @Autowired
    private PoweronApiInoutXmlDao poweronApiInoutXmlDao;

    public PoweronApiInout selectAll(String keyValue){
       PoweronApiInout poweronApiInout =  powerApiInoutDao.selectAllByKeyValue(keyValue);
       return poweronApiInout;
    }

    public PoweronApiInout selectAllXml(String keyValue){
        PoweronApiInout poweronApiInout =  poweronApiInoutXmlDao.selectAllXmlByKeyValue(keyValue);
        return poweronApiInout;
    }

    public List<PoweronApiInout> selectList(){
        return poweronApiInoutXmlDao.selectList();
    }
}
