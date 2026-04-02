package com.shopingcart.tryout.service.image;

import com.shopingcart.tryout.model.Image;
import com.shopingcart.tryout.repository.ImageRepository;
import com.shopingcart.tryout.service.ProductSerice.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@RequiredArgsConstructor


public class ImageService implements IImageSurvice{

    private final ImageRepository imageRepository;
    private IProductService productService;


    @Override
    public Image getImage(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    public void DeleteImageByid(Long id) {

    }

    @Override
    public Image saveImage(MultipartFile file, Long imageId) {
        return null;
    }

    @Override
    public void updateImage(MultipartFile file, Long imageId) {

    }
}
