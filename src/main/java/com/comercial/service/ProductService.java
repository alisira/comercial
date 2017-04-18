package com.comercial.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.comercial.model.Category;
import com.comercial.model.Products;
import com.comercial.model.QProducts;
import com.comercial.repository.ProductRepository;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service("ProductService")
@Transactional
public class ProductService implements ProductRepository  {
	
	@Autowired
	private ProductRepository productsRepository;

	@Override
	public Products save(Products entity) {
		Products entityFinal = null;
		if (entity.getIdProduct() != null){
			Products product = productsRepository.findOne(entity.getIdProduct());
			if (product != null){
	        	String[] nullPropertyNames = ServiceUtil.getNullPropertyNames(entity);
	            ServiceUtil.copyProperties(entity, product, nullPropertyNames);
	            entityFinal =  product;
	        }else{	        	
	        	entityFinal =  entity;
	        }
			
		}else{
			entityFinal =  entity;	
		}
		
		return productsRepository.save(entityFinal);
	}

	@Override
	public <S extends Products> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Products findOne(Long id) {
		return productsRepository.findOne(id);
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Products> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Products> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {		
		return productsRepository.count();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Products entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Products> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Products findOne(Predicate predicate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Products> findAll(Predicate predicate, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Iterable<Products> findAll(Predicate predicate, OrderSpecifier<?>... orders) {		
		return null;
	}

	@Override
	public Iterable<Products> findAll(OrderSpecifier<?>... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Predicate predicate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Products findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Products> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Products> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> findAllByCustomProduct(Products pro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> findAllByCustomProduct(Products pro, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> findAll(String name, Pageable p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Products> findAll(Predicate predicate) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Page<Products> findAll(@RequestParam Map<String,String> requestParams, Pageable page) {
		return productsRepository.findAll(criteryConstructor(requestParams), page);
	}
	
	public Page<Products> findAll(@RequestParam Map<String,String> requestParams) {
		return productsRepository.findAll(criteryConstructorFromChar(requestParams), pageConstructor(requestParams));
	}
	
	@Override
	public Page<Products> findAll(Predicate predicate, Pageable p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count(Predicate predicate) {
		return productsRepository.count(predicate);
	}
	
	public long count(@RequestParam Map<String,String> requestParams) {
		return productsRepository.count(criteryConstructor(requestParams));
	}

	private BooleanExpression criteryConstructor(Map<String,String> requestParams){
    	
    	QProducts qpro = QProducts.products;
		BooleanExpression criterioFinal = null;
		int con = 0;
		Iterator it = requestParams.entrySet().iterator();
		while (it.hasNext()) {
	        Map.Entry e = (Map.Entry)it.next();
	        //System.out.println(e.getKey() + "=" + e.getValue());
	        
	        BooleanExpression criterio = null;
	        if (e.getKey().equals("name")){
	        	criterio = qpro.products.name.likeIgnoreCase("%" + (String)e.getValue() + "%");
	        }
	        
	        if (e.getKey().equals("description")){
	        	criterio = qpro.products.description.likeIgnoreCase("%" + (String)e.getValue() + "%");
	        }
	        
	        if (e.getKey().equals("idCategory")){
	        	Category cat = new Category();
	    		cat.setIdCategory(Integer.parseInt(e.getValue().toString()));	        	
	        	criterio = qpro.products.idCategory.eq(cat);
	        }
	        
	        if (e.getKey().equals("code")){
	        	criterio = qpro.products.code.likeIgnoreCase("%" + (String)e.getValue() + "%");
	        }	        
	        
	        if (criterio != null){
	        	if (con == 0){
	        		criterioFinal = criterio;	
	        	}else{
	        		if (criterioFinal != null){
	        			criterioFinal = criterioFinal.and(criterio);
	        		}else{
	        			criterioFinal = criterio;
	        		}
	        	}
	        }
	        con++;
	    }
    	
		return criterioFinal;
    	
    }
	
	
	private BooleanExpression criteryConstructorFromChar(Map<String,String> requestParams){
		
    	Iterator it = requestParams.entrySet().iterator();    	
    	String[] xy =  new String[requestParams.size()];
    	
    	//insert ?0=p&1=a&10=P&11=a&12=g&13=e&14=%3D&15=1&16=0&17=%26 into a array
    	while (it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
	        xy[Integer.parseInt(e.getKey().toString())] = e.getValue().toString();
		}
    	
    	//convert xy into string page=1&perPage=10&code=a&conect=or&description=a&conect=or&name=a&
    	String strQuery = "";
	    for (int i=0; i < xy.length;i++){
	    	strQuery  += xy[i];
	    }	    
	        	
	    String[] arrayParam =  strQuery.split("&");
	    
	    
    	QProducts qpro = QProducts.products;
		BooleanExpression criterioFinal = null;
		String conectTemp = null;
	    
	    for (int i=0; i < arrayParam.length;i++){	    		    	
	    	String[] obj =  arrayParam[i].split("=");
	    	
	        BooleanExpression criterio = null;
	        if (obj[0].toString().equals("name")){
	        	if (obj.length > 1 && obj[1].toString().length() > 0){
	        		criterio = qpro.products.name.likeIgnoreCase("%" + obj[1].toString() + "%");
	        	}
	        }
	        
	        if (obj[0].toString().equals("description")){
	        	if (obj.length > 1 && obj[1].toString().length() > 0){
	        		criterio = qpro.products.description.likeIgnoreCase("%" + obj[1].toString() + "%");
	        	}	
	        }
	        
	        if (obj[0].toString().equals("idCategory")){
	        	if (obj.length > 1 && obj[1].toString().length() > 0){
	        		Category cat = new Category();
		    		cat.setIdCategory(Integer.parseInt(obj[1].toString()));	        	
		        	criterio = qpro.products.idCategory.eq(cat);	
	        	}
	        }
	        
	        if (obj[0].toString().equals("code")){
	        	if (obj.length > 1 && obj[1].toString().length() > 0){
	        		criterio = qpro.products.code.likeIgnoreCase("%" + obj[1].toString() + "%");
	        	}
	        }
	        
	        if (criterio != null && i >= 0 && criterioFinal == null){
	        	criterioFinal = criterio;
	        }
	        
	        //System.out.println(e.getKey().toString() + " - " + e.getKey().toString().indexOf("conect"));
	        if (obj[0].toString().indexOf("conect") > -1){
				if ("or".equals(obj[1].toString())){
	        		conectTemp = "or";
	        	}else{
	        		conectTemp = "and";
	        	}
	        }
	        
	        if (criterio != null && conectTemp != null){
	        	
	        	if ("or".equals(conectTemp)){
	        		criterioFinal = criterioFinal.or(criterio);
	        	}else{
	        		criterioFinal = criterioFinal.and(criterio);
	        	}
	        	
	        	conectTemp = null;
	        	
	        }	    	
	    	
	    }
    	
		return criterioFinal;
    	
    }
	
	private Pageable pageConstructor(Map<String,String> requestParams){
		
    	Iterator it = requestParams.entrySet().iterator();
    	//List<String> xx =  new ArrayList<String>();    	
    	String[] xy =  new String[requestParams.size()];
    	
    	//insert ?0=p&1=a&10=P&11=a&12=g&13=e&14=%3D&15=1&16=0&17=%26 into a array
    	while (it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
	        xy[Integer.parseInt(e.getKey().toString())] = e.getValue().toString();
		}
    	
    	//convert xy into string page=1&perPage=10&code=a&conect=or&description=a&conect=or&name=a&
    	String strQuery = "";
	    for (int i=0; i < xy.length;i++){
	    	strQuery  += xy[i];
	    }	    
    	
	    String[] arrayParam =  strQuery.split("&");

	    int page= -1;
	    int perPage= -1;
	    for (int i=0; i < arrayParam.length;i++){
	    	
	    	String[] obj =  arrayParam[i].split("=");
	        
	        BooleanExpression criterio = null;
	        if (obj[0].toString().equals("page")){
	        	page =  Integer.parseInt(obj[1].toString())-1;
	        }

	        if (obj[0].toString().equals("perPage")){
	        	perPage =  Integer.parseInt(obj[1].toString());
	        }	        	    	
	    	
	    }
	    
	    if (page == -1){
	    	page = 1;
	    }
	    
	    if (perPage <= 0){
	    	perPage = 10;
	    }
		
	    return new PageRequest(page, perPage, new Sort(Sort.Direction.ASC, "idProduct").and(new Sort(Sort.Direction.DESC, "name")));
		
	}

}


