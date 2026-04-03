package com.shopingcart.tryout.service.image;

import com.shopingcart.tryout.dto.ImageDto;
import com.shopingcart.tryout.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    Image getImage(Long id);
    void DeleteImageByid(Long id);
    List<ImageDto> saveImages(List<MultipartFile> file, Long imageId);
    void updateImage(List<MultipartFile> file,Long imageId);
}
