package com.stu.luanvan.service.infowebsite;

import com.stu.luanvan.model.infowebsite.BannerModel;
import com.stu.luanvan.repository.BannerRepository;
import com.stu.luanvan.response.BannerRequest;
import com.stu.luanvan.service.cloudinary.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class BannerService {
    @Autowired
    BannerRepository bannerRepository;
    @Autowired
    CloudinaryService cloudinaryService;
    public Collection<BannerModel> getBannerList(){

        return bannerRepository.findAll();
    }

    public BannerModel psotBanner(BannerRequest bannerRequest){
        var file = cloudinaryService.uploadFile(bannerRequest.getFile(), UUID.randomUUID().toString()) ;
        var bannerModel = new BannerModel(file,bannerRequest.getSort());
        return bannerRepository.save(bannerModel);
    }

}
