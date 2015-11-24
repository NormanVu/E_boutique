package net.youssfi.eboutique.controllers;

import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.youssfi.eboutique.entities.Categorie;
import net.youssfi.eboutique.metier.IAdminCategoriesMetier;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/adminCat")
@SessionAttributes("editedCat")
public class AdminCategoriesController implements HandlerExceptionResolver{
	@Autowired
	private IAdminCategoriesMetier metier;

	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());
		return "categories";
	}

	@RequestMapping("/saveCat")
	public String saveCat(@Valid Categorie c, BindingResult bindingResult,
			Model model, MultipartFile file) throws Exception {
		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", metier.listCategories());
			return "categories";
		}
		if (!file.isEmpty()) {
			c.setPhoto(file.getBytes());
			c.setNomPhoto(file.getOriginalFilename());
		} else {
			if (c.getIdCategorie() != null) {
				Categorie cat = (Categorie) model.asMap().get("editedCat");
				c.setPhoto(cat.getPhoto());
			}
		}
		if (c.getIdCategorie() == null)
			metier.ajouterCategorie(c);
		else
			metier.modifierCategorie(c);
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());
		return "categories";
	}

	@RequestMapping(value = "/photoCat", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(Long idCat) throws IOException {
		Categorie c = metier.getCategorie(idCat);
		if (c.getPhoto() == null)
			return new byte[0];
		else
			return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
	}

	@RequestMapping(value = "/suppCat")
	public String suppCat(Long idCat, Model model) {
		metier.supprimerCategrorie(idCat);
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());
		return "categories";
	}

	@RequestMapping(value = "/editCat")
	public String editCat(Long idCat, Model model) {
		Categorie c = metier.getCategorie(idCat);
		model.addAttribute("editedCat", c);
		model.addAttribute("categorie", c);
		model.addAttribute("categories", metier.listCategories());
		return "categories";
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest req,
			HttpServletResponse resp, Object arg2, Exception ex) {
		// TODO Auto-generated method stub
		ModelAndView mv=new ModelAndView();
		mv.addObject("categorie", new Categorie());
		mv.addObject("categories", metier.listCategories());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("categories");
		return mv;
	}
}