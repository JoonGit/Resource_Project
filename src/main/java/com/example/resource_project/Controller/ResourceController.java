package com.example.resource_project.Controller;


import com.example.resource_project.Entity.ResourcePriceInfoTb;
import com.example.resource_project.Service.ResourceSerivce;
import com.example.resource_project.dto.Resource.ResourceTbSaveDto;
import com.example.resource_project.dto.Resource.ResourcePriceInfoTbSaveDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/resource")
public class ResourceController {

    private final ResourceSerivce resourceSerivce;
    public ResourceController(ResourceSerivce resourceSerivce)
    {
        this.resourceSerivce = resourceSerivce;
    }


    @PostMapping("/tbsave")
    public int TbSave(@RequestBody ResourceTbSaveDto requestDto )
    {
        return resourceSerivce.ResourceCodeSave(requestDto);
    }
    @PostMapping("/infosave")
    public int InfoSave(@RequestBody List<ResourcePriceInfoTbSaveDto> requestDto )
    {
        return resourceSerivce.ResourceInfoSave(requestDto);
    }
    @GetMapping("/all")
    public ResponseEntity<Object> All()
    {
        List<ResourcePriceInfoTb> result = resourceSerivce.ResourceAll();
        return ResponseEntity.ok().body(
                result);
    }



}
