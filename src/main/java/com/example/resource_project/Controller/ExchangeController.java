package com.example.resource_project.Controller;


import com.example.resource_project.Service.ExchageService;
import com.example.resource_project.dto.Resource.ExchageInfoTbSaveDto;
import com.example.resource_project.dto.Resource.ExchageTbSaveDto;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/exchange")
public class ExchangeController {
    private final ExchageService exchageService;
    public ExchangeController(ExchageService exchageService)
    {
        this.exchageService = exchageService;
    }

    @PostMapping("/tbsave")
    public void TbSave(@RequestBody ExchageTbSaveDto requestDto)
    {
        exchageService.TbSave(requestDto);
    }

    @PostMapping("/infosave")
    public void InfoSave(@RequestBody ExchageInfoTbSaveDto requestDto)
    {
        exchageService.InfoSave(requestDto);
    }




}
