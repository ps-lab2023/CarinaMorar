package com.beautyProducts.beautyProducts;

import com.beautyProducts.beautyProducts.model.Admin;
import com.beautyProducts.beautyProducts.model.BeautyProducts;
import com.beautyProducts.beautyProducts.model.Orders;
import com.beautyProducts.beautyProducts.model.User;
import com.beautyProducts.beautyProducts.repository.AdminRepository;
import com.beautyProducts.beautyProducts.repository.BeautyProductsRepository;
import com.beautyProducts.beautyProducts.repository.OrdersRepository;
import com.beautyProducts.beautyProducts.repository.UserRepository;
import com.beautyProducts.beautyProducts.service.AdminService;
import com.beautyProducts.beautyProducts.service.BeautyProductsService;
import com.beautyProducts.beautyProducts.service.OrdersService;
import com.beautyProducts.beautyProducts.service.ServiceImplementation.AdminServiceImplementation;
import com.beautyProducts.beautyProducts.service.ServiceImplementation.BeautyProductsServiceImplementation;
import com.beautyProducts.beautyProducts.service.ServiceImplementation.OrdersServiceImplementation;
import com.beautyProducts.beautyProducts.service.ServiceImplementation.UserServiceImplementation;
import com.beautyProducts.beautyProducts.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@SpringBootApplication
@EnableJpaRepositories
@ComponentScan({"com.beautyProducts"})
@EnableWebMvc
public class BeautyProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeautyProductsApplication.class, args);
	}

	@Bean
	CommandLineRunner init (AdminRepository adminRepository, UserRepository userRepository, BeautyProductsRepository beautyProductsRepository, OrdersRepository orderRepository) {
		return args -> {

			AdminService adminService = new AdminServiceImplementation(adminRepository, beautyProductsRepository, userRepository, orderRepository);
			UserService userService=new UserServiceImplementation(userRepository);
			OrdersService orderService=new OrdersServiceImplementation();
			BeautyProductsService beautyProductsService=new BeautyProductsServiceImplementation();

			//BD Admin
			User admin = new User();
			admin.setUsername("carina.morar");
			admin.setEmail("carina@gmail.com");
			admin.setFirstName("Carina");
			admin.setLastName("Morar");
			admin.setPassword("password");
			admin.setIsAdmin(true);
			admin.setLogged(false);
			userRepository.save(admin);

			/*Admin admin2 = new Admin();
			admin2.setAdminName("carina.morar2");
			admin2.setEmail("carina2@gmail.com");
			admin2.setFirstName("Carina2");
			admin2.setLastName("Morar2");
			admin2.setPassword("password2");*/

			//adminRepository.save(admin2);

			Admin admin3 = new Admin(null,"carina.morar3","carina3@gmail.com","pass","Carina3","Morar3");


			//Bd Beauty
			BeautyProducts product1 = new BeautyProducts();
			product1.setNameProduct("La Vie Est Belle");
			product1.setBrand("Lancome");
			product1.setPrice(650);
			product1.setQuantity(32);
			product1.setImg("/assets/images/La Vie Est Belle.jpg");
			product1.setCategory("Woman Perfume");
			beautyProductsRepository.save(product1);

			BeautyProducts product2 = new BeautyProducts();
			product2.setNameProduct("L'Interdit");
			product2.setBrand("Givenchy");
			product2.setPrice(569);
			product2.setQuantity(20);
			product2.setImg("/assets/images/L'Interdit.jpg");
			product2.setCategory("Woman Perfume");
			beautyProductsRepository.save(product2);

			BeautyProducts product3 = new BeautyProducts();
			product3.setNameProduct("The Scent For Her");
			product3.setBrand("Hugo Boss");
			product3.setPrice(270);
			product3.setQuantity(18);
			product3.setImg("/assets/images/The Scent For Her.jpg");
			product3.setCategory("Woman Perfume");
			beautyProductsRepository.save(product3);

			BeautyProducts product4 = new BeautyProducts();
			product4.setNameProduct("Good Girl");
			product4.setBrand("Carolina Herrera");
			product4.setPrice(657);
			product4.setQuantity(54);
			product4.setImg("/assets/images/Good Girl.jpg");
			product4.setCategory("Woman Perfume");
			beautyProductsRepository.save(product4);

			BeautyProducts product5 = new BeautyProducts();
			product5.setNameProduct("Lady Million");
			product5.setBrand("Paco Rabanne");
			product5.setPrice(300);
			product5.setQuantity(34);
			product5.setImg("/assets/images/Lady Million.jpg");
			product5.setCategory("Woman Perfume");
			beautyProductsRepository.save(product5);

			BeautyProducts product6 = new BeautyProducts();
			product6.setNameProduct("Savage");
			product6.setBrand("Dior");
			product6.setPrice(452);
			product6.setQuantity(35);
			product6.setImg("/assets/images/Savage.png");
			product6.setCategory("Man Perfume");
			beautyProductsRepository.save(product6);

			BeautyProducts product7 = new BeautyProducts();
			product7.setNameProduct("Stronger with YOU");
			product7.setBrand("Armani");
			product7.setPrice(333);
			product7.setQuantity(22);
			product7.setImg("/assets/images/Stronger with you.jpg");
			product7.setCategory("Man Perfume");
			beautyProductsRepository.save(product7);

			BeautyProducts product8 = new BeautyProducts();
			product8.setNameProduct("Versace Eros");
			product8.setBrand("Versace");
			product8.setPrice(444);
			product8.setQuantity(66);
			product8.setImg("/assets/images/Versace Eros.jpg");
			product8.setCategory("Man Perfume");
			beautyProductsRepository.save(product8);

			//Bd User
			User user1 = new User();
			user1.setEmail("ana.banana@gmail.com");
			user1.setPassword("password");
			user1.setFirstName("Ana");
			user1.setLastName("Banana");
			user1.setUsername("ana.banana");
			user1.setOrders(null);
			user1.setIsAdmin(false);
			user1.setLogged(false);
			userRepository.save(user1);

			User user2 = new User();
			user2.setEmail("alina.maslina@gmail.com");
			user2.setPassword("password");
			user2.setFirstName("Alina");
			user2.setLastName("Maslina");
			user2.setUsername("alina.maslina");
			user2.setIsAdmin(false);
			user2.setOrders(null);
			user2.setLogged(false);
			userRepository.save(user2);

			List<BeautyProducts> beautyProductsList1 = new ArrayList<>();
			beautyProductsList1.add(product1);
			beautyProductsList1.add(product2);
			beautyProductsList1.add(product3);
			/*ArrayList<BeautyProducts> b=new ArrayList<>();
			b= (ArrayList<BeautyProducts>) beautyProductsRepository.findAll();
			for(BeautyProducts a:b)
				System.out.println(a.getNameProduct());*/

			List<Orders> ordersList = new ArrayList<>();
			//ordersList.add()

			User user3 = new User();
			user3.setEmail("dana.lana@gmail.com");
			user3.setPassword("password");
			user3.setFirstName("Dana");
			user3.setLastName("Lana");
			user3.setUsername("dana.lana");
			user3.setOrders(ordersList);
			user3.setIsAdmin(false);
			user3.setLogged(false);
			userRepository.save(user3);


			Orders orders1 = new Orders();
			orders1.setId(1L);
			orders1.setQuantity(12);
			orders1.setPrice(1000);
			orders1.setBeautyProductsCart(null);
			orders1.setUser(user3);
			log.info(String.valueOf(orders1));
			orderRepository.save(orders1);



			//Testare metode admin
			//System.out.println(adminService.findAllAdmins()); //ok
			//System.out.println(adminService.findAdminById(2L)); //ok
			//System.out.println(adminService.deleteAdmin(admin)); //ok
			//System.out.println(adminService.findAdminByName("carina.morar")); //ok
			//System.out.println(adminService.deleteByIdAdmin(2l)); //ok
			//System.out.println(adminService.createAdmin(admin3)); //ok
			//System.out.println(adminService.updateAdminName(admin,"aaa")); //ok
			//System.out.println(adminService.updateAdminEmail(admin,"bbb")); //ok
			//System.out.println(adminService.updateAdminFirstName(admin,"ccc")); //ok
			//System.out.println(adminService.updateAdminLastName(admin,"ddd")); //ok
			//System.out.println(adminService.updateAdminPass(admin,"llalala")); //ok

			/*try
			{
				System.out.println(adminService.logIn(admin,"password", "carina@gmail.com"));
			}catch (Exception e){
				e.printStackTrace();
			}*/

		};

	}
}
