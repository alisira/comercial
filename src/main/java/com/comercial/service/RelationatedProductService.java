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

import com.comercial.model.Products;
import com.comercial.model.QRelationatedProduct;
import com.comercial.model.RelationatedProduct;
import com.comercial.repository.RelationatedProductRepository;
import com.comercial.repository.ProductRepository;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service("RelationatedProductService")
@Transactional
public class RelationatedProductService  implements RelationatedProductRepository {
	
	@Autowired
	private RelationatedProductRepository relationatedProductRepository;

	
	
	public Page<RelationatedProduct> findAll(@RequestParam Map<String,String> requestParams, Pageable page) {
		return relationatedProductRepository.findAll(criteryConstructor(requestParams), pageConstructor(requestParams));
	}
	
	public Page<RelationatedProduct> findAll(@RequestParam Map<String,String> requestParams) {
		return relationatedProductRepository.findAll(criteryConstructor(requestParams), pageConstructor(requestParams));
	}
	
	public  RelationatedProductRepository save(RelationatedProductService entity) {
		
		return relationatedProductRepository;
	}

	
	public long count() {		
		return relationatedProductRepository.count();
	}
	
	private BooleanExpression criteryConstructor(Map<String,String> requestParams){
    	
    	QRelationatedProduct qRelationatedProduct = QRelationatedProduct.relationatedProduct;
		BooleanExpression criterioFinal = null;
		int con = 0;
		Iterator it = requestParams.entrySet().iterator();
		while (it.hasNext()) {
	        Map.Entry e = (Map.Entry)it.next();
	        //System.out.println(e.getKey() + "=" + e.getValue());

	        BooleanExpression criterio = null;
	        if (e.getKey().equals("idProduct")){
	        	criterio = qRelationatedProduct.idProduct.idProduct.eq((long)e.getValue());
	        }

	        if (e.getKey().equals("idProductRelation")){
	        	criterio = qRelationatedProduct.idProductRelation.eq((long)e.getValue());
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
	
	private Pageable pageConstructor(Map<String,String> requestParams){
		
	    int page= -1;
	    int perPage= -1;
		//detect type of requestParams (array or plan text)
    	boolean typeParams= false;//true=array, false=plan text

	    for (Integer i=0; i < requestParams.size();i++){	    	
	    	StringBuilder sb = new StringBuilder();
	    	sb.append(i);	    	
	    	//System.out.println(requestParams.containsKey(sb.toString()));	    	
	    	if (requestParams.containsKey(sb.toString())){
	    		typeParams = true;
	    	}
	    }
		
	    //true=array, false=plan text
	    if (typeParams){
			
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
	

		    for (int i=0; i < arrayParam.length;i++){
		    	
		    	String[] obj =  arrayParam[i].split("=");
		        
		        if (obj[0].toString().equals("page")){
		        	page =  Integer.parseInt(obj[1].toString())-1;
		        }
	
		        if (obj[0].toString().equals("perPage")){
		        	perPage =  Integer.parseInt(obj[1].toString());
		        }	        	    	
		    	
		    }
		    
		    if (page <= -1){
		    	page = 1;
		    }
		    
		    if (perPage <= 0){
		    	perPage = 10;
		    }
			
		    return new PageRequest(page, perPage, new Sort(Sort.Direction.ASC, "idProduct").and(new Sort(Sort.Direction.DESC, "idProductRelation")));
	    }else{
	    	
	    	if (requestParams.get("page").matches("^[0-9]+$") ){
	    		if (Integer.parseInt(requestParams.get("page")) <= -1){
			    	page = 1;
			    }else{
			    	page = Integer.parseInt(requestParams.get("page")); 
			    }
	    	}
	    	
	    	if (requestParams.get("perPage").matches("^[0-9]+$") ){
	    		if (Integer.parseInt(requestParams.get("perPage")) <= -1){
	    			perPage = 10;
	    		}else{
	    			perPage = Integer.parseInt(requestParams.get("perPage")); 
			    }
	    	}
	    	
	    	return new PageRequest(page-1, perPage,new Sort(Sort.Direction.ASC, "idProduct").and(new Sort(Sort.Direction.DESC, "idProductRelation")));

	    }
		
	}
	

	public void deleteByidProduct(Products products) {
		relationatedProductRepository.deleteByidProduct(products);
		
	}
	

	public void delete(Long id) {
		// TODO Auto-generated method stub
		relationatedProductRepository.delete(id);
		
	}


	public void delete(RelationatedProduct entity) {
		// TODO Auto-generated method stub
		relationatedProductRepository.delete(entity);
		
	}

	@Override
	public <S extends RelationatedProduct> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends RelationatedProduct> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RelationatedProduct findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<RelationatedProduct> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<RelationatedProduct> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Iterable<? extends RelationatedProduct> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RelationatedProduct findOne(Predicate predicate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<RelationatedProduct> findAll(Predicate predicate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<RelationatedProduct> findAll(Predicate predicate, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<RelationatedProduct> findAll(Predicate predicate, OrderSpecifier<?>... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<RelationatedProduct> findAll(OrderSpecifier<?>... orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<RelationatedProduct> findAll(Predicate predicate, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Predicate predicate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteByidRelationatedProduct(Integer idRelationatedProduct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long count(Predicate predicate) {
		return relationatedProductRepository.count(predicate);
	}

	public long count(Map<String, String> requestParams) {
		return relationatedProductRepository.count(criteryConstructor(requestParams));
	}
	

}

