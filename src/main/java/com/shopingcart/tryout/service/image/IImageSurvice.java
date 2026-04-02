package com.shopingcart.tryout.service.image;

import com.shopingcart.tryout.model.Image;
import org.springframework.web.multipart.MultipartFile;

public interface IImageSurvice {
    Image getImage(Long id);
    void DeleteImageByid(Long id);
    Image saveImage(MultipartFile file, Long imageId);
    void updateImage(MultipartFile file,Long imageId);
}
