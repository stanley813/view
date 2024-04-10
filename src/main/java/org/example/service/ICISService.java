package org.example.service;

import org.example.dao.ICISMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ICISService {

    @Autowired
    ICISMapper icisMapper;

    public List<Map> query(Map m) {
        return icisMapper.query(m);
    }

}
