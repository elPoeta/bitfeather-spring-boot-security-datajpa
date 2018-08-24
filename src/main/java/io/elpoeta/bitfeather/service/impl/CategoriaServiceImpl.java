
package io.elpoeta.bitfeather.service.impl;

import io.elpoeta.bitfeather.domain.Categoria;
import io.elpoeta.bitfeather.repository.CategoriaRepository;
import io.elpoeta.bitfeather.service.CategoriaService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author elpoeta
 */
@Service
@Transactional
public class CategoriaServiceImpl implements CategoriaService{
    private final CategoriaRepository catgoriaRepository;
	
	public CategoriaServiceImpl(CategoriaRepository catgoriaRepository) {
		this.catgoriaRepository = catgoriaRepository;
	}

	@Override
	public Categoria buscarCategoriaPorId(Integer id) {
	
		return this.catgoriaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Categoria> buscarTodas() {
		
		return this.catgoriaRepository.findAll();
	}
}
