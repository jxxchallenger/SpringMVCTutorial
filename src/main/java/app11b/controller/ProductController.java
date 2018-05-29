package app11b.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import app11b.domain.Product;

@Controller(value="productController11b")
@RequestMapping("/app11b")
public class ProductController {

	@RequestMapping("/product_input")
	public String inputProduct(Model model){
		model.addAttribute("product", new Product());
		return "app11b/ProductForm";
	}
	
	@RequestMapping(value="/product_save", method=RequestMethod.POST)
	public String saveProduct(HttpServletRequest request, @Valid Product product, BindingResult bindingResult, Model model){
		
		if(bindingResult.hasErrors()){
			return "app11b/ProductForm";
		}
		
		List<MultipartFile> files = product.getImages();
		List<String> fileNames = new ArrayList<String>();
		if(null != files && files.size() > 0){
			for(MultipartFile multipartFile:files){
				String fileName = multipartFile.getOriginalFilename();
				fileNames.add(fileName);
				
				File imageFile = new File(request.getServletContext().getRealPath("/image"), fileName);
				
				try {
					multipartFile.transferTo(imageFile);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		model.addAttribute("product", product);
		return "app11b/ProductDetails";
	}
}
