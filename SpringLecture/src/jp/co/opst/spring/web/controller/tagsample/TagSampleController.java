package jp.co.opst.spring.web.controller.tagsample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TagSampleController {

	@RequestMapping(value = "/executeTagSample", method = RequestMethod.POST)
	public ModelAndView execute(@ModelAttribute TagSampleModel tagSampleModel) {
	//public ModelAndView execute() {
		System.out.println("TagSampleController#execute()");
		return new ModelAndView("tagsampleResult", "tagSampleModel", tagSampleModel);
		//return new ModelAndView("tagsampleResult", "tagSampleModel", null);
	}

	@RequestMapping(value = "/tagSample")
	public String form(Model model) {
		System.out.println("TagSampleController#form()");
		TagSampleModel tagSampleModel = new TagSampleModel();
		tagSampleModel.setLunch(true);
		tagSampleModel.setBreakfast(true);
		model.addAttribute("tagSampleModel", tagSampleModel);
		return "tagsample";
	}

}
