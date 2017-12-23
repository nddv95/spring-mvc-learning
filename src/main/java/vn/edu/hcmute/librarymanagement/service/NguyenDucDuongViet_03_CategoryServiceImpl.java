/**
 * 
 */
package vn.edu.hcmute.librarymanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.hcmute.librarymanagement.dao.NguyenDucDuongViet_03_CategoryDAO;
import vn.edu.hcmute.librarymanagement.dto.book.NguyenDucDuongViet_03_CategoryDTO;
import vn.edu.hcmute.librarymanagement.model.NguyenDucDuongViet_03_Category;

/**
 * @author Nguyen Duc Duong Viet
 *
 *         Dec 13, 2016
 * 
 *         Implement CategoryService interface
 * 
 */

@Service
public class NguyenDucDuongViet_03_CategoryServiceImpl implements NguyenDucDuongViet_03_CategoryService {

	/**
	 * categoryDAO chứa các hàm truy cập csdl bảng category
	 */
	@Autowired
	private NguyenDucDuongViet_03_CategoryDAO categoryDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.edu.hcmute.librarymanagement.service.
	 * NguyenDucDuongViet_03_CategoryService#findAll()
	 */
	@Override
	public List<NguyenDucDuongViet_03_CategoryDTO> findAll() {
		List<NguyenDucDuongViet_03_CategoryDTO> lstCategoryDTO = new ArrayList<NguyenDucDuongViet_03_CategoryDTO>();
		List<NguyenDucDuongViet_03_Category> lstCategory = categoryDAO.findAll();
		for (NguyenDucDuongViet_03_Category category : lstCategory) {
			NguyenDucDuongViet_03_CategoryDTO categoryDTO = new NguyenDucDuongViet_03_CategoryDTO();
			categoryDTO.setId(category.getId());
			categoryDTO.setCategoryName(category.getCategoryName());
			lstCategoryDTO.add(categoryDTO);
		}
		return lstCategoryDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.edu.hcmute.librarymanagement.service.
	 * NguyenDucDuongViet_03_CategoryService#findById(int)
	 */
	@Override
	public NguyenDucDuongViet_03_CategoryDTO findById(int id) {
		NguyenDucDuongViet_03_CategoryDTO categoryDTO = new NguyenDucDuongViet_03_CategoryDTO();
		NguyenDucDuongViet_03_Category category = categoryDAO.findById(id);
		categoryDTO.setId(category.getId());
		categoryDTO.setCategoryName(category.getCategoryName());
		return categoryDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.edu.hcmute.librarymanagement.service.
	 * NguyenDucDuongViet_03_CategoryService#saveOrUpdate(vn.edu.hcmute.
	 * librarymanagement.dto.book.NguyenDucDuongViet_03_CategoryDTO)
	 */
	@Override
	public boolean saveOrUpdate(NguyenDucDuongViet_03_CategoryDTO category) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.edu.hcmute.librarymanagement.service.
	 * NguyenDucDuongViet_03_CategoryService#delete(int)
	 */
	@Override
	public boolean delete(int category_id) {
		NguyenDucDuongViet_03_Category category = categoryDAO.findById(category_id);
		return categoryDAO.delete(category);
	}

}
