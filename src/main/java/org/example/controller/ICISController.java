package org.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.example.service.ICISService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Stanley Zhou on 2019/7/9.
 */
@RestController
@RequestMapping("/ICIS")
@Slf4j
public class ICISController {

    @Autowired
    ICISService icisService;

    @PostMapping("")
    public ResponseEntity query(@RequestBody(required = false) Map m) {
        log.info("search...param:{}", JSON.toJSONString(m));
        try {

            int start = Integer.parseInt(m.get("start").toString());
            int length = Integer.parseInt(m.get("length").toString());
            start = start / length + 1;
            Object patientName = m.get("patientName");
            if (!StringUtils.isEmpty(patientName)) {
                m.put("patientName", patientName.toString().toUpperCase().trim());
            }
            PageHelper.startPage(start, length);
            List<Map> query = icisService.query(m);
            PageInfo pageInfo = new PageInfo(query);
            JSONObject result = new JSONObject();
            result.put("recordsFiltered", pageInfo.getTotal());
            result.put("recordsTotal", pageInfo.getTotal());
            result.put("data", query);

//            ArrayList arrayList = new ArrayList();
//            result.put("recordsFiltered", 1);
//            result.put("recordsTotal",10);
//            HashMap map = new HashMap();
//            map.put("id",1);
//            map.put("patientClass","E");
//            arrayList.add(map);
//            result.put("data", arrayList);

            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            log.error("search error...", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
