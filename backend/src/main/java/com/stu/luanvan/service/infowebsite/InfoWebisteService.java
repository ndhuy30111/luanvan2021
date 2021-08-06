package com.stu.luanvan.service.infowebsite;

import com.stu.luanvan.model.infowebsite.InfoWebsiteModel;
import com.stu.luanvan.repository.InfoWebsiteRepository;
import com.stu.luanvan.response.InfoWebsiteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoWebisteService {
    @Autowired private InfoWebsiteRepository infoWebsiteRepository;


    public InfoWebsiteModel getInfoWebsite(){
        return infoWebsiteRepository.findAll().get(1);
    }
    public InfoWebsiteModel updateInfoWebsite(InfoWebsiteRequest infoWebsiteRequest){
        var infoWebsite = infoWebsiteRepository.findAll().get(1);
        if(infoWebsite ==null){
            infoWebsite = new InfoWebsiteModel(infoWebsiteRequest);
        }else{
            infoWebsite.edit(infoWebsiteRequest);
        }
        infoWebsiteRepository.save(infoWebsite);
        return infoWebsite;
    }
}
