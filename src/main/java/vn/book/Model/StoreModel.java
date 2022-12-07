package vn.book.Model;

import java.util.Date;


import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreModel {
	private Long storeId;
	
	private String storeName;
	
	private String description;
	
	private Long ownerId;
	
	private String avatar;
	private MultipartFile avatarFile;
	private boolean isActive;
	
	private boolean isOpen;
	
	private Date createAt;
	
	private Date updateAt;
	private Boolean isEdit = false;
}
