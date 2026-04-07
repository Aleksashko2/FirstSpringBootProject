package com.shopingcart.tryout.service.image;

import com.shopingcart.tryout.dto.ImageDto;
import com.shopingcart.tryout.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    Image getImageById(Long id);
    void DeleteImageById(Long id);
    List<ImageDto> saveImages(List<MultipartFile> file, Long imageId);
    void updateImage(MultipartFile file,Long imageId);
}
