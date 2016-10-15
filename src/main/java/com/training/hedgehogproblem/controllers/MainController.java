package com.training.hedgehogproblem.controllers;

import com.training.hedgehogproblem.data.ProcessingResultDto;
import com.training.hedgehogproblem.process.HedgehogWalk;
import com.training.hedgehogproblem.util.HedgehogWalkHelper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sony on 10/12/2016.
 */
@Controller
@EnableAutoConfiguration
public class MainController {
    @RequestMapping(value = "/hedgehog", method = RequestMethod.GET)
    public String mainPage(Model model) {
        return "main";
    }

    @RequestMapping(value = "/hedgehog/formProcess", method = RequestMethod.POST, consumes = "multipart/form-data")
    @ResponseBody
    public ResponseEntity<ProcessingResultDto> process(HttpServletRequest request, HttpServletResponse response,
                                                       @RequestParam(name = "loadFile") MultipartFile file) throws IOException {

        int[][] array = HedgehogWalkHelper.createArrayFromFileStream(file.getInputStream());
        if (array != null) {
            HedgehogWalk hedgehogWalk = new HedgehogWalk(array);
            int result = hedgehogWalk.walk();
            if (result != 0) {
                ProcessingResultDto dto = new ProcessingResultDto(array, hedgehogWalk.getWalkField(), result);
                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(dto);
            }
        }

        return new ResponseEntity<ProcessingResultDto>(HttpStatus.NO_CONTENT);
    }
}
