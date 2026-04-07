package com.shopingcart.tryout.service.image;

import com.shopingcart.tryout.dto.ImageDto;
import com.shopingcart.tryout.exceptions.ResourceNotFoundException;
import com.shopingcart.tryout.model.Image;
import com.shopingcart.tryout.model.Product;
import com.shopingcart.tryout.repository.ImageRepository;
import com.shopingcart.tryout.service.ProductService.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor


public class ImageService implements IImageService {

    private final ImageRepository imageRepository;
    private IProductService productService;

    @Override
    public Image getImageById(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No image with id: "+ id));
    }

    @Override
    public void DeleteImageById(Long id) {
        imageRepository.findById(id).ifPresentOrElse(imageRepository :: delete, ()-> {throw new ResourceNotFoundException("No image with id: "+ id);});
    }


    @Override
    public List<ImageDto> saveImages(List<MultipartFile> files, Long productId) {
        Product product = productService.getProductById(productId);

        List<ImageDto> savedImageDto = new ArrayList<>();
        for (MultipartFile file : files) {
            try {
                Image image = new Image();
                image.setFileName(file.getOriginalFilename());
                image.setFileType(file.getContentType());
                image.setImage(file.getBytes());
                image.setProduct(product);

                String buildDownloadUrl = "/api/v1/images/image/download/";
                String downloadUrl = buildDownloadUrl+image.getId();
                image.setDownloadUrl(downloadUrl);
                Image savedImage = imageRepository.save(image);

                savedImage.setDownloadUrl(buildDownloadUrl+savedImage.getId());
                imageRepository.save(savedImage);

                ImageDto imageDto = new ImageDto();
                imageDto.setImageId(savedImage.getId());
                imageDto.setFileName(savedImage.getFileName());
                imageDto.setDownloadUrl(savedImage.getDownloadUrl());
                savedImageDto.add(imageDto);

            }   catch(IOException e){
                throw new RuntimeException(e.getMessage());
            }
        }
        return savedImageDto;
    }

    @Override
    public void updateImage(MultipartFile file, Long imageId) {
        Image image = getImageById(imageId);
        try {
            image.setFileName(file.getOriginalFilename());
            image.setFileType(file.getContentType());

            image.setImage(file.getBytes());

            imageRepository.save(image);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file bytes: " + e.getMessage());
        }
    }
}
