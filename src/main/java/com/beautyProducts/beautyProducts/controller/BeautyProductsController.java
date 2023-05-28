package com.beautyProducts.beautyProducts.controller;

import com.beautyProducts.beautyProducts.DTO.BeautyProductsDTO;
import com.beautyProducts.beautyProducts.model.BeautyProducts;
import com.beautyProducts.beautyProducts.service.BeautyProductsService;
import jakarta.mail.MessagingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/beautyProducts")
public class BeautyProductsController {
    @Autowired
    private BeautyProductsService beautyProductsService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/findAll")
    public List<BeautyProductsDTO> findAllBeautyProducts(){
        List<BeautyProducts> beautyProducts1 = beautyProductsService.findAllBeautyProducts();
        List<BeautyProductsDTO> beautyProductsDTO = beautyProducts1.stream().map(beautyProducts ->
               modelMapper.map(beautyProducts,BeautyProductsDTO.class)).collect(Collectors.toList());
        return beautyProductsDTO;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity findBeautyProductsById(@PathVariable Long id){
        Optional<BeautyProducts> beautyProducts = beautyProductsService.findBeautyProductsById(id);
        BeautyProductsDTO beautyProductsDTO = modelMapper.map(beautyProducts, BeautyProductsDTO.class);
        return ResponseEntity.status(HttpStatus.OK).body(beautyProductsDTO);
    }

    @GetMapping("/findByBrand/{brand}")
    public ResponseEntity findBeautyProductsByBrand(@PathVariable String brand){
        List<BeautyProducts> beautyProducts = beautyProductsService.findBeautyProductsByBrand(brand);
        List<BeautyProductsDTO> beautyProductsDTO = beautyProducts.stream().map(beautyProducts1 ->
                modelMapper.map(beautyProducts1, BeautyProductsDTO.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(beautyProductsDTO);
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity findBeautyProductsByName(@PathVariable String name){
       /* List<BeautyProducts> beautyProducts = beautyProductsService.findBeautyProductsByNameProduct(name);
        List<BeautyProductsDTO> beautyProductsDTO = beautyProducts.stream().map(beautyProducts1 ->
                modelMapper.map(beautyProducts, BeautyProductsDTO.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(beautyProductsDTO);*/

       /* List<BeautyProducts> beautyProducts = beautyProductsService.findBeautyProductsByNameProduct(name);
        BeautyProductsDTO beautyProductsDTO = modelMapper.map(beautyProducts, BeautyProductsDTO.class);
        return ResponseEntity.status(HttpStatus.OK).body(beautyProductsDTO);*/

        List<BeautyProducts> beautyProducts = beautyProductsService.findBeautyProductsByNameProduct(name);
        List<BeautyProductsDTO> beautyProductsDTO = beautyProducts.stream().map(beautyProducts1 -> modelMapper.map(beautyProducts1, BeautyProductsDTO.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(beautyProductsDTO);
    }

    @GetMapping("/findByCategory/{category}")
    public ResponseEntity findBeautyProductsByCategory(@PathVariable String category){
        List<BeautyProducts> beautyProducts = beautyProductsService.findBeautyProductsByCategory(category);
        List<BeautyProductsDTO> beautyProductsDTO = beautyProducts.stream().map(beautyProducts1 -> modelMapper.map(beautyProducts1, BeautyProductsDTO.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(beautyProductsDTO);
    }

    @DeleteMapping("/delete")
    public BeautyProductsDTO deleteBeautyProducts(@RequestBody BeautyProducts beautyProducts){
        BeautyProducts beautyProducts1 = beautyProductsService.deleteBeautyProducts(beautyProducts);
        BeautyProductsDTO beautyProductsDTO = modelMapper.map(beautyProducts1, BeautyProductsDTO.class);

        return beautyProductsDTO;
    }

    @DeleteMapping("/deleteById/{id}")
    public BeautyProductsDTO deleteBeautyProductsById(@PathVariable Long id){
        Optional<BeautyProducts> beautyProducts1 = beautyProductsService.findBeautyProductsById(beautyProductsService.deleteBeautyProductsById(id));
        BeautyProductsDTO beautyProductsDTO = modelMapper.map(beautyProducts1, BeautyProductsDTO.class);

        return beautyProductsDTO;
    }

    @PutMapping("/updatePrice/{price}")
    public BeautyProductsDTO updateBeautyProductsPrice(@RequestBody BeautyProducts beautyProducts, @PathVariable Float price){
        BeautyProducts beautyProducts1 = beautyProductsService.updateBeautyProductsPrice(beautyProducts, price);
        BeautyProductsDTO beautyProductsDTO = modelMapper.map(beautyProducts1, BeautyProductsDTO.class);
        return beautyProductsDTO;
    }

    @PutMapping("/updateQuantity/{id}")
    public BeautyProductsDTO updateBeautyProductQuantity(@RequestBody BeautyProducts beautyProducts, @PathVariable int quantity){
        BeautyProducts beautyProducts1 = beautyProductsService.updateBeautyProductsQuantity(beautyProducts, quantity);
        BeautyProductsDTO beautyProductsDTO = modelMapper.map(beautyProducts1, BeautyProductsDTO.class);
        return beautyProductsDTO;
    }

    @PutMapping("/updatePriceById")
    public BeautyProductsDTO updateBeautyProductsPriceById(@RequestParam Long id , @RequestParam Float price){
        BeautyProducts beautyProducts1 = beautyProductsService.updateBeautyProductsPriceById(id, price);
        BeautyProductsDTO beautyProductsDTO = modelMapper.map(beautyProducts1, BeautyProductsDTO.class);
        return beautyProductsDTO;
    }

    @PutMapping("/updateQuantityById")
    public BeautyProductsDTO updateBeautyProductsQuantityById(@RequestParam Long id, @RequestParam int quantity){
        BeautyProducts beautyProducts1 = beautyProductsService.updateBeautyProductsQuantityById(id, quantity);
        BeautyProductsDTO beautyProductsDTO = modelMapper.map(beautyProducts1, BeautyProductsDTO.class);
        return beautyProductsDTO;
    }

    @PutMapping("/create")
    public BeautyProductsDTO createBeautyProducts(@RequestParam String nameProduct,@RequestParam String brand,
                                                @RequestParam int quantity, @RequestParam float price, @RequestParam String img, @RequestParam String category) throws MessagingException {
        /*BeautyProducts beautyProducts1 = beautyProductsService.createBeautyProducts(beautyProducts);
        BeautyProductsDTO beautyProductsDTO = modelMapper.map(beautyProducts1, BeautyProductsDTO.class);
        return beautyProductsDTO;*/
    BeautyProducts b= new BeautyProducts();
    b.setNameProduct(nameProduct);
    b.setBrand(brand);
    b.setQuantity(quantity);
    b.setPrice(price);
    b.setImg(img);
    b.setCategory(category);
    BeautyProducts beautyProducts= beautyProductsService.createBeautyProducts(b);
    BeautyProductsDTO beautyProductsDTO= modelMapper.map(beautyProducts,BeautyProductsDTO.class);
    return beautyProductsDTO;
    }
    @GetMapping("/findByIncreasingPrice")
    public List<BeautyProductsDTO> findByIncreasingPrice(){
      return beautyProductsService.findByIncreasingPrice();
    }

    @GetMapping("/findByAscBrand")
    public List<BeautyProductsDTO> findByAscBrand(){
      return beautyProductsService.findByAscBrand();
    }
}