package com.example.resource_project.Controller;


import com.example.resource_project.Service.Resource_serivce;
import com.example.resource_project.dto.Resource.Resource_tb_save_dto;
import com.example.resource_project.dto.Resource.Resource_price_info_tb_save_dto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/resource")
public class Resource_controller {

    private final Resource_serivce resourceSerivce;
    public Resource_controller(Resource_serivce resourceSerivce)
    {
        this.resourceSerivce = resourceSerivce;
    }


    @PostMapping("/codesave")
    public int CodeSave(@RequestBody Resource_tb_save_dto requestDto )
    {
        return resourceSerivce.ResourceCodeSave(requestDto);
    }
    @PostMapping("/infosave")
//    public int InfoSave(@RequestBody List<Resource_price_info_tb_save_dto> requestDto )
    public int InfoSave(@RequestBody Resource_price_info_tb_save_dto requestDto )
    {
        return resourceSerivce.ResourceInfoSave(requestDto);
    }



}
