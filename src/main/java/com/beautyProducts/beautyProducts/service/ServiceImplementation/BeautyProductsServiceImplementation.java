package com.beautyProducts.beautyProducts.service.ServiceImplementation;

import com.beautyProducts.beautyProducts.DTO.BeautyProductsDTO;
import com.beautyProducts.beautyProducts.model.BeautyProducts;
import com.beautyProducts.beautyProducts.BeautyProductsComparator;
import com.beautyProducts.beautyProducts.model.Orders;
import com.beautyProducts.beautyProducts.repository.BeautyProductsRepository;
import com.beautyProducts.beautyProducts.service.BeautyProductsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BeautyProductsServiceImplementation implements BeautyProductsService {
    @Autowired
    private BeautyProductsRepository beautyProductsRepository;

    @Autowired
    private ModelMapper modelMapper;
    public void BeautyProductsServiceImplementation(BeautyProductsRepository beautyProductsRepository){
        this.beautyProductsRepository = beautyProductsRepository;
    }
    @Override
    public List<BeautyProducts> findAllBeautyProducts(){
        return (List<BeautyProducts>)beautyProductsRepository.findAll();
    }
    @Override
    public Optional<BeautyProducts> findBeautyProductsById(Long id ){
        return beautyProductsRepository.findById(id);
    }

    @Override
    public List<BeautyProducts> findBeautyProductsByBrand(String brand){return beautyProductsRepository.findBeautyProductsByBrand(brand);}
    @Override
    public List<BeautyProducts> findBeautyProductsByCategory(String category){return beautyProductsRepository.findBeautyProductsByCategory(category);}
    @Override
    public List<BeautyProducts> findBeautyProductsByNameProduct(String name){return beautyProductsRepository.findBeautyProductsByNameProduct(name);}

    @Override
    public Long deleteBeautyProductsById(Long id){
        beautyProductsRepository.deleteById(id);
        return id;
    }
    @Override
    public BeautyProducts deleteBeautyProducts(BeautyProducts beautyProducts){
        beautyProductsRepository.delete(beautyProducts);
        return beautyProducts;
    }
    @Override
    public BeautyProducts createBeautyProducts(BeautyProducts beautyProducts){
        return beautyProductsRepository.save(beautyProducts);
    }
    @Override
    public BeautyProducts updateBeautyProductsName(BeautyProducts beautyProducts,String name){
        BeautyProducts existingBeautyProducts = beautyProductsRepository.findById(beautyProducts.getId()).orElse(null);
        existingBeautyProducts.setNameProduct(name);
        return beautyProductsRepository.save(existingBeautyProducts);
    }
    @Override
    public BeautyProducts updateBeautyProductsBrand(BeautyProducts beautyProducts,String brand){
        BeautyProducts existingBeautyProducts = beautyProductsRepository.findById(beautyProducts.getId()).orElse(null);
        existingBeautyProducts.setBrand(brand);
        return beautyProductsRepository.save(existingBeautyProducts);
    }
    @Override
    public BeautyProducts updateBeautyProductsPrice(BeautyProducts beautyProducts,float price){
        BeautyProducts existingBeautyProducts = beautyProductsRepository.findById(beautyProducts.getId()).orElse(null);
        existingBeautyProducts.setPrice(price);
        return beautyProductsRepository.save(existingBeautyProducts);
    }

    @Override
    public BeautyProducts updateBeautyProductsQuantity(BeautyProducts beautyProducts, int quantity){
        BeautyProducts existingBeautyProducts = beautyProductsRepository.findById(beautyProducts.getId()).orElse(null);
        existingBeautyProducts.setQuantity(quantity);
        return beautyProductsRepository.save(existingBeautyProducts);
    }
    @Override
    public BeautyProducts updateBeautyProductsPriceById(Long id,float price){
        BeautyProducts existingBeautyProducts = beautyProductsRepository.findById(id).orElse(null);
        existingBeautyProducts.setPrice(price);
        return beautyProductsRepository.save(existingBeautyProducts);
    }

    @Override
    public BeautyProducts updateBeautyProductsQuantityById(Long id, int quantity){
        BeautyProducts existingBeautyProducts = beautyProductsRepository.findById(id).orElse(null);
        existingBeautyProducts.setQuantity(quantity);
        return beautyProductsRepository.save(existingBeautyProducts);
    }

    @Override
    public BeautyProducts updateBeautyProductsClientOrder(BeautyProducts beautyProducts, Orders clientOrders){
        BeautyProducts existingBeautyProducts = beautyProductsRepository.findById(beautyProducts.getId()).orElse(null);
        existingBeautyProducts.setClientOrders(clientOrders);
        return beautyProductsRepository.save(existingBeautyProducts);
    }

    @Override
    public List<BeautyProductsDTO> findByIncreasingPrice() {
        List<BeautyProducts> a= (List<BeautyProducts>) beautyProductsRepository.findAll();
        List<BeautyProductsDTO> list=new ArrayList<>();
        Collections.sort(a);
        for(BeautyProducts b:a)
        {
            list.add( modelMapper.map(b, BeautyProductsDTO.class));
        }
   return  list;
    }

    @Override
    public List<BeautyProductsDTO> findByAscBrand() {
        List<BeautyProducts> a= (List<BeautyProducts>) beautyProductsRepository.findAll();
        List<BeautyProductsDTO> list=new ArrayList<>();
        Collections.sort(a,new BeautyProductsComparator());
        for(BeautyProducts b:a)
        {
            list.add( modelMapper.map(b, BeautyProductsDTO.class));
        }
        return  list;
    }

    /*@Override
    public BeautyProducts updateBeautyProducts(BeautyProducts beautyProducts){
        BeautyProducts existingBeautyProducts = beautyProductsRepository.findById(beautyProducts.getId()).orElse(null);
        existingBeautyProducts.setNameProduct(beautyProducts.getNameProduct());
        existingBeautyProducts.setBrand(beautyProducts.getBrand());
        existingBeautyProducts.setPrice(beautyProducts.getPrice());
        existingBeautyProducts.setId(beautyProducts.getId());
        return beautyProductsRepository.save(existingBeautyProducts);
    }*/
}