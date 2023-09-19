package com.jojoldu.book.spring.web.Controller;

import com.jojoldu.book.spring.Service.posts.ResourceSerivce;
import com.jojoldu.book.spring.web.dto.Resource.resourceCodeSaveDto;
import com.jojoldu.book.spring.web.dto.Resource.resourceInfoSaveDto;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/resource")
public class ResourceController {

    private final ResourceSerivce resourceSerivce;
    public ResourceController(ResourceSerivce resourceSerivce)
    {
        this.resourceSerivce = resourceSerivce;
    }

    @PostMapping("/infosave")
    public Long InfoSave(@RequestBody resourceInfoSaveDto requestDto )
    {
        return resourceSerivce.ResourceInfoSave(requestDto);
    }

    @PostMapping("/codesave")
    public Long CodeSave(@RequestBody resourceCodeSaveDto requestDto )
    {
        return resourceSerivce.ResourceCodeSave(requestDto);
    }

}
