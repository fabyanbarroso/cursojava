package com.fbf.quizback.controller;

import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fbf.quizback.component.mapper.dificult.DificultMapper;
import com.fbf.quizback.dto.DificultDTO;
import com.fbf.quizback.model.Dificult;
import com.fbf.quizback.service.DificultService;

@RestController
@RequestMapping(value = "/dificult")
public class DificultController {
	
	@Autowired
	DificultService dificultService;
	
	@Autowired
	DificultMapper dificultMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public Set<DificultDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final Set<Dificult> dificult = dificultService.findAll(PageRequest.of(page, size));
		return dificultMapper.modelToDto(dificult);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public DificultDTO findById(@PathVariable("id") Integer id) {
		final Optional<Dificult> dificult = dificultService.findById(id);
		return dificultMapper.modelToDto(dificult.get());
	}

	@RequestMapping(method = RequestMethod.POST)
	public DificultDTO create(@RequestBody DificultDTO dto) {
		final Dificult dificult = dificultMapper.dtoToModel(dto);
		final Dificult createdificult = dificultService.create(dificult);
		return dificultMapper.modelToDto(createdificult);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("id") Integer id, @RequestBody DificultDTO dto) {
		final Optional<Dificult> dificult = dificultService.findById(id);
		Dificult dificultEdit = dificultMapper.dtoToModel(dto);
		dificult.get().setDificult(dificultEdit.getDificult());
		dificultService.update(dificult.get());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		final Optional<Dificult> dificult = dificultService.findById(id);
		dificultService.delete(dificult.get());
	}
	
}
