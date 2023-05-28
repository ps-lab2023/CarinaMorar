package com.beautyProducts.beautyProducts.service.ServiceImplementation;

import com.beautyProducts.beautyProducts.model.Admin;
import com.beautyProducts.beautyProducts.repository.AdminRepository;
import com.beautyProducts.beautyProducts.repository.BeautyProductsRepository;
import com.beautyProducts.beautyProducts.repository.OrdersRepository;
import com.beautyProducts.beautyProducts.repository.UserRepository;
import com.beautyProducts.beautyProducts.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImplementation implements AdminService {
    @Autowired
    private AdminRepository adminRepository;
    private BeautyProductsRepository beautyProductsRepository;
    private UserRepository userRepository;
    private OrdersRepository ordersRepository;

    public AdminServiceImplementation(AdminRepository adminRepository, BeautyProductsRepository beautyProductsRepository, UserRepository userRepository, OrdersRepository ordersRepository) {
        this.adminRepository=adminRepository;
        this.beautyProductsRepository=beautyProductsRepository;
        this.userRepository=userRepository;
        this.ordersRepository=ordersRepository;
    }

    /*
    public void AdminServiceImplementation(AdminRepository adminRepository, BeautyProductsRepository beautyProductsRepository, UserRepository userRepository, OrderRepository orderRepository)
     {

     }

     */

    @Override
    public List<Admin> findAllAdmins() {
        return (List<Admin>) adminRepository.findAll();
    }
    @Override
    public Optional<Admin> findAdminById(Long id) {
        return adminRepository.findById(id);
    }
    @Override
    public List<Admin> findAdminByName(String name){
        return adminRepository.findAdminByAdminName(name);
    }
    @Override
    public Long deleteByIdAdmin(Long id){
        adminRepository.deleteById(id);
        return id;
    }
    @Override
    public Admin deleteAdmin(Admin admin){
        adminRepository.delete(admin);
        return admin;
    }
    @Override
    public Admin createAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdminName(Admin admin, String name){
        Admin existingAdmin = adminRepository.findById(admin.getId()).orElse(null);
        existingAdmin.setAdminName(name);
        return adminRepository.save(existingAdmin);
    }
    @Override
    public Admin updateAdminFirstName(Admin admin, String name){
        Admin existingAdmin = adminRepository.findById(admin.getId()).orElse(null);
        existingAdmin.setFirstName(name);
        return adminRepository.save(existingAdmin);
    }
    @Override
    public Admin updateAdminLastName(Admin admin, String name){
        Admin existingAdmin = adminRepository.findById(admin.getId()).orElse(null);
        existingAdmin.setLastName(name);
        return adminRepository.save(existingAdmin);
    }
    @Override
    public Admin updateAdminEmail(Admin admin, String email){
        Admin existingAdmin = adminRepository.findById(admin.getId()).orElse(null);
        existingAdmin.setEmail(email);
        return adminRepository.save(existingAdmin);
    }
    @Override
    public Admin updateAdminPass(Admin admin, String pass){
        Admin existingAdmin = adminRepository.findById(admin.getId()).orElse(null);
        existingAdmin.setPassword(pass);
        return adminRepository.save(existingAdmin);
    }

    @Override
    public String logIn(Admin admin1, String password, String email)
    {
        Admin adminToLogin = adminRepository.findById(admin1.getId()).orElse(null);
        //System.out.println("aaaaaaaaaaaaaaaaaaaaa");
        if(adminToLogin == null)
            System.out.println("NAIBAAA");
        if(adminToLogin.getPassword().equals(password) && adminToLogin.getEmail().equals(email)) {
            return "Succes";
        }
        else
            return "Try Again";
    }

     /*@Override
     public Admin updateAdmin(Admin admin){
         Admin existingAdmin = adminRepository.findById(admin.getId()).orElse(null);
         existingAdmin.setAdminName(admin.getAdminName());
         existingAdmin.setFirstName(admin.getFirstName());
         existingAdmin.setLastName(admin.getLastName());
         existingAdmin.setEmail(admin.getEmail());
         existingAdmin.setPassword(admin.getPassword());
         //existingAdmin.setId(admin.getId());
         return adminRepository.save(existingAdmin);
     }*/
}