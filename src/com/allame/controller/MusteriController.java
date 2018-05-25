package com.allame.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.allame.model.Musteri;
import com.allame.repository.MusteriDaoImpl;
import com.allame.service.MusteriService;

	
@Controller
public class MusteriController {


	@Autowired
//@Inject
	private MusteriService musteriService;
	
	@RequestMapping(value = "/newMusteri",method = RequestMethod.GET)
	public ModelAndView getir(@ModelAttribute Musteri musteri){
	
		return new ModelAndView("musteriForm");
	}
	
	@RequestMapping(value="editMusteri", method=RequestMethod.GET)
	public ModelAndView updateMusteri(@RequestParam long musteriId,@ModelAttribute Musteri musteri)
	{	
		musteri = musteriService.findMusteri(musteriId);
		return new ModelAndView("musteriForm","musteriObject",musteri);
	}
	
	@RequestMapping(value = "saveMusteri",method = RequestMethod.POST)
	public ModelAndView saveMusteri(@ModelAttribute Musteri musteri)
	{
		if(musteri.getMusteriId() == 0)
		{
			musteriService.createMusteri(musteri);
		}else{
			musteriService.updateMusteri(musteri);
		}
		return new ModelAndView("redirect:findAllMusteri");
	}//FUNC
	
	@RequestMapping(value ={"findAllMusteri","/findAllMusteri"}, method=RequestMethod.GET)
	public ModelAndView findAllMusteri()
	{
		List<Musteri> musteriList = musteriService.findAllMusteri();
		return new ModelAndView("musteriList","musteriList",musteriList);
	}
	
	@RequestMapping(value="deleteMusteri", method=RequestMethod.GET)
	public ModelAndView deleteMusteri(@RequestParam long musteriId)
	{	
		musteriService.deleteMusteri(musteriId);
		return new ModelAndView("redirect:findAllMusteri");
	}
	
	
	@RequestMapping(value="searchMusteri", method=RequestMethod.GET)
	public ModelAndView updateMusteri(@RequestParam("searchAdi") String searchAdi)
	{
		List<Musteri> musteriListBilgi = musteriService.findMusteriler(searchAdi);
		
		return new ModelAndView("musteriList","musteriList",musteriListBilgi);
	}
	
	
	/*
	@RequestMapping(value = "postMusteri", method = RequestMethod.POST)
	public ModelAndView formpost(@ModelAttribute Musteri musteri){
		
		ModelAndView ty = new ModelAndView("musteriList");
					ty.addObject("musteri", musteri);
				
					//tablo.createMusteri(musteri);
					
		return ty;
	}*/
	
	//VERILER BURDA GITMEDI REQUEST SINIFINI METHODU CAGIRIP VERILERI GETIREMEDIK KALSIN SIMDILIK
	/*@RequestMapping(value = "postMusteri" , method = RequestMethod.POST)
	public ModelAndView postMusteri(HttpServletRequest req, HttpServletResponse resp)throws Exception{
				ModelAndView vt = new ModelAndView("musteriList");
							 vt.addObject("w", req.getAttribute("musteriNo"));
							 vt.addObject("w1", req.getAttribute("musteriAdi"));
							 vt.addObject("w2",req.getAttribute("musteriSoyadi"));
				return vt;
			
	}
	*/
	
	
	
	/*
	@RequestMapping(value = "postMusteri", method = RequestMethod.POST)
	public ModelAndView formpost(@ModelAttribute Musteri musteri){
		
		ModelAndView ty = new ModelAndView("musteriList");
					ty.addObject("w", musteri.getMusteriAdi());
					ty.addObject("w1", musteri.getMusteriSoyadi());
					ty.addObject("w2", musteri.getMusteriNo());
		return ty;
	}
	*/
	
	/*
	@RequestMapping(value="postMusteri", method = RequestMethod.POST)
	public ModelAndView formpost(@RequestParam(value="musteriNo",defaultValue="musteriNO-YOK")String musteriNo,
								 @RequestParam(value="musteriAdi",defaultValue="musteriAdi-YOK")String musteriAdi,
								 @RequestParam(value="musteriSoyadi",defaultValue="musteriSoyadi-YOK")String musteriSoyadi)
	{
		
		ModelAndView ty = new ModelAndView("musteriList");
					 ty.addObject("w", musteriNo);
					 ty.addObject("w1", musteriAdi);
					 ty.addObject("w2",musteriSoyadi);
		return ty;
	}
	*/
	
	/*
	@RequestMapping(value = "createMusteri",method = RequestMethod.GET)
	public ModelAndView getPersonelForm(){
		ModelAndView viv = new ModelAndView("musteriForm");
					 viv.addObject("musteri", new Musteri());
		return viv;
	}//func
	
	*/

	
	
	
	
	
}



